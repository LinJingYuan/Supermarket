package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.MessagesRecord;

@Repository
public interface IMessagesRecord {
	//根据手机号获取5分钟内短信发送记录
	List<MessagesRecord> getMRByPhone(@Param("phone") String phone);
	//根据设备id 获取5分钟内短信发送记录
	@Select("select * from MessagesRecord where sendTime >= DATE_SUB(NOW(),INTERVAL 5 MINUTE) and derviceUUId = #{derviceUUId}")
	List<MessagesRecord> getMRByIsEnabled(@Param("derviceUUId") String derviceUUId);
	//新增短信发送记录
	@Insert("insert into MessagesRecord(phoneNumber,derviceUUId,sendTime,IsEnabled) values(#{phoneNumber},#{derviceUUId},#{sendTime},1)")
	Integer insertMessagesRecord(MessagesRecord messagesRecord);
	
}
