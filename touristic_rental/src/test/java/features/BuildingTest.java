package features;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    private Building building;

    @BeforeEach
    void setUp() {
        building = new Building("Test Building");
    }

    @Test
    void testAddApartment() {
        Apartment apartment = new Apartment("Test Apartment", 0, 0, 0, 0);
        building.addApartment(apartment);
        // Assuming you have a method to get an apartment by name
        assertEquals(apartment, building.getApartment("Test Apartment"));
    }

    @Test
    void testAddApartmentByName() {
        building.addApartment("Test Apartment 2");
        // Assuming you have a method to get an apartment by name
        assertNotNull(building.getApartment("Test Apartment 2"));
    }

    @Test
    void testGetApartmentQuantity() {
        building.addApartment("Apartment 1");
        building.addApartment("Apartment 2");
        building.addApartment("Apartment 3");
        assertEquals(3, building.getApartmentQuantity());
    }

    @Test
    void testGetName() {
        assertEquals("Test Building", building.getName());
    }

}