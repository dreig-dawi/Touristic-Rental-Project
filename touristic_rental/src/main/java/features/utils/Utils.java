package features.utils;

public class Utils {
    public static int apartmentNotFound() {
        System.out.println("Apartment not found");
        return 0;
    }
    public static void wait(double d) throws InterruptedException {
        Thread.sleep((long) (d * 1000));
    }
    public static void wait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
    public static void printLine() {
       System.out.println("--------------------------------------------------");
    }
    public static void invalidChoice() {
        System.out.println("Invalid choice. Please try again.");
        printLine();
    }
    public static boolean yearValidator(int year) {
        if (year < 2024 || year > 2034) {
            System.out.println("Invalid year. Please enter a year between 2024 and 2034.");
            return false;
        }
        return true;
    }
    public static boolean monthValidator(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a month between 1 and 12.");
            return false;
        }
        return true;
    }
    public static boolean dayValidator(int day, int month, int year) {
        if (!Date.checkExistentDay(day, month, year)) {
            System.out.println("Invalid day. Please enter a valid day.");
            return false;
        }
        return true;
    }
}
