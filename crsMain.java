import java.io.*;
import java.util.*; 
import java.lang.*;

public class crsMain {
	public static void main(String [] args) throws IOException, FileNotFoundException {
		
		User Admin = new Admin("Shelby", "Liu", "Admin", "Admin001");
		userLogin();
		
	} // close main
		
		// Start by asking user to login as either Admin or Student
		public static void userLogin() throws IOException {
			System.out.println("1. Admin\n" + "2. Student\n" + "3. Exit\n");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Username: \n");
				String username = input.next();
				System.out.println("Password: \n");
				String password = input.next();
				
				if (username.equals("Admin") && password.equals("Admin001")) {
					System.out.println("Welcome, Admin");
					adminMenu();
				}
			
			case 2:
				// Get student's name
				System.out.println("First name: \n");
				String firstName = input.next();
				System.out.println("Last name: \n");
				String lastName = input.next();
	
				System.out.println("1. New user\n" + "2. Existing user\n");
				int userStatus = input.nextInt();
				
				// New Student  
				if (userStatus == 1) {
					System.out.println("Enter a username: ");
					String newUsername = input.next();
					System.out.println("Enter a password: ");
					String newPassword = input.next();
					
					Student newStudent = new Student(firstName, lastName, newUsername, newPassword);
					Serialization.serStudent.add(newStudent);
					
					System.out.println("Student successfully added");
					studentMenu();
				}
				
				// Find an existing student 
				else if (userStatus == 2) {
					System.out.println("Enter username: ");
					String loginStudentUsername = input.next();
					System.out.println("Enter password: ");
					String loginStudentPassword = input.next();
					
					for (int i=0; i<Serialization.serStudent.size(); i++) {
						if (Serialization.serStudent.get(i).getFirst().equals(firstName)
							&& Serialization.serStudent.get(i).getLast().equals(lastName)
							&& Serialization.serStudent.get(i).getUsername().equals(loginStudentUsername)
							&& Serialization.serStudent.get(i).getPassword().equals(loginStudentPassword)) {
							
							System.out.println("Welcome back, " + firstName + " " + lastName);
						}
					}

					studentMenu();
				}
				
			case 3:
				System.exit(0);
					
			} // close switch
		} // close userlogin
		
		public static void adminMenu() throws IOException {
			int choice;
			do {
			System.out.println("Course Management:\n " + 
								"1. Create course\n" +
								"2. Delete course\n" +
								"3. Edit course\n" +
								"4. Display course info\n" +
								"5. Register a student\n" +
								"6. Exit\n");
			
			System.out.println("Course Management:\n " + 
								"7. View all courses\n" +
								"8. View all FULL courses\n" +
								"9. Add full courses to a file\n" +
								"10. View all student names in a course\n" +
								"11. View courses a student is enrolled in\n" +
								"12. Sort courses based on enrollment\n" +
								"13. Exit\n");
			
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			if (choice == 1) Admin.createNew();
			if (choice == 2) Admin.delete();
			if (choice == 3) Admin.edit();
			if (choice == 4) Admin.displayCourseInfo();
			if (choice == 5) Admin.registerStudent();
			
			if (choice == 7) Admin.viewAll();
			if (choice == 8) Admin.viewFull();
			if (choice == 9) Admin.writeToFile();
			if (choice == 10) Admin.viewStudentsInCourse();
			if (choice == 11) Admin.studentRegisteredCourses();
			if (choice == 12) Admin.sortByRegistration();
			if (choice == 6 || choice == 13) System.exit(0);
			} while (choice != 6 || choice != 13);
		}
		
		public static void studentMenu() throws IOException {
			int choice;
			do {
			System.out.println("Course Management:\n " + 
							"1. View all courses\n" +
							"2. View all courses that are not full\n" +
							"3. Register in a course\n" +
							"4. Withdraw from a course\n" +
							"5. View courses currently enrolled in\n" +
							"6. Exit\n");
			
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			if (choice == 1) Student.viewAll();
			if (choice == 2) Student.viewNotFull();
			if (choice == 3) Student.register();
			if (choice == 4) Student.withdraw();
			if (choice == 5) Student.viewEnrolled();
			if (choice == 6) System.exit(0);
			} while (choice != 6);
		}
		
		// FILE IO
		public static ArrayList<Course> courseAL = new ArrayList<Course>();
		
		public static ArrayList <Course> getCourseList() throws IOException, FileNotFoundException {
			ArrayList <Course> course_list = new ArrayList();
		
		// FILE READER
		String fileName = "MyUniversityCourses.csv";
		try{
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;

			String [] entry = {};
			while((line = br.readLine()) != null) {
				entry = line.split(",");
			}
			
			Course courseEntry = new Course(entry[0], entry[1], Integer.parseInt(entry[2]), Integer.parseInt(entry[3]), entry[5],Integer.parseInt(entry[6]), entry[7], null);
			course_list.add(courseEntry);
		}
			catch (FileNotFoundException ex){
				System.out.println( "Unable to open file '" + fileName + "'");			
				ex.printStackTrace();
			}
	
			catch (IOException ex) {
				System.out.println( "Error reading file '" + fileName + "'");
				ex.printStackTrace();
			}
		
		courseAL = course_list;
		return courseAL;
		
		}

} // close class

// Code adapted from readerTest, and fileWriterTest resources posted on course site
