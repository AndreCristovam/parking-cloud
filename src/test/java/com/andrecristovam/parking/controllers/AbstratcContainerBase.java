package com.andrecristovam.parking.controllers;

import org.testcontainers.containers.MySQLContainer;


public abstract class AbstratcContainerBase {

	static final MySQLContainer  MYSQL_CONTAINER;
	
	static {
		MYSQL_CONTAINER = new MySQLContainer ("mysql:latest");
		MYSQL_CONTAINER.start();
		System.setProperty("spring.datasource.url", MYSQL_CONTAINER.getJdbcUrl());
		System.setProperty("spring.datasource.username", MYSQL_CONTAINER.getUsername());
		System.setProperty("spring.datasource.password", MYSQL_CONTAINER.getPassword());
	}
}
