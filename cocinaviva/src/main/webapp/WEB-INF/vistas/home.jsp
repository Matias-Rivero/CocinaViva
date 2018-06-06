<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Aesthetic by gettemplates.co
	Twitter: http://twitter.com/gettemplateco
	URL: http://gettemplates.co
-->
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Cocina Viva &mdash;</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by GetTemplates.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="GetTemplates.co" />

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


		<!-- <div class="page-inner"> -->
		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="gtco-logo">
							<a href="home">Cocina Viva <em>.</em></a>
						</div>
					</div>

					<c:choose>
						<c:when test="${usuariologueado != null}">
							<div class="col-xs-8 text-right menu-1">
								<ul>
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



		<c:choose>
			<c:when test="${usuariologueado != null}">

				<header id="gtco-header" class="gtco-cover gtco-cover-sm">

				</header>


				<c:choose>
					<c:when test="${not empty tieneingredienteselusuario}">

						<div class="overlay"></div>
						<div class="gtco-container">
							<div class="py-5 text-center">
								<img class="d-block mx-auto mb-4"
									src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg"
									alt="" width="72" height="72">
								<h1>Cocina con tus ingredientes!</h1>
							</div>
							<div class="row">
								<div class="col-md-9 order-md-9 mb-9">

									<h4
										class="d-flex justify-content-between align-items-center mb-3">
										<span class="text-muted">Selecciona los ingredientes de
											tu heladera</span>
									</h4>
									<ul class="list-group mb-3">
										<form:form method="POST" modelAttribute="checkingredientes"
											action="recetas">
											<c:choose>
												<c:when test="${not empty ingredienteslacteosdelusuario}">
													<li
														class="list-group-item d-flex justify-content-between lh-condensed">

														<div class="table-responsive">
															<h2 class="my-0">Lacteos</h2>
															<table class="table table-hover">
																<thead>
																	<tr>
																		<th><span class="lead">Nombre</span></th>
																		<th><span class="lead">Cantidad</span></th>
																		<th><span class="lead">Gramos</span></th>
																		<th><span class="lead">Fecha de Compra</span></th>
																		<th><span class="lead">Fecha de
																				Vencimiento</span></th>
																	</tr>
																</thead>
																<tbody class="buscar">

																	<c:forEach items="${ingredienteslacteosdelusuario}"
																		var="ingredienteslacteosdelusuario">
																		<tr align="left">

																			<th><span class="lead"><form:checkbox
																						path="seleccionados"
																						value="${ingredienteslacteosdelusuario.id}" />&nbsp
																					${ingredienteslacteosdelusuario.nombre}</span></th>
																			<th><span class="lead">${ingredienteslacteosdelusuario.cantidad}</span></th>
																			<th><span class="lead">${ingredienteslacteosdelusuario.gramos}</span></th>
																			<th><span class="lead">${ingredienteslacteosdelusuario.fcompra}</span></th>
																			<th><span class="lead">${ingredienteslacteosdelusuario.fvencimiento}</span></th>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</li>
												</c:when>
											</c:choose>

											<c:choose>
												<c:when test="${not empty ingredientesvegetalesdelusuario}">
													<li
														class="list-group-item d-flex justify-content-between lh-condensed">

														<div class="table-responsive">
															<h2 class="my-0">Vegetales</h2>
															<table class="table table-hover">
																<thead>
																	<tr>
																		<th><span class="lead">Nombre</span></th>
																		<th><span class="lead">Cantidad</span></th>
																		<th><span class="lead">Gramos</span></th>
																		<th><span class="lead">Fecha de Compra</span></th>
																		<th><span class="lead">Fecha de
																				Vencimiento</span></th>
																	</tr>
																</thead>
																<tbody class="buscar">

																	<c:forEach items="${ingredientesvegetalesdelusuario}"
																		var="ingredientesvegetalesdelusuario">
																		<tr align="left">

																			<th><span class="lead"><form:checkbox
																						path="seleccionados"
																						value="${ingredientesvegetalesdelusuario.id}" />&nbsp
																					${ingredientesvegetalesdelusuario.nombre}</span></th>
																			<th><span class="lead">${ingredientesvegetalesdelusuario.cantidad}</span></th>
																			<th><span class="lead">${ingredientesvegetalesdelusuario.gramos}</span></th>
																			<th><span class="lead">${ingredientesvegetalesdelusuario.fcompra}</span></th>
																			<th><span class="lead">${ingredientesvegetalesdelusuario.fvencimiento}</span></th>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</li>
												</c:when>
											</c:choose>

											<c:choose>
												<c:when test="${not empty ingredientescarnesdelusuario}">
													<li
														class="list-group-item d-flex justify-content-between lh-condensed">

														<div class="table-responsive">
															<h2 class="my-0">Carnes</h2>
															<table class="table table-hover">
																<thead>
																	<tr>
																		<th><span class="lead">Nombre</span></th>
																		<th><span class="lead">Cantidad</span></th>
																		<th><span class="lead">Gramos</span></th>
																		<th><span class="lead">Fecha de Compra</span></th>
																		<th><span class="lead">Fecha de
																				Vencimiento</span></th>
																	</tr>
																</thead>
																<tbody class="buscar">

																	<c:forEach items="${ingredientescarnesdelusuario}"
																		var="ingredientescarnesdelusuario">
																		<tr align="left">

																			<th><span class="lead"><form:checkbox
																						path="seleccionados"
																						value="${ingredientescarnesdelusuario.id}" />&nbsp
																					${ingredientescarnesdelusuario.nombre}</span></th>
																			<th><span class="lead">${ingredientescarnesdelusuario.cantidad}</span></th>
																			<th><span class="lead">${ingredientescarnesdelusuario.gramos}</span></th>
																			<th><span class="lead">${ingredientescarnesdelusuario.fcompra}</span></th>
																			<th><span class="lead">${ingredientescarnesdelusuario.fvencimiento}</span></th>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</li>
												</c:when>
											</c:choose>

											<c:choose>
												<c:when test="${not empty ingredientespescadodelusuario}">
													<li
														class="list-group-item d-flex justify-content-between lh-condensed">

														<div class="table-responsive">
															<h2 class="my-0">Pescado</h2>
															<table class="table table-hover">
																<thead>
																	<tr>
																		<th><span class="lead">Nombre</span></th>
																		<th><span class="lead">Cantidad</span></th>
																		<th><span class="lead">Gramos</span></th>
																		<th><span class="lead">Fecha de Compra</span></th>
																		<th><span class="lead">Fecha de
																				Vencimiento</span></th>
																	</tr>
																</thead>
																<tbody class="buscar">

																	<c:forEach items="${ingredientespescadodelusuario}"
																		var="ingredientespescadodelusuario">
																		<tr align="left">

																			<th><span class="lead"><form:checkbox
																						path="seleccionados"
																						value="${ingredientespescadodelusuario.id}" />&nbsp
																					${ingredientespescadodelusuario.nombre}</span></th>
																			<th><span class="lead">${ingredientespescadodelusuario.cantidad}</span></th>
																			<th><span class="lead">${ingredientespescadodelusuario.gramos}</span></th>
																			<th><span class="lead">${ingredientespescadodelusuario.fcompra}</span></th>
																			<th><span class="lead">${ingredientespescadodelusuario.fvencimiento}</span></th>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</li>
												</c:when>
											</c:choose>

											<c:choose>
												<c:when test="${not empty ingredientescondimentodelusuario}">
													<li
														class="list-group-item d-flex justify-content-between lh-condensed">

														<div class="table-responsive">
															<h2 class="my-0">Condimento</h2>
															<table class="table table-hover">
																<thead>
																	<tr>
																		<th><span class="lead">Nombre</span></th>
																		<th><span class="lead">Cantidad</span></th>
																		<th><span class="lead">Gramos</span></th>
																		<th><span class="lead">Fecha de Compra</span></th>
																		<th><span class="lead">Fecha de
																				Vencimiento</span></th>
																	</tr>
																</thead>
																<tbody class="buscar">

																	<c:forEach items="${ingredientescondimentodelusuario}"
																		var="ingredientescondimentodelusuario">
																		<tr align="left">

																			<th><span class="lead"><form:checkbox
																						path="seleccionados"
																						value="${ingredientescondimentodelusuario.id}" />&nbsp
																					${ingredientescondimentodelusuario.nombre}</span></th>
																			<th><span class="lead">${ingredientescondimentodelusuario.cantidad}</span></th>
																			<th><span class="lead">${ingredientescondimentodelusuario.gramos}</span></th>
																			<th><span class="lead">${ingredientescondimentodelusuario.fcompra}</span></th>
																			<th><span class="lead">${ingredientescondimentodelusuario.fvencimiento}</span></th>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</li>
												</c:when>
											</c:choose>
											<div style="visibility: hidden;">
												<button id="buscarreceta" class="btn btn-primary"
													type="submit">Iniciar</button>
											</div>
										</form:form>
									</ul>




								</div>

								<div class="col-md-3 order-md-3">

									<h4
										class="d-flex justify-content-between align-items-center mb-3">
										<!-- 										<span class="text-muted">Buscar Ingrediente</span> -->
										<span class="text-muted">¿Tienes mas ingredientes?</span>
									</h4>
									<!-- 									<ul class="list-group mb-3"> -->
									<!-- 										<li -->
									<!-- 											class="list-group-item d-flex justify-content-between lh-condensed"> -->
									<!-- 											<div class="input-group"> -->
									<!-- 												<span class="input-group-addon">Buscar</span> <input -->
									<!-- 													type="text" id="filtrar" class="form-control" -->
									<!-- 													placeholder="Ingrediente"> -->

									<!-- 											</div> -->
									<!-- 										</li> -->
									<!-- 									</ul> -->

									<ul class="list-group mb-3">
										<li
											class="list-group-item d-flex justify-content-between lh-condensed">

											<a href="ingredientes"
											class="btn btn-primary btn-lg btn-block" role="button">Agregar
												Ingredientes</a>

										</li>
									</ul>

									<ul class="list-group mb-3">


										<li
											class="list-group-item d-flex justify-content-between lh-condensed">

											<a onclick="buscarreceta();"> <span class="text-muted">
													<input type=image src="images/flecha.jpg"
													alt="BUSCAR RECETA" class="img-rounded img-responsive">

											</span>
												<h2
													class="d-flex justify-content-between align-items-center mb-3">
													<span class="text-muted">BUSCAR RECETAS</span>
												</h2>
										</a>
										</li>
									</ul>

								</div>

							</div>


						</div>



					</c:when>

				</c:choose>


			</c:when>
			<c:otherwise>
				<header id="gtco-header" class="gtco-cover gtco-cover-md"
					role="banner" style="background-image: url(images/img_bg_1.jpg)"
					data-stellar-background-ratio="0.5">
					<div class="overlay"></div>
					<div class="gtco-container">
						<div class="row">
							<div class="col-md-12 col-md-offset-0 text-left">


								<div class="row row-mt-15em">
									<div class="col-md-7 mt-text animate-box"
										data-animate-effect="fadeInUp">
										<span class="intro-text-small">NO desperdicies más!</span>
										<h2 class="cursive-font">Unite a esta comunidad
											saludable!</h2>
										<span class="intro-text-small">Cocina todo lo de tu
											alacena, ahorrás y aprendes a comer. ¿Qué Más?.</span>
									</div>
									<div class="col-md-4 col-md-push-1 animate-box"
										data-animate-effect="fadeInRight">
										<div class="form-wrap">
											<div class="tab">

												<div class="tab-content">
													<div class="tab-content-inner active" data-content="signup">
														<h2 class="cursive-font">Ingresá</h2>
														<form:form action="validar-login" method="POST"
															modelAttribute="usuario">

															<div class="row form-group">
																<div class="col-md-12">
																	<label for="date-start">Usuario</label>
																	<form:input path="email" id="email" type="email"
																		placeholder="usuario@usuario.com.ar"
																		class="form-control" />
																</div>
															</div>
															<div class="row form-group">
																<div class="col-md-12">
																	<label for="date-start">Contraseña</label>
																	<form:input path="password" type="password"
																		id="password" class="form-control" />
																</div>
															</div>

															<div class="row form-group">
																<div class="col-md-12">
																	<input type="submit" class="btn btn-primary btn-block"
																		value="Ingresar">
																</div>
															</div>
														</form:form>
														<%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
														<c:if test="${not empty error}">
															<h4>
																<span class="intro-text-small">${error}</span>
															</h4>
															<br>
														</c:if>
														<h2 class="cursive-font">
															<a href="registro">Regístrate</a>
														</h2>
													</div>


												</div>
											</div>
										</div>
									</div>
								</div>


							</div>
						</div>
					</div>
				</header>
			</c:otherwise>
		</c:choose>

		<footer id="gtco-footer" role="contentinfo"
			style="background-image: url(images/img_bg_1.jpg)"
			data-stellar-background-ratio="0.5">
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
		<!-- </div> -->

	</div>

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
		function buscarreceta() {

			var capa = document.getElementById("buscarreceta");
			capa.click();

		}

		function agregaringre() {

			var capa = document.getElementById("agregaringre");
			capa.click();

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

</body>
</html>

