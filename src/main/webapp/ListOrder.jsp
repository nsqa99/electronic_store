<%@page import="ltweb.electronic_store.model.Order"%>
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
                    <span>Ngày đặt</span>
                </div>
                <div class = danhsachsanpham>
                    <span>Tổng số lượng</span>
                </div>
                 <div class = danhsachtongtien>
                    <span>Tổng tiền</span>
                </div>
                
                
        </div>
        <div id = menuDanhsachdonhang>
        <% ArrayList<Order> Orders = (ArrayList<Order>) request.getSession().getAttribute("orders");
        	if (Orders != null) {
        		
	        	if (Orders.size() == 0) { %>
	        		
	        	<% } else { %>
	        		<div class="dssp">
			        	<% 
			        		for(Order order: Orders) {
			        	%>
            <div class = danhsachdonhang>
                <div class = dsmadonhang1>
                    <span><%= order.getIdOrd() %></span>
                </div>
                
                <div class = "dssanpham1">
                    <span><%= order.getCreatedDate()%></span>
                </div>
                <div class = dsmadonhang1>
                    <span><%= order.getAmount() %></span>
					                    
					                    
                </div>
                <div class="dstongtien1">
                    <span><%= order.getTotal() %></span>
                </div>
                
                
                <!-- <button class="btXemchitiet"></button> -->
                <!-- <div class="btXemchitiet"> -->
                    <form action="<%=request.getContextPath()%>/DetailOrderServlet" method="get">
                    <input type="hidden" name = "idHD" value = <%= order.getIdOrd()%>>
                    <input class = "btXemchitiet" type="submit" value="Xem chi tiết">
                </form>
                <% } %>
                <% } %>
                <% } %>
                 </div> 
            </div>

        </div>
            
        
    </div>
</body>
</html>