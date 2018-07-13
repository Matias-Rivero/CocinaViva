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
							<a href="home">Cocina Viva<em>.</em></a>
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

				<header id="gtco-header" class="gtco-cover gtco-cover-sm"></header>

				<c:choose>
					<c:when test="${not empty receta}">

						<div class="overlay"></div>
						<div class="gtco-section">
						<div class="gtco-container">							
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<div class="page-header">
								 <h1>${receta.nombre}</h1>
								</div>	 
								 <img src="images/recetas/${receta.imagen}"  alt="receta" class="img-responsive img-thumbnail" style="width: 500px; height: 300px;" data-holder-rendered="true">
								 
								</div>
								<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<div class="page-header">
<!-- 								 <h1 style="visibility: hidden">.</h1> -->								 
								 <h1 class="cursive-font"><a href="#" target=""><span class="dot">Cocinar</span></a></h1>
								</div>
									<ul class="list-group mb-3">
						                
									<c:forEach items="${receta.listaIngrediente}" var="ingrediente">	
									
		<li class="list-group-item d-flex justify-content-between lh-condensed">${ingrediente.cantidadstring} ${ingrediente.nombre}</li>

						            </c:forEach>    

						             </ul>																	
								</div>
								
							</div>	
							
							
							
							<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							
							  <div class="page-header">
						        <h1>Pasos</h1>
						      </div>
						      <c:forEach items="${listaPasos}" var="pasos">
						      <div class="panel panel-info">
					            <div class="panel-heading">
					              <h3 class="panel-title">Paso ${pasos.paso}</h3>
					            </div>
					            <div class="panel-body">
					              ${pasos.descripcion}
					            </div>
					          </div>
					          </c:forEach> 
						     						      
							</div>
							</div>
							
							

						</div>
						</div>
					</c:when>
				</c:choose>

			</c:when>
		</c:choose>

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
		
		<div id="ModalCrear" class="modal fade" tabindex="-1" role="dialog"
			style="overflow-y: scroll;">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">¿Estas seguro de
							elminar el ingrediente?</h4>
					</div>
					<div class="modal-body">
						<span class="lead" id="ingred"></span>
					</div>
					<div class="modal-footer" id="despues">
						<a type="button" class="btn btn-lg btn-primary btn-block" href=""
							id="eliminar"><span class="glyphicon glyphicon-ok">Confirmar</span></a>
						<a type="button" class="btn btn-lg btn-default btn-block" href=""
							data-dismiss="modal"><span class="glyphicon glyphicon-remove">Cancelar</span></a>
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

</body>
</html>

