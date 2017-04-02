package by.netcracker.hotel.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User {

	private int id;

	@Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters long")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "First name must be alphanumeric with no spaces")
	private String firstName;

	@Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters long")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Last name must be alphanumeric with no spaces")
	private String lastName;

	@Size(min = 4, message = "Username size is min 4 symbols")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Login must be alphanumeric with no spaces")
	private String username;

	@Size(min = 6, message = "Password is min 6 and max 15 symbols ")
	private String password;

	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email address")
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
