package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.utils.ValidationHelper;

public class AirplaneImpl extends Vehicle implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final String INVALID_NUMBER_PASSENGERS = "A vehicle with less than 1 passenger or more than 800 passengers cannot exist!";

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(VehicleType.AIR, id, passengerCapacity, pricePerKilometer);
        setHasFreeFood(hasFreeFood);
    }

    @Override
    public boolean hasFreeFood() {
        return this.hasFreeFood;
    }

    private void setHasFreeFood(boolean hasFreeFood) {
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public String getAsString() {
        return String.format("Airplane ----%n" +
                "%s%n" +
                "Has free food: %s%n", super.getAsString(), this.hasFreeFood);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
//        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
//            throw new IllegalArgumentException(INVALID_NUMBER_PASSENGERS);
//        }

        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, INVALID_NUMBER_PASSENGERS);
    }
}