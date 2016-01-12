package com.wellsneargo.model;

public class User {



	int accountNo;
	String name;
	String username;
	String password;
	String email;
	double amount;

	public User(int accountNo, String name, String username, String password,
			String email,double amount) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "User [accountNo=" + accountNo + ", name=" + name
				+ ", username=" + username + ", password=" + password
				+ ", email=" + email + ", getAccountNo()=" + getAccountNo()
				+ ", getName()=" + getName() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
