package com.spring.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.parking.model.CarDetails;
import com.spring.parking.model.LotModel;
import com.spring.parking.service.LotDetailService;

@RestController
@RequestMapping("/api/lotDetails")
public class LotDetailsController {

	@Autowired
	LotDetailService lotDetailService;

	// API for Add lot-it adds 1 lot each time it calls
	@PutMapping(path = "/addLot")
	public @ResponseBody ResponseEntity<String> addLot(@RequestParam String lotType) {
		return lotDetailService.addLot(lotType);
	}

	// API for delete lot-it delete lot which have given lotId
	@DeleteMapping(path = "/deletLot")
	public @ResponseBody ResponseEntity<String> deletLot(@RequestParam String lotType, long lotId) {
		return lotDetailService.deletLot(lotType, lotId);
	}

	// API gives all Lots
	@GetMapping(path = "/getAllLot")
	public @ResponseBody ResponseEntity<LotModel>  getAllLot() {
		return lotDetailService.getAllLot();
	}

	// it update lot table with car number and lot status changed to 'Booked'
	@PutMapping(path = "/lotBooking")
	public @ResponseBody ResponseEntity<Object> lotAllocation(@RequestBody CarDetails carDetails, @RequestParam long lotId) {
		return lotDetailService.lotAllocation(carDetails, lotId);
	}

	// API gives all Lots which is available for car by checking its dimensions
	@GetMapping(path = "/getLotByType")
	public @ResponseBody ResponseEntity<Object> getLotByType(@RequestParam float length, float width) {
		return lotDetailService.getLotByType(length, width);
	}

	// Api releases Booked lot by using cardetails data,it update lot table by
	// change lot status to available
	@PutMapping(path = "/lotRelease")
	public @ResponseBody ResponseEntity<Object> lotRelease(@RequestBody CarDetails carDetails) {
		return lotDetailService.lotRelease(carDetails);
	}
}
