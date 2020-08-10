package cn.itcast.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.Smmembers;

@Repository
public interface ISmmembersDao {
	//根据手机号查询会员
	@Select("select * from Smmembers where PhoneNumber = #{phone} limit 1")
	Smmembers findSmmembersMyPhone(@Param("phone") String phone);
	//查询最大会员卡Id
	@Select("SELECT memberId FROM Smmembers ORDER BY memberId DESC LIMIT 0,1")
	Integer selectMemberId();
	//新增会员
	@Insert("insert into Smmembers(memberId,UPassword,memberName,sex,photo,points,phoneNumber,memberAddress,openTime) values(#{memberId},#{UPassword},#{memberName},#{sex},null,null,#{phoneNumber},#{memberAddress},#{openTime})")
	Integer insertSmmembers(Smmembers smmembers);
	//修改用户密码
	@Update("update Smmembers set UPassword=#{UPassword} where phoneNumber=#{phoneNumber}")
	Integer updateSmmembersById(Smmembers smmembers);
	//修改登录
	@Update("update Smmembers set UPassword=#{param1} where MemberId=#{param2}")
	Integer updatePassword(String newPassword, Integer memberId);
	//根据会员卡号查询会员信息
	@Select("select * from Smmembers where MemberId = #{memberId}")
	Smmembers selectMemberById(Integer memberId);
	//修改头像
	@Update("update Smmembers set Photo=#{photo} where MemberId = #{memberId}")
	Integer updateMemberById(Smmembers member);
	//修个人信息（性别）
	@Update("update Smmembers set Sex=#{sex} where MemberId = #{memberId}")
	Integer updateSexById(Smmembers member);
	
}
