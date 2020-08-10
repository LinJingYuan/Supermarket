package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Sysadmins;
import cn.itcast.vo.Bsgrid;

public interface IUserManageService {
	//查询用户总条数
	Integer account(Integer pageSize);
	//查询用户
	List<Sysadmins> selectUM(Integer startIndex,Integer pageSize);
	//查詢用戶ID
	Integer selectLId();
	//新增用户
	Integer insertUser(String userName,Integer roleid);
	//修改用户
	Integer updateUser(String userName,Integer roleid,Integer loginId);
	//修改用户状态
	Integer updateRoleid(Integer loginId,Integer roleid);
}
