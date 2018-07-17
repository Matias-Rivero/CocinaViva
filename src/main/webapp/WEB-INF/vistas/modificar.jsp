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
									<li><a href="ingredientes"><span>Agregar ingredientes</span></a></li>
									<li class="has-dropdown">|<a href="#" class="dropdown-toggle" data-toggle="dropdown" ><i class="glyphicon glyphicon-bell"></i></a>									<ul class="dropdown">
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

		<c:choose>
			<c:when test="${usuariologueado != null}">

				<header id="gtco-header" class="gtco-cover gtco-cover-sm"></header>

				<c:choose>
					<c:when test="${not empty tieneingredienteselusuario}">

						<div class="overlay"></div>
						<div class="gtco-section">
						<div class="gtco-container">
							<div class="py-5 text-center">
								<h1>Modificar Ingredientes</h1><a href="cerrarSesion"><span>vencidos y agotados</span></a>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

									<ul class="list-group mb-3">
						                <form:form method="POST" modelAttribute="ingrediente"
						                  action="modificar">

						                  <li class="list-group-item d-flex justify-content-between lh-condensed">

						                    <div>
						                      <table class="table">
						                        <thead>
						                          <tr>
						                            <th><span class="lead">Ingredientes</span></th>
						                            <th><span class="lead">Fecha de vencimiento:</span></th>
						                            <th><span class="lead">Me quedan:</span></th>
						                            <th><span class="lead"></span></th>
						                          </tr>
						                        </thead>
						                        <tbody>

						                          <c:forEach items="${ingrediente.listaIngredientes}" var="i"
						                            varStatus="status">
						                            
						                            <c:if test = "${i.tipo == 'LACTEOS'}">
						                            <tr align="left" >
						                            </c:if>
						                            <c:if test = "${i.tipo == 'VEGETALES'}">
						                            <tr align="left" >
						                            </c:if>
						                            <c:if test = "${i.tipo == 'CARNES'}">
						                            <tr align="left">
						                            </c:if>
						                            <c:if test = "${i.tipo == 'PESCADO'}">
						                            <tr align="left" >
						                            </c:if>
						                            <c:if test = "${i.tipo == 'CONDIMENTOS'}">
						                            <tr align="left">
						                            </c:if>
						                            
						                              <th><span class="lead">${i.nombre}</span></th>
						                              
						                              <c:if test = "${i.perece == 'SEVENCE'}">
						                              <th>
						                              <form:input class="form-control datetimepicker1" autocomplete="off"
						                                  path="listaIngredientes[${status.index}].fvencimiento"
						                                  type="text" /></th> 
						                              </c:if>
						                              <c:if test = "${i.perece == 'SEPUDRE'}">
						                              <th><span class="lead4">${i.fvencimiento}</span><a href="javascript:verDetalle('${i.nombre}','${i.fvencimiento}','${i.fcompra}','${i.dias * -1}');" >Detalle</a></th>
						                           	 <label class="oculto"><form:input class="form-control datetimepicker1" autocomplete="off" 
						                                  path="listaIngredientes[${status.index}].fcompra"
						                                  type="text" /></label>
						                              </c:if>
						                              
						                              <c:if test = "${i.unidad == 'Lts'}">                                
						                              <th>                        
						                                <form:select class="form-control"
						                                  path="listaIngredientes[${status.index}].cantidad">
						                                  <c:forEach var="cantidad" begin="1" end="10">
						                                    <form:option value="${cantidad * 1000}">${cantidad}</form:option>
						                                  </c:forEach>
						                                </form:select>                                
						                              </th>
						                              </c:if>
						                              <c:if test = "${i.unidad == 'Unids'}">                                
						                              <th>                        
						                                <form:select class="form-control"
						                                  path="listaIngredientes[${status.index}].cantidad">
						                                  <c:forEach var="cantidad" begin="1" end="24">
						                                    <form:option value="${cantidad}">${cantidad}</form:option>
						                                  </c:forEach>
						                                </form:select>                                
						                              </th>
						                              </c:if> 
						                              <c:if test = "${i.unidad == 'Grs'}">                                
						                              <th>                        
						                                <form:select class="form-control" path="listaIngredientes[${status.index}].cantidad">
						                                <c:forEach items="${listagramos}" var="g" varStatus="estado">
						                                    <form:option value="${(estado.index + 1)* 50}">${g}</form:option>
						                                </c:forEach>
						                                </form:select>                            
						                              </th>
						                              </c:if> 
						                              <th><a href='javascript:;' onclick="eliminarIngrediente(${i.id},'${i.nombre}','${i.cantidad}','${i.unidad}');"><span
																						class="lead glyphicon glyphicon-trash"></span></a></th>   
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
						                                  
						                              <c:if test = "${i.perece == 'SEVENCE'}">    
						                               <label class="oculto"><form:input
						                                  path="listaIngredientes[${status.index}].fcompra"
						                                  type="text" /></label> 
						                              </c:if>
						                              <c:if test = "${i.perece == 'SEPUDRE'}">    
						                                <label class="oculto"><form:input
						                                  path="listaIngredientes[${status.index}].fvencimiento"
						                                  type="text" /></label>  
						                              </c:if>          
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
													<div id="verDetalle" class="modal fade" tabindex="-1" role="dialog"
														style="overflow-y: scroll;">
														<div class="modal-dialog modal-sm">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close" data-dismiss="modal"
																		aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																	<h3 class="modal-title" id="detalleDeIngre"></h3>
																</div>
																<div class="modal-body">

											                 		 	<div class="table-responsive">
																			<table  class="table table-bordered">
																			<thead>
																			<tr class="active"><h5>Recuerda que calculamos 7 dias para alimentos perecederos.<h5></h5></tr>
																			
																			</thead>
																			<tbody>	
																																  
																			  <tr>
																			  	<td class="active">Estimamos vence:</td>   
																			    <td class="danger"><label id="detalleVence"></label></td>  
																			  </tr>
																			  <tr>               
																			    <td class="active">Comprado el:</td>   
																			    <td class="danger"><label id="detalleComprado"></label></td>
																			  </tr>  
																			  <tr>
																			    <td class="active">Ya lleva:</td>   
																			    <td class="danger"><label id="detalleDias"></label></td>
																			  </tr>
																			  
																			</tbody>
																			</table>
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
    function verDetalle(ingrediente,venci,compra,dias) { 
    	document.getElementById("detalleDeIngre").innerHTML = ingrediente;
    	document.getElementById("detalleVence").innerHTML = venci;
    	document.getElementById("detalleComprado").innerHTML = compra;
    	document.getElementById("detalleDias").innerHTML = dias+" dias";
    	$('#verDetalle').modal('show');
    }
    </script>
    
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
     
     <script type="text/javascript">
     	function eliminarIngrediente(ingrediente,nombre,cantidad,unidad) {		
			var ingre = ingrediente;		
			var nombr = nombre;	
			var cant = cantidad;	
			var unid = unidad;	
			$('#eliminar').attr('href','eliminar-ingrediente-modificar?id='+ingre+'');
			$('#ingred').text(''+nombr+' '+cant+' '+unid+'');		
			$('#ModalCrear').modal('show');

		}
	</script>
</body>
</html>

