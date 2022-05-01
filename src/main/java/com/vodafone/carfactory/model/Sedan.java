package com.vodafone.carfactory.model;

import com.vodafone.carfactory.util.CarConstants;

public class Sedan implements Car {

	@Override
	public String getType() {
		return CarConstants.SEDAN;
	}
}