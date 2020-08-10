package cn.itcast.domain;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */

public class Products implements java.io.Serializable {

	// Fields

	private String productId;
	private String productName;
	private Double unitPrice;
	private String unit;
	private Integer discount;
	private Integer categoryId;

	// Constructors

	/** default constructor */
	public Products() {
	}

	/** full constructor */
	public Products(String productName, Double unitPrice, String unit,
			Integer discount, Integer categoryId) {
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.discount = discount;
		this.categoryId = categoryId;
	}

	// Property accessors

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}