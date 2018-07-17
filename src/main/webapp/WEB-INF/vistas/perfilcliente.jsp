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


		<!-- <div class="page-inner"> -->
		<nav class="gtco-nav" role="navigation">
			<div class="gtco-container">

				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="gtco-logo">
							<a href="home"><img src="images/logo.png" width="170px" height="60px" style="margin:-10px" /></a>
						</div>
					</div>

					<c:choose>
						<c:when test="${usuariologueado != null}">

							<div class="col-xs-8 text-right menu-1">
								<ul>

									<li><a href="home"><span>Inventario</span></a></li>
									<li><a href="ingredientes"><span>Agregar Ingredientes</span></a></li>
									<li><a href="modificar"><span>Modificar Ingredientes</span></a></li>
									<li class="has-dropdown">|<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-bell"></i></a>									
									<ul class="dropdown">
									<li class="page-header">Recordatorios</li>
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
		<div class="gtco-container">
			<div class="py-5 text-center">
				<h1>Mi Perfil</h1>
			</div>

			<div class="row">
				<!-- <h2>blabla</h2> -->

				<div class="col-md-12 ">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h2>${usuariologueado.alias}</h2>
						</div>
						<div class="panel-body">

							<div class="box box-info">

								<div class="box-body">
									<div class="col-sm-6">
										<div align="center">
											<img alt="User Pic"
												src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
												id="profile-image1" class="img-circle img-responsive">

											<input id="profile-image-upload" class="hidden" type="file">
											<div style="color: #999;">Click para cambiar imagen</div>
											
										</div>

										<br>

										<!-- /input-group -->
									</div>
									
									<div class="clearfix"></div>
									<hr style="margin: 5px 0 5px 0;">


									<div class="col-sm-5 col-xs-6 tital ">Nombre:</div>
									<div class="col-sm-7 col-xs-6 ">${usuariologueado.nombre}</div>
									<div class="clearfix"></div>
									<div class="bot-border"></div>

									<div class="col-sm-5 col-xs-6 tital ">Apellido:</div>
									<div class="col-sm-7">${usuariologueado.apellido}</div>
									<div class="clearfix"></div>
									<div class="bot-border"></div>

									<div class="col-sm-5 col-xs-6 tital ">Alias:</div>
									<div class="col-sm-7">${usuariologueado.alias}</div>
									<div class="clearfix"></div>
									<div class="bot-border"></div>

									<div class="col-sm-5 col-xs-6 tital ">Email</div>
									<div class="col-sm-7">${usuariologueado.email}</div>

									<div class="clearfix"></div>
									<div class="bot-border"></div>

									<!-- /.box-body -->
								</div>
								<!-- /.box -->

							</div>


						</div>
					</div>
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

	<script>
		$(function() {
			$('#profile-image1').on('click', function() {
				$('#profile-image-upload').click();
			});
		});
	</script>
</body>
</html>

