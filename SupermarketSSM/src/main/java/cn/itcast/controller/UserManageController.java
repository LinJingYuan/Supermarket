package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.Sysadmins;
import cn.itcast.service.IUserManageService;
import cn.itcast.vo.Bsgrid;

@Controller
@RequestMapping("/userManage")
public class UserManageController {
	
	@Autowired
	private IUserManageService userManageService;
	
	//查询用户信息
	@RequestMapping("/selectUManage")
	public @ResponseBody Object selectUManage(Integer curPage,Integer pageSize){
		if (curPage==null) {
			curPage=1;
		}
		if (pageSize==null) {
			pageSize=5;
		}
		Integer startIndex = (curPage-1)*pageSize;
		Integer account = userManageService.account(pageSize);
		List<Sysadmins> listCommodityI = userManageService.selectUM(startIndex,pageSize);
		Bsgrid<Sysadmins> bsgrid = new Bsgrid<Sysadmins>();
		bsgrid.setSuccess(true);
		bsgrid.setCurPage(pageSize);
		bsgrid.setTotalRows(account);
		bsgrid.setData(listCommodityI);
		return bsgrid;
	}
	
	//返回用户新增账户
	@RequestMapping("/selectLoginId")
	public @ResponseBody Object selectLoginId(Integer loginId){
		loginId = userManageService.selectLId();
		return loginId;
	}
	
	//新增用户
	@RequestMapping("/insertSysadmins")
	public @ResponseBody Object insertSysadmins(String loginname,Integer roleid){
		
		Integer message = userManageService.insertUser(loginname,roleid);
		return message;
	}
	
	//修改用户信息
	@RequestMapping("/updateSysadmins")
	public @ResponseBody Object updateSysadmins(String loginname,Integer loginId,Integer roleid){
		Integer message;
		if(loginId!=null){
			message = userManageService.updateUser(loginname,roleid,loginId);
		}else{
			message = 0;
		}
		return message;
	}
	
	//修改用户禁用启用
	@RequestMapping("/updataState")
	public @ResponseBody Object updataState(Integer loginId,Integer roleid){
		Integer message;
		if(loginId!=null){
			message = userManageService.updateRoleid(loginId,roleid);
		}else{
			message = 0;
		}
		return message;
	}
}
