package com.spring.parking.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.parking.entity.LargeLotDetails;

public interface LargeLotDetailRepo extends CrudRepository<LargeLotDetails, Long>{

	LargeLotDetails findByLargeLotIdAndStatus(long lotId, String lotStatus);

	LargeLotDetails findByCarNo(String carNo);

}
