package cn.itcast.domain;

/**
 * Productunit entity. @author MyEclipse Persistence Tools
 */

public class Productunit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String unit;

	// Constructors

	/** default constructor */
	public Productunit() {
	}

	/** full constructor */
	public Productunit(String unit) {
		this.unit = unit;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}