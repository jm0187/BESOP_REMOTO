$(document).ready(function () {
  
	var url = window.location.pathname;  
	var activePage = stripTrailingSlash(url);

	$('.nav li a').each(function(){  
		var currentPage = stripTrailingSlash($(this).attr('href'));
		if (activePage == currentPage) {
			$(this).parent().addClass('active'); 
		}
	});
	
	$('.dropdown a').each(function(){  
		var currentPage = stripTrailingSlash($(this).attr('href'));
		if (activePage == currentPage) {
			$(this).addClass('active'); 
		}
	});
	
	$('[data-toggle="offcanvas"]').click(function () {
    $('.row-offcanvas').toggleClass('active');
  });
});

$(document).ready(function(){
    $("#myNav").affix({
        offset: { 
            top: 30 
        }
    });
  //Check to see if the window is top if not then display button
	$(window).scroll(function(){
		if ($(this).scrollTop() > 100) {
			$('.scrollToTop').fadeIn();
		} else {
			$('.scrollToTop').fadeOut();
		}
	});
	
	//Click event to scroll to top
	$('.scrollToTop').click(function(){
		$('html, body').animate({scrollTop : 0},800);
		return false;
	});
});

function stripTrailingSlash(str) {
	if(str.substr(-1) == '/') {
		return str.substr(0, str.length - 1);
	}
	return str;
}

function handleRequest(xhr, status, args) {
    if(!args.validationFailed && args.exito) {
        var elem = getElementsByAttr('tabindex');
        for(var i = 0; i < elem.length; i++) {
            elem[i].value="";
        }
        PF('dlg').hide();
    }
}


function getElementsByAttr(attr) {
    var all = document.getElementsByTagName('*');
    var elements = [];
    for ( var i = 0; i < all.length; i++) {
        if (all[i].getAttribute(attr))
            elements.push(all[i]);
    }
    return elements;
}

    
////////////////////////////////////////////////////////////////
function showAceptMessage2(xhr, status, args) {
    if(!args.validationFailed && args.exito) {
        PF('avisoExitoLogOut').show();
    } else {
        PF('avisoExitoLogOut').hide();
    }
}

function confirmaRegistroMessage2(xhr, status, args) {
    if(!args.validationFailed && args.exito) {
    	PF('confirmaRegistro').show();
    } else {
    	PF('confirmaRegistro').hide();
    }
}

function timeoutMessage2(xhr, status, args) {
    if(!args.validationFailed && args.exito) {
        PF('timeout').show();
    } else {
        PF('timeout').hide();
    }
}

function genericMessage(xhr, status, args, obj) {
    if(!args.validationFailed && args.exito) {
    	obj.show();
    } else {
    	obj.hide();
    }
}

function navegate(xhr, status, args, obj) {
    if(!args.validationFailed && args.exito) {
        location = obj;
    }
}
function navegate2(xhr, status, args, obj) {
    if(!args.validationFailed && args.exito) {
        location = obj;
    }
}
////////////////////////////////////////////////////////////////////
function timeoutMessage(xhr, status, args) {
	genericMessage(xhr, status, args, PF('timeout'));
}
function showAceptMessage(xhr, status, args) {
	genericMessage(xhr, status, args, PF('avisoExitoLogOut'));
}

function confirmaRegistroMessage(xhr, status, args) {
	genericMessage(xhr, status, args, PF('confirmaRegistro'));
}

function redirect(xhr, status, args, url) {
    if(!args.validationFailed && args.exito) {
        location=url;
    }
}

function redirectConsulta(xhr, status, args, url) {
    if(!args.validationFailed && args.exito) {
    	statusDialog.show();
        location=url;
    }
}
function decide(args, status, obj) {  
    if(!args.validationFailed && args.exito) {    
        obj.hide();  
    }
}


 

 

 
 
 

















/*



 function handleEjemploNoUsado(xhr, status, args) {  
     alert(status); // pinta: success, fail, ...
     alert(xhr); // no se... pero creo que es el ajax http request
     if(args.validationFailed || !args.loggedIn) {  
         //jQuery('#loginScreenX').parent().effect("shake", { times:3 }, 100);  
     } else {  
         PF('loginScreen').hide();  
         //jQuery('#loginLink').fadeOut();  
     }  
 }
function showModal() {
     try {    
            otro = document.getElementById("modalLayer");
            otro.style.height= vsize()+"px";
            otro.style.width= hsize()+"px";
            otro.style.display = "block";
            
            img = document.getElementById("waitImage");
            img.style.top = middleVScreen()+"px";
            img.style.left = middleHScreen()+"px";
     } catch(e) {
         alert(e);
     }
     return false;
 }


function getInternetExplorerVersion()
// Returns the version of Windows Internet Explorer or a -1
// (indicating the use of another browser).
{
   var rv = -1; // Return value assumes failure.
   if (navigator.appName == 'Microsoft Internet Explorer')
   {
      var ua = navigator.userAgent;
      var re  = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
      if (re.exec(ua) != null)
         rv = parseFloat( RegExp.$1 );
   }
   return rv;
}
function checkIEVersion()
{
   var msg = "You're not using Windows Internet Explorer.";
   var ver = getInternetExplorerVersion();
   if ( ver> -1 )
   {
      if ( ver>= 8.0 )
         msg = "You're using Windows Internet Explorer 8.";
      else if ( ver == 7.0 )
          msg = "You're using Windows Internet Explorer 7.";
      else if ( ver == 6.0 )
          msg = "You're using Windows Internet Explorer 6.";
      else
          msg = "You should upgrade your copy of Windows Internet Explorer";
    }
   alert( msg );
}
 function hideModal() {
     try {    
            otro = document.getElementById("modalLayer");
            otro.style.display = "none";
     } catch(e) {
         alert(e);
     }
     return false;
 }
 function vsize() {
     return document.body.offsetHeight + 86;
 }
 
 function hsize() {
     return document.body.offsetWidth + 16;
 }
 
 function middleVScreen() {
     return (window.screen.height/2)-(50);
 }
 
 function middleHScreen() {
     return (window.screen.width/2)-(25);
 }
 


*/