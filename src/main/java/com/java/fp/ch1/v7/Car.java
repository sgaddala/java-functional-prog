package com.java.fp.ch1.v7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *
 *-->   Implement Anonomus inner class
 * --> Transform into Lamda expressions
 *
 * */
public class Car {
    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;

    private Car(int gasLevel, String color, List<String> passengers, List<String> trunkContents) {
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContents = trunkContents;
    }

    // This type of construction of Object are called "static factories"
    // These static factories used to Construct an Object instead of an public constructor.
    public static Car withGasColorPassengers(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas, color, p, null);
        return self;
    }

    public static Car withGasColorPassengersAndTrunk(int gas, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        Car self = new Car(gas, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
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
                (trunkContents != null ? ", trunkContents=" + trunkContents : "NO TRUNKS!!!") +
                '}';
    }


    public static CarCriteria getColoredCriteria(){
        return COLOR_CRITERIEA;
    }

    private static CarCriteria COLOR_CRITERIEA =(c) ->{ return c.color.equals("Red");};

    public static CarCriteria getCarGasCriteria(){
        return GAS_CRITERIA;
    }

    private static CarCriteria GAS_CRITERIA= new CarGasCriteria(6);
    static class CarGasCriteria implements CarCriteria {
        private int threashHold;

        public CarGasCriteria(int threashHold) {
            this.threashHold = threashHold;
        }

        @Override
        public boolean test(Car c) {
            return c.getGasLevel() >= threashHold;
        }
    }
    //Step -1
    // The following commented code used to implement Comparator inner class
    /*static class CarGasComparator implements Comparator<Car>{

        @Override
        public int compare(Car o1, Car o2) {
            return o1.gasLevel - o2.gasLevel;
        }
    }
    private static final CarGasComparator gasComparator = new CarGasComparator();
    public static CarGasComparator getGasComparator(){
        return gasComparator;
    }*/

    // This code snippet will give understanding of Anonmous inner class
    /*private static final Comparator<Car> gasComparator = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.gasLevel - o2.gasLevel;
        };
    };
    public static Comparator<Car> getGasComparator(){
        return gasComparator;
    }*/

    //Transforming above code snippet to Lamda Expression
    private static final Comparator<Car> gasComparator = (Car o1,Car o2) -> o1.gasLevel - o2.gasLevel;
    public static Comparator<Car> getGasComparator(){
        return gasComparator;
    }




}
interface CarCriteria{
    boolean test(Car c);
}


