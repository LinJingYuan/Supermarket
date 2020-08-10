package cn.itcast.domain;

/**
 * Sysadmins entity. @author MyEclipse Persistence Tools
 */

public class Sysadmins implements java.io.Serializable {

	// Fields

	private Integer loginId;
	private String loginPwd;
	private String adminName;
	private String adminStatus;
	private Integer roleId;

	// Constructors

	/** default constructor */
	public Sysadmins() {
	}

	/** full constructor */
	public Sysadmins(String loginPwd, String adminName, String adminStatus,
			Integer roleId) {
		this.loginPwd = loginPwd;
		this.adminName = adminName;
		this.adminStatus = adminStatus;
		this.roleId = roleId;
	}

	// Property accessors

	public Integer getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminStatus() {
		return this.adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}