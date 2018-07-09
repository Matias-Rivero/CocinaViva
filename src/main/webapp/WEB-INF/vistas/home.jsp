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
									<h1>Cocina con tus ingredientes!</h1>
								</div>
								<div class="row">
									<div class="col-md-12 order-md-12 mb-12">
										<ul class="list-group mb-3">
											<li
												class="list-group-item d-flex justify-content-between lh-condensed">

												<div class="input-group">
													<span class="input-group-addon">Usar</span> <input
														type="text" id="filtrar" class="form-control"
														placeholder="pure de tomate">
												</div>
											</li>
										</ul>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<ul class="list-group mb-3 alturaulicon">

										

												
											<li><label class="pull-left iconos">Cambiar<a href="modificar"><input type=image src="images/modificar2.jpg" alt="mas" class="img-rounded img-responsive" /></a></label></li>	
											<li><label class="pull-left iconos">Agregar<a href="ingredientes"><input type=image src="images/mas.jpg" alt="mas" class="img-rounded img-responsive" /></a></label></li>	
											<li><label class="pull-left iconos">Todos<a href="javascript:seleccionarTodos();" id="todos"><input type=image src="images/cale.jpg" alt="mas" class="img-rounded img-responsive" /></a></label></li>
											<li><label id="iconbusc" class="pull-left iconos">Buscar<a onclick="validaEnvia();"><input type=image src="images/play2.jpg" alt="BUSCAR RECETA" class="img-rounded img-responsive"></a></label></li>
											<c:if test="${not empty exitomodificar}"><li>${exitomodificar}</li></c:if>
												
											
										
										</ul>
										
									
										
												
									</div>	
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<ul class="list-group mb-3">
											<form:form name="confirform" method="POST"
												modelAttribute="checkingredientes" action="recetas">
												<c:choose>
													<c:when test="${not empty ingredienteslacteosdelusuario}">
														<li
															class="list-group-item d-flex justify-content-between lh-condensed">
															<div class="table-responsive">
																<table class="table table-hover">
																	<thead>
																		<tr>
																			<th><span class="lead"><strong>Lacteos</strong></span></th>
																			<th><span class="lead colorverde">Estado</span></th>
																			<th><span class="lead"></span></th>
																			<th><span class="lead">Cantidad</span></th>
																			<th><span class="lead">Fecha de:</span></th>
																		</tr>
																	</thead>
																	<tbody class="buscar">
																		<c:forEach items="${ingredienteslacteosdelusuario}"
																			var="ingredientes">
																			<tr align="left">
																				<c:if test="${ingredientes.estado != 'VENCIDO'}">
																					<td><span class="lead"><form:checkbox
																								path="seleccionados" value="${ingredientes.id}"
																								class="check" />${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td><span class="lead"><input
																							type="checkbox" value="disabled" disabled>${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'NOVENCIDO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVENCER'}">
																					<td class="danger"><label
																						class="label label-warning">Por vencer</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'SINAVISO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVISO'}">
																					<td class="warning"><label
																						class="label label-warning">Mas de 10 dias</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td class="danger"><label
																						class="label label-danger">Vencido</label></td>
																				</c:if>

																				<td><a href='javascript:;'
																					onclick="eliminarIngrediente(${ingredientes.id},'${ingredientes.nombre}','${ingredientes.cantidad}','${ingredientes.unidad}');"><span
																						class="lead glyphicon glyphicon-trash"></span></a></td>

																				<td><span class="lead4">${ingredientes.cantidad}</span>
																					<c:if test="${ingredientes.unidad == 'Lts'}">
																						<label>Litros</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Grs'}">
																						<label>Gramos</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Unids'}">
																						<label>Unidades</label>
																					</c:if></td>

																				<c:if test="${ingredientes.perece == 'SEVENCE'}">
																					<td><span class="lead4">${ingredientes.fvencimiento}</span><label><strong>Vencimiento</strong></label></td>
																				</c:if>
																				<c:if test="${ingredientes.perece == 'SEPUDRE'}">
																					<td><span class="lead4">${ingredientes.fcompra}</span><label><strong>Compra</strong></label></td>
																				</c:if>
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
																<table class="table table-hover">
																	<thead>
																		<tr>
																			<th><span class="lead"><strong>Vegetales</strong></span></th>
																			<th><span class="lead colorverde">Estado</span></th>
																			<th><span class="lead"></span></th>
																			<th><span class="lead">Cantidad</span></th>
																			<th><span class="lead">Fecha de:</span></th>
																		</tr>
																	</thead>
																	<tbody class="buscar">
																		<c:forEach items="${ingredientesvegetalesdelusuario}"
																			var="ingredientes">
																			<tr align="left">
																				<c:if test="${ingredientes.estado != 'VENCIDO'}">
																					<td><span class="lead"><form:checkbox
																								path="seleccionados" value="${ingredientes.id}"
																								class="check" />${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td><span class="lead"><input
																							type="checkbox" value="disabled" disabled>${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'NOVENCIDO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVENCER'}">
																					<td class="danger"><label
																						class="label label-warning">Por vencer</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'SINAVISO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVISO'}">
																					<td class="warning"><label
																						class="label label-warning">Mas de 10 dias</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td class="danger"><label
																						class="label label-danger">Vencido</label></td>
																				</c:if>

																				<td><a href='javascript:;'
																					onclick="eliminarIngrediente(${ingredientes.id},'${ingredientes.nombre}','${ingredientes.cantidad}','${ingredientes.unidad}');"><span
																						class="lead glyphicon glyphicon-trash"></span></a></td>

																				<td><span class="lead4">${ingredientes.cantidad}</span>
																					<c:if test="${ingredientes.unidad == 'Lts'}">
																						<label>Litros</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Grs'}">
																						<label>Gramos</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Unids'}">
																						<label>Unidades</label>
																					</c:if></td>

																				<c:if test="${ingredientes.perece == 'SEVENCE'}">
																					<td><span class="lead4">${ingredientes.fvencimiento}</span><label><strong>Vencimiento</strong></label></td>
																				</c:if>
																				<c:if test="${ingredientes.perece == 'SEPUDRE'}">
																					<td><span class="lead4">${ingredientes.fcompra}</span><label><strong>Compra</strong></label></td>
																				</c:if>
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
																<table class="table table-hover">
																	<thead>
																		<tr>
																			<th><span class="lead"><strong>Carnes</strong></span></th>
																			<th><span class="lead colorverde">Estado</span></th>
																			<th><span class="lead"></span></th>
																			<th><span class="lead">Cantidad</span></th>
																			<th><span class="lead">Fecha de:</span></th>
																		</tr>
																	</thead>
																	<tbody class="buscar">
																		<c:forEach items="${ingredientescarnesdelusuario}"
																			var="ingredientes">
																			<tr align="left">
																				<c:if test="${ingredientes.estado != 'VENCIDO'}">
																					<td><span class="lead"><form:checkbox
																								path="seleccionados" value="${ingredientes.id}"
																								class="check" />${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td><span class="lead"><input
																							type="checkbox" value="disabled" disabled>${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'NOVENCIDO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVENCER'}">
																					<td class="danger"><label
																						class="label label-warning">Por vencer</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'SINAVISO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVISO'}">
																					<td class="warning"><label
																						class="label label-warning">Mas de 10 dias</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td class="danger"><label
																						class="label label-danger">Vencido</label></td>
																				</c:if>

																				<td><a href='javascript:;'
																					onclick="eliminarIngrediente(${ingredientes.id},'${ingredientes.nombre}','${ingredientes.cantidad}','${ingredientes.unidad}');"><span
																						class="lead glyphicon glyphicon-trash"></span></a></td>

																				<td><span class="lead4">${ingredientes.cantidad}</span>
																					<c:if test="${ingredientes.unidad == 'Lts'}">
																						<label>Litros</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Grs'}">
																						<label>Gramos</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Unids'}">
																						<label>Unidades</label>
																					</c:if></td>

																				<c:if test="${ingredientes.perece == 'SEVENCE'}">
																					<td><span class="lead4">${ingredientes.fvencimiento}</span><label><strong>Vencimiento</strong></label></td>
																				</c:if>
																				<c:if test="${ingredientes.perece == 'SEPUDRE'}">
																					<td><span class="lead4">${ingredientes.fcompra}</span><label><strong>Compra</strong></label></td>
																				</c:if>
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
																<table class="table table-hover">
																	<thead>
																		<tr>
																			<th><span class="lead"><strong>Pescado</strong></span></th>
																			<th><span class="lead colorverde">Estado</span></th>
																			<th><span class="lead"></span></th>
																			<th><span class="lead">Cantidad</span></th>
																			<th><span class="lead">Fecha de:</span></th>
																		</tr>
																	</thead>
																	<tbody class="buscar">
																		<c:forEach items="${ingredientespescadodelusuario}"
																			var="ingredientes">
																			<tr align="left">
																				<c:if test="${ingredientes.estado != 'VENCIDO'}">
																					<td><span class="lead"><form:checkbox
																								path="seleccionados" value="${ingredientes.id}"
																								class="check" />${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td><span class="lead"><input
																							type="checkbox" value="disabled" disabled>${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'NOVENCIDO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVENCER'}">
																					<td class="danger"><label
																						class="label label-warning">Por vencer</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'SINAVISO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVISO'}">
																					<td class="warning"><label
																						class="label label-warning">Mas de 10 dias</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td class="danger"><label
																						class="label label-danger">Vencido</label></td>
																				</c:if>

																				<td><a href='javascript:;'
																					onclick="eliminarIngrediente(${ingredientes.id},'${ingredientes.nombre}','${ingredientes.cantidad}','${ingredientes.unidad}');"><span
																						class="lead glyphicon glyphicon-trash"></span></a></td>

																				<td><span class="lead4">${ingredientes.cantidad}</span>
																					<c:if test="${ingredientes.unidad == 'Lts'}">
																						<label>Litros</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Grs'}">
																						<label>Gramos</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Unids'}">
																						<label>Unidades</label>
																					</c:if></td>

																				<c:if test="${ingredientes.perece == 'SEVENCE'}">
																					<td><span class="lead4">${ingredientes.fvencimiento}</span><label><strong>Vencimiento</strong></label></td>
																				</c:if>
																				<c:if test="${ingredientes.perece == 'SEPUDRE'}">
																					<td><span class="lead4">${ingredientes.fcompra}</span><label><strong>Compra</strong></label></td>
																				</c:if>
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
																<table class="table table-hover">
																	<thead>
																		<tr>
																			<th><span class="lead"><strong>Condimento</strong></span></th>
																			<th><span class="lead colorverde">Estado</span></th>
																			<th><span class="lead"></span></th>
																			<th><span class="lead">Cantidad</span></th>
																			<th><span class="lead">Fecha de:</span></th>
																		</tr>
																	</thead>
																	<tbody class="buscar">
																		<c:forEach items="${ingredientescondimentodelusuario}"
																			var="ingredientes">
																			<tr align="left">
																				<c:if test="${ingredientes.estado != 'VENCIDO'}">
																					<td><span class="lead"><form:checkbox
																								path="seleccionados" value="${ingredientes.id}"
																								class="check" />${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td><span class="lead"><input
																							type="checkbox" value="disabled" disabled>${ingredientes.nombre}</span></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'NOVENCIDO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVENCER'}">
																					<td class="danger"><label
																						class="label label-warning">Por vencer</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'SINAVISO'}">
																					<td class="success"><label
																						class="label label-success">Usable</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'AVISO'}">
																					<td class="warning"><label
																						class="label label-warning">Mas de 10 dias</label></td>
																				</c:if>
																				<c:if test="${ingredientes.estado == 'VENCIDO'}">
																					<td class="danger"><label
																						class="label label-danger">Vencido</label></td>
																				</c:if>

																				<td><a href='javascript:;'
																					onclick="eliminarIngrediente(${ingredientes.id},'${ingredientes.nombre}','${ingredientes.cantidad}','${ingredientes.unidad}');"><span
																						class="lead glyphicon glyphicon-trash"></span></a></td>

																				<td><span class="lead4">${ingredientes.cantidad}</span>
																					<c:if test="${ingredientes.unidad == 'Lts'}">
																						<label>Litros</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Grs'}">
																						<label>Gramos</label>
																					</c:if> <c:if test="${ingredientes.unidad == 'Unids'}">
																						<label>Unidades</label>
																					</c:if></td>

																				<c:if test="${ingredientes.perece == 'SEVENCE'}">
																					<td><span class="lead4">${ingredientes.fvencimiento}</span><label><strong>Vencimiento</strong></label></td>
																				</c:if>
																				<c:if test="${ingredientes.perece == 'SEPUDRE'}">
																					<td><span class="lead4">${ingredientes.fcompra}</span><label><strong>Compra</strong></label></td>
																				</c:if>
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
									</div>									
								</div>


							</div>
						</div>
					</c:when>
				</c:choose>

			</c:when>
			<c:otherwise>
				<header id="gtco-header" class="gtco-cover gtco-cover-md"
					role="banner" style="background-image: url(images/lareceta.jpg)"
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
		<div id="Selecciona" class="modal fade" tabindex="-1" role="dialog"
			style="overflow-y: scroll;">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<div class="alert alert-danger" role="alert">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h3>Por favor, primero selecciona los ingredientes a usar</h3>
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
		function buscarreceta() {

			var capa = document.getElementById("buscarreceta");
			capa.click();

		}

		function agregaringre() {

			var capa = document.getElementById("agregaringre");
			capa.click();

		}
		
		function eliminarIngrediente(ingrediente,nombre,cantidad,unidad) {		
			var ingre = ingrediente;		
			var nombr = nombre;	
			var cant = cantidad;	
			var unid = unidad;	
			$('#eliminar').attr('href','eliminar-ingrediente?id='+ingre+'');
			$('#ingred').text(''+nombr+' '+cant+' '+unid+'');		
			$('#ModalCrear').modal('show');

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

	<script type="text/javascript">
	function seleccionarTodos() {
		
        $(".check").each(function(){
        	 if ($(this).is(':checked')) {         	 	
       $(this).prop('checked',false);     
        }else{
       $(this).prop('checked',true);        
       $( "#iconbusc" ).focus();
   		 }
        });
    
	}
	</script>
	<script type="text/javascript">
  function validaEnvia() {
   var no = "no"; 
        $(".check").each(function(){
           if ($(this).is(':checked')) {   
          no = "si";         
        }
        });

        if(no == "no") { 
              $('#Selecciona').modal('show'); 
            }else{
              buscarreceta();
            }                
  }
  </script>
</body>
</html>

