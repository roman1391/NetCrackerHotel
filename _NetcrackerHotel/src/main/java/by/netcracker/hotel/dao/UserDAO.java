package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.User;

public interface UserDAO {

	public void regUser(User user);

	public void loginUser();

	public void blockUser(User user);

}
