package com.java.fp.ch1.v6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1) More code clean-up
 * 2)
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
                Car.withGasColorPassengers(6,"Octarine","Ricewind","Ridcully"),
                Car.withGasColorPassengers(6,"Black","John","Jack","Andy"),
                Car.withGasColorPassengers(6,"Green","Brat","Brain","Ethan"),
                Car.withGasColorPassengers(6,"Red","David","lincon","peter"),
                Car.withGasColorPassengers(6,"Yellow","Fred","Jim","Sheila")
        );
        showAll(cars);
       // getColoredCars(cars,"Black");
        getColoredCars(cars, Car.getColoredCriteria());


    }
}
