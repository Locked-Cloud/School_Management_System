
package com.mycompany.schoolmanagementsystem;

class Course {
    private String name;
    private Teacher teacher;
    private Student[] students = new Student[30];
    private int studentCount = 0;

    public Course(String name, Teacher teacher, int maxStudents) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getCourseName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("Student list is full.");
        }
    }


    public void removeStudent(Student student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] == student) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null;
                break;
            }
        }
    }

    public void listStudents() {
        System.out.println("Students in " + name + ":");
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                System.out.println(students[i].getName() + " (" + students[i].getUsername() + ")");
            }
        }
    }

    @Override
    public String toString() {
        return "Course Name: " + name + ", Teacher: " + teacher.getName();
    }
}
