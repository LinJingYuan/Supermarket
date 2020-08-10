package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.Sysadmins;

@Repository
public interface IUserManageDao {
	//查询用户总条数
	@Select("select count(*) count from Sysadmins order by loginId limit 0,#{pageSize}")
	Integer account(Integer pageSize);
	
	//查询全部用户信息
	@Select("select * from Sysadmins order by loginId limit #{param1},#{param2}")
	List<Sysadmins> selectUM(Integer startIndex, Integer pageSize);
	
	//查询用户最大ID
	@Select("select * from Sysadmins order by loginId desc limit 0,1")
	Integer selectLId();
	
	//新增用户
	@Insert("insert into Sysadmins(loginPwd,adminName,adminStatus,roleId) values('123456',#{param1},'1',#{param2})")
	Integer insertUser(String userName,Integer roleid);
	
	//修改用户信息
	@Update("update Sysadmins set adminName=#{param1},roleId=#{param2} where loginId=#{param3}")
	Integer updateUser(String userName,Integer roleid,Integer loginId);
	
	//修改启动或者禁用
	@Update("update Sysadmins set adminStatus=#{param2} where loginId=#{param1}")
	Integer updateRoleid(Integer loginId, Integer roleid);
}
