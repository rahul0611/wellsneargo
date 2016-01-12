package com.wellsneargo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.wellsneargo.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "used to login", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("custUsername");
		String password = request.getParameter("custPassword");
		
		UserDaoImpl daoImpl = new UserDaoImpl();

		boolean usernameExists = daoImpl.isUsernameExists(username);
		
		if (!usernameExists) {
			response.getWriter().println("Invalid username/password!");
			return;
		}else{
			
			String dbPassword = daoImpl.getPassword(username);
			
			if(!password.equals(dbPassword)){
				
				response.getWriter().println("Invalid username/password!");
				return;
				
			}else{
				
				HttpSession httpSession = request.getSession(false);
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("accountNo", daoImpl.getUser(username).getAccountNo());
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("account.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		
		
		
		
		
		
	}

}
