package com.mycompany.schoolmanagementsystem;

class Teacher extends Person {
    private String teacherId;
    private Course[] courses = new Course[10]; // Maximum 10 courses
    private int courseCount = 0;

    // Constructor automatically generates a teacher ID
    public Teacher(String name, String username, String password) {
        super(name, username, password);
        this.teacherId = IDGenerator.generateTeacherId(); // Generate teacher ID automatically
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Course[] getCourses() {
        return courses;
    }

    // Method to add a course to the teacher's list
    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
        } else {
            System.out.println("Course list is full.");
        }
    }

    // Method to display the teacher's details
    public void displayTeacherDetails() {
        System.out.println("Teacher Name: " + getName());
        System.out.println("Username: " + getUsername());
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Courses:");
        if (courseCount == 0) {
            System.out.println("No courses assigned.");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + courses[i].getCourseName());
            }
        }
    }

    @Override
    public String toString() {
        return "Teacher{name='" + getName() + "', username='" + getUsername() + "', teacherId='" + teacherId + "'}";
    }
}
