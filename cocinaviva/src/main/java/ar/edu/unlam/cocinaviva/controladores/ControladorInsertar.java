package ar.edu.unlam.cocinaviva.controladores;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import ar.edu.unlam.cocinaviva.servicios.ServicioIngrediente;
import ar.edu.unlam.cocinaviva.servicios.ServicioUsuario;

@Controller
public class ControladorInsertar {

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioIngrediente servicioIngrediente;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {

		List<Ingrediente> listaIngrediente = servicioIngrediente.traerTodosLosIngredientes();

		if (listaIngrediente.isEmpty()) {
			return new ModelAndView("redirect:/insertar-ingre-usuarios");
		} else {
			return new ModelAndView("redirect:/home");
		}
	}
	
	@RequestMapping("/insertar-ingre-usuarios")
	public ModelAndView insertarIngreUsuarios() {
		
		Ingrediente manteca = new Ingrediente();
		manteca.setNombre("manteca");
		manteca.setCantidad(0);
		manteca.setGramos(0);
		manteca.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(manteca);
		
		Ingrediente quesofresco = new Ingrediente();
		quesofresco.setNombre("queso fresco");
		quesofresco.setCantidad(0);
		quesofresco.setGramos(0);
		quesofresco.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesofresco);

		Ingrediente huevos = new Ingrediente();
		huevos.setNombre("huevos");
		huevos.setCantidad(0);
		huevos.setGramos(0);
		huevos.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(huevos);
		
		Ingrediente leche = new Ingrediente();
		leche.setNombre("leche");
		leche.setCantidad(0);
		leche.setGramos(0);
		leche.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(leche);
		
		Ingrediente quesoparmesano = new Ingrediente();
		quesoparmesano.setNombre("queso parmesano");
		quesoparmesano.setCantidad(0);
		quesoparmesano.setGramos(0);
		quesoparmesano.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesoparmesano);
		
		Ingrediente quesocheddar = new Ingrediente();
		quesocheddar.setNombre("queso cheddar");
		quesocheddar.setCantidad(0);
		quesocheddar.setGramos(0);
		quesocheddar.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesocheddar);

		Ingrediente quesoamericano = new Ingrediente();
		quesoamericano.setNombre("queso americano");
		quesoamericano.setCantidad(0);
		quesoamericano.setGramos(0);
		quesoamericano.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesoamericano);

		Ingrediente quesocrema = new Ingrediente();
		quesocrema.setNombre("queso crema");
		quesocrema.setCantidad(0);
		quesocrema.setGramos(0);
		quesocrema.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesocrema);
		
		Ingrediente quesomozzarella = new Ingrediente();
		quesomozzarella.setNombre("queso mozzarella");
		quesomozzarella.setCantidad(0);
		quesomozzarella.setGramos(0);
		quesomozzarella.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesomozzarella);
		
		Ingrediente yogurt  = new Ingrediente();
		yogurt.setNombre("yogurt");
		yogurt.setCantidad(0);
		yogurt.setGramos(0);
		yogurt.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(yogurt);
		
		Ingrediente cremadeleche = new Ingrediente();
		cremadeleche.setNombre("crema de leche");
		cremadeleche.setCantidad(0);
		cremadeleche.setGramos(0);
		cremadeleche.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(cremadeleche);

		Ingrediente lechecondensada  = new Ingrediente();
		lechecondensada.setNombre("leche condensada ");
		lechecondensada.setCantidad(0);
		lechecondensada.setGramos(0);
		lechecondensada.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(lechecondensada);

		Ingrediente quesocottage = new Ingrediente();
		quesocottage.setNombre("queso cottage");
		quesocottage.setCantidad(0);
		quesocottage.setGramos(0);
		quesocottage.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesocottage);
		
		Ingrediente quesosuizo = new Ingrediente();
		quesosuizo.setNombre("queso suizo");
		quesosuizo.setCantidad(0);
		quesosuizo.setGramos(0);
		quesosuizo.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesosuizo);
		
		Ingrediente requeson = new Ingrediente();
		requeson.setNombre("requesón");
		requeson.setCantidad(0);
		requeson.setGramos(0);
		requeson.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(requeson);
		
		Ingrediente quesodecabra = new Ingrediente();
		quesodecabra.setNombre("queso de cabra");
		quesodecabra.setCantidad(0);
		quesodecabra.setGramos(0);
		quesodecabra.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesodecabra);

		Ingrediente quesoprovolone = new Ingrediente();
		quesoprovolone.setNombre("queso provolone");
		quesoprovolone.setCantidad(0);
		quesoprovolone.setGramos(0);
		quesoprovolone.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesoprovolone);

		Ingrediente quesoazul = new Ingrediente();
		quesoazul.setNombre("queso azul");
		quesoazul.setCantidad(0);
		quesoazul.setGramos(0);
		quesoazul.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesoazul);
		
		Ingrediente lecheenpolvo = new Ingrediente();
		lecheenpolvo.setNombre("leche en polvo");
		lecheenpolvo.setCantidad(0);
		lecheenpolvo.setGramos(0);
		lecheenpolvo.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(lecheenpolvo);
		
		Ingrediente quesocolby = new Ingrediente();
		quesocolby.setNombre("queso colby");
		quesocolby.setCantidad(0);
		quesocolby.setGramos(0);
		quesocolby.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesocolby);
		
		Ingrediente quesoitaliano = new Ingrediente();
		quesoitaliano.setNombre("queso italiano");
		quesoitaliano.setCantidad(0);
		quesoitaliano.setGramos(0);
		quesoitaliano.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesoitaliano);

		Ingrediente quesosuavegouda = new Ingrediente();
		quesosuavegouda.setNombre("queso suave gouda");
		quesosuavegouda.setCantidad(0);
		quesosuavegouda.setGramos(0);
		quesosuavegouda.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesosuavegouda);

		Ingrediente quesopimienta = new Ingrediente();
		quesopimienta.setNombre("queso pimienta");
		quesopimienta.setCantidad(0);
		quesopimienta.setGramos(0);
		quesopimienta.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesopimienta);
		
		Ingrediente quesobrie = new Ingrediente();
		quesobrie.setNombre("queso brie");
		quesobrie.setCantidad(0);
		quesobrie.setGramos(0);
		quesobrie.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesobrie);
		
		Ingrediente quesomuenster = new Ingrediente();
		quesomuenster.setNombre("queso muenster");
		quesomuenster.setCantidad(0);
		quesomuenster.setGramos(0);
		quesomuenster.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesomuenster);
		
		Ingrediente quesoduro = new Ingrediente();
		quesoduro.setNombre("queso duro");
		quesoduro.setCantidad(0);
		quesoduro.setGramos(0);
		quesoduro.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesoduro);

		Ingrediente quesohavarti = new Ingrediente();
		quesohavarti.setNombre("queso havarti");
		quesohavarti.setCantidad(0);
		quesohavarti.setGramos(0);
		quesohavarti.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(quesohavarti);

		Ingrediente lechedecabra = new Ingrediente();
		lechedecabra.setNombre("leche de cabra");
		lechedecabra.setCantidad(0);
		lechedecabra.setGramos(0);
		lechedecabra.setTipo("LACTEOS");
		servicioIngrediente.guardarIngrediente(lechedecabra);
		
		// VEGETALES
		
		Ingrediente cebolla = new Ingrediente();
		cebolla.setNombre("cebolla");
		cebolla.setCantidad(0);
		cebolla.setGramos(0);
		cebolla.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(cebolla);
		
		Ingrediente ajo = new Ingrediente();
		ajo.setNombre("ajo");
		ajo.setCantidad(0);
		ajo.setGramos(0);
		ajo.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(ajo);
		
		Ingrediente lechuga = new Ingrediente();
		lechuga.setNombre("lechuga");
		lechuga.setCantidad(0);
		lechuga.setGramos(0);
		lechuga.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(lechuga);
		
		Ingrediente tomate = new Ingrediente();
		tomate.setNombre("tomate");
		tomate.setCantidad(0);
		tomate.setGramos(0);
		tomate.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(tomate);
		
		Ingrediente papa = new Ingrediente();
		papa.setNombre("papa");
		papa.setCantidad(0);
		papa.setGramos(0);
		papa.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(papa);
		
		Ingrediente zanahoria = new Ingrediente();
		zanahoria.setNombre("zanahoria");
		zanahoria.setCantidad(0);
		zanahoria.setGramos(0);
		zanahoria.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(zanahoria);
		
		Ingrediente albahaca = new Ingrediente();
		albahaca.setNombre("albahaca");
		albahaca.setCantidad(0);
		albahaca.setGramos(0);
		albahaca.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(albahaca);
		
		Ingrediente perejil = new Ingrediente();
		perejil.setNombre("perejil");
		perejil.setCantidad(0);
		perejil.setGramos(0);
		perejil.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(perejil);
		
		Ingrediente brocoli = new Ingrediente();
		brocoli.setNombre("brócoli");
		brocoli.setCantidad(0);
		brocoli.setGramos(0);
		brocoli.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(brocoli);
		
		Ingrediente maiz = new Ingrediente();
		maiz.setNombre("maíz");
		maiz.setCantidad(0);
		maiz.setGramos(0);
		maiz.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(maiz);
		
		Ingrediente espinacas = new Ingrediente();
		espinacas.setNombre("espinacas");
		espinacas.setCantidad(0);
		espinacas.setGramos(0);
		espinacas.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(espinacas);
		
		Ingrediente jengibre = new Ingrediente();
		jengibre.setNombre("jengibre");
		jengibre.setCantidad(0);
		jengibre.setGramos(0);
		jengibre.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(jengibre);
		
		Ingrediente ajipicante = new Ingrediente();
		ajipicante.setNombre("ají picante");
		ajipicante.setCantidad(0);
		ajipicante.setGramos(0);
		ajipicante.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(ajipicante);
		
		Ingrediente apio = new Ingrediente();
		apio.setNombre("apio");
		apio.setCantidad(0);
		apio.setGramos(0);
		apio.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(apio);
		
		Ingrediente romero = new Ingrediente();
		romero.setNombre("romero");
		romero.setCantidad(0);
		romero.setGramos(0);
		romero.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(romero);
		
		Ingrediente cebollaroja = new Ingrediente();
		cebollaroja.setNombre("cebolla roja");
		cebollaroja.setCantidad(0);
		cebollaroja.setGramos(0);
		cebollaroja.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(cebollaroja);
		
		Ingrediente pepino = new Ingrediente();
		pepino.setNombre("pepino");
		pepino.setCantidad(0);
		pepino.setGramos(0);
		pepino.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(pepino);
		
		Ingrediente batata = new Ingrediente();
		batata.setNombre("batata");
		batata.setCantidad(0);
		batata.setGramos(0);
		batata.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(batata);
		
		Ingrediente calabacin = new Ingrediente();
		calabacin.setNombre("calabacín");
		calabacin.setCantidad(0);
		calabacin.setGramos(0);
		calabacin.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(calabacin);
		
		Ingrediente aceituna = new Ingrediente();
		aceituna.setNombre("aceituna");
		aceituna.setCantidad(0);
		aceituna.setGramos(0);
		aceituna.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(aceituna);
		
		Ingrediente berenjena = new Ingrediente();
		berenjena.setNombre("berenjena");
		berenjena.setCantidad(0);
		berenjena.setGramos(0);
		berenjena.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(berenjena);
		
		Ingrediente remolacha = new Ingrediente();
		remolacha.setNombre("remolacha");
		remolacha.setCantidad(0);
		remolacha.setGramos(0);
		remolacha.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(remolacha);
		
		Ingrediente calabaza = new Ingrediente();
		calabaza.setNombre("calabaza");
		calabaza.setCantidad(0);
		calabaza.setGramos(0);
		calabaza.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(calabaza);
		
		Ingrediente semillasdechia = new Ingrediente();
		semillasdechia.setNombre("semillas de chia");
		semillasdechia.setCantidad(0);
		semillasdechia.setGramos(0);
		semillasdechia.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(semillasdechia);
		
		Ingrediente semillasdelino = new Ingrediente();
		semillasdelino.setNombre("semillas de lino");
		semillasdelino.setCantidad(0);
		semillasdelino.setGramos(0);
		semillasdelino.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(semillasdelino);
		
		Ingrediente brotesdesoja = new Ingrediente();
		brotesdesoja.setNombre("brotes de soja");
		brotesdesoja.setCantidad(0);
		brotesdesoja.setGramos(0);
		brotesdesoja.setTipo("VEGETALES");
		servicioIngrediente.guardarIngrediente(brotesdesoja);
		
		// CARNES
		
		Ingrediente pechugadepollo = new Ingrediente();
		pechugadepollo.setNombre("pechuga de pollo");
		pechugadepollo.setCantidad(0);
		pechugadepollo.setGramos(0);
		pechugadepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(pechugadepollo);
		
		Ingrediente carnechurrasco = new Ingrediente();
		carnechurrasco.setNombre("carne churrasco");
		carnechurrasco.setCantidad(0);
		carnechurrasco.setGramos(0);
		carnechurrasco.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(carnechurrasco);
		
		Ingrediente tocino = new Ingrediente();
		tocino.setNombre("tocino");
		tocino.setCantidad(0);
		tocino.setGramos(0);
		tocino.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(tocino);
		
		Ingrediente salchicha = new Ingrediente();
		salchicha.setNombre("salchicha");
		salchicha.setCantidad(0);
		salchicha.setGramos(0);
		salchicha.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(salchicha);
		
		Ingrediente filetedeternera = new Ingrediente();
		filetedeternera.setNombre("filete de ternera");
		filetedeternera.setCantidad(0);
		filetedeternera.setGramos(0);
		filetedeternera.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(filetedeternera);
		
		Ingrediente jamon = new Ingrediente();
		jamon.setNombre("jamón");
		jamon.setCantidad(0);
		jamon.setGramos(0);
		jamon.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(jamon);
		
		Ingrediente chuletasdecerdo = new Ingrediente();
		chuletasdecerdo.setNombre("chuletas de cerdo");
		chuletasdecerdo.setCantidad(0);
		chuletasdecerdo.setGramos(0);
		chuletasdecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(chuletasdecerdo);
		
		Ingrediente muslosdepollo = new Ingrediente();
		muslosdepollo.setNombre("muslos de pollo");
		muslosdepollo.setCantidad(0);
		muslosdepollo.setGramos(0);
		muslosdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(muslosdepollo);
		
		Ingrediente pavo = new Ingrediente();
		pavo.setNombre("pavo");
		pavo.setCantidad(0);
		pavo.setGramos(0);
		pavo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(pavo);
		
		Ingrediente polloentero = new Ingrediente();
		polloentero.setNombre("polloentero");
		polloentero.setCantidad(0);
		polloentero.setGramos(0);
		polloentero.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(polloentero);
		
		Ingrediente cerdo = new Ingrediente();
		cerdo.setNombre("pechuga de pollo");
		cerdo.setCantidad(0);
		cerdo.setGramos(0);
		cerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(cerdo);
		
		Ingrediente patasdepollo = new Ingrediente();
		patasdepollo.setNombre("patas de pollo");
		patasdepollo.setCantidad(0);
		patasdepollo.setGramos(0);
		patasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(patasdepollo);
		
		Ingrediente carnedecerdo = new Ingrediente();
		carnedecerdo.setNombre("carne de cerdo");
		carnedecerdo.setCantidad(0);
		carnedecerdo.setGramos(0);
		carnedecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(carnedecerdo);
		
		Ingrediente chorizo = new Ingrediente();
		chorizo.setNombre("chorizo");
		chorizo.setCantidad(0);
		chorizo.setGramos(0);
		chorizo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(chorizo);
		
		Ingrediente alitasdepollo = new Ingrediente();
		alitasdepollo.setNombre("alitas de pollo");
		alitasdepollo.setCantidad(0);
		alitasdepollo.setGramos(0);
		alitasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(alitasdepollo);
		
		Ingrediente carneasada = new Ingrediente();
		carneasada.setNombre("carne asada");
		carneasada.setCantidad(0);
		carneasada.setGramos(0);
		carneasada.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(carneasada);
		
		Ingrediente costillasdecerdo = new Ingrediente();
		costillasdecerdo.setNombre("costillas de cerdo");
		costillasdecerdo.setCantidad(0);
		costillasdecerdo.setGramos(0);
		costillasdecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(costillasdecerdo);
		
		Ingrediente cordero = new Ingrediente();
		cordero.setNombre("cordero");
		cordero.setCantidad(0);
		cordero.setGramos(0);
		cordero.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(cordero);
		
		Ingrediente costillasdeternera = new Ingrediente();
		costillasdeternera.setNombre("costillas de ternera");
		costillasdeternera.setCantidad(0);
		costillasdeternera.setGramos(0);
		costillasdeternera.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(costillasdeternera);
		
		Ingrediente pato = new Ingrediente();
		pato.setNombre("pechuga de pollo");
		pato.setCantidad(0);
		pato.setGramos(0);
		pato.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(pato);
		
		Ingrediente menudenciasdepollo = new Ingrediente();
		menudenciasdepollo.setNombre("menudencias de pollo");
		menudenciasdepollo.setCantidad(0);
		menudenciasdepollo.setGramos(0);
		menudenciasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(menudenciasdepollo);
		
		Ingrediente conejo = new Ingrediente();
		conejo.setNombre("conejo");
		conejo.setCantidad(0);
		conejo.setGramos(0);
		conejo.setTipo("CARNES");
		servicioIngrediente.guardarIngrediente(conejo);
		
		// PESCADO
		
		Ingrediente atunenlatado = new Ingrediente();
		atunenlatado.setNombre("atún enlatado");
		atunenlatado.setCantidad(0);
		atunenlatado.setGramos(0);
		atunenlatado.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(atunenlatado);
		
		Ingrediente filetesdepescado = new Ingrediente();
		filetesdepescado.setNombre("filetes de pescado");
		filetesdepescado.setCantidad(0);
		filetesdepescado.setGramos(0);
		filetesdepescado.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(filetesdepescado);
		
		Ingrediente salmon = new Ingrediente();
		salmon.setNombre("salmón");
		salmon.setCantidad(0);
		salmon.setGramos(0);
		salmon.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(salmon);
		
		Ingrediente tilapia = new Ingrediente();
		tilapia.setNombre("tilapia");
		tilapia.setCantidad(0);
		tilapia.setGramos(0);
		tilapia.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(tilapia);
		
		Ingrediente salmonenlatado = new Ingrediente();
		salmonenlatado.setNombre("salmón enlatado");
		salmonenlatado.setCantidad(0);
		salmonenlatado.setGramos(0);
		salmonenlatado.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(salmonenlatado);

		Ingrediente anchoas = new Ingrediente();
		anchoas.setNombre("anchoas");
		anchoas.setCantidad(0);
		anchoas.setGramos(0);
		anchoas.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(anchoas);
		
		Ingrediente salmonahumado = new Ingrediente();
		salmonahumado.setNombre("salmón ahumado");
		salmonahumado.setCantidad(0);
		salmonahumado.setGramos(0);
		salmonahumado.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(salmonahumado);
		
		Ingrediente sardinas = new Ingrediente();
		sardinas.setNombre("sardinas");
		sardinas.setCantidad(0);
		sardinas.setGramos(0);
		sardinas.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(sardinas);
		
		Ingrediente filetedeatun = new Ingrediente();
		filetedeatun.setNombre("filete de atún");
		filetedeatun.setCantidad(0);
		filetedeatun.setGramos(0);
		filetedeatun.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(filetedeatun);
		
		Ingrediente trucha = new Ingrediente();
		trucha.setNombre("trucha");
		trucha.setCantidad(0);
		trucha.setGramos(0);
		trucha.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(trucha);

		Ingrediente bagre = new Ingrediente();
		bagre.setNombre("bagre");
		bagre.setCantidad(0);
		bagre.setGramos(0);
		bagre.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(bagre);
		
		Ingrediente caballa = new Ingrediente();
		caballa.setNombre("caballa");
		caballa.setCantidad(0);
		caballa.setGramos(0);
		caballa.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(caballa);
		
		Ingrediente pezespada = new Ingrediente();
		pezespada.setNombre("pez espada");
		pezespada.setCantidad(0);
		pezespada.setGramos(0);
		pezespada.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(pezespada);
		
		Ingrediente abadejo = new Ingrediente();
		abadejo.setNombre("abadejo");
		abadejo.setCantidad(0);
		abadejo.setGramos(0);
		abadejo.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(abadejo);
		
		Ingrediente caviar = new Ingrediente();
		caviar.setNombre("caviar");
		caviar.setCantidad(0);
		caviar.setGramos(0);
		caviar.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(caviar);

		Ingrediente pezroca = new Ingrediente();
		pezroca.setNombre("pez roca");
		pezroca.setCantidad(0);
		pezroca.setGramos(0);
		pezroca.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(pezroca);
		
		Ingrediente sueladelimon = new Ingrediente();
		sueladelimon.setNombre("suela de limón");
		sueladelimon.setCantidad(0);
		sueladelimon.setGramos(0);
		sueladelimon.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(sueladelimon);
		
		Ingrediente carpa = new Ingrediente();
		carpa.setNombre("carpa");
		carpa.setCantidad(0);
		carpa.setGramos(0);
		carpa.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(carpa);
		
		Ingrediente calamar = new Ingrediente();
		calamar.setNombre("calamar");
		calamar.setCantidad(0);
		calamar.setGramos(0);
		calamar.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(calamar);
		
		Ingrediente cornalitos = new Ingrediente();
		cornalitos.setNombre("cornalitos");
		cornalitos.setCantidad(0);
		cornalitos.setGramos(0);
		cornalitos.setTipo("PESCADO");
		servicioIngrediente.guardarIngrediente(cornalitos);
		
		// CONDIMENTOS
		
		Ingrediente mayonesa = new Ingrediente();
		mayonesa.setNombre("mayonesa");
		mayonesa.setCantidad(0);
		mayonesa.setGramos(0);
		mayonesa.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(mayonesa);
		
		Ingrediente salfina = new Ingrediente();
		salfina.setNombre("sal fina");
		salfina.setCantidad(0);
		salfina.setGramos(0);
		salfina.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salfina);
		
		Ingrediente salsadetomate = new Ingrediente();
		salsadetomate.setNombre("salsa de tomate");
		salsadetomate.setCantidad(0);
		salsadetomate.setGramos(0);
		salsadetomate.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadetomate);
		
		Ingrediente vinagre = new Ingrediente();
		vinagre.setNombre("vinagre");
		vinagre.setCantidad(0);
		vinagre.setGramos(0);
		vinagre.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(vinagre);
		
		Ingrediente salsadesoja = new Ingrediente();
		salsadesoja.setNombre("salsa de soja");
		salsadesoja.setCantidad(0);
		salsadesoja.setGramos(0);
		salsadesoja.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadesoja);
		
		Ingrediente salsapicante = new Ingrediente();
		salsapicante.setNombre("salsa picante");
		salsapicante.setCantidad(0);
		salsapicante.setGramos(0);
		salsapicante.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsapicante);
		
		Ingrediente salsadebarbacoa = new Ingrediente();
		salsadebarbacoa.setNombre("salsa de barbacoa");
		salsadebarbacoa.setCantidad(0);
		salsadebarbacoa.setGramos(0);
		salsadebarbacoa.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadebarbacoa);
		
		Ingrediente aderezoranch = new Ingrediente();
		aderezoranch.setNombre("aderezo ranch");
		aderezoranch.setCantidad(0);
		aderezoranch.setGramos(0);
		aderezoranch.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(aderezoranch);
		
		Ingrediente vinagredesidrademanzana = new Ingrediente();
		vinagredesidrademanzana.setNombre("vinagre de sidra de manzana ");
		vinagredesidrademanzana.setCantidad(0);
		vinagredesidrademanzana.setGramos(0);
		vinagredesidrademanzana.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(vinagredesidrademanzana);
		
		Ingrediente vinagredevino = new Ingrediente();
		vinagredevino.setNombre("vinagre de vino");
		vinagredevino.setCantidad(0);
		vinagredevino.setGramos(0);
		vinagredevino.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(vinagredevino);
		
		Ingrediente vinagredearroz = new Ingrediente();
		vinagredearroz.setNombre("vinagre de arroz");
		vinagredearroz.setCantidad(0);
		vinagredearroz.setGramos(0);
		vinagredearroz.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(vinagredearroz);
		
		Ingrediente aderezoparaensaladas = new Ingrediente();
		aderezoparaensaladas.setNombre("aderezo para ensaladas");
		aderezoparaensaladas.setCantidad(0);
		aderezoparaensaladas.setGramos(0);
		aderezoparaensaladas.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(aderezoparaensaladas);
		
		Ingrediente tabasco = new Ingrediente();
		tabasco.setNombre("tabasco");
		tabasco.setCantidad(0);
		tabasco.setGramos(0);
		tabasco.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(tabasco);
		
		Ingrediente salsadepescado = new Ingrediente();
		salsadepescado.setNombre("salsa de pescado");
		salsadepescado.setCantidad(0);
		salsadepescado.setGramos(0);
		salsadepescado.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadepescado);
		
		Ingrediente miel = new Ingrediente();
		miel.setNombre("miel");
		miel.setCantidad(0);
		miel.setGramos(0);
		miel.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(miel);
		
		Ingrediente mostaza = new Ingrediente();
		mostaza.setNombre("mostaza");
		mostaza.setCantidad(0);
		mostaza.setGramos(0);
		mostaza.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(mostaza);
		
		Ingrediente salsatartara = new Ingrediente();
		salsatartara.setNombre("salsa tártara");
		salsatartara.setCantidad(0);
		salsatartara.setGramos(0);
		salsatartara.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsatartara);
		
		Ingrediente salsadecoctel = new Ingrediente();
		salsadecoctel.setNombre("salsa de cóctel");
		salsadecoctel.setCantidad(0);
		salsadecoctel.setGramos(0);
		salsadecoctel.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadecoctel);
		
		Ingrediente marsala = new Ingrediente();
		marsala.setNombre("marsala");
		marsala.setCantidad(0);
		marsala.setGramos(0);
		marsala.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(marsala);
		
		Ingrediente salsadeadobo = new Ingrediente();
		salsadeadobo.setNombre("salsa de adobo");
		salsadeadobo.setCantidad(0);
		salsadeadobo.setGramos(0);
		salsadeadobo.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadeadobo);
		
		Ingrediente ketchup = new Ingrediente();
		ketchup.setNombre("ketchup");
		ketchup.setCantidad(0);
		ketchup.setGramos(0);
		ketchup.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(ketchup);
		
		Ingrediente aderezodesesamo = new Ingrediente();
		aderezodesesamo.setNombre("aderezo de sésamo");
		aderezodesesamo.setCantidad(0);
		aderezodesesamo.setGramos(0);
		aderezodesesamo.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(aderezodesesamo);
		
		Ingrediente ponzu = new Ingrediente();
		ponzu.setNombre("ponzu");
		ponzu.setCantidad(0);
		ponzu.setGramos(0);
		ponzu.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(ponzu);
		
		Ingrediente salsadepato = new Ingrediente();
		salsadepato.setNombre("salsa de pato");
		salsadepato.setCantidad(0);
		salsadepato.setGramos(0);
		salsadepato.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadepato);
		
		Ingrediente salsapickapeppa = new Ingrediente();
		salsapickapeppa.setNombre("salsa pickapeppa");
		salsapickapeppa.setCantidad(0);
		salsapickapeppa.setGramos(0);
		salsapickapeppa.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsapickapeppa);
		
		Ingrediente jugodeyuzu = new Ingrediente();
		jugodeyuzu.setNombre("jugo de yuzu");
		jugodeyuzu.setCantidad(0);
		jugodeyuzu.setGramos(0);
		jugodeyuzu.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(jugodeyuzu);
		
		Ingrediente salsadecrema = new Ingrediente();
		salsadecrema.setNombre("salsa de crema");
		salsadecrema.setCantidad(0);
		salsadecrema.setGramos(0);
		salsadecrema.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngrediente(salsadecrema);
		
		// Usuarios
			
		Usuario matias = new Usuario();
		matias.setNombre("Matias");
		matias.setApellido("Rivero");
		matias.setAlias("Mati");
		matias.setEmail("matias@gmail.com");
		matias.setPassword("12345");
		matias.setRepassword("12345");
		matias.setRol("Usuario");
		
		Ingrediente ttomate = servicioIngrediente.buscarIngrediente("tomate");
		List<Ingrediente> ingredienteusuariomatias = new LinkedList<Ingrediente>();
		ingredienteusuariomatias.add(ttomate);
		ingredienteusuariomatias.add(lechuga);
		ingredienteusuariomatias.add(ketchup);
		ingredienteusuariomatias.add(mostaza);
		ingredienteusuariomatias.add(berenjena);
		ingredienteusuariomatias.add(pechugadepollo);
		
		matias.setListaIngrediente(ingredienteusuariomatias);
			
		servicioUsuario.guardarUsuario(matias);
		
		Usuario juanpablo = new Usuario();
		juanpablo.setNombre("Juan Pablo");
		juanpablo.setApellido("Ramirez");
		juanpablo.setAlias("Juampi");
		juanpablo.setEmail("gopaka.94@gmail.com");
		juanpablo.setPassword("12345");
		juanpablo.setRepassword("12345");
		juanpablo.setRol("Usuario");
		servicioUsuario.guardarUsuario(juanpablo);
		
		Usuario flor = new Usuario();
		flor.setNombre("Florencia");
		flor.setApellido("Alvarez");
		flor.setAlias("Flor");
		flor.setEmail("floor.alvarez@gmail.com");
		flor.setPassword("12345");
		flor.setRepassword("12345");
		flor.setRol("Usuario");
		servicioUsuario.guardarUsuario(flor);
		
		// Administrador
		
		Usuario admin = new Usuario();
		admin.setNombre("Jose");
		admin.setApellido("Perez");
		admin.setAlias("Jperez");
		admin.setEmail("administrador@gmail.com");
		admin.setPassword("12345");
		admin.setRepassword("12345");
		admin.setRol("Administrador");
		servicioUsuario.guardarAdministrador(admin);

		return new ModelAndView("redirect:/home");
	}

}
