package com.example;

import features.Apartment;
import features.Building;
import features.Menu;

public class Main {
    public static void main(String[] args) throws InterruptedException {            
        Apartment myApartment = new Apartment("Borne1", 0, 0, 0, 0);
        Building myBuilding = new Building("Borne suites");
        myBuilding.addApartment(myApartment);
        myBuilding.addApartment("Borne2");
        myApartment.printAvilabilty(2025, 10, 31, 3);
        myApartment.book(2025, 10, 31, 3);
        myApartment.book(2025, 10, 31, 3);
        Apartment myApartment1 = new Apartment("Borne3");
        System.out.println("Test: " + myApartment1.getTerraceQuantity());
        Menu.displayMenu();
    }
}