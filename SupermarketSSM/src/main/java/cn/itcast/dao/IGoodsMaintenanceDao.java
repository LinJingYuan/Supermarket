package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.Productinventory;
import cn.itcast.domain.Products;
import cn.itcast.domain.Productstorage;
import cn.itcast.vo.GoodsPreserve;

@Repository
public interface IGoodsMaintenanceDao {
	
	//新增商品
	@Insert("insert into Products(productId,productName,unitPrice,unit,discount,categoryId) values(#{productId},#{productName},#{unitPrice},#{unit},#{discount},#{categoryId})")
	Integer insertProducts(Products products);
	//新增商品
	@Insert("insert into Productinventory(productId,totalCount,minCount,maxCount,statusId) values(#{productId},#{totalCount},#{minCount},#{maxCount},#{statusId})")
	Integer insertProductinventory(Productinventory productinventory);
	//查询商品总条数
	@Select("SELECT COUNT(*) count FROM Products du,ProductCategory ca,ProductInventory ins WHERE du.CategoryId=ca.CategoryId AND du.ProductId=ins.ProductId order by du.productId limit 0,#{pageSize}")
	Integer spSAccount(Integer pageSize);
	//查询商品总条数模糊查询
	Integer spMAccount(@Param("sEncode") String sEncode,@Param("sName") String sName,@Param("categoryId") Integer categoryId,@Param("pageSize") Integer pageSize);
	//查询商品信息
	List<GoodsPreserve> selectGMs(@Param("sEncode") String sEncode,@Param("sName") String sName,@Param("categoryId") Integer categoryId,@Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);
	//-根据商品编号查询商品名称
	@Select("select * from Products where productId=#{productId}")
	Products selectSPName(String productId);
	//新增入库信息
	@Insert("insert into ProductStorage(productId,addedCount,currentTime) value(#{productId},#{addedCount},#{currentTime})")
	Integer insertP(Productstorage productstorage);
	
	//查询库存数量
	@Select("select totalCount from Productinventory where productId=#{productId}")
	Integer selectTotalCount(String productId);
	
	//商品入库
	@Update("update Productinventory set totalCount=#{totalCount} where productId=#{productId}")
	Integer cStorage(Productinventory productinventory);
	
	//修改商品信息
	@Update("update Products set productId = #{productId},productName=#{productName},unitPrice=#{unitPrice},unit=#{unit},categoryId=#{categoryId} where productId=#{productId}")
	Integer updateProducts(Products products);
	//删除商品信息
	@Delete("delete from Products where productId = #{productId}")
	Integer deleteProducts(String productId);
	//修改商品折扣
	@Update("update Products set discount=#{discount} where productId=#{productId}")
	Integer updateDiscounts(Products products);
}
