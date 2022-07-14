package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * Appointment Class - Superclass
 */

public abstract class Appointment implements Comparable<Appointment> {

    /**
     * Set instance variables and constructors' parameters.
     *
     * @param description String description
     * @param startDate LocalDate startDate
     * @param endDate LocalDate endDate
     */
    public final String description;
    public final LocalDate startDate;
    public final LocalDate endDate;

    public Appointment(String description , LocalDate startDate , LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Implement Appointment class as Comparable
     *
     * @param o LocalDate endDate
     */

    @Override
    public int compareTo(Appointment o) {
        if (!startDate.isEqual(o.startDate)) {
            return startDate.compareTo(o.startDate);
        } else if (!endDate.isEqual(o.endDate)) {
            return endDate.compareTo(o.endDate);
        } else return description.compareTo(o.description);
    }

    /**
     * Check whether the appointment occurs on a date or not
     *
     * @param date String description
     */
    public abstract boolean occursOn(LocalDate date);

    protected boolean inBetween(LocalDate date) {
        return !((date.isBefore(startDate)) || (date.isAfter(endDate)));
    }

    /**
     * get Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * get StartDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * get EndDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }
}
