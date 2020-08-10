package cn.itcast.service.impl;

import java.util.List;

import org.aspectj.bridge.MessageUtil.IMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.ICartDao;
import cn.itcast.dao.IMessagesRecord;
import cn.itcast.dao.ISmmembersDao;
import cn.itcast.domain.Cart;
import cn.itcast.domain.MessagesRecord;
import cn.itcast.domain.Smmembers;
import cn.itcast.service.IAppMemberService;

@Transactional
@Service("appMember")
public class AppMemberServiceImpl implements IAppMemberService{
	@Autowired
	ISmmembersDao smmembersDao;
	@Autowired
	IMessagesRecord iMessagesRecord;
	@Autowired
	ICartDao cartDao;

	@Override
	public List<MessagesRecord> getMRByPhone(String phone) {
		// TODO Auto-generated method stub
		return iMessagesRecord.getMRByPhone(phone);
	}

	@Override
	public List<MessagesRecord> getMRByIsEnabled(String derviceUUId) {
		// TODO Auto-generated method stub
		return iMessagesRecord.getMRByIsEnabled(derviceUUId);
	}
	
	@Override
	public Integer insertMessagesRecord(MessagesRecord messagesRecord) {
		// TODO Auto-generated method stub
		return iMessagesRecord.insertMessagesRecord(messagesRecord);
	}


	@Override
	public Smmembers findSmmembersMyPhone(String phone) {
		// TODO Auto-generated method stub
		return smmembersDao.findSmmembersMyPhone(phone);
	}

	@Override
	public Integer selectMemberId() {
		// TODO Auto-generated method stub
		return smmembersDao.selectMemberId();
	}

	@Override
	public Integer insertSmmembers(Smmembers smmembers) {
		// TODO Auto-generated method stub
		return smmembersDao.insertSmmembers(smmembers);
	}

	@Override
	public Integer updateSmmembersById(Smmembers smmembers) {
		// TODO Auto-generated method stub
		return smmembersDao.updateSmmembersById(smmembers);
	}

	@Override
	public Integer insertCartTable(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.insertCartTable(cart);
	}

	@Override
	public Cart selectCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.selectCart(cart);
	}

	@Override
	public Integer updateCartPN(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.updateCartPN(cart);
	}

	@Override
	public Integer updatePassword(String newPassword, Integer memberId) {
		// TODO Auto-generated method stub
		return smmembersDao.updatePassword(newPassword, memberId);
	}

	@Override
	public Smmembers selectMemberById(Integer memberId) {
		// TODO Auto-generated method stub
		return smmembersDao.selectMemberById(memberId);
	}

	@Override
	public Integer updateMemberById(Smmembers member) {
		// TODO Auto-generated method stub
		return smmembersDao.updateMemberById(member);
	}

	@Override
	public Integer updateSexById(Smmembers member) {
		// TODO Auto-generated method stub
		return smmembersDao.updateSexById(member);
	}

	
}
