package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * MonthlyAppointment Class - subclass of Appointment
 */

public class MonthlyAppointment extends Appointment {
    public MonthlyAppointment(String description , LocalDate startDate , LocalDate endDate) {
        super(description , startDate , endDate);
    }

    /**
     * Check if the input is between the start and end date (inclusive) AND the day of month of the
     * input date is the same as the start date’s day of month of the appointment
     *
     * @param date String description
     */
    @Override
    public boolean occursOn(LocalDate date) {
        return inBetween(date) &&
                date.getDayOfMonth() == this.getStartDate().getDayOfMonth();
    }
}
