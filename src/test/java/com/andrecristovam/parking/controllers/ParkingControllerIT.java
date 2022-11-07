package com.andrecristovam.parking.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.andrecristovam.parking.domain.dto.ParkingCreateDTO;

import io.restassured.RestAssured;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerIT extends AbstratcContainerBase{
	
	@LocalServerPort
	private int randonPort;
	
	@BeforeEach
	public void setUpTest() {
		System.out.println(randonPort);
		RestAssured.port = randonPort;
	}

	@Test
	void whenFindAllThenCheckResult() {
		RestAssured.given()
			.auth()
			.basic("user", "root")
			.when()
			.get("/parkings")
			.then()
			.statusCode(HttpStatus.OK.value());			
	}
	
	@Test
	void whenCreateThenCheckIsCreated() {
		var createDTO = ParkingCreateDTO.builder().license("WRT-5555").state("SP").model("BRASILIA").color("AMARELO").build();
		
		RestAssured.given()
		.auth()
		.basic("user", "root")
		.when()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(createDTO)
		.post("/parkings")
		.then()
		.statusCode(HttpStatus.CREATED.value())
		.body("license", Matchers.equalTo("WRT-5555"));
	}
}
