package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.IUserDao;
import cn.itcast.domain.Loginlogs;
import cn.itcast.domain.Productcategory;
import cn.itcast.domain.Productinventory;
import cn.itcast.domain.Products;
import cn.itcast.domain.Productunit;
import cn.itcast.domain.Saleslist;
import cn.itcast.domain.Saleslistdetail;
import cn.itcast.domain.Salesperson;
import cn.itcast.domain.Smmembers;
import cn.itcast.domain.Sysadmins;
import cn.itcast.service.IUserService;

@Transactional
@Service(value="userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	@Override
	public Sysadmins login(Sysadmins user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
	@Override
	public List<Productcategory> category() {
		// TODO Auto-generated method stub
		return userDao.category();
	}
	@Override
	public List<Productunit> unit() {
		// TODO Auto-generated method stub
		return userDao.unit();
	}
	@Override
	public Integer updateP(Sysadmins sysadmins) {
		// TODO Auto-generated method stub
		return userDao.updateP(sysadmins);
	}
	@Override
	public Integer insertLoginlogs(Loginlogs loginlogs) {
		// TODO Auto-generated method stub
		return userDao.insertLoginlogs(loginlogs);
	}
	@Override
	public Integer updateTime(Loginlogs loginlogs) {
		// TODO Auto-generated method stub
		return userDao.updateTime(loginlogs);
	}
	@Override
	public Salesperson frontDeskLogin(Salesperson user) {
		// TODO Auto-generated method stub
		return userDao.frontDeskLogin(user);
	}
	@Override
	public Products selectProducts(String productId) {
		// TODO Auto-generated method stub
		return userDao.selectProducts(productId);
	}
	@Override
	public Saleslist selectSaleslist(Saleslist saleslist) {
		// TODO Auto-generated method stub
		return userDao.selectSaleslist(saleslist);
	}
	@Override
	public Productinventory selectProductinventory(String productId) {
		// TODO Auto-generated method stub
		return userDao.selectProductinventory(productId);
	}
	@Override
	public Integer insertSaleslist(Saleslist saleslist) {
		// TODO Auto-generated method stub
		return userDao.insertSaleslist(saleslist);
	}
	@Override
	public Smmembers selectSmmembers(String memberId) {
		// TODO Auto-generated method stub
		return userDao.selectSmmembers(memberId);
	}
	@Override
	public Integer updateSmmembers(Smmembers smmembers) {
		// TODO Auto-generated method stub
		return userDao.updateSmmembers(smmembers);
	}
	@Override
	public Integer insertSaleslistdetail(Saleslistdetail saleslistdetail) {
		// TODO Auto-generated method stub
		return userDao.insertSaleslistdetail(saleslistdetail);
	}
	@Override
	public Integer updateProductinventory(Productinventory productinventory) {
		// TODO Auto-generated method stub
		return userDao.updateProductinventory(productinventory);
	}
	@Override
	public Sysadmins selectSQLQuery(Integer loginId) {
		// TODO Auto-generated method stub
		return userDao.selectSysadmins(loginId);
	}
	
	
	
	
	
	
	
}
