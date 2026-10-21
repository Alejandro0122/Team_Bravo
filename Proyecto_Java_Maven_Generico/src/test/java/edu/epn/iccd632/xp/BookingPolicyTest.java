package edu.epn.iccd632.xp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingPolicyTest {

    private Reservations reservations;

    @BeforeEach
    void setUp() {
        reservations = new Reservations();
    }

    @Test
    void testReservaExitosa() {
        assertTrue(reservations.book("EST-01", "A"));
        assertFalse(reservations.isAvailable("A"));
    }

    @Test
    void testReservaDuplicadaMismoBloque() {
        assertTrue(reservations.book("EST-01", "A"));
        assertFalse(reservations.book("EST-02", "A")); // Debe fallar
    }

    @Test
    void testReservaBloqueInvalidoOEstudianteNulo() {
        assertFalse(reservations.book(null, "A"));
        assertFalse(reservations.book("   ", "A"));
        assertFalse(reservations.book("EST-01", "D")); // Bloque inválido
    }
}