package com.vodafone.carfactory.service;

import java.util.StringJoiner;

import org.springframework.stereotype.Service;

import com.vodafone.carfactory.util.CarConstants;
import com.vodafone.carfactory.util.CarFactory;


@Service
public class CarFactoryServiceImpl implements CarFactoryService{

	private final CarFactory carFactory;

	public CarFactoryServiceImpl(CarFactory carFactory) {
		this.carFactory = carFactory;
	}

	@Override
	public String getCarType(String carType) {
		
		if(carFactory.getCar(carType)==null) {
			return "Car Type does not exists.";
		}
		
		StringJoiner stringJoiner = new StringJoiner(" ");

		stringJoiner.add(carFactory.getCar(carType).getType());
		stringJoiner.add(CarConstants.CAR_HAS_PRODUCED);

		return stringJoiner.toString();
	}

}
