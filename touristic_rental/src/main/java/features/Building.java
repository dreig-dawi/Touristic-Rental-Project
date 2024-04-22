package features;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String name;
    private List<Apartment> apartmentList = new ArrayList<Apartment>();

    public Building(String name) {
        this.name = name;
    }
    public void addApartment(String name) {
        Apartment apartment = new Apartment(name);
        this.apartmentList.add(apartment);
    }
    public void addApartment(Apartment apartment) {
        this.apartmentList.add(apartment);
    }
    public void getApartmentQuantity() {
        System.out.println("The building has " + this.apartmentList.size() + " apartments.");
    }
    public int getApartmentQuantityNumber() {
        return this.apartmentList.size();
    }
    public void getApartmentNames() {
        System.out.println("The building has the following apartments:");
        for (Apartment apartment : this.apartmentList) {
            System.out.println(apartment.getName());
        }
    }
    public String getApartmentNamesString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The building has the following apartments:\n");
        for (Apartment apartment : this.apartmentList) {
            sb.append(apartment.getName() + "\n");
        }
        return sb.toString();
    }
    public String getName() {
        return this.name;
    }
    public void getApartmentList() {
        getApartmentQuantity();
        for (Apartment apartment : this.apartmentList) {
            System.out.println(apartment.getName());
        }
    }
    public Apartment getApartment(String name) {
        for (Apartment apartment : this.apartmentList) {
            if (apartment.getName().equals(name)) {
                return apartment;
            }
        }
        return null;
    }
}
