
package com.mycompany.apartmentrental;

import java.util.Scanner;

public class ApartmentManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private String currentPassword = "adminuser";
    private String[] users = new String[10]; // Assume a maximum of 10 users for simplicity 
    private int userCount = 0;

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
        int selection=-1;
        do {
            System.out.println("\n");
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

            if (scanner.hasNextInt()) {
            selection = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()
            } else {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();  // Consume the invalid input
            continue;
            }


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
        System.out.print("Enter Selection: ");
        
        int filterSelection = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Sample output based on selection
        switch (filterSelection) {
            case 1 -> System.out.println("Display the Room Number...");
            case 2 -> System.out.println("Displaying the Room Type...");
            case 3 -> System.out.println("Displaying the Room Capacity...");
            case 4 -> System.out.println("Displaying the Room Rate...");
            case 5 -> System.out.println("Displaying the Room Status...");
            case 6 -> System.out.println("Displaying the Room Occupant...");
            case 0 -> System.out.println("Displaying all rooms...");
            default -> System.out.println("Invalid selection.");
        }
    }

    private void viewTenants() {
        System.out.println("----------------");
        System.out.println("| View Tenants |");
        System.out.println("----------------");
        
        System.out.println("Filter by:");
        System.out.println("[1] Room Number");
        System.out.println("[2] Tenant Name");
        System.out.println("[3] Tenant Status");
        System.out.println("[0] None");
        System.out.println("\n");
        System.out.print("Enter Selection: ");
        
        
    }

    private void paymentMaintenance() {
        System.out.println("-----------------------");
        System.out.println("| Payment Maintenance |");
        System.out.println("-----------------------");
        // Code for payment-related operations
        // Code for payment-related operations
        System.out.print("Enter Payment ID: ");
        int paymentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Billing ID: ");
        int billingID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Payment Date (YYYY-MM-DD): ");
        String paymentDate = scanner.nextLine();

        System.out.print("Enter Amount: ");
        float amount = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        System.out.println("Select Payment Mode: ");
        System.out.println("[1] GCash");
        System.out.println("[2] Bank Account");
        System.out.println("[3] Credit Card");
        System.out.print("Your choice: ");
        int paymentModeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String paymentMode;
        switch (paymentModeChoice) {
            case 1: 
                paymentMode = "GCash"; 
                break;
            case 2: 
                paymentMode = "Bank Account"; 
                break;
            case 3: 
                paymentMode = "Credit Card"; 
                break;
            default: 
                paymentMode = "Unknown"; 
            System.out.println("Invalid choice. Defaulting to Unknown."); 
                break;
        }

        // Display payment details
        System.out.println("Managing payments...");
        System.out.println("Payment of $" + amount + " on " + paymentDate + " through " + paymentMode + " has been processed.");
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Billing ID: " + billingID);
        System.out.println("\n");
    }

    private void apartmentMaintenance() {
        System.out.println("-------------------------"); 
        System.out.println("| Apartment Maintenance |"); 
        System.out.println("-------------------------"); 
        System.out.println("Options:"); 
        System.out.println("[1] Schedule Maintenance"); 
        System.out.println("[2] View Maintenance Requests"); 
        System.out.println("[3] Update Maintenance Status"); 
        System.out.println("[4] Back to Main Menu"); 
        System.out.println("\n");
        
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter Selection: "); 
        int selection = scanner.nextInt();
        scanner.nextLine();
        
        switch (selection) { 
            case 1: 
                System.out.print("Enter Apartment ID for maintenance: ");
                String apartmentId = scanner.nextLine(); 
                System.out.print("Enter Maintenance Date (YYYY-MM-DD): "); 
                String maintenanceDate = scanner.nextLine(); 
                System.out.println("Maintenance scheduled for Apartment " + apartmentId + " on " + maintenanceDate); 
                break; 
            case 2: 
                System.out.println("Displaying all maintenance requests..."); // Code to fetch and display maintenance requests 
                break; 
            case 3: 
                System.out.print("Enter Maintenance Request ID to update: "); 
                int requestId = scanner.nextInt(); 
                scanner.nextLine(); // Consume the newline 
                System.out.print("Enter new status: "); 
                String status = scanner.nextLine(); 
                System.out.println("Maintenance request " + requestId + " updated to status: " + status); 
                break; 
            case 4: 
                System.out.println("Returning to main menu..."); 
                break; 
            default: System.out.println("Invalid selection. Please try again."); 
            break; 
        }
        System.out.println("\n");
    }

    private void tenantMaintenance() {
        System.out.println("----------------------");
        System.out.println("| Tenant Maintenance |");
        System.out.println("----------------------");
        
        tenantMaintenance.manageTenants();
    }

    void userMaintenance() {
    System.out.println("--------------------");
    System.out.println("| User Maintenance |");
    System.out.println("--------------------");

    while (true) {
        System.out.println("Current Users:");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ". " + users[i]);
        }

        System.out.println("\nChoose an action:");
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.println("3. Update User Information");
        System.out.println("4. Return to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                if (userCount < users.length) {
                    System.out.print("Enter username to add: ");
                    String newUser = scanner.nextLine();
                    users[userCount] = newUser;
                    userCount++;
                    System.out.println(newUser + " has been added.");
                } else {
                    System.out.println("Maximum number of users reached.");
                }
                break;
            case 2:
                System.out.print("Enter user number to remove: ");
                int userToRemove = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (userToRemove > 0 && userToRemove <= userCount) {
                    System.out.println(users[userToRemove - 1] + " has been removed.");
                    for (int i = userToRemove - 1; i < userCount - 1; i++) {
                        users[i] = users[i + 1];
                    }
                    users[userCount - 1] = null;
                    userCount--;
                } else {
                    System.out.println("Invalid user number.");
                }
                break;
            case 3:
                System.out.print("Enter user number to update: ");
                int userToUpdate = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (userToUpdate > 0 && userToUpdate <= userCount) {
                    System.out.print("Enter new information for " + users[userToUpdate - 1] + ": ");
                    String updatedInfo = scanner.nextLine();
                    users[userToUpdate - 1] = updatedInfo;
                    System.out.println("User information has been updated to: " + updatedInfo);
                } else {
                    System.out.println("Invalid user number.");
                }
                break;
            case 4:
                System.out.println("Returning to main menu...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}


    void changePassword() {
        System.out.println("-------------------");
        System.out.println("| Change Password |");
        System.out.println("-------------------");
        
        System.out.print("Enter current password: "); 
        String inputCurrentPassword = scanner.nextLine(); 
        
        if (inputCurrentPassword.equals(currentPassword)) { 
            System.out.print("Enter new password: "); 
            String newPassword = scanner.nextLine(); 
            System.out.print("Confirm new password: "); 
            String confirmPassword = scanner.nextLine(); 
            
            if (newPassword.equals(confirmPassword)) { 
                currentPassword = newPassword; 
                System.out.println("Password has been changed successfully."); 
            } else { 
                System.out.println("Password confirmation does not match. Please try again."); 
            }
        } else { 
            System.out.println("Incorrect current password. Please try again."); 
        } 
    }

    private void about() {
        System.out.println("---------");
        System.out.println("| About |");
        System.out.println("---------");
        System.out.println("Apartment Management System Version 1.0");
        System.out.println("Developed by: MCC Tricorp");
    }
}