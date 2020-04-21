// Course class contains all necessary contructors and data fields to be used when 
// working with courses and course info
import java.io.Serializable;
import java.util.*;
public class Course {
	private String course_name;
	private String course_id;
	private int max;
	private int numEnrolled; // current num of registered students 
	private ArrayList <Student> enrolledStudents = new ArrayList <Student> ();	
	private String instructor;
	private int section;
	private String location;
	
	

	// Default constructor
	public Course() {}
	
	// Constructor for admin use
	public Course(String course_name, String course_id, int max, int numEnrolled, String instructor, int section, String location,ArrayList enrolledNames) {
		this.course_name = course_name;
		this.course_id = course_id;
		this.max = max;
		this.numEnrolled = numEnrolled;
		this.instructor = instructor;
		this.section = section;
		this.location = location;
		this.enrolledStudents = enrolledStudents;
	}
	
	// Constructor for student use
	public Course(String course_name, String course_id, String instructor, int section, String location) {
		this.course_name = course_name;
		this.course_id = course_id;
		this.instructor = instructor;
		this.section = section;
		this.location = location;
	}

	public Course(String course_id, int numEnrolled) {
		this.course_id = course_id;
		this.numEnrolled = numEnrolled;
	}
	
	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getNumEnrolled() {
		return numEnrolled;
	}

	public void setNumEnrolled(int numEnrolled) {
		this.numEnrolled = numEnrolled;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public ArrayList<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

		@Override
		public String toString() {
			return this.course_name + " " + this.course_id + " " + this.max + " " + this.instructor + " " + this.section + " " + this.location + this.enrolledStudents;
		}
		
		public void printCourseInfo(){
			System.out.println("Course name: " + this.course_name);
			System.out.println("Course ID: " + this.course_id);
			System.out.println("Max number of students: " + this.max);
			System.out.println("Number of students enrolled: " + this.numEnrolled);
			System.out.println("Instrutor: " + this.instructor);
			System.out.println("Section: " + this.section);
			System.out.println("Location: " + this.location);
			System.out.println("Students enrolled " + this.enrolledStudents);
		}
		
		public void printCourseInfoStudent() {
			System.out.println("Course name: " + this.course_name);
			System.out.println("Course ID: " + this.course_id);
			System.out.println("Instrutor: " + this.instructor);
			System.out.println("Section: " + this.section);
			System.out.println("Location: " + this.location);
		}

}
