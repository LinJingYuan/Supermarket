package cn.itcast.domain;

/**
 * Salesperson entity. @author MyEclipse Persistence Tools
 */

public class Salesperson implements java.io.Serializable {

	// Fields

	private Integer salesPersonId;
	private String spname;
	private String loginPwd;

	// Constructors

	/** default constructor */
	public Salesperson() {
	}

	/** full constructor */
	public Salesperson(String spname, String loginPwd) {
		this.spname = spname;
		this.loginPwd = loginPwd;
	}

	// Property accessors

	public Integer getSalesPersonId() {
		return this.salesPersonId;
	}

	public void setSalesPersonId(Integer salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	public String getSpname() {
		return this.spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}