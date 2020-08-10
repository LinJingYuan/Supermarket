package cn.itcast.domain;

import java.sql.Timestamp;

/**
 * Saleslist entity. @author MyEclipse Persistence Tools
 */

public class Saleslist implements java.io.Serializable {

	// Fields

	private String serialNum;
	private Double totalMoney;
	private Double realReceive;
	private Double returnMoney;
	private Integer salesPersonId;
	private Timestamp saleDate;

	// Constructors

	/** default constructor */
	public Saleslist() {
	}

	/** full constructor */
	public Saleslist(Double totalMoney, Double realReceive, Double returnMoney,
			Integer salesPersonId, Timestamp saleDate) {
		this.totalMoney = totalMoney;
		this.realReceive = realReceive;
		this.returnMoney = returnMoney;
		this.salesPersonId = salesPersonId;
		this.saleDate = saleDate;
	}

	// Property accessors

	public String getSerialNum() {
		return this.serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Double getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getRealReceive() {
		return this.realReceive;
	}

	public void setRealReceive(Double realReceive) {
		this.realReceive = realReceive;
	}

	public Double getReturnMoney() {
		return this.returnMoney;
	}

	public void setReturnMoney(Double returnMoney) {
		this.returnMoney = returnMoney;
	}

	public Integer getSalesPersonId() {
		return this.salesPersonId;
	}

	public void setSalesPersonId(Integer salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	public Timestamp getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Timestamp saleDate) {
		this.saleDate = saleDate;
	}

}