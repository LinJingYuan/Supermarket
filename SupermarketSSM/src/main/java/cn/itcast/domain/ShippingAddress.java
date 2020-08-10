package cn.itcast.domain;

public class ShippingAddress implements java.io.Serializable {
	private Integer shippingAddressId;
	private Integer memberId;
	private String name;
	private String phone;
	private String address;
	private Boolean isDefault;
	
	public ShippingAddress() {
	}

	public ShippingAddress(Integer shippingAddressId, Integer memberId, String name,String phone,String address,Boolean isDefault) {
		this.shippingAddressId = shippingAddressId;
		this.memberId = memberId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.isDefault = isDefault;
	}
	
	
	public Integer getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(Integer shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	
}
