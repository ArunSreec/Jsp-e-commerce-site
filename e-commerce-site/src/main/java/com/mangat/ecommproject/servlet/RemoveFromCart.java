package com.mangat.ecommproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.mangat.ecommproject.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String id = request.getParameter("id");
			
			if(id!= null) {
				ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
				
				if(cart_list != null) {
					for(Cart x:cart_list) {
						if(x.getPid()==Integer.parseInt(id)) {
							cart_list.remove(cart_list.indexOf(x));
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
