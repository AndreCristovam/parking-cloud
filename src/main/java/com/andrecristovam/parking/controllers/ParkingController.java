package com.andrecristovam.parking.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrecristovam.parking.controllers.mapper.ParkingMapper;
import com.andrecristovam.parking.domain.Parking;
import com.andrecristovam.parking.domain.dto.ParkingCreateDTO;
import com.andrecristovam.parking.domain.dto.ParkingDTO;
import com.andrecristovam.parking.service.ParkingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/parkings")
@Api(tags = "Parking Controller")
public class ParkingController {	
	
	private final ParkingService service;
	private final ParkingMapper parkingMapper;
	
	public ParkingController(ParkingService service, ParkingMapper parkingMapper) {		
		this.service = service;
		this.parkingMapper = parkingMapper;
	}

	@GetMapping
	@ApiOperation("Find all parkings")
	public ResponseEntity<List<ParkingDTO>> findAll() {	
		List<Parking> parkingList = service.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {	
		var parking = service.findById(id);
		var result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {	
		var parkingCreate = parkingMapper.toParkingCreate(dto);
		var parking = service.create(parkingCreate);
		var result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable String id) {	
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto) {	
		var parkingCreate = parkingMapper.toParkingCreate(dto);
		var parking = service.update(id, parkingCreate);
		var result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

}
