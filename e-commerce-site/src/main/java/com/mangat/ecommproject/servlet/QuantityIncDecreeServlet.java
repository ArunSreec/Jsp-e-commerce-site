package com.mangat.ecommproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.mangat.ecommproject.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class QuantityIncDecreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public QuantityIncDecreeServlet() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			
			 ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			 
			 if(action != null && id>1) {
				 if(action.equals("inc")) {
					 for(Cart c : cart_list) {
						 if(c.getPid() == id) {
							 int quant = c.getQuantity();
							 quant++;
							 c.setQuantity(quant);
							 response.sendRedirect("cart.jsp");
						 }
					 }
				 }
				 if(action.equals("dec")){
					 for(Cart c : cart_list) {
						 if(c.getPid() == id && c.getQuantity()>1) {
							 int quant = c.getQuantity();
							 quant--;
							 c.setQuantity(quant);
							 break;
						 }
						 
					 }
					 response.sendRedirect("cart.jsp");
					 
				 }
			 }else {
				 response.sendRedirect("cart.jsp");
			 }
		}
	}


	

}
