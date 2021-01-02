<%@page import="ltweb.electronic_store.model.Customer"%>
<%@page import="ltweb.electronic_store.model.Cart"%>
<%@page import="ltweb.electronic_store.model.Product"%>
<%@page import="ltweb.electronic_store.model.DetailCart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./style/giohang.css">
    <link rel="stylesheet" href="./style/checkout1.css">
    <link rel="stylesheet" href="./style/chitietdonhang.css">
    
</head>
<body>
	<div class="navbar">
        <h1>Đặt hàng</h1>
        <a href="cart.html" class="button" id="backBtn">Quay lại</a>
    </div>
    <div id = "chitietdonhang">
        
        <div id = "bodyChitietdonhang">
            <div class = "menuChitietdonhang">
            <%
            	ArrayList<DetailCart> ct = (ArrayList<DetailCart>) request.getSession().getAttribute("products");
                    	if (ct != null) {
                    		
            	        	if (ct.size() == 0) {
            %>
	        		
	        	<%
	        			        		} else {
	        			        	%>
	        	<div class = "maSanpham"><span >Mã sản phẩm</span></div>
                <div class = "tenSanpham">
                    <span >Sản phẩm</span></div>
                <div class = "soluongSanpham"><span >Số lượng</span></div>
                <div class = "giaSanpham"><span>Giá</span></div>
            
            <div class= "sanphamChitietdonhang">
                <div class = "menuChitietdonhang">
                    <%
                    	for(DetailCart chitiet: ct) {
                    %>
			        	<div class = "maSanpham1"><span><%= chitiet.getIdSP()%></span></div>
                    <div class = "tenSanpham1"><span><%= chitiet.getTenSP()%></span></div>
                    <div class = "soluongSanpham1"><span><%= chitiet.getSoluong()%></span></div>
                    <div class = giaSanpham1><span><%= chitiet.getGia()%></span></div>
                    <% } %>
                </div>
                
                
            </div>
            <% } %>
                <% } %>
        </div>
        
        </div>
        <% Cart hd = (Cart) request.getSession().getAttribute("cart");%>
            <div  id = "tongtienChitietdonhang">Tổng tiền: <%= hd.getTotal()%></div>
        <div class="container">
        <div class="client__info" id="clientInfo">
            <p id="title">Thông tin khách hàng</p>
             <% Customer cus = (Customer) request.getSession().getAttribute("customer");%>
             
            <form action = "<%=request.getContextPath()%>/EditInfoCus" method = "get">
            <input type = "hidden" value = <%= cus.getIdCust() %> name = "idCustomer">
            <input type = "submit" value = "Chỉnh sửa" class="button button__checkout" id="infoModifyBtn"/>
            </form>
            <p>Tên người nhận: <span id="clientName"><%= cus.getFullName()%></span></p>
            <p>Số điện thoại: <span id="clientPhone"><%= cus.getPhone()%></span></p>
            <p>Địa chỉ nhận hàng: <span id="clientAddr"><%= cus.getAddress()%></span></p>
        </div>
        <div class="payment__method">
            <p id="title">Lựa chọn phương thức thanh toán</p>
            <div class="method">
                <label class="method__container">Thanh toán khi nhận hàng
                    <input type="radio" name="COD" id="COD" required>
                    <span class="checkmark"></span>
                </label>

            </div>
            <form action="<%=request.getContextPath()%>/WebOrderServlet" method = "post">
            <input type = "hidden" value = "<%= cus.getIdCust()%>" name = "idCustomer">
            <input  type = "submit" id="payBtn" class="button button__checkout" value = "Đặt hàng"/>
            </form>
        </div>

    </div>
    </div>
</body>
</html>