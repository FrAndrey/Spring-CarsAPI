package com.rincentral.test.controllers;

import com.rincentral.test.models.CarCollection;
import com.rincentral.test.models.CarFullInfo;
import com.rincentral.test.models.CarInfo;
import com.rincentral.test.models.external.enums.FuelType;
import com.rincentral.test.models.params.CarRequestParameters;
import com.rincentral.test.models.params.MaxSpeedRequestParameters;
import com.rincentral.test.services.ExternalCarsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    @Autowired
    private ExternalCarsApiService apiService;
    HashSet <CarFullInfo> carHashCollection = CarCollection.getInstance().getArray();

    @RequestMapping(value = "/cars", method = RequestMethod.GET )
    public ResponseEntity<List<? extends CarInfo>> getCars(CarRequestParameters requestParameters) {
        //On this moment I've stacked, casting Child class list to Parent.. so just matched the values
        List <CarFullInfo> carFullList = (ArrayList<CarFullInfo>)carHashCollection.stream()
                .collect(Collectors.toList());
        List<CarInfo> shortenedList = new LinkedList<>();
        //dirty conversion
        for (CarFullInfo car : carFullList ) {
            CarInfo carToAppend = new CarInfo();
            carToAppend.setId(car.getId());
            carToAppend.setCountry(car.getCountry());
            carToAppend.setBrand(car.getBrand());
            carToAppend.setModel(car.getModel());
            carToAppend.setModification(car.getModification());
            carToAppend.setSegment(car.getSegment());
            carToAppend.setGeneration(car.getGeneration());
            shortenedList.add(carToAppend);
        }
        return ResponseEntity.ok(shortenedList);
    }

    @GetMapping("/fuel-types")
    public List<String> getFuelTypes() {
        List <CarFullInfo> carFullList = (ArrayList<CarFullInfo>)carHashCollection.stream()
                .collect(Collectors.toList());
        List <String> allFuels = new ArrayList<>();

        //filter to show only Fuels
        //use distinct to show only unique values
        //also, it might be easier to use just Map
        allFuels = carFullList.stream().map(
                car -> car
                        .getEngineCharacteristics().getEngineType()
                        .toString()).distinct()
                        .collect(Collectors.toList());
            return allFuels;
    }

    @GetMapping("/body-styles")
    public List<String> getBodyStyles() {
        List <CarFullInfo> carFullList = (ArrayList<CarFullInfo>)carHashCollection.stream()
                .collect(Collectors.toList());
        List <String> allBodyStyles = new ArrayList<>();
        //same concept with distinct
        allBodyStyles = carFullList.stream().map(
                car -> car
                        .getBodyCharacteristics().getBodyStyle()
                        .toString()).distinct()
                .collect(Collectors.toList());
        return allBodyStyles;

    }

    @GetMapping("/engine-types")
    public List<String> getEngineTypes() {
        List <CarFullInfo> carFullList = (ArrayList<CarFullInfo>)carHashCollection.stream()
                .collect(Collectors.toList());
        List <String> allEngines = new ArrayList<>();
        allEngines = carFullList.stream().map(
                car -> car
                        .getEngineCharacteristics().getEngineType()
                        .toString()).distinct()
                .collect(Collectors.toList());
        return allEngines;
    }

    @GetMapping("/wheel-drives")
    public List<String> getWheelDrives() {
        List <CarFullInfo> carFullList = (ArrayList<CarFullInfo>)carHashCollection.stream()
                .collect(Collectors.toList());
        List <String> allWheelDrives = new ArrayList<>();
        allWheelDrives = carFullList.stream().map(
                car -> car
                        .getWheelDriveType()
                        .toString()).distinct()
                .collect(Collectors.toList());
        return allWheelDrives;
    }

    @GetMapping("/gearboxes")
    public List<String> getGearboxTypes() {
        List <CarFullInfo> carFullList = (ArrayList<CarFullInfo>)carHashCollection.stream()
                .collect(Collectors.toList());
        List <String> allGearboxes = new ArrayList<>();
        allGearboxes = carFullList.stream().map(
                car -> car
                        .getGearboxType()
                        .toString()).distinct()
                .collect(Collectors.toList());
        return allGearboxes;
    }

    @GetMapping("/max-speed")
    public List<String> getMaxSpeed(MaxSpeedRequestParameters requestParameters) {
        List <CarFullInfo> carFullList = (ArrayList<CarFullInfo>)carHashCollection.stream()
                .collect(Collectors.toList());
        List <String> allMaxSpeed = new ArrayList<>();
        allMaxSpeed = carFullList.stream().map(
                car -> car
                        .getMaxSpeed()
                        .toString()).distinct()
                .collect(Collectors.toList());
        return allMaxSpeed;
    }
}
