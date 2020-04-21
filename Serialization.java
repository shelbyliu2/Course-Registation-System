// Serialization class allows us to write to and read from a permanent file in memory
// We have separate .ser files for Student and Course info 
import java.io.*;
import java.util.*; 
import java.lang.*;

public class Serialization implements Serializable {

	public static ArrayList <Student> serStudent = new ArrayList <Student> ();
	public static ArrayList <Course> serCourse = new ArrayList <Course> ();
	
	// Serialization
	public static void serialize() {
		
		try {
			FileOutputStream fos = new FileOutputStream("StudentList.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
			oos.writeObject(serStudent);
				
			oos.close();
			fos.close();

			System.out.println("Student Serialization Complete");
			
			fos = new FileOutputStream("CourseList.ser");
			oos = new ObjectOutputStream(fos);
				
			oos.writeObject(serCourse);
				
			oos.close();
			fos.close();

			System.out.println("Course Serialization Complete");
	
			}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	// Deserialization
	public static ArrayList <Student> deserStudent = new ArrayList <Student> ();
	public static ArrayList <Course> deserCourse = new ArrayList <Course> ();
	public static void deserialize() {
		try
        {
			FileInputStream fis = new FileInputStream("StudentList.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    deserStudent = (ArrayList<Student>)ois.readObject();
		    ois.close();
		    fis.close();
		    
			fis = new FileInputStream("CourseList.ser");
			ois = new ObjectInputStream(fis);
		    deserCourse = (ArrayList<Course>)ois.readObject();
		    ois.close();
		    fis.close();
            
         }catch(IOException ioe){
        	 String fileName = "MyUniversityCourses.csv";
     		try{
     			
     			FileReader fr = new FileReader(fileName);
     			BufferedReader br = new BufferedReader(fr);
     			String line;

     			String [] entry = {};
     			while((line = br.readLine()) != null) {
     				entry = line.split(",");
     			}
     		}
     			catch (FileNotFoundException ex){
     				System.out.println( "Unable to open file '" + fileName + "'");			
     				ex.printStackTrace();
     			}
     	
     			catch (IOException ex) {
     				System.out.println( "Error reading file '" + fileName + "'");
     				ex.printStackTrace();
     			}
     		
             return;
             
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
	}
	
}


