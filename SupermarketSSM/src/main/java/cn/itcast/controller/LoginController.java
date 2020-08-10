package cn.itcast.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.Loginlogs;
import cn.itcast.domain.Productcategory;
import cn.itcast.domain.Productunit;
import cn.itcast.domain.Sysadmins;
import cn.itcast.service.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	//Cookie
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request){
		//获取浏览器访问访问服务器时传递过来的cookie数组
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for (int i = 0; i < cookies.length; i++) {
				 Cookie cookie1 = cookies[i];
                 if (cookie1.getName().equals("name")) {
                	 request.setAttribute("name", cookie1.getValue());
                 }
                 if(cookie1.getName().equals("password")){
                	 request.setAttribute("password", cookie1.getValue());
                 }
             }
		}
		return "loginTwo";
	}
	
	//登录认证
	@RequestMapping(value="/rLogin")
	public @ResponseBody Object rLogin(Sysadmins sysadmins,String rememberMe,HttpServletResponse response,HttpServletRequest request){
		Integer message=1;
		Sysadmins sysadminsy = userService.login(sysadmins);
		List<Productcategory> listCategory = userService.category();
		List<Productunit> listUnit = userService.unit();
		if (sysadminsy!=null) {
			if (sysadminsy.getLoginPwd().equals(sysadmins.getLoginPwd())) {
				if(sysadminsy.getAdminStatus().equals("1")){
					//记住我
					String loginName =Integer.toString(sysadmins.getLoginId());
					if ("on".equals(rememberMe)) {
						Cookie cookie = new Cookie("name",loginName);
						Cookie cookie2 = new Cookie("password",sysadmins.getLoginPwd());
						cookie.setMaxAge(7*24*60*60);
						cookie2.setMaxAge(7*24*60*60);
						response.addCookie(cookie);
						response.addCookie(cookie2);
					}else{
						Cookie cookie = new Cookie("name",loginName);
						Cookie cookie2 = new Cookie("password",sysadmins.getLoginPwd());
						cookie.setMaxAge(0);
						cookie2.setMaxAge(0);
						response.addCookie(cookie);
						response.addCookie(cookie2);
					}
					String serverName = request.getServerName();
					
					Loginlogs loginlogs = new Loginlogs();
					try {
						Date date = new Date();
						SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy‐MM‐dd HH:mm:ss");
						String str = dateFormat1.format(date);
						dateFormat1.format(dateFormat1.parse(str).getTime());
						loginlogs.setLoginId(sysadminsy.getLoginId());
						loginlogs.setSpname(sysadminsy.getAdminName());
						loginlogs.setServerName(serverName);
						loginlogs.setLoginTime(new Timestamp(dateFormat1.parse(str).getTime()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Integer insertLlogs = userService.insertLoginlogs(loginlogs);
					HttpSession session=request.getSession();
					session.setAttribute("logId", loginlogs.getLogId());
					session.setAttribute("sysadmins", sysadminsy);
					session.setAttribute("listCategory", listCategory);
					session.setAttribute("listUnit", listUnit);
					message = 4;
				}else{
					message = 3;
				}
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
	public String removeSession(Integer logId,HttpServletRequest request){
		Loginlogs loginlogs = new Loginlogs();
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy‐MM‐dd HH:mm:ss");
			String str = dateFormat1.format(date);
			dateFormat1.format(dateFormat1.parse(str).getTime());
			loginlogs.setExitTime(new Timestamp(dateFormat1.parse(str).getTime()));
			loginlogs.setLogId(logId);
			userService.updateTime(loginlogs);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Enumeration em = request.getSession().getAttributeNames();
		
	    while(em.hasMoreElements()){
	    
	    	request.getSession().removeAttribute(em.nextElement().toString());
	    
	    }
	    return "loginTwo";
	}
	
	//修改用户密码
	@RequestMapping("/updatePassword")
	public @ResponseBody Object updatePassword(Integer userid,String ypassword,String npassword){
		Integer message;
		if (userid!=null) {
			Sysadmins sysadmins  = userService.selectSQLQuery(userid);
			if (sysadmins.getLoginPwd().equals(ypassword)) {
				sysadmins.setLoginPwd(npassword);
				message = userService.updateP(sysadmins);
			}else{
				message = 2;
			}
		}else{
			message = 0;
		}
		return message;
	}

}
