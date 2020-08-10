package cn.itcast.domain;

/**
 * Productinventory entity. @author MyEclipse Persistence Tools
 */

public class Productinventory implements java.io.Serializable {

	// Fields

	private String productId;
	private Integer totalCount;
	private Integer minCount;
	private Integer maxCount;
	private Integer statusId;

	// Constructors

	/** default constructor */
	public Productinventory() {
	}

	/** full constructor */
	public Productinventory(Integer totalCount, Integer minCount,
			Integer maxCount, Integer statusId) {
		this.totalCount = totalCount;
		this.minCount = minCount;
		this.maxCount = maxCount;
		this.statusId = statusId;
	}

	// Property accessors

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getMinCount() {
		return this.minCount;
	}

	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}

	public Integer getMaxCount() {
		return this.maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

}