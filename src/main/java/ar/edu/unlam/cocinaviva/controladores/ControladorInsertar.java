package ar.edu.unlam.cocinaviva.controladores;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Pasos;
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
		manteca.setNombre("Manteca");
		manteca.setTipo("LACTEOS");
		manteca.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(manteca);
		
		Ingrediente quesofresco = new Ingrediente();
		quesofresco.setNombre("Queso fresco");
		quesofresco.setTipo("LACTEOS");
		quesofresco.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesofresco);

		Ingrediente huevos = new Ingrediente();
		huevos.setNombre("Huevos");
		huevos.setTipo("LACTEOS");
		huevos.setPerece("SEPUDRE");
		huevos.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(huevos);
		
		Ingrediente leche = new Ingrediente();
		leche.setNombre("Leche");
		leche.setTipo("LACTEOS");
		leche.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(leche);
		
		Ingrediente quesoparmesano = new Ingrediente();
		quesoparmesano.setNombre("Queso parmesano");
		quesoparmesano.setTipo("LACTEOS");
		quesoparmesano.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoparmesano);
		
		Ingrediente quesocheddar = new Ingrediente();
		quesocheddar.setNombre("Queso cheddar");
		quesocheddar.setTipo("LACTEOS");
		quesocheddar.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocheddar);

		Ingrediente quesoamericano = new Ingrediente();
		quesoamericano.setNombre("Queso americano");
		quesoamericano.setTipo("LACTEOS");
		quesoamericano.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoamericano);

		Ingrediente quesocrema = new Ingrediente();
		quesocrema.setNombre("Queso crema");
		quesocrema.setTipo("LACTEOS");
		quesocrema.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocrema);
		
		Ingrediente quesomozzarella = new Ingrediente();
		quesomozzarella.setNombre("Queso mozzarella");
		quesomozzarella.setTipo("LACTEOS");
		quesomozzarella.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesomozzarella);
		
		Ingrediente yogurt  = new Ingrediente();
		yogurt.setNombre("Yogurt");
		yogurt.setTipo("LACTEOS");
		yogurt.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(yogurt);
		
		Ingrediente cremadeleche = new Ingrediente();
		cremadeleche.setNombre("Crema de leche");
		cremadeleche.setTipo("LACTEOS");
		cremadeleche.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(cremadeleche);

		Ingrediente lechecondensada  = new Ingrediente();
		lechecondensada.setNombre("Leche condensada ");
		lechecondensada.setTipo("LACTEOS");
		lechecondensada.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(lechecondensada);

		Ingrediente quesocottage = new Ingrediente();
		quesocottage.setNombre("Queso cottage");
		quesocottage.setTipo("LACTEOS");
		quesocottage.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocottage);
		
		Ingrediente quesosuizo = new Ingrediente();
		quesosuizo.setNombre("Queso suizo");
		quesosuizo.setTipo("LACTEOS");
		quesosuizo.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesosuizo);
		
		Ingrediente requeson = new Ingrediente();

		requeson.setNombre("requesón");
		requeson.setTipo("LACTEOS");
		requeson.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(requeson);
		
		Ingrediente quesodecabra = new Ingrediente();
		quesodecabra.setNombre("Queso de cabra");
		quesodecabra.setTipo("LACTEOS");
		quesodecabra.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesodecabra);

		Ingrediente quesoprovolone = new Ingrediente();
		quesoprovolone.setNombre("Queso provolone");
		quesoprovolone.setTipo("LACTEOS");
		quesoprovolone.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoprovolone);

		Ingrediente quesoazul = new Ingrediente();
		quesoazul.setNombre("Queso azul");
		quesoazul.setTipo("LACTEOS");
		quesoazul.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoazul);
		
		Ingrediente lecheenpolvo = new Ingrediente();
		lecheenpolvo.setNombre("Leche en polvo");
		lecheenpolvo.setTipo("LACTEOS");
		lecheenpolvo.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(lecheenpolvo);
		
		Ingrediente quesocolby = new Ingrediente();
		quesocolby.setNombre("Queso colby");
		quesocolby.setTipo("LACTEOS");
		quesocolby.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesocolby);
		
		Ingrediente quesoitaliano = new Ingrediente();
		quesoitaliano.setNombre("Queso italiano");
		quesoitaliano.setTipo("LACTEOS");
		quesoitaliano.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoitaliano);

		Ingrediente quesosuavegouda = new Ingrediente();
		quesosuavegouda.setNombre("Queso suave gouda");
		quesosuavegouda.setTipo("LACTEOS");
		quesosuavegouda.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesosuavegouda);

		Ingrediente quesopimienta = new Ingrediente();
		quesopimienta.setNombre("Queso pimienta");
		quesopimienta.setTipo("LACTEOS");
		quesopimienta.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesopimienta);
		
		Ingrediente quesobrie = new Ingrediente();
		quesobrie.setNombre("Queso brie");
		quesobrie.setTipo("LACTEOS");
		quesobrie.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesobrie);
		
		Ingrediente quesomuenster = new Ingrediente();
		quesomuenster.setNombre("Queso muenster");
		quesomuenster.setTipo("LACTEOS");
		quesomuenster.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesomuenster);
		
		Ingrediente quesoduro = new Ingrediente();
		quesoduro.setNombre("Queso duro");
		quesoduro.setTipo("LACTEOS");
		quesoduro.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoduro);

		Ingrediente quesohavarti = new Ingrediente();
		quesohavarti.setNombre("Queso havarti");
		quesohavarti.setTipo("LACTEOS");
		quesohavarti.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesohavarti);

		Ingrediente lechedecabra = new Ingrediente();
		lechedecabra.setNombre("Leche de cabra");
		lechedecabra.setTipo("LACTEOS");
		lechedecabra.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(lechedecabra);
		
		// VEGETALES // Lts Grs Unids
		
		Ingrediente cebolla = new Ingrediente();
		cebolla.setNombre("Cebolla");
		cebolla.setTipo("VEGETALES");
		cebolla.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(cebolla);
		
		Ingrediente ajo = new Ingrediente();
		ajo.setNombre("Dientes de ajo");
		ajo.setTipo("VEGETALES");
		ajo.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(ajo);
		
		Ingrediente limon = new Ingrediente();
		limon.setNombre("Lim�n");
		limon.setTipo("VEGETALES");
		limon.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(limon);
		
		Ingrediente lechuga = new Ingrediente();
		lechuga.setNombre("Lechuga");
		lechuga.setTipo("VEGETALES");
		lechuga.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(lechuga);
		
		Ingrediente tomate = new Ingrediente();
		tomate.setNombre("Tomate");
		tomate.setTipo("VEGETALES");
		tomate.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(tomate);
		
		Ingrediente papa = new Ingrediente();
		papa.setNombre("Papa");
		papa.setTipo("VEGETALES");
		papa.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(papa);
		
		Ingrediente zanahoria = new Ingrediente();
		zanahoria.setNombre("Zanahoria");
		zanahoria.setTipo("VEGETALES");
		zanahoria.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(zanahoria);
		
		Ingrediente albahaca = new Ingrediente();
		albahaca.setNombre("Albahaca");
		albahaca.setTipo("VEGETALES");
		albahaca.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(albahaca);
		
		Ingrediente perejil = new Ingrediente();
		perejil.setNombre("Perejil");
		perejil.setTipo("VEGETALES");
		perejil.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(perejil);
		
		Ingrediente brocoli = new Ingrediente();
		brocoli.setNombre("brócoli");
		brocoli.setTipo("VEGETALES");
		brocoli.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(brocoli);
		
		Ingrediente maiz = new Ingrediente();
		maiz.setNombre("ma�z");
		maiz.setTipo("VEGETALES");
		maiz.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(maiz);
		
		Ingrediente espinacas = new Ingrediente();
		espinacas.setNombre("Espinacas");
		espinacas.setTipo("VEGETALES");
		espinacas.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(espinacas);
		
		Ingrediente jengibre = new Ingrediente();
		jengibre.setNombre("Jengibre");
		jengibre.setTipo("VEGETALES");
		jengibre.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(jengibre);
		
		Ingrediente ajipicante = new Ingrediente();
		ajipicante.setNombre("aj� picante");
		ajipicante.setTipo("VEGETALES");
		ajipicante.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(ajipicante);
		
		Ingrediente apio = new Ingrediente();
		apio.setNombre("Apio");
		apio.setTipo("VEGETALES");
		apio.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(apio);
		
		Ingrediente romero = new Ingrediente();
		romero.setNombre("Romero");
		romero.setTipo("VEGETALES");
		romero.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(romero);
		
		Ingrediente cebollaroja = new Ingrediente();
		cebollaroja.setNombre("Cebolla roja");
		cebollaroja.setTipo("VEGETALES");
		cebollaroja.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(cebollaroja);
		
		Ingrediente pepino = new Ingrediente();
		pepino.setNombre("Pepino");
		pepino.setTipo("VEGETALES");
		pepino.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(pepino);
		
		Ingrediente batata = new Ingrediente();
		batata.setNombre("Batata");
		batata.setTipo("VEGETALES");
		batata.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(batata);
		
		Ingrediente calabacin = new Ingrediente();
		calabacin.setNombre("calabac�n");
		calabacin.setTipo("VEGETALES");
		calabacin.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(calabacin);
		
		Ingrediente aceituna = new Ingrediente();
		aceituna.setNombre("Aceituna");
		aceituna.setTipo("VEGETALES");
		aceituna.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(aceituna);
		
		Ingrediente berenjena = new Ingrediente();
		berenjena.setNombre("Berenjena");
		berenjena.setTipo("VEGETALES");
		berenjena.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(berenjena);
		
		Ingrediente remolacha = new Ingrediente();
		remolacha.setNombre("Remolacha");
		remolacha.setTipo("VEGETALES");
		remolacha.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(remolacha);
		
		Ingrediente calabaza = new Ingrediente();
		calabaza.setNombre("Calabaza");
		calabaza.setTipo("VEGETALES");
		calabaza.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(calabaza);
		
		Ingrediente semillasdechia = new Ingrediente();
		semillasdechia.setNombre("Semillas de chia");
		semillasdechia.setTipo("VEGETALES");
		semillasdechia.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(semillasdechia);
		
		Ingrediente semillasdelino = new Ingrediente();
		semillasdelino.setNombre("Semillas de lino");
		semillasdelino.setTipo("VEGETALES");
		semillasdelino.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(semillasdelino);
		
		Ingrediente brotesdesoja = new Ingrediente();
		brotesdesoja.setNombre("Brotes de soja");
		brotesdesoja.setTipo("VEGETALES");
		brotesdesoja.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(brotesdesoja);
			
		// CARNES
		
		Ingrediente pechugadepollo = new Ingrediente();
		pechugadepollo.setNombre("Pechuga de pollo");
		pechugadepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(pechugadepollo);
		
		Ingrediente carnechurrasco = new Ingrediente();
		carnechurrasco.setNombre("Carne churrasco");
		carnechurrasco.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(carnechurrasco);
		
		Ingrediente ossobuco = new Ingrediente();
		ossobuco.setNombre("Ossobuco");
		ossobuco.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(ossobuco);
		
		Ingrediente tocino = new Ingrediente();
		tocino.setNombre("tocino");
		tocino.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(tocino);
		
		Ingrediente salchicha = new Ingrediente();
		salchicha.setNombre("Salchicha");
		salchicha.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(salchicha);
		
		Ingrediente filetedeternera = new Ingrediente();
		filetedeternera.setNombre("Filete de ternera");
		filetedeternera.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(filetedeternera);
		
		Ingrediente jamon = new Ingrediente();
		jamon.setNombre("jamón");
		jamon.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(jamon);
		
		Ingrediente chuletasdecerdo = new Ingrediente();
		chuletasdecerdo.setNombre("Chuletas de cerdo");
		chuletasdecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(chuletasdecerdo);
		
		Ingrediente muslosdepollo = new Ingrediente();
		muslosdepollo.setNombre("Muslos de pollo");
		muslosdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(muslosdepollo);
		
		Ingrediente pavo = new Ingrediente();
		pavo.setNombre("pavo");
		pavo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(pavo);
		
		Ingrediente polloentero = new Ingrediente();
		polloentero.setNombre("Pollo entero");
		polloentero.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(polloentero);
		
		Ingrediente cerdo = new Ingrediente();
		cerdo.setNombre("cerdo");
		cerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(cerdo);
		
		Ingrediente patasdepollo = new Ingrediente();
		patasdepollo.setNombre("Patas de pollo");
		patasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(patasdepollo);
		
		Ingrediente carnedecerdo = new Ingrediente();
		carnedecerdo.setNombre("Carne de cerdo");
		carnedecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(carnedecerdo);
		
		Ingrediente chorizo = new Ingrediente();
		chorizo.setNombre("Chorizo");
		chorizo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(chorizo);
		
		Ingrediente alitasdepollo = new Ingrediente();
		alitasdepollo.setNombre("Alitas de pollo");
		alitasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(alitasdepollo);
		
		Ingrediente carneasada = new Ingrediente();
		carneasada.setNombre("Carne asada");
		carneasada.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(carneasada);
		
		Ingrediente costillasdecerdo = new Ingrediente();
		costillasdecerdo.setNombre("Costillas de cerdo");
		costillasdecerdo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(costillasdecerdo);
		
		Ingrediente cordero = new Ingrediente();
		cordero.setNombre("Cordero");
		cordero.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(cordero);
		
		Ingrediente costillasdeternera = new Ingrediente();
		costillasdeternera.setNombre("Costillas de ternera");
		costillasdeternera.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(costillasdeternera);
		
		Ingrediente pato = new Ingrediente();
		pato.setNombre("Pato");
		pato.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(pato);
		
		Ingrediente menudenciasdepollo = new Ingrediente();
		menudenciasdepollo.setNombre("Menudencias de pollo");
		menudenciasdepollo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(menudenciasdepollo);
		
		Ingrediente conejo = new Ingrediente();
		conejo.setNombre("Conejo");
		conejo.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(conejo);
		
		// PESCADO
		
		Ingrediente atunenlatado = new Ingrediente();
		atunenlatado.setNombre("at�n enlatado");
		atunenlatado.setTipo("PESCADO");
		atunenlatado.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(atunenlatado);
		
		Ingrediente filetesdepescado = new Ingrediente();
		filetesdepescado.setNombre("Filetes de pescado");
		filetesdepescado.setTipo("PESCADO");
		filetesdepescado.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(filetesdepescado);
		
		Ingrediente salmon = new Ingrediente();
		salmon.setNombre("salmón");
		salmon.setTipo("PESCADO");
		salmon.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(salmon);
		
		Ingrediente tilapia = new Ingrediente();
		tilapia.setNombre("Tilapia");
		tilapia.setTipo("PESCADO");
		tilapia.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(tilapia);
		
		Ingrediente salmonenlatado = new Ingrediente();
		salmonenlatado.setNombre("salmón enlatado");
		salmonenlatado.setTipo("PESCADO");
		salmonenlatado.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(salmonenlatado);

		Ingrediente anchoas = new Ingrediente();
		anchoas.setNombre("Anchoas");
		anchoas.setTipo("PESCADO");
		anchoas.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(anchoas);
		
		Ingrediente salmonahumado = new Ingrediente();
		salmonahumado.setNombre("salm�n ahumado");
		salmonahumado.setTipo("PESCADO");
		salmonahumado.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(salmonahumado);
		
		Ingrediente sardinas = new Ingrediente();
		sardinas.setNombre("Sardinas");
		sardinas.setTipo("PESCADO");
		sardinas.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(sardinas);
		
		Ingrediente filetedeatun = new Ingrediente();
		filetedeatun.setNombre("filete de at�n");
		filetedeatun.setTipo("PESCADO");
		filetedeatun.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(filetedeatun);
		
		Ingrediente trucha = new Ingrediente();
		trucha.setNombre("Trucha");
		trucha.setTipo("PESCADO");
		trucha.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(trucha);

		Ingrediente bagre = new Ingrediente();
		bagre.setNombre("Bagre");
		bagre.setTipo("PESCADO");
		bagre.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(bagre);
		
		Ingrediente caballa = new Ingrediente();
		caballa.setNombre("Caballa");
		caballa.setTipo("PESCADO");
		caballa.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(caballa);
		
		Ingrediente pezespada = new Ingrediente();
		pezespada.setNombre("Pez espada");
		pezespada.setTipo("PESCADO");
		pezespada.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(pezespada);
		
		Ingrediente abadejo = new Ingrediente();
		abadejo.setNombre("Abadejo");
		abadejo.setTipo("PESCADO");
		abadejo.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(abadejo);
		
		Ingrediente caviar = new Ingrediente();
		caviar.setNombre("Caviar");
		caviar.setTipo("PESCADO");
		caviar.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(caviar);

		Ingrediente pezroca = new Ingrediente();
		pezroca.setNombre("Pez roca");
		pezroca.setTipo("PESCADO");
		pezroca.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(pezroca);
		
		Ingrediente sueladelimon = new Ingrediente();
		sueladelimon.setNombre("suela de lim�n");
		sueladelimon.setTipo("PESCADO");
		sueladelimon.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(sueladelimon);
		
		Ingrediente carpa = new Ingrediente();
		carpa.setNombre("Carpa");
		carpa.setTipo("PESCADO");
		carpa.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(carpa);
		
		Ingrediente calamar = new Ingrediente();
		calamar.setNombre("Calamar");
		calamar.setTipo("PESCADO");
		calamar.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(calamar);
		
		Ingrediente cornalitos = new Ingrediente();
		cornalitos.setNombre("Cornalitos");
		cornalitos.setTipo("PESCADO");
		cornalitos.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(cornalitos);
		
		// CONDIMENTOS
		
		Ingrediente mayonesa = new Ingrediente();
		mayonesa.setNombre("Mayonesa");
		mayonesa.setTipo("CONDIMENTOS");
		mayonesa.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(mayonesa);
		
		Ingrediente salfina = new Ingrediente();
		salfina.setNombre("Sal fina");
		salfina.setTipo("CONDIMENTOS");
		salfina.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(salfina);
		
		Ingrediente salsadetomate = new Ingrediente();
		salsadetomate.setNombre("Salsa de tomate");
		salsadetomate.setTipo("CONDIMENTOS");
		salsadetomate.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadetomate);
		
		Ingrediente vinagre = new Ingrediente();
		vinagre.setNombre("Vinagre");
		vinagre.setTipo("CONDIMENTOS");
		vinagre.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagre);
		
		Ingrediente salsadesoja = new Ingrediente();
		salsadesoja.setNombre("Salsa de soja");
		salsadesoja.setTipo("CONDIMENTOS");
		salsadesoja.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadesoja);
		
		Ingrediente salsapicante = new Ingrediente();
		salsapicante.setNombre("Salsa picante");
		salsapicante.setTipo("CONDIMENTOS");
		salsapicante.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsapicante);
		
		Ingrediente salsadebarbacoa = new Ingrediente();
		salsadebarbacoa.setNombre("Salsa de barbacoa");
		salsadebarbacoa.setTipo("CONDIMENTOS");
		salsadebarbacoa.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadebarbacoa);
		
		Ingrediente aderezoranch = new Ingrediente();
		aderezoranch.setNombre("Aderezo ranch");
		aderezoranch.setTipo("CONDIMENTOS");
		aderezoranch.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(aderezoranch);
		
		Ingrediente vinagredesidrademanzana = new Ingrediente();
		vinagredesidrademanzana.setNombre("Vinagre de sidra de manzana ");
		vinagredesidrademanzana.setTipo("CONDIMENTOS");
		vinagredesidrademanzana.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredesidrademanzana);
		
		Ingrediente vinagredevino = new Ingrediente();
		vinagredevino.setNombre("Vinagre de vino");
		vinagredevino.setTipo("CONDIMENTOS");
		vinagredevino.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredevino);
		
		Ingrediente vinagredearroz = new Ingrediente();
		vinagredearroz.setNombre("Vinagre de arroz");
		vinagredearroz.setTipo("CONDIMENTOS");
		vinagredearroz.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(vinagredearroz);
		
		Ingrediente aderezoparaensaladas = new Ingrediente();
		aderezoparaensaladas.setNombre("Aderezo para ensaladas");
		aderezoparaensaladas.setTipo("CONDIMENTOS");
		aderezoparaensaladas.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(aderezoparaensaladas);
		
		Ingrediente tabasco = new Ingrediente();
		tabasco.setNombre("Tabasco");
		tabasco.setTipo("CONDIMENTOS");
		tabasco.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(tabasco);
		
		Ingrediente salsadepescado = new Ingrediente();
		salsadepescado.setNombre("Salsa de pescado");
		salsadepescado.setTipo("CONDIMENTOS");
		salsadepescado.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadepescado);
		
		Ingrediente miel = new Ingrediente();
		miel.setNombre("Miel");
		miel.setTipo("CONDIMENTOS");
		miel.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(miel);
		
		Ingrediente mostaza = new Ingrediente();
		mostaza.setNombre("Mostaza");
		mostaza.setTipo("CONDIMENTOS");
		mostaza.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(mostaza);
		
		Ingrediente salsatartara = new Ingrediente();
		salsatartara.setNombre("salsa t�rtara");
		salsatartara.setTipo("CONDIMENTOS");
		salsatartara.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsatartara);
		
		Ingrediente salsadecoctel = new Ingrediente();
		salsadecoctel.setNombre("salsa de cóctel");
		salsadecoctel.setTipo("CONDIMENTOS");
		salsadecoctel.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadecoctel);
		
		Ingrediente marsala = new Ingrediente();
		marsala.setNombre("Marsala");
		marsala.setTipo("CONDIMENTOS");
		marsala.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(marsala);
		
		Ingrediente salsadeadobo = new Ingrediente();
		salsadeadobo.setNombre("Salsa de adobo");
		salsadeadobo.setTipo("CONDIMENTOS");
		salsadeadobo.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadeadobo);
		
		Ingrediente ketchup = new Ingrediente();
		ketchup.setNombre("Ketchup");
		ketchup.setTipo("CONDIMENTOS");
		ketchup.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(ketchup);
		
		Ingrediente aderezodesesamo = new Ingrediente();
		aderezodesesamo.setNombre("aderezo de sósamo");
		aderezodesesamo.setTipo("CONDIMENTOS");
		aderezodesesamo.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(aderezodesesamo);
		
		Ingrediente ponzu = new Ingrediente();
		ponzu.setNombre("Ponzu");
		ponzu.setTipo("CONDIMENTOS");
		ponzu.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(ponzu);
		
		Ingrediente salsadepato = new Ingrediente();
		salsadepato.setNombre("Salsa de pato");
		salsadepato.setTipo("CONDIMENTOS");
		salsadepato.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadepato);
		
		Ingrediente salsapickapeppa = new Ingrediente();
		salsapickapeppa.setNombre("Salsa pickapeppa");
		salsapickapeppa.setTipo("CONDIMENTOS");
		salsapickapeppa.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsapickapeppa);
		
		Ingrediente jugodeyuzu = new Ingrediente();
		jugodeyuzu.setNombre("Jugo de yuzu");
		jugodeyuzu.setTipo("CONDIMENTOS");
		jugodeyuzu.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(jugodeyuzu);
		
		Ingrediente salsadecrema = new Ingrediente();
		salsadecrema.setNombre("Salsa de crema");
		salsadecrema.setTipo("CONDIMENTOS");
		salsadecrema.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsadecrema);
		
		Ingrediente aceitedeoliva = new Ingrediente();
		aceitedeoliva.setNombre("Aceite de oliva");
		aceitedeoliva.setTipo("CONDIMENTOS");
		aceitedeoliva.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(aceitedeoliva);
		
		Ingrediente calditoverduras = new Ingrediente();
		calditoverduras.setNombre("Caldo de verduras");
		calditoverduras.setTipo("CONDIMENTOS");
		calditoverduras.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(calditoverduras);

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
	
	Usuario martin = new Usuario();
	martin.setNombre("jorge martin");
	martin.setApellido("rivero");
	martin.setAlias("tincho");
	martin.setEmail("tincho_2235@hotmail.com");
	martin.setPassword("GUADA");
	martin.setRepassword("GUADA");
	martin.setRol("Usuario");
	servicioUsuario.guardarUsuario(martin);
	
	Usuario rossana = new Usuario();
	rossana.setNombre("jorge martin");
	rossana.setApellido("rivero");
	rossana.setAlias("tincho");
	rossana.setEmail("rossanavera2015@gmail.com");
	rossana.setPassword("GUADA");
	rossana.setRepassword("GUADA");
	rossana.setRol("Usuario");
	servicioUsuario.guardarUsuario(martin);
	
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
	return new ModelAndView("redirect:/insertar-polloalhorno");
}	
	@RequestMapping("/insertar-polloalhorno")
	public ModelAndView insertarPolloalhorno() {	

	Receta polloalhorno = new Receta();
	polloalhorno.setNombre("Pollo al horno");
	polloalhorno.setCalorias(650);
	polloalhorno.setCarpeta("polloalhorno");
	polloalhorno.setImagen("polloalhorno.jpg");
	List<Ingrediente> ipolloalhorno = new LinkedList<Ingrediente>();
	Ingrediente polloentero = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Pollo entero");
	polloentero.setCantidad(2000);
	polloentero.setCantidadstring("2kg");
	servicioIngrediente.guardarIngredienteEnReceta(polloentero);
	Ingrediente dientesdeajo = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Dientes de ajo");
	dientesdeajo.setCantidad(6);
	dientesdeajo.setCantidadstring("6u");
	servicioIngrediente.guardarIngredienteEnReceta(dientesdeajo);
	Ingrediente aceiteoliva = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Aceite de oliva");
	aceiteoliva.setCantidad(200);
	aceiteoliva.setCantidadstring("200cc");
	servicioIngrediente.guardarIngredienteEnReceta(aceiteoliva);
	Ingrediente zanahoria = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Zanahoria");
	zanahoria.setCantidad(500);
	zanahoria.setCantidadstring("1/2kg");
	servicioIngrediente.guardarIngredienteEnReceta(zanahoria);
	Ingrediente calabaza = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Calabaza");
	calabaza.setCantidad(500);
	calabaza.setCantidadstring("1/2kg");
	servicioIngrediente.guardarIngredienteEnReceta(calabaza);
	Ingrediente salfina = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Sal fina");
	salfina.setCantidad(0);
	salfina.setCantidadstring("A gusto");
	servicioIngrediente.guardarIngredienteEnReceta(salfina);
	ipolloalhorno.add(polloentero);
	ipolloalhorno.add(dientesdeajo);
	ipolloalhorno.add(aceiteoliva);
	ipolloalhorno.add(zanahoria);
	ipolloalhorno.add(calabaza);
	ipolloalhorno.add(salfina);
	polloalhorno.setDescripcion("Pollo al horno, Riqu�simo para compartir!");
	
	List<Pasos> pasospolloalhorno = new LinkedList<Pasos>();
	
	Pasos pahP1 = new Pasos();
	pahP1.setPaso(1);
	pahP1.setDescripcion("Picar los dientes de ajo, bien chiquitos y colocarlos en un recipiente con el aceite.");
	pasospolloalhorno.add(pahP1);
	servicioReceta.guardarPasoEnReceta(pahP1);
	
	Pasos pahP2 = new Pasos();
	pahP2.setPaso(2);
	pahP2.setDescripcion("Tapar y dejar macerar 10 minutos.");
	pasospolloalhorno.add(pahP2);
	servicioReceta.guardarPasoEnReceta(pahP2);
	
	Pasos pahP3 = new Pasos();
	pahP3.setPaso(3);
	pahP3.setDescripcion("Abrir el pollo, limpiarlo y colocarlo en una bandeja para horno.");
	pasospolloalhorno.add(pahP3);
	servicioReceta.guardarPasoEnReceta(pahP3);
	
	Pasos pahP4 = new Pasos();
	pahP4.setPaso(4);
	pahP4.setDescripcion("Sazonarlo con sal y col el preparado de ajo y aceite. Dejar 90 minutos en reposo.");
	pasospolloalhorno.add(pahP4);
	servicioReceta.guardarPasoEnReceta(pahP4);
	
	Pasos pahP5 = new Pasos();
	pahP5.setPaso(5);
	pahP5.setDescripcion("Llevarlo a horno fuerte, ba�ando con el mismo l�quido de la cocci�n si fuese necesario, para que no se reseque la carne.");
	pasospolloalhorno.add(pahP5);
	servicioReceta.guardarPasoEnReceta(pahP5);
	
	Pasos pahP6 = new Pasos();
	pahP6.setPaso(6);
	pahP6.setDescripcion("Hervir las zanahorias cortadas en rodajitas.");
	pasospolloalhorno.add(pahP6);
	servicioReceta.guardarPasoEnReceta(pahP6);
	
	Pasos pahP7 = new Pasos();
	pahP7.setPaso(7);
	pahP7.setDescripcion("Cocinar la calabaza y hacer un pur�.");
	pasospolloalhorno.add(pahP7);
	servicioReceta.guardarPasoEnReceta(pahP7);
	
	Pasos pahP8 = new Pasos();
	pahP8.setPaso(8);
	pahP8.setDescripcion("Retirar el pollo del horno cuando este dorado y crocante.");
	pasospolloalhorno.add(pahP8);
	servicioReceta.guardarPasoEnReceta(pahP8);
	
	Pasos pahP9 = new Pasos();
	pahP9.setPaso(9);
	pahP9.setDescripcion("Servir decorado con las zanahorias y acompa�ado del pur� de calabaza.");
	pasospolloalhorno.add(pahP9);
	servicioReceta.guardarPasoEnReceta(pahP9);
	
	polloalhorno.setlistaPasos(pasospolloalhorno);
	polloalhorno.setListaIngrediente(ipolloalhorno);
	servicioReceta.guardarReceta(polloalhorno);
	
	return new ModelAndView("redirect:/insertar-pucherodecaracu");
}
	@RequestMapping("/insertar-pucherodecaracu")
	public ModelAndView insertarPucherodecaracu() {	
		Receta pucherodecaracu = new Receta();

		pucherodecaracu.setNombre("Puchero de carac�");

		pucherodecaracu.setCalorias(750);
		
		pucherodecaracu.setCarpeta("pucherodecaracu");
		
		pucherodecaracu.setImagen("pucherodecaracu.jpg");

		pucherodecaracu.setDescripcion("Receta criolla bien Argentina !!!");

		List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();

		Ingrediente osobuco = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Ossobuco");
		osobuco.setCantidad(1500);
		osobuco.setCantidadstring("1 1/2 kg");
		servicioIngrediente.guardarIngredienteEnReceta(osobuco);
		ingredientes.add(osobuco);

		Ingrediente zanahoria = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Zanahoria");
		zanahoria.setCantidad(1000);
		zanahoria.setCantidadstring("1kg ~ (5u)");
		servicioIngrediente.guardarIngredienteEnReceta(zanahoria);
		ingredientes.add(zanahoria);

		Ingrediente papa = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Papa");
		papa.setCantidad(1000);
		papa.setCantidadstring("1kg ~ (4u)");
		servicioIngrediente.guardarIngredienteEnReceta(papa);
		ingredientes.add(papa);

		Ingrediente calabaza = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Calabaza");
		calabaza.setCantidad(1000);
		calabaza.setCantidadstring("1kg ~ (1u Chica)");
		servicioIngrediente.guardarIngredienteEnReceta(calabaza);
		ingredientes.add(calabaza);


		Ingrediente batata = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Batata");
		batata.setCantidad(1000);
		batata.setCantidadstring("1kg ~ (5u)");
		servicioIngrediente.guardarIngredienteEnReceta(batata);
		ingredientes.add(batata);

		Ingrediente cebolla = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
		cebolla.setCantidad(500);
		cebolla.setCantidadstring("1/2kg ~ (4u)");
		servicioIngrediente.guardarIngredienteEnReceta(cebolla);
		ingredientes.add(cebolla);

		Ingrediente perejil = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Perejil");
		perejil.setCantidad(0);
		perejil.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(perejil);
		ingredientes.add(perejil);

		Ingrediente dientesdeajo = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Dientes de ajo");
		dientesdeajo.setCantidad(5);
		dientesdeajo.setCantidadstring("5u");
		servicioIngrediente.guardarIngredienteEnReceta(dientesdeajo);
		ingredientes.add(dientesdeajo);

		Ingrediente calditoverduras = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Caldo de verduras");
		calditoverduras.setCantidad(2);
		calditoverduras.setCantidadstring("2u");
		servicioIngrediente.guardarIngredienteEnReceta(calditoverduras);
		ingredientes.add(calditoverduras);

		Ingrediente salfina = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Sal fina");
		salfina.setCantidad(0);
		salfina.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(salfina);
		ingredientes.add(salfina);

		Ingrediente mayonesa = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Mayonesa");
		mayonesa.setCantidad(0);
		mayonesa.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(mayonesa);
		ingredientes.add(mayonesa);

		Ingrediente limon = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Lim�n");
		limon.setCantidad(0);
		limon.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(limon);
		ingredientes.add(limon);
		
		List<Pasos> pasos = new LinkedList<Pasos>();
		
		Pasos pahP1 = new Pasos();
		pahP1.setPaso(1);
		pahP1.setImagen("p1.jpg");
		pahP1.setDescripcion("Ponemos a hervir la carne en una olla por aproximadamente 1 hora y media con un caldo saborizante a fuego fuerte y tapada. (tiernizamos bien el osobuco)");
		pasos.add(pahP1);
		servicioReceta.guardarPasoEnReceta(pahP1);
		
		Pasos pahP2 = new Pasos();
		pahP2.setPaso(2);
		pahP2.setImagen("p2.jpg");
		pahP2.setDescripcion("Pelamos las verduras, lavamos bien y las reservamos enteras (sin cortar), menos la calabaza que la cortamos en rodajas manteniendo su c�scara.");
		pasos.add(pahP2);
		servicioReceta.guardarPasoEnReceta(pahP2);
		
		Pasos pahP3 = new Pasos();
		pahP3.setPaso(3);
		pahP3.setImagen("p3.jpg");
		pahP3.setDescripcion("Pasada la hora y media de hervor de nuestra carne chequeamos su cocci�n, luego colocamos las zanahorias y las batatas.");
		pasos.add(pahP3);
		servicioReceta.guardarPasoEnReceta(pahP3);
		
		Pasos pahP4 = new Pasos();
		pahP4.setPaso(4);
		pahP4.setImagen("p4.jpg");
		pahP4.setDescripcion("Pasados 10 minutos ponemos todas las dem�s verduras m�s los dientes de ajo machacados, el perejil y el otro caldo saborizante, cocinamos a olla tapada y fuego fuerte por 20 minutos m�s.");
		pasos.add(pahP4);
		servicioReceta.guardarPasoEnReceta(pahP4);
		
		Pasos pahP5 = new Pasos();
		pahP5.setPaso(5);
		pahP5.setDescripcion("Por ulitmo, chequeamos pinchando con un cuchillo cada verdura para ver si ya est�n a punto, y listo nuestro puchero de carac�.");
		pasos.add(pahP5);
		servicioReceta.guardarPasoEnReceta(pahP5);
		
		Pasos pahP6 = new Pasos();
		pahP6.setPaso(6);
		pahP6.setDescripcion("Tips 1 : Las verduras se pueden comer enteras o hacer un rico pur� con mucho lim�n y aceite de oliva. (tambi�n con mayonesa queda muy bien).");
		pasos.add(pahP6);
		servicioReceta.guardarPasoEnReceta(pahP6);
		
		Pasos pahP7 = new Pasos();
		pahP7.setPaso(7);
		pahP7.setDescripcion("Tips 2 : La carne se puede untar con mayonesa. Usamos esas verduras pero se pueden agregar todas las que sean de su agrado. (el apio le da un sabor muy especial)");
		pasos.add(pahP7);
		servicioReceta.guardarPasoEnReceta(pahP7);
		
		Pasos pahP8 = new Pasos();
		pahP8.setPaso(8);
		pahP8.setDescripcion("Tips 3: A no olvidarse de comer el tuetano del carac� con una rica tostada o bizcocho bien crocante.");
		pasos.add(pahP8);
		servicioReceta.guardarPasoEnReceta(pahP8);
		
		Pasos pahP9 = new Pasos();
		pahP9.setPaso(9);
		pahP9.setDescripcion("Tips 4: Con el tremendo caldo que nos queda al otro d�a nos podemos hacer una fabulosa sopa de verduras. (opcional ponerle municiones).");
		pasos.add(pahP9);
		servicioReceta.guardarPasoEnReceta(pahP9);
		
		pucherodecaracu.setlistaPasos(pasos);

		pucherodecaracu.setListaIngrediente(ingredientes);
		
		servicioReceta.guardarReceta(pucherodecaracu);
	return new ModelAndView("redirect:/");
}

	@RequestMapping("/insertar-ingre-usuarios")
	public ModelAndView ingredientesAUsuarios() throws ParseException, CloneNotSupportedException {	
		
		Usuario matias = servicioUsuario.traerUnUsuarioPorSuId((long) 1);
		
		Ingrediente cebollarojamatias = new Ingrediente();
		cebollarojamatias.setNombre("cebolla roja");	
		cebollarojamatias.setFcompra("28/06/2018");
		cebollarojamatias.setCantidad(250);
		cebollarojamatias.setUnidad("Grs");
		cebollarojamatias.setTipo("VEGETALES");
		cebollarojamatias.setPerece("SEPUDRE");
		cebollarojamatias.setEstado("SINAVISO");
		
		Ingrediente manteca = new Ingrediente();
		manteca.setNombre("manteca");
		manteca.setFvencimiento("16/12/2018");
		manteca.setCantidad(500);
		manteca.setUnidad("Grs");
		manteca.setTipo("LACTEOS");
		manteca.setPerece("SEVENCE");
		manteca.setEstado("NOVENCIDO");
		
		Ingrediente quesofresco = new Ingrediente();
		quesofresco.setNombre("queso fresco");
		quesofresco.setFvencimiento("25/06/2018");
		quesofresco.setCantidad(250);
		quesofresco.setUnidad("Grs");
		quesofresco.setTipo("LACTEOS");
		quesofresco.setPerece("SEVENCE");
		quesofresco.setEstado("NOVENCIDO");

		Ingrediente huevos = new Ingrediente();
		huevos.setNombre("huevos");
		huevos.setFcompra("26/06/2018");
		huevos.setCantidad(24);
		huevos.setUnidad("Unids");
		huevos.setTipo("LACTEOS");
		huevos.setPerece("SEPUDRE");
		huevos.setEstado("SINAVISO");

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
		cebollarojajuanpi.setPerece("SEPUDRE");
		cebollarojajuanpi.setEstado("SINAVISO");
		cebollarojajuanpi.setFcompra("26/06/2018");
		
		List<Ingrediente> ingredientesdejuanpablo = juanpablo.getlistaIngrediente();
		ingredientesdejuanpablo.add(cebollarojajuanpi);

		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojajuanpi);
		juanpablo.setlistaIngrediente(ingredientesdejuanpablo);
		servicioUsuario.actualizarUsuario(juanpablo);	
		
		Usuario flor = servicioUsuario.traerUnUsuarioPorSuId((long) 3);
		
		Ingrediente cebollarojaDelInventario = servicioIngrediente.traerUnIngredientePorSuId((long) 44);
		Ingrediente cebollarojaflor = new Ingrediente();
		
		cebollarojaflor.setNombre(cebollarojaDelInventario.getNombre());		
		cebollarojaflor.setUnidad(cebollarojaDelInventario.getUnidad());
		cebollarojaflor.setTipo(cebollarojaDelInventario.getTipo());
		cebollarojaflor.setPerece(cebollarojaDelInventario.getPerece());
		cebollarojaflor.setEstado(cebollarojaDelInventario.getEstado());
		cebollarojaflor.setCantidad(500);
		cebollarojaflor.setFcompra("30/09/2018");
		
		List<Ingrediente> ingredientesdeflor = flor.getlistaIngrediente();
		ingredientesdeflor.add(cebollarojaflor);
		
		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojaflor);
		flor.setlistaIngrediente(ingredientesdeflor);
		servicioUsuario.actualizarUsuario(flor);	
				
		return new ModelAndView("redirect:/");
	}
		
}
