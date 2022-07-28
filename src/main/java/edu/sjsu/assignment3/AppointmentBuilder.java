package edu.sjsu.assignment3;

import java.time.LocalDate;

public class AppointmentBuilder {
    private String description;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    public AppointmentBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public AppointmentBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public AppointmentBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public AppointmentBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Appointment createAppointment() {
        return new Appointment(description , startDate , endDate) {
            @Override
            public boolean occursOn(LocalDate date) {
                return false;
            }
        };
    }
}