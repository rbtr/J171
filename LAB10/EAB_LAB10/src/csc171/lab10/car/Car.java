package csc171.lab10.car;

/*
 * Car.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 10
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/18/15
 */

/**
 * This class is a basic implementation of a Car, demonstrating the use of the final modifier for appropriate fields
 */
public class Car {

    /**
     * The VIN number. Globally unique and never changes.
     */
    final long vin;

    /**
     * The interior color. Should not change during the life of the car (there are exceptions that are being ignored).
     */
    final String interiorColor;

    /**
     * The number of cylinders in the engine. Does not normally change during the life of the car.
     */
    final int cylinders;

    /**
     * The number of seats in the car. Except for the rare case of (temporarily) removable seats, never changes during
     * the life of the car.
     */
    final int seats;

    /**
     * The mileage of the car. Highly variable; changes every time the car is used.
     */
    long mileage;

    /**
     * The exterior paint color of the car. Mutable because it's very possible that the user will change it.
     */
    String paintColor;


    /**
     * Constructs a Car
     * @param vin the vin number
     * @param interiorColor the interior color
     * @param cylinders the number of cylinders
     * @param seats the number of seats
     * @param paintColor the paint color
     */
    public Car(long vin, String interiorColor, int cylinders, int seats, String paintColor) {
        // Set the final properties of the car
        this.vin = vin;
        this.interiorColor = interiorColor;
        this.cylinders = cylinders;
        this.seats = seats;
        // Init the mileage to 0 for a new car
        this.mileage = 0;
        // Set the mutable paint color through its mutator
        setPaintColor(paintColor);
    }

    /**
     * @return the vin number
     */
    public long getVin() {
        return vin;
    }

    /**
     * @return the interior color
     */
    public String getInteriorColor() {
        return interiorColor;
    }

    /**
     * @return the number of cylinders
     */
    public int getCylinders() {
        return cylinders;
    }

    /**
     * @return the number of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @return the current mileage
     */
    public long getMileage() {
        return mileage;
    }

    /**
     * Sets the current mileage of the car
     * @param mileage the mileage
     */
    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    /**
     * Adds some miles to the mileage of the car
     * @param miles the miles to add
     */
    public void addMileage(long miles) {
        this.mileage += miles;
    }

    /**
     * @return the paint color
     */
    public String getPaintColor() {
        return paintColor;
    }

    /**
     * Sets the current paint color of the car
     * @param paintColor the paint color
     */
    public void setPaintColor(String paintColor) {
        this.paintColor = paintColor;
    }
}
