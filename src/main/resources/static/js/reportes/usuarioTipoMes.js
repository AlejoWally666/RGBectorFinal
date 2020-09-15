$.getJSON('http://cityemark.com/rgbector/apis/repTipoUsuarioMes.php', function(data) {
        
	var color = Chart.helpers.color;
var jsonfile = data;

var labels = jsonfile.jsonarray.map(function(e) {
   return e.mes;
});
var data = jsonfile.jsonarray.map(function(e) {
   return e.cliente;
});
var data1 = jsonfile.jsonarray.map(function(e) {
   return e.diseniador;
});


var ctx = canvas.getContext('2d');
var config = {
   type: 'bar',
   options:{
			responsive: true,
			legend: {
				position: 'top',
			},
			title: {
				display: true,
				text: 'Usuarios por tipo usuario y agrupados por mes'
			},
			scales: {
		        yAxes: [{
		            ticks:{
						beginAtZero: true
					}
		        }]
		    }
		},
   data: {
      labels: labels,
      datasets: [{
         label: 'Cliente',
         data: data,
         backgroundColor: color(getRandomColor()).alpha(0.5).rgbString()
      },
	  {
         label: 'Dise\361ador',
         data: data1,
         backgroundColor: color(getRandomColor()).alpha(0.5).rgbString()
      }
	  ]
   }
};
function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
	}

var chart = new Chart(ctx, config);

    });