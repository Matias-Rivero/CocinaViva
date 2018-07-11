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
//   if(noespacios('nombre'))
//   {
//	 nombre.focus();
//	 document.getElementById("errornombre").innerHTML = "*El campo no puede tener espacios en blanco";
//	 nombre.style.borderColor="red";
//	 return false; 
//   }
   if(apellido.value=="")
   {
	apellido.focus();
    document.getElementById("errorapellido").innerHTML = "*El campo Apellido esta vacio";
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
   if(password.value=="")
   {
	password.focus();
    document.getElementById("errorpassword").innerHTML = "*El campo esta vacio";
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