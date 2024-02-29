package com;



import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained (out of 100) in each subject.
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int subjects = 5; // Assuming there are 5 subjects
        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Subject " + i + ": ");
            int marks = scanner.nextInt();
            
            // Validate input marks (assuming marks are between 0 and 100)
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                i--; // Decrement i to repeat the input for the current subject
            } else {
                totalMarks += marks;
            }
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / subjects;
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Grade Calculation: Assign grades based on the average percentage achieved.
        String grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Grade Calculation Method
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

