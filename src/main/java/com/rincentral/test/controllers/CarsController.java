package com.rincentral.test.controllers;


import com.rincentral.test.models.external.ExternalCar;
import com.rincentral.test.services.ExternalCarsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CarsController {

    @Autowired
    private ExternalCarsApiService apiService;

    @RequestMapping("/cars")
    public List<ExternalCar> getAllCars() {
        return apiService.loadAllCars();
    }

    @GetMapping("/")
    @ResponseBody
    public String greeting(){
        return "Welcome to the Test task written by Andrey <a href = \"http://t.me/frandrey\">Telegram</a>";
    }

//    @GetMapping("/custom")
//    public Iterable<CarFullInfo> list() {
//        return carService.list();
//    }


}
