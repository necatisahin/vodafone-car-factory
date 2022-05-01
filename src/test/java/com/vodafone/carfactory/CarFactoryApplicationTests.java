package com.vodafone.carfactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vodafone.carfactory.controller.CarFactoryController;
import com.vodafone.carfactory.service.CarFactoryService;
import com.vodafone.carfactory.service.CarFactoryServiceImpl;
import com.vodafone.carfactory.util.CarFactory;

@SpringBootTest
class CarFactoryApplicationTests {

	private static CarFactoryService carFactoryService;
	private static CarFactoryController carFactoryController;
	private static CarFactory carFactory;

	@BeforeAll
	public static void setUp() {
		carFactory = new CarFactory();
		carFactoryService = new CarFactoryServiceImpl(carFactory);
		carFactoryController = new CarFactoryController(carFactoryService);

	}

	@Test
	void testCabrioProduce() {
		String request = "cabrio";
		ResponseEntity<String> response = carFactoryController.command(request);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Cabrio Car has produced.");
	}

	@Test
	void testSedanProduce() {
		String request = "sedan";
		ResponseEntity<String> response = carFactoryController.command(request);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Sedan Car has produced.");
	}

	@Test
	void testHatchbackProduce() {
		String request = "hatchback";
		ResponseEntity<String> response = carFactoryController.command(request);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Hatchback Car has produced.");
	}

	@Test
	void testInvalidProduce() {
		String request = "invalid";
		ResponseEntity<String> response = carFactoryController.command(request);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody()).isEqualTo("Car Type does not exists.");
	}

	@Test
	void testEmptyCarTypeProduce() {
		String request = "";
		ResponseEntity<String> response = carFactoryController.command(request);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

}
