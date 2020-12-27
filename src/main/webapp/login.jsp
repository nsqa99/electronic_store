<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="1tr">
<head>
	<title>Login</title>
	<meta charset="utf-8"> 
	<link rel="stylesheet" href="./style/login.css">

	<script>
        function dangnhap() {
            var a = document.getElementById('tendn');
            var b = document.getElementById('mkdn');
            if (a.value == "admin" && b.value == "1234") {
                alert("Dang nhap thanh cong");
                history.back();
            }else{
                alert("Dang nhap khong thanh cong!")
            }
        }
	</script>
	
</head>
<body>
<div class="container">
	<!-- action="index.html" -->
	<form class="box" method="post" > 
		<h1>Đăng nhập</h1>
		<input type="text" name="" placeholder="Username" id="tendn">
		<input type="password" name="" placeholder="Password"id="mkdn">
		<div class="detail">
			<a  href="forgotpass.jsp" >Quên mật khẩu</a>
			<a 	href="registration.jsp">Đăng ký</a>
		</div>
		<input type="submit" name="" value="Login" onclick="dangnhap()">	
	</form>
</div>
	
</body>
</html>	