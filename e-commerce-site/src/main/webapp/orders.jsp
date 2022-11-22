 <%@page import="com.mangat.ecommproject.database.DdConn"%>
<%@page import="com.mangat.ecommproject.dao.OrderDao"%>
<%@page import="com.mangat.ecommproject.model.*"%>
  <%@page import="java.util.*"%>
<%
	User auth1 = (User) request.getSession().getAttribute("auth1");
	List<Order> orders = null;
	if(auth1 != null){
		request.setAttribute("auth1",auth1);
		 orders = new OrderDao(DdConn.getConnection()).userOrders(auth1.getId());
	}else{
		response.sendRedirect("login.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
	
	if(cart_list != null) {
		request.setAttribute("cart_list",cart_list);
		
	}
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  	<%@include file="includes/navbar.jsp"%>
  	
  	
     <div class="container">
    	<div class="d-flex py-5"><h3>All Orders</h3></div>
    	
    	<table class="table table-light">
	    	<thead>
	    		<tr>
	    			<th scope="col">Date</th>
	    			<th scope="col">Name</th>
	    			<th scope="col">Category</th>
	    			<th scope="col">Price</th>
	    			<th scope="col">Quantity</th>
	    			<th scope="col">Bill</th>	
	    		</tr>
	    	</thead>
	    	<tbody>
	    	<%
	    		if(orders != null){
	    			for(Order o: orders){
	    		%>
	    		<tr>
	    		<td><%=o.getOdate() %></td>
	    		<td><%=o.getPdtname() %></td>
	    		<td><%=o.getPdtcategory() %></td>
	    		<td><%=o.getPdtprice() %></td>
	    		<td><%=o.getQuantity() %></td>
	    		<td><a class="btn btn-primary" href="bill?oid=<%=o.getOrderId()%>">Generate Bill</a></td>
	    		</tr>
	    		<%} }%>
	    	
	    	
	    	</tbody>
	    </table>
	  </div>	
    
    
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" ></script>
  </body>
</html>