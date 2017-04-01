package by.netcracker.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.netcracker.hotel.connector.ConnectorDB;
import by.netcracker.hotel.entities.User;

public class UserDAOImpl implements UserDAO {

	private static final String SQL_QUERY_GET_CLIENTS = "INSERT INTO `netcracker_hotel`.`users` (`first_name`, `last_name`, `login`, `password`) VALUES (?, ?, ?, ?);";

	@Override
	public void regUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = ConnectorDB.getConnection();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_CLIENTS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getLogin());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public User loginUser(User user) {
		return user;

	}

	@Override
	public void blockUser(User user) {
		// TODO Auto-generated method stub

	}

}
