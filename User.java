// User class contains constructors and data fields that Admin and Student share
// Admin and Student inherit from User
import java.util.Scanner;

public class User {
	private String username;
	private String password;
	private String first;
	private String last;
	
	User() {}
	
	User(String username, String password, String first, String last){
		this.username = username;
		this.password = password;
		this.first = first;
		this.last = last;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	public void getUserInfo() {
		Scanner input = new Scanner(System.in);
		System.out.println("First name: ");
		String first = input.nextLine();
		
		System.out.println("Last name: ");
		String last = input.nextLine();
		
		System.out.println("Username: ");
		String username = input.nextLine();
		
		System.out.println("Password: ");
		String password = input.nextLine();
	}
	
	public void printUserInfo() {
		System.out.println("First name: " + this.first);
		System.out.println("Last name: " + this.last);
		System.out.println("Username: " + this.username);
		System.out.println("Password: " + this.password);
	}
	
}
