package com.andrecristovam.parking.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.andrecristovam.parking.domain.Parking;

public class ParkingCheckOutImp {
	
	public static final int ONE_HOUR = 60;
	public static final int TWENTY_FOUR_HOUR = 24 * ONE_HOUR;
	public static final double ONE_HOUR_VALUE = 5.00;
	public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
	public static final double DAY_VALUE = 20.00;

	public static Double getBill(Parking parking) {
		return getBill(parking.getEntryDate(), parking.getExitDate());
	}

	private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
		long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
		Double bill = 0.0;
		
		if (minutes <= ONE_HOUR) {
			return ONE_HOUR_VALUE;
		}
		
		if (minutes <= TWENTY_FOUR_HOUR) {
			return getMoreOneHour(minutes);
		}
		
		return getMoreDayValue(minutes, bill);		
	}
	
	private static Double getMoreOneHour(Long minutes) {
		Double bill = ONE_HOUR_VALUE;
		int hours = (int) (minutes / ONE_HOUR);
		
		for (int i = 0; i < hours; i++) {
			bill += ADDITIONAL_PER_HOUR_VALUE;
		}
		
		return bill;
	}
	
	private static Double getMoreDayValue(Long minutes, Double bill) {
		
		int days = 0;
		double newBill = bill;		
		days = (int) (minutes / TWENTY_FOUR_HOUR);
		
		for (int i = 0; i < days; i++) {
			newBill += DAY_VALUE;
		}
		
		return newBill;
	}
}
