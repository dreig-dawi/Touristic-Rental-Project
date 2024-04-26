package features;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import features.utils.Utils;

public class Menu {
    private static List<Building> buildingList = new ArrayList<Building>();
    private static Scanner scanner = new Scanner(System.in);

    // Menus
    public static void displayMenu() throws InterruptedException {
        int choice;

        System.out.println("Welcome to the Touristic Rental System!");
        do {
            Utils.wait(1);
            System.out.println("1. Select a building");
            Utils.wait(0.5);
            System.out.println("2. Add a building");
            Utils.wait(0.5);
            System.out.println("3. Remove a building");
            Utils.wait(0.5);
            System.out.println("4. Exit");
            Utils.wait(0.5);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            Utils.wait(0.25);

            switch (choice) {
                case 1:
                    showBuidlings();
                    break;
                case 2:
                    addBuilding();
                    break;
                case 3:
                    removeBuilding();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    Utils.invalidChoice();
                    break;
            }
        } while (choice != 4);
        System.out.println("Thank you for using the Touristic Rental System!");
        Utils.printLine();
    }
    static void displayBuildingMenu(Building building) throws InterruptedException {
        int choice;

        Utils.printLine();
        System.out.println("Welcome to " + building.getName() + "'s menu!");
        do {
            Utils.wait(1);
            System.out.println("1. Select apartment");
            Utils.wait(0.5);
            System.out.println("2. Add an apartment");
            Utils.wait(0.5);
            System.out.println("3. Remove an apartment");
            Utils.wait(0.5);
            System.out.println("4. Exit");
            Utils.wait(0.5);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            Utils.wait(0.25);

            switch (choice) {
                case 1:
                    showApartments(building);
                    break;
                case 2:
                    addApartment(building);
                    break;
                case 3:
                    removeApartment(building);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    Utils.printLine();
                    break;
                default:
                    Utils.invalidChoice();
                    break;
            }
        } while (choice != 4);
    }
    static void displayApartmentMenu(Apartment apartment) throws InterruptedException {
        int choice;

        Utils.printLine();
        System.out.println("Welcome to " + apartment.getName() + "'s menu!");
        do {
            Utils.wait(1);
            System.out.println("1. Display availability");
            Utils.wait(0.5);
            System.out.println("2. Book an apartment");
            Utils.wait(0.5);
            System.out.println("3. Exit");
            Utils.wait(0.5);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            Utils.wait(0.25);

            switch (choice) {
                case 1:
                    displayAvailability(apartment);
                    break;
                case 2:
                    bookApartment(apartment);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    Utils.invalidChoice();
                    break;
            }
        } while (choice != 3);
    }

    // BuildingList methods
    private static void showBuidlings() throws InterruptedException {
        if (buildingList.isEmpty()) {
            System.out.println("No buildingList available.");
            Utils.printLine();
        } else {
            System.out.println("Available buildingList:");
            for (Building building : buildingList) {
                System.out.println("    - " +building.getName());
            }
            selectBuilding();
        }
    }

    private static void selectBuilding() throws InterruptedException {
        Building buildingSelected;
        
        System.out.print("Enter the name of the building: ");
        
        String buildingName = scanner.next();
        
        for (Building building : buildingList) {
            if (building.getName().equals(buildingName)) {
                buildingSelected = building;
                displayBuildingMenu(buildingSelected);
                return;
            }
        }
    
            System.out.println("Building not found.");
            Utils.printLine();

    }

    private static void addBuilding() {
        System.out.print("Enter the name of the building: ");
        String buildingName = scanner.next();
        Building building = new Building(buildingName);
        buildingList.add(building);
        System.out.println("Building " + buildingName + " added.");
        Utils.printLine();
    }

    private static void removeBuilding() {
        System.out.print("Enter the name of the building: ");
        String buildingName = scanner.next();
        for (Building building : buildingList) {
            if (building.getName().equals(buildingName)) {
                buildingList.remove(building);
                System.out.println("Building " + buildingName + " removed.");
                Utils.printLine();
                return;
            }
        }
        System.out.println("Building not found.");
        Utils.printLine();
    }

    // Aparments methods
    @SuppressWarnings("static-access")
    private static void showApartments(Building building) throws InterruptedException {
        if (building.getApartmentQuantity() == 0) {
            System.out.println("No apartments available.");
            Utils.printLine();
        } else {
            System.out.println("Available apartments:");
            for (Apartment apartment : building.getApartmentList()) {
                System.out.println("    - " + apartment.getName());
            }
            selectApartment(building);
        }
    }
    private static void selectApartment(Building building) throws InterruptedException {
        System.out.print("Enter the name of the apartment: ");
        String apartmentName = scanner.next();
        try {
            Apartment apartment = building.getApartment(apartmentName);
            System.out.println("Apartment " + apartment.getName() + " selected.");
            displayApartmentMenu(apartment);
            Utils.printLine();
        } catch (IllegalArgumentException e) {
            Utils.apartmentNotFound();
            Utils.printLine();
        }
    }
    private static void displayAvailability(Apartment apartment) {
        int year, month, day, nights;

        System.out.print("Enter the year: ");
        year = scanner.nextInt();
        System.out.print("Enter the month: ");
        month = scanner.nextInt();
        System.out.print("Enter the day: ");
        day = scanner.nextInt();
        System.out.print("Enter the number of nights: ");
        nights = scanner.nextInt();
        apartment.printAvilabilty(year, month, day, nights);
        Utils.printLine();
    }
    private static void bookApartment(Apartment apartment) {
        int year, month, day, nights;

        System.out.print("Enter the year: ");
        year = scanner.nextInt();
        System.out.print("Enter the month: ");
        month = scanner.nextInt();
        System.out.print("Enter the day: ");
        day = scanner.nextInt();
        System.out.print("Enter the number of nights: ");
        nights = scanner.nextInt();
        apartment.book(year, month, day, nights);
        System.out.println("Apartment " + apartment.getName() +" booked.");
        Utils.printLine();
    }
    private static void addApartment(Building building) {
        int choice;
        System.out.print("1. Simple mode");
        System.out.print("2. Advance mode");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addApartmentSimple(building);
                break;
            case 2:
                addApartmentAdvance(building);
                break;
            default:
                Utils.invalidChoice();
                break;
        }
    }
    private static void addApartmentSimple(Building building) {
        System.out.print("Enter the name of the apartment: ");
        String apartmentName = scanner.next();
        building.addApartment(apartmentName);
        Utils.printLine();
    }
    private static void addApartmentAdvance(Building building) {
        System.out.print("Enter the name of the apartment: ");
        String apartmentName = scanner.next();
        System.out.print("Enter the number of guests: ");
        int guests = scanner.nextInt();
        System.out.print("Enter the number of bedrooms: ");
        int bedrooms = scanner.nextInt();
        System.out.print("Enter the number of bathrooms: ");
        int bathrooms = scanner.nextInt();
        System.out.print("Enter the number of terraces: ");
        int terraces = scanner.nextInt();
        building.addApartment(apartmentName, guests, bedrooms, bathrooms, terraces);
        Utils.printLine();
    }
    private static void removeApartment(Building building) {
        System.out.print("Enter the name of the apartment: ");
        String apartmentName = scanner.next();
        building.removeApartment(apartmentName);
        Utils.printLine();
    }
}
