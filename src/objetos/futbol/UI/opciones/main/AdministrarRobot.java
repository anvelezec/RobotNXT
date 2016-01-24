package objetos.futbol.UI.opciones.main;

import java.util.ArrayList;

import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;
import objetos.futbol.UI.opciones.main.administrarRobot.AgregarRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.EstablecerJugadorRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobots;
import objetos.futbol.UI.opciones.main.administrarRobot.QuitarRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.configurarBTRobot;
import objetos.futbol.robot.Robot;
import objetos.futbol.varios.ManejoXML;
import objetos.futbol.varios.ManejoXMLeer;
/**
 * clase para administrar el robot
 * @author luisa
 *
 */
public class AdministrarRobot extends OpcionGeneral {
	private boolean backFlag = false;
	private static ArrayList<Robot> robots = new ArrayList<Robot>();
	private boolean isBack = false;
	private static AdministrarRobotFrame administrarRobotFrame= new AdministrarRobotFrame();

	/**
	 * constructor para administrar el robot sin argumentos
	 */
	public AdministrarRobot() {
		super(true, true, "Administrar los diferentes robots", "Administrar Robot", new ArrayList<Opcion>());
		this.getOpciones().add(new AgregarRobot());
		this.getOpciones().add(new ListarRobots());
		this.getOpciones().add(new QuitarRobot());
		this.getOpciones().add(new EstablecerJugadorRobot());
		ManejoXMLeer leer = new ManejoXMLeer("Robots.xml");
		robots.addAll(leer.leerRobotsXML());
		administrarRobotFrame.getListarRobots().cargarRobots();
		// this.getOpciones().add(new configurarBTRobot());
		
	}

	/**
	 * constructor para administrar robot 
	 * @param opcions
	 */
	public AdministrarRobot(ArrayList<Opcion> opcions) {
		super(true, true, "Administrar los diferentes robots", "Administrar Robot", opcions);
	}

	@Override
	public void ejecutar() {
		/*
		// TODO Auto-generated method stub
		isBack = false;
		while (!isBack) {
			imprimirMenu();
			selecionarrOpcion();
		}
*/
		administrarRobotFrame.setVisible(true);
	}

	@Override
	public void volverAtras() {
		isBack = true;

	}

	/**
	 * consultar el array de robot 
	 * @return
	 */
	public static ArrayList<Robot> getRobots() {
		return robots;
	}

	/**
	 * dar un array de robots 
	 * @param robots
	 */
	public static void setRobots(ArrayList<Robot> robots) {
		AdministrarRobot.robots = robots;
	}

	/** 
	 * agregar un robot
	 * @param robot
	 */
	public static void addRobot(Robot robot) {
		AdministrarRobot.robots.add(robot);
		guardar();
	}
	/**
	 * remover robot
	 * @param robot
	 */
	public static void quitarRobot(Robot robot) {
		AdministrarRobot.robots.remove(robot);
		guardar();
	}

	public static void removeRobots(int i) {
		robots.remove(i);
		guardar();
	}
	
	/**
	 * cuardar robots a un XML  
	 */
	public static void guardar() {
		ManejoXML escribir = new ManejoXML("Robots.xml");
		escribir.guardarRobot(AdministrarRobot.getRobots());
		administrarRobotFrame.listarRobots.cargarRobots();
	}
	
	
	public static AdministrarRobotFrame getAdministraRobotFrame() {
		return administrarRobotFrame;
	}
	
	public static void setAdministraRobotFrame(AdministrarRobotFrame administraRobotFrame) {
		AdministrarRobot.administrarRobotFrame=administraRobotFrame;
	}
}
