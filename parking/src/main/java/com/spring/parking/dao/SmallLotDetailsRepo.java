package com.spring.parking.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.parking.entity.SmallLotDetails;


public interface SmallLotDetailsRepo extends CrudRepository<SmallLotDetails, Long>{

	SmallLotDetails findBySmallLotIdAndStatus(long lotId, String lotStatus);

	SmallLotDetails findByCarNo(String carNo);



}
