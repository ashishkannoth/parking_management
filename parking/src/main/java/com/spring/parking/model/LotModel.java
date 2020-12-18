package com.spring.parking.model;

import java.util.List;

import com.spring.parking.entity.LargeLotDetails;
import com.spring.parking.entity.MediumLotDetails;
import com.spring.parking.entity.SmallLotDetails;

public class LotModel {

	private List<SmallLotDetails> smallLotDetails;
	private List<MediumLotDetails> mediumLotDetails;
	private List<LargeLotDetails> largeLotDetails;

	public List<SmallLotDetails> getSmallLotDetails() {
		return smallLotDetails;
	}

	public void setSmallLotDetails(List<SmallLotDetails> smallLotDetails) {
		this.smallLotDetails = smallLotDetails;
	}

	public List<MediumLotDetails> getMediumLotDetails() {
		return mediumLotDetails;
	}

	public void setMediumLotDetails(List<MediumLotDetails> mediumLotDetails) {
		this.mediumLotDetails = mediumLotDetails;
	}

	public List<LargeLotDetails> getLargeLotDetails() {
		return largeLotDetails;
	}

	public void setLargeLotDetails(List<LargeLotDetails> largeLotDetails) {
		this.largeLotDetails = largeLotDetails;
	}

}
