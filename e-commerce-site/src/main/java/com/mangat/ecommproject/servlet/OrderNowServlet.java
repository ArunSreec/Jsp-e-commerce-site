package com.mangat.ecommproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.mangat.ecommproject.dao.OrderDao;
import com.mangat.ecommproject.database.DdConn;
import com.mangat.ecommproject.model.Cart;
import com.mangat.ecommproject.model.Order;
import com.mangat.ecommproject.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderNowServlet
 */
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = new Date();
			
			User auth = (User) request.getSession().getAttribute("auth1");
			if(auth != null) {
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				if(productQuantity <= 0) {
					productQuantity = 1;
				}
				
				Order order = new Order();
				order.setPid(Integer.parseInt(productId));
				order.setUid(auth.getId());
				order.setQuantity(productQuantity);
				order.setOdate(formatter.format(date));
				
				OrderDao dao = new OrderDao(DdConn.getConnection());
				boolean result = dao.insertOrder(order);
				if(result) {
					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					
					if(cart_list != null) {
						for(Cart x:cart_list) {
							if(x.getPid()==Integer.parseInt(productId)) {
								cart_list.remove(cart_list.indexOf(x));
								break;
							}
						} 
						
					}
					response.sendRedirect("orders.jsp");
				}else {
					out.print("order failed");
				}
			}
			else {
				response.sendRedirect("login.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
