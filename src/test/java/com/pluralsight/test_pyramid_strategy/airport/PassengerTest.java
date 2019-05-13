package com.pluralsight.test_pyramid_strategy.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testPassengerCreation() {
        Passenger passenger = new Passenger("123-45-6789",
                "John Smith", "US");
        assertNotNull(passenger);
    }

    @Test
    public void testInvalidSsn() {
        assertThrows(RuntimeException.class,
                () -> {
                    Passenger passenger = new Passenger("123-456-789",
                            "John Smith", "US");
                });
    }

    @Test
    public void testSetInvalidSsn() {
        assertThrows(RuntimeException.class,
                () -> {
                    Passenger passenger = new Passenger("123-45-6789",
                            "John Smith", "US");
                    passenger.setIdentifier("123-456-789");
                });
    }

    @Test
    public void testSetValidSsn() {
        Passenger passenger = new Passenger("123-45-6789",
                "John Smith", "US");
        passenger.setIdentifier("123-98-7654");
        assertEquals("123-98-7654", passenger.getIdentifier());
    }

    @Test
    public void testInvalidCountryCode() {
        assertThrows(RuntimeException.class,
                () -> {
                    Passenger passenger = new Passenger("123-45-6789",
                            "John Smith", "GJ");
                });
    }

    @Test
    public void testSetInvalidCountryCode() {
        assertThrows(RuntimeException.class,
                () -> {
                    Passenger passenger = new Passenger("123-45-6789",
                            "John Smith", "US");
                    passenger.setCountryCode("GJ");
                });
    }

    @Test
    public void testSetValidCountryCode() {
        Passenger passenger = new Passenger("123-45-6789",
                "John Smith", "US");
        passenger.setCountryCode("ES");
        assertEquals("ES", passenger.getCountryCode());
    }

    @Test
    public void testPassengerToString() {
        Passenger passenger = new Passenger("123-45-6789",
                "John Smith", "US");
        passenger.setName("John Brown");
        passenger.recordToSystem();
        assertEquals("Passenger John Brown with identifier: 123-45-6789 from US",
                passenger.toString());
    }

}

