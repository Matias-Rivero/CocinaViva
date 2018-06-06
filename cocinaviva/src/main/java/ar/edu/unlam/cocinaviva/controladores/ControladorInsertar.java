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
		
		Ingrediente manteca = new Ingrediente();
		manteca.setNombre("manteca");
		manteca.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(manteca);
		
		Ingrediente quesofresco = new Ingrediente();
		quesofresco.setNombre("queso fresco");
		quesofresco.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesofresco);

		Ingrediente huevos = new Ingrediente();
		huevos.setNombre("huevos");
		huevos.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(huevos);
		
		Ingrediente leche = new Ingrediente();
		leche.setNombre("leche");
		leche.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(leche);
		
		Ingrediente quesoparmesano = new Ingrediente();
		quesoparmesano.setNombre("queso parmesano");
		quesoparmesano.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesoparmesano);
		
		Ingrediente quesocheddar = new Ingrediente();
		quesocheddar.setNombre("queso cheddar");
		quesocheddar.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesocheddar);

		Ingrediente quesoamericano = new Ingrediente();
		quesoamericano.setNombre("queso americano");
		quesoamericano.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesoamericano);

		Ingrediente quesocrema = new Ingrediente();
		quesocrema.setNombre("queso crema");
		quesocrema.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesocrema);
		
		Ingrediente quesomozzarella = new Ingrediente();
		quesomozzarella.setNombre("queso mozzarella");
		quesomozzarella.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesomozzarella);
		
		Ingrediente yogurt  = new Ingrediente();
		yogurt.setNombre("yogurt");
		yogurt.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(yogurt);
		
		Ingrediente cremadeleche = new Ingrediente();
		cremadeleche.setNombre("crema de leche");
		cremadeleche.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(cremadeleche);

		Ingrediente lechecondensada  = new Ingrediente();
		lechecondensada.setNombre("leche condensada ");
		lechecondensada.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(lechecondensada);

		Ingrediente quesocottage = new Ingrediente();
		quesocottage.setNombre("queso cottage");
		quesocottage.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesocottage);
		
		Ingrediente quesosuizo = new Ingrediente();
		quesosuizo.setNombre("queso suizo");
		quesosuizo.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesosuizo);
		
		Ingrediente requeson = new Ingrediente();
		requeson.setNombre("requesón");
		requeson.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(requeson);
		
		Ingrediente quesodecabra = new Ingrediente();
		quesodecabra.setNombre("queso de cabra");
		quesodecabra.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesodecabra);

		Ingrediente quesoprovolone = new Ingrediente();
		quesoprovolone.setNombre("queso provolone");
		quesoprovolone.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesoprovolone);

		Ingrediente quesoazul = new Ingrediente();
		quesoazul.setNombre("queso azul");
		quesoazul.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesoazul);
		
		Ingrediente lecheenpolvo = new Ingrediente();
		lecheenpolvo.setNombre("leche en polvo");
		lecheenpolvo.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(lecheenpolvo);
		
		Ingrediente quesocolby = new Ingrediente();
		quesocolby.setNombre("queso colby");
		quesocolby.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesocolby);
		
		Ingrediente quesoitaliano = new Ingrediente();
		quesoitaliano.setNombre("queso italiano");
		quesoitaliano.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesoitaliano);

		Ingrediente quesosuavegouda = new Ingrediente();
		quesosuavegouda.setNombre("queso suave gouda");
		quesosuavegouda.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesosuavegouda);

		Ingrediente quesopimienta = new Ingrediente();
		quesopimienta.setNombre("queso pimienta");
		quesopimienta.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesopimienta);
		
		Ingrediente quesobrie = new Ingrediente();
		quesobrie.setNombre("queso brie");
		quesobrie.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesobrie);
		
		Ingrediente quesomuenster = new Ingrediente();
		quesomuenster.setNombre("queso muenster");
		quesomuenster.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesomuenster);
		
		Ingrediente quesoduro = new Ingrediente();
		quesoduro.setNombre("queso duro");
		quesoduro.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesoduro);

		Ingrediente quesohavarti = new Ingrediente();
		quesohavarti.setNombre("queso havarti");
		quesohavarti.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(quesohavarti);

		Ingrediente lechedecabra = new Ingrediente();
		lechedecabra.setNombre("leche de cabra");
		lechedecabra.setTipo("LACTEOS");
		servicioIngrediente.guardarIngredienteEnInventario(lechedecabra);
		
		// VEGETALES
		
		Ingrediente cebolla = new Ingrediente();
		cebolla.setNombre("cebolla");
		cebolla.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(cebolla);
		
		Ingrediente ajo = new Ingrediente();
		ajo.setNombre("ajo");
		ajo.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(ajo);
		
		Ingrediente lechuga = new Ingrediente();
		lechuga.setNombre("lechuga");
		lechuga.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(lechuga);
		
		Ingrediente tomate = new Ingrediente();
		tomate.setNombre("tomate");
		tomate.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(tomate);
		
		Ingrediente papa = new Ingrediente();
		papa.setNombre("papa");
		papa.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(papa);
		
		Ingrediente zanahoria = new Ingrediente();
		zanahoria.setNombre("zanahoria");
		zanahoria.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(zanahoria);
		
		Ingrediente albahaca = new Ingrediente();
		albahaca.setNombre("albahaca");
		albahaca.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(albahaca);
		
		Ingrediente perejil = new Ingrediente();
		perejil.setNombre("perejil");
		perejil.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(perejil);
		
		Ingrediente brocoli = new Ingrediente();
		brocoli.setNombre("brócoli");
		brocoli.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(brocoli);
		
		Ingrediente maiz = new Ingrediente();
		maiz.setNombre("maíz");
		maiz.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(maiz);
		
		Ingrediente espinacas = new Ingrediente();
		espinacas.setNombre("espinacas");
		espinacas.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(espinacas);
		
		Ingrediente jengibre = new Ingrediente();
		jengibre.setNombre("jengibre");
		jengibre.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(jengibre);
		
		Ingrediente ajipicante = new Ingrediente();
		ajipicante.setNombre("ají picante");
		ajipicante.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(ajipicante);
		
		Ingrediente apio = new Ingrediente();
		apio.setNombre("apio");
		apio.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(apio);
		
		Ingrediente romero = new Ingrediente();
		romero.setNombre("romero");
		romero.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(romero);
		
		Ingrediente cebollaroja = new Ingrediente();
		cebollaroja.setNombre("cebolla roja");
		cebollaroja.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(cebollaroja);
		
		Ingrediente pepino = new Ingrediente();
		pepino.setNombre("pepino");
		pepino.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(pepino);
		
		Ingrediente batata = new Ingrediente();
		batata.setNombre("batata");
		batata.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(batata);
		
		Ingrediente calabacin = new Ingrediente();
		calabacin.setNombre("calabacín");
		calabacin.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(calabacin);
		
		Ingrediente aceituna = new Ingrediente();
		aceituna.setNombre("aceituna");
		aceituna.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(aceituna);
		
		Ingrediente berenjena = new Ingrediente();
		berenjena.setNombre("berenjena");
		berenjena.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(berenjena);
		
		Ingrediente remolacha = new Ingrediente();
		remolacha.setNombre("remolacha");
		remolacha.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(remolacha);
		
		Ingrediente calabaza = new Ingrediente();
		calabaza.setNombre("calabaza");
		calabaza.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(calabaza);
		
		Ingrediente semillasdechia = new Ingrediente();
		semillasdechia.setNombre("semillas de chia");
		semillasdechia.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(semillasdechia);
		
		Ingrediente semillasdelino = new Ingrediente();
		semillasdelino.setNombre("semillas de lino");
		semillasdelino.setTipo("VEGETALES");
		servicioIngrediente.guardarIngredienteEnInventario(semillasdelino);
		
		Ingrediente brotesdesoja = new Ingrediente();
		brotesdesoja.setNombre("brotes de soja");
		brotesdesoja.setTipo("VEGETALES");
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
		polloentero.setNombre("polloentero");
		polloentero.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(polloentero);
		
		Ingrediente cerdo = new Ingrediente();
		cerdo.setNombre("pechuga de pollo");
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
		pato.setNombre("pechuga de pollo");
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
		servicioIngrediente.guardarIngredienteEnInventario(mayonesa);
		
		Ingrediente salfina = new Ingrediente();
		salfina.setNombre("sal fina");
		salfina.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salfina);
		
		Ingrediente salsadetomate = new Ingrediente();
		salsadetomate.setNombre("salsa de tomate");
		salsadetomate.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsadetomate);
		
		Ingrediente vinagre = new Ingrediente();
		vinagre.setNombre("vinagre");
		vinagre.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(vinagre);
		
		Ingrediente salsadesoja = new Ingrediente();
		salsadesoja.setNombre("salsa de soja");
		salsadesoja.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsadesoja);
		
		Ingrediente salsapicante = new Ingrediente();
		salsapicante.setNombre("salsa picante");
		salsapicante.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsapicante);
		
		Ingrediente salsadebarbacoa = new Ingrediente();
		salsadebarbacoa.setNombre("salsa de barbacoa");
		salsadebarbacoa.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsadebarbacoa);
		
		Ingrediente aderezoranch = new Ingrediente();
		aderezoranch.setNombre("aderezo ranch");
		aderezoranch.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(aderezoranch);
		
		Ingrediente vinagredesidrademanzana = new Ingrediente();
		vinagredesidrademanzana.setNombre("vinagre de sidra de manzana ");
		vinagredesidrademanzana.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredesidrademanzana);
		
		Ingrediente vinagredevino = new Ingrediente();
		vinagredevino.setNombre("vinagre de vino");
		vinagredevino.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredevino);
		
		Ingrediente vinagredearroz = new Ingrediente();
		vinagredearroz.setNombre("vinagre de arroz");
		vinagredearroz.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredearroz);
		
		Ingrediente aderezoparaensaladas = new Ingrediente();
		aderezoparaensaladas.setNombre("aderezo para ensaladas");
		aderezoparaensaladas.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(aderezoparaensaladas);
		
		Ingrediente tabasco = new Ingrediente();
		tabasco.setNombre("tabasco");
		tabasco.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(tabasco);
		
		Ingrediente salsadepescado = new Ingrediente();
		salsadepescado.setNombre("salsa de pescado");
		salsadepescado.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsadepescado);
		
		Ingrediente miel = new Ingrediente();
		miel.setNombre("miel");
		miel.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(miel);
		
		Ingrediente mostaza = new Ingrediente();
		mostaza.setNombre("mostaza");
		mostaza.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(mostaza);
		
		Ingrediente salsatartara = new Ingrediente();
		salsatartara.setNombre("salsa tártara");
		salsatartara.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsatartara);
		
		Ingrediente salsadecoctel = new Ingrediente();
		salsadecoctel.setNombre("salsa de cóctel");
		salsadecoctel.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsadecoctel);
		
		Ingrediente marsala = new Ingrediente();
		marsala.setNombre("marsala");
		marsala.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(marsala);
		
		Ingrediente salsadeadobo = new Ingrediente();
		salsadeadobo.setNombre("salsa de adobo");
		salsadeadobo.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsadeadobo);
		
		Ingrediente ketchup = new Ingrediente();
		ketchup.setNombre("ketchup");
		ketchup.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(ketchup);
		
		Ingrediente aderezodesesamo = new Ingrediente();
		aderezodesesamo.setNombre("aderezo de sésamo");
		aderezodesesamo.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(aderezodesesamo);
		
		Ingrediente ponzu = new Ingrediente();
		ponzu.setNombre("ponzu");
		ponzu.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(ponzu);
		
		Ingrediente salsadepato = new Ingrediente();
		salsadepato.setNombre("salsa de pato");
		salsadepato.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsadepato);
		
		Ingrediente salsapickapeppa = new Ingrediente();
		salsapickapeppa.setNombre("salsa pickapeppa");
		salsapickapeppa.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(salsapickapeppa);
		
		Ingrediente jugodeyuzu = new Ingrediente();
		jugodeyuzu.setNombre("jugo de yuzu");
		jugodeyuzu.setTipo("CONDIMENTOS");
		servicioIngrediente.guardarIngredienteEnInventario(jugodeyuzu);
		
		Ingrediente salsadecrema = new Ingrediente();
		salsadecrema.setNombre("salsa de crema");
		salsadecrema.setTipo("CONDIMENTOS");
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
	
	@RequestMapping("/insertar-ingre-usuarios")
	public ModelAndView ingredientesAUsuarios() {	
		
		Usuario matias = servicioUsuario.traerUnUsuarioPorSuId((long) 1);
		
		Ingrediente cebollarojamatias = new Ingrediente();
		cebollarojamatias.setNombre("cebolla roja");
		cebollarojamatias.setCantidad(4);
		cebollarojamatias.setGramos(250);
		cebollarojamatias.setTipo("VEGETALES");
		cebollarojamatias.setFcompra(01);
		cebollarojamatias.setFvencimiento(01);

		List<Ingrediente> ingredientesdematias  = matias.getlistaIngrediente();
		ingredientesdematias.add(cebollarojamatias);
		
		
		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojamatias);		
		matias.setlistaIngrediente(ingredientesdematias);
		servicioUsuario.actualizarUsuario(matias);		
			
		Usuario juanpablo = servicioUsuario.traerUnUsuarioPorSuId((long) 2);

		Ingrediente cebollarojajuanpi = new Ingrediente();
		cebollarojajuanpi.setNombre("cebolla roja");
		cebollarojajuanpi.setCantidad(1);
		cebollarojajuanpi.setGramos(750);
		cebollarojajuanpi.setTipo("VEGETALES");
		cebollarojajuanpi.setFcompra(03);
		cebollarojajuanpi.setFvencimiento(07);
		
		List<Ingrediente> ingredientesdejuanpablo = juanpablo.getlistaIngrediente();
		ingredientesdejuanpablo.add(cebollarojajuanpi);

		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojajuanpi);
		juanpablo.setlistaIngrediente(ingredientesdejuanpablo);
		servicioUsuario.actualizarUsuario(juanpablo);	
		
		Usuario flor = servicioUsuario.traerUnUsuarioPorSuId((long) 3);
		
		Ingrediente cebollarojaflor = servicioIngrediente.traerUnIngredientePorSuId((long) 44);
		cebollarojaflor.setCantidad(3);
		cebollarojaflor.setFcompra(12);
		cebollarojaflor.setFvencimiento(13);
		cebollarojaflor.setGramos(4);
		
		List<Ingrediente> ingredientesdeflor = flor.getlistaIngrediente();
		ingredientesdeflor.add(cebollarojaflor);
		
		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojaflor);
		flor.setlistaIngrediente(ingredientesdeflor);
		servicioUsuario.actualizarUsuario(flor);	
				
		return new ModelAndView("redirect:/");
	}
}
