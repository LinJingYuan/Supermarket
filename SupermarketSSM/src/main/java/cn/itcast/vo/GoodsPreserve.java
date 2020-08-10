package cn.itcast.vo;


public class GoodsPreserve implements java.io.Serializable{

	private String productId;
	private String productName;
	private String unit;
	private Double unitPrice;
	private Integer discount;
	private Integer categoryId;
	private Integer totalCount;
	private String categoryName;
	
	public GoodsPreserve(){
		
	}
	
	public GoodsPreserve(String productId,String productName,  String unit,Double unitPrice,
			Integer discount, Integer categoryId,Integer totalCount,String categoryName) {
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.discount = discount;
		this.categoryId = categoryId;
		this.totalCount = totalCount;
		this.categoryName = categoryName;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
