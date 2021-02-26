package com.rincentral.test.models;

import java.util.HashSet;

public class CarCollection {
//Singleton collection
    private static CarCollection carInstance;
    private HashSet<CarFullInfo> list = null;

    public static CarCollection getInstance() {
        if(carInstance == null)
            carInstance = new CarCollection();
        return carInstance;
    }
    private CarCollection() {
        list = new HashSet<CarFullInfo>();
    }

    public HashSet<CarFullInfo> getArray() {
        return this.list;
    }

    public void addToArray(CarFullInfo value) {
        list.add(value);
    }
}