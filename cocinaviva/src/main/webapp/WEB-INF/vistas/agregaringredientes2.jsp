<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Cocina Viva &mdash;</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="" />
<meta name="keywords"
	content="" />
<meta name="author" content="" />

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<link href="https://fonts.googleapis.com/css?family=Fira+Sans" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lobster+Two" rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Bootstrap DateTimePicker -->
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>


<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<style type="text/css">
.gtco-cover.gtco-cover-sm {
	height: 80px;
}
</style>



</head>
<body>

	<div class="gtco-loader"></div>

	<div id="page">


		<!-- <div class="page-inner"> -->
		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="gtco-logo">
							<img src="images/logo.png" width="150px" />
						</div>
					</div>

					<c:choose>
						<c:when test="${usuariologueado != null}">
							<div class="col-xs-8 text-right menu-1">
								<ul>
									<li class="btn-cta"><a href="home"><span>Buscar
												Recetas</span></a></li>
									<li class="btn-cta"><a href="perfilcliente"><span>Mi
												perfil: ${usuariologueado.alias}</span></a></li>
									<li class="btn-cta"><a href="cerrarSesion"><span>Salir</span></a></li>
								</ul>
							</div>
						</c:when>
					</c:choose>
				</div>

			</div>
		</nav>


		<header id="gtco-header" class="gtco-cover gtco-cover-sm"> </header>



		<div class="overlay"></div>
		<div class="gtco-section">
		<div class="gtco-container">
					<c:choose>
						<c:when test="${not empty tieneingredienteselusuario}">
								<div class="py-5 text-center">				
									<h1>¿Ingredientes para agregar?  <c:if test="${not empty paso}"><span class="lead5">${paso}</span></c:if></h1>
								</div>
						</c:when>
						<c:otherwise>
								<div class="py-5 text-center">				
									<h1>Oops!...</h1><h2>¿No tienes ingredientes en tu heladera?</h2>
								</div>
						</c:otherwise>
					</c:choose>
		</div>
		</div>
			<div class="row">
				<div class="col-md-12 order-md-12 mb-12">
				
					<c:choose>
						<c:when test="${not empty ingrediente.listaIngredientes}">
							<ul class="list-group mb-3">
								<form:form method="POST" modelAttribute="ingrediente"
									action="altaIngredientes">

									<li
										class="list-group-item d-flex justify-content-between lh-condensed">

										<div class="table-responsive">
											<h3 class="my-0">Para Agregar</h3>
<!-- 											<a href="ingredientes#agringre" class="btn btn-link">Volver a seleccionar ingredientes</a> -->
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="lead">Nombre</span></th>
														<th><span class="lead">Fecha de :</span></th>
														<th><span class="lead">Cantidad</span></th>
													</tr>
												</thead>
												<tbody>

													<c:forEach items="${ingrediente.listaIngredientes}" var="i"
														varStatus="status">
														<tr align="left">
															<th><span class="lead">${i.nombre}</span></th>
														
															<c:if test = "${i.perece == 'SEVENCE'}">															
																<th>
																<label><strong>Vencimiento</strong></label>
																<form:input class="form-control datetimepicker1" autocomplete="off"
																	path="listaIngredientes[${status.index}].fvencimiento"
																	type="text" />
																</th>
															</c:if>
															<c:if test = "${i.perece == 'SEPUDRE'}">															
																<th>
																<label><strong>Compra</strong></label>
																<form:input class="form-control datetimepicker1" autocomplete="off"
																	path="listaIngredientes[${status.index}].fcompra"
																	type="text" />
																</th>
															</c:if>
																
															<c:if test = "${i.unidad == 'Lts'}">																
															<th><label><strong>Litros</strong></label>												
																<form:select class="form-control"
																	path="listaIngredientes[${status.index}].cantidad">
																	<c:forEach var="cantidad" begin="1" end="10">
																		<form:option value="${cantidad}">${cantidad}</form:option>
																	</c:forEach>
																</form:select>																
															</th>
															</c:if>
															<c:if test = "${i.unidad == 'Unids'}">																
															<th><label><strong>Unidades</strong></label>												
																<form:select class="form-control"
																	path="listaIngredientes[${status.index}].cantidad">
																	<c:forEach var="cantidad" begin="1" end="24">
																		<form:option value="${cantidad}">${cantidad}</form:option>
																	</c:forEach>
																</form:select>																
															</th>
															</c:if> 
															<c:if test = "${i.unidad == 'Grs'}">																
															<th><label><strong>Gramos</strong></label>												
																<form:select class="form-control" path="listaIngredientes[${status.index}].cantidad">
																<c:forEach items="${listagramos}" var="g" varStatus="estado">
																		<form:option value="${(estado.index + 1)* 50}">${g}</form:option>
																</c:forEach>
																</form:select>														
															</th>
															</c:if>    
															<label class="oculto"><form:input
																	path="listaIngredientes[${status.index}].unidad"
																	type="text" /></label>
															<label class="oculto"><form:input
																	path="listaIngredientes[${status.index}].perece"
																	type="text" /></label>		
															<label class="oculto"><form:input
																	path="listaIngredientes[${status.index}].nombre"
																	type="text" /></label>
															<label class="oculto"><form:input
																	path="listaIngredientes[${status.index}].estado"
																	type="text" /></label>
															<label class="oculto"><form:input
																	path="listaIngredientes[${status.index}].tipo"
																	type="text" /></label> 
<!-- 																	style="display: none" -->
														</tr>
													</c:forEach>
												</tbody>

											</table>
											<button type="button" onclick="validaEnviaAltaIngre();" class="btn btn-primary btn-md btn-block">Agregar</button>
											<button type="button" onclick="validaEnviaAltaIngre();" class="btn btn-primary btn-md btn-block">Volver</button>	
											<div style="visibility: hidden;">
												<button id="agregaringre" class="btn btn-primary" type="submit">agregaringre</button>
											</div>	
										</div>
										
									</li>

								</form:form>
								<!-- 											<div style="visibility: hidden;"> -->

								<!-- 											</div> -->
								<%-- 										</form:form> --%>
							</ul>
							
							<h4 class="d-flex justify-content-between align-items-center mb-3">
					</h4>
					<ul class="list-group mb-3">
						<c:choose>
							<c:when test="${not empty tieneingredienteselusuario}">
								<li
									class="list-group-item d-flex justify-content-between lh-condensed">

									<div class="table-responsive">
										<h3 class="my-0">Tus ingredientes</h3>
										<a href="modificar" class="btn btn-link">Modificar</a>
										<table class="table table-hover">
											<thead>
												<tr>
													<th><span class="lead">Nombre</span></th>													
													<th><span class="lead">Fecha de:</span></th>
													<th><span class="lead">Cantidad</span></th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${tieneingredienteselusuario}"
													var="tieneingredienteselusuario">
													<tr align="left">
														<th><span class="lead">${tieneingredienteselusuario.nombre}</span></th>														
														<th>														
														<span class="lead">${tieneingredienteselusuario.fvencimiento}</span>
														<c:if test = "${(tieneingredienteselusuario.tipo == 'LACTEOS') || (tieneingredienteselusuario.tipo == 'CONDIMENTOS')}">																
														<label><strong>Vencimiento</strong></label>	
														</c:if>
														<c:if test = "${(tieneingredienteselusuario.tipo == 'VEGETALES') || (tieneingredienteselusuario.tipo == 'CARNES') || (i.tipo == 'PESCADO')}">
														<label><strong>Compra</strong></label>
														</c:if>													
														</th>
														<th>
														<span class="lead">${tieneingredienteselusuario.cantidad}</span>
														<c:if test = "${tieneingredienteselusuario.unidad == 'Lts'}">
														<label><strong>Litros</strong></label>
														</c:if>
														<c:if test = "${tieneingredienteselusuario.unidad == 'Grs'}">
														<label><strong>Gramos</strong></label>
														</c:if>
														<c:if test = "${tieneingredienteselusuario.unidad == 'Unids'}">
														<label><strong>Unidades</strong></label>
														</c:if>
														</th>											
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</li>
							</c:when>
						</c:choose>
					</ul>
					<%-- 										<form:form method="POST" modelAttribute="checkingredientes" --%>
					<%-- 											action="recetas"> --%>
							</div>
						</div>
							
						
						
						</c:when>
						<c:otherwise>									
				
			
			

			<div class="row">
			
							<div class="col-xs-6 col-sm-6 col-md-2 col-lg-2" id="agringre">
				<!-- Oops!. ¿No tienes ingredientes en tu heladera? -->
<!-- 				<h4 class="d-flex justify-content-between align-items-center mb-3"> -->
<!-- 					<span class="text-muted">Agregar Ingrediente</span> -->
<!-- 				</h4> -->
				<ul class="list-group mb-3">
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div class="input-group">
							<form name="buscar" action="javascript:;" onsubmit="buscarIngrediente(this)" method="get"><input type="text"
								id="filtrar" class="form-control"
								placeholder="tomate" autocomplete="off"></form>
						</div>
					</li>
				</ul>
			
				
				<form:form method="POST" name="f1" id="f1" modelAttribute="checkingredientes"
					action="agregarIngredientes">
					
						<c:choose>
							<c:when test="${not empty iflacteos}">
			
								<div id="lacteos">

									<table class="table table-hover">
										<thead>
											<tr>																															
												<th><img class="d-block mx-auto mb-4" src="images/lacteos.png" id="blacteos" alt="Lacteos" width="40" height="40"/></th>
											</tr>
										</thead>
										<tbody class="buscar" id="tlacteos" style="display:none">

											<c:forEach items="${iflacteos}" var="iflacteos">
												<tr align="left">
<th><span class="lead"> <form:checkbox path="seleccionados" class="${iflacteos.nombre}" id="${iflacteos.id}" value="${iflacteos.id}" name="valores[]" onclick="armarListaLacteos(${iflacteos.id}, '${iflacteos.nombre}')" /> ${iflacteos.nombre}
													</span></th>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>

							</c:when>
						</c:choose>
					
					
						
							<c:if test="${not empty ifvegetales}">

								<div id="vegetales">

									<table class="table table-hover">
										<thead>
											<tr>																															
												<th><img class="d-block mx-auto mb-4" src="images/vegetales.png" id="bvegetales" alt="Vegetales" width="40" height="40"/></th>
											</tr>
										</thead>
										<tbody class="buscar" id="tvegetales" style="display:none">

											<c:forEach items="${ifvegetales}" var="ifvegetales">
												<tr align="left">
<th><span class="lead"> <form:checkbox path="seleccionados" class="${ifvegetales.nombre}" id="${ifvegetales.id}" value="${ifvegetales.id}" name="valores[]" onclick="armarListaVegetales(${ifvegetales.id}, '${ifvegetales.nombre}')" /> ${ifvegetales.nombre}
													</span></th>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>

							</c:if>
						
					
					
						
							<c:if test="${not empty ifcarnes}">
							
								<div id="carnes">

									<table class="table table-hover">
										<thead>
											<tr>																															
												<th><img class="d-block mx-auto mb-4" src="images/carnes.png" id="bcarnes" alt="Carnes" width="40" height="40"/></th>
											</tr>
										</thead>
										<tbody class="buscar" id="tcarnes" style="display:none">

											<c:forEach items="${ifcarnes}" var="ifcarnes">
												<tr align="left">
													<th><span class="lead"> <form:checkbox
																path="seleccionados" class="${ifcarnes.nombre}" id="${ifcarnes.id}"
																value="${ifcarnes.id}" name="valores[]"
																onclick="armarListaCarnes(${ifcarnes.id}, '${ifcarnes.nombre}')" /> ${ifcarnes.nombre}
													</span></th>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>

							</c:if>
						
					
					
						
							<c:if test="${not empty ifpescado}">

								<div id="pescado">

									<table class="table table-hover">
										<thead>
											<tr>																															
												<th><img class="d-block mx-auto mb-4" src="images/pescado.png" id="bpescado" alt="Pescado" width="40" height="40"/></th>
											</tr>
										</thead>
										<tbody class="buscar" id="tpescado" style="display:none">

											<c:forEach items="${ifpescado}" var="ifpescado">
												<tr align="left">
													<th><span class="lead"> <form:checkbox
																path="seleccionados" class="${ifpescado.nombre}" id="${ifpescado.id}"
																value="${ifpescado.id}" name="valores[]"
																onclick="armarListaPescado(${ifpescado.id}, '${ifpescado.nombre}')" /> ${ifpescado.nombre}
													</span></th>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>

							</c:if>
						
					
					
						
							<c:if test="${not empty ifcondimento}">

								<div id="condimento">

									<table class="table table-hover">
										<thead>
											<tr>																															
												<th><img class="d-block mx-auto mb-4" src="images/condimento.png" id="bcondimento" alt="Condimento" width="40" height="40"/></th>
											</tr>
										</thead>
										<tbody class="buscar" id="tcondimento" style="display:none">

											<c:forEach items="${ifcondimento}" var="ifcondimento">
												<tr align="left">
													<th><span class="lead"> <form:checkbox
																path="seleccionados" class="${ifcondimento.nombre}" id="${ifcondimento.id}"
																value="${ifcondimento.id}" name="valores[]"
																onclick="armarListaCondimento(${ifcondimento.id}, '${ifcondimento.nombre}')" /> ${ifcondimento.nombre}
													</span></th>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>

							</c:if>
						

						<div style="visibility: hidden;">
							<button id="agregaringre" class="btn btn-primary" type="submit">agregaringre</button>
						</div>
					
				</form:form>
				
			</div>
			
				<div class="col-xs-6 col-sm-6 col-md-10 col-lg-10">
				
					
					
				<div class="jumbotron">
				  <div class="container">
				  <div class="row">
			
				<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
				    <table class="table">
									<thead>
										<tr>
											<th><span class="lead3"><strong>Lacteos</strong></span></th>
										</tr>
									</thead>
									<tbody id="madlacteos">
											
												
											
											
									</tbody>
					</table>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
				    <table class="table">
									<thead>
										<tr>
											<th><span class="lead3"><strong>Vegetales</strong></span></th>
										</tr>
									</thead>
									<tbody id="madvegetales">
											
												
											
											
									</tbody>
					</table>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
				    <table class="table">
									<thead>
										<tr>
											<th><span class="lead3"><strong>Carnes</strong></span></th>
										</tr>
									</thead>
									<tbody id="madcarnes">
											
												
											
											
									</tbody>
					</table>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
				    <table class="table">
									<thead>
										<tr>
											<th><span class="lead3"><strong>Pescado</strong></span></th>
										</tr>
									</thead>
									<tbody id="madpescado">
											
												
											
											
									</tbody>
					</table>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
				    <table class="table">
									<thead>
										<tr>
											<th><span class="lead3"><strong>Condimento</strong></span></th>
										</tr>
									</thead>
									<tbody id="madcondimento">
											
												
											
											
									</tbody>
					</table>
				</div>				   				    
				    </div>
				  </div>
				  
				</div>
					<button type="button" onclick="validaEnvia();" class="btn btn-success btn-lg btn-block">Agregar</button>
				
				</div>
				
				
				
			</div>	
				<div class="row">	
				

			
	</div>
		<!-- </div> -->
			</c:otherwise>
					</c:choose>
		





		
		
	</div>
	<div id="almenosuno" class="modal fade" tabindex="-1" role="dialog" style="overflow-y: scroll;">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-header">
	      	<div class="alert alert-danger" role="alert">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>        
			  <h3>¡Agrega al menos 1 ingrediente!</h3>
			</div>
	      </div>  
	    </div>
	  </div>
	</div>
	<div id="datetimepickervacio" class="modal fade" tabindex="-1" role="dialog" style="overflow-y: scroll;">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-header">
	      	<div class="alert alert-danger" role="alert">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>        
			  <h3>¡La fecha es necesaria!</h3>
			</div>
	      </div>  
	    </div>
	  </div>
	</div>
	
	<footer id="gtco-footer" role="contentinfo" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row row-pb-md">




					<div class="col-md-12 text-center">
						<div class="gtco-widget">
							<h3>Cocina Viva</h3>
							<ul class="gtco-quick-contact">
								<li><a href="#"><i class="icon-phone"></i> +54 11 6234
										3596</a></li>
								<li><a href="#"><i class="icon-mail2"></i>
										info@cocinaviva.com.ar</a></li>
							</ul>
						</div>
						<div class="gtco-widget">
							<h3>Redes Sociales</h3>
							<ul class="gtco-social-icons">
								<li><a href="#"><i class="icon-twitter"></i></a></li>
								<li><a href="#"><i class="icon-facebook"></i></a></li>
								<li><a href="#"><i class="icon-linkedin"></i></a></li>
								<li><a href="#"><i class="icon-dribbble"></i></a></li>
							</ul>
						</div>
					</div>

					<div class="col-md-12 text-center copyright">
						<p>
							<small class="block">&copy; 2018 COCINA VIVA SA. TODOS
								LOS DERECHOS RESERVADOS.</small> <small class="block">Taller
								Practico Integrador</small>
						</p>
					</div>

				</div>



			</div>
		</footer>
	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>

	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>

	<script src="js/moment.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>


	<!-- Main -->
	<script src="js/main.js"></script>
	
	<script type="text/javascript">
		window.onload=function() {
// 			if(typeof (document.getElementsByName("f1") ) !== "undefined"){
		if($("#f1").length != 0) {
			for (i=0;i<document.f1.elements.length;i++) {  		
		          if(document.f1.elements[i].type == "checkbox") {
				               if(document.f1.elements[i].checked == 1) {  
				            	   document.f1.elements[i].checked = false;
				            	   document.f1.elements[i].click();
				                  
				                  }
				         
		                  }
		            } 
				}
			}
	</script>
	<script type="text/javascript">
	function validaEnviaAltaIngre() {
	var clases = document.getElementsByClassName("datetimepicker1");	
	var no = "si";
	for (x = 0; x < clases.length; x++)
		      {
		        if(clases[x].value == ''){
		        $('#datetimepickervacio').modal('show');
// 		        clases[x].focus();   	
				no = "no";
		        }
		      }
		        if(no == "si") { 
			        var capa = document.getElementById("agregaringre");
					capa.click(); 
			        }         

		      		
	}		
</script>	
	<script type="text/javascript">
	function validaEnvia() {
		
		 var no = "no";
		  for (i=0;i<document.f1.elements.length;i++) {  		
		          if(document.f1.elements[i].type == "checkbox") {
				               if(document.f1.elements[i].checked == 1) {  
				                  document.getElementById("agregaringre").click();
				                  no = "si";
				                  
				                  }
				         
		                  }
		            }      
		        if(no == "no") { 
		          $('#almenosuno').modal('show');
		          $( "#filtrar" ).focus();   
		        }          
        
    
	}
	</script>
	

<script type="text/javascript">
		function buscarIngrediente() {
			var ingrediente = document.getElementById("filtrar").value;
			var clases = document.getElementsByClassName(ingrediente);
					
			for (x = 0; x < clases.length; x++)
		      {
		        if(clases[x].className == ingrediente){
		          clases[x].click();
		          document.getElementById("filtrar").value = '';
//		          clases[x].focus();
 		          $( "#filtrar" ).focus();
		        } 

		      }		
			if(document.getElementById("filtrar").value != ''){
	        	$( "#tlacteos" ).show();
	            $( "#tvegetales" ).show();
	            $( "#tcarnes" ).show();
	            $( "#tpescado" ).show();
	            $( "#tcondimento" ).show();
	        }else{	
			  $( "#tlacteos" ).hide();
	          $( "#tvegetales" ).hide();
	          $( "#tcarnes" ).hide();
	          $( "#tpescado" ).hide();
	          $( "#tcondimento" ).hide();
	        }
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			(function($) {
				$('#filtrar').keyup(function() {
					var rex = new RegExp($(this).val(), 'i');
 					$('.buscar tr').hide();
					$('.buscar tr').filter(function() {
						return rex.test($(this).text());
					}).show();
				})
			}(jQuery));
		});
	</script>
	
<!-- <script> -->
// $("#filtrar").keyup(
//       function() {
//     	  $( "#tlacteos" ).show();
//           $( "#tvegetales" ).show();
//           $( "#tcarnes" ).show();
//           $( "#tpescado" ).show();
//           $( "#tcondimento" ).show();
//       });
<!-- </script> -->
	
	<script type="text/javascript">
	$(document).ready(function(){ 
		   $('#blacteos').on('click',function(){
		      $('#tlacteos').toggle('slow');
		   	   });
	});
	</script>
	<script type="text/javascript">
	$(document).ready(function(){ 	   
		   $('#bvegetales').on('click',function(){
			      $('#tvegetales').toggle('slow');
			   });
	});
	</script>
	<script type="text/javascript">
	$(document).ready(function(){ 		   
		   $('#bcarnes').on('click',function(){
			      $('#tcarnes').toggle('slow');
			   });
	});
	</script>
	<script type="text/javascript">
	$(document).ready(function(){ 		   
		   $('#bpescado').on('click',function(){
			      $('#tpescado').toggle('slow');
			   });
	});
	</script>
	<script type="text/javascript">
	$(document).ready(function(){ 		   
		   $('#bcondimento').on('click',function(){
			      $('#tcondimento').toggle('slow');
			   });
		});
	</script>
		
	<script type="text/javascript">
	    function armarLista(iddelcheck, nombre) {
	    	var idcheck = iddelcheck;
	    	var nombr = nombre;
	        element = document.getElementById("smedio");
	        check = document.getElementById(iddelcheck);
	        if (check.checked) {
	    //    	var elementNodetr = document.createElement('th');
	        	var elementNodeth = document.createElement('tr');
	        	elementNodeth.setAttribute("align","left");
	        	var elementNode = document.createElement('span');
	        	elementNodeth.appendChild(elementNode);
	        	elementNode.setAttribute("id",iddelcheck+"n");
	        	elementNode.setAttribute("class","lead2");
	            var textNode = document.createTextNode(nombr);  
	            elementNode.appendChild(textNode);
	            element.appendChild(elementNodeth);
	      //      elementNode.appendChild(document.createElement("br"));
	        }
	        else {
	        	var checkno = document.getElementById(iddelcheck+"n"); 
	        	checkno.parentNode.removeChild(checkno); 
	        }
	    }
	</script>
	<script type="text/javascript">
	    function armarListaLacteos(iddelcheck, nombre) {
	    	var idcheck = iddelcheck;
	    	var nombr = nombre;
	        element = document.getElementById("madlacteos");
	        check = document.getElementById(iddelcheck);
	  //      $('#filtrar').val('');
	        if (check.checked) {
	    //    	var elementNodetr = document.createElement('th');
	        	var elementNodeth = document.createElement('tr');
	        	elementNodeth.setAttribute("align","left");
	        	var elementNode = document.createElement('span');
	        	elementNodeth.appendChild(elementNode);
	        	elementNode.setAttribute("id",iddelcheck+"n");
	        	elementNode.setAttribute("class","leadl");
	            var textNode = document.createTextNode(nombr);  
	            elementNode.appendChild(textNode);
	            element.appendChild(elementNodeth);
	      //      elementNode.appendChild(document.createElement("br"));
	        }
	        else {
	        	var checkno = document.getElementById(iddelcheck+"n"); 
	        	checkno.parentNode.removeChild(checkno); 
	        }
	    }
	</script>
	<script type="text/javascript">
	    function armarListaVegetales(iddelcheck, nombre) {
	    	var idcheck = iddelcheck;
	    	var nombr = nombre;
	        element = document.getElementById("madvegetales");
	        check = document.getElementById(iddelcheck);
	        if (check.checked) {
	    //    	var elementNodetr = document.createElement('th');
	        	var elementNodeth = document.createElement('tr');
	        	elementNodeth.setAttribute("align","left");
	        	var elementNode = document.createElement('span');
	        	elementNodeth.appendChild(elementNode);
	        	elementNode.setAttribute("id",iddelcheck+"n");
	        	elementNode.setAttribute("class","leadv");
	            var textNode = document.createTextNode(nombr);  
	            elementNode.appendChild(textNode);
	            element.appendChild(elementNodeth);
	      //      elementNode.appendChild(document.createElement("br"));
	        }
	        else {
	        	var checkno = document.getElementById(iddelcheck+"n"); 
	        	checkno.parentNode.removeChild(checkno); 
	        }
	    }
	</script>
	<script type="text/javascript">
	    function armarListaCarnes(iddelcheck, nombre) {
	    	var idcheck = iddelcheck;
	    	var nombr = nombre;
	        element = document.getElementById("madcarnes");
	        check = document.getElementById(iddelcheck);
	        if (check.checked) {
	    //    	var elementNodetr = document.createElement('th');
	        	var elementNodeth = document.createElement('tr');
	        	elementNodeth.setAttribute("align","left");
	        	var elementNode = document.createElement('span');
	        	elementNodeth.appendChild(elementNode);
	        	elementNode.setAttribute("id",iddelcheck+"n");
	        	elementNode.setAttribute("class","leadc");
	            var textNode = document.createTextNode(nombr);  
	            elementNode.appendChild(textNode);
	            element.appendChild(elementNodeth);
	      //      elementNode.appendChild(document.createElement("br"));
	        }
	        else {
	        	var checkno = document.getElementById(iddelcheck+"n"); 
	        	checkno.parentNode.removeChild(checkno); 
	        }
	    }
	</script>
	<script type="text/javascript">
	    function armarListaPescado(iddelcheck, nombre) {
	    	var idcheck = iddelcheck;
	    	var nombr = nombre;
	        element = document.getElementById("madpescado");
	        check = document.getElementById(iddelcheck);
	        if (check.checked) {
	    //    	var elementNodetr = document.createElement('th');
	        	var elementNodeth = document.createElement('tr');
	        	elementNodeth.setAttribute("align","left");
	        	var elementNode = document.createElement('span');
	        	elementNodeth.appendChild(elementNode);
	        	elementNode.setAttribute("id",iddelcheck+"n");
	        	elementNode.setAttribute("class","leadp");
	            var textNode = document.createTextNode(nombr);  
	            elementNode.appendChild(textNode);
	            element.appendChild(elementNodeth);
	      //      elementNode.appendChild(document.createElement("br"));
	        }
	        else {
	        	var checkno = document.getElementById(iddelcheck+"n"); 
	        	checkno.parentNode.removeChild(checkno); 
	        }
	    }
	</script>
	<script type="text/javascript">
	    function armarListaCondimento(iddelcheck, nombre) {
	    	var idcheck = iddelcheck;
	    	var nombr = nombre;
	        element = document.getElementById("madcondimento");
	        check = document.getElementById(iddelcheck);
	        if (check.checked) {
	    //    	var elementNodetr = document.createElement('th');
	        	var elementNodeth = document.createElement('tr');
	        	elementNodeth.setAttribute("align","left");
	        	var elementNode = document.createElement('span');
	        	elementNodeth.appendChild(elementNode);
	        	elementNode.setAttribute("id",iddelcheck+"n");
	        	elementNode.setAttribute("class","leadco");
	            var textNode = document.createTextNode(nombr);  
	            elementNode.appendChild(textNode);
	            element.appendChild(elementNodeth);
	      //      elementNode.appendChild(document.createElement("br"));
	        }
	        else {
	        	var checkno = document.getElementById(iddelcheck+"n"); 
	        	checkno.parentNode.removeChild(checkno); 
	        }
	    }
	</script>
	
   <script type="text/javascript">
            $(function () {
                $('.datetimepicker1').datetimepicker({
                	format: 'DD/MM/YYYY'               	
                });
            });
        </script>
</body>
</html>

