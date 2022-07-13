package edu.sjsu.assignment3;

import java.util.Comparator;

public class DesComparator implements Comparator<Appointment>{
    @Override
    public int compare(Appointment o1 , Appointment o2) {
        // compare description if description are different,otherwise compare start date and then end date.
        if(o1.getDescription().equals(o2.getDescription())){
            return o1.getDescription().compareTo(o2.getDescription());
        }
        if(o1.getStartDate().isEqual(o2.getStartDate())){
            return o1.getStartDate().compareTo(o2.getStartDate());
        }
        if(o1.getEndDate().isEqual(o2.getEndDate())){
            return o1.getEndDate().compareTo(o2.getEndDate());
        }
        return 0;
    }
}
