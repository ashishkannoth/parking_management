package com.spring.parking.service;

import org.springframework.http.ResponseEntity;

import com.spring.parking.model.CarDetails;
import com.spring.parking.model.LotModel;

public interface LotDetailService {

	ResponseEntity<String> addLot(String lotType);

	ResponseEntity<String> deletLot(String lotType, long lotId);

	ResponseEntity<LotModel> getAllLot();

	ResponseEntity<Object> lotAllocation(CarDetails carDetails, long lotId);

	ResponseEntity<Object> getLotByType(float length, float width);

	ResponseEntity<Object> lotRelease(CarDetails carDetails);

}
