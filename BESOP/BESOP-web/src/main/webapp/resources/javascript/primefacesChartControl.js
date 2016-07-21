/**
 * 
 * Author: David Israel Garcia Alcazar
 * Este archivo JS contiene funciones para manipular el comportamiento de las graficas de primefaces (jqPlot).
 * 
 */

/**
* Este bloque permite que la grafica sea re-rendereada
* al hacer un resize de la pagina. Para permitir su funcionalidad
* es necesario que se agregue un extender a la grafica
* y que en dicho extender se agregue el objeto de la grafica
* a la lista arrayBarChart.
*/
var arrayBarChart = [];

window.addEventListener("resize", redrawCharts);
			
function redrawCharts(){
	for(var chartIndex in arrayBarChart){
		arrayBarChart[chartIndex].plot.replot( {
			redraw: true
		});
	}
}
/*Fin de bloque de control de auto-resizing de graficas*/