package com.mycompany.schoolmanagementsystem;

import java.util.Scanner;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("Admin", "admin", "admin");
        Person loggedInUser = null;

        while (true) {
            if (loggedInUser == null) {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Login process
                        System.out.print("Enter username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPassword = scanner.nextLine();

                        loggedInUser = admin.findStudent(loginUsername);
                        if (loggedInUser == null) {
                            loggedInUser = admin.findTeacher(loginUsername);
                        }
                        if (admin.getUsername().equals(loginUsername) && admin.getPassword().equals(loginPassword)) {
                            loggedInUser = admin;
                            System.out.println("Logged in as Admin.");
                        }

                        if (loggedInUser != null && loggedInUser.getPassword().equals(loginPassword)) {
                            System.out.println("Logged in as " + loggedInUser.getName());

                            // Create separate dashboard objects based on the type of user
                            if (loggedInUser instanceof Admin) {
                                Admindashboard adminDashboard = new Admindashboard(admin.getName(), admin.getUsername(), admin.getPassword(), admin, scanner);
                                boolean loggedOut = adminDashboard.show();
                                if (loggedOut) {
                                    loggedInUser = null; // Set to null to show the login page again
                                }
                            } else if (loggedInUser instanceof Teacher) {
                                Teacherdashboard teacherDashboard = new Teacherdashboard((Teacher) loggedInUser, admin, scanner);
                                teacherDashboard.show();
                                loggedInUser = null; // Set to null to show the login page again after logging out
                            } else if (loggedInUser instanceof Student) {
                                Studentdashboard studentDashboard = new Studentdashboard((Student) loggedInUser, scanner);
                                studentDashboard.show();
                                loggedInUser = null; // Set to null to show the login page again after logging out
                            }
                        } else {
                            System.out.println("Invalid username or password.");
                            loggedInUser = null; // Reset loggedInUser
                        }
                        break;
                    case 2:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            }
        }
    }
}
