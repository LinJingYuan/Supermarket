package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.Productinventory;
import cn.itcast.vo.CommodityI;

@Repository
public interface ICommodityInventoryDao {
	//库存信息总数查询
	Integer selectCIAccount(@Param("productId") String productId,@Param("productName") String productName
			,@Param("categoryId") Integer categoryId,@Param("warningCount") Integer warningCount
			,@Param("upperLimit") Integer upperLimit,@Param("floor") Integer floor,@Param("pageSize") Integer pageSize);
	//库存信息查询
	List<CommodityI> selectCI(@Param("productId") String productId,@Param("productName") String productName
			,@Param("categoryId") Integer categoryId,@Param("warningCount") Integer warningCount
			,@Param("upperLimit") Integer upperLimit,@Param("floor") Integer floor,@Param("startIndex") Integer startIndex
			,@Param("pageSize") Integer pageSize);
	//修改最大最小库存量
	@Update("update Productinventory set maxCount=#{maxCount},minCount=#{minCount} where productId=#{productId}")
	Integer updateI(Productinventory productinventory);
	//修改库存总量
	@Update("update Productinventory set totalCount=#{totalCount} where productId=#{productId}")
	Integer updateIC(Productinventory productinventory);
	
}
