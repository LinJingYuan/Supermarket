package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.IUserManageDao;
import cn.itcast.domain.Sysadmins;
import cn.itcast.service.IUserManageService;
import cn.itcast.vo.Bsgrid;

@Transactional
@Service("userManageService")
public class UserManageServiceImpl implements IUserManageService {
	@Autowired
	IUserManageDao userManageDao;

	@Override
	public List<Sysadmins> selectUM(Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return userManageDao.selectUM(startIndex, pageSize);
	}

	@Override
	public Integer selectLId() {
		// TODO Auto-generated method stub
		return userManageDao.selectLId();
	}

	@Override
	public Integer insertUser(String userName, Integer roleid) {
		// TODO Auto-generated method stub
		return userManageDao.insertUser(userName,roleid);
	}

	@Override
	public Integer updateUser(String userName, Integer roleid,Integer loginId) {
		// TODO Auto-generated method stub
		return userManageDao.updateUser(userName,roleid,loginId);
	}

	@Override
	public Integer updateRoleid(Integer loginId, Integer roleid) {
		// TODO Auto-generated method stub
		return userManageDao.updateRoleid(loginId,roleid);
	}

	@Override
	public Integer account(Integer pageSize) {
		// TODO Auto-generated method stub
		return userManageDao.account(pageSize);
	}
	
}
