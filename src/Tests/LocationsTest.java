package Tests;

import Maps.Directions;
import Maps.Location;
import Maps.Locations;

import static org.junit.Assert.*;

public class LocationsTest {

    @org.junit.Test
    public void convertToEnumTest_notNull(){
        assertEquals(Directions.N, Locations.convertToEnum("N"));
        assertEquals(Directions.S, Locations.convertToEnum("S"));
        assertEquals(Directions.E, Locations.convertToEnum("E"));
        assertEquals(Directions.W, Locations.convertToEnum("W"));
    }

    @org.junit.Test
    public void convertToEnumTest_null(){
       assertEquals(null, Locations.convertToEnum("Abba"));
    }

}