import java.util.ArrayList;
import java.util.Scanner;

public class User {

	//=========================================================== Properties
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	public ArrayList<Team> teams = new ArrayList<Team>();

	//=========================================================== Constructors
	public User (int userId, String firstName, String lastName, String userName, String password) {
		setUserId(userId);
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
		setPassword(password);
	}

	public User (Scanner fin) throws Exception {
		String[] parts = fin.nextLine().split("\t");
		setUserId(Integer.parseInt(parts[0]));
		setFirstName(parts[1]);
		setLastName(parts[2]);
		setUserName(parts[3]);
		setPassword(parts[4]);
	}

	//=========================================================== Methods
	public boolean equals (Object obj) {
		if(!(obj instanceof User)) return false;
		User u = (User) obj;
		return getEqualsString().equals(u.getEqualsString());
	}

	private String getEqualsString() {
		return userId + "-" + firstName + "-" + lastName + "-" + userName + "-" + password;
	}

	public String toString() {
		return "userId: " + userId + ", firstName: " + firstName + ", lastName: " + lastName + ", userName: " + userName + ", password: " + password;
	}

	//=========================================================== Getters/Setters
	public int getUserId() {
		return this.userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
