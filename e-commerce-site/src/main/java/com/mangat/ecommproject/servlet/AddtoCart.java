package com.mangat.ecommproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.mangat.ecommproject.model.Cart;
import com.mangat.ecommproject.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addtocart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public AddtoCart() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			ArrayList<Cart> cartList = new ArrayList<Cart>();
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			Cart cart = new Cart();
			cart.setPid(pid);
			cart.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list =(ArrayList<Cart>) session.getAttribute("cart-list");
			
			ArrayList<User> odr_list =(ArrayList<User>) session.getAttribute("odr-list");
			
			if(odr_list == null) {
				session.setAttribute("odr-list", odr_list);
			}
			
			if(cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("index.jsp");
				
			}else {
				cartList= cart_list;
				boolean exist = false;
				for(Cart c : cart_list) {
					if(c.getPid() == pid) {
						exist = true;
						out.print("<h3 style='colour:crimson;text-align:center;'>Item already in Cart<a href='cart.jsp'>Go to cart page</a></h3>");
					}
					
					
					 
				}
				if(!exist) {
					cartList.add(cart);
					response.sendRedirect("index.jsp");
				}
				
			}
		}
	}

}
