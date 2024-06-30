package com.keyin.Sprint1Client;

import com.keyin.Sprint1Client.model.*;


import java.util.Scanner;

public class ClientApp {
    private final ApiService apiService;
    private final Scanner scanner;

    public ClientApp() {
        this.apiService = new ApiService();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ClientApp app = new ClientApp();
        app.run();
    }

    private void run() {
        while (true) {
            System.out.println("1. List all cities");
            System.out.println("2. Create a city");
            System.out.println("3. List all passengers");
            System.out.println("4. Create a passenger");
            System.out.println("5. List all airports");
            System.out.println("6. Create an airport");
            System.out.println("7. List all aircraft");
            System.out.println("8. Create an aircraft");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        listAllCities();
                        break;
                    case 2:
                        createCity();
                        break;
                    case 3:
                        listAllPassengers();
                        break;
                    case 4:
                        createPassenger();
                        break;
                    case 5:
                        listAllAirports();
                        break;
                    case 6:
                        createAirport();
                        break;
                    case 7:
                        listAllAircraft();
                        break;
                    case 8:
                        createAircraft();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void listAllCities() throws Exception {
        var cities = apiService.getAllCities();
        for (var city : cities) {
            System.out.println(city);
        }
    }

    private void createCity() throws Exception {
        System.out.println("Enter city name:");
        String name = scanner.nextLine();
        System.out.println("Enter city province:");
        String province = scanner.nextLine();
        System.out.println("Enter city population:");
        int population = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        City city = new City();
        city.setName(name);
        city.setProvince(province); // Make sure `setState` is correct based on your City model
        city.setPopulation(population);

        City createdCity = apiService.createCity(city);
        System.out.println("Created city: " + createdCity);
    }

    private void listAllPassengers() throws Exception {
        var passengers = apiService.getAllPassengers();
        for (var passenger : passengers) {
            System.out.println(passenger);
        }
    }

    private void createPassenger() throws Exception {
        System.out.println("Enter passenger first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter passenger last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter passenger phone number:");
        String phoneNumber = scanner.nextLine();

        Passenger passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setPhoneNumber(phoneNumber);

        Passenger createdPassenger = apiService.createPassenger(passenger);
        System.out.println("Created passenger: " + createdPassenger);
    }

    private void listAllAirports() throws Exception {
        var airports = apiService.getAllAirports();
        for (var airport : airports) {
            System.out.println(airport);
        }
    }

    private void createAirport() throws Exception {
        System.out.println("Enter airport name:");
        String name = scanner.nextLine();
        System.out.println("Enter airport code:");
        String code = scanner.nextLine();

        Airport airport = new Airport();
        airport.setName(name);
        airport.setCode(code);

        Airport createdAirport = apiService.createAirport(airport);
        System.out.println("Created airport: " + createdAirport);
    }

    private void listAllAircraft() throws Exception {
        var aircraft = apiService.getAllAircraft();
        for (var ac : aircraft) {
            System.out.println(ac);
        }
    }

    private void createAircraft() throws Exception {
        System.out.println("Enter aircraft type:");
        String type = scanner.nextLine();
        System.out.println("Enter airline name:");
        String airlineName = scanner.nextLine();
        System.out.println("Enter number of passengers:");
        int numberOfPassengers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Aircraft aircraft = new Aircraft();
        aircraft.setType(type);
        aircraft.setAirlineName(airlineName);
        aircraft.setNumberOfPassengers(numberOfPassengers);

        Aircraft createdAircraft = apiService.createAircraft(aircraft);
        System.out.println("Created aircraft: " + createdAircraft);
    }
}
