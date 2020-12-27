document.addEventListener("DOMContentLoaded",function(){
    var nutso1=document.getElementsByClassName('declick');
    var ndung=document.getElementsByClassName('dehienthi');
    for(var i=0;i<nutso1.length;i++){
      nutso1[i].onclick=function(){
         for(var k=0;k<nutso1.length;k++){
          nutso1[k].classList.remove('maudo');
         }
        this.classList.toggle('maudo');
        var ndhienra=this.getAttribute('data-hienlen');
        var phan_tu_hien_ra=document.getElementById(ndhienra);
        for(var k=0;k<ndung.length;k++){
          ndung[k].classList.remove('ra');
         }
        phan_tu_hien_ra.classList.toggle('ra');
      }
    }
    nutso2=document.getElementsByClassName('tat');
       for(var i=0;i<nutso2.length;i++){
      nutso2[i].onclick=function(){
        for(var k=0;k<ndung.length;k++)
          ndung[k].classList.remove('ra');
      }
    }
    var nut=document.querySelectorAll('.chuyenslide ul li');
    var slides=document.querySelectorAll('.cacslide ul li');
    for(var i=0;i<nut.length;i++){
      nut[i].addEventListener('click',function(){
        for(var i=0;i<nut.length;i++){
          nut[i].classList.remove('kichhoat');
        }
        this.classList.add('kichhoat');
        // console.log(this.previousElementSibling)
        var nutkh=this;
        var vt=0;
        for(vt=0;nutkh=nutkh.previousElementSibling;vt++){}
        for(var i=0;i< slides.length;i++){
        slides[i].classList.remove('active');
        slides[vt].classList.add('active');
        }
      })
    }
    // hàm tự động chuyển slide
    autoSlide();
    function autoSlide(){
    var thoigian=setInterval(function(){
      var vitrislide=0;
      var slideHienTai=document.querySelector('.cacslide ul li.active');
     
      for(vitrislide=0; slideHienTai =slideHienTai.previousElementSibling;vitrislide++){}
      if(vitrislide < (slides.length-1)){
      for( var i=0;i<slides.length;i++){
      slides[i].classList.remove('active');
      nut[i].classList.remove('kichhoat');
      }
      slides[vitrislide].nextElementSibling.classList.add('active');
      nut[vitrislide].nextElementSibling.classList.add('kichhoat');
      }
      else{
        for( var i=0;i<slides.length;i++){
          slides[i].classList.remove('active');
          nut[i].classList.remove('kichhoat');
          }
          slides[0].classList.add('active');
          nut[0].classList.add('kichhoat');
      }
           },3000);
        }
  },false)