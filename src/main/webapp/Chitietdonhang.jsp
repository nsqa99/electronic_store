<%@page import="ltweb.electronic_store.model.Customer"%>
<%@page import="ltweb.electronic_store.model.Order"%>
<%@page import="ltweb.electronic_store.model.Product"%>
<%@page import="ltweb.electronic_store.model.ChitietHoadon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./style/chitietdonhang1.css">
</head>
<body>
    <div id = "chitietdonhang">
        <h1 id = "titleChitietdonhang"> Chi tiết đơn hàng</h1>
        <div id = "bodyChitietdonhang">
            <div class = "menuChitietdonhang">
            <% ArrayList<ChitietHoadon> ct = (ArrayList<ChitietHoadon>) request.getSession().getAttribute("chitiet");
        	if (ct != null) {
        		
	        	if (ct.size() == 0) { %>
	        		
	        	<% } else { %>
	        	<div class = "maSanpham"><span >Mã sản phẩm</span></div>
                <div class = "tenSanpham">
                    <span >Sản phẩm</span></div>
                <div class = "soluongSanpham"><span >Số lượng</span></div>
                <div class = "giaSanpham"><span>Giá</span></div>
            
            <div class= "sanphamChitietdonhang">
                <div class = "menuChitietdonhang">
                    <% 
			        		for(ChitietHoadon chitiet: ct) {
			        	%>
			        	<div class = "maSanpham1"><span><%= chitiet.getIdSP()%></span></div>
                    <div class = "tenSanpham1"><span><%= chitiet.getTenSP()%></span></div>
                    <div class = "soluongSanpham1"><span><%= chitiet.getSoluong()%></span></div>
                    <div class = giaSanpham1><span><%= chitiet.getGia()%></span></div>
                    <% } %>
                </div>
                
                <% } %>
                <% } %>
            </div>
        </div>
        <% Order hd = (Order) request.getSession().getAttribute("hoadon");%>
            <div  id = "tongtienChitietdonhang">Tổng tiền: <%= hd.getTotal()%></div>
            <div id = "thongtinChitietdonhang">
                <div id = "ngaydat"> Ngày đặt: <%= hd.getCreatedDate()%></div>
                 <% Customer kh = (Customer) request.getSession().getAttribute("khachhang");%>
                
                <div id = "hotenkhach">Họ tên khách hàng nhận: <%= kh.getFullName()%></div>
                <div id = "sdt">Số điện thoại:  <%= kh.getPhone()%></div>
                <div id = "diachi">Địa chỉ:  <%= kh.getAddress()%></div>
            </div>
            <div style="float: right;">
                
                <input type="button" value="OK" class = btChitietdonhang onclick = history.back()>
            </div>
            
        </div> 
    </div>
</body>
</html>