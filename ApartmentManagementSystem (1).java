package com.mycompany.apartmentrental;

import java.util.Scanner;

public class ApartmentManagementSystem {
    private static Scanner scanner = new Scanner(System.in);

    public boolean login() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();                                                                           
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("adminuser")) {
            System.out.println("Login successful\n");
            return true;
        } else {
            System.out.println("Tenant login failed. Invalid username or password.");
        }
        return false;
    }

    public void showMenu() {
        int selection;
        do {
            System.out.println("-------------------------------");
            System.out.println("| Apartment Management System |");
            System.out.println("-------------------------------");
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

    private void viewRooms() {
        System.out.println("--------------");
        System.out.println("| View Rooms |");
        System.out.println("--------------");
        System.out.println("Filter by:");
        System.out.println("[1] Room Number");
        System.out.println("[2] Room Type");
        System.out.println("[3] Room Capacity");
        System.out.println("[4] Room Rate");
        System.out.println("[5] Room Status");
        System.out.println("[6] Room Occupant");
        System.out.println("[0] None");
        System.out.println("\n");
        System.out.println("Enter Selection: ");
    }

    private void viewTenants() {
        System.out.println("----------------");
        System.out.println("| View Tenants |");
        System.out.println("----------------");
        // Implementation details...
    }

    private void paymentMaintenance() {
        System.out.println("-----------------------");
        System.out.println("| Payment Maintenance |");
        System.out.println("-----------------------");
        System.out.print("Enter Payment ID: ");
        int paymentID = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Billing ID: ");
        int billingID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Payment Date (YYYY-MM-DD): ");
        String paymentDate = scanner.nextLine();

        System.out.print("Enter Amount: ");
        float amount = scanner.nextFloat();
        scanner.nextLine(); 
    }

    private void apartmentMaintenance() {
        System.out.println("-------------------------"); 
        System.out.println("| Apartment Maintenance |"); 
        System.out.println("-------------------------");
        // Implementation details...
    }

    private void tenantMaintenance() {
        System.out.println("----------------------");
        System.out.println("| Tenant Maintenance |");
        System.out.println("----------------------");
        // Implementation details...
    }

    private void userMaintenance() {
        System.out.println("--------------------");
        System.out.println("| User Maintenance |");
        System.out.println("--------------------");
        // Implementation details...
    }

    private void changePassword() {
        System.out.println("-------------------");
        System.out.println("| Change Password |");
        System.out.println("-------------------");
        // Implementation details...
    }

    private void about() {
        System.out.println("---------");
        System.out.println("| About |");
        System.out.println("---------");
        System.out.println("Apartment Management System Version 1.0");
        System.out.println("Developed by: MCC Tricorp");
    }
}
