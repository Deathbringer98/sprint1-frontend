package com.keyin;

import java.util.List;

public class Aircraft {
    private String aircraftType;
    private String airlineName;
    private int passengerCapacity;
    private List<Airport> airports;
    private List<Passenger> passengers;

    // Constructor
    public Aircraft(String aircraftType, String airlineName, int passengerCapacity, List<Airport> airports, List<Passenger> passengers) {
        this.aircraftType = aircraftType;
        this.airlineName = airlineName;
        this.passengerCapacity = passengerCapacity;
        this.airports = airports;
        this.passengers = passengers;
    }

    // Getters and setters
    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}


