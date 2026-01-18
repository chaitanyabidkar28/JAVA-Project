package com.cb;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        ArrayList<Student> students = new ArrayList<>();

	        System.out.print("Enter number of students: ");
	        int numStudents = sc.nextInt();

	        for (int i = 0; i < numStudents; i++) {
	            sc.nextLine(); // clear buffer
	            System.out.print("\nEnter student name: ");
	            String name = sc.nextLine();

	            Student student = new Student(name);

	            System.out.print("Enter number of grades: ");
	            int numGrades = sc.nextInt();

	            for (int j = 0; j < numGrades; j++) {
	                System.out.print("Enter grade " + (j + 1) + ": ");
	                int grade = sc.nextInt();
	                student.addGrade(grade);
	            }

	            students.add(student);
	        }

	        // Summary Report
	        System.out.println("\n===== STUDENT GRADE SUMMARY =====");
	        for (Student s : students) {
	            System.out.println("Student: " + s.name);
	            System.out.println("Average Score: " + s.getAverage());
	            System.out.println("Highest Score: " + s.getHighest());
	            System.out.println("Lowest Score: " + s.getLowest());
	            System.out.println("--------------------------------");
	        }

	        sc.close();
	    }
	}



