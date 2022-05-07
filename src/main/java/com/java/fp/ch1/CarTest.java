package com.java.fp.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarTest {

    public static void showAll(Iterable<Car> lc){
        for(Car c:lc){
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------");
    }


    // Version 1.0
    public static void getColoredCars(Iterable<Car> lc, String color){
        List<Car> result = new ArrayList<>();
        for(Car c:lc){
            if(c.getColor().equals(color)){
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
        getColoredCars(cars,"Black");

    }
}
