package cn.itcast.domain;

public class Cart implements java.io.Serializable {
	private Integer cartId;
	private String memberId;
	private String productId;
	private Integer productNumber;
	
	public Cart() {
	}

	public Cart(Integer cartId, String memberId, String productId,Integer productNumber) {
		this.cartId = cartId;
		this.memberId = memberId;
		this.productId = productId;
		this.productNumber = productNumber;
	}
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	
}
