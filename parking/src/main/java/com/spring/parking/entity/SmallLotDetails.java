package com.spring.parking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SmallLotDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long smallLotId;
	private String status;
	private String carNo;

	public long getSmallLotId() {
		return smallLotId;
	}

	public void setSmallLotId(long smallLotId) {
		this.smallLotId = smallLotId;
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

	public SmallLotDetails(String status, String carNo) {
		super();
		this.status = status;
		this.carNo = carNo;
	}

	public SmallLotDetails() {
		super();
	}

	public SmallLotDetails(long smallLotId, String status, String carNo) {
		super();
		this.smallLotId = smallLotId;
		this.status = status;
		this.carNo = carNo;
	}

	
}
