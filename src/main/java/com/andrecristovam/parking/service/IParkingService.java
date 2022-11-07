package com.andrecristovam.parking.service;

import java.util.List;

import com.andrecristovam.parking.domain.Parking;
import com.andrecristovam.parking.exception.ParkingNotFoundException;

public interface IParkingService  {

	List<Parking> findAll();

	Parking findById(String id) throws ParkingNotFoundException;
	
	Parking create(Parking parkingCreate);
	
	void delete(String id);
	
	Parking update(String id, Parking parkingDTO);
	
	Parking checkOut(String id);

}
