<%@page import="ltweb.electronic_store.utils.CookieUtils"%>
<%@page import="ltweb.electronic_store.contants.Settings"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Điện máy xanh</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="./style/index.css">

</head>
<body>
	<%
			HttpSession ss = request.getSession();
			String authToken = (String) ss.getAttribute("auth-token");
	%>
     <!-- header -->
            <!-- menu trên -->
	        <div class="thanhxanh" >
                <div class="menushop" style="width: 100%;">
                   <ul>
                       <li>
                         <img class="logo" src="img/logo 12.png" alt="">	
                       </li>
                       <li >
                           <form class="form-inline" action="<%=request.getContextPath()%>/search" method="get">
                               <input id ="boxSearch" name="nameP" type="search" placeholder="Bạn tìm gì.." aria-label="Search" required>
                               <button class="btn" type="submit">Tìm kiếm</button>
                           </form>
                       </li>
                       <li >
                           <a href="#" class="declick">
                           <i class="fa fa-truck"></i>Vận chuyển</a>
                       </li>
                       <li >
                           <a href="giohang.jsp" class="declick" data-hienlen="giohang">
                           <i class="fa fa-shopping-cart"></i>Giỏ hàng</a>
                       </li>
                       <%
                       //System.out.print("token " + tokenCookie);
                         if (!CookieUtils.isAuthenCookieAvailable(request, authToken)) {
                       %> 
	                       <li >
	                           <a href="login.jsp" class="declick" data-hienlen="dangnhap">
	                           <i class="fa fa-sign-in"></i> Đăng nhập </a>
	                       </li>
	                       <li >
	                           <a href="registration.jsp" class="declick" data-hienlen="dangki">
	                           <i class="fa fa-sign-out "></i>Đăng kí </a>
	                       </li>
                       <% } else { %>
                       		<li >
	                           <a href="#" class="declick" data-hienlen="taikhoan">
	                           <i class="fa fa-user-o" aria-hidden="true"></i>Tài khoản</a>
	                       	</li>
	                       	<li >
		                       	<form action="<%=request.getContextPath()%>/logout" method="GET">
		                       		
		                           <button class="btn__logout"><i class="fa fa-sign-out "></i>Đăng xuất</button>
		                       	</form>
	                        
	                       </li>
                       <% } %>
                       
                       
                   </ul> 
               </div>
          </div> 
          <!-- hết menu trên -->
          <!-- menu dưới -->
          <div class="thanhvang" >
           <div class="menu" style="width: 100%;">
              <ul>
                  <li class='mobile'>
                        <a href="#"><i class="fa fa-mobile"></i> Điện thoại</a>
                  </li>
                  <li >
                       <a href="#"><i class="fa fa-laptop"></i>Laptop</a>
                  </li>
                  <li  >
                      <a href="#"><i class="fa fa-tablet"></i>Tablet</a>
                  </li>
                  <li  >
                      <a href="#"><i class="fa fa-headphones"></i>Phụ kiện</a>
                  </li>
                  <li  >
                      <a href="#" ><i class="fa fa-clock-o"></i> Đồng hồ</a>
                  </li>
                  <li >
                      <a href="#"><i class="fa fa-desktop"></i>PC,Máy in </a>
                  </li>
              </ul> 
          </div>
     </div> 
          
     <div class="noidung">
     <div class="slidewraper">
       <div class="cacslide">
           <ul>
               <li>
                   <div class="motslide">
                       <div class="anh" style="background-image:url(img/banner1.jpg);"></div>
                   </div>
               </li>
               <li class="active">
                   <div class="motslide">
                       <div class="anh" style="background-image: url(img/banner3.jpg);"></div>
              
                   </div>
               </li>
               <li>
                   <div class="motslide">
                       <div class="anh" style="background-image: url(img/banner2.jpg);"></div>
             
                   </div>
               </li>
               <li>
                   <div class="motslide">
                       <div class="anh" style="background-image: url(img/banner1.jpg);"></div>
                    
                   </div>
               </li>
           </ul>
       </div>
       <div class="chuyenslide">
           <ul>
               <li>1</li>
               <li class="kichhoat">2</li>
               <li>3</li>
               <li>4</li>
           </ul>
       </div>
   </div>

   <!-- hết banner -->
   <!-- content -->
   <div class="dienthoai">
       <div class="dttren">
           <img src="img/DT1.png" alt="">
       </div>
       <div class="dtduoi">
           <div class="_1anh trai">
               <a href="chitietsp.jsp">
               <img src="img/samsung-galaxy-note-20-ultra-spec.jpg" alt="">
               <p>Samsung Galaxy Note 20 Ultra</p>
               </a>
               <div class="gia">
                   <p>26.490.000đ</p>
                   <del>29.990.000đ</del>
                   <p class="giamgia">-11%</p>
               </div>
               <small>Giảm thêm 1.000.000đ</small>
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">39 đánh giá</div>
               </div>
           </div>

           <div class="_1anh phai">
            <a href="chitietsp.jsp">
               <img src="img/oppo-a93.jpg" alt="">
               <p>OOPO A93</p>
            </a>
               <div class="gia">
                   <p>6.360.000đ</p>
                   <del>7.490.000đ</del>
                   <p class="giamgia">-15%</p>
               </div>
               
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">156 đánh giá</div>
               </div>
           </div>

           <div class="_1anh phai">
            <a href="chitietsp.jsp">
               <img src="img/iphone-11.jpg" alt="">
               <p>Iphone 11 64G (Hộp mới)</p>
            </a>
               <div class="gia">
                   <p>11.990.000đ</p>
               </div>
               <small>Giảm thêm 2.100.000đ</small>
               
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">39 đánh giá</div>
               </div>
           </div>

           <div class="_1anh phai">
            <a href="chitietsp.jsp">
               <img src="img/xiaomi-redmi.jpg" alt="">
               <p>Xiaomi Redmi 9 (4GB/64GB)</p>
            </a>
               <div class="gia">
                   <p>3.390.000đ</p>
                   <del>3.990.000đ</del>
                   <p class="giamgia">-15%</p>
               </div>
               
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">181 đánh giá</div>
               </div>
           </div>

           <div class="_1anh trai">
            <a href="chitietsp.jsp">
               <img src="img/oppo-reno4.jpg" alt="">
               <p>OPPO Reno4</p>
            </a>
               <div class="gia">
                   <p>8.490.000đ</p>
               </div>
               <small>Giảm thêm 1.280.000đ</small>
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">265 đánh giá</div>
               </div>
           </div>

           <div class="_1anh phai">
            <a href="chitietsp.jsp">
               <img src="img/samsung-galaxy.jpg" alt="">
               <p>Samsung Galaxy M51</p>
            </a>
               <div class="gia">
                   <p>8.090.000đ</p>
                   <del>9.490.000đ</del>
                   <p class="giamgia">-14%</p>
               </div>
               
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">90 đánh giá</div>
               </div>
           </div>

           <div class="_1anh phai">
            <a href="chitietsp.jsp">
               <img src="img/realme-7i.jpg" alt="">
               <p>Realme 7i</p>
           </a>
               <div class="gia">
                   <p>5.340.000đ</p>
                   <del>6.290.000đ</del>
                   <p class="giamgia">-15%</p>
               </div>
               
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">16đánh giá</div>
               </div>
           </div>

           <div class="_1anh phai">
            <a href="chitietsp.jsp">
               <img src="img/vivo-v20.jpg" alt="">
               <p>Vio V20</p>
            </a>
               <div class="gia">
                   <p>7.210.000đ</p>
                   <del>8.490.000đ</del>
                   <p class="giamgia">-15%</p>
               </div>
               
               <div class="danhgia">
                   <div class="sao">
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star"></i>
                       <i class="fa fa-star-half"></i>
                   </div>
                   <div class="nhanxet">65 đánh giá</div>
               </div>
           </div>
       </div>
   </div>
   <!-- hết điện thoại -->
   <!-- laptop -->
       <div class="laptop">
           <div class="lttren">
            <a href="chitietsp.jsp">
               <img src="img/LT1.png" alt="">
           </a>
           </div>
           <div class="ltduoi">
               <div class="_1anh trai">
                <a href="chitietsp.jsp">
                   <img src="img/laptop1.jpg" alt="">
                   <p> Acer Aspire 3 A315 56 36YS i3 1005G1 (NX.HS5SV.008)</p>
                </a>
                   <div class="thongso">
                       <div class="ram"> RAM 8GB</div>
                       <div class="ocung">Ổ CỨNG SSD 512GB</div>
                   </div>
                   <div class="gia">
                       <p>13.690.000đ</p>
                       <del>13.990.000đ</del>
                   
                   </div>
                   <small>Quà 100.000đ</small>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/laptop2.jpg" alt="">
                   <p>Lenovo IdeaPad S145 15IIL i3 1005G1 (81W8001XVN)</p>
                </a>
                   <div class="thongso">
                       <div class="ram"> RAM 4GB</div>
                       <div class="ocung">Ổ CỨNG SSD 256GB</div>
                   </div>
                   <div class="gia">
                       <p>9.760.000đ</p>
                       <del>11.490.000đ</del>
                       <p class="giamgia">-15%</p>
                   </div>
                   <small>Quà 100.000đ</small>
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">13 đánh giá</div>
                   </div>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/latop3.jpg" alt="">
                   <p> Lenovo IdeaPad S340 14IIL i3 1005G1(81VV003VVN)</p>
                </a>
                   <div class="thongso">
                       <div class="ram"> RAM 8GB</div>
                       <div class="ocung">Ổ CỨNG SSD 512GB</div>
                   </div>
                   <div class="gia">
                       <p>11.890.000đ</p>
                       <del>11.490.000đ</del>
                       <p class="giamgia">-15%</p>
                   </div>
                   <small>Quà 100.000đ</small>
                   
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">6 đánh giá</div>
                   </div>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/latop4.jpg" alt="">
                   <p>Apple MacBook Air 2017 (MQD32SA/A)</p>
                </a>
                   <div class="thongso">
                       <div class="ram"> RAM 8GB</div>
                       <div class="ocung">Ổ CỨNG SSD 128GB</div>
                   </div>
                   <div class="gia">
                       <p>18.890.000đ</p>
                       <del>20.990.000đ</del>
                       <p class="giamgia">-10%</p>
                   </div>
                   
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">45 đánh giá</div>
                   </div>
               </div>
           </div>
       </div>
       <!-- hết laptop -->
       <!-- tablet -->
       <div class="tablet">
           <div class="tltren">
               <img src="img/TL1.png" alt="">
           </div>
           <div class="tlduoi">
               <div class="_1anh trai">
                <a href="chitietsp.jsp">
                   <img src="img/tablet1.jpg" alt="">
                   <p> Samsung Galaxy Tab A7 (2020)</p>
                </a>
                   <div class="gia">
                       <p>7.990.000đ</p>
                   </div>
               </div>
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/tablet2.jpg" alt="">
                   <p>iPad Mini 7.9 inch Wifi 64GB (2019)</p>
                </a>
                   <div class="gia">
                       <p>9.990.000đ</p>
                       <del>10.990.000đ</del>
                       <p class="giamgia">-9%</p>
                   </div>
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">53 đánh giá</div>
                   </div>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/tablet3.jpg" alt="">
                   <p> Lenovo Tab E10 TB-X104L Đen</p>
                </a>
                   <div class="gia">
                       <p>3.050.000đ</p>
                       <del>3.590.000đ</del>
                       <p class="giamgia">-15%</p>
                   </div>
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">23 đánh giá</div>
                   </div>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/tablet4.jpg" alt="">
                   <p>Masstel Tab 10 Ultra</p>
                </a>
                   <div class="gia">
                       <p>2.940.000đ</p>
                       <del>3.490.000đ</del>
                       <p class="giamgia">-15%</p>
                   </div>
               </div>
           </div>
       </div>
       <!-- hết tablet -->
       <!-- phụ kiện -->
       <div class="phukien">
           <div class="pkrten">
               <img src="img/PK1.png" alt="">
           </div>
           <div class="pkduoi">
               <div class="anh">
                <a href="chitietsp.jsp">
                   <img src="img/pk1.jpg" alt="">
                   <p> Pin sạc dự phòng Polymer 10.000 mAh Xmobile Atela 10 Nhôm Xám</p>
                </a>
                   <div class="gia">
                       <p>455.000đ</p>
                       <del>650.000đ</del>
                   </div>
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">13 đánh giá</div>
                   </div>

               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/pk2.jpg" alt="">
                   <p>Cáp Micro 2 m Xmobile LTMP-2006 Xanh Navy</p>
                </a>
                   <div class="gia">
                       <p>65.000đ</p>
                       <del>100.000đ</del>
                       <p class="giamgia">-35%</p>
                   </div>
               
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">13 đánh giá</div>
                   </div>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/pk3.jpg" alt="">
                   <p> Thẻ nhớ MicroSD 8 GB Class 4</p>
               </a>
                   <div class="gia">
                       <p>120.000đ</p>
                       <del>150.000đ</del>
                       <p class="giamgia">-20%</p>
                   </div>
                   
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">190 đánh giá</div>
                   </div>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/pk4.jpg" alt="">
                   <p>Tai nghe Bluetooth Roman R552N Xanh</p>
                </a>
                   <div class="gia">
                       <p>195.000đ</p>
                       <del>300.000đ</del>
                       <p class="giamgia">-35%</p>
                   </div>
                   
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">58 đánh giá</div>
                   </div>
               </div>
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/pk5.jpg" alt="">
                   <p>Tai nghe chụp tai Beats Studio3 Wireless MX422/ MX432</p>
                </a>
                   <div class="gia">
                       <p>7.690.000đ</p>
                   </div>
               </div>
           </div>
       </div>
       <!-- hết phụ kiện -->
       <!-- đồng hồ thông minh -->
       <div class="dongho">
           <div class="dhtren">
               <img src="img/DH1.png" alt="">
           </div>
           <div class="dhduoi">
               <div class="anh ">
                <a href="chitietsp.jsp">
                   <img src="img/dh1.jpg" alt="">
                   <p> Apple Watch S6 LTE 40mm viền nhôm dây cao su</p>
                </a>   
                   <div class="thongso">
                       <div class="sim"> ESIM</div>
                       <div class="chucnang">NGHE GỌI TRÊN ĐỒNG HỒ</div>
                   </div>
                   <div class="gia">
                       <p>13.591.000đ</p>
                       <del>15.990.000đ</del>
                   
                   </div>
                   
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/dh2.jpg" alt="">
                   <p>Apple Watch SE 40mm viền nhôm dây cao su</p>
                   </a>
                   <div class="thongso">
           
                       <div class="chucnang">NGHE GỌI TRÊN ĐỒNG HỒ</div>
                   </div>
                   <div class="gia">
                       <p>7.641.000đ</p>
                       <del>8.990.000đ</del>
                       <p class="giamgia">-15%</p>
                   </div>
                   
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/dh3.jpg" alt="">
                   <p> Samsung Galaxy Watch Active 2 44mm viền thép dây da</p>
                </a>
                   <div class="thongso">
           
                       <div class="chucnang">NGHE GỌI TRÊN ĐỒNG HỒ</div>
                   </div>
                   <div class="gia">
                       <p>7.992.000đ</p>
                       <del>9.990.000đ</del>
                       <p class="giamgia">-20%</p>
                   </div>
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">9 đánh giá</div>
                   </div>
               </div>
   
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/dh4.jpg" alt="">
                   <p>Samsung Galaxy Watch 3 41mm viền thép hồng dây da</p>
                </a>
                   <div class="thongso">
           
                       <div class="chucnang">NGHE GỌI TRÊN ĐỒNG HỒ</div>
                   </div>
                   <div class="gia">
                       <p>7.890.000đ</p>
                       <del>9.490.000đ</del>
                       <p class="giamgia">-15%</p>
                   </div>
                   
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">8 đánh giá</div>
                   </div>
               </div>
               <div class="_1anh phai">
                <a href="chitietsp.jsp">
                   <img src="img/dh5.jpg" alt="">
                   <p>Oppo Watch 41mm dây silicone hồng</p>
                </a>
                   <div class="thongso">
           
                       <div class="chucnang">NGHE GỌI TRÊN ĐỒNG HỒ</div>
                   </div>
                   <div class="gia">
                       <p>5.091.000đ</p>
                       <del>5.990.000đ</del>
                       <p class="giamgia">-15%</p>
                   </div>
                   
                   <div class="danhgia">
                       <div class="sao">
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star"></i>
                           <i class="fa fa-star-half"></i>
                       </div>
                       <div class="nhanxet">26 đánh giá</div>
                   </div>
               </div>
           </div>
       </div>
       <!-- hết đồng hồ thông minh -->
     </div>
     
       <div class="Footer">
           <div class="Detail-footer">
               <div class="Detail-footer1">
                   <ul class="Footer-List">
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Lịch sử mua hàng</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Giao hàng & thanh toán</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Chính sách bảo hàng</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">chính sách đổi trả</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Tìm hiểu mua trả góp</a>
                       </li>   
                   </ul>
               </div>
               <div class="Detail-footer1">
                   <ul class="Footer-List">
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Giới thiệu công ty</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Tuyển dụng</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Gửi góp ý, khiếu nại</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Tìm siêu thị</a>
                       </li>
                       <li class="Footer-item">
                           <a href="" class="footer-item-link">Chính sách</a>
                       </li>                   
                   </ul>
               </div>
               <div class="Detail-footer1 lien-lac">
                   <ul class="Footer-List ">
                       <li class="Footer-item cuocgoi">
                           <img src="img/3.PNG" alt="" class="anh1" >  
                           <p class="goi">Gọi mua hàng</p>       
                           <a href="" class="footer-item-link">1800.1060 (7:30-22:00)</a>
                       </li>
                       <li class="Footer-item cuocgoi">
                           <img src="img/3.PNG" alt="" class="anh1" > 
                           <p class="goi">Gọi khiếu nại</p>  
                           <a href="" class="footer-item-link">1800.1062 (8:00-21:30</a>
                       </li>
                       <li class="Footer-item cuocgoi">
                           <img src="img/3.PNG" alt="" class="anh1" > 
                           <p class="goi">Gọi bảo hàng</p>  
                           <a href="" class="footer-item-link">1800.1064 (8:00-21:00</a>
                       </li>
                       <li class="Footer-item cuocgoi">
                           <img src="img/3.PNG" alt="" class="anh1" > 
                           <p class="goi">Kỹ thuật</p>  
                           <a href="" class="footer-item-link">1800.1063 (7:30-22:00)</a>
                       </li>
                   </ul>
               </div>
               <div class="Detail-footer1 dang">
                   <i class="fa fa-envelope-open"></i>
                   <p class="footer-free">Đăng kí nhận bản tin</p>
                   <div class="email-go">
                       <input type="text" placeholder="Nhập email của bạn" name="Email" class="inputemail">
                       <button class="buttongo">Đăng kí</button>
   
                   </div>
                   <h3 class="theodoi">Theo dõi</h3>
                   <ul class="list-anh">
                       <li class="icon3">
                           <a><img src="img/fb.PNG" alt="fb"></a>
                       </li>
                       <li class="icon3">
                           <a><img src="img/email.PNG" alt="fb"></a>
                       </li>
                       <li class="icon3">
                           <a><img src="img/google.PNG" alt="fb"></a>
                       </li>
                   </ul>
               </div>
           </div>
       </div>
       <!-- hết footer -->
       <div class="copy-right">
           <p>© 2018. Công ty cổ phần Thế Giới Di Động. GPMXH: 238/GP-BTTTT do Bộ Thông Tin và Truyền Thông cấp ngày 04/06/2020. Địa chỉ: 128 Trần Quang Khải, P. Tân Định, Q.1, TP.Hồ Chí Minh. Điện thoại: 028 38125960. Email: cskh@thegioididong.com.
               Chịu trách nhiệm nội dung: Huỳnh Văn Tốt. Xem chính sách sử dụng</p>
       </div>

    <script src="./Javscrips/index.js"></script>
</body>
</html>