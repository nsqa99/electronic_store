<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./style/quanlysanpham.css">
</head>
<body>
    <div class="container">
        <form id="thanhtimkiem">
            <!-- <label>Tìm kiếm sản phẩm</label> -->
            <input id = "textTimkiem" type="text" name="name" placeholder="Tim kiem san pham" />
            <input id = "btnTimkiem" type="button" value="Tìm kiếm" />
            <input id = "btnThemSP" type="button" value="Them san pham">
        </form>
        <!-- them san pham -->
        <div id = "themSanPham">
            <div id  = "titleThemSP">
                <h1> Them san pham </h1>
            </div>
            <div id = "formThemSP">
                <input type="text" class="TextThemSP" placeholder="Anh san pham">
                <input type="text" class="TextThemSP" placeholder="Nhan ten san pham">
                <input type="text" class="TextThemSP" placeholder="Nhap mo ta san pham">
                <input type="text" class="TextThemSP" placeholder="Nhap gia san pham">
                <input type="text" class="TextThemSP" placeholder="Nhap so luong san pham">
                <input type="button" id="btnThemSP1" value="Xong"> 
            </div>
        </div>
    </div>
    
</body>
</html>