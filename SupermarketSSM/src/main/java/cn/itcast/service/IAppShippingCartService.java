package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Orderform;
import cn.itcast.domain.ShippingAddress;
import cn.itcast.vo.CartVo;

public interface IAppShippingCartService {
	//查询用户的购物车总数
	Integer selectShippingCartAccount(Integer memberId,Integer pageSize);
	
	//查询用户的购物车
	List<CartVo> selectShippingCart(Integer memberId,Integer startIndex,Integer pageSize);
	
	//修改购物车加入商品数量
	Integer updateProductNumber(Integer cartId,Integer productNumber);
	
	//删除加入购物车的商品
	Integer deleteCart(Integer cartId);
	
	//结算默认收货地址
	ShippingAddress selectAddress(Integer memberId);
	
	//添加订单
	Integer insertOrderform(Orderform orderform);
}
