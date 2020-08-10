package cn.itcast.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.Loginlogs;
import cn.itcast.service.IFindInformationService;
import cn.itcast.vo.Bsgrid;
import cn.itcast.vo.XSCount;

@Controller
@RequestMapping("/findInformation")
public class FindInformationController {
	
	@Autowired
	IFindInformationService findInformationService;
	
	@RequestMapping("/selectLoginlogs")
	public @ResponseBody Object selectLoginlogs(Integer curPage,Integer pageSize,String begintime,String endtime){
		
		if (curPage==null) {
			curPage=1;
		}
		
		if (pageSize==null) {
			pageSize=5;
		}
		Integer startIndex = (curPage-1)*pageSize;
		Integer account=0;
		if (begintime!=null||endtime!=null) {			
			account = findInformationService.Maccount(begintime,endtime, pageSize);
		}else{
			account = findInformationService.Laccount(pageSize);
		}
		
		Bsgrid<Loginlogs> bsgrid = new Bsgrid<Loginlogs>();
		List<Loginlogs> listLoginlogs = findInformationService.selectLoginlogs(begintime,endtime, startIndex, pageSize);
		bsgrid.setTotalRows(account);
		bsgrid.setData(listLoginlogs);
		bsgrid.setSuccess(true);
		bsgrid.setCurPage(pageSize);

		return bsgrid;
	}
	
	@RequestMapping("/selectSaleslist")
	public @ResponseBody Object selectSaleslist(Integer curPage,Integer pageSize,String begintime,String endtime){
		
		if (curPage==null) {
			curPage=1;
		}

		if (pageSize==null) {
			pageSize=5;
		}
		Integer startIndex = (curPage-1)*pageSize;
		String selectL="";
		Integer account=findInformationService.Saccount(begintime,endtime, pageSize);
		Bsgrid<XSCount> bsgrid = new Bsgrid<XSCount>();
		List<XSCount> listXSCount = findInformationService.selectSaleslist(begintime,endtime, startIndex, pageSize);
		bsgrid.setSuccess(true);
		bsgrid.setTotalRows(account);
		bsgrid.setData(listXSCount);
		bsgrid.setCurPage(pageSize);
		
		return bsgrid;
	}
	
	
}
