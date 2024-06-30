package com.keyin.Sprint1Client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {
    private Long aircraft_id;

    @JsonProperty("aircraftType")
    private String aircraftType;

    @JsonProperty("airlineName")
    private String airlineName;

    @JsonProperty("numPassengers")
    private int numPassengers;

    @JsonProperty("airports")
    private List<Airport> airports;

    @JsonProperty("passengers")
    private List<Passenger> passengers;

    // Getters and setters
    public Long getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(Long aircraft_id) {
        this.aircraft_id = aircraft_id;
    }

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

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
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

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraft_id=" + aircraft_id +
                ", aircraftType='" + aircraftType + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", numPassengers=" + numPassengers +
                ", airports=" + airports +
                ", passengers=" + passengers +
                '}';
    }
}
