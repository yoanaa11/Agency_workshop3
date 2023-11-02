package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends Vehicle implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final String INVALID_NUMBER_PASSENGERS = "A bus cannot have less than 10 passengers or more than 50 passengers.";

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(VehicleType.LAND, id, passengerCapacity, pricePerKilometer);
    }

    @Override
    public String getAsString() {
        return String.format("Bus ----%n" +
                "%s%n", super.getAsString());
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
//        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
//            throw new IllegalArgumentException("A bus cannot have less than 10 passengers or more than 50 passengers.");
//        }

        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, INVALID_NUMBER_PASSENGERS);
    }
}