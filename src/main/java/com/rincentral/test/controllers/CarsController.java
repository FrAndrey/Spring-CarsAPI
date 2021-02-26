package com.rincentral.test.controllers;


import com.rincentral.test.models.CarCollection;
import com.rincentral.test.models.CarFullInfo;
import com.rincentral.test.models.CarInfo;
import com.rincentral.test.models.external.ExternalCar;
import com.rincentral.test.services.ExternalCarsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarsController {

    @GetMapping("/")
    @ResponseBody
    public String greeting(){
        return "Welcome to the Test task written by Andrey <a href = \"http://t.me/frandrey\">Telegram</a>";
    }


}
