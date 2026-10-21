package edu.epn.iccd632.xp;

import java.util.Map;

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

        // 3. Verificar si el bloque ya está ocupado por alguien más
        if (ownerBySlot.containsKey(slot)) {
            return false; 
        }

        // 4. NUEVA REGLA (Cambio del cliente): Verificar si el estudiante ya tiene otra reserva activa en cualquier bloque
        if (ownerBySlot.containsValue(studentId)) {
            return false; // El estudiante ya posee una reserva activa en otro bloque
        }

        // 5. Registrar la reserva si pasa todas las validaciones
        ownerBySlot.put(slot, studentId);
        return true;
    }
}