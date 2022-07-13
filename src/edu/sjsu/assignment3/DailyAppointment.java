package edu.sjsu.assignment3;

import java.time.LocalDate;

public class DailyAppointment extends Appointment{
    @Override
    public boolean occursOn(LocalDate date) {
        return inBetween(date);
    }

    public DailyAppointment(String description , LocalDate startDate , LocalDate endDate) {
        super(description , startDate , endDate);
    }
}
