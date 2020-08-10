package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.ShippingAddress;

@Repository
public interface IShippingAddressDao {
	//修改收货地址中的默认选中
	@Update("update ShippingAddress set isDefault=false where MemberId=#{memberId}")
	Integer updateIsDefault(ShippingAddress shippingAddress);
	
	//添加收货地址
	@Insert("insert into ShippingAddress(MemberId,name,phone,address,isDefault) values(#{memberId},#{name},#{phone},#{address},#{isDefault})")
	Integer insertShippingAddress(ShippingAddress shippingAddress);
	
	//查询用户的所有收货地址的总条数
	@Select("select count(*) count from ShippingAddress where MemberId=#{param1} limit 0,#{param2}")
	Integer selectShippingAddressAccount(Integer memberId,Integer pageSize);
	
	//查询用户的所有收货地址
	@Select("SELECT * FROM ShippingAddress WHERE MemberId=#{param1} ORDER BY isDefault DESC LIMIT #{param2},#{param3}")
	List<ShippingAddress> selectShippingAddress(Integer memberId,Integer startIndex,Integer pageSize);
	
	//修改收货地址
	@Update("update ShippingAddress set name=#{name},phone=#{phone},address=#{address},isDefault=#{isDefault} where shippingAddressId=#{shippingAddressId}")
	Integer updateShippingAddress(ShippingAddress shippingAddress);
	
	//删除收货地址
	@Delete("delete from ShippingAddress where shippingAddressId=#{shippingAddressId}")
	Integer deleteShippingAddress(ShippingAddress shippingAddress);
	
	//根据会员号查询会员的默认收货地址
	@Select("select * from ShippingAddress where memberId=#{memberId} and isDefault=true")
	ShippingAddress selectAddress(Integer memberId);
}
