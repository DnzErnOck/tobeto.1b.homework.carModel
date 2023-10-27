package org.example.business;

import org.example.core.logging.Logger;
import org.example.dataAccess.CarDao;
import org.example.entities.Car;

public class CarManager {
    //interface
    private CarDao carDao;
    private Logger[] loggers;

    public CarManager(CarDao carDao,Logger[] loggers) {
        this.carDao = carDao;
        this.loggers=loggers;

    }

    public void add(Car car) throws Exception {
        //iş kuralları
        if(car.getTotalKm() <3000){
            throw new Exception("Araba 3000 km den küçüktür.");
        }
        carDao.add(car);

        for (Logger logger: loggers) {
            logger.log(car.getBrand());
        }
    }

    public void update(Car car) throws Exception {
        if(car.getModelYear().equals("2000")){
            throw new Exception("Araba modeli 2000 olmamalı");
        }
        carDao.update(car);

        for (Logger logger: loggers) {
            logger.log(car.getColor());
        }

    }


}
