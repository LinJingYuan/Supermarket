package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.itcast.dao.IShippingAddressDao;
import cn.itcast.domain.ShippingAddress;
import cn.itcast.service.IShippingAddressService;

@Transactional
@Service("shippingAddressService")
public class ShippingAddressServiceImpl implements IShippingAddressService{

	@Autowired
	IShippingAddressDao shippingAddressDao;
	@Override
	public Integer insertShippingAddress(ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		return shippingAddressDao.insertShippingAddress(shippingAddress);
	}
	@Override
	public Integer updateIsDefault(ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		return shippingAddressDao.updateIsDefault(shippingAddress);
	}
	@Override
	public Integer selectShippingAddressAccount(Integer memberId, Integer pageSize) {
		// TODO Auto-generated method stub
		return shippingAddressDao.selectShippingAddressAccount(memberId, pageSize);
	}
	@Override
	public List<ShippingAddress> selectShippingAddress(Integer memberId, Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return shippingAddressDao.selectShippingAddress(memberId, startIndex, pageSize);
	}
	@Override
	public Integer updateShippingAddress(ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		return shippingAddressDao.updateShippingAddress(shippingAddress);
	}
	@Override
	public Integer deleteShippingAddress(ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		return shippingAddressDao.deleteShippingAddress(shippingAddress);
	}

}
