package com.rincentral.test.models;

import com.rincentral.test.models.external.enums.EngineType;
import com.rincentral.test.models.external.enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EngineCharacteristics {

    private FuelType engineType;
    private EngineType engineCylinders;
    private Integer engineDisplacement;
    private Integer engineHorsepower;

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
