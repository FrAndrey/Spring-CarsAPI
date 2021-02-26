package com.rincentral.test.services;

import com.rincentral.test.models.CarFullInfo;
import com.rincentral.test.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//Repo and Service are not used, but typically data is stored using them (With JPA for example, and some DB)
@Service
public class CarService {

    private CarRepository carRepository;

    public Iterable<CarFullInfo> list() {
        return carRepository.findAll();
    }

    public CarFullInfo save(CarFullInfo car) {
        return carRepository.save(car);
    }

    public Iterable<CarFullInfo> save(List<CarFullInfo> cars) {
        return carRepository.saveAll(cars);
    }
}
