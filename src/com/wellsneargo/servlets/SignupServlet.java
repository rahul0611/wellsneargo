package com.wellsneargo.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsneargo.dao.UserDaoImpl;
import com.wellsneargo.database.DatabaseUtility;
import com.wellsneargo.model.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
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

		// request elements
		String name = request.getParameter("custName");
		String username = request.getParameter("custUsername");
		String email = request.getParameter("custEmail");
		String password = request.getParameter("custPassword");

		UserDaoImpl daoImpl = new UserDaoImpl();

		boolean usernameExists = daoImpl.isUsernameExists(username);
		
		if (usernameExists) {
			response.getWriter().println("This username already exists!!");
			return;
		} else {
			User u = new User(0, name, username, password, email,500.0);
			daoImpl.createUser(u);
			response.getWriter().println("You have registered successfully.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
}