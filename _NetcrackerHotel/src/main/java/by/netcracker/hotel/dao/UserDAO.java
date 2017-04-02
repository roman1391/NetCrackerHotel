package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.User;

public interface UserDAO {

	public void createUser(User user);

	public User readUser(User user);

	public void updateUser(User user);

}
