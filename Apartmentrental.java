
package com.mycompany.apartmentrental;

import java.util.Scanner;

public class Apartmentrental {

    public static void main(String[] args) {
        ApartmentManagementSystem system = new ApartmentManagementSystem();
        // Mock login method (can be replaced with actual authentication logic)
        if (system.login()) {
            system.showMenu();
        } else {
            System.out.println("Login failed.");
        }
        
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter Selection: "); 
        int selection = scanner.nextInt();
        scanner.nextLine();
        
        ApartmentManagementSystem app = new ApartmentManagementSystem();
        app.changePassword();
        app.userMaintenance();
        
    }
}


