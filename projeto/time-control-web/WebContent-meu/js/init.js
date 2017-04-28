$(document).ready(function(){
  $(".icon-close").on("click",function(){
    $(".main-menu").removeClass("expanded");
     $("main").addClass("expanded");
  });

  $(".icon-open").on("click", function(){
    $(".main-menu").addClass("expanded");
     $("main").removeClass("expanded");
  });

    $('[data-toggle="tooltip"]').tooltip();
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
