import java.util.Scanner;

public class User {
	private String email;
	private String password;

	public User(String email, String password) {
		this.email = email;
		this.password = verifyPassword(password);
	}

	/*
	 * public Food search(String query) {
	 * 	Get the menu from application and search through food from menu to find a match of the query
	 * }
	 */
	private String verifyPassword(String password) {
		int length = password.length();
		if (length >= 8) {
			return password;
		}
		else {
			Scanner reader = new Scanner(System.in);
			System.out.println("Password is too Short! Enter a new Password (Password has to be greater than 8 characters): ");
			String input = reader.nextLine();
			reader.close();
			return verifyPassword(input);
		}
	}

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

	public void changePassword(String password) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter your current password: ");
		String input = reader.nextLine();
		if (input.equals(this.password)) {
			this.password = verifyPassword(password);
		}
		reader.close();
	}

	public void ChangeForcePassword(String password) {
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

