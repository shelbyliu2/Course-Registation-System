// Admin class contains methods to be used by admins upon logging in 
import java.util.*;
import java.lang.*;
import java.io.*;

public class Admin extends User implements AdminInterface, java.io.Serializable, Comparable {
	
	public Admin(String f, String l, String u, String p) {
		String first = f;
		String last = l;
		String username = u;
		String password = p;
	}
	
	// COURSE MANAGEMENT
	
	// 1. Create a new course
	public static void createNew() throws IOException{
		
		Scanner input = new Scanner(System.in);
		System.out.println("Course name: ");
		String course_name = input.next();
		
		System.out.println("Course ID: ");
		String course_id = input.next();
		
		System.out.println("Max number of students: ");
		int max = input.nextInt();
		
		int numEnrolled = 0;
		
		ArrayList <Student> enrolledStudents = new ArrayList <Student> ();
		
		System.out.println("Instructor: ");
		String instructor = input.next();
		
		System.out.println("Section: ");
		int section = input.nextInt();
		
		System.out.println("Location: ");
		String location = input.next();
		
		Course newCourse = new Course(course_name, course_id, max, numEnrolled, instructor, section, location, enrolledStudents);
		
		Serialization.serCourse.add(newCourse);
	
		System.out.println("Course added.");
	}
	
	// 2. Delete a course
	public static void delete() {
		Course c = new Course();
		Scanner input = new Scanner(System.in);
		System.out.println("Course ID to delete: ");
		String course_id = input.nextLine();
		
		// Find course ID in course info 
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getCourse_id().equals(course_id)) {
				Serialization.serCourse.remove(i);
			}
		}
	}
	
	// 3. Edit a course
	public static void edit() {
		Scanner input = new Scanner(System.in);
		Course c = new Course();
		
		System.out.println("Course ID: ");
		String course_id = input.nextLine();
		
		System.out.println("What would you like to edit?\n");
		System.out.println("1. Max number of students\n");
		System.out.println("2. Instructor\n");
		System.out.println("3. Section\n");
		System.out.println("4. Location\n");
		int choice = input.nextInt();
		
		// Edit the max number of students
		if (choice == 1) {
			System.out.println("New max number of students: \n");
			int newMax = input.nextInt();
			
			for (int i=0; i<Serialization.serCourse.size(); i++) {
				if (Serialization.serCourse.get(i).getCourse_id().equals(course_id)) {
					Serialization.serCourse.get(i).setMax(newMax);
				}
			}
		}
		
		// Edit instructor name
		if (choice == 2) {
			System.out.println("New instructor name: \n");
			String newInstructor = input.nextLine();
			
			for (int i=0; i<Serialization.serCourse.size(); i++) {
				if (Serialization.serCourse.get(i).getCourse_id().equals(course_id)) {
					Serialization.serCourse.get(i).setInstructor(newInstructor);
				}
			}
		}
		
		// Edit section 
		if (choice == 3) {
			System.out.println("New section: \n");
			int newSection = input.nextInt();
			
			for (int i=0; i<Serialization.serCourse.size(); i++) {
				if (Serialization.serCourse.get(i).getCourse_id().equals(course_id)) {
					Serialization.serCourse.get(i).setSection(newSection);
				}
			}
		}
		
		// Edit location
		if (choice == 4) {
			System.out.println("New location: \n");
			String newLocation = input.nextLine();
			
			for (int i=0; i<Serialization.serCourse.size(); i++) {
				if (Serialization.serCourse.get(i).getCourse_id().equals(course_id)) {
					Serialization.serCourse.get(i).setLocation(newLocation);;
				}
			}
		}
	}
	
	// 4. Display a course's info
	public static void displayCourseInfo() {
		Scanner input = new Scanner(System.in);		
		System.out.println("Course ID: ");
		String course_id = input.nextLine();
		
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getCourse_id().equals(course_id)) {
				Serialization.serCourse.get(i).printCourseInfo();
			}
		}
	}
	
	// 5. Register a student
	public static void registerStudent() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter student's info to register: \n");
		System.out.println("First name: \n");
		String newStudentFirst = input.nextLine();
		System.out.println("Last name: \n");
		String newStudentLast = input.nextLine();
		System.out.println("Username: \n");
		String newStudentUser = input.nextLine();
		System.out.println("Password: \n");
		String newStudentPass = input.nextLine();
		
		Student newStudent = new Student(newStudentFirst, newStudentLast, newStudentUser, newStudentPass);
		
		Serialization.serStudent.add(newStudent);	
	}
	
	
	// REPORTS
	
	// 6. View all courses
	public static void viewAll() {
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			System.out.println("Number enrolled: " + Serialization.serCourse.get(i).getNumEnrolled());
			System.out.println("Max enrollment: " + Serialization.serCourse.get(i).getMax() + "\n");
			for (int j=0; j<=4; j++) {
				Serialization.serCourse.get(i).getEnrolledStudents().get(j).printUserInfo();
			}
		}
			
	}
	
	// 7. View all full courses
	public static void viewFull() {
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getMax() == Serialization.serCourse.get(i).getNumEnrolled()) {
				Serialization.serCourse.get(i).printCourseInfo();
			}
		}	
	}
	
	// 8. Write full courses to a file
	public static void writeToFile() throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(new File("FullCourses.csv"))) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i<Serialization.serCourse.size(); i++) {
				if (Serialization.serCourse.get(i).getNumEnrolled() == Serialization.serCourse.get(i).getMax()) {
					sb.append(Serialization.serCourse.get(i).getCourse_id());
				}
			}
			
		}
	}
	
	// 9. View students in a specific course
	public static void viewStudentsInCourse() {
		Scanner input = new Scanner(System.in);		
		System.out.println("Course ID: ");
		String course_id = input.nextLine();
		
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getCourse_id() == course_id) {
				for (int j=0; j< Serialization.serCourse.get(i).getEnrolledStudents().size(); j++) {
					Serialization.serCourse.get(i).getEnrolledStudents().get(j).printUserInfo();
				}
			}
		}
	}
	
	// 10. View courses that a specific student is registered in 
	public static void studentRegisteredCourses() {
		Scanner input = new Scanner(System.in);
		System.out.println("Student first name: \n");
		String first = input.nextLine();
		System.out.println("Student last name: \n");
		String last = input.nextLine();

		System.out.println(first + " " + last + " is enrolled in: \n");
		for (int i=0; i<Serialization.serCourse.size(); i++) {
			if (Serialization.serCourse.get(i).getEnrolledStudents().get(i).getFirst().equals(first)
				&& Serialization.serCourse.get(i).getEnrolledStudents().get(i).getLast().equals(last)) {
				System.out.println(Serialization.serCourse.get(i).getCourse_name());
			}
		}
	}
	
	// 11. Sort courses by number of students enrolled 
	public static void sortByRegistration() {
		Course c = new Course();
		ArrayList <Integer> sorted = new ArrayList <Integer> ();
		for (int i = 0; i<Serialization.serCourse.size(); i++) {
			sorted.add(Serialization.serCourse.get(i).getNumEnrolled());
			String course_id = Serialization.serCourse.get(i).getCourse_id();
		}
		Collections.sort(sorted, Collections.reverseOrder());
		System.out.println(sorted.toString());
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

}
