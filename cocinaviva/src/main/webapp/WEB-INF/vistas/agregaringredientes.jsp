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


		<header id="gtco-header" class="gtco-cover gtco-cover-sm"> </header>



		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="py-5 text-center">
				<img class="d-block mx-auto mb-4"
					src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg"
					alt="" width="72" height="72">
				<h1>Agregar Ingredientes</h1>
			</div>

			<div class="row">
				<div class="col-md-12 order-md-12 mb-12">

					<h4 class="d-flex justify-content-between align-items-center mb-3">
					</h4>
					<ul class="list-group mb-3">
						<c:choose>
							<c:when test="${not empty tieneingredienteselusuario}">
								<li
									class="list-group-item d-flex justify-content-between lh-condensed">

									<div class="table-responsive">
										<h3 class="my-0">Tus ingredientes</h3>
										<table class="table table-hover">
											<thead>
												<tr>
													<th><span class="lead">Nombre</span></th>
													<th><span class="lead">Cantidad</span></th>
													<th><span class="lead">Gramos</span></th>
													<th><span class="lead">Fecha de Compra</span></th>
													<th><span class="lead">Fecha de Vencimiento</span></th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${tieneingredienteselusuario}"
													var="tieneingredienteselusuario">
													<tr align="left">

														<th><span class="lead">${tieneingredienteselusuario.nombre}</span></th>
														<th><span class="lead">${tieneingredienteselusuario.cantidad}</span></th>
														<th><span class="lead">${tieneingredienteselusuario.gramos}</span></th>
														<th><span class="lead">${tieneingredienteselusuario.fcompra}</span></th>
														<th><span class="lead">${tieneingredienteselusuario.fvencimiento}</span></th>
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
					<ul class="list-group mb-3">
						<form:form method="POST" modelAttribute="altaingredientes"
							action="altaIngredientes">
							<c:choose>
								<c:when test="${not empty ingredinetesseleccionados}">
									<li
										class="list-group-item d-flex justify-content-between lh-condensed">

										<div class="table-responsive">
											<h3 class="my-0">Para Agregar</h3>
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="lead">Nombre</span></th>
														<th><span class="lead">Cantidad</span></th>
														<th><span class="lead">Gramos</span></th>
														<th><span class="lead">Fecha de Compra</span></th>
														<th><span class="lead">Fecha de Vencimiento</span></th>
													</tr>
												</thead>
												<tbody>

													<c:forEach items="${ingredinetesseleccionados}"
														var="ingredinetesseleccionados">
														<tr align="left">

															<th><span class="lead">${ingredinetesseleccionados.nombre}</span></th>
															<th><span class="lead">${ingredinetesseleccionados.cantidad}</span></th>
															<th><span class="lead">${ingredinetesseleccionados.gramos}</span></th>
															<th><span class="lead">${ingredinetesseleccionados.fcompra}</span></th>
															<th><span class="lead">${ingredinetesseleccionados.fvencimiento}</span></th>
														</tr>
													</c:forEach>
											</tbody>
											
										</table>
										<input type="submit" class="btn btn-primary btn-lg btn-block"
												value="AGREGAR">
									</div>
								</li>
							</c:when>
						</c:choose>
						</form:form>
						<!-- 											<div style="visibility: hidden;"> -->
																		
						<!-- 											</div> -->
						<%-- 										</form:form> --%>
					</ul>




				</div>


			</div>


			<div class="row">
				<div class="col-md-12 order-md-12 mb-12">
					<!-- Oops!. ¿No tienes ingredientes en tu heladera? -->
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Agregar Ingrediente</span>
					</h4>
					<ul class="list-group mb-3">
						<li
							class="list-group-item d-flex justify-content-between lh-condensed">

							<div class="input-group">
								<span class="input-group-addon">Buscar</span> <input type="text"
									id="filtrar" class="form-control"
									placeholder="Agregar Ingrediente">

							</div>

						</li>
					</ul>
				</div>
				<div class="col-md-9 order-md-9 mb-9">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Ingredientes Sugeridos</span>
					</h4>

					<ul class="list-group mb-3">
						<form:form method="POST" modelAttribute="checkingredientes"
							action="agregarIngredientes">
							<c:choose>
								<c:when test="${not empty ingredientesofrecidosenlacteos}">
									<li
										class="list-group-item d-flex justify-content-between lh-condensed">

										<div class="table-responsive">
											<h2 class="my-0">Lacteos</h2>
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="lead">Nombre</span></th>
													</tr>
												</thead>
												<tbody class="buscar">

													<c:forEach items="${ingredientesofrecidosenlacteos}"
														var="ingredientesofrecidosenlacteos">
														<tr align="left">

															<th><span class="lead"><form:checkbox
																		path="seleccionados"
																		value="${ingredientesofrecidosenlacteos.id}" />&nbsp
																	${ingredientesofrecidosenlacteos.nombre}</span></th>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</li>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when test="${not empty ingredientesofrecidosenvegetales}">
									<li
										class="list-group-item d-flex justify-content-between lh-condensed">

										<div class="table-responsive">
											<h2 class="my-0">Vegetales</h2>
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="lead">Nombre</span></th>
													</tr>
												</thead>
												<tbody class="buscar">

													<c:forEach items="${ingredientesofrecidosenvegetales}"
														var="ingredientesofrecidosenvegetales">
														<tr align="left">

															<th><span class="lead"><form:checkbox
																		path="seleccionados"
																		value="${ingredientesofrecidosenvegetales.id}" />&nbsp
																	${ingredientesofrecidosenvegetales.nombre}</span></th>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</li>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when test="${not empty ingredientesofrecidosencarnes}">
									<li
										class="list-group-item d-flex justify-content-between lh-condensed">

										<div class="table-responsive">
											<h2 class="my-0">Carnes</h2>
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="lead">Nombre</span></th>
													</tr>
												</thead>
												<tbody class="buscar">

													<c:forEach items="${ingredientesofrecidosencarnes}"
														var="ingredientesofrecidosencarnes">
														<tr align="left">

															<th><span class="lead"><form:checkbox
																		path="seleccionados"
																		value="${ingredientesofrecidosencarnes.id}" />&nbsp
																	${ingredientesofrecidosencarnes.nombre}</span></th>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</li>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when test="${not empty ingredientesofrecidosenpescado}">
									<li
										class="list-group-item d-flex justify-content-between lh-condensed">

										<div class="table-responsive">
											<h2 class="my-0">Pescado</h2>
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="lead">Nombre</span></th>
													</tr>
												</thead>
												<tbody class="buscar">

													<c:forEach items="${ingredientesofrecidosenpescado}"
														var="ingredientesofrecidosenpescado">
														<tr align="left">

															<th><span class="lead"><form:checkbox
																		path="seleccionados"
																		value="${ingredientesofrecidosenpescado.id}" />&nbsp
																	${ingredientesofrecidosenpescado.nombre}</span></th>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</li>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when test="${not empty ingredientesofrecidosencondimento}">
									<li
										class="list-group-item d-flex justify-content-between lh-condensed">

										<div class="table-responsive">
											<h2 class="my-0">Condimento</h2>
											<table class="table table-hover">
												<thead>
													<tr>
														<th><span class="lead">Nombre</span></th>
													</tr>
												</thead>
												<tbody class="buscar">

													<c:forEach items="${ingredientesofrecidosencondimento}"
														var="ingredientesofrecidosencondimento">
														<tr align="left">

															<th><span class="lead"><form:checkbox
																		path="seleccionados"
																		value="${ingredientesofrecidosencondimento.id}" />&nbsp
																	${ingredientesofrecidosencondimento.nombre}</span></th>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</li>
								</c:when>
							</c:choose>
							<div style="visibility: hidden;">
								<button id="agregaringre" class="btn btn-primary" type="submit">Iniciar</button>
							</div>
						</form:form>
					</ul>


				</div>
				<div class="col-md-3 order-md-3">

					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Click para confirmar</span>
					</h4>

					<ul class="list-group mb-3">


						<li
							class="list-group-item d-flex justify-content-between lh-condensed">

							<a onclick="agregaringre();"> <span class="text-muted">
									<span class="text-muted"> <input type=image
										src="images/flecha.jpg" alt="AGREGAR INGREDIENTE"
										class="img-rounded img-responsive">

								</span>
									<h2
										class="d-flex justify-content-between align-items-center mb-3">
										<span class="text-muted">AGREGAR INGREDIENTE</span>
									</h2></a>
						</li>
					</ul>

				</div>

			</div>


		</div>



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

