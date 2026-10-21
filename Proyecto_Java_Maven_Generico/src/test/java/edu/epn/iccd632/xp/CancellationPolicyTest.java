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
}