package edu.epn.iccd632.xp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.HashMap;
import java.util.Map;

class CancellationPolicyTest {

    @Test
    void titularCancelaSuReserva() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("A", "E01");
        CancellationPolicy politica = new CancellationPolicy();

        boolean resultado = politica.cancel(mapa, "E01", "A");

        Assertions.assertTrue(resultado);
        Assertions.assertFalse(mapa.containsKey("A"));
    }

    @Test
    void otroEstudianteNoPuedeCancelar() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("A", "E01");
        CancellationPolicy politica = new CancellationPolicy();

        boolean resultado = politica.cancel(mapa, "E02", "A");

        Assertions.assertFalse(resultado);
        Assertions.assertEquals("E01", mapa.get("A"));
    }

    @Test
    void bloqueLibreNoSePuedeCancelar() {
        Map<String, String> mapa = new HashMap<>();
        CancellationPolicy politica = new CancellationPolicy();

        boolean resultado = politica.cancel(mapa, "E01", "B");

        Assertions.assertFalse(resultado);
        Assertions.assertTrue(mapa.isEmpty());
    }

    // CR-01: depende de HU-01 (BookingPolicy), seguira en rojo hasta que la pareja 1 termine.
    @Test
    void despuesDeCancelarPuedeReservarOtroBloque() {
        Reservations r = new Reservations();
        r.book("E01", "A");

        Assertions.assertTrue(r.cancel("E01", "A"));
        Assertions.assertTrue(r.book("E01", "B"));
    }
}