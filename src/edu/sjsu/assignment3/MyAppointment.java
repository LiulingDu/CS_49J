package edu.sjsu.assignment3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MyAppointment {
    public static void main(String[] args) {
        LocalDate a1_startDate = LocalDate.parse("2022-01-27");
        OnetimeAppointment a1 = new OnetimeAppointment("Class starts" , a1_startDate);

        LocalDate a2_startDate = a1_startDate;
        LocalDate a2_endDate = LocalDate.parse("2022-05-18");
        DailyAppointment a2 = new DailyAppointment("Class" , a2_startDate , a2_endDate);

        LocalDate a3_startDate = LocalDate.parse("2022-02-16");
        LocalDate a3_endDate = LocalDate.parse("2022-05-16");
        DailyAppointment a3 = new DailyAppointment("Assignments" , a3_startDate , a3_endDate);

        LocalDate a4_startDate = LocalDate.parse("2022-01-27");
        LocalDate a4_endDate = LocalDate.parse("2022-05-18");
        MonthlyAppointment a4 = new MonthlyAppointment("A meeting" , a4_startDate , a4_endDate);

        LocalDate a5_startDate = LocalDate.parse("2022-02-16");
        LocalDate a5_endDate = LocalDate.parse("2022-05-18");
        MonthlyAppointment a5 = new MonthlyAppointment("A meeting" , a5_startDate , a5_endDate);

        Appointment[] myAppointment = {a1 , a2 , a3 , a4 , a5};
        Appointment[] result = {a4 , a5 , a3 , a2 , a1};
        Arrays.sort(myAppointment,new DesComparator());
        System.out.println(Arrays.equals(myAppointment,result));
    }
}
