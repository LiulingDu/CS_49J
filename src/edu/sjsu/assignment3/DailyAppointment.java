package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * DailyAppointment Class - subclass of Appointment
 *
 *
 */

public class DailyAppointment extends Appointment {

    public DailyAppointment(String description , LocalDate startDate , LocalDate endDate) {
        super(description , startDate , endDate);
    }

    /**
     * Check if the input is between the start and end date (inclusive)
     *
     * @param date String description
     */
    @Override
    public boolean occursOn(LocalDate date) {
        return inBetween(date);
    }
}
