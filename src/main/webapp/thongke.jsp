<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./style/thongke.css">
</head>
<body>
    <div class="Thongke">
        <div class="tieude">
            <h1>Báo cáo doanh thu</h1>
        </div>
        <hr>
        <button class=" nv thoigian" type="button" data-toggle="tooltip" data-placement="top"
                title="nv doanh thu">Thời gian</button>
        <button class=" nv khachhang" type="button"  data-toggle="tooltip" data-placement="top"
                title="Thống kê khách hàng">Khách hàng</button>
        <button class="nv sanpham" data-toggle="tooltip" data-placement="top" title="thống kê mặt hàng">
               Mặt hàng</button>
        <button class="nv nhacc" data-toggle="tooltip" data-placement="bottom" title="thống kê nhà cung cấp"> Nhà cung cấp</button>
        <hr>
        <div class="loaibaocao">
        <label for="type">Loại thời gian</label>
        <select name="cars" id="times">
        <option value="volvo">Báo cáo theo ngày</option>
        <option value="saab">Báo cáo theo tháng</option>
        <option value="mercedes">Báo cáo theo quý</option>
        <option value="audi">Báo cáo theo năm</option>
        </select>
        </div>
        <div class="form-group">
            <label class="bd">Ngày bắt đầu</label>
            <input type="date" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="">
        </div>
        <div class="form-group">
            <label class="kt">Ngày kết thúc</label>
            <input type="date" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="">
        </div>
        <button class="timkiem">Tìm kiếm</button>
        <hr>
        <button class="tongquan">Tổng quan</button>
        <button class="chitiet">Chi tiết</button>
    </div>
</body>
</html>