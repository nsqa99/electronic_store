<%@page import="com.mysql.cj.jdbc.ha.ReplicationMySQLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="1tr">
<head>
	<title>Dangky</title>
	<meta charset="utf-8"> 
	<link rel="stylesheet" href="./style/registration.css">

        
    <script>
        function checkPhone() {
            var phone = document.getElementById("phone");
            var phoneRegex = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
            return phone.value.match(phoneRegex);
        };
        function checkPass1() {
            var pass1 = document.getElementById("passdk1");
            var passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})";
            return pass1.value.match(passRegex);
        };
        
        function checkPass2(){
            var pass1 = document.getElementById("passdk1");
            var pass2 = document.getElementById("passdk2");
            if(pass1.value != pass2.value){
                return false;
            }else return true; 
        }

        function dangky(){
            if (checkPhone()){
            	if (checkPass1()){
                   if (checkPass2()){
                    alert("Bạn đã đăng ký thành công!")
                    history.back();
                  }else alert("Mật khẩu không giống nhau");
            	}else alert("Mật khẩu tối thiểu 8 kí tự ");
                
            }else alert("Số điện thoại không hợp lệ");
        }
    </script>
</head>
<body>
<h1> <%=request.getAttribute("errorMessage")!= null ? request.getAttribute("errorMessage") : " "%></h1>
<div class="container">
	<!-- action="index.html" -->
    <form class="box" action="<%=request.getContextPath()%>/resgister" method="post" onsubmit="dangky()" > 
        <div class="tendangky">
            <div class="imgdangky">
                <a  href="login.jsp"><img src="./img/muiten.PNG"></a>
            </div>
            <div class="h1dk"><h1>Đăng ký</h1></div>
        </div>
		<input type="text" name="fullname" placeholder="Tên đầy đủ" id="fullname" >
		<input type="text" name="username" placeholder="Tài khoản" id="tendk" >
        <input type="password" name="password" placeholder="Mật khẩu" id="passdk1">
        <input type="password" name="repassword" placeholder="Nhập lại mật khẩu "id="passdk2">
        <input type="text" name="" placeholder="Địa chỉ" id="Address" >
        <input type="text" name="phone" placeholder="Số điện thoại"id="phone">
		<input type="text" name="gender" placeholder="Giới tính" id="gender" >
		<input type="submit" name="" value="Registration" >	
	</form>
</div>
	
</body>
</html>	