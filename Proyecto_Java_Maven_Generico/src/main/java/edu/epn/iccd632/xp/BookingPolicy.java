package edu.epn.iccd632.xp;

import java.util.Map;

/** HU-01. PUNTO DE TRABAJO PARA LA PAREJA 1. */
final class BookingPolicy {
    
    boolean book(Map<String, String> ownerBySlot, String studentId, String slot) {
        // 1. Validar que el estudiante no sea nulo ni esté en blanco
        if (studentId == null || studentId.trim().isEmpty()) {
            return false;
        }

        // 2. Validar que el bloque sea exactamente A, B o C
        if (slot == null || (!slot.equals("A") && !slot.equals("B") && !slot.equals("C"))) {
            return false;
        }

        // 3. Verificar si el bloque ya está ocupado
        if (ownerBySlot.containsKey(slot)) {
            return false; // Conserva al primer titular
        }

        // 4. Registrar la reserva
        ownerBySlot.put(slot, studentId);
        return true;
    }
}