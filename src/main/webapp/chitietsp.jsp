
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ltweb.electronic_store.model.Mobile"%>
<%@page import="ltweb.electronic_store.model.Laptop"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./style/chitietsanpham.css">
    <title>Chi Tiết Sản Phẩm</title>
</head>
<body>
    <!-- thanh vang -->
    <div class="thanhvang">
        <div class="container">
            <ul class="menu">
                <li class="menu-item"><a href="index.jsp">Điện thoại</a></li>
                <li class="menu-item"><a href="index.jsp">Laptop</a></li>
                <li class="menu-item"><a href="index.jsp">Tablet</a></li>
                <li class="menu-item"><a href="index.jsp">Phụ kiện</a></li>
                <li class="menu-item"><a href="index.jsp">Đồng hồ</a></li>
                <li class="menu-item"><a href="index.jsp">PC,Máy in</a></li>
            </ul>
        </div>
    </div>
    <!-- Het thanh vang -->
    <!-- Chi tiet sp -->
    <% 
    	HttpSession ss = request.getSession();
    	String type = (String) ss.getAttribute("pType");
    	Laptop laptop = null;
    	Mobile mobile = null;
    	if (type != null) {
    		if (type.equals("laptop")) { 
    			laptop = (Laptop) ss.getAttribute("oneProduct");    		
    		} else {
    			mobile = (Mobile) ss.getAttribute("oneProduct");
    		}
    	}
    	
    %>
    <div class="chitietsp">
    	<% if (laptop != null) { %> 
		    	<div class="tensp">
		            <h1><%=laptop.getName() %></h1>
		        </div>
		        <div class="thongtinsp">
		            <div class="anhsp">
		                
		                <div class="anhto">
		                    <img id="imgBox" src="<%=laptop.getImage()%>" alt="anh-san-pham">
		                </div>
		                <!--  
		                <div class="anhnho">
		                    <ul>
		                        <li>
		                            <img id = "image1"src="img/ip3.jpg" alt="" onclick="MyFunction(this)">
		                        </li>
		                        <li>
		                            <img src="img/ip1.jpg" alt="" onclick="MyFunction(this)">
		                        </li>
		                        <li>
		                            <img src="img/ip2.png" alt="" onclick="MyFunction(this)">
		                        </li>
		                    </ul>
		                    
		                    
		                    
		                </div> -->
		            </div>
		           
		            <div class="bangthongso">
		            	<% if (laptop.getDiscountedPrice() != laptop.getPrice()) { %> 
		            		<Strong class="giamoi"><%=NumberFormat.getCurrencyInstance().format(laptop.getDiscountedPrice()).substring(1)%>₫</Strong>
		                	<span class="giacu"><%=NumberFormat.getCurrencyInstance().format(laptop.getPrice()).substring(1)%>₫</span>
		            	<%} else { %> 
		            		<Strong class="giamoi"><%=NumberFormat.getCurrencyInstance().format(laptop.getPrice()).substring(1)%>₫</Strong>
		            	<%} %>
		                
		                <h2>Thông số kỹ thuật</h2>
		                <ul class="thongso">
		                    <li>
		                        <span>Màn hình:</span>
		                        <div><%=laptop.getScreen() %></div>
		                    </li>
		                    
		                    <li>
		                        <span>Hệ điều hành:</span>
		                        <div><%=laptop.getOs() %></div>
		                    </li>
		                    <li>
		                        <span>Camera:</span>
		                        <div><%=laptop.getCamera() %></div>
		                    </li>
		                    <li>
		                        <span>Card đồ họa:</span>
		                        <div><%=laptop.getVGA() %></div>
		                    </li>
		                    <li>
		                        <span>CPU:</span>
		                        <div><%=laptop.getCpu() %></div>
		                    </li>
		                    <li>
		                        <span>RAM:</span>
		                        <div><%=laptop.getRam()%></div>
		                    </li>
		                    <li>
		                        <span>Bộ nhớ:</span>
		                        <div><%=laptop.getRom() %></div>
		                    </li>
		                    <li>
		                        <span>Dung lượng pin:</span>
		                        <div><%=laptop.getBattery()%></div>
		                    </li>
		                    <li>
		                        <span>Bảo hành:</span>
		                        <div><%=laptop.getWarranty()%></div>
		                    </li>
		                </ul>
		                <input type="button" id="themvaogiohang" name="addcart" value="Thêm vào giỏ hàng" onclick="them()">
		            </div>
		        </div>
		    </div>
    	<%} else if (mobile != null) { %>
    		<div class="tensp">
		            <h1><%=mobile.getName() %></h1>
		        </div>
		        <div class="thongtinsp">
		            <div class="anhsp">
		                
		                <div class="anhto">
		                    <img id="imgBox" src="<%=mobile.getImage()%>" alt="anh-san-pham">
		                </div>
		                <!--  
		                <div class="anhnho">
		                    <ul>
		                        <li>
		                            <img id = "image1"src="img/ip3.jpg" alt="" onclick="MyFunction(this)">
		                        </li>
		                        <li>
		                            <img src="img/ip1.jpg" alt="" onclick="MyFunction(this)">
		                        </li>
		                        <li>
		                            <img src="img/ip2.png" alt="" onclick="MyFunction(this)">
		                        </li>
		                    </ul>
		                    
		                    
		                    
		                </div> -->
		            </div>
		           
		            <div class="bangthongso">
		            	<% if (mobile.getDiscountedPrice() != mobile.getPrice()) { %> 
		            		<Strong class="giamoi"><%=NumberFormat.getCurrencyInstance().format(mobile.getDiscountedPrice()).substring(1) %>₫</Strong>
		                	<span class="giacu"><%=NumberFormat.getCurrencyInstance().format(mobile.getPrice()).substring(1)%>₫</span>
		            	<%} else { %> 
		            		<Strong class="giamoi"><%=NumberFormat.getCurrencyInstance().format(mobile.getPrice()).substring(1)%>₫</Strong>
		            	<%} %>
		                
		                <h2>Thông số kỹ thuật</h2>
		                <ul class="thongso">
		                    <li>
		                        <span>Màn hình:</span>
		                        <div><%=mobile.getScreen() %></div>
		                    </li>
		                    
		                    <li>
		                        <span>Hệ điều hành:</span>
		                        <div><%=mobile.getOs() %></div>
		                    </li>
		                    <li>
		                        <span>Camera trước:</span>
		                        <div><%=mobile.getFrontCamera()%></div>
		                    </li>
		                    <li>
		                        <span>Camera sau:</span>
		                        <div><%=mobile.getBackCamera()%></div>
		                    </li>
		                    <li>
		                        <span>CPU:</span>
		                        <div><%=mobile.getCpu() %></div>
		                    </li>
		                    <li>
		                        <span>RAM:</span>
		                        <div><%=mobile.getRam()%></div>
		                    </li>
		                    <li>
		                        <span>Bộ nhớ trong:</span>
		                        <div><%=mobile.getRom() %></div>
		                    </li>
		                    <li>
		                        <span>Dung lượng pin:</span>
		                        <div><%=mobile.getBattery()%></div>
		                    </li>
		                    <li>
		                        <span>Bảo hành:</span>
		                        <div><%=mobile.getWarranty()%></div>
		                    </li>
		                </ul>
		                <input type="button" id="themvaogiohang" name="addcart" value="Thêm vào giỏ hàng" onclick="them()">
		            </div>
		        </div>
		    </div>
    	 <% } %>
        
    <!-- Het chi tiet sp -->
    <!-- Đánh giá -->
    <div class="tong">
        <div class="tongdanhgia">
            <h1>Đánh giá sản phẩm</h1>
            <div class="chitietdanhgia">
                <div class="imganhdaidien">
                <div class="avata">
                    <a href="#"><img src="img/Capture.PNG"></a>
                </div>
                </div>
                <div class="noidungdanhgia">
                <div class="tenspdanhgia">
                    <h5>Iphone12XsMax</h5>
                </div>
                <div class="imgrating">
                    <img src="img/sao.PNG" alt="#">
                </div>               
                <div class="frm">
                    <form  class="boxdanhgia"action="" method="post">
                        <textarea placeholder="Nội dung đánh giá" rows="5"></textarea>
                        <button>Đánh giá</button>            
                    </form>
                </div>              
            </div>
        </div>
    </div>
        </div>
    <!-- Hết Đánh giá -->
    <!-- footer -->
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
    <script src="./Javscrips/action.js"></script>
</body>
</html>