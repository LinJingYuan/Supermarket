package cn.itcast.vo;

import java.io.Serializable;

public class CommodityI implements Serializable{
	private String productId;
	private String productName;
	private Integer categoryId;
	private Integer totalCount;
	private String unit;
	private Integer minCount;
	private Integer maxCount;
	private Integer statusId;
	
	public CommodityI() {
		// TODO Auto-generated constructor stub
	}
	
	public CommodityI(String productId, String productName, Integer categoryId,
			Integer totalCount, String unit, Integer minCount,
			Integer maxCount, Integer statusId) {
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.totalCount = totalCount;
		this.unit = unit;
		this.minCount = minCount;
		this.maxCount = maxCount;
		this.statusId = statusId;
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

	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getMinCount() {
		return minCount;
	}
	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}
	public Integer getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
}
