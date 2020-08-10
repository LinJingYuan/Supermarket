package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;

public class MessagesRecord implements Serializable{
	
	private Integer eecordId;
	private String phoneNumber;
	private String derviceUUId;
	private Date sendTime;
	private Boolean IsEnabled;
	public Integer getEecordId() {
		return eecordId;
	}
	public void setEecordId(Integer eecordId) {
		this.eecordId = eecordId;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDerviceUUId() {
		return derviceUUId;
	}
	public void setDerviceUUId(String derviceUUId) {
		this.derviceUUId = derviceUUId;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Boolean getIsEnabled() {
		return IsEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		IsEnabled = isEnabled;
	}
	
}
