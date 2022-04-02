import java.util.Scanner;

/*
 * change log
 * verifyPassword interferes with GUI. Removing and implementing in GUI screen. User() edited to accommodate.
 * changePassword changed to be better interact with GUI
 */

public class User {
	private String email;
	private String password;
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User() {
		email = null;
	}
	
	/* 
	 * public Food search(String query) {
	 * 	Get the menu from application and search through food from menu to find a match of the query
	 * }
	 */
	
	/*
	private String verifyPassword(String password) {
		int length = password.length();
		if (length >= 8) {
			return password;
		}
		else {
			Scanner reader = new Scanner(System.in);
			System.out.println("Password is too Short! Enter a new Password (Password has to be greater than 8 characters): ");
			String input = reader.nextLine();
			return verifyPassword(input);
		}
	
	}
	*/
	
	public Boolean verifyLogin(String email, String password) {
		// check database to verify that email and password exit and match
		return true;
	}
	
	public void changeEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void changePassword(String currentPassword, String password) {
		if (currentPassword.equals(this.password)) {
			this.password = password;
		}
	}
	
	public void changeForcePassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	/*
	 * public static void main(String[] args) { User myUser = new
	 * User("nickfullerton2285@gmail.com", "Slimt");
	 * System.out.println(myUser.getEmail());
	 * System.out.println(myUser.getPassword()); myUser.changePassword("bob");
	 * System.out.println(myUser.getPassword());
	 * 
	 * }
	 */
}
