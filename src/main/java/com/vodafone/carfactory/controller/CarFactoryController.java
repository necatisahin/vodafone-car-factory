package com.vodafone.carfactory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.carfactory.service.CarFactoryService;
import com.vodafone.carfactory.util.ApiPaths;


@RestController
@RequestMapping(ApiPaths.CarController.CONTROLLER)
public class CarFactoryController {
	
	
	private final CarFactoryService carFactoryService;

    public CarFactoryController(CarFactoryService carFactoryService) {
        this.carFactoryService = carFactoryService;
    }
	

	@PostMapping
	public ResponseEntity<String> command(@RequestBody String request) {
		if (!StringUtils.hasLength(request)) {
			return new ResponseEntity<String>("Car Type is required!", HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok(carFactoryService.getCarType(request));
	}
}
