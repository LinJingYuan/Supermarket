package cn.itcast.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

public interface IUserService {
	//后台登录
	Sysadmins login(Sysadmins user);
	//商品分类
	List<Productcategory> category();
	//商品计量单位
	List<Productunit> unit();
	//根据用户id查询用户信息
	Sysadmins selectSQLQuery(Integer loginId);
	//修改用户密码
	Integer updateP(Sysadmins sysadmins);
	//新增登录记录
	Integer insertLoginlogs(Loginlogs loginlogs);
	//修改退出系统时间
	Integer updateTime(Loginlogs loginlogs);
	//前台登录
	Salesperson frontDeskLogin(Salesperson user);
	//查询商品信息
	Products selectProducts(String productId);
	//销售流水账
	Saleslist selectSaleslist(Saleslist saleslist);
	//商品库存信息
	Productinventory selectProductinventory(String productId);
	//新增销售记录
	Integer insertSaleslist(Saleslist saleslist);
	//查询会员信息
	Smmembers selectSmmembers(String memberId);
	//修改会员的积分
	Integer updateSmmembers(Smmembers smmembers);
	//新增销售流水账明细
	Integer insertSaleslistdetail(Saleslistdetail saleslistdetail);
	//修改库存数量与状态
	Integer updateProductinventory(Productinventory productinventory);
}
