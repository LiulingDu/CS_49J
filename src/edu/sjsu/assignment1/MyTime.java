package edu.sjsu.assignment1;

public class MyTime {
    public static void main(String[] args) {
        printTimeDifference("0120", "1510");
    }
        /*
        Write a public static function that takes two Strings as two times in military format (hhmm) and
        prints the number of hours and minutes between the two times. If the first time is later than the
        second time, assume the second time is the next day (i.e., add 24 hours to the second time).
Specifications
• Package name: edu.sjsu.assignment1
• Class name: MyTime
• Method name: printTimeDifference
• Output format: X hour(s) Y minute(s)
         */
    public static void printTimeDifference(String time1,String time2) {
        // Convert times to minutes in integer
        int t1 = militaryToMinutes(time1);
        int t2 = militaryToMinutes(time2);
        // compute difference
        int difference= t2 - t1;
        // if difference < 0
        //      add 24 hours to be the difference
        //      since t2 + 24 - t1 = t2 - t1 + 24
        if(difference<0){
            difference=difference+24*60;
        }
        // separate the difference to hour & minutes
        int hour= difference / 60;
        int minutes=difference % 60;
        // printout
        System.out.println(hour+ " hour(s) " + minutes + " minute(s)");
    }

    private static int militaryToMinutes(String time){
        // Convert String to integer
        int t=Integer.parseInt(time);
        // Separate hhmm -> h and m;
        // eg.1155 -> 11 & 55
        int h = t / 100;
        int m = t % 100;
        // minutes= h * 60 + m;
        return h * 60 + m;
    }
}