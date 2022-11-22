package com.mangat.ecommproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.mangat.ecommproject.dao.BillDao;
import com.mangat.ecommproject.database.DdConn;
import com.mangat.ecommproject.model.Bill;
import com.mangat.ecommproject.model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProductBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			
			ArrayList<Bill> odrList = new ArrayList<>();
			ArrayList<Bill> odr_list =(ArrayList<Bill>) request.getSession().getAttribute("odr-list");
			
			String orderId = request.getParameter("oid");
				
			if(odr_list!= null) {
				
				
				odr_list = null;
				
			}
			
			BillDao bdao = new BillDao(DdConn.getConnection());
			
			
			
				try {
					odrList.add(bdao.getOrder(Integer.parseInt(orderId)));
				} catch (NumberFormatException e) {

					e.printStackTrace();
				} catch (Exception e) {

					e.printStackTrace();
				}
				request.getSession().setAttribute("odr-list", odrList);
				
				response.sendRedirect("bill.jsp");
				
			
			
				
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}

}
