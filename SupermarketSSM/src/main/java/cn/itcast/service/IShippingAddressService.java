package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.ShippingAddress;

public interface IShippingAddressService {
	//修改收货地址的是否默认选中
	Integer updateIsDefault(ShippingAddress shippingAddress);
	
	//添加收货地址
	Integer insertShippingAddress(ShippingAddress shippingAddress);
	
	//查询用户的所有收货地址的总条数
	Integer selectShippingAddressAccount(Integer memberId,Integer pageSize);
	
	//查询用户的所有收货地址
	List<ShippingAddress> selectShippingAddress(Integer memberId,Integer startIndex,Integer pageSize);
	
	//修改收货地址
	Integer updateShippingAddress(ShippingAddress shippingAddress);
	
	//删除收货地址
	Integer deleteShippingAddress(ShippingAddress shippingAddress);
	
	
}
