
function onlyNumbers(evt){
	var keyPressed = (evt.which) ? evt.which : event.keyCode;
	if((keyPressed >= 48 && keyPressed <= 57)||(keyPressed == 8)){
		return true;
	}else{
		return false;
	}
}

function onlyDecimal(e, field) {
	key = e.keyCode ? e.keyCode : e.which;
	if (key == 8) 
		return true;
	if (key <= 13 || (key >= 48 && key <= 57) || key == 46) {
		if (field.value == "")
			return true;
		
		return !(regexp.test(field.value));
	}
	if (key == 44) {
		if (field.value == "") 
			return false;
		regexp = /^[0-9]+$/;
		return regexp.test(field.value);
	}
	return false;
}

function onlyAlfaNumeric(evt) {
	var key = (evt.which) ? evt.which : event.keyCode;
	if((key >= 48 && key <= 57) ||
			(key >= 65 && key <= 90) ||
			(key >= 97 && key <= 122) ||
			(key == 8) ||
			(key == 32)
			){
		return true;
	}else{
		return false;
	}
}

function trim(str) {
	if(str){
		
		if(str.value){
		
			strModificado = str.value; 
			
		} else {
			
			strModificado = str;								
		}
		
		strModificado = strModificado.trim();
		strModificado = strModificado.replace(/(^\s*)|(\s*$)/gi, "");   // removes leading and trailing spaces
		strModificado = strModificado.replace(/[ ]{2,}/gi," ");         // replaces multiple spaces with one space
		strModificado = strModificado.replace(/\n +/,"\n");             // Removes spaces after newlines		
		return strModificado;	
		
	} else {
		
		return "";
	}
}		

function limitTextArea(element, limit) { 
	if (element){
		if (element.value.length > limit) { 
			element.value = element.value.substring(0, limit); 
		} 		
	}
} 		

