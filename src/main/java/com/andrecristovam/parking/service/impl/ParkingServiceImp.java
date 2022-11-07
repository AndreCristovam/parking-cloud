package com.andrecristovam.parking.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andrecristovam.parking.domain.Parking;
import com.andrecristovam.parking.exception.ParkingNotFoundException;
import com.andrecristovam.parking.repository.IParkingRepository;
import com.andrecristovam.parking.service.IParkingService;



@Service
public class ParkingServiceImp implements IParkingService{		
		
	private final IParkingRepository repository;
	
	public ParkingServiceImp(IParkingRepository repository) {
		this.repository = repository;
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Parking> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Parking findById(String id) throws ParkingNotFoundException {
		return repository.findById(id).orElseThrow(() ->
			new ParkingNotFoundException(id));
	}

	@Transactional
	public Parking create(Parking parkingCreate) {
		String uuid = getUUID();
		parkingCreate.setId(uuid);
		parkingCreate.setEntryDate(LocalDateTime.now());
		repository.save(parkingCreate);
		return parkingCreate;
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	@Transactional
	public Parking update(String id, Parking parkingDTO) {
		Parking parking = findById(id);
		parking.setColor(parkingDTO.getColor());
		parking.setLicense(parkingDTO.getLicense());
		parking.setModel(parkingDTO.getModel());
		parking.setEntryDate(parkingDTO.getEntryDate());
		repository.save(parking);
		return parking;
	}
	
	public Parking checkOut(String id) {
		var parking = findById(id);
		parking.setExitDate(LocalDateTime.now());
		parking.setBill(ParkingCheckOutImp.getBill(parking));
		repository.save(parking);
		return parking;
	}
}
