<%@page import="ltweb.electronic_store.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style/dssp.css">
    <title>Danh sách sản phẩm</title>
</head>
<body>
    <div class="con">
        <div class="container">
            
            <form  id="thanhtimkiem" action="<%=request.getContextPath()%>/search" method="get">
                <input id = "textTimkiem" name="nameP" type="search" placeholder="Tìm kiếm sản phẩm mong muốn..." >
                <button id = "btnTimkiem" type="submit">Tìm kiếm</button>
            </form>
        </div>
        <% ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("products");
        	if (products != null) {
        		
	        	if (products.size() == 0) { %>
	        		
	        	<% } else { %>
	        		<div class="dssp">
			        	<% 
			        		for(Product product: products) {
			        	%>
			        			<div class="_1sanpham">
					                <a href="chitietsp.html">
					                    <img src="img/ip3.jpg" alt="">
					                    <h3><%= product.getName() %></h3>
					                    <span><%= product.getDiscountedPrice()%>đ</span>
					                    <span>Số lượng: <b><%= product.getAmount() %></b></span>
					                </a>
				             	</div>
					          
			        	<% } %>
	        		</div>
	        	<div class="pagination">
			            <a href="#">&laquo;</a>
			            <a class="active" href="#">1</a>
			            <a href="#">2</a>
			            <a href="#">3</a>
			            <a href="#">4</a>
			            <a href="#">5</a>
			            <a href="#">6</a>
			            <a href="#">&raquo;</a>
			       	</div>  
	        <% } %>
	       <% } %>
    </div>
</body>
</html>