package objetos.futbol.UI.opciones.main;

import java.util.ArrayList;

import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.EliminarJugadaCompleja;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.ListarJugadasComplejas;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.varios.ManejoXML;
import objetos.futbol.varios.ManejoXMLeer;

/**
 * clase para administrar las jugadas complejas
 * @author luisa
 *
 */
public class AdministrarJugadasComplejas extends OpcionGeneral {
	
	static ManejoXML xml = new ManejoXML("JugadasComplejas.xml");
	static ManejoXMLeer xmleer = new ManejoXMLeer("JugadasComplejas.xml");
	private static ArrayList<JugadaCompleja> jugadaComplejas = new ArrayList<JugadaCompleja>();
	private boolean isBack = false;
	private static AdministrarJugadasComplejasFrame administrarJugadasComplejasFrame = new AdministrarJugadasComplejasFrame();

	/** 
	 * constructor paa administrar jugadas complejas sin argumentos
	 */
	public AdministrarJugadasComplejas(){
		super(true, false, "Administrar las Jugadas Complejas", "Administrar jugadas complejas", new ArrayList<Opcion>());
		this.getOpciones().add(new AgregarJugadaCompleja());
		this.getOpciones().add(new ListarJugadasComplejas());
		this.getOpciones().add(new EliminarJugadaCompleja());
		
		ArrayList<JugadaCompleja> jugadasleidas = new ArrayList<JugadaCompleja>();
		jugadasleidas = xmleer.JugadasComplejasXML();
		jugadaComplejas.addAll(jugadasleidas);
		administrarJugadasComplejasFrame.listarJugadasComplejas.cargarJugadasComplejas();
		
	}
	
	/**
	 * constructo para administrar 
	 * @param opciones
	 */
	public AdministrarJugadasComplejas(ArrayList<Opcion> opciones) {
		super(true, false, "Administrar las Jugadas Complejas", "Administrar jugadas complejas", opciones);
		ArrayList<JugadaCompleja> jugadasleidas = new ArrayList<JugadaCompleja>();
		jugadasleidas = xmleer.JugadasComplejasXML();
		jugadaComplejas.addAll(jugadasleidas);
	}

	@Override
	public void ejecutar() {
		/*isBack = false;
		while (!isBack) {
			imprimirMenu();
			selecionarrOpcion();
		}*/
		administrarJugadasComplejasFrame.setVisible(true);

	}

	@Override
	public void volverAtras() {
		isBack = true;
	}

	/**
	 * agregar jugadas ocmplejas a un XML
	 * @param jugadaCompleja
	 */
	public static void agregarJugadaCompleja(JugadaCompleja jugadaCompleja) {
		jugadaComplejas.add(jugadaCompleja);
		guardarXML();
	}

	/**
	 * quita una jugada compleja del XML
	 * @param jugadaComleja
	 */
	public static void removeJugadaCompleja(JugadaCompleja jugadaComleja) {
		jugadaComplejas.remove(jugadaComleja);
		guardarXML();
	}

	/**
	 * consultamo las jugadas complejas ue tenemos guardadas en el XML
	 * @return
	 */
	public static ArrayList<JugadaCompleja> getJugadaComplejas() {
		return jugadaComplejas;
	}

	/**
	 * guardar un array en el XML de jugadas primitivas
	 * @param jugadaComplejas
	 */
	public static void setJugadaComplejas(ArrayList<JugadaCompleja> jugadaComplejas) {
		AdministrarJugadasComplejas.jugadaComplejas = jugadaComplejas;
		guardarXML();
	}

	/**
	 * guardar XML
	 */
	public static void guardarXML() {

		xml.guardarJugadasComplejas(jugadaComplejas);
		administrarJugadasComplejasFrame.getListarJugadasComplejas().cargarJugadasComplejas();
		
	}

	public static AdministrarJugadasComplejasFrame getAdministrarJugadasComplejasFrame() {
		return administrarJugadasComplejasFrame;
	}

	public static void setAdministrarJugadasComplejasFrame(
			AdministrarJugadasComplejasFrame administrarJugadasComplejasFrame) {
		AdministrarJugadasComplejas.administrarJugadasComplejasFrame = administrarJugadasComplejasFrame;
	}


	
	

}
