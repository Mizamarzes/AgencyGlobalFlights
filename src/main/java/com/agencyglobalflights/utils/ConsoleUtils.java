package com.agencyglobalflights.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner sc = new Scanner(System.in);

    private static final String REGEX_DATE = "^(?:\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12][0-9]|3[01]))$";
    private static final String REGEX_DOUBLE = "^\\d{1,5}(\\.\\d{1,2})?$"; // Max 7 digits with 2 decimal places

    
    // Clean the console
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // time wait for show up information
    public static void waitWindow(){
        System.out.println("");
        System.out.println("Press enter to continue");
        sc.nextLine();
    }

    // verify if it is a number without range, i mean any number
    public static int verifyingIntNoRange(){
        int option = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                option = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.next();  
            }
        }
        
        return option;
    }

    // verify if it is a number and you must enter the min and the max
    public static int verifyEntryInt(int min, int max) {
        int option = -1;

        while (true) {
            try {
                option = sc.nextInt();
                sc.nextLine();
                if (option >= min && option <= max) {
                    break; 
                } else {
                    System.out.println("Invalid input. Please, select an option between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please, enter a number between " + min + " and " + max + ".");
                sc.nextLine(); 
            }
        }

        return option;
    }

    // verify if it is text
    public static String verifyEntryString() {
        String entry = "";

        while (true) {
            entry = sc.nextLine().trim(); 
            if (!entry.isEmpty()) {
                break; 
            } else {
                System.out.println("Invalid input. Please enter text only.");
            }
        }

        return entry; 
    }

    // this method confirms the format of the date
    public static Date verifyDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        while (true) {
            try {
                String dateStr = sc.nextLine().trim();
                java.util.Date utilDate = formatter.parse(dateStr);
                return new Date(utilDate.getTime());
            } catch (ParseException e) {
                System.out.println("Formato de fecha no válido. Por favor, ingrese la fecha en el formato yyyy-MM-dd.");
            }
        }
    }

    // this method confirms, if the data entered is DOUBLE(7, 2)
    public static double verifyingDouble() {
        double option = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = sc.next();
                option = Double.parseDouble(input);
                sc.nextLine();

                // Validar formato
                if (input.matches("^\\d{1,5}(\\.\\d{1,2})?$")) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number in the format XXXXX.XX");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double number.");
                sc.nextLine();
            }
        }

        return option;
    }

    // verify the format from string
    public static String verifyingStringFormat(String regex, String type) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            input = sc.nextLine();

            if (input.matches(regex)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please follow the format for a valid " + type + ".");
            }
        }

        return input;
    }

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // REGEX DATE FUNCTIONS

    // VERIFY DATE
    public static String verifyingDateREGEX() {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            input = sc.nextLine();

            if (input.matches(REGEX_DATE)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a date in the format yyyy-mm-dd.");
            }
        }

        return input;
    }

    public static String verifyingStringMaxStringREGEX(int maxLength) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            input = sc.nextLine();

            if (input.length() <= maxLength) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a string with at most " + maxLength + " characters.");
            }
        }

        return input;
    }

    public static String verifyingDoubleREGEX() {
        String input = "";
        boolean validInput = false;
    
        while (!validInput) {
            input = sc.nextLine();
    
            if (input.matches(REGEX_DOUBLE)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid double with at most 7 digits and 2 decimal places.");
            }
        }
    
        return input;
    }
   
    public static String verifyingIntREGEXString() {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            input = sc.nextLine();

            try {
                Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer(numbers only).");
            }
        }

        return input;
    }
}
