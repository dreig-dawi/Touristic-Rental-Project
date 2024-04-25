package features;

import features.utils.Date;

public class Apartment{
    private String name;
    private int guestQuantity;
    private int bedroomQuantity;
    private int bathroomQuantity;
    private int terraceQuantity;
    private Calendar availability = new Calendar();

    // Constructors
    public Apartment(String name) {
        this.name = name;
    }
    public Apartment(String name, int nGuests, int nBedrooms, int nBathrooms, int nTerraces) {
        this.name = name;
        this.guestQuantity = nGuests;
        this.bedroomQuantity = nBedrooms;
        this.bathroomQuantity = nBathrooms;
        this.terraceQuantity = nTerraces;
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public int getGuestQuantity() {
        return this.guestQuantity;
    }
    public int getBedroomQuantity() {
        return this.bedroomQuantity;
    }
    public int getBathroomQuantity() {
        return this.bathroomQuantity;
    }
    public int getTerraceQuantity() {
        return this.terraceQuantity;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setGuestQuantity(int nGuests) {
        this.guestQuantity = nGuests;
    }
    public void setBedroomQuantity(int nBedrooms) {
        this.bedroomQuantity = nBedrooms;
    }
    public void setBathroomQuantity(int nBathrooms) {
        this.bathroomQuantity = nBathrooms;
    }
    public void setTerraceQuantity(int nTerraces) {
        this.terraceQuantity = nTerraces;
    }
    
    // Methods
    public void printAvilabilty(int year, int month, int day, int nights) {
        String date;
        String available;
        for (int i = 0; i < nights; i++, day++) {
            date = Date.dateRegulator(year, month, day);
            if (date.equals("next_month")) {
                month++;
                day = 0;
                i--;
                continue;
            } else if(date.equals("next_year")) {
                year++;
                month = 1;
                day = 0;
                i--;
                continue;
            }
            available = availability.getAvailabilty(date) ? "available" : "not available";
            System.out.println("On " + date + " the apartment is " + available);
        }
    }
    public void book(int year, int month, int day, int nights) {
        String date;
        boolean available = true;
        int iDay = day, iMonth = month, iYear = year;
        
        for (int i = 0; i < nights; i++, day++) {
            date = Date.dateRegulator(year, month, day);
            if (date.equals("next_month")) {
                month++;
                day = 0;
                i--;
                continue;
            } else if(date.equals("next_year")) {
                year++;
                month = 1;
                day = 0;
                i--;
                continue;
            }
            available = availability.getAvailabilty(date);
            if (!available) {
                System.out.println("The apartment is not available on " + date);
                break;
            }
        }
        if (available) {
            year = iYear;
            month = iMonth;
            day = iDay;
            for (int i = 0; i < nights; i++, day++) {
                date = Date.dateRegulator(year, month, day);
                if (date.equals("next_month")) {
                    month++;
                    day = 0;
                    i--;
                    continue;
                } else if(date.equals("next_year")) {
                    year++;
                    month = 1;
                    day = 0;
                    i--;
                    continue;
                }
                availability.bookingDate(date);
            } 
        }
    }
}