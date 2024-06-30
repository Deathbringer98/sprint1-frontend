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
        String response = apiClient.postRequest("/city", json);
        return objectMapper.readValue(response, City.class);
    }

    // Passenger Methods
    public List<Passenger> getAllPassengers() throws Exception {
        String response = apiClient.getRequest("/passengers");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Passenger.class));
    }

    public Passenger createPassenger(Passenger passenger) throws Exception {
        String json = objectMapper.writeValueAsString(passenger);
        System.out.println("Serialized JSON: " + json); // Debugging line to check JSON content
        String response = apiClient.postRequest("/passenger", json);
        System.out.println("Response JSON: " + response); // Debugging line to check response content
        return objectMapper.readValue(response, Passenger.class);
    }

    // Airport Methods
    public Airport createAirport(Airport airport) throws Exception {
        String json = objectMapper.writeValueAsString(airport);
        String response = apiClient.postRequest("/airport", json);
        return objectMapper.readValue(response, Airport.class);
    }

    public Airport getAirport(Long index) throws Exception {
        String response = apiClient.getRequest("/airport/" + index);
        return objectMapper.readValue(response, Airport.class);
    }

    public Airport getAirportByAirportId(Long airportId) throws Exception {
        String response = apiClient.getRequest("/airport/id/" + airportId);
        return objectMapper.readValue(response, Airport.class);
    }

    public List<Airport> getAirportsByCityName(String cityName) throws Exception {
        String response = apiClient.getRequest("/airports/city/" + cityName);
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    public Airport updateAirportByIndex(Long index, Airport airport) throws Exception {
        String json = objectMapper.writeValueAsString(airport);
        String response = apiClient.putRequest("/airport/" + index, json);
        return objectMapper.readValue(response, Airport.class);
    }

    public Airport updateAirportByAirportId(Long airportId, Airport airport) throws Exception {
        String json = objectMapper.writeValueAsString(airport);
        String response = apiClient.putRequest("/airport/id/" + airportId, json);
        return objectMapper.readValue(response, Airport.class);
    }

    public void deleteAirportByIndex(Long index) throws Exception {
        apiClient.deleteRequest("/airport/" + index);
    }

    public void deleteAirportByAirportId(Long airportId) throws Exception {
        apiClient.deleteRequest("/airport/id/" + airportId);
    }

    public List<Airport> getAllAirports() throws Exception {
        String response = apiClient.getRequest("/airports");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    // Aircraft Methods
    public List<Aircraft> getAllAircraft() throws Exception {
        String response = apiClient.getRequest("/aircraft");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Aircraft.class));
    }

    public Aircraft getAircraft(Long id) throws Exception {
        String response = apiClient.getRequest("/aircraft/" + id);
        return objectMapper.readValue(response, Aircraft.class);
    }

    public Aircraft getAircraftByAircraftId(Long aircraftId) throws Exception {
        String response = apiClient.getRequest("/aircraft/byId/" + aircraftId);
        return objectMapper.readValue(response, Aircraft.class);
    }

    public List<Airport> getAllAirportsUsedBySpecificAircraft(Long aircraftId) throws Exception {
        String response = apiClient.getRequest("/aircraft/" + aircraftId + "/airports");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    public List<Airport> getAllAirportsUsedBySpecificAircraftId(Long aircraftId) throws Exception {
        return getAllAirportsUsedBySpecificAircraft(aircraftId);
    }

    public Aircraft createAircraft(Aircraft aircraft) throws Exception {
        String json = objectMapper.writeValueAsString(aircraft);
        System.out.println("Serialized JSON: " + json);  // Debugging line to check JSON content
        String response = apiClient.postRequest("/aircraft", json);
        System.out.println("Response JSON: " + response); // Debugging line to check response content
        return objectMapper.readValue(response, Aircraft.class);
    }

    public Aircraft updateAircraft(Aircraft aircraft) throws Exception {
        String json = objectMapper.writeValueAsString(aircraft);
        String response = apiClient.putRequest("/aircraft/" + aircraft.getAircraft_id(), json);
        return objectMapper.readValue(response, Aircraft.class);
    }

    public Aircraft updateAircraftByAircraftId(Long aircraftId, Aircraft aircraft) throws Exception {
        String json = objectMapper.writeValueAsString(aircraft);
        String response = apiClient.putRequest("/aircraft/byId/" + aircraftId, json);
        return objectMapper.readValue(response, Aircraft.class);
    }

    public void deleteAircraft(Long id) throws Exception {
        apiClient.deleteRequest("/aircraft/" + id);
    }

    public void deleteAircraftByAircraftId(Long aircraftId) throws Exception {
        apiClient.deleteRequest("/aircraft/byId/" + aircraftId);
    }

    public void addAirportToAircraft(Long aircraftId, String airportCode) throws Exception {
        String json = objectMapper.writeValueAsString(airportCode);
        apiClient.postRequest("/aircraft/" + aircraftId + "/airports", json);
    }

    public void addPassengerToAircraft(Long aircraftId, Long passengerId) throws Exception {
        String json = objectMapper.writeValueAsString(passengerId);
        apiClient.postRequest("/aircraft/" + aircraftId + "/passengers", json);
    }

    public void deletePassengerFromAircraft(Long aircraftId, Long passengerId) throws Exception {
        apiClient.deleteRequest("/aircraft/" + aircraftId + "/passengers/" + passengerId);
    }
}
