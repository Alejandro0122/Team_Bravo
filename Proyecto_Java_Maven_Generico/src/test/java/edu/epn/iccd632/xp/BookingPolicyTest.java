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
    void testEstudianteNoPuedeTenerMasDeUnaReservaActiva() {
        // E01 reserva el bloque A con éxito
        assertTrue(reservations.book("E01", "A"));
        
        // E01 intenta reservar el bloque B, debe fallar (false) porque ya tiene una reserva activa
        assertFalse(reservations.book("E01", "B"));
        
        // Un estudiante distinto (E02) sí puede reservar B si está libre
        assertTrue(reservations.book("E02", "B"));
    }

    @Test
    void testEstudiantePuedeReservarDespuesDeCancelar() {
        // E01 reserva el bloque A
        assertTrue(reservations.book("E01", "A"));
        
        // E01 cancela correctamente su reserva en A
        assertTrue(reservations.cancel("E01", "A"));
        
        // Ahora E01 ya no tiene reservas activas, por lo que puede reservar B con éxito
        assertTrue(reservations.book("E01", "B"));
    }
}