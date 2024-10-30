
package com.mycompany.apartmentrental;

public class Apartmentrental {

    public static void main(String[] args) {
        ApartmentManagementSystem system = new ApartmentManagementSystem();
        // Mock login method (can be replaced with actual authentication logic)
        if (system.login()) {
            system.showMenu();
        } else {
            System.out.println("Login failed.");
        }
    }
}
