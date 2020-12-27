<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đặt hàng</title>
    <link rel="stylesheet" href="./style/giohang.css">
    <link rel="stylesheet" href="./style/checkout.css">
</head>
<body>
    <div class="navbar">
        <h1>Đặt hàng</h1>
        <a href="cart.html" class="button" id="backBtn">Quay lại</a>
    </div>
    <div class="container">
        <div class="client__info" id="clientInfo">
            <p id="title">Thông tin khách hàng</p>
            <a href="#" class="button button__checkout" id="infoModifyBtn">Chỉnh sửa</a>
            <p>Tên người nhận: <span id="clientName">Nguyễn Sỹ Quang Anh</span></p>
            <p>Số điện thoại: <span id="clientPhone">0123456789</span></p>
            <p>Địa chỉ nhận hàng: <span id="clientAddr">Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit quod atque ipsa deserunt cum pariatur quia facilis sit minima animi.</span></p>
            <p>Email: <span id="clientMail">example@ptit.web.vn</span></p>
        </div>
        <div class="payment__method">
            <p id="title">Lựa chọn phương thức thanh toán</p>
            <div class="method">
                <label class="method__container">Thanh toán khi nhận hàng
                    <input type="radio" name="COD" id="COD" required>
                    <span class="checkmark"></span>
                </label>
            </div>
            <a href="#" id="payBtn" class="button button__checkout">Đặt hàng</a>
        </div>

    </div>
</body>
</html>