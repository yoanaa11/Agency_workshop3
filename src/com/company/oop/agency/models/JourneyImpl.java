package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;
    public static final String INVALID_START_LOCATION_OR_DESTINATION = "The %s length cannot be less than %d or more than %d symbols long.";
    public static final String INVALID_DISTANCE = "The Distance cannot be less than 5 or more than 5000 kilometers.";

    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;
    private int id;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        this.id = id;
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        this.vehicle = vehicle;
    }

    public String getStartLocation() {
        return startLocation;
    }

    private void setStartLocation(String startLocation) {
        ValidationHelper.validateStringLength(startLocation, START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH,
                String.format(INVALID_START_LOCATION_OR_DESTINATION, "StartingLocation's", START_LOCATION_MIN_LENGTH, START_LOCATION_MAX_LENGTH));

        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    private void setDestination(String destination) {
        ValidationHelper.validateStringLength(destination, DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH,
                String.format(INVALID_START_LOCATION_OR_DESTINATION, "Destination's", DESTINATION_MIN_LENGTH, DESTINATION_MAX_LENGTH));

        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        ValidationHelper.validateValueInRange(distance, DISTANCE_MIN_VALUE, DISTANCE_MAX_VALUE, INVALID_DISTANCE);
        this.distance = distance;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public double calculateTravelCosts() {
        return this.distance * vehicle.getPricePerKilometer();
    }

    public String getAsString() {
        return String.format("Journey ----%n" +
                "Start location: %s%n" +
                "Destination: %s%n" +
                "Distance: %d%n" +
                "Vehicle type: %s%n" +
                "Travel costs: %.2f%n", this.startLocation, this.destination, this.distance, this.vehicle.getType(), calculateTravelCosts());
    }
}