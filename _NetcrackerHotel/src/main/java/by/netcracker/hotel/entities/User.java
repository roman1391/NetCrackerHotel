package by.netcracker.hotel.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	private int id;

	@Size(min = 6, max = 15, message = "First name size is min 6 and max 15 symbols")
	private String firstName;

	@Size(min = 5, max = 15, message = "Last name size is min 6 and max 15 symbols")
	private String lastName;

	@Size(min = 4, message = "Login size is min 4 symbols")
	private String login;

	@Size(min = 6, message = "Password is min 6 and max 15 symbols ")
	private String password;

	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "{invalid.email}")
	private String email;

	private int accessLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

}
