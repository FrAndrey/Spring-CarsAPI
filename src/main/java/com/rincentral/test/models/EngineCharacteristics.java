package com.rincentral.test.models;

import com.rincentral.test.models.external.enums.EngineType;
import com.rincentral.test.models.external.enums.FuelType;

public class EngineCharacteristics {

    public FuelType engineType;
    public EngineType engineCylinders;
    public Integer engineDisplacement;
    public Integer engineHorsepower;

    public EngineCharacteristics(FuelType engineType, EngineType engineCylinders, Integer engineDisplacement, Integer engineHorsepower) {
        this.engineType = engineType;
        this.engineCylinders = engineCylinders;
        this.engineDisplacement = engineDisplacement;
        this.engineHorsepower = engineHorsepower;
    }

    public FuelType getEngineType() {
        return engineType;
    }

    public void setEngineType(FuelType engineType) {
        this.engineType = engineType;
    }

    public EngineType getEngineCylinders() {
        return engineCylinders;
    }

    public void setEngineCylinders(EngineType engineCylinders) {
        this.engineCylinders = engineCylinders;
    }

    public Integer getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(Integer engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Integer getEngineHorsepower() {
        return engineHorsepower;
    }

    public void setEngineHorsepower(Integer engineHorsepower) {
        this.engineHorsepower = engineHorsepower;
    }
}
