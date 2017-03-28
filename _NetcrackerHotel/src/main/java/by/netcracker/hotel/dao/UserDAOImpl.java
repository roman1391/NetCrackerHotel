package by.netcracker.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.netcracker.hotel.connector.ConnectorDB;
import by.netcracker.hotel.entities.User;

public class UserDAOImpl implements UserDAO {

	private static final String SQL_QUERY_GET_CLIENTS = "INSERT INTO `netcracker_hotel`.`users` (`first_name`, `last_name`, `login`, `password`) VALUES (?, ?, ?, ?);";
	private Connection connection;

	@Override
	public void regUser(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = ConnectorDB.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY_GET_CLIENTS);
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
