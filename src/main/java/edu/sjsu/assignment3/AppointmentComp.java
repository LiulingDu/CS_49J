package edu.sjsu.assignment3;

import java.util.Comparator;

public class AppointmentComp implements Comparator<Appointment> {
    @Override
    public int compare(Appointment o1 , Appointment o2) {
        if(o1.getType()==o2.getType())
            return o1.getStartDate().compareTo(o2.getStartDate());
        else if(o1.getType()!=o2.getType())
            return o1.getType().compareTo(o2.getType());
        return 0;
    }
}
