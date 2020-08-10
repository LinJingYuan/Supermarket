package cn.itcast.service;

import java.util.List;

import cn.itcast.common.SelectParam;
import cn.itcast.domain.Productinventory;
import cn.itcast.vo.CommodityI;

public interface ICommodityInventoryService {
	//库存信息总数查询
	Integer selectCIAccount(String productId,String productName,Integer categoryId,Integer warningCount,Integer upperLimit,Integer floor,Integer pageSize);
	//库存信息查询
	List<CommodityI> selectCI(String productId,String productName,Integer categoryId,Integer warningCount,Integer upperLimit,Integer floor,Integer startIndex,Integer pageSize);
	//修改最大最小库存量
	Integer updateI(Productinventory productinventory);
	//修改库存总量
	Integer updateIC(Productinventory productinventory);
}
