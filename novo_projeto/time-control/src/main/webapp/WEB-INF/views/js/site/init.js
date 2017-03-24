$(document).ready(function(){
  $(window).scroll(function()
  {
  var scrollTop = $(window).scrollTop(); // qto foi rolado a barra

  // USADO UM PARA SER BEM DINAMICO QO ROLA JA APARECER
  if(scrollTop > 1){
    $('header').addClass("menuScroll");
  }else{
    $('header').removeClass("menuScroll");
  }               
  });

  $('.menu-topo li').click(function(){
    $('.menu-topo li').removeClass('active');
    $(this).addClass('active');
  });

});