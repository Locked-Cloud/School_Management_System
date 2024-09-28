package com.mycompany.schoolmanagementsystem;

import java.util.Scanner;

public class Teacherdashboard {
    private Teacher teacher;
    private Admin admin;
    private Scanner scanner;
    private Course[] courses = new Course[10]; // Array to hold courses
    private int courseCount = 0; // Counter to track the number of courses

    public Teacherdashboard(Teacher teacher, Admin admin, Scanner scanner) {
        this.teacher = teacher;
        this.admin = admin;
        this.scanner = scanner;
    }

    public void show() {
        while (true) {
            System.out.println("ID : " + teacher.getTeacherId());
            System.out.println("Teacher Options:");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Show All Courses");
            System.out.println("4. Add Student to Course");
            System.out.println("5. Remove Student from Course");
            System.out.println("6. Add Grade");
            System.out.println("7. Edit Grade");
            System.out.println("8. List Students in Course");
            System.out.println("9. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    removeCourse();
                    break;
                case 3:
                    showAllCourses();
                    break;
                case 4:
                    addStudentToCourse();
                    break;
                case 5:
                    removeStudentFromCourse();
                    break;
                case 6:
                    addGrade();
                    break;
                case 7:
                    modifyGrade();
                    break;
                case 8:
                    listStudentsInCourse();
                    break;
                case 9:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addCourse() {
        if (courseCount >= courses.length) {
            System.out.println("Cannot add more courses. Maximum limit reached.");
            return;
        }

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = new Course(courseName, teacher, 30); // Max students 30

        admin.addCourse(course); // Add course to admin's list
        courses[courseCount++] = course; // Add course to teacher's list
        System.out.println("Course added.");
    }

    public void showAllCourses() {
        if (courseCount == 0) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("List of all courses:");
        for (int i = 0; i < courseCount; i++) {
            if (courses[i] != null) {
                System.out.println("Course " + (i + 1) + ": " + courses[i].getCourseName());
            }
        }
    }

    public void removeCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equals(courseName)) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--courseCount] = null;
                System.out.println("Course removed.");
                return;
            }
        }
        System.out.println("Course not found.");
    }

    private void addStudentToCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = admin.findCourse(courseName);

        System.out.print("Enter student username: ");
        String studentUsername = scanner.nextLine();
        Student student = admin.findStudent(studentUsername);

        if (course != null && student != null) {
            course.addStudent(student);
            student.addCourse(course);
            System.out.println("Student added to course.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private void removeStudentFromCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = admin.findCourse(courseName);

        System.out.print("Enter student username: ");
        String studentUsername = scanner.nextLine();
        Student student = admin.findStudent(studentUsername);

        if (course != null && student != null) {
            course.removeStudent(student);
            student.removeCourse(course);
            System.out.println("Student removed from course.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private void addGrade() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = admin.findCourse(courseName);

        System.out.print("Enter student username: ");
        String studentUsername = scanner.nextLine();
        Student student = admin.findStudent(studentUsername);

        if (course != null && student != null) {
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            student.modifyGrade(course, grade);
            System.out.println("Grade added.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private void modifyGrade() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = admin.findCourse(courseName);

        System.out.print("Enter student username: ");
        String studentUsername = scanner.nextLine();
        Student student = admin.findStudent(studentUsername);

        if (course != null && student != null) {
            System.out.print("Enter new grade: ");
            double newGrade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            student.modifyGrade(course, newGrade);
            System.out.println("Grade modified.");
        } else {
            System.out.println("Course or student not found.");
        }
    }

    private void listStudentsInCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = admin.findCourse(courseName);

        if (course != null) {
            course.listStudents();
        } else {
            System.out.println("Course not found.");
        }
    }
}
