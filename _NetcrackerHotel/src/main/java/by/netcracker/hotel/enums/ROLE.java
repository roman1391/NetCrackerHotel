package by.netcracker.hotel.enums;

/**
 * Created by Alexander on 10.04.2017.
 */
public enum ROLE {
	ADMIN(1), GUEST(2), USER(3), BLOCKED(4);

	private int role;

	ROLE(int i) {
		role = i;
	}

	public int getRole() {
		return role;
	}
}
