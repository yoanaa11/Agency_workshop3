package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends Vehicle implements Train {

    private static final int PASSENGER_MIN_VALUE = 30;
    private static final int PASSENGER_MAX_VALUE = 150;
    private static final int CARTS_MIN_VALUE = 1;
    private static final int CARTS_MAX_VALUE = 15;
    private static final String INVALID_CART = "A train cannot have less than 1 cart or more than 15 carts.";
    private static final String INVALID_NUMBER_PASSENGERS = "A train cannot have less than 30 passengers or more than 150 passengers.";

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(VehicleType.LAND, id, passengerCapacity, pricePerKilometer);
        setCarts(carts);
    }

    @Override
    public int getCarts() {
        return this.carts;
    }

    private void setCarts(int carts) {
        validateCarts(carts);

        this.carts = carts;
    }

    @Override
    public String getAsString() {
        return String.format("Train ----%n" +
                "%s%n" +
                "Carts amount: %s%n", super.getAsString(), this.carts);
    }

    private void validateCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_CART);
        }
    }


    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
//        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
//            throw new IllegalArgumentException(INVALID_NUMBER_PASSENGERS);
//        }

        ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, INVALID_NUMBER_PASSENGERS);
    }
}