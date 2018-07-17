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

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">

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

		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-1 col-xs-12">
						<div id="gtco-logo">
							<a href="home"><img src="images/logo.png" width="170px" height="60px" style="margin:-10px" /></a>
						</div>
					</div>

					<c:choose>
						<c:when test="${usuariologueado != null}">
							<div class="col-xs-11 text-right menu-1">
								<ul>								
									<li><a href="home"><span>Inventario</span></a></li>
									<li><a href="modificar"><span>Modificar ingredientes</span></a></li>
									<li class="has-dropdown">|<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-bell"></i></a>									<ul class="dropdown">
										<c:forEach items="${notificacionesUsu}" var="notificacion">
											<li>
												<c:choose>
													<c:when test="${notificacion.tipoNotificacion == 'SIN_STOCK'}">
														<a href="ingredientes"><span class="label label-primary">${notificacion.fechaNotificacion}</span> ${notificacion.mensaje} </a>
													</c:when>
													<c:otherwise>
														<a href="modificar"><span class="label label-primary">${notificacion.fechaNotificacion}</span> ${notificacion.mensaje} </a>
													</c:otherwise>
												</c:choose>
											</li>
											<li role="presentation" class="divider"></li>
										</c:forEach>
									</ul>
									</li>
									<li class="btn-cta has-dropdown"><a href="#" ><span><i class="glyphicon glyphicon-user"></i>
												&nbsp;${usuariologueado.alias}</span></a>
												<ul class="dropdown" style="display: none;">
													<li><a href="perfilcliente">Mi Perfil</a></li>
                									<li><a href="cerrarSesion">Cerrar Sesiòn</a></li>
   									             </ul></li>			
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
		<div class="gtco-container" id="altura2">

			<div class="row" id="agringre">
				<div class="col-md-12 order-md-12 mb-12">
					<ul class="list-group mb-3">
						<li	class="list-group-item d-flex justify-content-between lh-condensed" style="padding-top: 2%;padding-bottom: 0%;">

							<div class="py-5 text-center">
								<h4>Selecciona de nuestro Inventario.</h4>
							</div>

							<div class="input-group">
								<span class="input-group-addon"></span> <input
									type="text" id="filtrar" class="form-control" autocomplete="off"
									placeholder="pure de tomate">
							</div>
							<div class="row">
								<form:form method="POST" name="f1" id="f1" modelAttribute="checkingredientes"
										   action="agregarIngredientes">
									<label class="oculto"><form:input path="nombre" id="loquebusco" type="text" class="form-control" /></label>
									<c:choose>
										<c:when test="${not empty iflacteos}">

											<div id="lacteos">

												<table class="table table-fixed" >
														<%--<thead>
														<span>Inventario!</span>
															<tr>
																<th><input type="text" id="filtrar" class="form-control" value="" placeholder="tomate" autocomplete="off"></th>
															</tr>
														</thead>--%>
													<tbody class="buscar" id="tlacteos" style="display:none;height: 100px;margin-top: 2%;margin-left: 1px;">

													<c:forEach items="${iflacteos}" var="i">
														<tr align="left">
															<th><form:checkbox path="seleccionados" onclick="checkearIngrediente()" class="${i.nombre}" id="${i.id}" value="${i.id}" name="valores[]" />
																<span class="lead"><a href="javascript:checkIngrediente(${i.id});">${i.nombre}</a></span>
															</th>
														</tr>
													</c:forEach>
													<c:forEach items="${ifvegetales}" var="i">
														<tr align="left">
															<th><form:checkbox path="seleccionados" onclick="checkearIngrediente()" class="${i.nombre}" id="${i.id}" value="${i.id}" name="valores[]" />
																<span class="lead"><a href="javascript:checkIngrediente(${i.id});">${i.nombre}</a></span>
															</th>
														</tr>
													</c:forEach>
													<c:forEach items="${ifcarnes}" var="i">
														<tr align="left">
															<th><form:checkbox path="seleccionados" onclick="checkearIngrediente()" class="${i.nombre}" id="${i.id}" value="${i.id}" name="valores[]" />
																<span class="lead"><a href="javascript:checkIngrediente(${i.id});">${i.nombre}</a></span>
															</th>
														</tr>
													</c:forEach>
													<c:forEach items="${ifpescado}" var="i">
														<tr align="left">
															<th><form:checkbox path="seleccionados" onclick="checkearIngrediente()" class="${i.nombre}" id="${i.id}" value="${i.id}" name="valores[]" />
																<span class="lead"><a href="javascript:checkIngrediente(${i.id});">${i.nombre}</a></span>
															</th>
														</tr>
													</c:forEach>
													<c:forEach items="${ifcondimento}" var="i">
														<tr align="left">
															<th><form:checkbox path="seleccionados" onclick="checkearIngrediente()" class="${i.nombre}" id="${i.id}" value="${i.id}" name="valores[]" />
																<span class="lead"><a href="javascript:checkIngrediente(${i.id});">${i.nombre}</a></span>
															</th>
														</tr>
													</c:forEach>
													</tbody>
												</table>
											</div>

										</c:when>
									</c:choose>

									<div style="visibility: hidden;">
										<button id="agregaringre" type="submit"></button>
									</div>

								</form:form>
							</div>
						</ul>
					</div>
				</div>
						<div id="ingredientesACargar">
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

									<c:choose>
										<c:when test="${not empty ingrediente.listaIngredientes}">
										<ul class="list-group mb-3">
											<form:form method="POST" modelAttribute="ingrediente"
													   action="altaIngredientes">

												<li	class="list-group-item d-flex justify-content-between lh-condensed">

													<div class="table-responsive">
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
																					<form:option value="${cantidad * 1000}">${cantidad}</form:option>
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
																</tr>
															</c:forEach>
															</tbody>

														</table>
														<button type="button" onclick="validaEnviaAltaIngre();" class="btn btn-primary btn-lg btn-block">Agregar</button>
														<div style="visibility: hidden;">
															<button id="altaingre" class="btn btn-primary" type="submit">agregaringre</button>
														</div>
													</div>

												</li>

												</form:form>

											</ul>
										</c:when>
										<c:otherwise>
											<li class="list-group-item d-flex justify-content-between lh-condensed">
												<div class="table-responsive">
													<table class="table table-hover">
														<thead>
														<tr>
															<th><span class="lead">Nombre</span></th>
															<th><span class="lead">Fecha de :</span></th>
															<th><span class="lead">Cantidad</span></th>
														</tr>
														</thead>
													</table>
													<button type="button" class="btn btn-danger btn-lg btn-block" >Seleccione un ingrediente para comenzar.</button>
												</div>
											</li>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</li>
					</div>
				</div>
				<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<c:choose>
								<c:when test="${not empty tieneingredienteselusuario}">
								</c:when>
								<c:otherwise>
								<div class="py-5 text-center">
									<h1>Oops!...</h1><h2>Â¿No tienes ingredientes en tu heladera?</h2>
								</div>
								</c:otherwise>
								</c:choose>
							</div>
				</div>

	<div id="almenosuno" class="modal fade" tabindex="-1" role="dialog" style="overflow-y: scroll;">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-header">
	      	<div class="alert alert-danger" role="alert">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>        
			  <h3>ï¿½Agrega al menos 1 ingrediente!</h3>
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
			  <h3>ï¿½La fecha es necesaria!</h3>
			</div>
	      </div>  
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
		var texto = document.getElementById("busco").value;
		
		if($("#busco").val() != '') {
			$( "#filtrar" ).val(texto);
			$( "#filtrar" ).focus();
			$( "#filtrar" ).click();
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
			        var capa = document.getElementById("altaingre");
					capa.click(); 
			        }         

		      		
	}		
</script>	
	<script type="text/javascript">
	function validaEnvia() {	
		        	document.getElementById("agregaringre").click(); 
	}
	</script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			(function($) {
				$('#filtrar').click(function() {
					var rex = new RegExp($(this).val(), 'i');
 					$('.buscar tr').hide();
 					if ($("#tlacteos").val() == ''){
 					$('#tlacteos').show();
					}
					$('.buscar tr').filter(function() {
						return rex.test($(this).text());
					}).show();
				})
			}(jQuery));
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			(function($) {
				$('#filtrar').keyup(function() {
					var rex = new RegExp($(this).val(), 'i');
 					$('.buscar tr').hide();
 					if ($("#tlacteos").val() == ''){
 					$('#tlacteos').show();
					}
					$('.buscar tr').filter(function() {
						return rex.test($(this).text());
					}).show();
				})
			}(jQuery));
		});
	</script>
		
   <script type="text/javascript">
            $(function () {
                $('.datetimepicker1').datetimepicker({
                	format: 'DD/MM/YYYY'               	
                });
            });
   </script>
    <script type="text/javascript">
             		function checkIngrediente(iddelcheck) {
	    			 var idcheck = iddelcheck;	 
	    			 var busca = document.getElementById("filtrar").value;
	        		check = document.getElementById(iddelcheck);
	        		check.click();
	        		document.getElementById("loquebusco").value = busca;
	        		validaEnvia();
			   		 }
   	</script>
   	<script language=javascript type=text/javascript>
	function stopRKey(evt) {
	var evt = (evt) ? evt : ((event) ? event : null);
	var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
	if ((evt.keyCode == 13) && (node.type=="text")) {return false;}
	}
	document.onkeypress = stopRKey; 
	</script>
	
	<script type="text/javascript">
		function checkearIngrediente() {
			validaEnvia();						
		}
	</script>
	
</body>
</html>

