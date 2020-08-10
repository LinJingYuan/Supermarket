package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import cn.itcast.domain.Loginlogs;
import cn.itcast.vo.XSCount;

@Repository
public interface IFindInformationDao {
	
	//查询日志信息总条数
	@Select("select count(*) count from Loginlogs order by logId limit 0,#{pageSize}")
	Integer Laccount(Integer pageSize);
	
	//查询日志信息模糊查询总条数
	Integer Maccount(@Param("begintime") String begintime,@Param("endtime") String endtime,@Param("pageSize") Integer pageSize);
	
	//查询日志信息
	List<Loginlogs> selectLoginlogs(@Param("begintime") String begintime,@Param("endtime") String endtime ,@Param("startIndex") Integer startIndex ,@Param("pageSize") Integer pageSize);
	
	//查询销售统计总条数
	Integer Saccount(@Param("begintime") String begintime,@Param("endtime") String endtime,@Param("pageSize") Integer pageSize);
	
	//查询销售统计
	List<XSCount> selectSaleslist(@Param("begintime") String begintime,@Param("endtime") String endtime ,@Param("startIndex") Integer startIndex ,@Param("pageSize") Integer pageSize);
}
