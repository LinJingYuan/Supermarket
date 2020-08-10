package cn.itcast.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Orderform implements Serializable{
	private Integer orderFormId;
	private String orderFormNumber;
	private Integer memberId;
	private String transactionNumber;
	private Timestamp createTime;
	private Timestamp paymentTime;
	private Timestamp shipmentsTime;
	private Timestamp turnoverTime;
	private Integer earnPoint;
	private String modeOfDistribution;
	private String consignee;
	private String consigneePhone;
	private String consigneeAddress;
	private String consigner;
	private String consignerPhone;
	private String consignerAddress;
	private String state;
	
	public Integer getOrderFormId() {
		return orderFormId;
	}
	public void setOrderFormId(Integer orderFormId) {
		this.orderFormId = orderFormId;
	}
	public String getOrderFormNumber() {
		return orderFormNumber;
	}
	public void setOrderFormNumber(String orderFormNumber) {
		this.orderFormNumber = orderFormNumber;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}
	public Timestamp getShipmentsTime() {
		return shipmentsTime;
	}
	public void setShipmentsTime(Timestamp shipmentsTime) {
		this.shipmentsTime = shipmentsTime;
	}
	public Timestamp getTurnoverTime() {
		return turnoverTime;
	}
	public void setTurnoverTime(Timestamp turnoverTime) {
		this.turnoverTime = turnoverTime;
	}
	public Integer getEarnPoint() {
		return earnPoint;
	}
	public void setEarnPoint(Integer earnPoint) {
		this.earnPoint = earnPoint;
	}
	public String getModeOfDistribution() {
		return modeOfDistribution;
	}
	public void setModeOfDistribution(String modeOfDistribution) {
		this.modeOfDistribution = modeOfDistribution;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getConsigner() {
		return consigner;
	}
	public void setConsigner(String consigner) {
		this.consigner = consigner;
	}
	public String getConsignerPhone() {
		return consignerPhone;
	}
	public void setConsignerPhone(String consignerPhone) {
		this.consignerPhone = consignerPhone;
	}
	public String getConsignerAddress() {
		return consignerAddress;
	}
	public void setConsignerAddress(String consignerAddress) {
		this.consignerAddress = consignerAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
