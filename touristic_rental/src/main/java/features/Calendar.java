package features;

import java.util.HashMap;

import features.utils.Date;

public class Calendar {
    public HashMap<String, Boolean> calendar = new HashMap<String, Boolean>();
    
    public Calendar() {
        calendarMaker();
    }

    public int getCalendarSize() {
        return this.calendar.size();
    }
    public boolean getAvailabilty(String date) {
        return calendar.get(date);
    }
    public void bookingDate(String date) {
        calendar.put(date, false);
    }
    
    // Possible dates between 2024 and 2034
    private void calendarMaker() {
        String date;

        for (int year = 2024; year <= 2034; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if (Date.checkExistentDay(day, month, year)) {
                        date = "" + year + "-" + month + "-" + day;
                        calendar.put(date, true);
                    }
                }
            }
        }
    }
    
}
