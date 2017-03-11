$(document).ready(function(){
  $(window).scroll(function()
  {
  var topo = $('header').height(); // altura do topo
  var scrollTop = $(window).scrollTop(); // qto foi rolado a barra

  if(scrollTop > topo){
    $('header').addClass("menuScroll");
  }else{
    $('header').removeClass("menuScroll");
  }               
  });
});