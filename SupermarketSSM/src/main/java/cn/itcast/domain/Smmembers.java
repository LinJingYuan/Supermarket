package cn.itcast.domain;

import java.util.Date;

/**
 * Smmembers entity. @author MyEclipse Persistence Tools
 */

public class Smmembers implements java.io.Serializable {

	// Fields

	private Integer memberId;
	private String UPassword;
	private String memberName;
	private Boolean sex;
	private String photo;
	private Integer points;
	private String phoneNumber;
	private String memberAddress;
	private Date openTime;
	

	private Integer memberStatus;

	// Constructors

	/** default constructor */
	public Smmembers() {
	}

	/** full constructor */
	public Smmembers(String UPassword,String memberName,Boolean sex,String photo, Integer points, String phoneNumber,
			String memberAddress, Date openTime, Integer memberStatus) {
		this.UPassword = UPassword;
		this.memberName = memberName;
		this.sex = sex;
		this.photo = photo;
		this.points = points;
		this.phoneNumber = phoneNumber;
		this.memberAddress = memberAddress;
		this.openTime = openTime;
		this.memberStatus = memberStatus;
	}

	// Property accessors
	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	
	public String getUPassword() {
		return UPassword;
	}

	public void setUPassword(String uPassword) {
		UPassword = uPassword;
	}
	
	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMemberAddress() {
		return this.memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Integer getMemberStatus() {
		return this.memberStatus;
	}

	public void setMemberStatus(Integer memberStatus) {
		this.memberStatus = memberStatus;
	}

}