package com.spring.parking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.parking.dao.LargeLotDetailRepo;
import com.spring.parking.dao.MediumLotDetailsRepo;
import com.spring.parking.dao.SmallLotDetailsRepo;
import com.spring.parking.entity.LargeLotDetails;
import com.spring.parking.entity.MediumLotDetails;
import com.spring.parking.entity.SmallLotDetails;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	@Autowired
	SmallLotDetailsRepo smallLotDetailsRepo;
	
	@Autowired
	MediumLotDetailsRepo mediumLotDetailsRepo;
	
	@Autowired
	LargeLotDetailRepo largeLotDetailsRepo;

	@Override
	public void run(String... args) throws Exception {
		
		List<SmallLotDetails>sld=(List<SmallLotDetails>) smallLotDetailsRepo.findAll();
		List<MediumLotDetails>mld=(List<MediumLotDetails>) mediumLotDetailsRepo.findAll();
		List<LargeLotDetails>lld=(List<LargeLotDetails>) largeLotDetailsRepo.findAll();

		if(sld.size()==0) {
		smallLotDetailsRepo.save(new SmallLotDetails("available",null));
		}if(mld.size()==0) {
		mediumLotDetailsRepo.save(new MediumLotDetails("available",null));
		}if(lld.size()==0) {
		largeLotDetailsRepo.save(new LargeLotDetails("available",null));
		}
		
	}

}
