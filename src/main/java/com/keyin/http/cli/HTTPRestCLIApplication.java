package com.keyin.http.cli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.RESTClient;
import com.keyin.Airport;
import com.keyin.Passenger;
import com.keyin.Aircraft;
import com.keyin.City;


import java.util.*;

public class HTTPRestCLIApplication {
    private static RESTClient restClient;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        String serverURL = args.length > 0 ? args[0] : "http://localhost:8080";
        restClient = new RESTClient(serverURL);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMainMenu(scanner);
        }
    }

    private static void showMainMenu(Scanner scanner) {
        System.out.println("Main Menu:");
        System.out.println("1. City");
        System.out.println("2. Airport");
        System.out.println("3. Passenger");
        System.out.println("4. Aircraft");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                showCityMenu(scanner);
                break;
            case 2:
                showAirportMenu(scanner);
                break;
            case 3:
                showPassengerMenu(scanner);
                break;
            case 4:
                showAircraftMenu(scanner);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void showCityMenu(Scanner scanner) {
        System.out.println("City Menu:");
        System.out.println("1. Create a city");
        System.out.println("2. List all cities");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                createCity(scanner);
                break;
            case 2:
                listAllCities();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void showAirportMenu(Scanner scanner) {
        System.out.println("Airport Menu:");
        System.out.println("1. Create an airport");
        System.out.println("2. List all airports");
        System.out.println("3. List all airports in a given city");
        System.out.println("4. List all airports a given aircraft can take off from");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                createAirport(scanner);
                break;
            case 2:
                listAllAirports();
                break;
            case 3:
                listAllAirportsInCity(scanner);
                break;
            case 4:
                listAllAirportsForAircraft(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void showPassengerMenu(Scanner scanner) {
        System.out.println("Passenger Menu:");
        System.out.println("1. Create a passenger");
        System.out.println("2. List all passengers");
        System.out.println("3. List all aircraft a given passenger has travelled on");
        System.out.println("4. List all airports a passenger has used");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                createPassenger(scanner);
                break;
            case 2:
                listAllPassengers();
                break;
            case 3:
                listAllAircraftForPassenger(scanner);
                break;
            case 4:
                listAllAirportsForPassenger(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void showAircraftMenu(Scanner scanner) {
        System.out.println("Aircraft Menu:");
        System.out.println("1. Create an aircraft");
        System.out.println("2. List all aircraft");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                createAircraft(scanner);
                break;
            case 2:
                listAllAircraft();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void createCity(Scanner scanner) {
        try {
            System.out.print("Enter city name: ");
            String name = scanner.nextLine();
            System.out.print("Enter province: ");
            String province = scanner.nextLine();
            System.out.print("Enter population: ");
            int population = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String json = objectMapper.writeValueAsString(new City(name, province, population));
            String response = restClient.createCity(json);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllCities() {
        try {
            String response = restClient.getAllCities();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createAirport(Scanner scanner) {
        try {
            System.out.print("Enter airport name: ");
            String airportName = scanner.nextLine();
            System.out.print("Enter airport code: ");
            String code = scanner.nextLine();
            System.out.print("Enter city name: ");
            String cityName = scanner.nextLine();
            System.out.print("Enter city province: ");
            String province = scanner.nextLine();
            System.out.print("Enter city population: ");
            int population = scanner.nextInt();
            scanner.nextLine(); // consume newline

            City city = new City(cityName, province, population);
            Airport airport = new Airport(airportName, code, city);

            String json = objectMapper.writeValueAsString(airport);
            String response = restClient.createAirport(json);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllAirports() {
        try {
            String response = restClient.getAllAirports();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPassenger(Scanner scanner) {
        try {
            System.out.print("Enter passenger first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter passenger last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNum = scanner.nextLine();
            System.out.print("Enter city name: ");
            String name = scanner.nextLine();
            System.out.print("Enter city province: ");
            String province = scanner.nextLine();
            System.out.print("Enter city population: ");
            int population = scanner.nextInt();
            scanner.nextLine(); // consume newline

            City city = new City(name, province, population);
            Passenger passenger = new Passenger(firstName, lastName, phoneNum, city);

            String json = objectMapper.writeValueAsString(passenger);
            System.out.println("JSON Payload: " + json);  // Print the JSON payload
            String response = restClient.createPassenger(json);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllPassengers() {
        try {
            String response = restClient.getAllPassengers();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createAircraft(Scanner scanner) {
        try {
            System.out.print("Enter aircraft type: ");
            String aircraftType = scanner.nextLine();
            System.out.print("Enter airline name: ");
            String airlineName = scanner.nextLine();
            System.out.print("Enter passenger capacity: ");
            int passengerCapacity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            List<Airport> airports = new ArrayList<>();
            List<Passenger> passengers = new ArrayList<>();

            System.out.print("Add airports (y/n)? ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                while (true) {
                    System.out.print("Enter airport name: ");
                    String airportName = scanner.nextLine();
                    System.out.print("Enter airport code: ");
                    String airportCode = scanner.nextLine();
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    System.out.print("Enter city province: ");
                    String cityProvince = scanner.nextLine();
                    System.out.print("Enter city population: ");
                    int cityPopulation = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    City city = new City(cityName, cityProvince, cityPopulation);
                    Airport airport = new Airport(airportName, airportCode, city);
                    airports.add(airport);

                    System.out.print("Add another airport (y/n)? ");
                    if (!scanner.nextLine().equalsIgnoreCase("y")) {
                        break;
                    }
                }
            }

            System.out.print("Add passengers (y/n)? ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                while (true) {
                    System.out.print("Enter passenger first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter passenger last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNum = scanner.nextLine();
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    System.out.print("Enter city province: ");
                    String cityProvince = scanner.nextLine();
                    System.out.print("Enter city population: ");
                    int cityPopulation = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    City city = new City(cityName, cityProvince, cityPopulation);
                    Passenger passenger = new Passenger(firstName, lastName, phoneNum, city);
                    passengers.add(passenger);

                    System.out.print("Add another passenger (y/n)? ");
                    if (!scanner.nextLine().equalsIgnoreCase("y")) {
                        break;
                    }
                }
            }

            Aircraft aircraft = new Aircraft(aircraftType, airlineName, passengerCapacity, airports, passengers);
            String json = objectMapper.writeValueAsString(aircraft);

            String response = restClient.createAircraft(json);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllAircraft() {
        try {
            String response = restClient.getAllAircraft();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void listAllAircraftForPassenger(Scanner scanner) {
        try {
            System.out.print("Enter passenger ID: ");
            int passengerId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String response = restClient.getAllAircraftForPassenger(passengerId);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllAirportsForPassenger(Scanner scanner) {
        try {
            System.out.print("Enter passenger ID: ");
            int passengerId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String response = restClient.getAllAirportsForPassenger(passengerId);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllAirportsInCity(Scanner scanner) {
        try {
            System.out.print("Enter city name: ");
            String cityName = scanner.nextLine();

            String response = restClient.getAllAirportsInCity(cityName);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listAllAirportsForAircraft(Scanner scanner) {
        try {
            System.out.print("Enter aircraft ID: ");
            int aircraftId = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String response = restClient.getAllAirportsForAircraft(aircraftId);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
