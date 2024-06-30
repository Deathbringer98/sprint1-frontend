package com.keyin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RESTClient {
    private String serverURL;
    private HttpClient client;
    private ObjectMapper objectMapper = new ObjectMapper();

    public RESTClient(String serverURL) {
        this.serverURL = serverURL;
        this.client = HttpClient.newHttpClient();
    }

    private HttpResponse<String> sendRequest(HttpRequest request) throws IOException, InterruptedException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String createCity(String json) {
        return sendPostRequest("city", json);
    }

    public String getAllCities() {
        return sendGetRequest("cities");
    }

    public String createAirport(String json) {
        return sendPostRequest("airport", json);
    }

    public String getAllAirports() {
        return sendGetRequest("airports");
    }

    public String createPassenger(String json) {
        return sendPostRequest("passenger", json);
    }

    public String getAllPassengers() {
        return sendGetRequest("passengers");
    }

    public String createAircraft(String json) {
        return sendPostRequest("aircraft", json);
    }

    public String getAllAircraft() {
        return sendGetRequest("aircraft");
    }

    public String getAllAircraftForPassenger(int passengerId) {
        return sendGetRequest("passenger/" + passengerId + "/aircraft");
    }

    public String getAllAirportsForPassenger(int passengerId) {
        return sendGetRequest("passenger/" + passengerId + "/airports");
    }

    public String getAllAirportsInCity(String cityName) {
        return sendGetRequest("airports/city/" + cityName);
    }

    public String getAllAirportsForAircraft(int aircraftId) {
        return sendGetRequest("aircraft/id/" + aircraftId + "/airport");
    }

    private String sendGetRequest(String endpoint) {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(serverURL + "/" + endpoint)).build();
        try {
            HttpResponse<String> response = sendRequest(request);
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String sendPostRequest(String endpoint, String json) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverURL + "/" + endpoint))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        try {
            HttpResponse<String> response = sendRequest(request);
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
