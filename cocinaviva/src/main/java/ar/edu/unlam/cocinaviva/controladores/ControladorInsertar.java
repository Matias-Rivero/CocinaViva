package ar.edu.unlam.cocinaviva.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Receta;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import ar.edu.unlam.cocinaviva.servicios.ServicioIngrediente;
import ar.edu.unlam.cocinaviva.servicios.ServicioReceta;
import ar.edu.unlam.cocinaviva.servicios.ServicioUsuario;

@Controller
public class ControladorInsertar {

	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioReceta servicioReceta;

	@Inject
	private ServicioIngrediente servicioIngrediente;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {

		List<Ingrediente> listaIngrediente = servicioIngrediente.traerTodosLosIngredientes();
		List<Usuario> listaUsuario = servicioUsuario.traerTodosLosUsuarios();
		if (listaIngrediente.isEmpty()) {
			return new ModelAndView("redirect:/insertar-ingredientes");
		}else if(listaUsuario.isEmpty()){
			return new ModelAndView("redirect:/insertar-usuarios");
		} else if(listaUsuario.get(0).getlistaIngrediente().isEmpty()){
			return new ModelAndView("redirect:/insertar-ingre-usuarios");
		} 
		
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping("/insertar-ingredientes")
	public ModelAndView insertarIngredientes() {
		// Lts Grs Unids
		Ingrediente manteca = new Ingrediente();
		manteca.setNombre("manteca");
		manteca.setTipo("LACTEOS");
		manteca.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(manteca);
		
		Ingrediente quesofresco = new Ingrediente();
		quesofresco.setNombre("queso fresco");
		quesofresco.setTipo("LACTEOS");
		quesofresco.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesofresco);

		Ingrediente huevos = new Ingrediente();
		huevos.setNombre("huevos");
		huevos.setTipo("LACTEOS");
		huevos.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(huevos);
		
		Ingrediente leche = new Ingrediente();
		leche.setNombre("leche");
		leche.setTipo("LACTEOS");
		leche.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(leche);
		
		Ingrediente quesoparmesano = new Ingrediente();
		quesoparmesano.setNombre("queso parmesano");
		quesoparmesano.setTipo("LACTEOS");
		quesoparmesano.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoparmesano);
		
		Ingrediente quesocheddar = new Ingrediente();
		quesocheddar.setNombre("queso cheddar");
		quesocheddar.setTipo("LACTEOS");
		quesocheddar.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocheddar);

		Ingrediente quesoamericano = new Ingrediente();
		quesoamericano.setNombre("queso americano");
		quesoamericano.setTipo("LACTEOS");
		quesoamericano.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoamericano);

		Ingrediente quesocrema = new Ingrediente();
		quesocrema.setNombre("queso crema");
		quesocrema.setTipo("LACTEOS");
		quesocrema.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocrema);
		
		Ingrediente quesomozzarella = new Ingrediente();
		quesomozzarella.setNombre("queso mozzarella");
		quesomozzarella.setTipo("LACTEOS");
		quesomozzarella.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesomozzarella);
		
		Ingrediente yogurt  = new Ingrediente();
		yogurt.setNombre("yogurt");
		yogurt.setTipo("LACTEOS");
		yogurt.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(yogurt);
		
		Ingrediente cremadeleche = new Ingrediente();
		cremadeleche.setNombre("crema de leche");
		cremadeleche.setTipo("LACTEOS");
		cremadeleche.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(cremadeleche);

		Ingrediente lechecondensada  = new Ingrediente();
		lechecondensada.setNombre("leche condensada ");
		lechecondensada.setTipo("LACTEOS");
		lechecondensada.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(lechecondensada);

		Ingrediente quesocottage = new Ingrediente();
		quesocottage.setNombre("queso cottage");
		quesocottage.setTipo("LACTEOS");
		quesocottage.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocottage);
		
		Ingrediente quesosuizo = new Ingrediente();
		quesosuizo.setNombre("queso suizo");
		quesosuizo.setTipo("LACTEOS");
		quesosuizo.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesosuizo);
		
		Ingrediente requeson = new Ingrediente();
		requeson.setNombre("requesón");
		requeson.setTipo("LACTEOS");
		requeson.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(requeson);
		
		Ingrediente quesodecabra = new Ingrediente();
		quesodecabra.setNombre("queso de cabra");
		quesodecabra.setTipo("LACTEOS");
		quesodecabra.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesodecabra);

		Ingrediente quesoprovolone = new Ingrediente();
		quesoprovolone.setNombre("queso provolone");
		quesoprovolone.setTipo("LACTEOS");
		quesoprovolone.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoprovolone);

		Ingrediente quesoazul = new Ingrediente();
		quesoazul.setNombre("queso azul");
		quesoazul.setTipo("LACTEOS");
		quesoazul.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoazul);
		
		Ingrediente lecheenpolvo = new Ingrediente();
		lecheenpolvo.setNombre("leche en polvo");
		lecheenpolvo.setTipo("LACTEOS");
		lecheenpolvo.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(lecheenpolvo);
		
		Ingrediente quesocolby = new Ingrediente();
		quesocolby.setNombre("queso colby");
		quesocolby.setTipo("LACTEOS");
		quesocolby.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocolby);
		
		Ingrediente quesoitaliano = new Ingrediente();
		quesoitaliano.setNombre("queso italiano");
		quesoitaliano.setTipo("LACTEOS");
		quesoitaliano.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoitaliano);

		Ingrediente quesosuavegouda = new Ingrediente();
		quesosuavegouda.setNombre("queso suave gouda");
		quesosuavegouda.setTipo("LACTEOS");
		quesosuavegouda.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesosuavegouda);

		Ingrediente quesopimienta = new Ingrediente();
		quesopimienta.setNombre("queso pimienta");
		quesopimienta.setTipo("LACTEOS");
		quesopimienta.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesopimienta);
		
		Ingrediente quesobrie = new Ingrediente();
		quesobrie.setNombre("queso brie");
		quesobrie.setTipo("LACTEOS");
		quesobrie.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesobrie);
		
		Ingrediente quesomuenster = new Ingrediente();
		quesomuenster.setNombre("queso muenster");
		quesomuenster.setTipo("LACTEOS");
		quesomuenster.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesomuenster);
		
		Ingrediente quesoduro = new Ingrediente();
		quesoduro.setNombre("queso duro");
		quesoduro.setTipo("LACTEOS");
		quesoduro.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoduro);

		Ingrediente quesohavarti = new Ingrediente();
		quesohavarti.setNombre("queso havarti");
		quesohavarti.setTipo("LACTEOS");
		quesohavarti.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesohavarti);

		Ingrediente lechedecabra = new Ingrediente();
		lechedecabra.setNombre("leche de cabra");
		lechedecabra.setTipo("LACTEOS");
		lechedecabra.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(lechedecabra);
		
		// VEGETALES // Lts Grs Unids
		
		Ingrediente cebolla = new Ingrediente();
		cebolla.setNombre("cebolla");
		cebolla.setTipo("VEGETALES");
		cebolla.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(cebolla);
		
		Ingrediente ajo = new Ingrediente();
		ajo.setNombre("ajo");
		ajo.setTipo("VEGETALES");
		ajo.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(ajo);
		
		Ingrediente lechuga = new Ingrediente();
		lechuga.setNombre("lechuga");
		lechuga.setTipo("VEGETALES");
		lechuga.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(lechuga);
		
		Ingrediente tomate = new Ingrediente();
		tomate.setNombre("tomate");
		tomate.setTipo("VEGETALES");
		tomate.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(tomate);
		
		Ingrediente papa = new Ingrediente();
		papa.setNombre("papa");
		papa.setTipo("VEGETALES");
		papa.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(papa);
		
		Ingrediente zanahoria = new Ingrediente();
		zanahoria.setNombre("zanahoria");
		zanahoria.setTipo("VEGETALES");
		zanahoria.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(zanahoria);
		
		Ingrediente albahaca = new Ingrediente();
		albahaca.setNombre("albahaca");
		albahaca.setTipo("VEGETALES");
		albahaca.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(albahaca);
		
		Ingrediente perejil = new Ingrediente();
		perejil.setNombre("perejil");
		perejil.setTipo("VEGETALES");
		perejil.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(perejil);
		
		Ingrediente brocoli = new Ingrediente();
		brocoli.setNombre("brócoli");
		brocoli.setTipo("VEGETALES");
		brocoli.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(brocoli);
		
		Ingrediente maiz = new Ingrediente();
		maiz.setNombre("maíz");
		maiz.setTipo("VEGETALES");
		maiz.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(maiz);
		
		Ingrediente espinacas = new Ingrediente();
		espinacas.setNombre("espinacas");
		espinacas.setTipo("VEGETALES");
		espinacas.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(espinacas);
		
		Ingrediente jengibre = new Ingrediente();
		jengibre.setNombre("jengibre");
		jengibre.setTipo("VEGETALES");
		jengibre.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(jengibre);
		
		Ingrediente ajipicante = new Ingrediente();
		ajipicante.setNombre("ají picante");
		ajipicante.setTipo("VEGETALES");
		ajipicante.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(ajipicante);
		
		Ingrediente apio = new Ingrediente();
		apio.setNombre("apio");
		apio.setTipo("VEGETALES");
		apio.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(apio);
		
		Ingrediente romero = new Ingrediente();
		romero.setNombre("romero");
		romero.setTipo("VEGETALES");
		romero.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(romero);
		
		Ingrediente cebollaroja = new Ingrediente();
		cebollaroja.setNombre("cebolla roja");
		cebollaroja.setTipo("VEGETALES");
		cebollaroja.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(cebollaroja);
		
		Ingrediente pepino = new Ingrediente();
		pepino.setNombre("pepino");
		pepino.setTipo("VEGETALES");
		pepino.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(pepino);
		
		Ingrediente batata = new Ingrediente();
		batata.setNombre("batata");
		batata.setTipo("VEGETALES");
		batata.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(batata);
		
		Ingrediente calabacin = new Ingrediente();
		calabacin.setNombre("calabacín");
		calabacin.setTipo("VEGETALES");
		calabacin.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(calabacin);
		
		Ingrediente aceituna = new Ingrediente();
		aceituna.setNombre("aceituna");
		aceituna.setTipo("VEGETALES");
		aceituna.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(aceituna);
		
		Ingrediente berenjena = new Ingrediente();
		berenjena.setNombre("berenjena");
		berenjena.setTipo("VEGETALES");
		berenjena.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(berenjena);
		
		Ingrediente remolacha = new Ingrediente();
		remolacha.setNombre("remolacha");
		remolacha.setTipo("VEGETALES");
		remolacha.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(remolacha);
		
		Ingrediente calabaza = new Ingrediente();
		calabaza.setNombre("calabaza");
		calabaza.setTipo("VEGETALES");
		calabaza.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(calabaza);
		
		Ingrediente semillasdechia = new Ingrediente();
		semillasdechia.setNombre("semillas de chia");
		semillasdechia.setTipo("VEGETALES");
		semillasdechia.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(semillasdechia);
		
		Ingrediente semillasdelino = new Ingrediente();
		semillasdelino.setNombre("semillas de lino");
		semillasdelino.setTipo("VEGETALES");
		semillasdelino.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(semillasdelino);
		
		Ingrediente brotesdesoja = new Ingrediente();
		brotesdesoja.setNombre("brotes de soja");
		brotesdesoja.setTipo("VEGETALES");
		brotesdesoja.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(brotesdesoja);
		
		// CARNES
		
		Ingrediente pechugadepollo = new Ingrediente();
		pechugadepollo.setNombre("pechuga de pollo");
		pechugadepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(pechugadepollo);
		
		Ingrediente carnechurrasco = new Ingrediente();
		carnechurrasco.setNombre("carne churrasco");
		carnechurrasco.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(carnechurrasco);
		
		Ingrediente tocino = new Ingrediente();
		tocino.setNombre("tocino");
		tocino.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(tocino);
		
		Ingrediente salchicha = new Ingrediente();
		salchicha.setNombre("salchicha");
		salchicha.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(salchicha);
		
		Ingrediente filetedeternera = new Ingrediente();
		filetedeternera.setNombre("filete de ternera");
		filetedeternera.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(filetedeternera);
		
		Ingrediente jamon = new Ingrediente();
		jamon.setNombre("jamón");
		jamon.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(jamon);
		
		Ingrediente chuletasdecerdo = new Ingrediente();
		chuletasdecerdo.setNombre("chuletas de cerdo");
		chuletasdecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(chuletasdecerdo);
		
		Ingrediente muslosdepollo = new Ingrediente();
		muslosdepollo.setNombre("muslos de pollo");
		muslosdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(muslosdepollo);
		
		Ingrediente pavo = new Ingrediente();
		pavo.setNombre("pavo");
		pavo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(pavo);
		
		Ingrediente polloentero = new Ingrediente();
		polloentero.setNombre("pollo entero");
		polloentero.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(polloentero);
		
		Ingrediente cerdo = new Ingrediente();
		cerdo.setNombre("cerdo");
		cerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(cerdo);
		
		Ingrediente patasdepollo = new Ingrediente();
		patasdepollo.setNombre("patas de pollo");
		patasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(patasdepollo);
		
		Ingrediente carnedecerdo = new Ingrediente();
		carnedecerdo.setNombre("carne de cerdo");
		carnedecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(carnedecerdo);
		
		Ingrediente chorizo = new Ingrediente();
		chorizo.setNombre("chorizo");
		chorizo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(chorizo);
		
		Ingrediente alitasdepollo = new Ingrediente();
		alitasdepollo.setNombre("alitas de pollo");
		alitasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(alitasdepollo);
		
		Ingrediente carneasada = new Ingrediente();
		carneasada.setNombre("carne asada");
		carneasada.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(carneasada);
		
		Ingrediente costillasdecerdo = new Ingrediente();
		costillasdecerdo.setNombre("costillas de cerdo");
		costillasdecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(costillasdecerdo);
		
		Ingrediente cordero = new Ingrediente();
		cordero.setNombre("cordero");
		cordero.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(cordero);
		
		Ingrediente costillasdeternera = new Ingrediente();
		costillasdeternera.setNombre("costillas de ternera");
		costillasdeternera.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(costillasdeternera);
		
		Ingrediente pato = new Ingrediente();
		pato.setNombre("pato");
		pato.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(pato);
		
		Ingrediente menudenciasdepollo = new Ingrediente();
		menudenciasdepollo.setNombre("menudencias de pollo");
		menudenciasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(menudenciasdepollo);
		
		Ingrediente conejo = new Ingrediente();
		conejo.setNombre("conejo");
		conejo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(conejo);
		
		// PESCADO
		
		Ingrediente atunenlatado = new Ingrediente();
		atunenlatado.setNombre("atún enlatado");
		atunenlatado.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(atunenlatado);
		
		Ingrediente filetesdepescado = new Ingrediente();
		filetesdepescado.setNombre("filetes de pescado");
		filetesdepescado.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(filetesdepescado);
		
		Ingrediente salmon = new Ingrediente();
		salmon.setNombre("salmón");
		salmon.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(salmon);
		
		Ingrediente tilapia = new Ingrediente();
		tilapia.setNombre("tilapia");
		tilapia.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(tilapia);
		
		Ingrediente salmonenlatado = new Ingrediente();
		salmonenlatado.setNombre("salmón enlatado");
		salmonenlatado.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(salmonenlatado);

		Ingrediente anchoas = new Ingrediente();
		anchoas.setNombre("anchoas");
		anchoas.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(anchoas);
		
		Ingrediente salmonahumado = new Ingrediente();
		salmonahumado.setNombre("salmón ahumado");
		salmonahumado.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(salmonahumado);
		
		Ingrediente sardinas = new Ingrediente();
		sardinas.setNombre("sardinas");
		sardinas.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(sardinas);
		
		Ingrediente filetedeatun = new Ingrediente();
		filetedeatun.setNombre("filete de atún");
		filetedeatun.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(filetedeatun);
		
		Ingrediente trucha = new Ingrediente();
		trucha.setNombre("trucha");
		trucha.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(trucha);

		Ingrediente bagre = new Ingrediente();
		bagre.setNombre("bagre");
		bagre.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(bagre);
		
		Ingrediente caballa = new Ingrediente();
		caballa.setNombre("caballa");
		caballa.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(caballa);
		
		Ingrediente pezespada = new Ingrediente();
		pezespada.setNombre("pez espada");
		pezespada.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(pezespada);
		
		Ingrediente abadejo = new Ingrediente();
		abadejo.setNombre("abadejo");
		abadejo.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(abadejo);
		
		Ingrediente caviar = new Ingrediente();
		caviar.setNombre("caviar");
		caviar.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(caviar);

		Ingrediente pezroca = new Ingrediente();
		pezroca.setNombre("pez roca");
		pezroca.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(pezroca);
		
		Ingrediente sueladelimon = new Ingrediente();
		sueladelimon.setNombre("suela de limón");
		sueladelimon.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(sueladelimon);
		
		Ingrediente carpa = new Ingrediente();
		carpa.setNombre("carpa");
		carpa.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(carpa);
		
		Ingrediente calamar = new Ingrediente();
		calamar.setNombre("calamar");
		calamar.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(calamar);
		
		Ingrediente cornalitos = new Ingrediente();
		cornalitos.setNombre("cornalitos");
		cornalitos.setTipo("PESCADO");
		servicioIngrediente.guardarIngredienteEnInventario(cornalitos);
		
		// CONDIMENTOS
		
		Ingrediente mayonesa = new Ingrediente();
		mayonesa.setNombre("mayonesa");
		mayonesa.setTipo("CONDIMENTOS");
		mayonesa.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(mayonesa);
		
		Ingrediente salfina = new Ingrediente();
		salfina.setNombre("sal fina");
		salfina.setTipo("CONDIMENTOS");
		salfina.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(salfina);
		
		Ingrediente salsadetomate = new Ingrediente();
		salsadetomate.setNombre("salsa de tomate");
		salsadetomate.setTipo("CONDIMENTOS");
		salsadetomate.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadetomate);
		
		Ingrediente vinagre = new Ingrediente();
		vinagre.setNombre("vinagre");
		vinagre.setTipo("CONDIMENTOS");
		vinagre.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagre);
		
		Ingrediente salsadesoja = new Ingrediente();
		salsadesoja.setNombre("salsa de soja");
		salsadesoja.setTipo("CONDIMENTOS");
		salsadesoja.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadesoja);
		
		Ingrediente salsapicante = new Ingrediente();
		salsapicante.setNombre("salsa picante");
		salsapicante.setTipo("CONDIMENTOS");
		salsapicante.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsapicante);
		
		Ingrediente salsadebarbacoa = new Ingrediente();
		salsadebarbacoa.setNombre("salsa de barbacoa");
		salsadebarbacoa.setTipo("CONDIMENTOS");
		salsadebarbacoa.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadebarbacoa);
		
		Ingrediente aderezoranch = new Ingrediente();
		aderezoranch.setNombre("aderezo ranch");
		aderezoranch.setTipo("CONDIMENTOS");
		aderezoranch.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(aderezoranch);
		
		Ingrediente vinagredesidrademanzana = new Ingrediente();
		vinagredesidrademanzana.setNombre("vinagre de sidra de manzana ");
		vinagredesidrademanzana.setTipo("CONDIMENTOS");
		vinagredesidrademanzana.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredesidrademanzana);
		
		Ingrediente vinagredevino = new Ingrediente();
		vinagredevino.setNombre("vinagre de vino");
		vinagredevino.setTipo("CONDIMENTOS");
		vinagredevino.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredevino);
		
		Ingrediente vinagredearroz = new Ingrediente();
		vinagredearroz.setNombre("vinagre de arroz");
		vinagredearroz.setTipo("CONDIMENTOS");
		vinagredearroz.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredearroz);
		
		Ingrediente aderezoparaensaladas = new Ingrediente();
		aderezoparaensaladas.setNombre("aderezo para ensaladas");
		aderezoparaensaladas.setTipo("CONDIMENTOS");
		aderezoparaensaladas.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(aderezoparaensaladas);
		
		Ingrediente tabasco = new Ingrediente();
		tabasco.setNombre("tabasco");
		tabasco.setTipo("CONDIMENTOS");
		tabasco.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(tabasco);
		
		Ingrediente salsadepescado = new Ingrediente();
		salsadepescado.setNombre("salsa de pescado");
		salsadepescado.setTipo("CONDIMENTOS");
		salsadepescado.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadepescado);
		
		Ingrediente miel = new Ingrediente();
		miel.setNombre("miel");
		miel.setTipo("CONDIMENTOS");
		miel.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(miel);
		
		Ingrediente mostaza = new Ingrediente();
		mostaza.setNombre("mostaza");
		mostaza.setTipo("CONDIMENTOS");
		mostaza.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(mostaza);
		
		Ingrediente salsatartara = new Ingrediente();
		salsatartara.setNombre("salsa tártara");
		salsatartara.setTipo("CONDIMENTOS");
		salsatartara.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsatartara);
		
		Ingrediente salsadecoctel = new Ingrediente();
		salsadecoctel.setNombre("salsa de cóctel");
		salsadecoctel.setTipo("CONDIMENTOS");
		salsadecoctel.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadecoctel);
		
		Ingrediente marsala = new Ingrediente();
		marsala.setNombre("marsala");
		marsala.setTipo("CONDIMENTOS");
		marsala.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(marsala);
		
		Ingrediente salsadeadobo = new Ingrediente();
		salsadeadobo.setNombre("salsa de adobo");
		salsadeadobo.setTipo("CONDIMENTOS");
		salsadeadobo.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadeadobo);
		
		Ingrediente ketchup = new Ingrediente();
		ketchup.setNombre("ketchup");
		ketchup.setTipo("CONDIMENTOS");
		ketchup.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(ketchup);
		
		Ingrediente aderezodesesamo = new Ingrediente();
		aderezodesesamo.setNombre("aderezo de sésamo");
		aderezodesesamo.setTipo("CONDIMENTOS");
		aderezodesesamo.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(aderezodesesamo);
		
		Ingrediente ponzu = new Ingrediente();
		ponzu.setNombre("ponzu");
		ponzu.setTipo("CONDIMENTOS");
		ponzu.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(ponzu);
		
		Ingrediente salsadepato = new Ingrediente();
		salsadepato.setNombre("salsa de pato");
		salsadepato.setTipo("CONDIMENTOS");
		salsadepato.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadepato);
		
		Ingrediente salsapickapeppa = new Ingrediente();
		salsapickapeppa.setNombre("salsa pickapeppa");
		salsapickapeppa.setTipo("CONDIMENTOS");
		salsapickapeppa.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsapickapeppa);
		
		Ingrediente jugodeyuzu = new Ingrediente();
		jugodeyuzu.setNombre("jugo de yuzu");
		jugodeyuzu.setTipo("CONDIMENTOS");
		jugodeyuzu.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(jugodeyuzu);
		
		Ingrediente salsadecrema = new Ingrediente();
		salsadecrema.setNombre("salsa de crema");
		salsadecrema.setTipo("CONDIMENTOS");
		salsadecrema.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadecrema);

		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/insertar-usuarios")
	public ModelAndView insertarUsuarios() {	
	// Usuarios
		
	Usuario matias = new Usuario();
	matias.setNombre("Matias");
	matias.setApellido("Rivero");
	matias.setAlias("Mati");
	matias.setEmail("matias@gmail.com");
	matias.setPassword("12345");
	matias.setRepassword("12345");
	matias.setRol("Usuario");	
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
	
	Usuario peke = new Usuario();
	peke.setNombre("edith");
	peke.setApellido("parisi");
	peke.setAlias("pequemonsters");
	peke.setEmail("edith69@gmail.com");
	peke.setPassword("monsters");
	peke.setRepassword("monsters");
	peke.setRol("Usuario");
	servicioUsuario.guardarUsuario(peke);
	
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
	
	return new ModelAndView("redirect:/");
}
	
	@RequestMapping("/insertar-recetas")
	public ModelAndView insertarRecetas() {	

	Receta receta1 = new Receta();
	receta1.setNombre("receta1");
	receta1.setCalorias(250);
	receta1.setImagen("receta.jpg");
	List<Ingrediente> ingredientesreceta1 = new LinkedList<Ingrediente>();
	Ingrediente manteca = servicioIngrediente.traerUnIngredientePorSuId((long) 1);	
	manteca.setCantidad(250);
//	Ingrediente mantecareceta1 = manteca.clone();
	servicioIngrediente.guardarIngredienteEnReceta(manteca);
	Ingrediente qfresco = servicioIngrediente.traerUnIngredientePorSuId((long) 2);
	qfresco.setCantidad(400);
//	Ingrediente qfrescoreceta1 = qfresco.clone();
	servicioIngrediente.guardarIngredienteEnReceta(qfresco);
	Ingrediente huevos = servicioIngrediente.traerUnIngredientePorSuId((long) 3);
	huevos.setCantidad(12);
//	Ingrediente huevosreceta1 = huevos.clone();
	servicioIngrediente.guardarIngredienteEnReceta(huevos);
	Ingrediente leche = servicioIngrediente.traerUnIngredientePorSuId((long) 4);
	leche.setCantidad(3);
//	Ingrediente lechereceta1 = leche.clone();
	servicioIngrediente.guardarIngredienteEnReceta(leche);
	ingredientesreceta1.add(manteca);
	ingredientesreceta1.add(qfresco);
	ingredientesreceta1.add(huevos);
	ingredientesreceta1.add(leche);
	receta1.setListaIngrediente(ingredientesreceta1);
	servicioReceta.guardarReceta(receta1);
	
	Receta receta2 = new Receta();
	receta2.setNombre("receta2");
	receta2.setCalorias(350);
	receta2.setImagen("receta.jpg");
	List<Ingrediente> ingredientesreceta2 = new LinkedList<Ingrediente>();
	Ingrediente pepino = servicioIngrediente.traerUnIngredientePorSuId((long) 45);	
	pepino.setCantidad(1000);
	servicioIngrediente.guardarIngredienteEnReceta(pepino);
	Ingrediente batata = servicioIngrediente.traerUnIngredientePorSuId((long) 46);
	batata.setCantidad(2000);
	servicioIngrediente.guardarIngredienteEnReceta(batata);
	Ingrediente calabacin = servicioIngrediente.traerUnIngredientePorSuId((long) 47);
	calabacin.setCantidad(1500);
	servicioIngrediente.guardarIngredienteEnReceta(calabacin);
	Ingrediente aceituna = servicioIngrediente.traerUnIngredientePorSuId((long) 48);
	aceituna.setCantidad(500);
	servicioIngrediente.guardarIngredienteEnReceta(aceituna);	
	ingredientesreceta2.add(pepino);
	ingredientesreceta2.add(batata);
	ingredientesreceta2.add(calabacin);
	ingredientesreceta2.add(aceituna);
	receta2.setListaIngrediente(ingredientesreceta2);
	servicioReceta.guardarReceta(receta2);
	
	Receta receta3 = new Receta();
	receta3.setNombre("receta3");
	receta3.setCalorias(450);
	receta3.setImagen("receta.jpg");
	List<Ingrediente> ingredientesreceta3 = new LinkedList<Ingrediente>();
	Ingrediente mantecar3 = servicioIngrediente.traerUnIngredientePorSuId((long) 1);
	mantecar3.setCantidad(500);
	servicioIngrediente.guardarIngredienteEnReceta(mantecar3);
	Ingrediente cebollaroja = servicioIngrediente.traerUnIngredientePorSuId((long) 44);
	cebollaroja.setCantidad(250);
	servicioIngrediente.guardarIngredienteEnReceta(cebollaroja);
	Ingrediente remolacha = servicioIngrediente.traerUnIngredientePorSuId((long) 50);
	remolacha.setCantidad(500);
	servicioIngrediente.guardarIngredienteEnReceta(remolacha);
	Ingrediente calabaza = servicioIngrediente.traerUnIngredientePorSuId((long) 51);
	calabaza.setCantidad(1000);
	servicioIngrediente.guardarIngredienteEnReceta(calabaza);
	ingredientesreceta3.add(mantecar3);
	ingredientesreceta3.add(cebollaroja);
	ingredientesreceta3.add(remolacha);
	ingredientesreceta3.add(calabaza);
	receta3.setListaIngrediente(ingredientesreceta3);
	servicioReceta.guardarReceta(receta3);
	
	return new ModelAndView("redirect:/");
}
	
	@RequestMapping("/insertar-ingre-usuarios")
	public ModelAndView ingredientesAUsuarios() throws ParseException {	
		
		Usuario matias = servicioUsuario.traerUnUsuarioPorSuId((long) 1);
		
		Ingrediente cebollarojamatias = new Ingrediente();
		cebollarojamatias.setNombre("cebolla roja");	
		cebollarojamatias.setFvencimiento("28/06/2018");
		cebollarojamatias.setCantidad(250);
		cebollarojamatias.setUnidad("Grs");
		cebollarojamatias.setTipo("VEGETALES");
		cebollarojamatias.setEstado("NOVENCIDO");
		
		Ingrediente manteca = new Ingrediente();
		manteca.setNombre("manteca");
		manteca.setFvencimiento("16/12/2018");
		manteca.setCantidad(500);
		manteca.setUnidad("Grs");
		manteca.setTipo("LACTEOS");
		manteca.setEstado("NOVENCIDO");
		
		Ingrediente quesofresco = new Ingrediente();
		quesofresco.setNombre("queso fresco");
		quesofresco.setFvencimiento("25/06/2018");
		quesofresco.setCantidad(250);
		quesofresco.setUnidad("Grs");
		quesofresco.setTipo("LACTEOS");
		quesofresco.setEstado("NOVENCIDO");

		Ingrediente huevos = new Ingrediente();
		huevos.setNombre("huevos");
		huevos.setFvencimiento("26/06/2018");
		huevos.setCantidad(24);
		huevos.setUnidad("Unids");
		huevos.setTipo("LACTEOS");
		huevos.setEstado("NOVENCIDO");

		List<Ingrediente> ingredientesdematias  = matias.getlistaIngrediente();
		ingredientesdematias.add(cebollarojamatias);
		ingredientesdematias.add(manteca);
		ingredientesdematias.add(quesofresco);
		ingredientesdematias.add(huevos);
		
		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojamatias);		
		servicioIngrediente.guardarIngredienteEnUsuario(manteca);		
		servicioIngrediente.guardarIngredienteEnUsuario(quesofresco);		
		servicioIngrediente.guardarIngredienteEnUsuario(huevos);		
		matias.setlistaIngrediente(ingredientesdematias);
		servicioUsuario.actualizarUsuario(matias);		
			
		Usuario juanpablo = servicioUsuario.traerUnUsuarioPorSuId((long) 2);

		Ingrediente cebollarojajuanpi = new Ingrediente();
		cebollarojajuanpi.setNombre("cebolla roja");
		cebollarojajuanpi.setCantidad(1000);
		cebollarojajuanpi.setUnidad("Grs");
		cebollarojajuanpi.setTipo("VEGETALES");
		cebollarojajuanpi.setEstado("NOVENCIDO");
		cebollarojajuanpi.setFvencimiento("26/06/2018");
		
		List<Ingrediente> ingredientesdejuanpablo = juanpablo.getlistaIngrediente();
		ingredientesdejuanpablo.add(cebollarojajuanpi);

		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojajuanpi);
		juanpablo.setlistaIngrediente(ingredientesdejuanpablo);
		servicioUsuario.actualizarUsuario(juanpablo);	
		
		Usuario flor = servicioUsuario.traerUnUsuarioPorSuId((long) 3);
		
		Ingrediente cebollarojaflor = servicioIngrediente.traerUnIngredientePorSuId((long) 44);
		cebollarojaflor.setCantidad(500);
		cebollarojaflor.setUnidad("Grs");
		cebollarojaflor.setFvencimiento("30/09/2018");
		
		List<Ingrediente> ingredientesdeflor = flor.getlistaIngrediente();
		ingredientesdeflor.add(cebollarojaflor);
		
		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojaflor);
		flor.setlistaIngrediente(ingredientesdeflor);
		servicioUsuario.actualizarUsuario(flor);	
				
		return new ModelAndView("redirect:/");
	}
		
}
