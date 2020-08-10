package cn.itcast.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.Productinventory;
import cn.itcast.domain.Products;
import cn.itcast.domain.Saleslist;
import cn.itcast.domain.Saleslistdetail;
import cn.itcast.domain.Salesperson;
import cn.itcast.domain.Smmembers;
import cn.itcast.service.IUserService;

@Controller
@RequestMapping("/receptionLogin")
public class ReceptionLoginController {
	@Autowired
	IUserService userService;
	/*private Salesperson salesperson;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String rememberMe;
	private Integer message;
	private String productId;
	private Products products;
	private String memberId;//会员号
	private Saleslist saleslist;//销售流水账
	private Saleslistdetail saleslistdetail;//销售流水账明细			
*/	
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request){
		//获取浏览器访问访问服务器时传递过来的cookie数组
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for (int i = 0; i < cookies.length; i++) {
				 Cookie cookie1 = cookies[i];
                 if (cookie1.getName().equals("fname")) {
                	 request.setAttribute("fname", cookie1.getValue());
                 }
                 if(cookie1.getName().equals("fpassword")){
                	 request.setAttribute("fpassword", cookie1.getValue());
                 }
             }
		}
		return "login";
	}
	@RequestMapping("/login")
	public @ResponseBody Object login(Salesperson salesperson,String rememberMe,HttpServletResponse response,HttpServletRequest request){
		Integer message=1;
		Salesperson salespersons = userService.frontDeskLogin(salesperson);
		if (salespersons!=null) {
			if (salespersons.getLoginPwd().equals(salesperson.getLoginPwd())) {
				//记住我
				String loginName =Integer.toString(salespersons.getSalesPersonId());
				if ("on".equals(rememberMe)) {
					Cookie cookie = new Cookie("fname",loginName);
					Cookie cookie2 = new Cookie("fpassword",salespersons.getLoginPwd());
					cookie.setMaxAge(7*24*60*60);
					cookie2.setMaxAge(7*24*60*60);
					response.addCookie(cookie);
					response.addCookie(cookie2);
				}else{
					Cookie cookie = new Cookie("fname",loginName);
					Cookie cookie2 = new Cookie("fpassword",salesperson.getLoginPwd());
					cookie.setMaxAge(0);
					cookie2.setMaxAge(0);
					response.addCookie(cookie);
					response.addCookie(cookie2);
				}
				HttpSession session=request.getSession();
				session.setAttribute("salespersons", salespersons);
				message = 3;
			}else{
				message = 2;
			}
		}else{
			message = 1;
		}
		
		return message;
	}
	
	//移除session
	@RequestMapping("/removeSession")
	public String removeSession(HttpServletRequest request){
		Enumeration em = request.getSession().getAttributeNames();
	    while(em.hasMoreElements()){
	       request.getSession().removeAttribute(em.nextElement().toString());
	    }
	    return "login";
	}
	
	//根据商品编号查询商品信息
	@RequestMapping("selectProductId")
	public @ResponseBody Object selectProductId(String productId,Products products){
		if(productId!=null){
			products = userService.selectProducts(productId);
		}else {
			
		}
		return products;
	}
	
	//商品结算
	@RequestMapping("/insertSS")
	public @ResponseBody Object insertSS(Saleslist saleslist,Saleslistdetail saleslistdetail,String memberId){
		Integer message = 0;
		if(saleslist!=null&&saleslistdetail!=null){
			//销售流水账
			Saleslist sales = userService.selectSaleslist(saleslist);
			//商品库存信息
			Productinventory productinventory = userService.selectProductinventory(saleslistdetail.getProductId());
			Integer totalCount = productinventory.getTotalCount()-saleslistdetail.getQuantity();//库存数量
			if (sales==null) {
				try {
					Date date = new Date();
					SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy‐MM‐dd HH:mm:ss");
					String str = dateFormat1.format(date);
					dateFormat1.format(dateFormat1.parse(str).getTime());
					saleslist.setSaleDate(new Timestamp(dateFormat1.parse(str).getTime()));
					//新增销售记录
					message = userService.insertSaleslist(saleslist);
					if(!"".equals(memberId)){
						Smmembers smmembers = userService.selectSmmembers(memberId);
						if(smmembers!=null){
							Double jf = (Double) saleslist.getTotalMoney()/10;
							Integer inte = Integer.parseInt(new java.text.DecimalFormat("0").format(jf));
							smmembers.setPoints(smmembers.getPoints()*1+inte);
							Integer s = userService.updateSmmembers(smmembers);
						}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//新增销售流水账明细
			Integer sa = userService.insertSaleslistdetail(saleslistdetail);
			
			if(productinventory.getMaxCount()<totalCount){
				productinventory.setStatusId(2);
			}else if(productinventory.getMinCount()>totalCount) {
				productinventory.setStatusId(-1);
			}else if(totalCount==0){
				productinventory.setStatusId(-2);
			}else {
				productinventory.setStatusId(1);
			}
			//修改库存数量以及状态
			message=userService.updateProductinventory(productinventory);
		}else {
			message=0;
		}
		
		return message;
	}
}
