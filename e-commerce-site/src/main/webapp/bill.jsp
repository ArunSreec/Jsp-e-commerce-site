<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 <%@page import="com.mangat.ecommproject.database.DdConn"%>
<%@page import="com.mangat.ecommproject.dao.OrderDao"%>
<%@page import="com.mangat.ecommproject.model.*"%>
  <%@page import="java.util.*"%>
<%
	User auth1 = (User) request.getSession().getAttribute("auth1");

	List<Order> orders = null;
	List<Bill> usrlist = null;
	
	ArrayList<Bill> odr_list =(ArrayList<Bill>) request.getSession().getAttribute("odr-list");
	if(auth1 != null){
		request.setAttribute("auth1",auth1);
		orders = new OrderDao(DdConn.getConnection()).userOrders(auth1.getId());
		usrlist=odr_list;
		
		
	}else{
		response.sendRedirect("login.jsp");
	}
	

	
	
	
	
	
%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

		<div class="container">
    		<div class="d-flex py-5"><h3 style="text-align">Bill</h3></div>
    	
    		<table class="table table-light">
	    		<thead>
	    		<tr>
	    			<th scope="col">Date</th>
	    			<th scope="col">Product Name</th>
	    			<th scope="col">Product Category</th>
	    			<th scope="col">Product Price</th>
	    			<th scope="col">Product Id</th>
	    			<th scope="col">Quantity</th>
	    			<th scope="col">Billing Name</th>
	    			<th scope="col">Billing Address</th>
	    			<th scope="col">Billing Phonenumber</th>
	    				
	    		</tr>
	    	</thead>
	    	<tbody>
	    	<%
	    		int i = 0;
	    		for(Bill p : odr_list){
	    			i= p.getPid();
	    		}
	    		if(orders != null){
	    			for(Bill p : odr_list){
	    				
	    		%>
	    		<tr>
	    		<td><%=p.getOdate() %></td>
	    		<td><%=p.getPdtname() %></td>
	    		<td><%=p.getPdtcategory() %></td>
	    		<td><%=p.getPdtprice() %></td>
	    		<td><%=p.getPid() %></td>
	    		<td><%=p.getQuantity() %></td>
	    		<td><%=p.getBname() %></td>
	    		<td><%=p.getbAddress() %></td>
	    		<td><%=p.getBphonenumber() %></td>
	    		</tr>
	    		<%} }%>
	    	
	    	
	    	</tbody>
	    	</table>
	  </div>	
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" ></script>  
</body>
</html>