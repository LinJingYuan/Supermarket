package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.itcast.domain.ShippingAddress;
import cn.itcast.service.IShippingAddressService;
import cn.itcast.vo.Bsgrid;
import cn.itcast.vo.JsonReturn;

@Controller
@RequestMapping("/app/shippingAddress")
public class AppShippingAddressController {
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	@Autowired
	IShippingAddressService shippingAddressService;
	//新增收货地址
	@ResponseBody
	@RequestMapping(value = "/insertShippingAddress", produces = "application/json;charset=UTF-8")
	public Object insertShippingAddress(ShippingAddress shippingAddress) {
		JsonReturn jsonReturn = new JsonReturn();

		if (shippingAddress!=null) {
			if (shippingAddress.getIsDefault()==true) {
				Integer intRun= this.shippingAddressService.updateIsDefault(shippingAddress);
			}
			Integer intR = this.shippingAddressService.insertShippingAddress(shippingAddress);
			if (intR == 1) {
				jsonReturn.setCode(200);
				jsonReturn.setText("添加收货地址成功");
			} else {
				jsonReturn.setCode(300);
				jsonReturn.setText("添加收货地址失败");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("参数异常");
		}

		return gson.toJson(jsonReturn);
	}
	
	//查询用户的所有收货地址
	@ResponseBody
	@RequestMapping(value = "/selectShippingAddress", produces = "application/json;charset=UTF-8")
	public Object selectShippingAddress(Integer memberId,Integer currentPage,Integer pageSize) {
		Integer account= shippingAddressService.selectShippingAddressAccount(memberId,pageSize);
		Integer startIndex = (currentPage-1)*pageSize;
		Bsgrid<ShippingAddress> bsgrid = new Bsgrid<ShippingAddress>();
		List<ShippingAddress> listSA = shippingAddressService.selectShippingAddress(memberId,startIndex,pageSize);
		bsgrid.setCurrentPage(currentPage);
		bsgrid.setPageSize(pageSize);
		bsgrid.setTotalRows(account);
		bsgrid.setCurPage(pageSize);
		bsgrid.setData(listSA);
		bsgrid.setSuccess(true);
		// 返回JSON
		return gson.toJson(bsgrid);
	}
	
	//新增收货地址
	@ResponseBody
	@RequestMapping(value = "/updateShippingAddress", produces = "application/json;charset=UTF-8")
	public Object updateShippingAddress(ShippingAddress shippingAddress) {
		JsonReturn jsonReturn = new JsonReturn();

		if (shippingAddress!=null) {
			if (shippingAddress.getIsDefault()==true) {
				Integer intRun= this.shippingAddressService.updateIsDefault(shippingAddress);
			}
			Integer intR = this.shippingAddressService.updateShippingAddress(shippingAddress);
			if (intR == 1) {
				jsonReturn.setCode(200);
				jsonReturn.setText("编辑收货地址成功");
			} else {
				jsonReturn.setCode(300);
				jsonReturn.setText("编辑收货地址失败");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("参数异常");
		}

		return gson.toJson(jsonReturn);
	}
	
	//新增收货地址
	@ResponseBody
	@RequestMapping(value = "/deleteShippingAddress", produces = "application/json;charset=UTF-8")
	public Object deleteShippingAddress(ShippingAddress shippingAddress) {
		JsonReturn jsonReturn = new JsonReturn();

		if (shippingAddress!=null) {
			
			Integer intR = this.shippingAddressService.deleteShippingAddress(shippingAddress);
			if (intR == 1) {
				jsonReturn.setCode(200);
				jsonReturn.setText("删除收货地址成功");
			} else {
				jsonReturn.setCode(300);
				jsonReturn.setText("删除收货地址失败");
			}
		} else {
			jsonReturn.setCode(500);
			jsonReturn.setText("参数异常");
		}

		return gson.toJson(jsonReturn);
	}	

}
