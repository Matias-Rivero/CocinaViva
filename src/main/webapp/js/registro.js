function validarForm(nombre,apellido,email,password,repassword,alias)
  {
   nombre=document.getElementById(nombre);
   apellido=document.getElementById(apellido);
   email=document.getElementById(email);
   password=document.getElementById(password);
   repassword=document.getElementById(repassword);
   alias=document.getElementById(alias);
	   
   if(nombre.value=="")
    {
     nombre.focus();
     document.getElementById("errornombre").innerHTML = "*El campo Nombre esta vacio";
     nombre.style.borderColor="red";
     return false;
    }
   if(/^([a-z\xc0-\xff]+)$/i.test(nombre.value) == false || noespacios(nombre.value) == false)
   {
	 nombre.focus();
	 document.getElementById("errornombre").innerHTML = "*Solo texto porfavor";
	 nombre.style.borderColor="red";
	 return false;
   }
   if(nombre.value.length <= 2)
   {
    nombre.focus();
    document.getElementById("errornombre").innerHTML = "*Ingrese un nombre de 3 caracteres minimo";
    nombre.style.borderColor="red";
    return false;
   }
   
   if(apellido.value=="")
   {
	apellido.focus();
    document.getElementById("errorapellido").innerHTML = "*El campo Apellido esta vacio";
    apellido.style.borderColor="red";
    return false;
   }
   if(/^([a-z\xc0-\xff]+)$/i.test(apellido.value) == false || noespacios(apellido.value) == false)
   {
	 apellido.focus();
	 document.getElementById("errorapellido").innerHTML = "*Solo texto porfavor";
	 apellido.style.borderColor="red";
	 return false;
   }
   if(apellido.value.length <= 2)
   {
	apellido.focus();
    document.getElementById("errorapellido").innerHTML = "*Ingrese un apellido de 3 caracteres minimo";
    apellido.style.borderColor="red";
    return false;
   }
   
   if(email.value=="")
   {
	email.focus();
    document.getElementById("erroremail").innerHTML = "*El campo Email esta vacio";
    email.style.borderColor="red";
    return false;
   }
   if (validarEmail(email.value) == false) {	      
	   email.focus();
	   document.getElementById("erroremail").innerHTML = "*El campo Email no es valido";
	   email.style.borderColor="red";
	   return false;
   }  
   
   if(password.value=="")
   {
	password.focus();
    document.getElementById("errorpassword").innerHTML = "*El campo esta vacio";
    password.style.borderColor="red";
    return false;
   }
   if(noespacios(password.value) == false)
   {
	 password.focus();
	 document.getElementById("errorpassword").innerHTML = "*No se permiten espacios en blanco";
	 password.style.borderColor="red";
	 return false;
   }
   if(password.value.length <= 7)
   {
	password.focus();
    document.getElementById("errorpassword").innerHTML = "*Minimo 8 caracteres";
    password.style.borderColor="red";
    return false;
   }
   
   
   if(repassword.value=="")
   {
	repassword.focus();
    document.getElementById("errorrepassword").innerHTML = "*El campo esta vacio";
    repassword.style.borderColor="red";
    return false;
   }
   if(noespacios(repassword.value) == false)
   {
	 repassword.focus();
	 document.getElementById("errorrepassword").innerHTML = "*No se permiten espacios en blanco";
	 repassword.style.borderColor="red";
	 return false;
   }
   if(repassword.value.length <= 7)
   {
	repassword.focus();
    document.getElementById("errorrepassword").innerHTML = "*Minimo 8 caracteres";
    repassword.style.borderColor="red";
    return false;
   }
  
   
   if (password.value != repassword.value) {
    repassword.focus();
	document.getElementById("errorrepassword").innerHTML = "*Las password deben ser iguales";
	repassword.style.borderColor="red";
	return false;
   }
   
   
   if(alias.value=="")
   {
	alias.focus();
    document.getElementById("erroralias").innerHTML = "*El campo Alias esta vacio";
    alias.style.borderColor="red";
    return false;
   }
   if(noespacios(alias.value) == false)
   {
	 alias.focus();
	 document.getElementById("erroralias").innerHTML = "*No se permiten espacios en blanco";
	 alias.style.borderColor="red";
	 return false;
   }
   if(alias.value.length <= 2)
   {
	alias.focus();
    document.getElementById("erroralias").innerHTML = "*Ingrese un alias de 3 caracteres minimo";
    alias.style.borderColor="red";
    return false;
   }
   
   document.formregistro.submit();
  }

function validarEmail( email ) {
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if ( !expr.test(email) )
    	{
    	return false;
    	}
    else{
    	return true;
    }
}

function noespacios(evaluar) {
	var er = new RegExp(/\s/);
	if(er.test(evaluar)){
		return false;
	}else{
		return true;
	}
}

window.onload = (function(){
	try{
	    $("#nombre").on('keyup', function(){
	        document.getElementById("errornombre").innerHTML = '';
	        nombre.style.borderColor="#5b4e3f";
	    }).keyup();
	    $("#apellido").on('keyup', function(){
	        document.getElementById("errorapellido").innerHTML = '';
	        apellido.style.borderColor="#5b4e3f";
	    }).keyup();
	    $("#email").on('keyup', function(){
	        document.getElementById("erroremail").innerHTML = '';
	        email.style.borderColor="#5b4e3f";
	    }).keyup();
	    $("#password").on('keyup', function(){
	        document.getElementById("errorpassword").innerHTML = '';
	        password.style.borderColor="#5b4e3f";
	    }).keyup();
	    $("#repassword").on('keyup', function(){
	        document.getElementById("errorrepassword").innerHTML = '';
	        repassword.style.borderColor="#5b4e3f";
	    }).keyup();
	    $("#alias").on('keyup', function(){
	        document.getElementById("erroralias").innerHTML = '';
	        alias.style.borderColor="#5b4e3f";
	    }).keyup();
	}catch(e){}});