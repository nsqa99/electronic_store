<%@page import="ltweb.electronic_store.contants.Settings"%>
<%@page import="ltweb.electronic_store.contants.URLs"%>
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
        	int total = (int) request.getSession().getAttribute("total");
        	//System.out.println("total: " + total);
        	if (products != null) {
        		
	        	if (products.size() == 0) { %>
	        		
	        	<% } else { 
	        		//System.out.println("size" + products.size() + "query size" + Settings.PAGE_SIZE); %>
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
	        	<% 
	        		int currentPage = (int) request.getSession().getAttribute("page");
	        		//System.out.print("current " + currentPage);
	        		String nameQuery = (String) request.getSession().getAttribute("nameQuery");
	        		if (nameQuery == null) nameQuery = "";
	        		nameQuery = nameQuery.replace(" ", "+"); 
	        		
	        		%>
		        	<div class="pagination">
		        		
		        	  <%
		        	  	//System.out.println("page size: " + Settings.PAGE_SIZE + ", total page: " + Math.ceil((double)total/(double)Settings.PAGE_SIZE));
		        	  	for(int i=1; i<=Math.ceil((double)total/(double)Settings.PAGE_SIZE); i++) {
		        			if(currentPage == i) {%>
		        				<a 
		        				class="active"
				        	  	id="page<%=i %>"
				        		href="<%=URLs.searchUrl%><%=nameQuery%>&page=<%=i %>&size=<%=Settings.PAGE_SIZE%>">
				        		<%=i %>
				        		</a> 
		        			<%} else { %>
				        	  	<a 
				        	  	id="page<%=i %>"
				        		href="<%=URLs.searchUrl%><%=nameQuery%>&page=<%=i %>&size=<%=Settings.PAGE_SIZE%>">
				        		<%=i %>
				        		</a> 
		        		<%} %>
		        	  <% } %>
		        	  
				    </div>  
			    
	        <% } %>
	  <% } %>
	       
    </div>
</body>
</html>