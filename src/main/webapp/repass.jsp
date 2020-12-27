<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style/repass.css">
    <title>repass</title>
</head>
<script>
    function checkrePass(){
            var repass = document.getElementById("mkmoi");
            var repass2 = document.getElementById("mkmoi2");
            if(repass.value != repass2.value){
                alert("Mật khẩu không giống nhau. Nhập lại mật khẩu.")
                return false;
            }else return true; 
        }
</script>
<body>
    <div class="container">
        <!-- action="index.html" -->
        <form class="boxrepass" method="post" onsubmit="checkrePass"> 
            <div class="imgremk">
                <a  href="forgotpass.jsp"><img src="./img/muiten.PNG"></a>
            
                <div class="h1remk">
                <h1>Mật khẩu mới</h1>
                </div>
            </div>
            
            <input type="password" name="" placeholder="Nhập mật khẩu mới" id="mkmoi">
            <input type="password" name="" placeholder="Nhập lại mật khẩu mới" id="mkmoi2">
            <input type="submit" name="" value="Đặt lại mật khẩu" >	
        </form>
    </div>
        
    </body>
</html>