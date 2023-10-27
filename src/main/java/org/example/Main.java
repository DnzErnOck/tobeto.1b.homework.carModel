package org.example;

import org.example.business.CarManager;
import org.example.core.logging.DatabaseLogger;
import org.example.core.logging.FileLogger;
import org.example.core.logging.Logger;
import org.example.core.logging.MailLogger;
import org.example.dataAccess.HibernateCarDao;
import org.example.dataAccess.JdbcCarDao;
import org.example.entities.Car;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car(1,"mercedes benz e250", "mercedes benz","siyah",2000,"2001");

        Car car2 = new Car(1,"bmw 500ü", "bmw","mavi",3001,"2020");

        Logger[] loggers= {new DatabaseLogger(),new FileLogger()};

        CarManager carManager = new CarManager(new HibernateCarDao(),loggers);
        carManager.add(car2);

        CarManager carManager1 = new CarManager(new JdbcCarDao(),loggers);
        carManager1.update(car1);


    }
}