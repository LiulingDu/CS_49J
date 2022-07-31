package edu.sjsu.assignment4_Part2;

import java.time.LocalDate;
import java.util.*;

public class AppointmentManager {
    static HashMap<String, Appointment> appointmentMap = new HashMap<>();
    static String description;
    static LocalDate startDate;
    static LocalDate endDate;
    static String type;

    public static void main(String[] args) {
        System.out.printf("(a) for adding an appointment; \n" + "(d) for deleting an appointment; \n" + "(v) for viewing all appointments; \n" + "(q) for quitting the program; \n" + "Please choose an option: ");
        // take user input
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                validate(input);
                if (input.matches("a")) {
                    addAnAppointment();
                } else if (input.matches("d")) {
                    deleteAnAppointment();
                } else if (input.matches("v")) {
                    printAllAppointment();
                    System.out.printf("(a) for adding an appointment; \n" + "(d) for deleting an appointment; \n" + "(v) for viewing all appointments; \n" + "(q) for quitting the program; \n" + "Please choose an option: ");
                } else if (input.matches("q")) {
                    System.out.print("Thank you for using the program. Have a nice day! ");
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void validate(String input) {
        if (!(input.matches("a") || input.matches("d") || input.matches("v") || input.matches("q"))) {
            throw new IllegalArgumentException("Sorry, wrong option! \n" + "Please enter again:");
        }
    }

    public static void addAnAppointment() {
        // - input type
        System.out.printf("Please enter the type (onetime, daily or monthly):");
        Scanner scannerType = new Scanner(System.in);
        type = scannerType.nextLine();

        // input all the info
        // - input description
        System.out.printf("Please enter a description:");
        Scanner scannerDescription = new Scanner(System.in);
        description = scannerDescription.nextLine();
        // validate and add the appointment
        ValidateAppointment(description);

        // - input startDate and validate format
        System.out.printf("Please enter the starting date (yyyy-mm-dd):");
        Scanner scannerStartingDate = new Scanner(System.in);
        try {
            startDate = LocalDate.parse(scannerStartingDate.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date!");
        }

        // - input endDate and validate format
        System.out.printf("Please enter the ending date (yyyy-mm-dd):");
        Scanner scannerEndingDate = new Scanner(System.in);
        try {
            endDate = LocalDate.parse(scannerEndingDate.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date!  ");
        }

        appointmentMap.put(description , new Appointment(startDate , endDate , type , description) {
            @Override
            public int compareTo(Appointment o) {
                if (!startDate.isEqual(o.startDate)) {
                    return startDate.compareTo(o.startDate);
                } else if (!endDate.isEqual(o.endDate)) {
                    return endDate.compareTo(o.endDate);
                } else return type.compareTo(o.type);
            };

            @Override
            public boolean occursOn(LocalDate date) {
                return false;
            }
        });
        System.out.println("Appointment added! ");
        System.out.printf("(a) for adding an appointment; \n" + "(d) for deleting an appointment; \n" + "(v) for viewing all appointments; \n" + "(q) for quitting the program; \n" + "Please choose an option: ");
    }

    private static void ValidateAppointment(String description) {
        if (appointmentMap.containsKey(description)) System.out.println("Description already exists.");
    }

    private static void deleteAnAppointment() {
        if (appointmentMap.isEmpty()) {
            System.out.printf("Sorry, no appointment to delete, please add an appointment first! \n" +
                    "Please enter again: ");
        } else {
            System.out.printf("Please enter the description of the appointment you want delete:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            while (!appointmentMap.containsKey(input)) {
                System.out.printf("Sorry, appointment not found! Please enter again! \n" +
                        "Please enter the description of the appointment you want delete:");
                Scanner scannerAgain = new Scanner(System.in);
                input = scannerAgain.nextLine();
            }
            appointmentMap.remove(input);
            System.out.println("Appointment deleted!");
            System.out.printf("(a) for adding an appointment; \n" + "(d) for deleting an appointment; \n" + "(v) for viewing all appointments; \n" + "(q) for quitting the program; \n" + "Please choose an option: ");
        }
    }


    private static void printAllAppointment() {
        if (appointmentMap.isEmpty()) {
            System.out.println("No any appointment now. ");
        }
        TreeSet<Appointment> appointmentTreeSet = new TreeSet<>(appointmentMap.values());
        for (Appointment appointment : appointmentTreeSet) {
            System.out.println(appointment);
        }
    }
}
