package edu.sjsu.assignment3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OnetimeAppointmentTest {

    @Test
    void occursOn() {
        LocalDate startDate = LocalDate.parse("2022-01-27");
        Appointment appointment = new OnetimeAppointment("Class starts", startDate);
        LocalDate testDate1 = LocalDate.parse("2022-01-27");
        LocalDate testDate2 = LocalDate.parse("2022-03-18");
        LocalDate testDate3 = LocalDate.parse("2022-05-27");
        // testDate1:returns true
        assertEquals(true,appointment.occursOn(testDate1));
        // testDate2:returns false (not the same date)
        assertEquals(false,appointment.occursOn(testDate2));
        // testDate3:returns false (not the same date)
        assertEquals(false,appointment.occursOn(testDate3));
    }
}