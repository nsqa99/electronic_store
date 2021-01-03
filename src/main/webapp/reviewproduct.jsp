<%@page import="ltweb.electronic_store.model.Product"%>
<%@page import="ltweb.electronic_store.model.Rating"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ReviewProduct</title>
<link rel="stylesheet" href="./style/reviewproduct.css">
</head>
<body>
	<div class="tong">
		<div class="tongdanhgia">
			<h1>Đánh giá sản phẩm</h1>
			<div class="chitietdanhgia">
				<%
					Product pro = (Product) request.getSession().getAttribute("product");
				if (pro != null) {
				%>
				<div class="imganhdaidien">
					<div class="avata">
						<img src="<%=pro.getImage()%>">
					</div>
				</div>
				<form action="<%=request.getContextPath()%>/RatingServlet" method="post">
				<div class="noidungdanhgia">
				<%
					Rating rate = (Rating) request.getSession().getAttribute("rate");
				if (rate != null) {
				%>
					<div class="tenspdanhgia">
						<h5><%=pro.getName()%></h5>
					</div>
					
					<div class="imgrating">
							1<input name="rate" type="radio" value="1" />
							2<input name="rate" type="radio" value="2" />
							3<input name="rate" type="radio" value="3" />
							4<input name="rate" type="radio" value="4" />
							5<input name="rate" type="radio" value="5" /> 
							
					</div>
					<div class="frm">
						<div class="boxdanhgia" >
							<textarea placeholder="Nội dung đánh giá" rows="5" name = "content">
							<%  if(rate.getContent() != null){%><%=rate.getContent()%><%} %></textarea>
							<input type = "hidden" value = "<%=pro.getIdProduct()%>" name = "idProduct"/>
							<input type = "hidden" value = "1" name = "idCustomer"/>
							<%  if(rate.getContent() != null){ %><input type = "hidden" value = <%= rate.toString()%> name = "dg"/><%} %>
							<input type = "submit" value = "Đánh giá" style = "font-size: 1.5VW"/>
						</div>
					</div>
					<% } %>
				</div>
				
				<%
					}
				%>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
