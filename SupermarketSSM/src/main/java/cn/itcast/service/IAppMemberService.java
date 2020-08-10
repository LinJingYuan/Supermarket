package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Cart;
import cn.itcast.domain.MessagesRecord;
import cn.itcast.domain.Smmembers;

public interface IAppMemberService {
	//根据手机号获取5分钟内短信发送记录
	List<MessagesRecord> getMRByPhone(String phone);
	//根据设备id 获取5分钟内短信发送记录
	List<MessagesRecord> getMRByIsEnabled(String derviceUUId);
	//新增短信发送记录
	Integer insertMessagesRecord(MessagesRecord messagesRecord);
	//根据手机号查询会员
	Smmembers findSmmembersMyPhone(String phone);
	//查找会员卡的最后卡号ID
	Integer selectMemberId();
	//新增会员
	Integer insertSmmembers(Smmembers smmembers);
	//修改用户密码
	Integer updateSmmembersById(Smmembers smmembers);
	//根据会员号和商品编号查询购物车的信息
	Cart selectCart(Cart cart);
	//根据会员号和商品编号修改购物车商品数量
	Integer updateCartPN(Cart cart);
	//修改登录密码
	Integer updatePassword(String newPassword,Integer memberId);
	//根据会员卡号查询会员信息
	Smmembers selectMemberById(Integer memberId);
	//修改头像
	Integer updateMemberById(Smmembers member);
	//修改个人信息(性别)
	Integer updateSexById(Smmembers member);
	//加入购物车
	Integer insertCartTable(Cart cart);
	
}
