package com.andrecristovam.parking.domain.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {

	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime entryDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime exitDate;
	private Double bill;
}
