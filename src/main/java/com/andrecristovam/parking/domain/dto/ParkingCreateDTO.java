package com.andrecristovam.parking.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingCreateDTO {
	
	private String license;
	private String state;
	private String model;
	private String color;

}
