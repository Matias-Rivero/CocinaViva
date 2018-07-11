<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Cocina Viva &mdash;</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="" />
<meta name="keywords" content="" />
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

		
				<header id="gtco-header" class="gtco-cover gtco-cover-md"
					role="banner" style="background-image: url(images/lareceta.jpg)"
					data-stellar-background-ratio="0.5">
					<div class="overlay"></div>
					<div class="gtco-container">
						<div class="row">
							<div class="col-md-12 col-md-offset-0 text-left">


								<div class="row">
									<div class="col-md-12 mt-text animate-box" data-animate-effect="fadeInUp">
										<div class="form-wrap">
											<div class="tab">
												<div class="tab-content">
													<div class="tab-content-inner active" data-content="signup">
														<h1 class="cursive-font text-center">Registrate</h1>
														<c:if test="${not empty errors}">
																<h4>
																	<span class="intro-text-small">${errors}</span>
																</h4>			
														</c:if>	
															<form:form action="validar-registro" method="POST"
																modelAttribute="usuario">
																<div class="row form-group">
																	<div class="col-md-6">
																		<label for="date-start">Nombre </label>
																		<form:input path="nombre" id="nombre" type="text" class="form-control" autocomplete="off"/>
																		<label id="errornombre" class="label label-danger"></label>																	
																	</div>
																
																
																	<div class="col-md-6">
																		<label for="date-start">Apellido</label>
																		<form:input path="apellido" type="text" id="apellido"
																			class="form-control" autocomplete="off"/>
																		<label id="errorapellido" class="label label-danger"></label>	
																	</div>
																</div>
																<div class="row form-group">
																	<div class="col-md-12">
																		<label for="date-start">Email</label>
																		<form:input path="email" id="email" type="email"
																			placeholder="usuario@usuario.com.ar" class="form-control" autocomplete="off"/>
																		<label id="erroremail" class="label label-danger"></label>	
																	</div>
																</div>
																<div class="row form-group">
																	<div class="col-md-6">
																		<label for="date-start">Contraseña</label>
																		<form:input path="password" type="password" id="password"
																			class="form-control" autocomplete="off"/>
																		<label id="errorpassword" class="label label-danger"></label>	
																	</div>
																
																
																
																	<div class="col-md-6">
																		<label for="date-start">Confirmar contraseña</label>
																		<form:input path="repassword" type="password" id="repassword"
																			class="form-control" autocomplete="off"/>
																		<label id="errorrepassword" class="label label-danger"></label>	
																	</div>
																</div>
																
																<div class="row form-group">
																	<div class="col-md-12">
																		<label for="date-start">Alias</label>
																		<form:input path="alias" type="text" id="alias" placeholder="ej: JuanPi" 
																			class="form-control" autocomplete="off"/>
																		<label id="erroralias" class="label label-danger"></label>	
																	</div>
																</div>
									
																<div class="row form-group">
																	<div class="col-md-6">
																		<input type="button" class="btn btn-primary btn-block"
																			value="Cancelar"  onclick="location.href='home'">
																	</div>
																	<div class="col-md-6">
																		<input type="button" class="btn btn-primary btn-block"
																			value="Registrarme"  onclick="javascript:validarForm('nombre','apellido','email','password','repassword','alias')">
																	</div>
																	
																</div>
															</form:form>
															
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

	

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	</div>
	<script src="js/js.js"></script>
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
	
</body>
</html>

