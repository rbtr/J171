package csc171.lab10.tests;

/*
 * CarTest.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/19/15
 */

import csc171.lab10.car.Car;

/**
 * Test for Car
 */

public class CarTest {

    private static final long vin = 123;
    private static final String interiorColor = "red";
    private static final int numCylinders = 8;
    private static final int numSeats = 2;
    private static final String paintColor = "black";

    private static final int miles = 5;
    private static final String newPaintColor = "white";

    public static void test() throws TestFailedException {
        // Make a new Car

        Car car = new Car(vin, interiorColor, numCylinders, numSeats, paintColor);

        // Test the car state
        if (car.getVin() != vin) {
            throw new TestFailedException("Car VIN doesn't match");
        }

        if (!car.getInteriorColor().equalsIgnoreCase(interiorColor)) {
            throw new TestFailedException("Car interior color doesn't match");
        }

        if (car.getCylinders() != numCylinders) {
            throw new TestFailedException("Car cylinder count doesn't match");
        }

        if (car.getSeats() != numSeats) {
            throw new TestFailedException("Car seat count doesn't match");
        }

        if (!car.getPaintColor().equalsIgnoreCase(paintColor)) {
            throw new TestFailedException("Car paint color doesn't match");
        }

        if (car.getMileage() != 0) {
            throw new TestFailedException("New car mileage != 0");
        }

        // Test the car mutators
        car.setMileage(miles);
        if (car.getMileage() != miles) {
            throw new TestFailedException("Set mileage test (5) failed");
        }

        car.addMileage(miles);
        if (car.getMileage() != 2 * miles) {
            throw new TestFailedException("Add mileage test (5) failed");
        }

        car.setPaintColor(newPaintColor);
        if (!car.getPaintColor().equalsIgnoreCase(newPaintColor)) {
            throw new TestFailedException("Changing car paint color failed (black -> white)");
        }

        // If it gets here, the Car passed the tests
        System.out.println("Car passed tests");
    }
}
