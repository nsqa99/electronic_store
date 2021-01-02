<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="1tr">
<head>
	<title>Login</title>
	<meta charset="utf-8"> 
	<link rel="stylesheet" href="./style/login.css">

	<script>
        function dangnhap() {
        }
	</script>
	
</head>
<body>

<div class="container">
	<!-- action="index.html" -->
	<form class="box" method="post" action="<%=request.getContextPath()%>/login"> 
		<h1>Đăng nhập</h1>
		<input type="text" name="username" placeholder="Username" id="usn" required>
		<input type="password" name="password" placeholder="Password"id="psw" required>
		<div class="detail">
			<a  href="forgotpass.jsp" >Quên mật khẩu</a>
			<a 	href="registration.jsp">Đăng ký</a>
		</div>
		<input type="submit" name="" value="Login" onclick="dangnhap()">	
	</form>
</div>
	
</body>
</html>	