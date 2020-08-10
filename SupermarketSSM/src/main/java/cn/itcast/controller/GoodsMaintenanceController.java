package cn.itcast.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.Productinventory;
import cn.itcast.domain.Products;
import cn.itcast.domain.Productstorage;
import cn.itcast.service.IGoodsMaintenanceService;
import cn.itcast.vo.Bsgrid;
import cn.itcast.vo.GoodsPreserve;

/**
 * 商品维护
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/goodsMaintenance")
public class GoodsMaintenanceController {
	@Autowired
	IGoodsMaintenanceService gms;

	//---------------新增商品
	@RequestMapping("/insertProduct")
	public @ResponseBody Object insertProduct(Products products,Productinventory productinventory){
		Integer message;
		if (products==null) {
			message = 0;
			return message;
		}else if(productinventory == null) {
			message = 0;
			return message;
		}else {
			products.setDiscount(0);
			productinventory.setStatusId(1);
			productinventory.setProductId(products.getProductId());
			productinventory.setTotalCount(0);
			message = gms.insertProducts(products);
			message = gms.insertProductinventory(productinventory);
		}
		return message;
	}
	
	//---------------查询商品信息
	@RequestMapping("/selectSPData")
	public @ResponseBody Object selectSPData(Integer curPage,Integer pageSize,String productId,String productName,Integer categoryId){
		if (productId!=null&&!"".equals(productId)) {
			productId = "%"+ productId +"%";
		}
		if (productName!=null&&!"".equals(productName)) {
			productName = "%"+ productName +"%";
		}
		if (curPage==null) {
			curPage=1;
		}
		if (pageSize==null) {
			pageSize=5;
		}
		Integer startIndex = (curPage-1)*pageSize;
		Integer account=0;
		if(productId!=null||productName!=null||categoryId!=null){
			account = gms.spMAccount(productId,productName,categoryId,pageSize);
		}else{
			account = gms.spSAccount(pageSize);
		}
		Bsgrid<GoodsPreserve> bsgrid = new Bsgrid<GoodsPreserve>();
		List<GoodsPreserve> listGP = gms.selectGMs(productId,productName,categoryId,startIndex,pageSize);
		bsgrid.setTotalRows(account);
		bsgrid.setSuccess(true);
		bsgrid.setCurPage(pageSize);
		bsgrid.setData(listGP);
		return bsgrid;
	}
	
	//---------------根据商品编码查询商品名称
	@RequestMapping("/selectsName")
	public @ResponseBody Object selectsName(Products products,String productId,String productName){
		products = gms.selectSPName(productId);
		if (products!=null) {
			productName = products.getProductName();
		}else{
			productName=null;
		}
		return productName;
	}
	//商品入库
	@RequestMapping("/commodityStorage")
	public @ResponseBody Object commodityStorage(Productinventory productinventory,String productName){
		Integer message=0;
		if(productName!=null&&productinventory!=null){
			//新增入库信息
			Productstorage productstorage = new Productstorage();
			try {
				productstorage.setProductId(productinventory.getProductId());
				productstorage.setAddedCount(productinventory.getTotalCount());
				Date date = new Date();
				SimpleDateFormat dateFormat1=new SimpleDateFormat("yyyy‐MM‐dd HH:mm:ss");
				String str = dateFormat1.format(date);
				dateFormat1.format(dateFormat1.parse(str).getTime());
				productstorage.setCurrentTime(new Timestamp(dateFormat1.parse(str).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Integer rinsertP=gms.insertP(productstorage);
			if(rinsertP>0){
				Integer totalCount=gms.selectTotalCount(productinventory.getProductId())+productinventory.getTotalCount();
				productinventory.setTotalCount(totalCount);
				message = gms.cStorage(productinventory);
			}
		}else{
			message = 0;
		}
		return message;
	}
	
	//修改商品信息
	@RequestMapping("/updateSP")
	public @ResponseBody Object updateSP(Products products){
		Integer message;
		if(products!=null){
			message = gms.updateProducts(products);
		}else{
			message= 0;
		}
		return message;
	}
	//删除商品信息
	@RequestMapping("/deleteProduct")
	public @ResponseBody Object deleteProduct(String productId){
		Integer message;
		if(productId!=null){
			message = gms.deleteProducts(productId);
		}else{
			message = 0;
		}
		
		return message;
	}
	//修改商品折扣
	@RequestMapping("/updateDiscount")
	public @ResponseBody Object updateDiscount(Products products){
		Integer message;
		if(products.getProductId().trim()!=null&&products.getDiscount()!=null){
			message = gms.updateDiscounts(products);
		}else{
			message = 0;
		}
		return message;
	}
	
}
