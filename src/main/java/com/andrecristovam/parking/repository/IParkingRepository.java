package com.andrecristovam.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andrecristovam.parking.domain.Parking;

@Repository
public interface IParkingRepository extends JpaRepository<Parking, String> {

}
