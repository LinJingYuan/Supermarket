package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
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

@Repository
public interface IUserDao {
	//用户登录
	@Select("select * from Sysadmins where LoginId=#{loginId}")
	Sysadmins login(Sysadmins user);
	
	//商品分类
	@Select("select * from Productcategory")
	List<Productcategory> category();
	
	//商品计量单位
	@Select("select * from Productunit")
	List<Productunit> unit();
	
	//根据用户id查询用户信息
	@Select("select * from Sysadmins where loginId=#{loginId}")
	Sysadmins selectSysadmins(Integer loginId);
	
	//修改用户密码
	@Update("update Sysadmins set loginPwd=#{loginPwd} where loginId=#{loginId}")
	Integer updateP(Sysadmins sysadmins);
	
	//新增登录记录
	Integer insertLoginlogs(Loginlogs loginlogs);
	
	//修改退出系统时间
	@Update("update Loginlogs set exitTime=#{exitTime} where logId=#{logId}")
	Integer updateTime(Loginlogs loginlogs);
	
	//前台登录
	@Select("select * from Salesperson where salesPersonId=#{salesPersonId}")
	Salesperson frontDeskLogin(Salesperson user);
	
	//查询商品信息
	@Select("select * from Products where productId=#{productId}")
	Products selectProducts(String productId);
	
	//销售流水账
	@Select("select * from Saleslist where serialNum=#{serialNum}")
	Saleslist selectSaleslist(Saleslist saleslist);
	
	//商品库存信息
	@Select("select * from Productinventory where productId=#{productId}")
	Productinventory selectProductinventory(String productId);
	
	//新增销售记录
	@Insert("insert into Saleslist(serialNum,totalMoney,realReceive,returnMoney,salesPersonId,saleDate) values(#{serialNum},#{totalMoney},#{realReceive},#{returnMoney},#{salesPersonId},#{saleDate})")
	Integer insertSaleslist(Saleslist saleslist);
	
	//查询会员信息
	@Select("select * from Smmembers where memberId=#{memberId}")
	Smmembers selectSmmembers(String memberId);
	
	//修改会员的积分
	@Update("update Smmembers set points=#{points} where memberId=#{memberId}")
	Integer updateSmmembers(Smmembers smmembers);
	
	//新增销售流水账明细
	@Insert("insert into Saleslistdetail(serialNum,productId,productName,unitPrice,discount,quantity,subTotalMoney) values(#{serialNum},#{productId},#{productName},#{unitPrice},#{discount},#{quantity},#{subTotalMoney})")
	Integer insertSaleslistdetail(Saleslistdetail saleslistdetail);
	
	//修改库存数量与状态
	@Update("update Productinventory set totalCount=#{totalCount},statusId=#{statusId} where productId=#{productId}")
	Integer updateProductinventory(Productinventory productinventory);
}
