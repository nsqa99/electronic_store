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
let checkDS = true;
let checkTK = true;
let checkThemSP = true;
let qlnv = true;
function Danhsach(id, id1, id2, id3){
    if(checkDS){
        document.getElementById(id1).style.display = 'none';
        document.getElementById(id2).style.display = 'none';
        document.getElementById(id3).style.display = 'none';
        checkTK = true;
        checkThemSP = true;
        qlnv = true;
        document.getElementById(id).style.display='block';
        // alert(id);
        checkDS = false;
        // alert(checkDS);
    }
    
    else{
        document.getElementById(id).style.display = 'none';
        checkDS = true;
        // alert(checkDS);
    }
};
function themSP(id, id1, id2, id3){
    if(checkThemSP){
        document.getElementById(id1).style.display = 'none';
        document.getElementById(id2).style.display = 'none';
        document.getElementById(id3).style.display = 'none';
        checkTK = true;
        checkDS = true;
        qlnv = true;
        document.getElementById(id).style.display='block';
        // alert(id);
        checkThemSP = false;
    }
    else{
        document.getElementById(id).style.display = 'none';
        checkThemSP = true;
    }
}
function thongke(id, id1, id2, id3){
    if(checkTK){
        document.getElementById(id1).style.display = 'none';
        document.getElementById(id2).style.display = 'none';
        document.getElementById(id3).style.display = 'none';
        checkDS = true;
        checkThemSP = true;
        qlnv = true;
        document.getElementById(id).style.display='block';
        // alert(id);
        checkTK = false;
    }
    else{
        document.getElementById(id).style.display = 'none';
        checkTK = true;
    }
}
function QLNV(id, id1, id2, id3){
    if(qlnv){
        document.getElementById(id1).style.display = 'none';
        document.getElementById(id2).style.display = 'none';
        document.getElementById(id3).style.display = 'none';
        checkTK = true;
        checkThemSP = true;
        checkDS = true;
        document.getElementById(id).style.display='block';
        // alert(id);
        qlnv = false;
    }
    else{
        document.getElementById(id).style.display = 'none';
        qlnv = true;
    }
}

