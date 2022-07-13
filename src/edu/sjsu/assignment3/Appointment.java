package edu.sjsu.assignment3;

import java.time.LocalDate;

public abstract class Appointment implements Comparable<Appointment>{
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;

    @Override
    public int compareTo(Appointment o){
        if(startDate.isEqual(o.startDate)){
            return startDate.compareTo(o.startDate);
        }else if(!endDate.isEqual(o.endDate)){
            return endDate.compareTo(o.endDate);
        }else return description.compareTo(o.description);
    }

    public abstract boolean occursOn(LocalDate date);

    public Appointment(String description , LocalDate startDate , LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    protected boolean inBetween(LocalDate date){
        return !((date.isBefore(startDate))|| (date.isAfter(endDate)));
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
