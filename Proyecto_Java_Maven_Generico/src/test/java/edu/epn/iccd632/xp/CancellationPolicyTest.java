package edu.epn.iccd632.xp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CancellationPolicyTest {

    @Test
    void ownerCancelsReservation() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "E01");

        assertTrue(new CancellationPolicy().cancel(map, "E01", "A"));
        assertFalse(map.containsKey("A"));
    }
}