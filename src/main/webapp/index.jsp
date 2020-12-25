<%@page import="ltweb.electronic_store.model.Product"%>
<%@page import="java.util.ArrayList"%>
<html>
	<body>
		<h2>Hello World!</h2>
		<form action="<%=request.getContextPath()%>/search" method="post">
			<input type="text" name="nameP"/>
			<button>Search</button>
		</form>
		<% ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("products");
			if (products != null) {
				if (products.size() == 0) { %>
					<h2>No product found!</h2>
				<% } else { 
					for (Product product : products) {
				%>
						<h2>Products: </h2>
						<h4>ID: <%= product.getIdProduct() %></h4>
						<h4>Name: <%= product.getName() %></h4>
						<h4>Price: <%= product.getPrice() %></h4>
					<% } %>
				<% } %>
			<%} %>
		
		
	</body>
</html>
