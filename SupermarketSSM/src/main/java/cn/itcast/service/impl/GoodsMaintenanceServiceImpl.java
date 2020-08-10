package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.IGoodsMaintenanceDao;
import cn.itcast.domain.Productinventory;
import cn.itcast.domain.Products;
import cn.itcast.domain.Productstorage;
import cn.itcast.service.IGoodsMaintenanceService;
import cn.itcast.vo.GoodsPreserve;

@Transactional
@Service(value="goodsMaintenanceService")
public class GoodsMaintenanceServiceImpl implements IGoodsMaintenanceService {

	@Autowired
	private IGoodsMaintenanceDao goodsMaintenanceDao;
	
	@Override
	public Integer insertProducts(Products products) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.insertProducts(products);
	}
	@Override
	public Integer insertProductinventory(Productinventory productinventory) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.insertProductinventory(productinventory);
	}
	@Override
	public Integer spSAccount(Integer pageSize) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.spSAccount(pageSize);
	}
	@Override
	public Integer spMAccount(String sEncode, String sName, Integer categoryId, Integer pageSize) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.spMAccount(sEncode, sName, categoryId, pageSize);
	}
	@Override
	public List<GoodsPreserve> selectGMs(String sEncode, String sName,
			Integer categoryId, Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.selectGMs(sEncode, sName, categoryId, startIndex, pageSize);
	}
	@Override
	public Products selectSPName(String productId) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.selectSPName(productId);
	}
	@Override
	public Integer insertP(Productstorage productstorage) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.insertP(productstorage);
	}
	@Override
	public Integer selectTotalCount(String productId) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.selectTotalCount(productId);
	}
	@Override
	public Integer cStorage(Productinventory productinventory) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.cStorage(productinventory);
	}
	@Override
	public Integer updateProducts(Products products) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.updateProducts(products);
	}
	@Override
	public Integer deleteProducts(String productId) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.deleteProducts(productId);
	}
	@Override
	public Integer updateDiscounts(Products products) {
		// TODO Auto-generated method stub
		return goodsMaintenanceDao.updateDiscounts(products);
	}
	
	
	
	

}
