package cn.itcast.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.itcast.domain.Cart;
import cn.itcast.domain.MessagesRecord;
import cn.itcast.domain.Smmembers;
import cn.itcast.service.IAppMemberService;
import cn.itcast.util.Tools;
import cn.itcast.vo.JsonReturn;

/**
 * App注册页面
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/app/member")
public class AppMemberController {
	private final String SMS_VALID_PHONE = "smsValidPhone";
	private final String SMS_VALID = "smsValid";
	private final String SESSION_MEMBER = "sessionMembber";
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	@Autowired
	IAppMemberService appMemberService;
	
	//获取验证码
	@ResponseBody
	@RequestMapping(value = "/sendSmsValid", produces = "application/json;charset=UTF-8")
	public Object sendSmsValid(String phone, String deviceId, Boolean isRegister, HttpServletRequest request) {
		JsonReturn jsonReturn = new JsonReturn();
		if (Tools.isNotNull(phone) && phone.length() == 11) {
			if (isRegister != null && isRegister) {
				// 注册需要判断是否已经注册
				Smmembers member = this.appMemberService.findSmmembersMyPhone(phone);
				if (member != null) {
					jsonReturn.setCode(404);
					jsonReturn.setText("该手机号已经注册，请登录");
					return gson.toJson(jsonReturn);
				}
			}

			// 查询5分钟内发送到该手机号的短信条数
			List<MessagesRecord> codeRecords = this.appMemberService.getMRByPhone(phone);
			// 查询5分钟内该设备ID对应设备请求发送的短信条数
			List<MessagesRecord> codeRecords2 = this.appMemberService.getMRByIsEnabled(deviceId);
			if (codeRecords.size() < 5 && codeRecords2.size() < 5) {

				// 生成6位随机数
				int numcode = (int) ((Math.random() * 9 + 1) * 100000);
				System.out.println("SMS_VALID=   " + numcode);

				HttpSession session = request.getSession();
				session.setAttribute(SMS_VALID, String.valueOf(numcode));
				session.setAttribute(SMS_VALID_PHONE, phone);

				// 模拟调用短信接口

				// 假设发送成功后记录发送情况
				MessagesRecord codeRecord = new MessagesRecord();
				codeRecord.setPhoneNumber(phone);
				codeRecord.setDerviceUUId(deviceId);
				codeRecord.setSendTime(new Date());
				// 添加短信发送记录到数据库
				int intR = this.appMemberService.insertMessagesRecord(codeRecord);
				if (intR > 0) {
					jsonReturn.setCode(200);
					jsonReturn.setText("发送成功，请注意查收");
				} else {
					jsonReturn.setCode(300);
					jsonReturn.setText("发送失败");
				}

			} else {
				jsonReturn.setCode(500);
				jsonReturn.setText("验证短信发送太频繁，请稍后再试");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("手机号不正确");
		}
		return gson.toJson(jsonReturn);
	}
	//注册
	@ResponseBody
	@RequestMapping(value = "/register", produces = "application/json;charset=UTF-8")
	public Object register(Smmembers smmembers, String smsValidCode, HttpServletRequest request) {
		JsonReturn jsonReturn = new JsonReturn();

		if (Tools.isNotNull(smmembers.getPhoneNumber()) && Tools.isNotNull(smmembers.getUPassword())
				&& Tools.isNotNull(smmembers.getMemberName()) && Tools.isNotNull(smmembers.getMemberAddress())) {
			// 获取session中的验证码和手机号
			HttpSession session = request.getSession();
			String sessionValidCode = (String) session.getAttribute(SMS_VALID);
			String sessionValidPhone = (String) session.getAttribute(SMS_VALID_PHONE);
			//会员卡号
			Integer memberid = this.appMemberService.selectMemberId();
			// 验证手机号和短信验证码
			if (smsValidCode.equals(sessionValidCode) && smmembers.getPhoneNumber().trim().equals(sessionValidPhone)) {
				smmembers.setMemberId(memberid*1+1);
				smmembers.setOpenTime(new Date());// 注册时间
				smmembers.setMemberStatus(1);//会员卡状态
				// 添加一个新用户
				Integer intR = this.appMemberService.insertSmmembers(smmembers);
				if (intR > 0) {
					Smmembers memberVo = this.appMemberService.findSmmembersMyPhone(smmembers.getPhoneNumber().trim());
					if (memberVo != null) {
						// 将memberVo放入session
						session.setAttribute(SESSION_MEMBER, memberVo);

						jsonReturn.setCode(200);
						jsonReturn.setText("注册成功");
						jsonReturn.setData(memberVo);
					} else {
						jsonReturn.setCode(300);
						jsonReturn.setText("注册失败");
					}
				} else {
					jsonReturn.setCode(501);
					jsonReturn.setText("添加新用户失败");
				}
			} else {
				jsonReturn.setCode(502);
				jsonReturn.setText("验证码不正确");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("数据异常");
		}

		return gson.toJson(jsonReturn);
	}
	/**
	 * 短信验证码登录
	 * @param phone
	 * @param smsValidCode
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginBySms", produces = "application/json;charset=UTF-8")
	public Object loginBySms(String phone, String smsValidCode, HttpServletRequest request) {
		JsonReturn jsonReturn = new JsonReturn();

		if (Tools.isNotNull(phone) && Tools.isNotNull(smsValidCode)) {
			Smmembers smmembers = this.appMemberService.findSmmembersMyPhone(phone);
			if (smmembers != null) {
				// 获取session中的验证码和手机号
				HttpSession session = request.getSession();
				String sessionValidCode = (String) session.getAttribute(SMS_VALID);
				String sessionValidPhone = (String) session.getAttribute(SMS_VALID_PHONE);
				if (smsValidCode.equals(sessionValidCode) && phone.equals(sessionValidPhone)) {
					// 登录成功
					// 将memberVo放入session
					session.setAttribute(SESSION_MEMBER, smmembers);

					jsonReturn.setCode(200);
					jsonReturn.setText("登录成功");
					jsonReturn.setData(smmembers);
				} else {
					jsonReturn.setCode(502);
					jsonReturn.setText("验证码不正确");
				}
			} else {
				jsonReturn.setCode(501);
				jsonReturn.setText("该手机号未注册");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("数据异常");
		}

		return gson.toJson(jsonReturn);
	}
	/**
	 * 密码登录
	 * @param phone
	 * @param password
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginByPassword", produces = "application/json;charset=UTF-8")
	public Object loginByPassword(String phone, String password, HttpServletRequest request) {
		JsonReturn jsonReturn = new JsonReturn();

		if (Tools.isNotNull(phone) && Tools.isNotNull(password)) {
			Smmembers smmembers = this.appMemberService.findSmmembersMyPhone(phone);
			if (smmembers != null) {
				// 验证密码
				HttpSession session = request.getSession();
				if (password.equals(smmembers.getUPassword().trim())) {
					// 登录成功
					// 将memberVo放入session
					session.setAttribute(SESSION_MEMBER, smmembers);

					jsonReturn.setCode(200);
					jsonReturn.setText("登录成功");
					jsonReturn.setData(smmembers);
				} else {
					jsonReturn.setCode(502);
					jsonReturn.setText("账号或密码不正确");
				}
			} else {
				jsonReturn.setCode(501);
				jsonReturn.setText("该手机号未注册");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("数据异常");
		}

		return gson.toJson(jsonReturn);
	}
	
	/**
	 * 忘记密码重置
	 * @param phone
	 * @param smsValidCode
	 * @param password
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetPassword", produces = "application/json;charset=UTF-8")
	public Object resetPassword(String phone, String smsValidCode, String password, HttpServletRequest request) {
		JsonReturn jsonReturn = new JsonReturn();

		if (Tools.isNotNull(phone) && Tools.isNotNull(smsValidCode) && Tools.isNotNull(password)) {
			// 获取session中的验证码和手机号
			HttpSession session = request.getSession();
			String sessionValidCode = (String) session.getAttribute(SMS_VALID);
			String sessionValidPhone = (String) session.getAttribute(SMS_VALID_PHONE);
			if (smsValidCode.equals(sessionValidCode) && phone.equals(sessionValidPhone)) {
				Smmembers smmembers = this.appMemberService.findSmmembersMyPhone(phone);
				if (smmembers != null) {
					// 修改密码
					smmembers.setUPassword(password);
					Integer intR = this.appMemberService.updateSmmembersById(smmembers);
					if (intR == 1) {
						jsonReturn.setCode(200);
						jsonReturn.setText("密码重置成功，请重新登录");
					} else {
						jsonReturn.setCode(300);
						jsonReturn.setText("密码重置失败，请稍后再试");
					}
				} else {
					jsonReturn.setCode(501);
					jsonReturn.setText("该手机号未注册");
				}
			} else {
				jsonReturn.setCode(502);
				jsonReturn.setText("验证码不正确");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("数据异常");
		}
		return gson.toJson(jsonReturn);
	}
	
	//修改登录密码
	@ResponseBody
	@RequestMapping(value = "/updatePassword", produces = "application/json;charset=UTF-8")
	public Object updatePassword(String newPassword,Integer memberId) {
		JsonReturn jsonReturn = new JsonReturn();
		if (Tools.isNotNull(newPassword) && memberId!=null) {
			Integer returnInt = this.appMemberService.updatePassword(newPassword, memberId);
			if (returnInt==1) {
				jsonReturn.setCode(200);
				jsonReturn.setText("修改成功，请重新登录");
			}else{
				jsonReturn.setCode(300);
				jsonReturn.setText("修改登录密码失败，请稍后再试");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("数据异常");
		}
		return gson.toJson(jsonReturn);
	}
	
	//上传头像
	@ResponseBody
	@RequestMapping(value = "/uploadMemberPicture", produces = "application/json;charset=UTF-8")
	public Object uploadMemberPicture(Integer memberId,MultipartFile photo) {
		JsonReturn jsonReturn = new JsonReturn();
		// 判断文件是否为空
		if (!photo.isEmpty() && photo.getSize() > 0) {
			// 判断memberId
			if (memberId > 0) {
				Smmembers member = this.appMemberService.selectMemberById(memberId);

				if (member != null) {

					// 获取文件名称
					String fileName = photo.getOriginalFilename();
					// 获取文件扩展名称
					String strExt = fileName.substring(fileName.lastIndexOf('.'));

					String phoneName = memberId + "_" + System.currentTimeMillis() + "_" + System.nanoTime() + strExt;

					// 保存图片
					try {
						FileUtils.writeByteArrayToFile(new File("D:\\android-WorkSpace\\SupermarketApp\\app\\src\\main\\res\\drawable\\image", phoneName),
								photo.getBytes());
						// 删除以前的图片
						if (Tools.isNotNull(member.getPhoto())) {
							File oldImage = new File("D:\\android-WorkSpace\\SupermarketApp\\app\\src\\main\\res\\drawable\\image", member.getPhoto());
							if (oldImage.exists()) {
								oldImage.delete();
							}
						}
						
						// 将头像的文件名称保存到数据库
						member.setPhoto(phoneName);
						Integer intR = this.appMemberService.updateMemberById(member);
						if (intR > 0) {
							Smmembers memberVo = this.appMemberService.selectMemberById(memberId);
							jsonReturn.setCode(200);
							jsonReturn.setText("头像上传成功");
							jsonReturn.setData(memberVo);
						} else {
							jsonReturn.setCode(300);
							jsonReturn.setText("头像上传失败，稍后再试");
						}

					} catch (IOException e) {
						e.printStackTrace();
						jsonReturn.setCode(300);
						jsonReturn.setText("头像上传失败，稍后再试");
					}
				} else {
					jsonReturn.setCode(500);
					jsonReturn.setText("参数异常");
				}

			} else {
				jsonReturn.setCode(500);
				jsonReturn.setText("参数异常");
			}

		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("上传的头像为空");
		}

		return gson.toJson(jsonReturn);
	}
	
	//查看头像
	@RequestMapping(value = "/getMemberPicture")
	public ResponseEntity<byte[]> getMemberPicture(String pictureName) throws IOException {
		if (Tools.isNotNull(pictureName)) {
			// 文件
			File file = new File("D:\\android-WorkSpace\\SupermarketApp\\app\\src\\main\\res\\drawable\\image", pictureName);
			if (file.exists()) {// 判断文件是否存在
				// 设置Header
				HttpHeaders headers = new HttpHeaders();
				// 设置为图片类型
				headers.setContentType(MediaType.IMAGE_JPEG);
				headers.setContentDispositionFormData("attachment", pictureName);
				
				// 返回文件相关数据
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
			}
		}
		return null;
	}
	
	//更新个人资料
	@ResponseBody
	@RequestMapping(value = "/updateMember", produces = "application/json;charset=UTF-8")
	public Object updateMember(Smmembers member) {
		JsonReturn jsonReturn = new JsonReturn();

		if (member!=null) {
			int intR = this.appMemberService.updateSexById(member);
			if (intR == 1) {
				Smmembers memberVo = this.appMemberService.selectMemberById(member.getMemberId());
				jsonReturn.setCode(200);
				jsonReturn.setText("个人资料更新成功");
				jsonReturn.setData(memberVo);
			} else {
				jsonReturn.setCode(300);
				jsonReturn.setText("个人资料更新失败");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("参数异常");
		}

		return gson.toJson(jsonReturn);
	}

	//加入购物车
	@ResponseBody
	@RequestMapping(value = "/insertCart", produces = "application/json;charset=UTF-8")
	public Object insertCart(Cart cart) {
		JsonReturn jsonReturn = new JsonReturn();
		if (Tools.isNotNull(cart.getProductId()) && Tools.isNotNull(cart.getProductNumber().toString())) {
			Cart cart2 = this.appMemberService.selectCart(cart);
			if (cart2!=null) {
				Integer proNumber = cart.getProductNumber() + cart2.getProductNumber();
				cart.setProductNumber(proNumber	);
				Integer returnNumber = this.appMemberService.updateCartPN(cart);
				if (returnNumber == 1) {
					jsonReturn.setCode(200);
					jsonReturn.setText("已将该商品加入购物车");
				} else {
					jsonReturn.setCode(300);
					jsonReturn.setText("加入购物车失败，请稍后再试");
				}
			}else{
				Integer intR = this.appMemberService.insertCartTable(cart);
				if (intR == 1) {
					jsonReturn.setCode(200);
					jsonReturn.setText("已将该商品加入购物车");
				} else {
					jsonReturn.setCode(300);
					jsonReturn.setText("加入购物车失败，请稍后再试");
				}
			}
			
			
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("数据异常");
		}

		return gson.toJson(jsonReturn);
	}
	
	
}
