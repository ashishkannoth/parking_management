package com.spring.parking.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.parking.entity.MediumLotDetails;

public interface MediumLotDetailsRepo extends CrudRepository<MediumLotDetails, Long> {

	MediumLotDetails findByMediumLotIdAndStatus(long lotId, String lotStatus);

	MediumLotDetails findByCarNo(String carNo);

}
