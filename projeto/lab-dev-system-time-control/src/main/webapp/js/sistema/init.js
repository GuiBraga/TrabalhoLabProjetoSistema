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
});