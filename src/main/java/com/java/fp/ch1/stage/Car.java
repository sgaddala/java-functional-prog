package com.java.fp.ch1.stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;

    private Car(int gasLevel, String color, List<String> passengers, List<String> trunkContents){
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContents = trunkContents;
    }

    // This type of construction of Object are called "static factories"
    // These static factories used to Construct an Object instead of an public constructor.
    public static Car withGasColorPassengers(int gas, String color, String... passengers){
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas,color,p,null);
        return self;
    }

    public static Car withGasColorPassengersAndTrunk(int gas, String color, String... passengers){
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas,color,p,Arrays.asList("jack","wrench","spare wheel"));
        return self;
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public String getColor() {
        return color;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public List<String> getTrunkContents() {
        return trunkContents;
    }

    @Override
    public String toString() {
        return "Car{" +
                "gasLevel=" + gasLevel +
                ", color='" + color + '\'' +
                ", passengers=" + passengers +
                (trunkContents !=null? ", trunkContents=" + trunkContents : "NO TRUNKS!!!")+
                '}';
    }
    public static CarCriteria getColorCriteria(){
        return COLOR_CRITERIA;
    }
    private static CarCriteria COLOR_CRITERIA = new CarCriteria(){
        @Override
        public boolean test(Car c) {
            return c.getColor().equals("Red");
        }
    };

    /*public static Comparator<Car> sortByCarGas() {
        return CAR_GAR_COMPARATOR;
    }
    private static Comparator CAR_GAR_COMPARATOR=new Comparator<Car>(){
        @Override
        public int compare(Car o1, Car o2) {
            return o1.gasLevel - o2.gasLevel;
        }
    };*/

    public static Comparator<Car> sortByCarGas() {
        return CAR_GAR_COMPARATOR;
    }
    private static Comparator<Car> CAR_GAR_COMPARATOR=(o1,o2)-> o1.gasLevel - o2.gasLevel;

    public static CarCriteria getCarByPassengers(){
        return CAR_BY_PASSENGERS;
    }

    //Another way of Lambda Implementation
    public static Comparator<Car> sortCars(){
        return ((o1, o2) -> o1.gasLevel - o2.gasLevel);
    }

    private static CarCriteria CAR_BY_PASSENGERS = (c) ->c.passengers.size() >= 4;

    //Another way of Lambda Implementation
    public static CarCriteria getFourPassengersCar(){
        return c -> c.passengers.size() > 4;
    }


}



class CarGasCriteria implements CarCriteria {
    private int threashHold;

    public CarGasCriteria(int threashHold) {
        this.threashHold = threashHold;
    }

    @Override
    public boolean test(Car c) {
        return c.getGasLevel() >= threashHold;
    }
}
interface CarCriteria{
    boolean test(Car c);
}


