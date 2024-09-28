package com.mycompany.schoolmanagementsystem;

import java.util.Scanner;

public class Studentdashboard {
    private Student student;
    Scanner scanner = new Scanner(System.in);
    public Studentdashboard(Student student, Scanner scanner) {
        this.student = student;
        this.scanner = scanner;
    }

    public void show() {
        while (true) {
            System.out.println("ID : " + student.getStudentId());
            System.out.println("Student Options:");
            System.out.println("1. View Courses");
            System.out.println("2. View Grades");
            System.out.println("3. View Student Details");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    viewGrades();
                    break;
                case 3:
                    viewStudentDetails(); // New option to view student details
                    break;
                case 4:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private void viewCourses() {
        System.out.println("Courses:");
        Course[] courses = student.getCourses();
        if (courses != null && courses.length > 0) {
            for (Course course : courses) {
                if (course != null) {
                    System.out.println(course.toString());
                }
            }
        } else {
            System.out.println("No courses enrolled.");
        }
    }

    private void viewGrades() {
        System.out.println("Grades:");
        Course[] courses = student.getCourses();
        if (courses != null && courses.length > 0) {
            for (Course course : courses) {
                if (course != null) {
                    double grade = student.getGradeForCourse(course);
                    if (grade >= 0) {
                        System.out.println(course.getCourseName() + ": " + grade);
                    } else {
                        System.out.println(course.getCourseName() + ": No grade assigned yet.");
                    }
                }
            }
        } else {
            System.out.println("No courses enrolled.");
        }
    }

    private void viewStudentDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + student.getName());
        System.out.println("Username: " + student.getUsername());
        System.out.println("Student ID: " + student.getStudentId()); // Display the student ID
        System.out.println("Level: " + student.getLevel());
    }
}
