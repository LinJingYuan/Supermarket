package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Productinventory;
import cn.itcast.domain.Products;
import cn.itcast.domain.Productstorage;
import cn.itcast.vo.GoodsPreserve;

public interface IGoodsMaintenanceService {
	//新增商品
	Integer insertProducts(Products products);
	//新增商品
	Integer insertProductinventory(Productinventory productinventory);
	//查询商品总条数
	Integer spSAccount(Integer pageSize);
	//查询商品总条数模糊查询
	Integer spMAccount(String sEncode,String sName,Integer categoryId,Integer pageSize);
	//查询商品信息
	List<GoodsPreserve> selectGMs(String sEncode,String sName,Integer categoryId,Integer startIndex,Integer pageSize);
	//-根据商品编号查询商品名称
	Products selectSPName(String productId);
	//新增入库信息
	Integer insertP(Productstorage productstorage);
	//查询库存数量
	Integer selectTotalCount(String productId);
	//商品入库
	Integer cStorage(Productinventory productinventory);
	//修改商品信息
	Integer updateProducts(Products products);
	//删除商品信息
	Integer deleteProducts(String productId);
	//修改商品折扣
	Integer updateDiscounts(Products products);
}
