package com.keyin.Sprint1Client;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.Sprint1Client.model.*;

import java.util.List;

public class ApiService {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public ApiService() {
        this.apiClient = new ApiClient();
        this.objectMapper = new ObjectMapper();
    }

    // City Methods
    public List<City> getAllCities() throws Exception {
        String response = apiClient.getRequest("/cities");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, City.class));
    }

    public City createCity(City city) throws Exception {
        String json = objectMapper.writeValueAsString(city);
        String response = apiClient.postRequest("/cities", json);
        return objectMapper.readValue(response, City.class);
    }

    // Passenger Methods
    public List<Passenger> getAllPassengers() throws Exception {
        String response = apiClient.getRequest("/passengers");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Passenger.class));
    }

    public Passenger createPassenger(Passenger passenger) throws Exception {
        String json = objectMapper.writeValueAsString(passenger);
        String response = apiClient.postRequest("/passengers", json);
        return objectMapper.readValue(response, Passenger.class);
    }

    // Airport Methods
    public List<Airport> getAllAirports() throws Exception {
        String response = apiClient.getRequest("/airports");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    public Airport createAirport(Airport airport) throws Exception {
        String json = objectMapper.writeValueAsString(airport);
        String response = apiClient.postRequest("/airports", json);
        return objectMapper.readValue(response, Airport.class);
    }

    // Aircraft Methods
    public List<Aircraft> getAllAircraft() throws Exception {
        String response = apiClient.getRequest("/aircraft");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Aircraft.class));
    }

    public Aircraft createAircraft(Aircraft aircraft) throws Exception {
        String json = objectMapper.writeValueAsString(aircraft);
        String response = apiClient.postRequest("/aircraft", json);
        return objectMapper.readValue(response, Aircraft.class);
    }
}
