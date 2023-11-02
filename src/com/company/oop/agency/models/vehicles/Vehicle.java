package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.utils.ValidationHelper;

public abstract class Vehicle implements com.company.oop.agency.models.vehicles.contracts.Vehicle {

    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    public static final String INVALID_PRICE_PER_KILOMETER = "A vehicle with a price per kilometer lower than $0.10 or higher than $2.50 cannot exist!";

    private final VehicleType vehicleType;
    private final int id;
    private int passengerCapacity;
    private double pricePerKilometer;

    public Vehicle(VehicleType vehicleType, int id, int passengerCapacity, double pricePerKilometer) {
        this.vehicleType = vehicleType;
        this.id = id;
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }

    @Override
    public VehicleType getType() {
        return this.vehicleType;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);

        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return this.pricePerKilometer;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);

        this.pricePerKilometer = pricePerKilometer;
    }

    protected abstract void validatePassengerCapacity(int passengerCapacity);

    protected void validatePricePerKilometer(double pricePerKilometer) {
        ValidationHelper.validateValueInRange(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE, INVALID_PRICE_PER_KILOMETER);
    }

    @Override
    public String getAsString() {

        return String.format("Passenger capacity: %d%n" +
                "Price per kilometer: %.2f%n" +
                "Vehicle type: %s", this.passengerCapacity, this.pricePerKilometer, this.vehicleType);
    }
}