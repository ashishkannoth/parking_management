package com.spring.parking.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.spring.parking.dao.LargeLotDetailRepo;
import com.spring.parking.dao.MediumLotDetailsRepo;
import com.spring.parking.dao.SmallLotDetailsRepo;
import com.spring.parking.entity.LargeLotDetails;
import com.spring.parking.entity.MediumLotDetails;
import com.spring.parking.entity.SmallLotDetails;
import com.spring.parking.model.CarDetails;
import com.spring.parking.model.LotModel;
import com.spring.parking.service.LotDetailService;

@Service
public class LotDetailServiceImpl implements LotDetailService {

	final double smallLotLength = 4;
	final double smallLotWidth = 2.5;
	final double mediumLotLength = 5;
	final double mediumLotWidth = 3;
	final double largeLotLength = 7;
	final double largeLotWidth = 4;
	final String lotStatusAvailable = "available";
	final String lotStatusBooked = "available";

	@Autowired
	SmallLotDetailsRepo smallLotDetailsRepo;
	@Autowired
	MediumLotDetailsRepo mediumLotDetailsRepo;
	@Autowired
	LargeLotDetailRepo largeLotDetailRepo;

	@Override
	public ResponseEntity<String> addLot(String lotType) {

		switch (lotType) {
		case "small":

			smallLotDetailsRepo.save(new SmallLotDetails(lotStatusAvailable, null));
			break;
		case "medium":
			mediumLotDetailsRepo.save(new MediumLotDetails(lotStatusAvailable, null));
			break;
		case "large":
			largeLotDetailRepo.save(new LargeLotDetails(lotStatusAvailable, null));
			break;
		default:
			return new ResponseEntity<String>("no Lot Type Found", HttpStatus.OK);
		}
		return new ResponseEntity<String>("lot Added", HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<String> deletLot(String lotType, long lotId) {
		switch (lotType) {
		case "small":
			smallLotDetailsRepo.deleteById(lotId);
			break;
		case "medium":
			mediumLotDetailsRepo.deleteById(lotId);
			break;
		case "large":
			largeLotDetailRepo.deleteById(lotId);
			break;
		default:
			return new ResponseEntity<String>("no Lot Type Found", HttpStatus.OK);

		}
		return new ResponseEntity<String>("lot deleted", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<LotModel> getAllLot() {

		LotModel lm = new LotModel();
		lm.setSmallLotDetails((List<SmallLotDetails>) smallLotDetailsRepo.findAll());
		lm.setMediumLotDetails((List<MediumLotDetails>) mediumLotDetailsRepo.findAll());
		lm.setLargeLotDetails((List<LargeLotDetails>) largeLotDetailRepo.findAll());
		return new ResponseEntity<LotModel>(lm, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> lotAllocation(CarDetails carDetails, long lotId) {

		String lotType = findLotForVehicle(carDetails);
		Object response;
		switch (lotType) {
		case "small":
			SmallLotDetails smallLotDetails = smallLotDetailsRepo.findBySmallLotIdAndStatus(lotId, lotStatusAvailable);
			if (smallLotDetails != null) {
				smallLotDetails.setCarNo(carDetails.getCarNo());
				smallLotDetails.setStatus("Booked");
				response=smallLotDetailsRepo.save(smallLotDetails);
				//response = "lot booked";
				break;
			} else {
				response = "there is no lot available with the lotId";
				break;
			}
		case "medium":
			MediumLotDetails mediumLotDetails = mediumLotDetailsRepo.findByMediumLotIdAndStatus(lotId,
					lotStatusAvailable);
			if (mediumLotDetails != null) {
				mediumLotDetails.setCarNo(carDetails.getCarNo());
				mediumLotDetails.setStatus("Booked");
				response=mediumLotDetailsRepo.save(mediumLotDetails);
				//response = "lot booked";
				break;
			} else {
				response = "there is no lot available with the lotId";
				break;
			}
		case "large":
			LargeLotDetails largeLotDetail = largeLotDetailRepo.findByLargeLotIdAndStatus(lotId, lotStatusAvailable);
			if (largeLotDetail != null) {
				largeLotDetail.setCarNo(carDetails.getCarNo());
				largeLotDetail.setStatus("Booked");
				response=largeLotDetailRepo.save(largeLotDetail);
				//response = "lot booked";
				break;
			} else {
				response = "there is no lot available with the lotId";
				break;
			}

		default:
			response = "there is no lot available with the lotId";
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

	// method for find which LotType is matching for vehicle when vehicle details  provide
	public String findLotForVehicle(CarDetails carDetails) {

		if (carDetails.getLength() <= smallLotLength && carDetails.getWidth() <= smallLotWidth) {
			System.out.println("small");

			return "small";
		} else if (carDetails.getLength() > smallLotLength && carDetails.getLength() <= mediumLotLength
				&& carDetails.getWidth() <= mediumLotLength) {
			System.out.println("medium");

			return "medium";
		} else if (carDetails.getLength() > mediumLotLength && carDetails.getLength() <= largeLotLength
				&& carDetails.getWidth() <= largeLotWidth) {
			System.out.println("latge");

			return "large";
		} else {
			return "false";
		}

	}

	@Override
	public  ResponseEntity<Object> getLotByType(float length, float width) {
		CarDetails cd = new CarDetails();
		cd.setLength(length);
		cd.setWidth(width);
		String lotType = findLotForVehicle(cd);
		Object response=null;
		switch (lotType) {
		case "small":

			response= smallLotDetailsRepo.findAll();
			break;

		case "medium":

			response=  mediumLotDetailsRepo.findAll();
			break;

		case "large":

			response=  largeLotDetailRepo.findAll();
			break;
		default:
			break;

		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> lotRelease(CarDetails carDetails) {
		String lotType = findLotForVehicle(carDetails);
		Object response;
		switch (lotType) {
		case "small":
			SmallLotDetails smallLotDetail = smallLotDetailsRepo.findByCarNo(carDetails.getCarNo());
			if (smallLotDetail != null) {
				smallLotDetail.setCarNo(null);
				smallLotDetail.setStatus(lotStatusAvailable);
				response =smallLotDetailsRepo.save(smallLotDetail);
				//response = "lot released";
				break;
			} else {
				response = "no vehicle found for Car Number";
				break;
			}
		case "medium":
			MediumLotDetails mediumLotDetails = mediumLotDetailsRepo.findByCarNo(carDetails.getCarNo());
			if (mediumLotDetails != null) {
				mediumLotDetails.setCarNo(null);
				mediumLotDetails.setStatus(lotStatusAvailable);
				response =	mediumLotDetailsRepo.save(mediumLotDetails);
				//response = "lot released";
				break;
			} else {
				response = "no vehicle found for Car Number";
				break;
			}
		case "large":
			LargeLotDetails largeLotDetails = largeLotDetailRepo.findByCarNo(carDetails.getCarNo());
			if (largeLotDetails != null) {
				largeLotDetails.setCarNo(null);
				largeLotDetails.setStatus(lotStatusAvailable);
				response =largeLotDetailRepo.save(largeLotDetails);
				//response = "lot released";
				break;
			} else {
				response = "no vehicle found for Car Number";
				break;
			}
		default:
			return new ResponseEntity<Object>("no Lot Type Found", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}
}
