
package com.mycompany.apfbc;

import java.util.Scanner;

public class ApartmentManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       
        if (login()) {
            showMenu();
        } else {
            System.out.println("Login failed.");
        }
    }

    private static boolean login() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("adminuser")) {
            System.out.println("Login successful\n");
            return true;
        }
        return false;
    }

    private static void showMenu() {
        int selection;
        do {
            System.out.println("| Apartment Management System |");
            System.out.println("Welcome, AMS Admin!\n");
            System.out.println("[1] View Rooms");
            System.out.println("[2] View Tenants");
            System.out.println("[3] Payment Maintenance");
            System.out.println("[4] Apartment Maintenance");
            System.out.println("[5] Tenant Maintenance");
            System.out.println("[6] User Maintenance");
            System.out.println("[7] Change Password");
            System.out.println("[8] About");
            System.out.println("[0] Logout");
            System.out.print("Enter Selection: ");

            selection = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (selection) {
                case 1 -> viewRooms();
                case 2 -> viewTenants();
                case 3 -> paymentMaintenance();
                case 4 -> apartmentMaintenance();
                case 5 -> tenantMaintenance();
                case 6 -> userMaintenance();
                case 7 -> changePassword();
                case 8 -> about();
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid selection. Please try again.");
            }
        } while (selection != 0);
    }

    private static void viewRooms() {
        System.out.println("| View Rooms |");
        System.out.println("Filter by:");
        System.out.println("[1] Room Number");
        System.out.println("[2] Room Type");
        System.out.println("[3] Room Capacity");
        System.out.println("[4] Room Rate");
        System.out.println("[5] Room Status");
        System.out.println("[6] Room Occupant");
        System.out.println("[0] None");

        System.out.print("Enter Selection: ");
        int filterSelection = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Sample output based on selection
        switch (filterSelection) {
            case 1 -> System.out.println("Displaying rooms by Room Number...");
            case 2 -> System.out.println("Displaying rooms by Room Type...");
            case 3 -> System.out.println("Displaying rooms by Room Capacity...");
            case 4 -> System.out.println("Displaying rooms by Room Rate...");
            case 5 -> System.out.println("Displaying rooms by Room Status...");
            case 6 -> System.out.println("Displaying rooms by Room Occupant...");
            case 0 -> System.out.println("Displaying all rooms...");
            default -> System.out.println("Invalid selection.");
        }
    }

    private static void viewTenants() {
        System.out.println("| View Tenants |");

        System.out.println("Listing all tenants...");
    }

    private static void paymentMaintenance() {
        System.out.println("| Payment Maintenance |");
        // Code for payment-related operations
        System.out.println("Managing payments...");
    }

    private static void apartmentMaintenance() {
        System.out.println("| Apartment Maintenance |");
        // Code for apartment maintenance-related operations
        System.out.println("Managing apartment maintenance...");
    }

    private static void tenantMaintenance() {
        System.out.println("| Tenant Maintenance |");
        // Code for tenant management-related operations
        System.out.println("Managing tenants...");
    }

    private static void userMaintenance() {
        System.out.println("| User Maintenance |");
        // Code for user management-related operations
        System.out.println("Managing users...");
    }

    private static void changePassword() {
        System.out.println("| Change Password |");
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        // Code to change the password goes here
        System.out.println("Password has been changed.");
    }


    private static void about() {
        System.out.println("| About |");
        System.out.println("Apartment Management System Version 1.0");
        System.out.println("Developed by: MCC Tricorp");
    }
}
