package com.spring.parking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MediumLotDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mediumLotId;
	private String status;
	private String carNo;

	public long getMediumLotId() {
		return mediumLotId;
	}

	public void setMediumLotId(long mediumLotId) {
		this.mediumLotId = mediumLotId;
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

	public MediumLotDetails(String status, String carNo) {
		super();
		this.status = status;
		this.carNo = carNo;
	}

	public MediumLotDetails() {
		super();
	}

	public MediumLotDetails(long mediumLotId, String status, String carNo) {
		super();
		this.mediumLotId = mediumLotId;
		this.status = status;
		this.carNo = carNo;
	}

}
