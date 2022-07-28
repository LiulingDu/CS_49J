package edu.sjsu.assignment3;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class AppointmentManager {
    static HashMap<String, Appointment> appointmentMap = new HashMap<>();
    static String description=null;
    static TreeSet<Appointment> appointmentTreeSet = new TreeSet<>((Comparator) new AppointmentComp());

    public static void main(String[] args) {
        while (true) {
            try {
                // take user input
                System.out.printf("(a) for adding an appointment; \n" +
                        "(d) for deleting an appointment; \n" +
                        "(v) for viewing all appointments; \n" +
                        "(q) for quitting the program; \n"+
                        "Please choose an option: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                validate(input);
                if (input.matches("a")) {
                    addAnAppointment();
                }
                if (input.matches("d")) {
                    deleteAnAppointment();
                }
                if (input.matches("v")){
                    printAllAppointment();
                }
                if (scanner.nextLine().equals("q")) {
                    System.out.println("Thank you for using the program. Have a nice day! ");
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void validate(String input) {
        if (!(input.matches("a") || input.matches("d") || input.matches("v") || input.matches("q"))) {
            throw new IllegalArgumentException("Sorry, wrong option! \n" +
                    "Please enter again:");
        }
    }

    public static void addAnAppointment() {
        LocalDate startDate=null;
        LocalDate endDate=null;
        String type=null;
        Appointment appointment = new Appointment(type , startDate , endDate) {
            @Override
            public boolean occursOn(LocalDate date) {
                return false;
            }
        };
        // input all the info
        // - input description
        System.out.println("Please enter a description:");
        Scanner scannerDescription = new Scanner(System.in);
        description = scannerDescription.nextLine();
        // validate and add the appointment
        ValidateAppointment(description,appointment);
        // - input type
        System.out.println("Please enter the type (onetime, daily or monthly):");
        Scanner scannerType = new Scanner(System.in);
        type = scannerType.nextLine();
        appointment.type=type;
        // - input startDate and validate format
        System.out.println("Please enter the starting date (yyyy-mm-dd)");
        Scanner scannerStartingDate = new Scanner(System.in);
        try{
            String startingDate = scannerStartingDate.nextLine();
            appointment.startDate = LocalDate.parse(startingDate);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid date! Try again! ");
        }
        // - input endDate and validate format
        System.out.println("Please enter the ending date (yyyy-mm-dd)");
        Scanner scannerEndingDate = new Scanner(System.in);
        try{
            String endingDate = scannerEndingDate.nextLine();
            appointment.endDate = LocalDate.parse(endingDate);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid date! Try again! ");
        }
        appointmentMap.put(description,appointment);
        appointmentTreeSet.add(appointment);
        System.out.println("Appointment added! ");
    }

    private static boolean ValidateAppointment(String description,Appointment appointment) {
        if (appointmentMap.containsKey(description))
            return false;
        appointmentMap.put(String.valueOf(description) , appointment);
        return true;
    }

    private static void deleteAnAppointment() {
        while (true) {
            if (appointmentMap.isEmpty()) {
                System.out.println("Sorry, no appointment to delete, please add an appointment first! \n" +
                        "Please enter again: ");
            } else {
                System.out.println("Please enter the description of the appointment you want delete:");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (!appointmentMap.containsKey(input)) {
                    System.out.println("Sorry, appointment not found! Please enter again! ");
                } else {
                    appointmentMap.remove(input);
                    System.out.println("Appointment deleted!");
                }
            }
        }
    }

    private static void printAllAppointment() {
        if (appointmentMap.isEmpty()) {
            System.out.println("No any appointment now. ");
        }
        appointmentTreeSet.forEach(appointment ->
                System.out.println(description + ", from " +  Appointment.getStartDate()+  " to " + Appointment.getEndDate()+ ", " + Appointment.getType())
        );
    }
}
