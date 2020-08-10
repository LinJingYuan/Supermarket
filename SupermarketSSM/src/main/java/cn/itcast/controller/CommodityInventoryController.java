package cn.itcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.common.SelectParam;
import cn.itcast.domain.Productinventory;
import cn.itcast.service.ICommodityInventoryService;
import cn.itcast.vo.Bsgrid;
import cn.itcast.vo.CommodityI;

@Controller
@RequestMapping("/commodityInventory")
public class CommodityInventoryController {
	@Autowired
	ICommodityInventoryService cis;
	
	/*
	private Integer curPage;
	private Integer pageSize;
	private SelectParam selectParam;
	private String productId;//商品编号
	private String productName;//商品名称
	private Integer categoryId;//商品分类
	private Integer warningCount;//总预警数
	private Integer upperLimit;//超库存上限
	private Integer floor;//低于库存下限
	
	private Productinventory productinventory;
	//返回值信息
	private Integer message;
	private Boolean success;
	private Integer totalRows;
	private List<CommodityI> data;
	*/	
	//查询库存信息
	@RequestMapping("/selectProductinventory")
	public @ResponseBody Object selectProductinventory(String productId,String productName,Integer categoryId
			,Integer warningCount,Integer upperLimit,Integer floor,Integer curPage,Integer pageSize){
		if (productId!=null&&!"".equals(productId)) {
			productId = "%"+productId+"%";
		}
		if (productName!=null&&!"".equals(productName)) {
			productName = "%"+productName+"%";
		}
		if (curPage==null) {
			curPage=1;
		}
		if (pageSize==null) {
			pageSize=5;
		}
		Integer startIndex = (curPage-1)*pageSize;
		Bsgrid<CommodityI> bsgrid = new Bsgrid<CommodityI>();
		bsgrid.setTotalRows(cis.selectCIAccount(productId,productName,categoryId,warningCount,upperLimit,floor,pageSize));
		bsgrid.setData(cis.selectCI(productId,productName,categoryId,warningCount,upperLimit,floor,startIndex, pageSize));
		bsgrid.setSuccess(true);
		bsgrid.setCurPage(pageSize);
		return bsgrid;
	}
	
	//更新库存
	@RequestMapping("/updateInventory")
	public @ResponseBody Object updateInventory(Productinventory productinventory){
		Integer message;
		Productinventory pro = new Productinventory();
		pro = productinventory;
		if(pro.getProductId()!=null){
			if(pro.getMaxCount()!=null||pro.getMinCount()!=null){
				message = cis.updateI(pro);
			}else{
				message = 0;
			}
		}else{
			message = 0;
		}
		
		return message;
	}
	
	//更新库存总数
	@RequestMapping("/updateICount")
	public @ResponseBody Object updateICount(Productinventory productinventory){
		Integer message;
		Productinventory pro = new Productinventory();
		pro = productinventory;
		if(pro.getProductId()!=null){
			if(pro.getTotalCount()!=null){
				message = cis.updateIC(pro);
			}else{
				message = 0;
			}
		}else{
			message = 0;
		}
		return message;
	}
	
}
