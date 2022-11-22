<%@page import="com.mangat.ecommproject.dao.ProductDao"%>
<%@page import="com.mangat.ecommproject.database.*"%>
<%@page import="com.mangat.ecommproject.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.mangat.ecommproject.model.*"%>
<%
	User auth1 = (User) request.getSession().getAttribute("auth1");
	if(auth1 != null){
		request.setAttribute("auth1",auth1);
	}
	
	ProductDao pd = new ProductDao(DdConn.getConnection());
	List<Product> products = pd.getAllProducts();
	
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	
	if(cart_list != null){
		
		request.setAttribute("cart_list",cart_list);
	}
			
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HomePage</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<%@include file="includes/navbar.jsp"%>
	<div class="container">
	<div class="card-header my-3" style="background-color:powderblue;">All Products</div>
	<div class="row">
	<%
		if(!products.isEmpty()){
			for(Product p : products){%>
				<div class="col-md-2">
		    	<div class="card w-100" style="width:18rem;">
		      			<img src="images/<%=p.getPdtimage()%>" class="card-img-top" alt="...">
				      <div class="card-body">
				        <h6 class="card-title"><%=p.getPdtname()%></h6>
				        <h6 class="price">Price : $<%=p.getPdtprice()%></h6>
				        <h6 class="category">Category : <%=p.getPdtcategory()%></h6>
		        		<div class="mt-6 d-flex justify-content-between">
		        			<a href="order-now?quantity=1&id=<%= p.getPid() %>" class="btn btn-dark btn-sm">Buy Now</a>
		        			<a href="addtocart?pid=<%= p.getPid() %>" class="btn btn-primary btn-sm">Add to Cart</a>
		       			 </div>
		        
		      		</div>
		    	</div>
		  	</div>
				
			<% }
		}
	%>
	  	
	  
	  <!-- 1 -->
	  
	  
	 
	  
	</div>
	</div>
		
		
	
	
	



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>