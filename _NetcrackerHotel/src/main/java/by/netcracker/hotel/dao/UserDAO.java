package by.netcracker.hotel.dao;

import by.netcracker.hotel.entities.User;

public interface UserDAO {

	public void regUser(User user);

	public User loginUser(User user);

	public void blockUser(User user);

}
