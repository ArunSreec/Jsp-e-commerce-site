<%@page import="com.mangat.ecommproject.model.*"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Mangat Stores</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarScroll"
				aria-controls="navbarScroll" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarScroll" >
				<ul class="navbar-nav ms-auto my-6 my-lg-7 navbar-nav-scroll"
					style="-bs-scroll-height: 100px;">
					<li class="nav-item" ><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
					<li class="nav-item" ><a class="nav-link active"
						aria-current="page" href="cart.jsp">Cart<span class="badge badge-danger px-1">${cart_list.size()}</span></a></li>
						
					<%if(auth1 != null){%>
						<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
						<li class="nav-item"><a class="nav-link" href="logout-user">Logout</a></li>
					<%}else{%>
						<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
					<%}%>
					
					
					
					
					
				</ul>
				
			</div>
		</div>
	</nav>
