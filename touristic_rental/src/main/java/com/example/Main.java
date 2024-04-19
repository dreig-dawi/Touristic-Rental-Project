package com.example;

import features.Apartment;
import features.Building;

public class Main {
    public static void main(String[] args) {            
        Apartment myApartment = new Apartment("Borne1", 0, 0, 0, 0);
        Building myBuilding = new Building("Borne suites");
        myBuilding.addApartment(myApartment);
        myBuilding.addApartment("Borne2");
        myApartment.getAvilabilty(2025, 10, 31, 3);
        myApartment.book(2025, 10, 31, 3);
        myApartment.book(2025, 10, 31, 3);
    }
}