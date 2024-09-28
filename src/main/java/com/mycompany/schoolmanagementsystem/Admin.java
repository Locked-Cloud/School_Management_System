package com.mycompany.schoolmanagementsystem;

// Simple Admin class that manages teachers, students, and courses
class Admin extends Person {
    private Teacher[] teachers = new Teacher[10]; // Array to hold teachers
    private Student[] students = new Student[10]; // Array to hold students
    private Course[] courses = new Course[10]; // Array to hold courses
    private int teacherCount = 0; // Track how many teachers have been added
    private int studentCount = 0; // Track how many students have been added
    private int courseCount = 0; // Track how many courses have been added

    public Admin(String name, String username, String password) {
        super(name, username, password);
    }

    // Add a new teacher to the teachers array
    public void addTeacher(Teacher teacher) {
        if (teacherCount < teachers.length) {
            teachers[teacherCount] = teacher;
            teacherCount++;
        } else {
            System.out.println("Teacher list is full.");
        }
    }

    // Add a new student to the students array
    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("Student list is full.");
        }
    }

    // Add a new course to the courses array
    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount] = course;
            courseCount++;
        } else {
            System.out.println("Course list is full.");
        }
    }

    // Find a teacher by their username
    public Teacher findTeacher(String username) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getUsername().equals(username)) {
                return teachers[i];
            }
        }
        return null;
    }

    // Find a student by their username
    public Student findStudent(String username) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getUsername().equals(username)) {
                return students[i];
            }
        }
        return null;
    }

    // Find a course by its name
    public Course findCourse(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equals(courseName)) {
                return courses[i];
            }
        }
        return null;
    }


    // Remove a teacher by their username
    public void removeTeacher(Teacher teacher) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getUsername().equals(teacher.getUsername())) {
                teachers[i] = teachers[teacherCount - 1]; // Replace with the last teacher
                teacherCount--;
                return;
            }
        }
        System.out.println("Teacher not found.");
    }

    // Remove a student by their username
    public void removeStudent(Student student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getUsername().equals(student.getUsername())) {
                students[i] = students[studentCount - 1]; // Replace with the last student
                studentCount--;
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Get an array of all teachers
    public Teacher[] getTeachers() {
        Teacher[] result = new Teacher[teacherCount];
        for (int i = 0; i < teacherCount; i++) {
            result[i] = teachers[i];
        }
        return result;
    }

    // Get an array of all students
    public Student[] getStudents() {
        Student[] result = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            result[i] = students[i];
        }
        return result;
    }
}
