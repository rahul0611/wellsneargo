package com.wellsneargo.dao;

import java.util.List;

import com.wellsneargo.model.Transaction;

public interface TransactionDao {

	public boolean withdraw(Transaction t);
	
	public boolean deposit(Transaction t);
	
	public List<Transaction> getTransactions();
	
}
