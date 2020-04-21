import java.util.*;

import java.lang.*;
import java.io.*;
// The student class contains all methods to be used by a student after logging in 
public class Student extends User implements StudentInterface, java.io.Serializable {
	
	public Student(String f, String l, String u, String p) {
		String first = f;
		String last = l;
		String username = u;
		String password = p;
	}
	
	// 1. View all courses
	public static void viewAll() {
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			Serialization.serCourse.get(i).printCourseInfoStudent();
		}
	}
	
	// 2. View all courses that are NOT full 
	public static void viewNotFull() {
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getMax() > Serialization.serCourse.get(i).getNumEnrolled()) {
				Serialization.serCourse.get(i).printCourseInfo();
			}
		}
	}
	
	// 3. Register for a course
	public static void register() {
		Scanner input = new Scanner(System.in);
		System.out.println("Register for a course\n");
		System.out.println("Course name: ");
		String course_name = input.nextLine();
		System.out.println("Section: \n");
		int section = input.nextInt();
		System.out.println("Student first name:\n");
		String first_name = input.nextLine();
		System.out.println("Student last name:\n");
		String last_name = input.nextLine();
		
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getCourse_name().equals(course_name)
				&& Serialization.serCourse.get(i).getSection() == section) {
				
				for (int j=0; j<Serialization.serCourse.get(i).getEnrolledStudents().size(); j++) {
					if (Serialization.serCourse.get(i).getEnrolledStudents().get(j) == null) {
						Serialization.serCourse.get(i).getEnrolledStudents().get(j).setFirst(first_name);
						Serialization.serCourse.get(i).getEnrolledStudents().get(j).setLast(last_name);
					}
				}
			System.out.println("Successfully registered");
			}
		}
	}
	
	// 4. Withdraw from a course
	// this will remove the student's name from the course's enrolled names
	// also will decrease the number enrolled in the course by 1
	public static void withdraw() {
		Scanner input = new Scanner(System.in);
		System.out.println("Student first name: \n");
		String first = input.nextLine();
		System.out.println("Student last name: \n");
		String last = input.nextLine();
		System.out.println("Course name: \n");
		String course_name = input.nextLine();
		
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getCourse_name().equals(course_name)) {
				int currentNum = Serialization.serCourse.get(i).getNumEnrolled();
				int newNum = currentNum - 1;
				Serialization.serCourse.get(i).setNumEnrolled(newNum);
				
				for (int j=0; j<Serialization.serCourse.get(i).getEnrolledStudents().size(); j++) {
					if (Serialization.serCourse.get(i).getEnrolledStudents().get(j).getFirst().equals(first)
						&& Serialization.serCourse.get(i).getEnrolledStudents().get(j).getLast().equals(last)) {
						Serialization.serCourse.get(i).getEnrolledStudents().get(j).setFirst(null);
						Serialization.serCourse.get(i).getEnrolledStudents().get(j).setLast(null);
						Serialization.serCourse.get(i).getEnrolledStudents().get(j).setUsername(null);;
						Serialization.serCourse.get(i).getEnrolledStudents().get(j).setPassword(null);
					}
				}
			}
		}
		System.out.println("Successfully withdrawn");
		
	}
	
	// 5. View courses that a specific student is registered in 
	public static void viewEnrolled() {
		Scanner input = new Scanner(System.in);
		System.out.println("Student first name: \n");
		String first = input.nextLine();
		System.out.println("Student last name: \n");
		String last = input.nextLine();
		
		System.out.println(first + " " + last + " is enrolled in: \n");
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getEnrolledStudents().get(i).getFirst().equals(first)
				&& Serialization.serCourse.get(i).getEnrolledStudents().get(i).getLast().equals(last)) {
				Serialization.serCourse.get(i).printCourseInfo();
			}
		}
	}

}
