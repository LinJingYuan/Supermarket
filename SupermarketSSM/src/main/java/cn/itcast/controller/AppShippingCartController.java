package cn.itcast.controller;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import cn.itcast.domain.Orderform;
import cn.itcast.domain.OrderformCommodity;
import cn.itcast.domain.ShippingAddress;
import cn.itcast.service.IAppShippingCartService;
import cn.itcast.vo.Bsgrid;
import cn.itcast.vo.CartVo;
import cn.itcast.vo.JsonReturn;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/app/shippingCart")
public class AppShippingCartController {
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	@Autowired
	IAppShippingCartService appShippingCartService;
	//查询用户的购物车
	@ResponseBody
	@RequestMapping(value = "/selectCartVo", produces = "application/json;charset=UTF-8")
	public Object selectCartVo(Integer memberId,Integer currentPage,Integer pageSize) {
		Integer account= appShippingCartService.selectShippingCartAccount(memberId,pageSize);
		Integer startIndex = (currentPage-1)*pageSize;
		Bsgrid<CartVo> bsgrid = new Bsgrid<CartVo>();
		List<CartVo> listSA = appShippingCartService.selectShippingCart(memberId,startIndex,pageSize);
		bsgrid.setCurrentPage(currentPage);
		bsgrid.setPageSize(pageSize);
		bsgrid.setTotalRows(account);
		bsgrid.setCurPage(pageSize);
		bsgrid.setData(listSA);
		bsgrid.setSuccess(true);
		// 返回JSON
		return gson.toJson(bsgrid);
	}
	//购物车商品数量的变动
	@ResponseBody
	@RequestMapping(value = "/updateProductNumber", produces = "application/json;charset=UTF-8")
	public Object updateProductNumber(Integer cartId,Integer productNumber) {
		Integer account= appShippingCartService.updateProductNumber(cartId,productNumber);
		JsonReturn jsonReturn = new JsonReturn();
		if(account==1){
			jsonReturn.setCode(200);
		}else{
			jsonReturn.setCode(300);
		}
		// 返回JSON
		return gson.toJson(jsonReturn);
	}
	
	//删除加入购物车的商品
	@ResponseBody
	@RequestMapping(value = "/deleteCart", produces = "application/json;charset=UTF-8")
	public Object deleteCart(Integer cartId) {
		Integer account= appShippingCartService.deleteCart(cartId);
		JsonReturn jsonReturn = new JsonReturn();
		if(account==1){
			jsonReturn.setCode(200);
		}else{
			jsonReturn.setCode(300);
		}
		// 返回JSON
		return gson.toJson(jsonReturn);
	}
	
	//结算默认收货地址
	@ResponseBody
	@RequestMapping(value = "/selectAddress", produces = "application/json;charset=UTF-8")
	public Object selectAddress(Integer memberId) {
		ShippingAddress sa= appShippingCartService.selectAddress(memberId);
		JsonReturn jsonReturn = new JsonReturn();
		if(sa!=null){
			jsonReturn.setCode(200);
			jsonReturn.setData(sa);
		}else{
			jsonReturn.setCode(300);
		}
		// 返回JSON
		return gson.toJson(jsonReturn);
	}
	
	//提交订单
	@ResponseBody
	@RequestMapping(value = "/insertOFOC", produces = "application/json;charset=UTF-8")
	public Object insertOFOC(Orderform orderform,String temporaryCartVo) {
		JsonReturn jsonReturn = new JsonReturn();
        Type type = new TypeToken<List<CartVo>>() {}.getType();
        List<CartVo> temporary = gson.fromJson(temporaryCartVo, type);
        Date date = new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy‐MM‐dd HH:mm:ss");
        String str = dateFormat.format(date);
        try {
        	dateFormat.format(dateFormat.parse(str).getTime());
        	orderform.setPaymentTime(new Timestamp(dateFormat.parse(str).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        orderform.setState("2");
        //保存订单
        Integer retrun = appShippingCartService.insertOrderform(orderform);
        if(retrun==1){
        	OrderformCommodity orderformCommodity = new OrderformCommodity();
            //保存订单购买的商品
            for (int i = 0; i < temporary.size(); i++) {
            	orderformCommodity.setDiscount(temporary.get(i).getDiscount());
            	orderformCommodity.setOrderFormNumber(orderform.getOrderFormNumber());
            	orderformCommodity.setProductId(temporary.get(i).getProductId());
            	orderformCommodity.setProductNumber(temporary.get(i).getProductNumber().toString());
            	orderformCommodity.setUnitPrice(temporary.get(i).getUnitPrice());
    			
    		}
        }
        
		return "";
		/*ShippingAddress sa= appShippingCartService.selectAddress(memberId);
		JsonReturn jsonReturn = new JsonReturn();
		if(sa!=null){
			jsonReturn.setCode(200);
			jsonReturn.setData(sa);
		}else{
			jsonReturn.setCode(300);
		}
		// 返回JSON
		return gson.toJson(jsonReturn);*/
	}
}
