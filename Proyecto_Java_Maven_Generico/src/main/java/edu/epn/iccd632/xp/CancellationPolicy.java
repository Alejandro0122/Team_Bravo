package edu.epn.iccd632.xp;

import java.util.Map;

/** HU-02. PUNTO DE TRABAJO PARA LA PAREJA 2. */
final class CancellationPolicy {
    boolean cancel(Map<String, String> ownerBySlot, String studentId, String slot) {
        String titular = ownerBySlot.get(slot);

        if (titular == null) {
            return false;
        }
        if (!titular.equals(studentId)) {
            return false;
        }

        ownerBySlot.remove(slot);
        return true;
    }
}