package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    private Passenger passenger;

    @BeforeEach
    void setUp() {
        passenger = new Passenger("13322345S", "Paco Rabanne", "US");
    }

    @Test
    void testGetIdentifier() {
        assertEquals("13322345S", passenger.getIdentifier());
    }

    @Test
    void testGetName() {
        assertEquals("Paco Rabanne", passenger.getName());
    }

    @Test
    void testGetCountryCode() {
        assertEquals("US", passenger.getCountryCode());
    }

    @Test
    void testGetFlightInitiallyNull() {
        assertNull(passenger.getFlight());
    }

    @Test
    void testJoinFlight() {
        Flight flight = new Flight("HV7565", 50);
        passenger.joinFlight(flight);

        assertEquals(flight, passenger.getFlight());
    }

    @Test
    void testJoinFlightWithPreviousFlight() {
        Flight previousFlight = new Flight("HV7565", 100);
        passenger.joinFlight(previousFlight);

        Flight newFlight = new Flight("HV7565", 100);
        passenger.joinFlight(newFlight);

        assertEquals(newFlight, passenger.getFlight());
        assertEquals(0, previousFlight.getNumberOfPassengers());
    }


}