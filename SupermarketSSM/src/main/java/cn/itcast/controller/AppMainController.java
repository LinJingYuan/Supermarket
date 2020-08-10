package cn.itcast.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.itcast.service.IGoodsMaintenanceService;
import cn.itcast.vo.Bsgrid;
import cn.itcast.vo.GoodsPreserve;

/**
 * APP搜索商品页面
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/app/main")
public class AppMainController {
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	@Autowired
	IGoodsMaintenanceService gms;
	
	//搜索商品
	@ResponseBody
	@RequestMapping(value = "/selectProduct", produces = "application/json;charset=UTF-8")
	public Object selectProduct(String productId,String productName,Integer categoryId,Integer currentPage,Integer pageSize) {
		Integer account=0;
		if(productId!=null||productName!=null||categoryId!=null){
			account = gms.spMAccount(productId,productName,categoryId,pageSize);
		}else{
			account = gms.spSAccount(pageSize);
		}
		if (productName!=null&&!"".equals(productName)) {
			productName = "%"+ productName +"%";
		}
		Integer startIndex = (currentPage-1)*pageSize;
		Bsgrid<GoodsPreserve> bsgrid = new Bsgrid<GoodsPreserve>();
		List<GoodsPreserve> listGP = gms.selectGMs(productId,productName,categoryId,startIndex,pageSize);
		bsgrid.setCurrentPage(currentPage);
		bsgrid.setPageSize(pageSize);
		bsgrid.setTotalRows(account);
		bsgrid.setCurPage(pageSize);
		bsgrid.setData(listGP);
		bsgrid.setSuccess(true);
		// 返回JSON
		return gson.toJson(bsgrid);
	}
	
}
