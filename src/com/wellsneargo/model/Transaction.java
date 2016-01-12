package com.wellsneargo.model;

import java.sql.Timestamp;

public class Transaction {

	int transaction_no;
	String transaction_type;
	double transaction_amount;
	Timestamp transaction_time;
	int accountNo;

	@Override
	public String toString() {
		return "Transaction [transaction_no=" + transaction_no
				+ ", transaction_type=" + transaction_type
				+ ", transaction_amount=" + transaction_amount
				+ ", transaction_time=" + transaction_time + ", accountNo="
				+ accountNo + ", getTransaction_no()=" + getTransaction_no()
				+ ", getTransaction_type()=" + getTransaction_type()
				+ ", getTransaction_amount()=" + getTransaction_amount()
				+ ", getTransaction_time()=" + getTransaction_time()
				+ ", getAccountNo()=" + getAccountNo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Transaction(int transaction_no, String transaction_type,
			double transaction_amount, Timestamp transaction_time, int accountNo) {
		super();
		this.transaction_no = transaction_no;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.transaction_time = transaction_time;
		this.accountNo = accountNo;
	}

	public int getTransaction_no() {
		return transaction_no;
	}

	public void setTransaction_no(int transaction_no) {
		this.transaction_no = transaction_no;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public double getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public Timestamp getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(Timestamp transaction_time) {
		this.transaction_time = transaction_time;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

}
