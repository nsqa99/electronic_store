<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ltweb.electronic_store.model.*" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./style/thongtincanhan.css">
    <link rel="stylesheet" href="css/font-awesome.css">
</head>
<body>
     <div class="thongtin">
         <div class="tieude">
             <h1>Thông tin tài khoản</h1>
         </div>
         <div class="trai">
             <img src="img/daidien.jpg" alt="">
             <!-- <div class="thaydoi">Thay đổi</div> -->
         </div>
          <div class="phai">
            <form action="#" name="myForm" method="post">
            	<% ArrayList<Customer> customer = (ArrayList<Customer>) request.getSession().getAttribute("in4cus");
                        		if (customer != null) {%>
                        	<%if (customer.size() == 0) { %>
            	        		
            	        		<% }  else{%>
            	        		<% 
			        				for(Customer cus : customer) {
			        			%>	
                <div class="form-group">
                    <label class="nhan">Tên: </label>
                    <input type="text" class="form-control" readonly value="<%=cus.getFullName()%>" placeholder=" " name="Name" required="">
                </div>
                <div class="form-group">
                    <label class="nhan">Địa chỉ:</label>
                    <input type="text" class="form-control" readonly value="<%=cus.getAddress()%>" placeholder=" " name="Username" required="">
                </div>
                <div class="form-group">
                    <label class="nhan">Giới tính:</label>
                    <input type="text" class="form-control" readonly value="<%=cus.getGender()%>" placeholder=" " name="gioitinh" required="">
                </div>
                <div class="form-group">
                    <label class="nhan">Số điện thoại:</label>
                    <input type="text" class="form-control" readonly value="<%=cus.getPhone()%>" placeholder=" " name="SDT" required="">
                </div>
                
                
                <% } %>
                <% } %>
                <% } %>
                <button class="luu" onclick="quay_lai_trang_truoc()">Về trang chủ</button>
                 <button class="luu">Cập nhật</button>
               
            </form>

          </div>
     </div>
     <script>
      function quay_lai_trang_truoc(){
          history.back();
      }
  		</script>
     <script src="./Javscrips/thongtincanhan.js"></script> 
</body>
</html>