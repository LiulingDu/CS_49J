package edu.sjsu.assignment3;

import java.time.LocalDate;

/**
 * Inheritance_AND_Interfaces
 */

public class Assignment3 {

    /**
     * Appointment Class - Superclass
     */

    public abstract class Appointment implements Comparable<edu.sjsu.assignment3.Appointment> {

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

        /**
         * Implement Appointment class as Comparable(Appointment)
         *
         * @param o LocalDate endDate
         */

        @Override
        public int compareTo(edu.sjsu.assignment3.Appointment o) {
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

    /**
     * MonthlyAppointment Class - subclass of Appointment
     */

    public class MonthlyAppointment extends edu.sjsu.assignment3.Appointment {
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

    /**
     * DailyAppointment Class - subclass of Appointment
     */

    public class DailyAppointment extends edu.sjsu.assignment3.Appointment {

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

    /**
     * OnetimeAppointment - subclass of Appointment
     */

    public class OnetimeAppointment extends edu.sjsu.assignment3.Appointment {
        public OnetimeAppointment(String description , LocalDate startDate) {
            super(description , startDate , startDate);
        }

        /**
         * Check if the input is the exact same as the start date of appointment.
         *
         * @param date String description
         */
        @Override
        public boolean occursOn(LocalDate date) {
            return getStartDate().isEqual(date);
        }
    }
}
