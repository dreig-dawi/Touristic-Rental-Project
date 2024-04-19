package features;

import features.utils.Utils;

public class Apartment extends Utils {
    private String name;
    private int nGuests;
    private int nBedrooms;
    private int nBathrooms;
    private int nTerraces;
    private Calendar availability = new Calendar();

    public Apartment(String name) {
        this.name = name;
    }
    public Apartment(String name, int nGuests, int nBedrooms, int nBathrooms, int nTerraces) {
        this.name = name;
        this.nGuests = nGuests;
        this.nBedrooms = nBedrooms;
        this.nBathrooms = nBathrooms;
        this.nTerraces = nTerraces;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNGuests() {
        return this.nGuests;
    }
    public int getNBedrooms() {
        return this.nBedrooms;
    }
    public int getNBarthrooms() {
        return this.nBathrooms;
    }
    public int getNTerrraces() {
        return this.nTerraces;
    }
    public void getAvilabilty(int year, int month, int day, int nights) {
        String date;
        String available;
        for (int i = 0; i < nights; i++, day++) {
            date = dateRegulator(year, month, day);
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
            date = dateRegulator(year, month, day);
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
                date = dateRegulator(year, month, day);
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