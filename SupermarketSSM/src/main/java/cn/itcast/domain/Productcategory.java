package cn.itcast.domain;

/**
 * Productcategory entity. @author MyEclipse Persistence Tools
 */

public class Productcategory implements java.io.Serializable {

	// Fields

	private Integer categoryId;
	private String categoryName;

	// Constructors

	/** default constructor */
	public Productcategory() {
	}

	/** full constructor */
	public Productcategory(String categoryName) {
		this.categoryName = categoryName;
	}

	// Property accessors

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}