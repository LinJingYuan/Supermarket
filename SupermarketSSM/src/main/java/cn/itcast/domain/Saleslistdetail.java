package cn.itcast.domain;

/**
 * Saleslistdetail entity. @author MyEclipse Persistence Tools
 */

public class Saleslistdetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private String serialNum;
	private String productId;
	private String productName;
	private Double unitPrice;
	private Integer discount;
	private Integer quantity;
	private Double subTotalMoney;

	// Constructors

	/** default constructor */
	public Saleslistdetail() {
	}

	/** full constructor */
	public Saleslistdetail(String serialNum, String productId,
			String productName, Double unitPrice, Integer discount,
			Integer quantity, Double subTotalMoney) {
		this.serialNum = serialNum;
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.quantity = quantity;
		this.subTotalMoney = subTotalMoney;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerialNum() {
		return this.serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

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

	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubTotalMoney() {
		return this.subTotalMoney;
	}

	public void setSubTotalMoney(Double subTotalMoney) {
		this.subTotalMoney = subTotalMoney;
	}

}