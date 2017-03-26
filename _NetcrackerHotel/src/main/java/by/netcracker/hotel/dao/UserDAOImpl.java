package by.netcracker.hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.netcracker.hotel.entities.User;

public class UserDAOImpl implements UserDAO {

	public static final String SQL_QUERY_GET_CLIENTS = "INSERT INTO `netcracker_hotel`.`users` (`first_name`, `last_name`, `login`, `password`) VALUES (?, ?, ?, ?);";
	Connection connection;
	PreparedStatement preparedStatement = null;

	@Override
	public void regUser(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/netcracker_hotel?autoReconnect=true&useSSL=false", "root", "1234");
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_CLIENTS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getLogin());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void loginUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void blockUser(User user) {
		// TODO Auto-generated method stub

	}

}
