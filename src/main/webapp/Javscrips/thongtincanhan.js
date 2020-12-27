document.addEventListener("DOMContentLoaded",function(){
  var ndung=document.getElementsByClassName('dehienthi');
nutso2=document.getElementsByClassName('tat');
for(var i=0;i<nutso2.length;i++){
nutso2[i].onclick=function(){
 for(var k=0;k<ndung.length;k++)
   ndung[k].classList.toggle('ra');
}
}
},false)