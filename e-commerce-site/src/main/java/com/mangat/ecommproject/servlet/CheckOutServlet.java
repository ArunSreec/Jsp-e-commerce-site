package com.mangat.ecommproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mangat.ecommproject.dao.OrderDao;
import com.mangat.ecommproject.database.DdConn;
import com.mangat.ecommproject.model.Cart;
import com.mangat.ecommproject.model.Order;
import com.mangat.ecommproject.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckOutServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date();

			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

			User auth = (User) request.getSession().getAttribute("auth1");

			if (cart_list != null && auth != null) {

				for (Cart c : cart_list) {
					Order order = new Order();
					order.setPid(c.getPid());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setOdate(formatter.format(date));

					OrderDao odao = new OrderDao(DdConn.getConnection());
					boolean result =odao.insertOrder(order);
					if(!result)
						break;
				}
				cart_list.clear();
				response.sendRedirect("orders.jsp");

			} else {
				if (auth == null)
					response.sendRedirect("login.jsp");
				else
					response.sendRedirect("cart.jsp");

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
