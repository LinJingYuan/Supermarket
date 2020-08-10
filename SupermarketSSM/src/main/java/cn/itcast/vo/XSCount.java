package cn.itcast.vo;

import java.io.Serializable;

public class XSCount implements Serializable{
	
	private String productId;
	private String productName;
	private String categoryName;
	private String unit;
	private String quantity;
	public XSCount() {
		// TODO Auto-generated constructor stub
	}
	
	public XSCount(String productId, String productName, String categoryName, 
			String unit,String quantity) {
		this.productId = productId;
		this.productName = productName;
		this.categoryName = categoryName;
		this.unit = unit;
		this.quantity = quantity;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
