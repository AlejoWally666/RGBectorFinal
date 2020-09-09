function alertDeleteUsuario(id) {
	
	Swal.fire({
		  title: '¿Deseas eliminar el usuario?',
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#d33',
		  cancelButtonColor: '#939393',
		  confirmButtonText: 'Sí, eliminar',
		  cancelButtonText: 'No, cancelar'
		}).then((result) => {
		  if (result.value) {
		    deleteUsuario(id);
		  }
		})
}

function deleteUsuario(id) {
	$.ajax({
		url : "/usuario/delete/" + id,
		method : 'GET',
		success : function(response){
			Swal.fire(
		      'Usuario eliminado',
		      'Usuario eliminado correctamente.',
		      'success'
		    ).then((result) => {
		    	location.reload();
			})		
		},
		error : function(err){
			Swal.fire(
		      'Ha ocurrido un error',
		      'No se ha podido eliminar el usuario, intente nuevamente.',
		      'warning'
		    )
			console.error(err);
		}		
	});
}