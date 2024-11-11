/*
package com.mycompany.apartmentrental;

import java.util.ArrayList;
import java.util.Scanner;

record Tenantlist(String name, String type, int id) {
    
    public Tenantlist(String name) {
        this(name, "Double", 1);  
    }
}
public class tenantMaintenance {

    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);
        

        ArrayList<Tenantlist> tenantList = new ArrayList<>();
        
        
        System.out.print("How many tenants do you want to add? ");
        int numberOfTenants = scanner.nextInt();
        scanner.nextLine(); 
        
 
        for (int i = 0; i < numberOfTenants; i++) {
            System.out.println("\nEnter details for tenant " + (i + 1) + ":");
            
   
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
   
            System.out.print("Type (leave blank for default 'Double'): ");
            String type = scanner.nextLine();
            if (type.isEmpty()) {
                type = "Double";
            }
            
    
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            

            tenantList.add(new Tenantlist(name, type, id));
        }


        System.out.println("\nTenant List:");
        for (Tenantlist tenant : tenantList) {
            System.out.println(tenant);
        }


        scanner.close();
    }
}
*/
package com.mycompany.apartmentrental;

import java.util.ArrayList;
import java.util.Scanner;

record Tenantlist(String name, String type, int id) {
    public Tenantlist(String name) {
        this(name, "Double", 1);  // Default constructor with default type and id
    }
}

public class tenantMaintenance {

    // Reusable method for managing tenants
    public static void manageTenants() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tenantlist> tenantList = new ArrayList<>();
        
        System.out.print("How many tenants do you want to add? ");
        int numberOfTenants = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int i = 0; i < numberOfTenants; i++) {
            System.out.println("\nEnter details for tenant " + (i + 1) + ":");
            
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Type (leave blank for default 'Double'): ");
            String type = scanner.nextLine();
            if (type.isEmpty()) {
                type = "Double";  // Default type
            }
            
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            tenantList.add(new Tenantlist(name, type, id)); // Add tenant to list
        }

        // Display tenant list
        System.out.println("\nTenant List:");
        for (Tenantlist tenant : tenantList) {
            System.out.println(tenant);  // Prints each tenant's details
        }

        scanner.close();  // Close the scanner
    }
}
