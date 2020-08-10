package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.ICartDao;
import cn.itcast.dao.IOrderformDao;
import cn.itcast.dao.IShippingAddressDao;
import cn.itcast.domain.Orderform;
import cn.itcast.domain.ShippingAddress;
import cn.itcast.service.IAppShippingCartService;
import cn.itcast.vo.CartVo;

@Transactional
@Service("appShippingCartService")
public class AppShippingCartServiceImpl implements IAppShippingCartService {

	@Autowired
	ICartDao cartDao;
	@Autowired
	IShippingAddressDao shippingAddressDao;
	@Autowired
	IOrderformDao orderformDao;
	
	@Override
	public Integer selectShippingCartAccount(Integer memberId, Integer pageSize) {
		// TODO Auto-generated method stub
		return cartDao.selectShippingCartAccount(memberId,pageSize);
	}

	@Override
	public List<CartVo> selectShippingCart(Integer memberId, Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return cartDao.selectShippingCart(memberId, startIndex, pageSize);
	}

	@Override
	public Integer updateProductNumber(Integer cartId, Integer productNumber) {
		// TODO Auto-generated method stub
		return cartDao.updateProductNumber(cartId, productNumber);
	}

	@Override
	public Integer deleteCart(Integer cartId) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(cartId);
	}

	@Override
	public ShippingAddress selectAddress(Integer memberId) {
		// TODO Auto-generated method stub
		return shippingAddressDao.selectAddress(memberId);
	}

	@Override
	public Integer insertOrderform(Orderform orderform) {
		// TODO Auto-generated method stub
		return orderformDao.insertOrderform(orderform);
	}

}
