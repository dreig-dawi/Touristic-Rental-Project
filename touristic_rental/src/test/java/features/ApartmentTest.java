package features;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import features.Apartment;

public class ApartmentTest {

    @Test
    public void testName() {
        Apartment apartment = new Apartment("Apartment Name", "Apartment Address", 3);
        assertEquals("Apartment Name", apartment.getName());
    }

    @Test
    public void testAddress() {
        Apartment apartment = new Apartment("Apartment Name", "Apartment Address", 3);
        assertEquals("Apartment Address", apartment.getAddress());
    }

    @Test
    public void testNumberOfRooms() {
        Apartment apartment = new Apartment("Apartment Name", "Apartment Address", 3);
        assertEquals(3, apartment.getNumberOfRooms());
    }
}