angular.module("timeControl").controller("timeControlController", function($scope){
	$('header').removeClass('header-page');

	$('.menu-topo').removeClass('esconde');
	$('.logo').removeClass('usuario');
	
	$(document).ready(function(){
		$('#mensagemUsuario').removeClass('in');
	});
});
