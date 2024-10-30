
package com.mycompany.apfbc;

import java.util.Scanner;

public class loginInterface {
    
    private static final String TENANT_USERNAME = "tenant";
    private static final String TENANT_PASSWORD = "tenant123";

    public static void main(String[] args) {
        loginInterface LoginInterface = new loginInterface();
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Select login type: \n1. Admin \n2. Tenant");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        switch (choice) {
            case 1:
                LoginInterface.adminLoginAccount(scanner);
                break;
            case 2:
                LoginInterface.tenantLoginAccount(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please select either 1 or 2.");
        }

        scanner.close();
    }

    
    public void adminLoginAccount(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            System.out.println("Admin login successful!");
        } else {
            System.out.println("Admin login failed. Invalid username or password.");
        }
    }

    
    public void tenantLoginAccount(Scanner scanner) {
        System.out.print("Enter tenant username: ");
        String username = scanner.nextLine();
        System.out.print("Enter tenant password: ");
        String password = scanner.nextLine();

        if (TENANT_USERNAME.equals(username) && TENANT_PASSWORD.equals(password)) {
            System.out.println("Tenant login successful!");
        } else {
            System.out.println("Tenant login failed. Invalid username or password.");
        }
    }
}

