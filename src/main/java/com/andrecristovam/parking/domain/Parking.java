package com.andrecristovam.parking.domain;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parking {
	
	private Long id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Double bill;


}