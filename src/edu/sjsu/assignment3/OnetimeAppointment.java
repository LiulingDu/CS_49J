package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * OnetimeAppointment - subclass of Appointment
 */

public class OnetimeAppointment extends Appointment {
    public OnetimeAppointment(String description , LocalDate startDate) {
        super(description , startDate , startDate);
    }

    /**
     * check if the input is the exact same as the start date of appointment.
     *
     * @param date String description
     */
    @Override
    public boolean occursOn(LocalDate date) {
        return getStartDate().isEqual(date);
    }
}
