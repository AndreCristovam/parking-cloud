package com.andrecristovam.parking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrecristovam.parking.controllers.mapper.ParkingMapper;
import com.andrecristovam.parking.domain.Parking;
import com.andrecristovam.parking.domain.dto.ParkingDTO;
import com.andrecristovam.parking.service.ParkingService;



@RestController
@RequestMapping("/parkings")
public class ParkingController {	
	
	private final ParkingService service;
	private final ParkingMapper parkingMapper;
	
	public ParkingController(ParkingService service, ParkingMapper parkingMapper) {		
		this.service = service;
		this.parkingMapper = parkingMapper;
	}

	@GetMapping
	public List<ParkingDTO> findAll() {	
		List<Parking> parkingList = service.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return result;
	}
}
