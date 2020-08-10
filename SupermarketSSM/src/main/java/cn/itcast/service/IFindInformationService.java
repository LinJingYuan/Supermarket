package cn.itcast.service;

import java.util.List;
import cn.itcast.domain.Loginlogs;
import cn.itcast.vo.XSCount;

public interface IFindInformationService {
	//查询日志信息总条数
	Integer Laccount(Integer pageSize);
	
	//查询日志信息模糊查询总条数
	Integer Maccount(String begintime,String endtime,Integer pageSize);
	
	//查询日志信息
	List<Loginlogs> selectLoginlogs(String begintime,String endtime,Integer startIndex,Integer pageSize);
	
	//查询销售统计总条数
	Integer Saccount(String begintime,String endtime,Integer pageSize);
	
	//查询销售统计
	List<XSCount> selectSaleslist(String begintime,String endtime,Integer startIndex ,Integer pageSize);
}	
