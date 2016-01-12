package com.wellsneargo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wellsneargo.database.DatabaseUtility;
import com.wellsneargo.model.Transaction;
import com.wellsneargo.model.User;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public boolean withdraw(Transaction t) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		try {

			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("insert into transaction(transaction_type,transaction_amount,accountNo) values(?,?,?)");
			pstatement.setString(1, t.getTransaction_type());
			pstatement.setDouble(2, t.getTransaction_amount());
			pstatement.setInt(3, t.getAccountNo());

			int result = pstatement.executeUpdate();

			if (result > 0) {

				// update balance

				UserDaoImpl daoImpl = new UserDaoImpl();

				User u = daoImpl.getUser(t.getAccountNo());

				daoImpl.updateBalance(t.getAccountNo(),
						u.getAmount() - t.getTransaction_amount());

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
	public boolean deposit(Transaction t) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		boolean response = false;
		try {

			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement("insert into transaction(transaction_type,transaction_amount,accountNo) values(?,?,?)");
			pstatement.setString(1, t.getTransaction_type());
			pstatement.setDouble(2, t.getTransaction_amount());
			pstatement.setInt(3, t.getAccountNo());

			int result = pstatement.executeUpdate();

			if (result > 0) {

				// update balance

				UserDaoImpl daoImpl = new UserDaoImpl();

				User u = daoImpl.getUser(t.getAccountNo());

				response = daoImpl.updateBalance(t.getAccountNo(),
						u.getAmount() + t.getTransaction_amount());

				return response;
			} else {

				return response;
			}

		} catch (Exception e) {

		}
		return response;
	}

	@Override
	public List<Transaction> getTransactions() {
		Connection connection = null;
		PreparedStatement pstatement = null;
		List<Transaction> transactions = new ArrayList<Transaction>();
		ResultSet resultSet = null;

		try {

			connection = DatabaseUtility.getConnection();
			pstatement = connection
					.prepareStatement(" select * from transaction");

			resultSet = pstatement.executeQuery();
			while (resultSet.next()) {

				int transaction_no = resultSet.getInt(1);
				String transaction_type = resultSet.getString(2);
				double transaction_amount = resultSet.getDouble(3);
				Timestamp transaction_time = resultSet.getTimestamp(4);
				int accountNo = resultSet.getInt(5);

				Transaction transaction = new Transaction(transaction_no,
						transaction_type, transaction_amount, transaction_time,
						accountNo);
				transactions.add(transaction);
			}

		} catch (Exception e) {

		}

		return transactions;
	}

}
