package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    private static final String INVALID_COSTS = "Value of 'costs' must be a positive number. Actual value: %.2f.";

    private final int id;
    private final Journey journey;
    private double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        setCosts(costs);
        this.journey = journey;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public Journey getJourney() {
        return journey;
    }

    @Override
    public double getAdministrativeCosts() {
        return this.costs;
    }

    private void setCosts(double costs) {
        validateCosts(costs);
        this.costs = costs;
    }

    public double calculatePrice() {
        return this.costs * journey.calculateTravelCosts();
    }

    public String getAsString() {
        return String.format("Ticket ----%n" +
                "Destination: %s%n" +
                "Price: %.2f%n", this.journey.getDestination(), calculatePrice());
    }

    private void validateCosts(double costs) {
        if (costs < 0) {
            throw new InvalidUserInputException(String.format(INVALID_COSTS, costs));
        }
    }
}