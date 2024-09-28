package com.mycompany.schoolmanagementsystem;

class Student extends Person {
    private static int idCounter = 1; // Static counter to generate unique IDs
    private String studentId;
    private String level;
    private Course[] courses = new Course[10];
    private double[] grades = new double[10];
    private int courseCount = 0;

    public Student(String name, String username, String password, String level) {
        super(name, username, password);
        this.level = level;
        this.studentId = generateStudentId(); // Generate student ID automatically
    }

    public Course[] getCourses() {
        return courses;
    }

    private String generateStudentId() {
        return "S" + (idCounter++); // Example ID format: "S1", "S2", etc.
    }

    public String getStudentId() {
        return studentId;
    }

    public String getLevel() {
        return level;
    }

    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount] = course;
            grades[courseCount] = -1; // Default value indicating no grade
            courseCount++;
        } else {
            System.out.println("Course list is full.");
        }
    }

    public void removeCourse(Course course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equals(course.getCourseName())) {
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1];
                    grades[j] = grades[j + 1];
                }
                courses[--courseCount] = null;
                grades[courseCount] = -1; // Reset grade
                return;
            }
        }
    }

    public void modifyGrade(Course course, double newGrade) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equals(course.getCourseName())) {
                grades[i] = newGrade;
                return;
            }
        }
    }

    /*public double calculateGPA() {
        if (courseCount == 0) {
            return 0.0;
        }
        double total = 0;
        int validGrades = 0;
        for (double grade : grades) {
            if (grade >= 0) { // Only include valid grades
                total += grade;
                validGrades++;
            }
        }
        return validGrades > 0 ? total / validGrades : 0.0;
    }*/

    public double getGradeForCourse(Course course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equals(course.getCourseName())) {
                return grades[i];
            }
        }
        return -1; // Indicate that the course was not found
    }

   /* public String getCourseGrades() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courseCount; i++) {
            sb.append(courses[i].getCourseName()).append(": ").append(grades[i]).append("\n");
        }
        return sb.toString();
    }*/

    @Override
    public String toString() {
        return "Student{name='" + getName() + "', username='" + getUsername() + "', studentId='" + studentId + "', level='" + level + "'}";
    }

}
