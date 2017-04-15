angular.module("timeControl").controller("homeController", function($scope){
  
  $("#calendar").fullCalendar({
			locale: "pt-br",
			defaultView: 'agendaWeek',
			showMinutes: true,
			showAllDay: false,
			header: {
				left: 'prev,next',
				center: 'title',
				right: 'agendaWeek,agendaDay'
			},
			defaultDate: new Date(),
			navLinks: true, 
			selectable: true,
			selectHelper: true,
			select: function(start, end) {
				$("#modal-nova-atividade").modal("show");

				// var title = prompt('Event Title:');
				// var eventData;
				// if (title) {
				// 	eventData = {
				// 		title: title,
				// 		start: start,
				// 		end: end
				// 	};
				// 	$('#calendar').fullCalendar('renderEvent', eventData, true); 
				// }
				// $('#calendar').fullCalendar('unselect');
			},
			editable: false,
			eventLimit: true,
			events: [
				{
					title: 'teste',
					start: '2017-03-12T09:00:00',
					end: '2017-03-12T10:00:00',
					color: '#34b04f'
				},
				{
					title: 'teste',
					start: '2017-03-12T10:00:00',
					end: '2017-03-12T10:31:00',
					color: '#f8e64a'
				},
				{
					title: 'teste',
					start: '2017-03-12T08:00:00',
					end: '2017-03-12T08:20:00',
					color: '#f44336'
				}
			]
		});

    $(".fc-time-grid-container").height("498px");

 });
