package com.vodafone.carfactory.model;

import com.vodafone.carfactory.util.CarConstants;

public class Cabrio implements Car {

	@Override
	public String getType() {
		return CarConstants.CABRIO;
	}

}