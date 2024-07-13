package com.agencyglobalflights;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner sc = new Scanner(System.in);
    
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
}
