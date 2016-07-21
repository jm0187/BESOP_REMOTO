function validarNumeroCaracteres(componente, total) { 
	if (componente) {
		if (componente.value.length > total) { 
			componente.value = componente.value.substring(0, total); 
		} 		
	}
} 


function convertirMayusculas(componente) { 
	if (componente) {
		componente.value = componente.value.toUpperCase(); 
	}
} 