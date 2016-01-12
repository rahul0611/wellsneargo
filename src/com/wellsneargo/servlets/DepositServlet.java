package com.wellsneargo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsneargo.dao.TransactionDaoImpl;
import com.wellsneargo.model.Transaction;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepositServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String amount = request.getParameter("depositAmount");
		int accountNo = (int) request.getSession(false).getAttribute(
				"accountNo");
		Transaction t = new Transaction(0, "deposit",
				Double.parseDouble(amount), null, accountNo);
		TransactionDaoImpl daoImpl = new TransactionDaoImpl();
		daoImpl.deposit(t);
	}

}
