package com.pluralsight.test_pyramid_strategy.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {
    @Test
    public void testFlightCreation() {
        Flight flight = new Flight("AA123", 100);
        assertNotNull(flight);
    }

    @Test
    public void testInvalidFlightNumbers() {
        assertThrows(RuntimeException.class,
                ()->{
                    Flight flight = new Flight("AA12", 100);
                });
        assertThrows(RuntimeException.class,
                ()->{
                    Flight flight = new Flight("AA12345", 100);
                });
    }

    @Test
    public void testValidFlightNumber() {
        Flight flight = new Flight("AA123", 100);
        assertNotNull(flight);
        flight = new Flight("AA1234", 100);
        assertNotNull(flight);
    }

    @Test
    public void testSellTicket() {
        Flight flight = new Flight("AA123", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        for(int i=0; i < flight.getPlaces(); i++) {
            flight.sellTicket();
        }
        assertEquals(50, flight.getPassengers());
        assertThrows(RuntimeException.class,
                ()->{
                    flight.sellTicket();
                });
    }

    @Test
    public void testSetInvalidPlaces() {
        Flight flight = new Flight("AA123", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        for(int i=0; i < flight.getPlaces(); i++) {
            flight.sellTicket();
        }
        assertEquals(50, flight.getPassengers());
        assertThrows(RuntimeException.class,
                ()->{
                    flight.setPlaces(49);
                });
    }

    @Test
    public void testSetValidPlaces() {
        Flight flight = new Flight("AA123", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        for (int i = 0; i < flight.getPlaces(); i++) {
            flight.sellTicket();
        }
        assertEquals(50, flight.getPassengers());
        flight.setPlaces(55);
        assertEquals(55, flight.getPlaces());
    }

    @Test
    public void testSetOrigin() {
        Flight flight = new Flight("AA123", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        flight.takeOff();
        assertEquals(true, flight.isFlying());
        assertThrows(RuntimeException.class,
                ()-> {
                    flight.setOrigin("Manchester");
                });
    }

    @Test
    public void testLand() {
        Flight flight = new Flight("AA123", 50);
        flight.setOrigin("London");
        flight.setDestination("Bucharest");
        flight.takeOff();
        flight.land();
        assertEquals(false, flight.isFlying());
    }
}
