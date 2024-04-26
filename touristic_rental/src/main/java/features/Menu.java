package features;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import features.utils.Utils;

public class Menu {
    private static List<Building> buildingList = new ArrayList<Building>();
    private static Scanner scanner;

    // Menus
    public static void displayMenu() throws InterruptedException {
        int choice;

        Utils.printLine();
        System.out.println("Welcome to the Touristic Rental System!");
        do {
            scanner = new Scanner(System.in);
            Utils.wait(1);
            System.out.println("1. Select a building");
            Utils.wait(0.5);
            System.out.println("2. Add a building");
            Utils.wait(0.5);
            System.out.println("3. Remove a building");
            Utils.wait(0.5);
            System.out.println("4. Show buildings");
            Utils.wait(0.5);
            System.out.println("5. Exit");
            Utils.wait(0.5);
            System.out.print("Enter your choice: ");
            try {            
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 0;
            }
            Utils.wait(0.25);

            switch (choice) {
                case 1:
                    if (!noBuildings()) {
                        showBuidlings();
                        selectBuilding();
                    }
                    break;
                case 2:
                    addBuilding();
                    break;
                case 3:
                    if (!noBuildings()) {
                        Utils.wait(0.25);
                        showBuidlings();
                        removeBuilding();
                    }
                    break;
                case 4:
                    if (!noBuildings()) {
                        Utils.wait(0.25);
                        showBuidlings();
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    Utils.invalidChoice();
                    break;
            }
        } while (choice != 5);
        System.out.println("Thank you for using the Touristic Rental System!");
        Utils.printLine();
    }
    static void displayBuildingMenu(Building building) throws InterruptedException {
        int choice;

        Utils.printLine();
        System.out.println("Welcome to " + building.getName() + "'s menu!");
        do {
            scanner = new Scanner(System.in);
            Utils.wait(1);
            System.out.println("1. Select apartment");
            Utils.wait(0.5);
            System.out.println("2. Add an apartment");
            Utils.wait(0.5);
            System.out.println("3. Remove an apartment");
            Utils.wait(0.5);
            System.out.println("4. Show apartments");
            Utils.wait(0.5);
            System.out.println("5. Exit");
            Utils.wait(0.5);
            System.out.print("Enter your choice: ");
            try {            
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 0;
            }
            Utils.wait(0.25);

            switch (choice) {
                case 1:
                    if (!noApartments(building)) {
                        showApartments(building);
                        selectApartment(building);
                    }
                    break;
                case 2:
                    addApartment(building);
                    break;
                case 3:
                    if (!noApartments(building)) { 
                        showApartments(building);                       
                        removeApartment(building);
                    }
                    break;
                case 4:
                    if (!noApartments(building)) {
                        showApartments(building);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    Utils.printLine();
                    break;
                default:
                    Utils.invalidChoice();
                    break;
            }
        } while (choice != 5);
        System.out.println("Touristic Rental System");
    }
    static void displayApartmentMenu(Apartment apartment, Building building) throws InterruptedException {
        int choice;

        Utils.printLine();
        System.out.println("Welcome to " + apartment.getName() + "'s menu!");
        do {
            scanner = new Scanner(System.in);
            Utils.wait(1);
            System.out.println("1. Display availability");
            Utils.wait(0.5);
            System.out.println("2. Book an apartment");
            Utils.wait(0.5);
            System.out.println("3. Apartment details");
            Utils.wait(0.5);
            System.out.println("4. Exit");
            Utils.wait(0.5);
            System.out.print("Enter your choice: ");
            try {            
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 0;
            }
            Utils.wait(0.25);

            switch (choice) {
                case 1:
                    displayAvailability(apartment);
                    break;
                case 2:
                    bookApartment(apartment);
                    break;
                case 3:
                    apartmentDetails(apartment);
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
        System.out.println(building.getName() + "'s menu");
    }

    // Building methods
    private static void showBuidlings() throws InterruptedException {
        if (!noBuildings()){
            System.out.println("Available buildings (" + buildingList.size() + "):");
            for (Building building : buildingList) {
                System.out.println("    - " +building.getName());
            }
            Utils.wait(0.5);
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

    private static void addBuilding() throws InterruptedException {
        System.out.print("Enter the name of the building: ");
        String buildingName = scanner.next();
        Building building = new Building(buildingName);
        buildingList.add(building);
        Utils.wait(0.25);
        System.out.println("Building " + buildingName + " added.");
        Utils.printLine();
    }

    private static void removeBuilding() {
        if (!noBuildings()) {
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
    }
    private static boolean noBuildings() {
        if (buildingList.isEmpty()) {
            System.out.println("No buildings available.");
            Utils.printLine();
            return true;
        }
        return false;
    }

    // Aparments methods
    @SuppressWarnings("static-access")
    private static void showApartments(Building building) throws InterruptedException {
        System.out.println("Available apartments (" + building.getApartmentQuantity() + "):");
        for (Apartment apartment : building.getApartmentList()) {
            System.out.println("    - " + apartment.getName());
        }
    }
    private static void selectApartment(Building building) throws InterruptedException {
        System.out.print("Enter the name of the apartment: ");
        String apartmentName = scanner.next();
        try {
            Apartment apartment = building.getApartment(apartmentName);
            System.out.println("Apartment " + apartment.getName() + " selected.");
            Utils.wait(0.25);
            displayApartmentMenu(apartment, building);
        } catch (IllegalArgumentException e) {
            Utils.apartmentNotFound();
            Utils.printLine();
        }
    }
    private static void displayAvailability(Apartment apartment) {
        int year, month, day, nights;

        do {
            System.out.print("Enter the year: ");
            year = scanner.nextInt();
        } while (!Utils.yearValidator(year));
        do {
            System.out.print("Enter the month: ");
            month = scanner.nextInt();
        } while (!Utils.monthValidator(month));
        do {
            System.out.print("Enter the day: ");
            day = scanner.nextInt();
        } while (!Utils.dayValidator(day, month, year));

        System.out.print("Enter the number of nights: ");
        nights = scanner.nextInt();
        apartment.printAvilabilty(year, month, day, nights);
        Utils.printLine();
    }
    private static void bookApartment(Apartment apartment) {
        int year, month, day, nights;

        do {
            System.out.print("Enter the year: ");
            year = scanner.nextInt();
        } while (!Utils.yearValidator(year));
        do {
            System.out.print("Enter the month: ");
            month = scanner.nextInt();
        } while (!Utils.monthValidator(month));
        do {
            System.out.print("Enter the day: ");
            day = scanner.nextInt();
        } while (!Utils.dayValidator(day, month, year));

        System.out.print("Enter the number of nights: ");
        nights = scanner.nextInt();
        apartment.book(year, month, day, nights);
        System.out.println("Apartment " + apartment.getName() +" booked.");
        Utils.printLine();
    }
    private static void apartmentDetails(Apartment apartment) {
        int choice;

        System.out.println("Apartment details:");
        System.out.println("    - Guests: " + apartment.getGuestQuantity());
        System.out.println("    - Bedrooms: " + apartment.getBedroomQuantity());
        System.out.println("    - Bathrooms: " + apartment.getBathroomQuantity());
        System.out.println("    - Terraces: " + apartment.getTerraceQuantity());
        do {       
            scanner = new Scanner(System.in);     
            System.out.println("1. Modify details");
            System.out.println("2. Exit");
            System.out.println("Enter your choice:");
            try {            
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 0;
            }
            switch (choice) {
                case 1:
                modifyApartmentDetails(apartment);
                break;
                case 2:
                break;
                default:
                Utils.invalidChoice();
                break;
            }
       } while (choice != 2);
    }
    private static void modifyApartmentDetails(Apartment apartment) {
        int choice;
        
        System.out.println("1. Modify guests (" + apartment.getGuestQuantity() + ")");
        System.out.println("2. Modify bedrooms (" + apartment.getBedroomQuantity() + ")");
        System.out.println("3. Modify bathrooms (" + apartment.getBathroomQuantity() + ")");
        System.out.println("4. Modify terraces (" + apartment.getTerraceQuantity() + ")");
        do {        
            System.out.print("Enter your choice: ");
            scanner = new Scanner(System.in);
            try {            
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 0;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter the number of guests: ");
                    int guests = scanner.nextInt();
                    apartment.setGuestQuantity(guests);
                    System.out.println("Guests of " + apartment.getName() + "modified to " + guests + ".");
                    break;
                case 2:
                    System.out.print("Enter the number of bedrooms: ");
                    int bedrooms = scanner.nextInt();
                    apartment.setBedroomQuantity(bedrooms);
                    System.out.println("Bedrooms of " + apartment.getName() + "modified to " + bedrooms + ".");
                    break;
                case 3:
                    System.out.print("Enter the number of bathrooms: ");
                    int bathrooms = scanner.nextInt();
                    apartment.setBathroomQuantity(bathrooms);
                    System.out.println("Bathrooms of " + apartment.getName() + "modified to " + bathrooms + ".");
                    break;
                case 4:
                    System.out.print("Enter the number of terraces: ");
                    int terraces = scanner.nextInt();
                    apartment.setTerraceQuantity(terraces);
                    System.out.println("Terraces of " + apartment.getName() + "modified to " + terraces + ".");
                    break;
                default:
                    Utils.invalidChoice();
                    break;
            }
        } while (choice < 1 || choice > 4);
    }
    private static void addApartment(Building building) {
        int choice;
        do {    
            scanner = new Scanner(System.in);        
            System.out.println("1. Simple mode");
            System.out.println("2. Advance mode");
            System.out.print("Enter your choice: ");
            try {            
                choice = scanner.nextInt();
            } catch (Exception e) {
                choice = 0;
            }
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
        } while (choice != 1 && choice != 2);
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
    private static boolean noApartments(Building building) {
        if (building.getApartmentList().isEmpty()) {
            System.out.println("No apartments available.");
            Utils.printLine();
            return true;
        }
        return false;
    }
}
