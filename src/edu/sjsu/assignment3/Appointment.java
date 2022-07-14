package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * Appointment Class - Superclass
 * Implement Appointment class as Comparable<Appointment>
 */
public abstract class Appointment implements Comparable<Appointment> {

    /**
     * Set instance variables and constructors' parameters.
     *
     * @param description String description
     * @param startDate LocalDate startDate
     * @param endDate LocalDate endDate
     */
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Appointment(String description , LocalDate startDate , LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
