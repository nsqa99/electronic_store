<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                <div class="form-group">
                    <label class="nhan">Tên: </label>
                    <input type="text" class="form-control" placeholder=" " name="Name" required="">
                </div>
                <div class="form-group">
                    <label class="nhan">Tên đăng nhập:</label>
                    <input type="text" class="form-control" placeholder=" " name="Username" required="">
                </div>
                <div class="form-group">
                    <label class="nhan">Email:</label>
                    <input type="email" class="form-control"  placeholder=" " name="Email" required="">
                </div>
                <div class="form-group">
                    <label class="nhan">Số điện thoại:</label>
                    <input type="text" class="form-control" readonly value="0392737733" placeholder=" " name="SDT" required="">
                </div>
                <div class="form-group">
                    <label class="nhan gende">Giới tính:</label>
                    <form>
                        <input name="gioitinh" type="radio" value="Nam" />Nam
                        <input name="gioitinh" type="radio" value="Nữ" />Nữ
                        <input name="gioitinh" type="radio" value="Khác" />Khác
                        </form>
                </div>
                <div class="form-group">
                    <label class="nhan">Ngày sinh:</label>
                    <input type="date" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="">
                </div>
                <div class=" custom-checkbox ">
					<input type="checkbox" class='tat' >
                    <label class="custom-label" for="">Đổi mật khẩu</label>
                     <div class="dehienthi">
                    <div class="form-group">
                        <label class="nhan">Mật khẩu cũ:</label>
                        <input type="password" class="form-control" placeholder=" " name="Password" id="password1" required="">
                    </div>
                    <div class="form-group">
                        <label class="nhan">Mật khẩu mới:</label>
                        <input type="password" class="form-control" placeholder=" " name="Password" id="password1" required="">
                    </div>
                    <div class="form-group">
                        <label class="nhan">Nhập lại mật khẩu:</label>
                        <input type="password" class="form-control" placeholder=" " name="Confirm Password" id="password2" required="">
                    </div>
                </div>
                </div>
                 <button class="luu">Cập nhật</button>
               
            </form>

          </div>
     </div>
     <script src="./Javscrips/thongtincanhan.js"></script> 
</body>
</html>