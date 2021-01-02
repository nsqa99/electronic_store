<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="./style/giohang.css">
</head>
<body>
    
    <div class="navbar">
        <h1>Giỏ hàng</h1>
    </div>
    <div class="container">
        <!-- <div class="cart__counter">
            <p>
                Số lượng (<span id="item__counter">3</span>)
            </p>
        </div> -->
        <div class="cart__item">
            <a href="#" id="removeBtn" class="button">x</a>
            <img src="img/oppo-a93.jpg"  alt="item_image"/>
            <div id="itemInfo" class="item__info">Lorem ipsum dolor sit amet</div>
            <div class="quantity__container">
                <a href="#" id="addBtn" class="button">+</a>
                <p id="itemQuantity" class="item__quantity">3</p>
                <a href="#" id="subBtn" class="button">-</a>
            </div>
            <div id="itemCost" class="item__cost">300000 VND</div>
        </div>
        <div class="cart__item">
            <a href="#" id="removeBtn" class="button">x</a>
            <img src="img/laptop2.jpg" alt="item_image"/>
            <div id="itemInfo" class="item__info">Lorem ipsum dolor sit amet</div>
            <div class="quantity__container">
                <a href="#" id="addBtn" class="button">+</a>
                <p id="itemQuantity" class="item__quantity">3</p>
                <a href="#" id="subBtn" class="button">-</a>
            </div>
            <div id="itemCost" class="item__cost">300000 VND</div>
        </div>
        <div class="cart__item">
            <a href="#" id="removeBtn" class="button">x</a>
            <img src="img/pk2.jpg" alt="item_image"/>
            <div id="itemInfo" class="item__info">Lorem ipsum dolor sit amet</div>
            <div class="quantity__container">
                <a href="#" id="addBtn" class="button">+</a>
                <p id="itemQuantity" class="item__quantity">3</p>
                <a href="#" id="subBtn" class="button">-</a>
            </div>
            <div id="itemCost" class="item__cost">300000 VND</div>
        </div>
        <div class="cart__item">
            <a href="#" id="removeBtn" class="button">x</a>
            <img src="img/dh2.jpg" alt="item_image"/>
            <div id="itemInfo" class="item__info">Lorem ipsum dolor sit amet</div>
            <div class="quantity__container">
                <a href="#" id="addBtn" class="button">+</a>
                <p id="itemQuantity" class="item__quantity">3</p>
                <a href="#" id="subBtn" class="button">-</a>
            </div>
            <div id="itemCost" class="item__cost">300000 VND</div>
        </div>
       
    </div> 
    <div class="total">
         <form action="<%=request.getContextPath()%>/CartServlet1" method = "get">
        <div class="total__cost">Total: <span id="totalCost"></span> VND</div>
        <input type = "submit" class="button" id="checkoutBtn" value = "Đặt hàng"/>
        </form>
    </div>
    
    <script src="./Javscrips/giohang.js"></script>
</body>
</html>