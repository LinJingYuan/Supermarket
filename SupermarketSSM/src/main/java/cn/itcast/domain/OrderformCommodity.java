package cn.itcast.domain;

import java.io.Serializable;

public class OrderformCommodity implements Serializable{
	private Integer orderformCommodityId;
	private String orderFormNumber;
	private String ProductId;
	private String productNumber;
	private Double unitPrice;
	private Integer discount;
	public Integer getOrderformCommodityId() {
		return orderformCommodityId;
	}
	public void setOrderformCommodityId(Integer orderformCommodityId) {
		this.orderformCommodityId = orderformCommodityId;
	}
	public String getOrderFormNumber() {
		return orderFormNumber;
	}
	public void setOrderFormNumber(String orderFormNumber) {
		this.orderFormNumber = orderFormNumber;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
}
