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
        function checkPass(){
            var pass1 = document.getElementById("passdk1");
            var pass2 = document.getElementById("passdk2");
            if(pass1.value != pass2.value){
                // alert("Mật khẩu không giống nhau. Nhập lại mật khẩu.")
                return false;
            }else return true; 
        }

        function dangky(){
            if (checkPhone()){
                if (checkPass){
                    alert("Bạn đã đăng ký thành công!")
                    history.back();
                }
                else alert("Mật khẩu không giống nhau. Nhập lại mật khẩu.")
            }else alert("Số điện thoại không hợp lệ")
        }
    </script>
</head>
<body>
<div class="container">
	<!-- action="index.html" -->
    <form class="box" method="post" onsubmit="dangky()" > 
        <div class="tendangky">
            <div class="imgdangky">
                <a  href="login.jsp"><img src="./img/muiten.PNG"></a>
            </div>
            <div class="h1dk"><h1>Đăng ký</h1></div>
        </div>
		
		<input type="text" name="" placeholder="Username" id="tendk" >
        <input type="password" name="" placeholder="Password" id="passdk1">
        <input type="password" name="" placeholder="Re-Password"id="passdk2">
        <input type="text" name="" placeholder="Số điện thoại"id="phone">
		<input type="submit" name="" value="Registration" >	
	</form>
</div>
	
</body>
</html>	