package features;

import java.util.ArrayList;
import java.util.List;
import features.utils.Utils;
public class Building {
    private String name;
    private static List<Apartment> apartmentList = new ArrayList<Apartment>();

    // Constructor
    public Building(String name) {
        this.name = name;
    }

    // Getters
    public static int getApartmentQuantity() {
        return apartmentList.size();
    }
    public String getName() {
        return this.name;
    }
    Apartment getApartment(String name) {
        for (Apartment apartment : apartmentList) {
            if (apartment.getName().equals(name)) {
                return apartment;
            }
        }
        throw new IllegalArgumentException("Apartment not found.");
    }
    public List<Apartment> getApartmentList() {
        return apartmentList;
    }
    public int getApartmentGuests(String name) {
        try {
            Apartment apartment = getApartment(name);
            return apartment.getGuestQuantity();
        } catch (IllegalArgumentException e) {
            return Utils.apartmentNotFound();
        }
    }
    public int getApartmentBedrooms(String name) {
        try {
            Apartment apartment = getApartment(name);
            return apartment.getBedroomQuantity();
        } catch (IllegalArgumentException e) {
            return Utils.apartmentNotFound();
        }
    }
    public int getApartmentBathrooms(String name) {
        try {
            Apartment apartment = getApartment(name);
            return apartment.getBathroomQuantity();
        } catch (IllegalArgumentException e) {
            return Utils.apartmentNotFound();
        }
    }
    public int getApartmentTerraces(String name) {
        try {
            Apartment apartment = getApartment(name);
            return apartment.getTerraceQuantity();
        } catch (IllegalArgumentException e) {
            return Utils.apartmentNotFound();
        }
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    // Methods
    public void addApartment(String name) {
        Apartment apartment = new Apartment(name);
        apartmentList.add(apartment);
        System.out.println("Apartment " + name + " added to the building.");
    }
    public void addApartment(Apartment apartment) {
        apartmentList.add(apartment);
        System.out.println("Apartment " + apartment.getName() + " added to the building.");
    }
    public void addApartment(String name, int nGuests, int nBedrooms, int nBathrooms, int nTerraces) {
        Apartment apartment = new Apartment(name, nGuests, nBedrooms, nBathrooms, nTerraces);
        apartmentList.add(apartment);
        System.out.println("Apartment " + name + " added to the building.");
    }
    public static void printApartmentQuantity() {
        System.out.println("The building has " + apartmentList.size() + " apartments.");
    }
    public void bookApartment(String name, int year, int month, int day, int nights) {
        Apartment apartment = getApartment(name);
        apartment.book(year, month, day, nights);
    }
    public static void printApartmentNames() {
        System.out.println("The building has the following apartments:");
        for (Apartment apartment : apartmentList) {
            System.out.println(apartment.getName());
        }
    }
    public static void printApartmentList() {
        StringBuilder sb = new StringBuilder();
        sb.append("The building has the following apartments:\n");
        for (Apartment apartment : apartmentList) {
            sb.append(apartment.getName() + "\n");
        }
        System.out.println(sb.toString());
    }
    public void printApartmentAvailability(String name, int year, int month, int day, int nights) {
        Apartment apartment = getApartment(name);
        apartment.printAvilabilty(year, month, day, nights);
    }
    public void removeApartment(String name) {
        for (Apartment apartment : apartmentList) {
            if (apartment.getName().equals(name)) {
                apartmentList.remove(apartment);
                System.out.println("Apartment " + name + " removed from the building.");
                return;
            }
        }
        System.out.println("Apartment not found.");
    }
}
