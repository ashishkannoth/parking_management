package com.spring.parking.model;

public class CarDetails {

	private String carNo;
	private double width;
	private double length;
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public CarDetails(String carNo, double width, double length) {
		super();
		this.carNo = carNo;
		this.width = width;
		this.length = length;
	}
	public CarDetails() {
		super();
	}
	
	
}
