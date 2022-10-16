package com.andrecristovam.parking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.andrecristovam.parking.domain.Parking;



@Service
public class ParkingService {
	
	private static Map<String, Parking> parkingMap = new HashMap<>();
	
	static {
		var id = getUUID();
		Parking parking = Parking.builder().id(id).license("DMS-1111").state("SC").model("CELTA").color("PRETO").build();
		parkingMap.put(id, parking);
	}
	
	public List<Parking> findAll() {
		return parkingMap.values().stream().collect(Collectors.toList());
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
