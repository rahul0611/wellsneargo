package com.wellsneargo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsneargo.database.DatabaseUtility;
import com.wellsneargo.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean createUser(User u) {
		// TODO Auto-generated method stub
		System.out.println(u);
		Connection connection = null;
		PreparedStatement pstatement = null;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("insert into user(name,username,password,email,amount) values(?,?,?,?,?)");
			pstatement.setString(1, u.getName());
			pstatement.setString(2, u.getUsername());
			pstatement.setString(3, u.getPassword());
			pstatement.setString(4, u.getEmail());
			pstatement.setDouble(5, u.getAmount());

			int result = pstatement.executeUpdate();

			if (result > 0) {

				return true;
			} else {

				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteUser(User u) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("delete user where username = ?");
			pstatement.setString(1, u.getUsername());
			int result = pstatement.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("update user set name=? and password = ? and email = ? where username = ? ");
			pstatement.setString(1, u.getName());
			pstatement.setString(2, u.getPassword());
			pstatement.setString(3, u.getEmail());
			pstatement.setString(4, u.getUsername());
			int result = pstatement.executeUpdate();

			if (result > 0) {

				return true;
			} else {

				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public String getPassword(String username) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;
		String password = null;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("select  password from user where username = ? ");
			pstatement.setString(1, username);
			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				password = resultSet.getString("password");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return password;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList();
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("select  accountNo, name,username, password, email from user ");

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {

				int accountNo = resultSet.getInt("accountNo");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				Double amount = resultSet.getDouble("amount");

				User user = new User(accountNo, name, username, password,
						email, amount);
				users.add(user);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public boolean isUsernameExists(String username) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;
		boolean userExists = false;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("select  count(*) from user where username = ?");
			pstatement.setString(1, username);
			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt(1) > 0) {
					userExists = true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userExists;
	}

	@Override
	public double getBalance(String username) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;
		double amount = 0;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("select  amount from user where username = ?");
			pstatement.setString(1, username);
			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {

				amount = resultSet.getDouble("amount");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}

	@Override
	public boolean updateBalance(int accountNo, double amount) {

		Connection connection = null;
		PreparedStatement pstatement = null;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("update user set amount = ? where accountNo = ?");
			pstatement.setDouble(1, amount);
			pstatement.setInt(2, accountNo);

			int result = pstatement.executeUpdate();

			if (result > 0) {

				return true;
			} else {

				return false;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public User getUser(int accountNo) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("select  accountNo, name,username, password, email,amount from user where accountNo=? ");
			pstatement.setInt(1, accountNo);
			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {

				int accountNoIn = resultSet.getInt("accountNo");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				Double amount = resultSet.getDouble("amount");

				user = new User(accountNoIn, name, username, password, email,
						amount);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("select  accountNo, name,username, password, email,amount from user where username=?  ");
			pstatement.setString(1, username);
			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {

				int accountNoIn = resultSet.getInt("accountNo");
				String name = resultSet.getString("name");
				String usernameIn = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				Double amount = resultSet.getDouble("amount");

				user = new User(accountNoIn, name, usernameIn, password, email,
						amount);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

}
