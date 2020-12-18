package com.spring.parking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LargeLotDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long largeLotId;
	private String status;
	private String carNo;
	public long getLargeLotId() {
		return largeLotId;
	}
	public void setLargeLotId(long largeLotId) {
		this.largeLotId = largeLotId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public LargeLotDetails(String status, String carNo) {
		super();
		this.status = status;
		this.carNo = carNo;
	}
	public LargeLotDetails() {
		super();
	}
	public LargeLotDetails(long largeLotId, String status, String carNo) {
		super();
		this.largeLotId = largeLotId;
		this.status = status;
		this.carNo = carNo;
	}
	
	
}
