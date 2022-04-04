import java.io.Serializable;

public class User implements Serializable{
	private String email;
	private String password;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User() {
		this.email = null;
		this.password = null;
	}

	public Food query(String query, Menu menu) {
		for (int i = 0; i < menu.getItems().size(); i++) {
			if (query.equals(menu.getItems().get(i).getName())) {
				return menu.getItems().get(i);
			}
		}
		return null;
	}

	public Boolean verifyLogin(String identifier, String password) {
		if(password.equals(this.password) && (identifier.equals(this.email)))
			return true;
		else
			return false;
	}

	public void changeEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

}

