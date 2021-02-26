package com.rincentral.test;
//by Andrey Fr, 2021
import com.rincentral.test.models.BodyCharacteristics;
import com.rincentral.test.models.CarFullInfo;
import com.rincentral.test.models.EngineCharacteristics;
import com.rincentral.test.models.external.ExternalBrand;
import com.rincentral.test.models.external.ExternalCar;
import com.rincentral.test.models.external.ExternalCarInfo;
import com.rincentral.test.models.external.enums.EngineType;
import com.rincentral.test.models.external.enums.FuelType;
import com.rincentral.test.models.external.enums.GearboxType;
import com.rincentral.test.models.external.enums.WheelDriveType;
import com.rincentral.test.services.ExternalCarsApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.*;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			//instantiate the api service
			ExternalCarsApiService api = new ExternalCarsApiService();
			// prepare data for usage from the api
			List<ExternalCar> externalCarCollection = api.loadAllCars();
			List<ExternalBrand> externalBrandCollection = api.loadAllBrands();
			//create a brand map based on id
			Map<Integer, String> brandMap = new HashMap<>();
			//set map key values
			for (ExternalBrand brand : externalBrandCollection) {
				Integer id = brand.getId();
				String country = brand.getCountry();
				brandMap.put(id,country);
			}
				//There are other, cleaner ways to map the data, with fewer lines of code
				// but I stick to this one - because I know it and it works
			for (int i = 1; i <= externalCarCollection.stream().count(); i++) {
				//variables to work with
				ExternalCarInfo detailedExternalCar = api.loadCarInformationById(i);
				CarFullInfo internalCar = new CarFullInfo();
				//Body and Engine props of CarFullInfo
				EngineCharacteristics engineCharacteristics = new EngineCharacteristics();
				BodyCharacteristics bodyCharacteristics = new BodyCharacteristics();

				Integer id = detailedExternalCar.getId();
				internalCar.setId(id);
				String segment = detailedExternalCar.getSegment();
				internalCar.setSegment(segment);
				//use HashMap for the brandId to convert it to country
				Integer brandId = detailedExternalCar.getBrandId();
				String country = brandMap.get(brandId);
				internalCar.setCountry(country);
				String model = detailedExternalCar.getModel();
				internalCar.setModel(model);
				String generation = detailedExternalCar.getGeneration();
				internalCar.setGeneration(generation);
				String modification = detailedExternalCar.getModification();
				internalCar.setModification(modification);
				String yearsRange = detailedExternalCar.getYearsRange();
				internalCar.setYearsRange(yearsRange);
				//set Engine characteristics prop
				EngineType engineType = detailedExternalCar.getEngineType();
				engineCharacteristics.setEngineCylinders(engineType);
				FuelType fuelType = detailedExternalCar.getFuelType();
				engineCharacteristics.setEngineType(fuelType);
				Integer engineDisplacement = detailedExternalCar.getEngineDisplacement();
				engineCharacteristics.setEngineDisplacement(engineDisplacement);
				Integer horsepower = detailedExternalCar.getHp();
				engineCharacteristics.setEngineHorsepower(horsepower);
				//attach engine charact. to the object
				internalCar.setEngineCharacteristics(engineCharacteristics);
				GearboxType gearboxType = detailedExternalCar.getGearboxType();
				internalCar.setGearboxType(gearboxType);
				WheelDriveType wheelDriveType = detailedExternalCar.getWheelDriveType();
				internalCar.setWheelDriveType(wheelDriveType);
				//set Body characteristics prop
				Integer bodyLength = detailedExternalCar.getBodyLength();
				bodyCharacteristics.setBodyLength(bodyLength);
				Integer bodyWidth = detailedExternalCar.getBodyWidth();
				bodyCharacteristics.setBodyWidth(bodyWidth);
				Integer bodyHeight = detailedExternalCar.getBodyHeight();
				bodyCharacteristics.setBodyHeight(bodyHeight);
				String bodyStyle = detailedExternalCar.getBodyStyle();
				bodyCharacteristics.setBodyStyle(bodyStyle);
				//attach body charact. to the object
				internalCar.setBodyCharacteristics(bodyCharacteristics);
				Double acceleration = detailedExternalCar.getAcceleration();
				internalCar.setAcceleration(acceleration);
				Integer maxSpeed = detailedExternalCar.getMaxSpeed();
				internalCar.setMaxSpeed(maxSpeed);
				//add to HashSet
				api.addToCollection(internalCar);
			}
			System.out.println(api.getCarsCollection().stream().count());
		};
	}
}
