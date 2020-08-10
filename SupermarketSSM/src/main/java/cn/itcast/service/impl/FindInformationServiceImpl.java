package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.IFindInformationDao;
import cn.itcast.domain.Loginlogs;
import cn.itcast.service.IFindInformationService;
import cn.itcast.vo.XSCount;

@Transactional
@Service("findInformationService")
public class FindInformationServiceImpl implements IFindInformationService {

	@Autowired
	IFindInformationDao findInformationDao;
	
	@Override
	public Integer Laccount(Integer pageSize) {
		// TODO Auto-generated method stub
		return findInformationDao.Laccount(pageSize);
	}


	@Override
	public Integer Maccount(String begintime,String endtime, Integer pageSize) {
		// TODO Auto-generated method stub
		return findInformationDao.Maccount(begintime,endtime, pageSize);
	}


	@Override
	public List<Loginlogs> selectLoginlogs(String begintime,String endtime, Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return findInformationDao.selectLoginlogs(begintime,endtime, startIndex, pageSize);
	}
	
	@Override
	public Integer Saccount(String begintime,String endtime, Integer pageSize) {
		// TODO Auto-generated method stub
		return findInformationDao.Saccount(begintime,endtime, pageSize);
	}
	
	@Override
	public List<XSCount> selectSaleslist(String begintime,String endtime,Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return findInformationDao.selectSaleslist(begintime,endtime, startIndex, pageSize);
	}


	

}
