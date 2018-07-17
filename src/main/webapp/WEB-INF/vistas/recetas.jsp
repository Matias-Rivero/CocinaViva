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
									<li><a href="ingredientes"><span>Agregar Ingredientes</span></a></li>
									<li><a href="modificar"><span>Modificar Ingredientes</span></a></li>
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

		<div class="gtco-section">
			<div class="gtco-container">
					<div class="py-5 text-center" id="gtco-counter">
			
					<h1>
						Recetas Encontradas!<span
							class="badge pull-right counter js-counter" data-from="0"
							data-to="${listaRecetasLargo}" data-speed="300" data-refresh-interval="50"></span>
					</h1>
					<a href="trecetas"><span class="label label-warning pull-left">¡Usalos Todos!</span></a>
					<label class="label label-warning">Con:</label>
					<form:form id="form1" method="POST" modelAttribute="lingrediente"
									action="drecetas">
						<label class="oculto"><form:input path="id" id="id" type="text" class="form-control" /></label>	
						<label class="oculto"><form:input path="nombre" id="nombrereceta" type="text" class="form-control" /></label>					
						<c:forEach items="${ingredinetesseleccionados}"
							var="ingredinetesseleccionados">
							<label class="label label-success"><a href="javascript:quitarIng(${ingredinetesseleccionados.id});" class="badge badge-danger">x</a>${ingredinetesseleccionados.nombre}<span
								class="badge badge-secondary">${ingredinetesseleccionados.cantidad}${ingredinetesseleccionados.unidad}</span></label>							
<%-- 							<label class="oculto"><form:input id="${ingredinetesseleccionados.id}" path="faltante" type="text" value="${ingredinetesseleccionados.faltante}" /></label>		 --%>
							<label class="oculto"><form:input path="seleccionados" type="text" value="${ingredinetesseleccionados.id}" /></label>	
						</c:forEach>
					</form:form>
				</div>
				<div class="row">
		          <div class="col-md-12 order-md-12 mb-12">
		          <br>
		            <ul class="list-group mb-3">
		            
		              <li class="list-group-item d-flex justify-content-between lh-condensed">
						 <form name="buscar" action="javascript:;" onsubmit="buscarRecetas(this)" method="get">	
		                <div class="input-group">
		               
		                <span class="input-group-addon"><a href="javascript:buscarRecetas();">Buscar</a></span> <input type="text" id="buscarR" class="form-control" value="<c:if test="${not empty loquebusco}">${loquebusco}</c:if>" placeholder="estofado de pollo" autocomplete="off">
		                	                
		                </div>
		                </form> 		              	
		              </li>
		              <c:if test="${not empty nohayrecetascriterio}"><li><label class="label label-info">No hay recetas con el criterio ${nohayrecetascriterio}</label></li></c:if>
		              <c:if test="${not empty loquebusco}"><li><a class="glyphicon glyphicon-remove" href="javascript:buscarRecetasVacio();"><span class="label label-info">${loquebusco}</span></a></li></c:if>
		            </ul>
          </div>
								
				<div class="row">
					<c:choose>
						<c:when test="${not empty listaRecetasBuscadas}">
							<c:forEach items="${listaRecetasBuscadas}" var="listaRecetas">
								<div class="col-lg-4 col-md-4 col-sm-6">
									
										<a href="leerRecetas?id=${listaRecetas.id}"
											class="fh5co-card-item">
											<figure>
												<div class="overlay">
													<i class="ti-plus"></i>
												</div>
												<img src="images/recetas/${listaRecetas.imagen}" alt="Image"
													class="img-responsive">
											</figure>
											<div class="fh5co-text">
												<h3>${listaRecetas.nombre}</h3>
												<p>			
													<span class="label">Calorias:</span>										
													<label>${listaRecetas.calorias}</label>													
												</p>
												<div class="table-responsive">
												<table  class="table table-bordered">
												<tbody>
												  <!-- Aplicadas en las filas -->
												  <tr class="active">Requiere:</tr>
												 
												  <!-- Aplicadas en las celdas (<td> o <th>) -->
												  <c:forEach items="${listaRecetas.listaIngrediente}" var="listaIngredientes">   
												  <tr>               
												    <td class="active">${listaIngredientes.nombre} ${listaIngredientes.cantidadstring}</td>
												    <c:if test = "${listaIngredientes.faltante > 0}">
												    <td class="success"><label class="label label-success">OK</label></td>
												    </c:if>  
												    <c:if test = "${listaIngredientes.faltante < 0}">
												    <td class="info"><label class="label label-info">FALTAN ${listaIngredientes.faltante * -1} </label></td>
												    </c:if>
												    <c:if test = "${listaIngredientes.faltante == 0}">
												    <td class="warning"><label class="label label-warning">OK</label></td>
												    </c:if>
												    <c:if test="${empty listaIngredientes.faltante}">
												    <td class="danger"><label class="label label-danger">NO</label></td>
												    </c:if>    
												  </tr>
												  </c:forEach> 
												</tbody>
												</table>
												</div>									
											</div>
										</a>																			
									
								</div>
							</c:forEach>
						</c:when>
					</c:choose>

				</div>
				<c:if test="${not empty listaRecetas}">
				<div class="text-left">
				<label class="label label-info">Con lo que tienes puedes hacer:</label>				
				</div>
				<br>
				</c:if>
				<c:if test="${empty listaRecetas}">
				<div class="text-center">
				<label class="label label-danger">Lo sentimos - todavía no tenemos recetas con esos ingredientes.</label>				
				</div>
				<br>
				</c:if>
				<div class="row">
					<c:choose>
						<c:when test="${not empty listaRecetas}">
							<c:forEach items="${listaRecetas}" var="listaRecetas">
								<div class="col-lg-4 col-md-4 col-sm-6">

										<a href="leerRecetas?id=${listaRecetas.id}"
											class="fh5co-card-item">
											<figure>
												<div class="overlay">
													<i class="ti-plus"></i>
												</div>
												<img src="images/recetas/${listaRecetas.imagen}" alt="Image"
													class="img-responsive">
											</figure>
											<div class="fh5co-text">
												<h3>${listaRecetas.nombre}</h3>
												<p>			
													<span class="label">Calorias:</span>										
													<label>${listaRecetas.calorias}</label>													
												</p>
												<div class="table-responsive">
												<table  class="table table-bordered">
												<tbody>
												  <!-- Aplicadas en las filas -->
												  <tr class="active">Requiere:</tr>
												 
												  <!-- Aplicadas en las celdas (<td> o <th>) -->
												  <c:forEach items="${listaRecetas.listaIngrediente}" var="listaIngredientes">   
												  <tr>               
												    <td class="active">${listaIngredientes.nombre} ${listaIngredientes.cantidadstring}</td>
												    <c:if test = "${listaIngredientes.faltante > 0}">
												    <td class="success"><label class="label label-success">OK</label></td>
												    </c:if>  
												    <c:if test = "${listaIngredientes.faltante < 0}">
												    <td class="info"><label class="label label-info">FALTAN ${listaIngredientes.faltante * -1}</label></td>
												    </c:if>
												    <c:if test = "${listaIngredientes.faltante == 0}">
												    <td class="warning"><label class="label label-warning">OK</label></td>
												    </c:if>
												    <c:if test="${empty listaIngredientes.faltante}">
												    <td class="danger"><label class="label label-danger">NO</label></td>
												    </c:if>    
												  </tr>
												  </c:forEach> 
												</tbody>
												</table>
												</div>									
											</div>
										</a>

								</div>
							</c:forEach>
						</c:when>
					</c:choose>

				</div>
				
			</div>
		</div>

		<div id="buscarrecetasvacio" class="modal fade" tabindex="-1" role="dialog" style="overflow-y: scroll;">
			  <div class="modal-dialog modal-sm">
			    <div class="modal-content">
			      <div class="modal-header">
			      	<div class="alert alert-danger" role="alert">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>        
					  <h3>Escriba el nombre de una receta</h3>
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


<!-- <div class="gototopo js-topo"> -->
<!-- 		<a href="#" class="js-gotopo"><i class="icon-arrow-up"></i></a> -->
<!-- </div>	 -->

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
	
	<script type="text/javascript">
		function quitarIng(id) {
			
		
			document.getElementById("id").value = id;
			
			document.forms["form1"].submit();
		}
	</script>
	
	<script type="text/javascript">
		function buscarRecetas() {
			var receta = document.getElementById("buscarR").value;
			
			if(receta == ''){
				$('#buscarrecetasvacio').modal('show');
			}
			else{
			document.getElementById("nombrereceta").value = receta;
			document.forms["form1"].submit();
			}
		}
	</script>
	<script type="text/javascript">
		function buscarRecetasVacio() {
			var receta = document.getElementById("buscarR").value;
			document.getElementById("nombrereceta").value = '';
			document.forms["form1"].submit();
			
		}
	</script>
	
</body>
</html>

