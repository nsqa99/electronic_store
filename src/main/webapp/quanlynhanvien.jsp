<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ltweb.electronic_store.model.*" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>quản lý nhân viên</title>
    <link rel="stylesheet" href="./style/quanlynhanvien.css">
    <link rel="stylesheet" href="css/font-awesome.css">
</head>
<body>
        <div class="Qlnhanvien">
        <div class="tieude " style="text-align: center;">
                <h1>QUẢN LÝ NHÂN VIÊN</h1>
        </div>
        <p class="timkiemnhanvien"><b>TÌM KIẾM NHÂN VIÊN:</b></p>
        <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Nhập tên nhân viên cần tìm..."
                data-toggle="tooltip" data-placement="bottom" title="Tìm Kiếm Nhân Viên">
        <i class="fa fa-search" aria-hidden="true"></i>

        <form action="">

        </form>
        <b>CHỨC NĂNG CHÍNH:</b><Br>
        <button class="nv btn add-new" type="button" data-toggle="tooltip" data-placement="top"
                title="Thêm Nhân Viên"><i class="fa fa-user-plus"></i></button>
        <button class="nv" type="button" onclick="sortTable()" data-toggle="tooltip" data-placement="top"
                title="Lọc Dữ Liệu"><i class="fa fa-filter" aria-hidden="true"></i></button>
        <button class="nv xuat" data-toggle="tooltip" data-placement="top" title="Xuất File"><i
                class="fas fa-file-import"></i></button>
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
                        <th >Ngày Sinh</th>
                        <th >Địa Chỉ</th>
                        <th width="200px;">Chức Vụ</th>
                        <th width="200px; !important">Tính Năng</th>
                </tr>
                </thead>
                <tbody >
                
                                <% ArrayList<Admin> admins = (ArrayList<Admin>) request.getSession().getAttribute("admin");
                        		if (admins != null) {%>
                    			
            	        		<%if (admins.size() == 0) { %>
            	        		
            	        		<% }  else{%>
            	        		<% 
			        				for(Admin ad : admins) {
			        			%>
                                <tr>
                                        <td><%=ad.getFullName()%></td>
                                        <td><%=ad.getGender()%></td>
                                        <td><%=ad.getDob()%></td>
                                        <td><%=ad.getAddress()%></td>
                
                                        <td><%=ad.getRole()%></td>
                                        <td>
                                        <a class="add" title="Lưu Lại" data-toggle="tooltip"><i class="fa fa-save"
                                                aria-hidden="true"></i></a>
                                        <a class="edit" title="Sửa" data-toggle="tooltip"><i class="fa fa-pencil"
                                                aria-hidden="true"></i></a>
                                        <a class="delete" title="Xóa" data-toggle="tooltip"><i class="fa fa-trash-o"
                                                aria-hidden="true"></i></a>
                                        </td>
                                </tr>
                                <% } %>
                            <% } %>
	       				<% } %>
                               
                            
                
            </tbody>
        </table>
    </div>
    <script type="text/javascript">
        //Lọc Dữ Liệu
        function myFunction() {
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
        //Lọc Table
        function sortTable() {
            var table, rows, switching, i, x, y, shouldSwitch;
            table = document.getElementById("myTable");
            switching = true;
            while (switching) {
                switching = false;
                rows = table.rows;
                for (i = 1; i < (rows.length - 1); i++) {
                    shouldSwitch = false;
                    x = rows[i].getElementsByTagName("TD")[0];
                    y = rows[i + 1].getElementsByTagName("TD")[0];
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        shouldSwitch = true;
                        break;
                    }
                }
                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                    swal("Thành Công!", "Bạn Đã Lọc Thành Công", "success");
                }
            }
        }
           
</script>
</body>
</html>