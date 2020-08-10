package cn.itcast.domain;

import java.sql.Timestamp;

/**
 * Productstorage entity. @author MyEclipse Persistence Tools
 */

public class Productstorage implements java.io.Serializable {

	// Fields

	private Integer storageId;
	private String productId;
	private Integer addedCount;
	private Timestamp currentTime;

	// Constructors

	/** default constructor */
	public Productstorage() {
	}

	/** full constructor */
	public Productstorage(String productId, Integer addedCount,
			Timestamp currentTime) {
		this.productId = productId;
		this.addedCount = addedCount;
		this.currentTime = currentTime;
	}

	// Property accessors

	public Integer getStorageId() {
		return this.storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getAddedCount() {
		return this.addedCount;
	}

	public void setAddedCount(Integer addedCount) {
		this.addedCount = addedCount;
	}

	public Timestamp getCurrentTime() {
		return this.currentTime;
	}

	public void setCurrentTime(Timestamp currentTime) {
		this.currentTime = currentTime;
	}

}