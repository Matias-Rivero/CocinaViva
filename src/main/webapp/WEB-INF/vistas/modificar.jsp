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
					<c:when test="${not empty tieneingredienteselusuario}">

						<div class="overlay"></div>
						<div class="gtco-section">
						<div class="gtco-container">
							<div class="py-5 text-center">
								<h1>Modificar Ingredientes <c:if test="${not empty modificar}">${modificar}</c:if></h1>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

									<ul class="list-group mb-3">
						                <form:form method="POST" modelAttribute="ingrediente"
						                  action="modificar">

						                  <li class="list-group-item d-flex justify-content-between lh-condensed">

						                    <div class="table-responsive">
						                      <h3 class="my-0">Ingredientes</h3>
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
						                              <th>
						                              <c:if test = "${(i.tipo == 'LACTEOS') || (i.tipo == 'CONDIMENTOS')}">
						                              <label><strong>Vencimiento</strong></label>
						                              </c:if>
						                              <c:if test = "${(i.tipo == 'VEGETALES') || (i.tipo == 'CARNES') || (i.tipo == 'PESCADO')}">
						                              <label><strong>Compra</strong></label>
						                              </c:if>
						                              <form:input class="form-control datetimepicker1" autocomplete="off"
						                                  path="listaIngredientes[${status.index}].fvencimiento"
						                                  type="text" /></th> 
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
						                                  path="listaIngredientes[${status.index}].id"
						                                  type="text" /></label>
						                              <label class="oculto"><form:input
						                                  path="listaIngredientes[${status.index}].unidad"
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
						                      <button type="button" onclick="validaEnvia();" class="btn btn-primary btn-lg btn-block">Modificar</button> 
						                      <div style="visibility: hidden;">
						                        <button id="modificaringre" class="btn btn-primary" type="submit">modificaringre</button>
						                      </div>  
						                    </div>
						                    
						                  </li>

						                </form:form>

						              </ul>		
															
								</div>

							</div>	
							

						</div>
						</div>
					</c:when>
				</c:choose>

			</c:when>
		<c:otherwise>			
		</c:otherwise>
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

	<script type="text/javascript">
	function validaEnvia() {
	var clases = document.getElementsByClassName("datetimepicker1");	
	var no = "si";
	for (x = 0; x < clases.length; x++)
		      {
		        if(clases[x].value == ''){
		        $('#datetimepickervacio').modal('show');	
				no = "no";
		        }
		      }
		        if(no == "si") { 
			        var capa = document.getElementById("modificaringre");
					capa.click(); 
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

