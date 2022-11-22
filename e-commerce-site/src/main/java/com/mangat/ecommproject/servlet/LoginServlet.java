package com.mangat.ecommproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mangat.ecommproject.dao.UsrDao;
import com.mangat.ecommproject.database.DdConn;
import com.mangat.ecommproject.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			String usremail = request.getParameter("login-email");
			String passwrd = request.getParameter("login-password");
			
			out.print(usremail+passwrd);
			
			UsrDao dao = new UsrDao(DdConn.getConnection());
			User user = dao.userlogin(usremail, passwrd);
			
			if(user != null) {
				request.getSession().setAttribute("auth1", user);
				response.sendRedirect("index.jsp");
			}
			else {
				out.print("Whoopies you are an imposter");
			}
		}
	}

}
