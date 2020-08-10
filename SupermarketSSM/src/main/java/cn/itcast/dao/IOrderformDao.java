package cn.itcast.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.Orderform;

@Repository
public interface IOrderformDao {
	//添加订单
	@Insert("Insert into Orderform(orderFormNumber,memberId,transactionNumber,createTime,paymentTime,shipmentsTime,"
			+ "turnoverTime,earnPoint,modeOfDistribution,consignee,"
			+ "consigneePhone,consigneeAddress,consigner,consignerPhone,consignerAddress,state) "
			+ "values(#{orderFormNumber},#{memberId},#{transactionNumber},#{createTime},#{paymentTime},#{shipmentsTime},"
			+ "#{turnoverTime},#{earnPoint},#{modeOfDistribution},#{consignee},"
			+ "#{consigneePhone},#{consigneeAddress},#{consigner},#{consignerPhone},#{consignerAddress},#{state})")
	Integer insertOrderform(Orderform orderform);
}
