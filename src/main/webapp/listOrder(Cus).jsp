<%@page import="ltweb.electronic_store.model.DetailOrdes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./style/danhsachdonhang1.css">
   
</head>
<body>
    <div id = "Danhsachdonhang">
        <div id = "titleDanhsachdonhang">
            Danh sách đơn hàng
        </div>
        <div class = "danhsachdonhang">
                <div class = "danhsachmadonhang">
                    <span> Mã đơn hàng</span>
                </div>
                
                 <div class = "danhsachngay">
                    <span>Mã sản phẩm</span>
                </div>
                <div class = danhsachsanpham>
                    <span>Tên sản phẩm</span>
                </div>
                <div class = danhsachsanpham>
                    <span>Số lương</span>
                </div>
                 <div class = danhsachtongtien>
                    <span>Tổng tiền</span>
                </div>
                
                
        </div>
        <div id = menuDanhsachdonhang>
        <% ArrayList<DetailOrdes> Orders = (ArrayList<DetailOrdes>) request.getSession().getAttribute("detailOr");
        	if (Orders != null) {
        		
	        	if (Orders.size() == 0) { %>
	        		
	        	<% } else { %>
	        		<div class="dssp">
			        	<% 
			        		for(DetailOrdes order: Orders) {
			        	%>
            <div class = danhsachdonhang>
                <div class = dsmadonhang1>
                    <span><%= order.getIdHD() %></span>
                </div>
                
                <div class = "dssanpham1">
                    <span><%= order.getIdSP()%></span>
                </div>
                <div class = dsmadonhang1>
                    <span><%= order.getTenSP() %></span>
					                    
					                    
                </div>
                <div class="dstongtien1">
                    <span><%= order.getSoluong() %></span>
                </div>
                <div class="dstongtien1">
                    <span><%= order.getGia()*order.getSoluong() %></span>
                </div>
                
                
                <!-- <button class="btXemchitiet"></button> -->
                <!-- <div class="btXemchitiet"> -->
                    
                <% } %>
                <% } %>
                <% } %>
                 </div> 
            </div>

        </div>
            
        
    </div>
</body>
</html>