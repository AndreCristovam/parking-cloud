package com.andrecristovam.parking.domain;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Parking {
	
	@Id
	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Double bill;


}