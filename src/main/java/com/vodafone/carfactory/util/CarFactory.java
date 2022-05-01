package com.vodafone.carfactory.util;

import org.springframework.stereotype.Component;

import com.vodafone.carfactory.model.Cabrio;
import com.vodafone.carfactory.model.Car;
import com.vodafone.carfactory.model.Hatchback;
import com.vodafone.carfactory.model.Sedan;

@Component
public class CarFactory {

	public Car getCar(String carType) {


		if (carType.equalsIgnoreCase("Sedan")) {
			return new Sedan();

		} else if (carType.equalsIgnoreCase("Hatchback")) {
			return new Hatchback();

		} else if (carType.equalsIgnoreCase("Cabrio")) {
			return new Cabrio();
		}
		return null;


	}

}