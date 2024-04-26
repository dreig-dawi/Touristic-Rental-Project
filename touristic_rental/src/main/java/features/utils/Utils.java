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
}
