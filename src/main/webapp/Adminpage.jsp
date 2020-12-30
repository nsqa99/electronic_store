<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Bán hàng điện tử</title>
                <link rel="stylesheet" href="./style/Adminpage.css">

                <!-- <link rel="stylesheet" href="danhsachdonhang.css"> -->
                <link rel="stylesheet" href="css/font-awesome.css">
                <link rel="stylesheet" href="css/bootstrap.min.css">

        </head>

        <body>
                <div class="admin">
                        <ul>
                                <li class="dau">
                                        <img src="/img/EmployeeImage.png" alt="">
                                        <p>Xin chào, admin</p>
                                </li>
                                <li>
                                        <i class="fa fa-sign-out">Vào trang web</i>
                                </li>
                                <li>
                                        <i class="fa fa-user ">Thông tin tài khoản</i>
                                </li>
                                <li>
                                        Thông báo
                                </li>
                                <li>
                                        <i class="fa fa-sign-out "></i>Đăng xuất </a>
                                </li>
                        </ul>
                </div>
                <div id="khung"></div>
                <div id="danhmuc">
                        <ul id="mucluc">
                                <li class="chucnang">
                                        <input class="btnChucnang" type="button" value="Quản lý đơn hàng"
                                                onclick="Danhsach('Danhsachdonhang', 'themSP', 'Thongke', 'QLNV')">
                                </li>
                                <li class="chucnang">
                                        <input class="btnChucnang" type="button" value="Thêm sản phẩm"
                                                onclick="themSP('themSP', 'Thongke', 'QLNV','Danhsachdonhang')">

                                </li>
                                <li class="chucnang">
                                        <input class="btnChucnang" type="button" value="Xem báo cáo"
                                                onclick="thongke('Thongke', 'QLNV','Danhsachdonhang','themSP')">

                                </li>
                                <li class="chucnang">
                                        <input class="btnChucnang" type="button" value="Quản  lý nhân viên"
                                                onclick="QLNV('QLNV','Danhsachdonhang','themSP','Thongke')">

                                </li>
                        </ul>
                </div>

                <div id="formChucnang">
                        <div id="formDanhsachdonhang">
                                <div id="Danhsachdonhang">
                                        <div id="titleDanhsachdonhang">
                                                Danh sách đơn hàng
                                        </div>
                                        <div class="danhsachdonhang">
                                                <div class="danhsachmadonhang">
                                                        <span> Mã đơn hàng</span>
                                                </div>
                                                <div class="danhsachsanpham">
                                                        <span>Sản phẩm</span>
                                                </div>
                                                <div class=danhsachtongtien>
                                                        <span>Tổng tiền</span>
                                                </div>
                                                <div class=danhsachngay>Ngày</div>

                                        </div>
                                        <div id=menuDanhsachdonhang>
                                                <div class=danhsachdonhang>
                                                        <div class=dsmadonhang1>
                                                                1234
                                                        </div>
                                                        <div class="dssanpham1">
                                                                san pham1
                                                        </div>
                                                        <div class="dstongtien1">
                                                                1234567
                                                        </div>
                                                        <div class="dsngay1">
                                                                12/12/1999
                                                        </div>
                                                        <!-- <button class="btXemchitiet"></button> -->
                                                        <!-- <div class="btXemchitiet"> -->
                                                        <a href="chitietdonhang.html">
                                                                <input class="btXemchitiet" type="button"
                                                                        value="Xem chi tiết">
                                                        </a>
                                                        <!-- </div> -->
                                                </div>

                                        </div>


                                </div>
                        </div>
                        <div id="themSP" class="container">

                                <!-- them san pham -->
                                <div id="themSanPham">
                                        <div id="titleThemSP">
                                                <h1> Them san pham </h1>
                                        </div>
                                        <div id="formThemSP">
                                                <form id="themsanpham" action="/electronic-store/products"
                                                        method="post">
                                                        <label for="loaiSP">Loại Sản phẩm</label>
                                                        <select onchange="handleChange(this.value)" name="loaiSP"
                                                                id="loaiSP">
                                                                <option value="laptop">Laptop</option>
                                                                <option value="dienthoai">Điện thoại</option>
                                                        </select>

                                                        <div id="formContent">
                                                                <input type="text" name="anhSP" class="TextThemSP"
                                                                        placeholder="Anh san pham">
                                                                <input type="text" name="tenSP" class="TextThemSP"
                                                                        placeholder="Nhap ten san pham">
                                                                <input type="text" name="motaSP" class="TextThemSP"
                                                                        placeholder="Nhap mo ta san pham">
                                                                <input type="text" name="giaSP" class="TextThemSP"
                                                                        placeholder="Nhap gia san pham">
                                                                <input type="text" name="soluongSP" class="TextThemSP"
                                                                        placeholder="Nhap so luong san pham">
                                                                <input type="text" name="manhinhSP" class="TextThemSP"
                                                                        placeholder="Nhap kich thuoc man hinh">
                                                                <input type="text" name="manhinhSP" class="TextThemSP"
                                                                        placeholder="Nhap HDH">
                                                                <input type="text" name="cpuSP" class="TextThemSP"
                                                                        placeholder="Nhap CPU">
                                                                <input type="text" name="ramSP" class="TextThemSP"
                                                                        placeholder="Nhap RAM">
                                                                <input type="text" name="romSP" class="TextThemSP"
                                                                        placeholder="Nhap ROM">
                                                                <input type="text" name="pinSP" class="TextThemSP"
                                                                        placeholder="Nhap Pin">
                                                                <input type="text" name="baohanhSP" class="TextThemSP"
                                                                        placeholder="Nhap BaoHanh">
                                                                <br>
                                                                <input type="submit" id="btnThemSP1" value="Xong">
                                                        </div>


                                                </form>

                                        </div>
                                </div>
                        </div>

                        <!-- Thongke -->
                        <div id="Thongke">
                                <div class="tieude">
                                        <h1>Báo cáo doanh thu</h1>
                                </div>
                                <hr>
                                <button class=" nv thoigian" type="button" data-toggle="tooltip" data-placement="top"
                                        title="nv doanh thu">Thời gian</button>
                                <button class=" nv khachhang" type="button" data-toggle="tooltip" data-placement="top"
                                        title="Thống kê khách hàng">Khách hàng</button>
                                <button class="nv sanpham" data-toggle="tooltip" data-placement="top"
                                        title="thống kê mặt hàng">
                                        Mặt hàng</button>
                                <button class="nv nhacc" data-toggle="tooltip" data-placement="bottom"
                                        title="thống kê nhà cung cấp"> Nhà cung cấp</button>
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
                                        <input type="date" class="form-control" placeholder=" " name="Confirm Password"
                                                id="password2" required="">
                                </div>
                                <div class="form-group">
                                        <label class="kt">Ngày kết thúc</label>
                                        <input type="date" class="form-control" placeholder=" " name="Confirm Password"
                                                id="password2" required="">
                                </div>
                                <button class="timkiem">Tìm kiếm</button>
                                <hr>
                                <button class="tongquan">Tổng quan</button>
                                <button class="chitiet">Chi tiết</button>
                        </div>
                        <!-- Quan ly nhan vien  -->
                        <div id="QLNV">
                                <div class="Qlnhanvien">
                                        <div class="tieude " style="text-align: center;">
                                                <h1>QUẢN LÝ NHÂN VIÊN</h1>
                                        </div>
                                        <p class="timkiemnhanvien"><b>TÌM KIẾM NHÂN VIÊN:</b></p>
                                        <input type="text" id="myInput" onkeyup="myFunction()"
                                                placeholder="Nhập tên nhân viên cần tìm..." data-toggle="tooltip"
                                                data-placement="bottom" title="Tìm Kiếm Nhân Viên">
                                        <i class="fa fa-search" aria-hidden="true"></i>

                                        <form action="">

                                        </form>
                                        <b>CHỨC NĂNG CHÍNH:</b><Br>
                                        <button class="nv btn add-new" type="button" data-toggle="tooltip"
                                                data-placement="top" title="Thêm Nhân Viên"><i
                                                        class="fa fa-user-plus"></i></button>
                                        <button class="nv" type="button" onclick="sortTable()" data-toggle="tooltip"
                                                data-placement="top" title="Lọc Dữ Liệu"><i class="fa fa-filter"
                                                        aria-hidden="true"></i></button>
                                        <button class="nv xuat" data-toggle="tooltip" data-placement="top"
                                                title="Xuất File"><i class="fas fa-file-import"></i></button>
                                        <button class="nv cog" data-toggle="tooltip" data-placement="bottom" title=""><i
                                                        class="fa fa-cogs"></i></button>
                                        <div class="table-title">
                                                <div class="row">

                                                </div>

                                        </div>
                                        <table class="table table-bordered" id="myTable">
                                                <thead>
                                                        <tr class="ex">
                                                                <th width="auto">Tên Nhân Viên</th>
                                                                <th width="100px">Giới Tính</th>
                                                                <th>Ngày Sinh</th>
                                                                <th>Địa Chỉ</th>
                                                                <th width="200px;">Chức Vụ</th>
                                                                <th width="200px; !important">Tính Năng</th>
                                                        </tr>
                                                </thead>
                                                <tbody>
                                                        <tr>
                                                                <td>Võ Trường</td>
                                                                <td>Nam</td>
                                                                <td>15/03/2000</td>
                                                                <td>Thông Tin Bảo Mật</td>

                                                                <td>Admin</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-save"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Trần Khả Ái</td>
                                                                <td>Nữ</td>
                                                                <td>12/02/1999</td>
                                                                <td>155-157 Trần Quốc Thảo, Quận 3, Hồ Chí Minh</td>

                                                                <td>Nhân viên</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Nguyễn Tấn Trung</td>
                                                                <td>Nam</td>
                                                                <td>07/10/1997</td>
                                                                <td>6 Nguyễn Lương Bằng, Tân Phú, Quận 7, Hồ Chí Minh
                                                                </td>

                                                                <td>Nhân viên</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sữa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Trần Trúc An</td>
                                                                <td>Nữ</td>
                                                                <td>22/12/1999</td>
                                                                <td>Số 3 Hòa Bình, Phường 3, Quận 11, Hồ Chí Minh</td>

                                                                <td>Nhân viên</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Phạm Thu Cúc</td>
                                                                <td>Nữ</td>
                                                                <td>02/06/1998</td>
                                                                <td>19 Đường Nguyễn Hữu Thọ, Tân Hưng, Quận 7, Hồ Chí
                                                                        Minh</td>

                                                                <td>Thu Ngân</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Nguyễn Thị Kim Ngân</td>
                                                                <td>Nữ</td>
                                                                <td>06/04/1998</td>
                                                                <td>Số 13, Tân Thuận Đông, Quận 7, Hồ Chí Minh</td>
                                                                <td>Thu ngân</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Nguyễn Anh Tuấn</td>
                                                                <td>Nam</td>
                                                                <td>23/07/1996</td>
                                                                <td>59C Nguyễn Đình Chiểu, Quận 3, Hồ Chí Minh</td>
                                                                <td>Nhân viên</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Huỳnh Cẩm Thu</td>
                                                                <td>Nữ</td>
                                                                <td>19/01/1997</td>
                                                                <td>764 Võ Văn Kiệt, Phường 1, Quận 5, Hồ Chí Minh</td>
                                                                <td>Tư Vấn</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Nguyễn Xuân Ly</td>
                                                                <td>Nữ</td>
                                                                <td>30/10/1999</td>
                                                                <td>Đường Kênh T2 Ấp 6 Xã Hưng Long Huyện Bình Chánh,
                                                                        Hưng Long, Bình Chánh, Hồ Chí Minh</td>
                                                                <td>Tư Vấn</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                        <tr>
                                                                <td>Hoàng Xuân Nam</td>
                                                                <td>Nữ</td>
                                                                <td>20/7/1989</td>
                                                                <td>37 Vạn Tượng, Phường 13, Quận 5, Hồ Chí Minh</td>
                                                                <td>Admin</td>
                                                                <td>
                                                                        <a class="add" title="Lưu Lại"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-floppy-o"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="edit" title="Sửa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-pencil"
                                                                                        aria-hidden="true"></i></a>
                                                                        <a class="delete" title="Xóa"
                                                                                data-toggle="tooltip"><i
                                                                                        class="fa fa-trash-o"
                                                                                        aria-hidden="true"></i></a>
                                                                </td>
                                                        </tr>
                                                </tbody>
                                        </table>
                                </div>
                        </div>
                </div>
                <script type="text/javascript" src="./Javscrips/Adminpage.js"></script>
                <script type="text/javascript" src="./Javscrips/addProduct.js"></script>
        </body>

        </html>