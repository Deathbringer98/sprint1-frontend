package com.keyin.Sprint1Client;

import com.keyin.Sprint1Client.model.*;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("9. Get aircraft by ID");
            System.out.println("10. Update an aircraft");
            System.out.println("11. Delete an aircraft");
            System.out.println("12. Add airport to aircraft");
            System.out.println("13. Add passenger to aircraft");
            System.out.println("14. Delete passenger from aircraft");
            System.out.println("15. Get airport by ID");
            System.out.println("16. Get airport by airport ID");
            System.out.println("17. Get airports by city name");
            System.out.println("18. Update airport by index");
            System.out.println("19. Update airport by airport ID");
            System.out.println("20. Delete airport by index");
            System.out.println("21. Delete airport by airport ID");
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
                    case 9:
                        getAircraftById();
                        break;
                    case 10:
                        updateAircraft();
                        break;
                    case 11:
                        deleteAircraft();
                        break;
                    case 12:
                        addAirportToAircraft();
                        break;
                    case 13:
                        addPassengerToAircraft();
                        break;
                    case 14:
                        deletePassengerFromAircraft();
                        break;
                    case 15:
                        getAirportById();
                        break;
                    case 16:
                        getAirportByAirportId();
                        break;
                    case 17:
                        getAirportsByCityName();
                        break;
                    case 18:
                        updateAirportByIndex();
                        break;
                    case 19:
                        updateAirportByAirportId();
                        break;
                    case 20:
                        deleteAirportByIndex();
                        break;
                    case 21:
                        deleteAirportByAirportId();
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
        city.setProvince(province);
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
        System.out.println("Enter city name:");
        String cityName = scanner.nextLine();
        System.out.println("Enter city province:");
        String cityProvince = scanner.nextLine();
        System.out.println("Enter city population:");
        int cityPopulation = Integer.parseInt(scanner.nextLine());

        City city = new City();
        city.setName(cityName);
        city.setProvince(cityProvince);
        city.setPopulation(cityPopulation);

        Passenger passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setPhoneNumber(phoneNumber);
        passenger.setCity(city);

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
        System.out.println("Enter city name:");
        String cityName = scanner.nextLine();
        System.out.println("Enter city province:");
        String province = scanner.nextLine();
        System.out.println("Enter city population:");
        int population = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        City city = new City();
        city.setName(cityName);
        city.setProvince(province);
        city.setPopulation(population);

        Airport airport = new Airport();
        airport.setName(name);
        airport.setCode(code);
        airport.setCity(city);

        System.out.println("Airport before sending: " + airport);  // Debugging line to check the object

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
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Initialize empty lists for airports and passengers
        List<Airport> airports = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();

        System.out.println("Do you want to add airports to this aircraft? (yes/no)");
        String addAirports = scanner.nextLine();
        while (addAirports.equalsIgnoreCase("yes")) {
            System.out.println("Enter airport name:");
            String airportName = scanner.nextLine();
            System.out.println("Enter airport code:");
            String airportCode = scanner.nextLine();
            System.out.println("Enter city name:");
            String cityName = scanner.nextLine();
            System.out.println("Enter city province:");
            String province = scanner.nextLine();
            System.out.println("Enter city population:");
            int population = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            City city = new City();
            city.setName(cityName);
            city.setProvince(province);
            city.setPopulation(population);

            Airport airport = new Airport();
            airport.setName(airportName);
            airport.setCode(airportCode);
            airport.setCity(city);

            airports.add(airport);

            System.out.println("Do you want to add another airport? (yes/no)");
            addAirports = scanner.nextLine();
        }

        System.out.println("Do you want to add passengers to this aircraft? (yes/no)");
        String addPassengers = scanner.nextLine();
        while (addPassengers.equalsIgnoreCase("yes")) {
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

            passengers.add(passenger);

            System.out.println("Do you want to add another passenger? (yes/no)");
            addPassengers = scanner.nextLine();
        }

        Aircraft aircraft = new Aircraft();
        aircraft.setAircraftType(type);
        aircraft.setAirlineName(airlineName);
        aircraft.setNumPassengers(numPassengers);
        aircraft.setAirports(airports);
        aircraft.setPassengers(passengers);

        System.out.println("Aircraft before sending: " + aircraft);  // Debugging line to check the object

        Aircraft createdAircraft = apiService.createAircraft(aircraft);
        System.out.println("Created aircraft: " + createdAircraft);
    }




    private void getAircraftById() throws Exception {
        System.out.println("Enter aircraft ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Aircraft aircraft = apiService.getAircraft((long) id);
        System.out.println(aircraft);
    }

    private void updateAircraft() throws Exception {
        System.out.println("Enter aircraft ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter aircraft type:");
        String type = scanner.nextLine();
        System.out.println("Enter airline name:");
        String airlineName = scanner.nextLine();
        System.out.println("Enter number of passengers:");
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Aircraft aircraft = new Aircraft();
        aircraft.setAircraft_id((long) id);
        aircraft.setAircraftType(type);
        aircraft.setAirlineName(airlineName);
        aircraft.setNumPassengers(numPassengers);

        Aircraft updatedAircraft = apiService.updateAircraft(aircraft);
        System.out.println("Updated aircraft: " + updatedAircraft);
    }

    private void deleteAircraft() throws Exception {
        System.out.println("Enter aircraft ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        apiService.deleteAircraft((long) id);
        System.out.println("Deleted aircraft with ID: " + id);
    }

    private void addAirportToAircraft() throws Exception {
        System.out.println("Enter aircraft ID:");
        int aircraftId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter airport code:");
        String airportCode = scanner.nextLine();

        apiService.addAirportToAircraft((long) aircraftId, airportCode);
        System.out.println("Added airport " + airportCode + " to aircraft with ID: " + aircraftId);
    }

    private void addPassengerToAircraft() throws Exception {
        System.out.println("Enter aircraft ID:");
        int aircraftId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter passenger ID:");
        int passengerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        apiService.addPassengerToAircraft((long) aircraftId, (long) passengerId);
        System.out.println("Added passenger with ID " + passengerId + " to aircraft with ID: " + aircraftId);
    }

    private void deletePassengerFromAircraft() throws Exception {
        System.out.println("Enter aircraft ID:");
        int aircraftId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter passenger ID:");
        int passengerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        apiService.deletePassengerFromAircraft((long) aircraftId, (long) passengerId);
        System.out.println("Deleted passenger with ID " + passengerId + " from aircraft with ID: " + aircraftId);
    }

    // Airport
    private void getAirportById() throws Exception {
        System.out.println("Enter airport index:");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Airport airport = apiService.getAirport((long) index);
        System.out.println(airport);
    }

    private void getAirportByAirportId() throws Exception {
        System.out.println("Enter airport ID:");
        int airportId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Airport airport = apiService.getAirportByAirportId((long) airportId);
        System.out.println(airport);
    }

    private void getAirportsByCityName() throws Exception {
        System.out.println("Enter city name:");
        String cityName = scanner.nextLine();

        var airports = apiService.getAirportsByCityName(cityName);
        for (var airport : airports) {
            System.out.println(airport);
        }
    }

    private void updateAirportByIndex() throws Exception {
        System.out.println("Enter airport index:");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter airport name:");
        String name = scanner.nextLine();
        System.out.println("Enter airport code:");
        String code = scanner.nextLine();

        Airport airport = new Airport();
        airport.setName(name);
        airport.setCode(code);

        Airport updatedAirport = apiService.updateAirportByIndex((long) index, airport);
        System.out.println("Updated airport: " + updatedAirport);
    }

    private void updateAirportByAirportId() throws Exception {
        System.out.println("Enter airport ID:");
        int airportId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter airport name:");
        String name = scanner.nextLine();
        System.out.println("Enter airport code:");
        String code = scanner.nextLine();

        Airport airport = new Airport();
        airport.setName(name);
        airport.setCode(code);

        Airport updatedAirport = apiService.updateAirportByAirportId((long) airportId, airport);
        System.out.println("Updated airport: " + updatedAirport);
    }

    private void deleteAirportByIndex() throws Exception {
        System.out.println("Enter airport index:");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        apiService.deleteAirportByIndex((long) index);
        System.out.println("Deleted airport with index: " + index);
    }

    private void deleteAirportByAirportId() throws Exception {
        System.out.println("Enter airport ID:");
        int airportId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        apiService.deleteAirportByAirportId((long) airportId);
        System.out.println("Deleted airport with ID: " + airportId);
    }
}
