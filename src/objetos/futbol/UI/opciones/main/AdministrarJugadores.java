package objetos.futbol.UI.opciones.main;

import java.io.File;
import java.util.ArrayList;

import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.opciones.main.administrarJugadores.AgregarJugadaComplejaJugador;
import objetos.futbol.UI.opciones.main.administrarJugadores.AgregarJugador;
import objetos.futbol.UI.opciones.main.administrarJugadores.DescripcionJugadasComplejas;
import objetos.futbol.UI.opciones.main.administrarJugadores.EliminarJugador;
import objetos.futbol.UI.opciones.main.administrarJugadores.InformacionBasicaJugador;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadores;
import objetos.futbol.UI.opciones.main.administrarRobot.AgregarRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobots;
import objetos.futbol.UI.opciones.main.administrarRobot.QuitarRobot;
import objetos.futbol.UI.opciones.main.administrarUsuarios.AgregarUsuario;
import objetos.futbol.UI.opciones.main.administrarUsuarios.EliminarUsuario;
import objetos.futbol.UI.opciones.main.administrarUsuarios.ListarUsuarios;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.varios.ManejoXML;
import objetos.futbol.varios.*;
/**
 * clase hija de opcion general para administrar los jugadores
 * @author luisa
 *
 */
public class AdministrarJugadores extends OpcionGeneral {
	private boolean backFlag=false;
	private static ArrayList<Delantero> delanteros=new ArrayList<Delantero>();
	private static ArrayList<Arquero> arqueros=new ArrayList<Arquero>();
	private static AdministrarJugadoresFrame administrarJugadoresFrame= new AdministrarJugadoresFrame();
	private static AdministrarJugadasComplejasFrame administrarJugadasComplejasFrame= new AdministrarJugadasComplejasFrame();

	/**
	 * constructor de administrar jugadores
	 * @param opciones
	 */
	public AdministrarJugadores(ArrayList<Opcion> opciones) {
		super(true, false, "Permite administrar los diferentes jugadores", "Administrar Jugadores", opciones);
		ArrayList<Delantero> delanteros=ManejoXMLeer.leerDelanteroXML();
		ArrayList<Arquero> arqueros=ManejoXMLeer.leerArqueroXML();
		AdministrarJugadores.getArqueros().addAll(arqueros);
		AdministrarJugadores.getDelanteros().addAll(delanteros);
		
	}
	
	/**
	 * constructor sin argumentos de administrar jugadores
	 */
	public AdministrarJugadores() {
		// TODO Auto-generated constructor stub
		super(true, false, "Permite administrar los diferentes jugadores", "Administrar Jugadores", new ArrayList<Opcion>() );
		this.getOpciones().add(new AgregarJugadaComplejaJugador() );
		this.getOpciones().add(new AgregarJugador());
		this.getOpciones().add(new EliminarJugador());
		this.getOpciones().add(new ListarJugadores());
		this.getOpciones().add(new DescripcionJugadasComplejas());
		this.getOpciones().add(new InformacionBasicaJugador());
		ArrayList<Delantero> delanteros=ManejoXMLeer.leerDelanteroXML();
		ArrayList<Arquero> arqueros=ManejoXMLeer.leerArqueroXML();
		AdministrarJugadores.getArqueros().addAll(arqueros);
		AdministrarJugadores.getDelanteros().addAll(delanteros);
		administrarJugadoresFrame.listarJugadores.cargarJugadores();
		administrarJugadasComplejasFrame.listarJugadasComplejas.cargarJugadasComplejas();
	}
	
	
	
	@Override
	public void ejecutar() {
		/*
		backFlag=false;
		while (!backFlag) {
			imprimirMenu();
			selecionarrOpcion();
		}
		*/
		administrarJugadoresFrame.setVisible(true);

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub
		backFlag=true;

	}
	
	/**
	 * agregar un delantero a los jugadores
	 * @param delantero
	 */
	public static void addDelantero(Delantero delantero){
		AdministrarJugadores.delanteros.add(delantero);
		guardarXML();
	}
	/**
	 * quita un delantero del XML
	 * @param delantero
	 */
	public static void removeDelantero(Delantero delantero){
		AdministrarJugadores.delanteros.remove(delantero);
		guardarXML();
		
	}
	/**
	 * agregar un arquero al XML
	 * @param arquero
	 */
	public static void addArquero(Arquero arquero){
		AdministrarJugadores.arqueros.add(arquero);
		guardarXML();
	}
	
	/**
	 * quitar el arquero del XML
	 * @param arquero
	 */
	public static void removeArquero(Arquero arquero){
		AdministrarJugadores.arqueros.remove(arquero);
		guardarXML();
	}

	/**
	 * consultar el array de delanteros
	 * @return
	 */
	public static ArrayList<Delantero> getDelanteros() {
		return delanteros;
	}

	/**
	 * agregar el array de delanteros
	 * @param delanteros
	 */
	public static void setDelanteros(ArrayList<Delantero> delanteros) {
		AdministrarJugadores.delanteros = delanteros;
		guardarXML();
	}

	/**
	 * consultar el array de arqueros
	 * @return
	 */
	public static ArrayList<Arquero> getArqueros() {
		return arqueros;
	}

	/**
	 * agregar un array de arqueros
	 * @param arqueros
	 */
	public static void setArqueros(ArrayList<Arquero> arqueros) {
		AdministrarJugadores.arqueros = arqueros;
		guardarXML();
	}
	/**
	 * guardar un XML 
	 */
	public static void guardarXML(){
		//TODO Guardar XML com arqueros y jugadores
		ManejoXML manejoXML= new ManejoXML("jugadores.xml");
		ArrayList<Futbolista> futbolistas= new ArrayList<Futbolista>();
		futbolistas.addAll(arqueros);
		futbolistas.addAll(delanteros);
		manejoXML.guardarFutbolistas(futbolistas);
		administrarJugadoresFrame.listarJugadores.cargarJugadores();
	}

	public static AdministrarJugadoresFrame getAdministrarJugadoresFrame() {
		return administrarJugadoresFrame;
	}

	public static void setAdministrarJugadoresFrame(AdministrarJugadoresFrame administrarJugadoresFrame) {
		AdministrarJugadores.administrarJugadoresFrame = administrarJugadoresFrame;
	}
	

}
