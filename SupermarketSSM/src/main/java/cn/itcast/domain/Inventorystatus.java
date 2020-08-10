package cn.itcast.domain;

/**
 * Inventorystatus entity. @author MyEclipse Persistence Tools
 */

public class Inventorystatus implements java.io.Serializable {

	// Fields

	private Integer statusId;
	private String statusDesc;

	// Constructors

	/** default constructor */
	public Inventorystatus() {
	}

	/** full constructor */
	public Inventorystatus(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	// Property accessors

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}