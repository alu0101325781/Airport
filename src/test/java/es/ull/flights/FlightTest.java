package es.ull.flights;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    private Flight flight;

    @BeforeEach
    void setUp() {
        // Configuración común antes de cada prueba
        flight = new Flight("ZY441", 60); // Número de vuelo válido y 50 asientos
    }

    @Test
    void testGetFlightNumber() {
        assertEquals("ZY441", flight.getFlightNumber());
    }


    @Test
    void testRemovePassenger() {
        Passenger passenger = new Passenger("4654523465F", "Fran Cuesta", "ES");
        flight.addPassenger(passenger);

        assertTrue(flight.removePassenger(passenger));
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testRemovePassengerNotInFlight() {
        Passenger passenger = new Passenger("43554345E", "Carlos Mendoza", "US");

        // Intentar eliminar un pasajero que no está en el vuelo no debería lanzar excepción
        assertFalse(flight.removePassenger(passenger));
        assertEquals(0, flight.getNumberOfPassengers());
    }
}
