package cn.itcast.domain;

import java.sql.Timestamp;

/**
 * Loginlogs entity. @author MyEclipse Persistence Tools
 */

public class Loginlogs implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer loginId;
	private String spname;
	private String serverName;
	private Timestamp loginTime;
	private Timestamp exitTime;

	// Constructors

	/** default constructor */
	public Loginlogs() {
	}

	/** full constructor */
	public Loginlogs(Integer loginId, String spname, String serverName,
			Timestamp loginTime, Timestamp exitTime) {
		this.loginId = loginId;
		this.spname = spname;
		this.serverName = serverName;
		this.loginTime = loginTime;
		this.exitTime = exitTime;
	}

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getSpname() {
		return this.spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getExitTime() {
		return this.exitTime;
	}

	public void setExitTime(Timestamp exitTime) {
		this.exitTime = exitTime;
	}

}