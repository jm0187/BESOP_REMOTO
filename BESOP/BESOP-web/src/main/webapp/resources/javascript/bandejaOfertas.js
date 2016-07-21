/**
 * Archivo con codigo para validaciones del lado del cliente para bandeja de ofertas
 */

function requerirFechaFinal(){
	var fechaFinInput = document.getElementById('formularioFiltros:fechaFin_input');
	var fechaInicioInput = document.getElementById('formularioFiltros:fechaInicio_input');
	if(fechaInicioInput.value !== null){
		fechaFinInput.setAttribute('required','true');
		document.getElementById('formularioFiltros:labelFechaFin').innerHTML = '*Fecha final';
	} else {
		fechaFinInput.setAttribute('required','false');
		document.getElementById('formularioFiltros:labelFechaFin').innerHTML = 'Fecha final';
	}
}

function noRequerirFechaFinal(){
	var fechaFinInput = document.getElementById('formularioFiltros:fechaFin_input');
	var fechaInicioInput = document.getElementById('formularioFiltros:fechaInicio_input');
	if(fechaInicioInput.value === ''){
		fechaFinInput.setAttribute('required','false');
		document.getElementById('formularioFiltros:labelFechaFin').innerHTML = 'Fecha final';
	}
}