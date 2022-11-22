<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mangat.ecommproject.dao.*"%>
<%@page import="com.mangat.ecommproject.database.*"%>
<%@page import="com.mangat.ecommproject.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mangat.ecommproject.servlet.*"%>
<%
	User auth1 = (User) request.getSession().getAttribute("auth1");
	if(auth1 != null){
		request.setAttribute("auth1",auth1);
	}
	
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	
	List<Cart> cartProduct = null;
	
	if(cart_list != null){
		ProductDao pdao = new ProductDao(DdConn.getConnection());
		cartProduct = pdao.getCartProducts(cart_list);
		int total = pdao.getTotalCartPrice(cart_list);
		request.setAttribute("cart_list",cart_list);
		request.setAttribute("total",total);
	}
	
	
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cart</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <%@include file="includes/navbar.jsp"%>
    
    
    <div class="container">
    	<div class="d-flex py-5"><h3>Total Price :$ ${total}</h3><a class="mx-2 btn btn-dark" href="check-out">Check Out</a></div>
    	
    	<table class="table table-light">
	    	<thead>
	    		<tr>
	    			<th scope="col">Name</th>
	    			<th scope="col">Category</th>
	    			<th scope="col">Price</th>
	    			<th scope="col">Buy Now</th>
	    			<th scope="col">Cancel</th>	
	    		</tr>
	    	</thead>
	    	<tbody>
	    	<%
				if(cart_list != null){
					
					for(Cart c : cartProduct){%>
						
						<tr>
		    			<td><%= c.getPdtname()%></td>
		    			<td><%= c.getPdtcategory()%></td>
		    			<td><%= c.getPdtprice()%>$</th>
		    			<td>
		    				<form action="order-now" method="post" class="form-inline">
		    					<input type="hidden" name="id" value="<%= c.getPid() %>" class="form-input">
		    					<div class="form-group d-flex justify-content-between w-50">
		    					<a class="btn btn-sm btn-incre" href="quantity-inc-decree?action=inc&id=<%=c.getPid()%>"><i class="fa-solid fa-plus"></i></a>
		    					<input type="text" name="quantity" value="<%= c.getQuantity() %>" class="form-control" readonly>
		    					<a class="btn btn-sm btn-decre" href="quantity-inc-decree?action=dec&id=<%=c.getPid()%>"><i class="fa-solid fa-minus"></i></a>
		    					<button type="submit" class="btn btn-primary btn-sm">Buy</button>
		    					</div>
		    					
		    				</form>
		    			</td>
		    			<td><a class="btn btn-sm btn-danger" href="remove-from-cart?id=<%= c.getPid() %>">Remove</a></td>
		    		</tr>
					<% }
				}
	    	
	    	%>
	    		
	    	</tbody>
    	</table>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" ></script>
  </body>
</html>