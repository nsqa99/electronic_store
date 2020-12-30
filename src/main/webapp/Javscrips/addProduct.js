const formContent = document.querySelector('#formContent');


window.onload = renderLaptopForm();

function handleChange(value) {
    if (value === 'laptop') renderLaptopForm();
    else renderMobileForm();
}



function renderLaptopForm() {
    formContent.innerHTML = `
    <input type="text" name="anhSP" class="TextThemSP" placeholder="Anh san pham">
    <input type="text" name="tenSP" class="TextThemSP" placeholder="Nhap ten san pham">
    <input type="text" name="motaSP" class="TextThemSP" placeholder="Nhap mo ta san pham">
    <input type="text" name="giaSP" class="TextThemSP" placeholder="Nhap gia san pham">
    <input type="text" name="soluongSP" class="TextThemSP" placeholder="Nhap so luong san pham">
    <input type="text" name="manhinhSP" class="TextThemSP" placeholder="Nhap kich thuoc man hinh">
    <input type="text" name="hdhSP" class="TextThemSP" placeholder="Nhap HDH">
    <input type="text" name="cpuSP" class="TextThemSP" placeholder="Nhap CPU">
    <input type="text" name="ramSP" class="TextThemSP" placeholder="Nhap RAM">
    <input type="text" name="romSP" class="TextThemSP" placeholder="Nhap ROM">
    <input type="text" name="pinSP" class="TextThemSP" placeholder="Nhap Pin">
    <input type="text" name="baohanhSP" class="TextThemSP" placeholder="Nhap BaoHanh">
    
    <input type="text" name="cameraSP" class="TextThemSP" placeholder="Nhap Camera">
    <input type="text" name="vgaSP" class="TextThemSP" placeholder="Nhap VGA">
        <br>
        <input type="submit" id="btnThemSP1" value="Xong">
    `;
}

function renderMobileForm() {
    formContent.innerHTML = `
    <input type="text" name="anhSP" class="TextThemSP" placeholder="Anh san pham">
    <input type="text" name="tenSP" class="TextThemSP" placeholder="Nhap ten san pham">
    <input type="text" name="motaSP" class="TextThemSP" placeholder="Nhap mo ta san pham">
    <input type="text" name="giaSP" class="TextThemSP" placeholder="Nhap gia san pham">
    <input type="text" name="soluongSP" class="TextThemSP" placeholder="Nhap so luong san pham">
    <input type="text" name="manhinhSP" class="TextThemSP" placeholder="Nhap kich thuoc man hinh">
    <input type="text" name="manhinhSP" class="TextThemSP" placeholder="Nhap HDH">
    <input type="text" name="cpuSP" class="TextThemSP" placeholder="Nhap CPU">
    <input type="text" name="ramSP" class="TextThemSP" placeholder="Nhap RAM">
    <input type="text" name="romSP" class="TextThemSP" placeholder="Nhap ROM">
    <input type="text" name="pinSP" class="TextThemSP" placeholder="Nhap Pin">
    <input type="text" name="baohanhSP" class="TextThemSP" placeholder="Nhap BaoHanh">
    <input type="text" name="camtruocSP" class="TextThemSP" placeholder="Nhap Camera truoc">
    <input type="text" name="camsauSP" class="TextThemSP" placeholder="Nhap Camera sau">
    <br>
    <input type="submit" id="btnThemSP1" value="Xong">
   
    `;
}