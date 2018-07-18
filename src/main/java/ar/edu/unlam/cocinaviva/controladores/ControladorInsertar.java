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
		
		Ingrediente quesoralladogruyere = new Ingrediente();
		quesoralladogruyere.setNombre("Queso rallado gruyere");
		quesoralladogruyere.setTipo("LACTEOS");
		quesoralladogruyere.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(quesoralladogruyere);
		
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
		requeson.setNombre("Requesón");
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
		limon.setNombre("Limón");
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
		
		Ingrediente arrozblanco = new Ingrediente();
		arrozblanco.setNombre("Arroz blanco");
		arrozblanco.setTipo("VEGETALES");
		arrozblanco.setUnidad("Grs");
		arrozblanco.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(arrozblanco);
		
		Ingrediente arrozintegral = new Ingrediente();
		arrozintegral.setNombre("Arroz integral");
		arrozintegral.setTipo("VEGETALES");
		arrozintegral.setUnidad("Grs");
		arrozintegral.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(arrozintegral);
		
		Ingrediente papa = new Ingrediente();
		papa.setNombre("Papa");
		papa.setTipo("VEGETALES");
		papa.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(papa);
		
		Ingrediente morronrojo = new Ingrediente();
		morronrojo.setNombre("Morron rojo");
		morronrojo.setTipo("VEGETALES");
		morronrojo.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(morronrojo);
		
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
		brocoli.setNombre("Brócoli");
		brocoli.setTipo("VEGETALES");
		brocoli.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(brocoli);
		
		Ingrediente maiz = new Ingrediente();
		maiz.setNombre("Maíz");
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
		
		Ingrediente zapalloverde = new Ingrediente();
		zapalloverde.setNombre("Zapallo verde");
		zapalloverde.setTipo("VEGETALES");
		zapalloverde.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(zapalloverde);
		
		Ingrediente ajipicante = new Ingrediente();
		ajipicante.setNombre("Ají picante");
		ajipicante.setTipo("VEGETALES");
		ajipicante.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(ajipicante);
		
		Ingrediente ajimolido = new Ingrediente();
		ajimolido.setNombre("Ají molido");
		ajimolido.setTipo("VEGETALES");
		ajimolido.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(ajimolido);
		
		Ingrediente pimenton = new Ingrediente();
		pimenton.setNombre("Pimentón");
		pimenton.setTipo("VEGETALES");
		pimenton.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(pimenton);
		
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
		cebollaroja.setNombre("Cebolla morada");
		cebollaroja.setTipo("VEGETALES");
		cebollaroja.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(cebollaroja);
		
		Ingrediente pepino = new Ingrediente();
		pepino.setNombre("Pepino");
		pepino.setTipo("VEGETALES");
		pepino.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(pepino);
		
		Ingrediente batata = new Ingrediente();
		batata.setNombre("Batata");
		batata.setTipo("VEGETALES");
		batata.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(batata);
		
		Ingrediente calabacin = new Ingrediente();
		calabacin.setNombre("Calabacín");
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
		
		Ingrediente arvejas = new Ingrediente();
		arvejas.setNombre("Arvejas");
		arvejas.setTipo("VEGETALES");
		arvejas.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(arvejas);
		
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
		
		Ingrediente carnepicada = new Ingrediente();
		carnepicada.setNombre("Carne picada");
		carnepicada.setTipo("CARNES");
		servicioIngrediente.guardarIngredienteEnInventario(carnepicada);
		
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
		jamon.setNombre("Jamón");
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
		atunenlatado.setNombre("Atún enlatado");
		atunenlatado.setTipo("PESCADO");
		atunenlatado.setPerece("SEVENCE");
		atunenlatado.setUnidad("Unids");
		servicioIngrediente.guardarIngredienteEnInventario(atunenlatado);
		
		Ingrediente filetesdepescado = new Ingrediente();
		filetesdepescado.setNombre("Filetes de pescado");
		filetesdepescado.setTipo("PESCADO");
		filetesdepescado.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(filetesdepescado);
		
		Ingrediente salmon = new Ingrediente();
		salmon.setNombre("Salmón");
		salmon.setTipo("PESCADO");
		salmon.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(salmon);
		
		Ingrediente tilapia = new Ingrediente();
		tilapia.setNombre("Tilapia");
		tilapia.setTipo("PESCADO");
		tilapia.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(tilapia);
		
		Ingrediente salmonenlatado = new Ingrediente();
		salmonenlatado.setNombre("Salmón enlatado");
		salmonenlatado.setTipo("PESCADO");
		salmonenlatado.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(salmonenlatado);

		Ingrediente anchoas = new Ingrediente();
		anchoas.setNombre("Anchoas");
		anchoas.setTipo("PESCADO");
		anchoas.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(anchoas);
		
		Ingrediente salmonahumado = new Ingrediente();
		salmonahumado.setNombre("Salmón ahumado");
		salmonahumado.setTipo("PESCADO");
		salmonahumado.setPerece("SEPUDRE");
		servicioIngrediente.guardarIngredienteEnInventario(salmonahumado);
		
		Ingrediente sardinas = new Ingrediente();
		sardinas.setNombre("Sardinas");
		sardinas.setTipo("PESCADO");
		sardinas.setPerece("SEVENCE");
		servicioIngrediente.guardarIngredienteEnInventario(sardinas);
		
		Ingrediente filetedeatun = new Ingrediente();
		filetedeatun.setNombre("Filete de atún");
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
		sueladelimon.setNombre("Suela de limón");
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
		
		Ingrediente oregano = new Ingrediente();
		oregano.setNombre("Orégano");
		oregano.setTipo("CONDIMENTOS");
		oregano.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(oregano);
		
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
		salsatartara.setNombre("Salsa tártara");
		salsatartara.setTipo("CONDIMENTOS");
		salsatartara.setUnidad("Lts");
		servicioIngrediente.guardarIngredienteEnInventario(salsatartara);
		
		Ingrediente salsadecoctel = new Ingrediente();
		salsadecoctel.setNombre("Salsa de cóctel");
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
		aderezodesesamo.setNombre("Aderezo de sésamo");
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
		
		Ingrediente pimienta = new Ingrediente();
		pimienta.setNombre("Pimienta");
		pimienta.setTipo("CONDIMENTOS");
		pimienta.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(pimienta);

		Ingrediente harina = new Ingrediente();
		harina.setNombre("Harina");
		harina.setTipo("CONDIMENTOS");
		harina.setUnidad("Grs");
		servicioIngrediente.guardarIngredienteEnInventario(harina);
		
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
		/* Tenemos
		 * 
		 * Puchero de caracú
		 * Pollo al horno
		 * Arroz con atún
		 * Arroz con pollo light
		 * Arroz con vegetales
		 * 
		 */
	return new ModelAndView("redirect:/insertar-pucherodecaracu");
}	
	
	@RequestMapping("/insertar-pucherodecaracu")
	public ModelAndView insertarPucherodecaracu() {	
		Receta pucherodecaracu = new Receta();

		pucherodecaracu.setNombre("Puchero de caracú");

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

		Ingrediente limon = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Limón");
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
		pahP2.setDescripcion("Pelamos las verduras, lavamos bien y las reservamos enteras (sin cortar), menos la calabaza que la cortamos en rodajas manteniendo su cáscara.");
		pasos.add(pahP2);
		servicioReceta.guardarPasoEnReceta(pahP2);
		
		Pasos pahP3 = new Pasos();
		pahP3.setPaso(3);
		pahP3.setImagen("p3.jpg");
		pahP3.setDescripcion("Pasada la hora y media de hervor de nuestra carne chequeamos su cocción, luego colocamos las zanahorias y las batatas.");
		pasos.add(pahP3);
		servicioReceta.guardarPasoEnReceta(pahP3);
		
		Pasos pahP4 = new Pasos();
		pahP4.setPaso(4);
		pahP4.setImagen("p4.jpg");
		pahP4.setDescripcion("Pasados 10 minutos ponemos todas las demás verduras más los dientes de ajo machacados, el perejil y el otro caldo saborizante, cocinamos a olla tapada y fuego fuerte por 20 minutos más.");
		pasos.add(pahP4);
		servicioReceta.guardarPasoEnReceta(pahP4);
		
		Pasos pahP5 = new Pasos();
		pahP5.setPaso(5);
		pahP5.setDescripcion("Por ulitmo, chequeamos pinchando con un cuchillo cada verdura para ver si ya están a punto, y listo nuestro puchero de caracú.");
		pasos.add(pahP5);
		servicioReceta.guardarPasoEnReceta(pahP5);
		
		Pasos pahP6 = new Pasos();
		pahP6.setPaso(6);
		pahP6.setDescripcion("Tips 1 : Las verduras se pueden comer enteras o hacer un rico puré con mucho limón y aceite de oliva. (también con mayonesa queda muy bien).");
		pasos.add(pahP6);
		servicioReceta.guardarPasoEnReceta(pahP6);
		
		Pasos pahP7 = new Pasos();
		pahP7.setPaso(7);
		pahP7.setDescripcion("Tips 2 : La carne se puede untar con mayonesa. Usamos esas verduras pero se pueden agregar todas las que sean de su agrado. (el apio le da un sabor muy especial)");
		pasos.add(pahP7);
		servicioReceta.guardarPasoEnReceta(pahP7);
		
		Pasos pahP8 = new Pasos();
		pahP8.setPaso(8);
		pahP8.setDescripcion("Tips 3: A no olvidarse de comer el tuetano del caracú con una rica tostada o bizcocho bien crocante.");
		pasos.add(pahP8);
		servicioReceta.guardarPasoEnReceta(pahP8);
		
		Pasos pahP9 = new Pasos();
		pahP9.setPaso(9);
		pahP9.setDescripcion("Tips 4: Con el tremendo caldo que nos queda al otro día nos podemos hacer una fabulosa sopa de verduras. (opcional ponerle municiones).");
		pasos.add(pahP9);
		servicioReceta.guardarPasoEnReceta(pahP9);
		
		pucherodecaracu.setlistaPasos(pasos);

		pucherodecaracu.setListaIngrediente(ingredientes);
		
		servicioReceta.guardarReceta(pucherodecaracu);
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
	polloalhorno.setDescripcion("Pollo al horno, Riquísimo para compartir!");
	
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
	pahP5.setDescripcion("Llevarlo a horno fuerte, bañando con el mismo líquido de la cocción si fuese necesario, para que no se reseque la carne.");
	pasospolloalhorno.add(pahP5);
	servicioReceta.guardarPasoEnReceta(pahP5);
	
	Pasos pahP6 = new Pasos();
	pahP6.setPaso(6);
	pahP6.setDescripcion("Hervir las zanahorias cortadas en rodajitas.");
	pasospolloalhorno.add(pahP6);
	servicioReceta.guardarPasoEnReceta(pahP6);
	
	Pasos pahP7 = new Pasos();
	pahP7.setPaso(7);
	pahP7.setDescripcion("Cocinar la calabaza y hacer un puré.");
	pasospolloalhorno.add(pahP7);
	servicioReceta.guardarPasoEnReceta(pahP7);
	
	Pasos pahP8 = new Pasos();
	pahP8.setPaso(8);
	pahP8.setDescripcion("Retirar el pollo del horno cuando este dorado y crocante.");
	pasospolloalhorno.add(pahP8);
	servicioReceta.guardarPasoEnReceta(pahP8);
	
	Pasos pahP9 = new Pasos();
	pahP9.setPaso(9);
	pahP9.setDescripcion("Servir decorado con las zanahorias y acompañado del puré de calabaza.");
	pasospolloalhorno.add(pahP9);
	servicioReceta.guardarPasoEnReceta(pahP9);
	
	polloalhorno.setlistaPasos(pasospolloalhorno);
	polloalhorno.setListaIngrediente(ipolloalhorno);
	servicioReceta.guardarReceta(polloalhorno);
	
	return new ModelAndView("redirect:/insertar-arrozconatun");
}
	
	@RequestMapping("/insertar-arrozconatun")
	public ModelAndView insertarArrozconatun() {	
		Receta arrozconatun = new Receta();
		arrozconatun.setNombre("Arroz con atún");		
		arrozconatun.setCalorias(500);		
		arrozconatun.setCarpeta("arrozconatun");		
		arrozconatun.setImagen("arrozconatun.jpg");		
		arrozconatun.setDescripcion("Excelente opcion rapido y facil !!!");

		List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
		
		Ingrediente arrozblanco = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arroz blanco");
		arrozblanco.setCantidad(500);
		arrozblanco.setCantidadstring("1/2 kg");
		servicioIngrediente.guardarIngredienteEnReceta(arrozblanco);
		ingredientes.add(arrozblanco);

		Ingrediente cebolla = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
		cebolla.setCantidad(1000);
		cebolla.setCantidadstring("1kg");
		servicioIngrediente.guardarIngredienteEnReceta(cebolla);
		ingredientes.add(cebolla);
		
		Ingrediente atun = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Atún enlatado");
		atun.setCantidad(3);
		atun.setCantidadstring("3u");
		servicioIngrediente.guardarIngredienteEnReceta(atun);
		ingredientes.add(atun);
		
		Ingrediente aceite = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Limón");
		aceite.setCantidad(0);
		aceite.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(aceite);
		ingredientes.add(aceite);
		
		Ingrediente sal = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Limón");
		sal.setCantidad(0);
		sal.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(sal);
		ingredientes.add(sal);
		
		Ingrediente mayonesa = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Limón");
		mayonesa.setCantidad(0);
		mayonesa.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(mayonesa);
		ingredientes.add(mayonesa);
		
		List<Pasos> pasos = new LinkedList<Pasos>();
		
		Pasos p1 = new Pasos();
		p1.setPaso(1);
		p1.setDescripcion("Poner a rehogar la cebolla con el aceite.. rehogar hasta que dore y agregar el atún colado, (le deje un poco del agua) muentras este caliente y revolver. Separar."); // contactar los caracteres que no pase los 255 sino dividir en dos pasos
		pasos.add(p1);
		servicioReceta.guardarPasoEnReceta(p1);
		
		Pasos p2 = new Pasos();
		p2.setPaso(2);
		p2.setDescripcion("Hervir agua y agregar el arroz. Cocinar como dice el paquete. Colar y esperar a que enfríe un poco.");
		pasos.add(p2);
		servicioReceta.guardarPasoEnReceta(p2);
		
		Pasos p3 = new Pasos();
		p3.setPaso(3);
		p3.setDescripcion("Mezclar el atuz y cebolla con el arroz. Y dejar enfriar. Mandar a la helader 4 horas y agregarle la mayonesa y mezclar bien. Y a disfrutar. La foto es sin la mayonesa. Pero queda mucho mejor con el agregado de esta. Es a gusto");
		pasos.add(p3);
		servicioReceta.guardarPasoEnReceta(p3);
		
		arrozconatun.setlistaPasos(pasos);

		arrozconatun.setListaIngrediente(ingredientes);
		
		servicioReceta.guardarReceta(arrozconatun);
	
	return new ModelAndView("redirect:/insertar-arrozconpollolight");
	}
	
	@RequestMapping("/insertar-arrozconpollolight")
	public ModelAndView insertarArrozconpollolight() {	
		Receta receta = new Receta();
		receta.setNombre("Arroz con pollo light");		
		receta.setCalorias(450);		
		receta.setCarpeta("arrozconpollolight");		
		receta.setImagen("arrozconpollolight.jpg");		
		receta.setDescripcion("");
		
		List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
		
		Ingrediente arrozintegral = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arroz integral");
		arrozintegral.setCantidad(250);
		arrozintegral.setCantidadstring("1/4 kg");
		servicioIngrediente.guardarIngredienteEnReceta(arrozintegral);
		ingredientes.add(arrozintegral);
		
		Ingrediente pechugadepollo = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Pechuga de pollo");
		pechugadepollo.setCantidad(500);
		pechugadepollo.setCantidadstring("1/2 kg");
		servicioIngrediente.guardarIngredienteEnReceta(pechugadepollo);
		ingredientes.add(pechugadepollo);
		
		Ingrediente cebolla = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
		cebolla.setCantidad(100);
		cebolla.setCantidadstring("100g ~ (2u)");
		servicioIngrediente.guardarIngredienteEnReceta(cebolla);
		ingredientes.add(cebolla);
		
		Ingrediente aceiteoliva = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Aceite de oliva");
		aceiteoliva.setCantidad(100);
		aceiteoliva.setCantidadstring("100cc ~ (4cditas)");
		servicioIngrediente.guardarIngredienteEnReceta(aceiteoliva);
		
		Ingrediente arvejas = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arvejas");
		arvejas.setCantidad(150);
		arvejas.setCantidadstring("150g ~ (1/2 lata)");
		servicioIngrediente.guardarIngredienteEnReceta(arvejas);
		ingredientes.add(arvejas);
		
		List<Pasos> pasos = new LinkedList<Pasos>();
		
		Pasos p1 = new Pasos();
		p1.setPaso(1); 
		p1.setDescripcion("Vamos a poner la mitad del aceite y cocinar la cebolla. Una vez lista la cebolla sacar");
		pasos.add(p1);
		servicioReceta.guardarPasoEnReceta(p1);
		
		Pasos p2 = new Pasos();
		p2.setPaso(2); 
		p2.setDescripcion("En la misma sartén poner el resto de aceite más el pollo. Dejar cocinar. Poner la cebolla el arroz y las arvejas. Por último la sal");
		pasos.add(p2);
		servicioReceta.guardarPasoEnReceta(p2);
		
		receta.setlistaPasos(pasos);

		receta.setListaIngrediente(ingredientes);
		
		servicioReceta.guardarReceta(receta);
		
		return new ModelAndView("redirect:/insertar-arrozconvegetales");
	}	
	
	@RequestMapping("/insertar-arrozconvegetales")
	public ModelAndView insertarxxx() {	
		Receta receta = new Receta();
		receta.setNombre("Arroz con vegetales");		
		receta.setCalorias(650);		
		receta.setCarpeta("arrozconvegetales");		
		receta.setImagen("arrozconvegetales.jpg");		
		receta.setDescripcion("Muy rico, fácil y saludable");

		List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
		
		Ingrediente arrozblanco = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arroz blanco");
		arrozblanco.setCantidad(500);
		arrozblanco.setCantidadstring("1/2 kg");
		servicioIngrediente.guardarIngredienteEnReceta(arrozblanco);
		ingredientes.add(arrozblanco);
		
		Ingrediente morronrojo = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Morron rojo");
		morronrojo.setCantidad(1);
		morronrojo.setCantidadstring("1u");
		servicioIngrediente.guardarIngredienteEnReceta(morronrojo);
		ingredientes.add(morronrojo);

		Ingrediente pepino = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Pepino");
		pepino.setCantidad(1);
		pepino.setCantidadstring("1u");
		servicioIngrediente.guardarIngredienteEnReceta(pepino);
		ingredientes.add(pepino);
		
		Ingrediente zapalloverde = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Zapallo verde");
		zapalloverde.setCantidad(250);
		zapalloverde.setCantidadstring("1/4");
		servicioIngrediente.guardarIngredienteEnReceta(zapalloverde);
		ingredientes.add(zapalloverde);
		
		Ingrediente cebollamorada = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla morada");
		cebollamorada.setCantidad(500);
		cebollamorada.setCantidadstring("1/2");
		servicioIngrediente.guardarIngredienteEnReceta(cebollamorada);
		ingredientes.add(cebollamorada);
		
		Ingrediente zanahoria = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Zanahoria");
		zanahoria.setCantidad(500);
		zanahoria.setCantidadstring("1/2");
		servicioIngrediente.guardarIngredienteEnReceta(zanahoria);
		ingredientes.add(zanahoria);
		
		Ingrediente ajimolido = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Ají molido");
		ajimolido.setCantidad(20);
		ajimolido.setCantidadstring("1 cdita");
		servicioIngrediente.guardarIngredienteEnReceta(ajimolido);
		ingredientes.add(ajimolido);
		
		Ingrediente pimenton = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Pimentón");
		pimenton.setCantidad(40);
		pimenton.setCantidadstring("2 cditas");
		servicioIngrediente.guardarIngredienteEnReceta(pimenton);
		ingredientes.add(pimenton);
		
		Ingrediente sal = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Limón");
		sal.setCantidad(0);
		sal.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(sal);
		ingredientes.add(sal);
		
		List<Pasos> pasos = new LinkedList<Pasos>();
		
		Pasos p1 = new Pasos();
		p1.setPaso(1); 
		p1.setImagen("p1.jpg");
		p1.setDescripcion("Hervimos el arroz. Reservamos");
		pasos.add(p1);
		servicioReceta.guardarPasoEnReceta(p1);
		
		Pasos p2 = new Pasos();
		p2.setPaso(2); 
		p2.setImagen("p2.jpg");
		p2.setDescripcion("Cortamos el morrón y la cebolla en juliana, rallamos la zanahoria, y cortamos el zapallito verde y el zuchini en cuadradaitos.");
		pasos.add(p2);
		servicioReceta.guardarPasoEnReceta(p2);
		
		Pasos p3 = new Pasos();
		p3.setPaso(3); 
		p3.setImagen("p3.jpg");
		p3.setDescripcion("Colocamos todo en un wok o en una sartén grande con un poco de aceite (preferentemente oliva). Cocinamos aprox. Durante 20 min, hasta que el zapallito se haya ablandado. Condimentamos con ají molido, pimentón y sal.");
		pasos.add(p3);
		servicioReceta.guardarPasoEnReceta(p3);
		
		Pasos p4 = new Pasos();
		p4.setPaso(4); 
		p4.setImagen("p4.jpg");
		p4.setDescripcion("Mezclamos con el arroz, servimos y a disfrutar de una comida rápida y saludable!");
		pasos.add(p4);
		servicioReceta.guardarPasoEnReceta(p4);
		
		receta.setlistaPasos(pasos);

		receta.setListaIngrediente(ingredientes);
		
		servicioReceta.guardarReceta(receta);
	
	return new ModelAndView("redirect:/insertar-Tomaterellenoalhorno");
	}
	
	@RequestMapping("/insertar-Tomaterellenoalhorno")
	public ModelAndView insertarTomaterellenoalhorno() {	
		Receta receta = new Receta();
		receta.setNombre("Tomate relleno al horno");		
		receta.setCalorias(600);		
		receta.setCarpeta("tomaterellenoalhorno");		
		receta.setImagen("tomaterellenoalhorno.jpg");		
		receta.setDescripcion("Delicioso =)");

		List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
		
		Ingrediente ing1 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Tomate");
		ing1.setCantidad(500);
		ing1.setCantidadstring("1/2 kg");
		servicioIngrediente.guardarIngredienteEnReceta(ing1);
		ingredientes.add(ing1);

		Ingrediente ing2 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Carne picada");
		ing2.setCantidad(200);
		ing2.setCantidadstring("200g");
		servicioIngrediente.guardarIngredienteEnReceta(ing2);
		ingredientes.add(ing2);

		Ingrediente ing3 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Zanahoria");
		ing3.setCantidad(200);
		ing3.setCantidadstring("200g ~ (2u)");
		servicioIngrediente.guardarIngredienteEnReceta(ing3);
		ingredientes.add(ing3);

		Ingrediente ing4 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
		ing4.setCantidad(100);
		ing4.setCantidadstring("100g ~ (1u)");
		servicioIngrediente.guardarIngredienteEnReceta(ing4);
		ingredientes.add(ing4);

		Ingrediente ing5 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Huevos");
		ing5.setCantidad(2);
		ing5.setCantidadstring("2u");
		servicioIngrediente.guardarIngredienteEnReceta(ing5);
		ingredientes.add(ing5);

		Ingrediente ing6 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Queso rallado gruyere");
		ing6.setCantidad(150);
		ing6.setCantidadstring("150g ~ (1paquete)");
		servicioIngrediente.guardarIngredienteEnReceta(ing6);
		ingredientes.add(ing6);

		Ingrediente ing7 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Orégano");
		ing7.setCantidad(0);
		ing7.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(ing7);
		ingredientes.add(ing7);

		Ingrediente ing8 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Sal fina");
		ing8.setCantidad(0);
		ing8.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(ing8);
		ingredientes.add(ing8);

		Ingrediente ing9 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Pimienta");
		ing9.setCantidad(0);
		ing9.setCantidadstring("A gusto");
		servicioIngrediente.guardarIngredienteEnReceta(ing9);
		ingredientes.add(ing9);
		
		List<Pasos> pasos = new LinkedList<Pasos>();
		
		Pasos p1 = new Pasos();
		p1.setPaso(1); 
		p1.setDescripcion("Vaciar los tomates.  Freír la cebolla y la zanahoria. Cuando ya esté añadir la carne de los tomates sal pimentar y poner orégano."); 
		pasos.add(p1);
		servicioReceta.guardarPasoEnReceta(p1);
		
		Pasos p2 = new Pasos();
		p2.setPaso(2);
		p2.setDescripcion("Que esté bien hecho no debe quedar caldo. En un bol grande mezclar el gruyere (150g) el huevo cortado pequeño con la carne sofrita.");
		pasos.add(p2);
		servicioReceta.guardarPasoEnReceta(p2);

		Pasos p3 = new Pasos();
		p3.setPaso(3);
		p3.setDescripcion("En una bandeja de pyrex, rellenar los tomates y poner por encima gruyere y orégano.");
		pasos.add(p3);
		servicioReceta.guardarPasoEnReceta(p3);

		Pasos p4 = new Pasos();
		p4.setPaso(4);
		p4.setDescripcion("Al horno el tiempo que se haga el tomate. Entre 25 y 30mn.  Sacar dejar reposar unos 10mn y servir. Una delicia.");
		pasos.add(p4);
		servicioReceta.guardarPasoEnReceta(p4);
		
		receta.setlistaPasos(pasos);

		receta.setListaIngrediente(ingredientes);
		
		servicioReceta.guardarReceta(receta);
	
	return new ModelAndView("redirect:/insertar-croquetaarroz");
	}
	
	@RequestMapping("/insertar-croquetaarroz")
	  public ModelAndView insertarcroquetaarroz() { 
	    Receta croquetaarroz= new Receta();
	    croquetaarroz.setNombre("Croquetas de Arroz");    
	    croquetaarroz.setCalorias(360);   
	    croquetaarroz.setCarpeta("croquetaarroz");    
	    croquetaarroz.setImagen("croquetaarroz.jpg");   
	    croquetaarroz.setDescripcion("¿Te ha sobrado arroz del día de ayer y no sabes qué hacer con él? Entonces preparà unas croquetas de arroz. Son deliciosas y nada complicadas de hacer.");

	    List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	    
	    Ingrediente ing1 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arroz blanco");
	    ing1.setCantidad(450);
	    ing1.setCantidadstring("450gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing1);
	    ingredientes.add(ing1);

	    Ingrediente ing2 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Queso mozzarella");
	    ing2.setCantidad(100);
	    ing2.setCantidadstring("100gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing2);
	    ingredientes.add(ing2);
	    
	    Ingrediente ing3 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Queso parmesano");
	    ing3.setCantidad(25);
	    ing3.setCantidadstring("25gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing3);
	    ingredientes.add(ing3);

	    Ingrediente ing4 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Huevos");
	    ing4.setCantidad(2);
	    ing4.setCantidadstring("2u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing4);
	    ingredientes.add(ing4);

	    List<Pasos> pasos = new LinkedList<Pasos>();
	    
	    Pasos p1 = new Pasos();
	    p1.setPaso(1); 
	    p1.setDescripcion("Coloca el arroz en un recipiente grande. Añade los huevos primero y comienza a mezclar con el arroz. Debes conseguir una consistencia adecuada como para crear bolas.");
	    pasos.add(p1);
	    servicioReceta.guardarPasoEnReceta(p1);
	    
	    Pasos p2 = new Pasos();
	    p2.setPaso(2);
	    p2.setDescripcion("Mezcla hasta que el arroz esté todo cubierto de huevo. Luego agrega el queso parmesano y mezcla bien. Si lo deseas, puedes agregar otros ingredientes como jamón picado.");
	    pasos.add(p2);
	    servicioReceta.guardarPasoEnReceta(p2);
	    
	    Pasos p3 = new Pasos();
	    p3.setPaso(3); 
	    p3.setDescripcion("Toma una parte del arroz con tu mano y coloca unos dados de mozzarrella en él. Cierra la croqueta en el interior haciendo una bola con el arroz. Luego hazla rodar sobre el pan rallado. Aplasta un poco la bola asegurándote de que no se quiebre.");
	    pasos.add(p3);
	    servicioReceta.guardarPasoEnReceta(p3);
	    
	  
	    Pasos p4 = new Pasos();
	    p4.setPaso(4); 
	    p4.setDescripcion("Calienta bien el aceite. Agrega las croquetas a la sartén. Remueve suavemente para que no se peguen al fondo. Fríe hasta que las croquetas estén bien doradas. Luego transfiérelas a una fuente forrada con papel de cocina para absorber el exceso de aceite.");
	    pasos.add(p4);
	    servicioReceta.guardarPasoEnReceta(p4);

	    

	    croquetaarroz.setlistaPasos(pasos);

	    croquetaarroz.setListaIngrediente(ingredientes);
	    
	    servicioReceta.guardarReceta(croquetaarroz);
	  
	  return new ModelAndView("redirect:/insertar-budinespinacas");
	  }


	@RequestMapping("/insertar-budinespinacas")
	  public ModelAndView insertarbudinespinacas() {  
	    Receta budinespinacas= new Receta();
	    budinespinacas.setNombre("Budìn de Espinacas");   
	    budinespinacas.setCalorias(43060);    
	    budinespinacas.setCarpeta("budinespinacas");    
	    budinespinacas.setImagen("budinespinacas.jpg");   
	    budinespinacas.setDescripcion("Un budín salado muy fácil de preparar, y de tip, viene con versión para microondas");

	    List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	    
	    Ingrediente ing1 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Espinacas");
	    ing1.setCantidad(400);
	    ing1.setCantidadstring("400gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing1);
	    ingredientes.add(ing1);

	    Ingrediente ing2 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
	    ing2.setCantidad(2);
	    ing2.setCantidadstring("2u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing2);
	    ingredientes.add(ing2);
	    
	    Ingrediente ing3 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Queso parmesano");
	    ing3.setCantidad(25);
	    ing3.setCantidadstring("25gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing3);
	    ingredientes.add(ing3);

	    Ingrediente ing4 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Huevos");
	    ing4.setCantidad(3);
	    ing4.setCantidadstring("3u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing4);
	    ingredientes.add(ing4);

	    Ingrediente ing5 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Harina");
	    ing5.setCantidad(150);
	    ing5.setCantidadstring("150gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing5);
	    ingredientes.add(ing5);

	    List<Pasos> pasos = new LinkedList<Pasos>();
	    
	    Pasos p1 = new Pasos();
	    p1.setPaso(1); 
	    p1.setDescripcion("Dorá las cebollas en una sartén con aceite. Dejá enfriar.Agregá  las espinaca con los huevos y el queso rallado. Mezclá bien y condimentá con sal, pimienta y nuez moscada.");
	    pasos.add(p1);
	    servicioReceta.guardarPasoEnReceta(p1);
	    
	    Pasos p2 = new Pasos();
	    p2.setPaso(2);
	    p2.setDescripcion("Agregá la harina. Mezcla.");
	    pasos.add(p2);
	    servicioReceta.guardarPasoEnReceta(p2);
	    
	    Pasos p3 = new Pasos();
	    p3.setPaso(3); 
	    p3.setDescripcion("Volcá la preparación en una budinera alargada, enmantecada y enharinada");
	    pasos.add(p3);
	    servicioReceta.guardarPasoEnReceta(p3);
	    
	  
	    Pasos p4 = new Pasos();
	    p4.setPaso(4); 
	    p4.setDescripcion("Llevá a horno de temperatura mediana hasta que pinchando con un palillo en el centro salga limpio.");
	    pasos.add(p4);
	    servicioReceta.guardarPasoEnReceta(p4);

	    

	    budinespinacas.setlistaPasos(pasos);

	    budinespinacas.setListaIngrediente(ingredientes);
	    
	    servicioReceta.guardarReceta(budinespinacas);
	  
	  return new ModelAndView("redirect:/insertar-tortilladepapa");
	  }
	@RequestMapping("/insertar-tortilladepapa")
	  public ModelAndView insertartortilladepapa() {  
	    Receta tortilladepapa= new Receta();
	    tortilladepapa.setNombre("Tortilla de Papa");   
	    tortilladepapa.setCalorias(43060);    
	    tortilladepapa.setCarpeta("tortilladepapa");    
	    tortilladepapa.setImagen("tortilladepapa.jpg");   
	    tortilladepapa.setDescripcion("Tortilla de papa muy fácil de preparar");

	    List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	    
	    Ingrediente ing1 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Papa");
	    ing1.setCantidad(800);
	    ing1.setCantidadstring("800gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing1);
	    ingredientes.add(ing1);

	    Ingrediente ing2 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
	    ing2.setCantidad(1);
	    ing2.setCantidadstring("1u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing2);
	    ingredientes.add(ing2);
	    
	    Ingrediente ing3 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Jamón");
	    ing3.setCantidad(150);
	    ing3.setCantidadstring("150gr");
	    servicioIngrediente.guardarIngredienteEnReceta(ing3);
	    ingredientes.add(ing3);

	    Ingrediente ing4 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Huevos");
	    ing4.setCantidad(6);
	    ing4.setCantidadstring("6u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing4);
	    ingredientes.add(ing4);

	    List<Pasos> pasos = new LinkedList<Pasos>();
	    
	    Pasos p1 = new Pasos();
	    p1.setPaso(1); 
	    p1.setDescripcion("Elegir papas medianas, cortarlas en cubos y rehogarlas en un poco aceite junto con la cebolla picada");
	    pasos.add(p1);
	    servicioReceta.guardarPasoEnReceta(p1);
	    
	    Pasos p2 = new Pasos();
	    p2.setPaso(2);
	    p2.setDescripcion("Tapar la sartén y cocinar hasta que estén blandas las papas");
	    pasos.add(p2);
	    servicioReceta.guardarPasoEnReceta(p2);
	    
	    Pasos p3 = new Pasos();
	    p3.setPaso(3); 
	    p3.setDescripcion("Una vez listo, escurrirles el excedente de aceite y volcar sobre los huevos ligeramente batidos. Agregar también el jamón cortado en tiritas,Mezclar");
	    pasos.add(p3);
	    servicioReceta.guardarPasoEnReceta(p3);
	    
	  
	    Pasos p4 = new Pasos();
	    p4.setPaso(4); 
	    p4.setDescripcion("Calentar una sartén de teflón con apenas un chorro de aceite a fuego medio, ni suave ni fuerte, y volcar en ella la preparación cuidando de llegar bien a todos los bordes");
	    pasos.add(p4);
	    servicioReceta.guardarPasoEnReceta(p4);
	    
	    Pasos p5 = new Pasos();
	    p5.setPaso(5); 
	    p5.setDescripcion("Cocinar por 10 minutos hasta que la mezcla de huevos coagule y la tortilla haya hecho base");
	    pasos.add(p5);
	    servicioReceta.guardarPasoEnReceta(p5);

	    

	    tortilladepapa.setlistaPasos(pasos);

	    tortilladepapa.setListaIngrediente(ingredientes);
	    
	    servicioReceta.guardarReceta(tortilladepapa);
	  
	  return new ModelAndView("redirect:/insertar-tartaratatouille");
	  }

	@RequestMapping("/insertar-tartaratatouille")
	  public ModelAndView insertartartaratatouille() {  
	    Receta tartaratatouille= new Receta();
	    tartaratatouille.setNombre("Tarta ratatouille");   
	    tartaratatouille.setCalorias(43060);    
	    tartaratatouille.setCarpeta("tartaratatouille");    
	    tartaratatouille.setImagen("tartaratatouille	.jpg");   
	    tartaratatouille.setDescripcion("Una tarta sana y muy sabrosa");

	    List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	    
	    Ingrediente ing1 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Morron rojo");
	    ing1.setCantidad(1);
	    ing1.setCantidadstring("1u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing1);
	    ingredientes.add(ing1);

	    Ingrediente ing2 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
	    ing2.setCantidad(1);
	    ing2.setCantidadstring("1u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing2);
	    ingredientes.add(ing2);
	    
	    Ingrediente ing3 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Berenjena");
	    ing3.setCantidad(2);
	    ing3.setCantidadstring("2u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing3);
	    ingredientes.add(ing3);

	    Ingrediente ing4 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Huevos");
	    ing4.setCantidad(3);
	    ing4.setCantidadstring("3u");
	    servicioIngrediente.guardarIngredienteEnReceta(ing4);
	    ingredientes.add(ing4);

	    List<Pasos> pasos = new LinkedList<Pasos>();
	    
	    Pasos p1 = new Pasos();
	    p1.setPaso(1); 
	    p1.setDescripcion("Cortar las verduras en cubitos, agregar un poco de tomillo, saltear en un poco de aceite hasta tiernizar. Enfriar.");
	    pasos.add(p1);
	    servicioReceta.guardarPasoEnReceta(p1);
	    
	    Pasos p2 = new Pasos();
	    p2.setPaso(2);
	    p2.setDescripcion("Batir los huevos con el yogur, sal, pimienta y una pizca de azúcar.");
	    pasos.add(p2);
	    servicioReceta.guardarPasoEnReceta(p2);
	    
	    Pasos p3 = new Pasos();
	    p3.setPaso(3); 
	    p3.setDescripcion("Cubrir una tartera con la masa, volcar el relleno y hornear a fuego mediano durante 40 minutos. Servir.");
	    pasos.add(p3);
	    servicioReceta.guardarPasoEnReceta(p3);
	    
	  
	  
	    
	   

	    

	    tartaratatouille.setlistaPasos(pasos);

	    tartaratatouille.setListaIngrediente(ingredientes);
	    
	    servicioReceta.guardarReceta(tartaratatouille);
	  
	  return new ModelAndView("redirect:/");
	  }


	   
/*	
    Molde 
	@RequestMapping("/insertar-xxx")
	public ModelAndView insertarxxx() {	
		Receta receta = new Receta();
		receta.setNombre("");		
		receta.setCalorias();		
		receta.setCarpeta("");		
		receta.setImagen("xxx.jpg");		
		receta.setDescripcion("");

		List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
		
		Ingrediente ing1 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arroz blanco");
		ing1.setCantidad(500);
		ing1.setCantidadstring("1/2 kg");
		servicioIngrediente.guardarIngredienteEnReceta(ing1);
		ingredientes.add(ing1);

		Ingrediente ing2 = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
		ing2.setCantidad(1000);
		ing2.setCantidadstring("1kg");
		servicioIngrediente.guardarIngredienteEnReceta(ing2);
		ingredientes.add(ing2);
		
		List<Pasos> pasos = new LinkedList<Pasos>();
		
		Pasos p1 = new Pasos();
		p1.setPaso(1); 
		p1.setImagen("p1.jpg");	// si no tiene imagen volarla - pueden haber pasos con imagenes y pasos que no, no pasa nada
		p1.setDescripcion(""); // contactar los caracteres que no pase los 255 sino dividir en dos pasos
		pasos.add(p1);
		servicioReceta.guardarPasoEnReceta(p1);
		
		Pasos p2 = new Pasos();
		p2.setPaso(2);
		p2.setDescripcion("");
		pasos.add(p2);
		servicioReceta.guardarPasoEnReceta(p2);
		
		receta.setlistaPasos(pasos);

		receta.setListaIngrediente(ingredientes);
		
		servicioReceta.guardarReceta(receta);
	
	return new ModelAndView("redirect:/redireccionalotroingrediente");
	}
*/	

	@RequestMapping("/insertar-ingre-usuarios")
	public ModelAndView ingredientesAUsuarios() throws ParseException, CloneNotSupportedException {	
		//Ingredientes
		Ingrediente cebollarojaDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla morada");
		Ingrediente cebollaDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Cebolla");
		Ingrediente polloenteroDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Pollo entero");
		Ingrediente arrozblancoDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arroz blanco");
		Ingrediente tomateDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Tomate");
		Ingrediente lechugaDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Lechuga");
		Ingrediente pdepolloDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Pechuga de pollo");
		Ingrediente arrozintDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arroz integral");
		Ingrediente arvejasDelInventario = servicioIngrediente.traerUnIngredienteDelInventarioPorSuNombre("Arvejas");
				
		Usuario matias = servicioUsuario.traerUnUsuarioPorSuId((long) 1);
		
		Ingrediente pdepollo = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(pdepolloDelInventario);
		pdepollo.setCantidad(1000);
		pdepollo.setFcompra("12/07/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(pdepollo);	
		
		Ingrediente arrozintDeMati = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(arrozintDelInventario);
		arrozintDeMati.setCantidad(1000);
		arrozintDeMati.setFvencimiento("30/12/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(arrozintDeMati);	
		
		Ingrediente arvejasDeMati = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(arvejasDelInventario);
		arvejasDeMati.setCantidad(1000);
		arvejasDeMati.setFcompra("15/07/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(arvejasDeMati);	
			
		Ingrediente cebollaDeMati = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(cebollaDelInventario);
		cebollaDeMati.setCantidad(1000);
		cebollaDeMati.setFcompra("08/07/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(cebollaDeMati);	
		
		Ingrediente polloenteroDeMati = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(polloenteroDelInventario);
		polloenteroDeMati.setCantidad(3000);
		polloenteroDeMati.setFcompra("12/07/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(polloenteroDeMati);	
		
		Ingrediente arrozDeMati = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(arrozblancoDelInventario);
		arrozDeMati.setCantidad(500);
		arrozDeMati.setFvencimiento("21/07/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(arrozDeMati);	
		
		Ingrediente tomateDeMati = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(tomateDelInventario);
		tomateDeMati.setCantidad(1500);
		tomateDeMati.setFcompra("14/07/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(tomateDeMati);	
		
		Ingrediente lechugaDeMati = servicioIngrediente.traerCopiaDeUnIngredienteDelInventario(lechugaDelInventario);
		lechugaDeMati.setCantidad(3);
		lechugaDeMati.setFcompra("13/07/2018");
		servicioIngrediente.guardarIngredienteEnUsuario(lechugaDeMati);	
		
		List<Ingrediente> ingredientesdematias  = matias.getlistaIngrediente();
		ingredientesdematias.add(cebollaDeMati);
		ingredientesdematias.add(polloenteroDeMati);
		ingredientesdematias.add(arrozDeMati);
		ingredientesdematias.add(tomateDeMati);
		ingredientesdematias.add(lechugaDeMati);  
		ingredientesdematias.add(pdepollo);
		ingredientesdematias.add(arrozintDeMati);
		ingredientesdematias.add(arvejasDeMati);
		
		matias.setlistaIngrediente(ingredientesdematias);
		servicioUsuario.actualizarUsuario(matias);	
		
			
		Usuario juanpablo = servicioUsuario.traerUnUsuarioPorSuId((long) 2);
		
		Ingrediente cebollarojajuanpi = new Ingrediente();
		
		cebollarojajuanpi.setNombre(cebollarojaDelInventario.getNombre());		
		cebollarojajuanpi.setUnidad(cebollarojaDelInventario.getUnidad());
		cebollarojajuanpi.setTipo(cebollarojaDelInventario.getTipo());
		cebollarojajuanpi.setPerece(cebollarojaDelInventario.getPerece());
		cebollarojajuanpi.setEstado(cebollarojaDelInventario.getEstado());
		cebollarojajuanpi.setCantidad(1000);
		cebollarojajuanpi.setFcompra("30/09/2018");
		
		List<Ingrediente> ingredientesdejuanpablo = juanpablo.getlistaIngrediente();
		ingredientesdejuanpablo.add(cebollarojajuanpi);
		
		servicioIngrediente.guardarIngredienteEnUsuario(cebollarojajuanpi);
		juanpablo.setlistaIngrediente(ingredientesdejuanpablo);
		servicioUsuario.actualizarUsuario(juanpablo);	
		
		
		Usuario flor = servicioUsuario.traerUnUsuarioPorSuId((long) 3);
		
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
