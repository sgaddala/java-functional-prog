package com.java.fp.ch1.stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created behavioral specific classes and moved the behavior logic into generalized type.
 */

public class CarTest {

    public static void showAll(Iterable<Car> lc){
        for(Car c:lc){
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------");
    }


    public static void getColoredCars(Iterable<Car> lc, CarCriteria rc){
        List<Car> result = new ArrayList<>();
        for(Car c:lc){
            if(rc.test(c)){
                result.add(c);
            }
        }
        showAll(result);
    }
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                Car.withGasColorPassengers(6,"Red","Fred","Jim","Sheila"),
                Car.withGasColorPassengers(1,"Octarine","Ricewind","Ridcully"),
                Car.withGasColorPassengers(2,"Black","John","Jack","Andy"),
                Car.withGasColorPassengers(2,"Green","Brat","Brain","Ethan"),
                Car.withGasColorPassengers(5,"Red","David","lincon","peter"),
                Car.withGasColorPassengers(6,"Yellow","Fred","Jim","Sheila","Subose")
        );
        showAll(cars);
       // getColoredCars(cars,"Black");
        getColoredCars(cars,Car.getColorCriteria());
        cars.sort(Car.sortCars());
        showAll(cars);
       getColoredCars(cars,Car.getCarByPassengers());
    }
}
