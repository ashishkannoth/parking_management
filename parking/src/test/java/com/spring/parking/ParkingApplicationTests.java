package com.spring.parking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.parking.entity.LargeLotDetails;
import com.spring.parking.entity.MediumLotDetails;
import com.spring.parking.entity.SmallLotDetails;
import com.spring.parking.model.CarDetails;
import com.spring.parking.model.LotModel;
import com.spring.parking.service.LotDetailService;
@RunWith(SpringRunner.class)
@SpringBootTest
class ParkingApplicationTests {

	@MockBean
	private LotDetailService lotDetailService;
	
	@Test
	public void getAllLotTest() {
		
		LotModel lm=new LotModel();
		lm.setSmallLotDetails(Stream.of( new SmallLotDetails( (Long.valueOf(1)) ,"available","PY-02"),new SmallLotDetails( (Long.valueOf(2)) ,"available","PY-03")).collect(Collectors.toList()));
		lm.setMediumLotDetails(Stream.of( new MediumLotDetails( (Long.valueOf(1)) ,"available","PY-04"),new MediumLotDetails( (Long.valueOf(2)) ,"available","PY-05")).collect(Collectors.toList()));
		lm.setLargeLotDetails(Stream.of( new LargeLotDetails( (Long.valueOf(1)) ,"available","PY-06"),new LargeLotDetails( (Long.valueOf(2)) ,"available","PY-07")).collect(Collectors.toList()));

		
		when(lotDetailService.getAllLot()).thenReturn(new ResponseEntity<LotModel>(lm,HttpStatus.CREATED));
		System.out.println(lm.getLargeLotDetails().size()+"size");
		assertEquals(2, lm.getLargeLotDetails().size());
		assertEquals(2, lm.getMediumLotDetails().size());
		assertEquals(2, lm.getSmallLotDetails().size());
	}
	@Test
	public void addLotTest() {

		String message="lot Added";
		when(lotDetailService.addLot("small")).thenReturn(new ResponseEntity<String>(message,HttpStatus.CREATED));
	
		assertEquals("lot Added",message);
	}
	@Test
	public void deletLotTest() {

		String message="lot deleted";
		when(lotDetailService.deletLot("medium", 2)).thenReturn(new ResponseEntity<String>(message,HttpStatus.OK));
	
		assertEquals("lot deleted",message);
	}
	@Test
	public void lotAllocationTest() {
		SmallLotDetails sm=new SmallLotDetails(1,"Booked","PY-023");

		when(lotDetailService.lotAllocation(new CarDetails("PY-023",2.4,4), 1)).thenReturn(new ResponseEntity<Object>(sm,HttpStatus.OK));
	
		assertEquals("PY-023",sm.getCarNo());
	}
	@Test
	public void lotReleaseTest() {
		SmallLotDetails sm=new SmallLotDetails(1,"available","Null");

		when(lotDetailService.lotRelease(new CarDetails("PY-023",2.4,4))).thenReturn(new ResponseEntity<Object>( sm,HttpStatus.OK));
	
		assertEquals(1,sm.getSmallLotId());
	}
	
}
