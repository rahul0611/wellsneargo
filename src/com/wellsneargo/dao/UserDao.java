package com.wellsneargo.dao;

import java.util.List;

import com.wellsneargo.model.User;

public interface UserDao {

	public boolean createUser(User u);
	public boolean deleteUser(User u);
	public boolean updateUser(User u);
	public String getPassword(String username);
	public List<User> getUsers();
	public User getUser(int accountNo);
	public User getUser(String username);
	public boolean isUsernameExists(String username);
	public double getBalance(String username);
	public boolean updateBalance(int accountNo, double amount);
	
}
