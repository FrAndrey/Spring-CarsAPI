package com.rincentral.test.models;


import com.rincentral.test.models.external.enums.FuelType;
import com.rincentral.test.models.external.enums.GearboxType;
import com.rincentral.test.models.external.enums.WheelDriveType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarFullInfo extends CarInfo{

    private Integer brandId;

    private String yearsRange;
    //4 props in Engine class: Type of Fuel(enum FuelType), cylinders(enum EngineType), Displacement, Horsepower
    private EngineCharacteristics engineCharacteristics;

    private GearboxType gearboxType;

    private WheelDriveType wheelDriveType;
    //4 props in Body class: Length, Width, Height, Style
    private BodyCharacteristics bodyCharacteristics;

    private Double acceleration;

    private Integer maxSpeed;

}

