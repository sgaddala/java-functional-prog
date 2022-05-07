package com.java.fp.ch1.v3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 *
 *
 *
 */
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


    public static RedColorCriteria getColoredCriteria(){
        return COLOR_CRITERIEA;
    }

    private static RedColorCriteria COLOR_CRITERIEA = new RedColorCriteria();
    private static CarGasCriteria GAS_CRITERIA= new CarGasCriteria(6);
    static class RedColorCriteria implements CarCriteria {
        public RedColorCriteria() {
            System.out.println(">>> RedColorCriteria!!!!");
        }

        @Override
        public boolean test(Car c) {
            return c.getColor().equals("Red");
        }
    }

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
}
interface CarCriteria{
    public boolean test(Car c);
}


