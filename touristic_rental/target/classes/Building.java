package features;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String name;
    private int apartments;
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
}
