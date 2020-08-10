package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.SelectParam;
import cn.itcast.dao.ICommodityInventoryDao;
import cn.itcast.domain.Productinventory;
import cn.itcast.service.ICommodityInventoryService;
import cn.itcast.vo.Bsgrid;
import cn.itcast.vo.CommodityI;

@Transactional
@Service("commodityInventoryService")
public class CommodityInventoryServiceImpl implements ICommodityInventoryService {

	@Autowired
	ICommodityInventoryDao ciDao;
	@Override
	public Integer selectCIAccount(String productId,String productName,Integer categoryId
			,Integer warningCount,Integer upperLimit,Integer floor,Integer pageSize) {
		// TODO Auto-generated method stub
		return ciDao.selectCIAccount(productId,productName, categoryId, warningCount, upperLimit, floor, pageSize);
	}
	@Override
	public List<CommodityI> selectCI(String productId,String productName,Integer categoryId
			,Integer warningCount,Integer upperLimit,Integer floor,Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return ciDao.selectCI(productId,productName, categoryId, warningCount, upperLimit, floor, startIndex, pageSize);
	}
	@Override
	public Integer updateI(Productinventory productinventory) {
		// TODO Auto-generated method stub
		return ciDao.updateI(productinventory);
	}
	@Override
	public Integer updateIC(Productinventory productinventory) {
		// TODO Auto-generated method stub
		return ciDao.updateIC(productinventory);
	}
	
	
	

}
