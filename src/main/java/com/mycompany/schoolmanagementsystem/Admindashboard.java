package com.mycompany.schoolmanagementsystem;

import java.util.Scanner;

public class Admindashboard extends Person {
    private Admin admin;
    private Scanner scanner;

    public Admindashboard(String name, String username, String password, Admin admin, Scanner scanner) {
        super(name, username, password);
        this.admin = admin;
        this.scanner = scanner;
    }

    public boolean show() {
        while (true) {
            System.out.println("Admin Options:");
            System.out.println("1. Add Teacher");
            System.out.println("2. Add Student");
            System.out.println("3. Delete Teacher");
            System.out.println("4. Delete Student");
            System.out.println("5. List Teachers");
            System.out.println("6. List Students");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    deleteTeacher();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    listTeachers();
                    break;
                case 6:
                    listStudents();
                    break;
                case 7:
                    System.out.println("Logged out.");
                    return true; // Indicate logout
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addTeacher() {
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        System.out.print("Enter teacher username: ");
        String username = scanner.nextLine();
        System.out.print("Enter teacher password: ");
        String password = scanner.nextLine();

        Teacher newTeacher = new Teacher(name, username, password);
        admin.addTeacher(newTeacher);

        System.out.println("Teacher added. Teacher ID: " + newTeacher.getTeacherId());
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student username: ");
        String username = scanner.nextLine();
        System.out.print("Enter student password: ");
        String password = scanner.nextLine();
        System.out.print("Enter student level: ");
        String level = scanner.nextLine();

        Student newStudent = new Student(name, username, password, level);
        admin.addStudent(newStudent);

        System.out.println("Student added. Student ID: " + newStudent.getStudentId());
    }

    private void deleteTeacher() {
        System.out.print("Enter teacher username to delete: ");
        String username = scanner.nextLine();

        Teacher teacher = admin.findTeacher(username);
        if (teacher != null) {
            admin.removeTeacher(teacher);
            System.out.println("Teacher removed.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter student username to delete: ");
        String username = scanner.nextLine();

        Student student = admin.findStudent(username);
        if (student != null) {
            admin.removeStudent(student);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void listTeachers() {
        Teacher[] teachers = admin.getTeachers();
        if (teachers.length > 0) {
            System.out.println("List of teachers:");
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        } else {
            System.out.println("No teachers available.");
        }
    }

    private void listStudents() {
        Student[] students = admin.getStudents();
        if (students.length > 0) {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students available.");
        }
    }
}
