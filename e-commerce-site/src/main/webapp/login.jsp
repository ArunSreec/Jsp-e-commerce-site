<%@page import="com.mangat.ecommproject.model.*"%>
<%
	User auth1 = (User) request.getSession().getAttribute("auth1");
	if(auth1 != null){
		request.setAttribute("auth1",auth1);
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  	<%@include file="includes/navbar.jsp"%>
    
    <div class="container">
	    <div class="card w-50 mx-auto my-5">
	    	<div class="card-header text-center">User Login	
	    		<div class="card-body">
	    			<form action="login-user" method="post">
	    				<div class="form-group">
	    					<label>Email Address</label>
	    					<input type="email" class="form-control" name="login-email" placeholder="Enter your email" required="required">
	    				</div>
	    				<div class="form-group">
	    					<label>Password</label>
	    					<input type="password" class="form-control" name="login-password" placeholder="*****" required="required">
	    				</div>
	    				<div class="text-center">
	    					<button type="submit" class="btn btn-primary">Login</button>
	    				</div>
	    			</form>
	    		</div>
	    	</div>
	    </div>
    
    </div>
    
    
    
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" ></script>
  </body>
</html>