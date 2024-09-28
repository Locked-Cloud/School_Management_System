package com.mycompany.schoolmanagementsystem;

public class IDGenerator {
    private static int teacherIdCounter = 1;

    public static String generateTeacherId() {
        return "T" + teacherIdCounter++; // Generates IDs like T1, T2, T3, etc.
    }
}
