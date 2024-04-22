package features;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApartmentTest {

    @Test
    public void testName() {
        Apartment apartment = new Apartment("Apartment Name");
        assertEquals("Apartment Name", apartment.getName());
    }

}