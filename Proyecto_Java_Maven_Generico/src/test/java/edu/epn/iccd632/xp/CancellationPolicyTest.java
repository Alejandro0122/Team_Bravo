package edu.epn.iccd632.xp;

import java.util.Map;

/** HU-01 + CR-01. */
final class BookingPolicy {
    boolean book(Map<String, String> ownerBySlot, String studentId, String slot) {
        if (!Reservations.validStudent(studentId)) {
            return false;
        }
        if (!Reservations.validSlot(slot)) {
            return false;
        }
        if (ownerBySlot.containsKey(slot)) {
            return false;
        }
        if (ownerBySlot.containsValue(studentId)) {
            return false;
        }

        ownerBySlot.put(slot, studentId);
        return true;
    }
}