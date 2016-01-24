package objetos.futbol.UI.opciones.main;

import java.util.ArrayList;

import lejos.geom.Point;
import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.opciones.main.administrarRobot.AgregarRobot;
import objetos.futbol.UI.opciones.main.cancha.AgregarRobotCancha;
import objetos.futbol.UI.opciones.main.cancha.EliminarRobotCancha;
import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.UI.opciones.main.cancha.ListarRobotsCancha;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.robot.Robot;
import objetos.futbol.varios.ManejoXML;
import objetos.futbol.varios.ManejoXMLeer;

/** 
 * clase para administrar la cancha
 * @author luisa
 *
 */
public class AdministrarCancha extends OpcionGeneral {

	private boolean backFlag = false;
	private static Cancha cancha = new Cancha();
	private static AdministrarCanchaFrame administrarCanchaFrame = new AdministrarCanchaFrame();

	public AdministrarCancha(){

		super(true, true, "Administra la cancha de juego", "Administrar Cancha", new ArrayList<Opcion>());
		
		ManejoXMLeer lectura = new ManejoXMLeer("Cancha.xml");
		cancha=lectura.lecturaXMLCancha();
		administrarCanchaFrame.listarRobotsCancha.cargarRobots();
		this.getOpciones().add(new AgregarRobotCancha());
		this.getOpciones().add(new EliminarRobotCancha());
		this.getOpciones().add(new ListarRobotsCancha());
		this.getOpciones().add(new Juego());
	}

	/**
	 * constructor para administrar cancha
	 * @param opciones
	 */
	public AdministrarCancha(ArrayList<Opcion> opciones) {
		super(true, true, "Administra la cancha de juego", "Administrar Cancha", opciones);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		/*
		// TODO Auto-generated method stub
		backFlag = false;
		while (!backFlag) {
			imprimirMenu();
			selecionarrOpcion();
		}
		*/
		administrarCanchaFrame.setVisible(true);
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub
		backFlag = true;
	}

	/**
	 * consultamos la cancha
	 * @return
	 */
	public static Cancha getCancha() {
		return cancha;
	}

	/**
	 * introducimos una cancha
	 * @param cancha
	 */
	public static void setCancha(Cancha cancha) {
		AdministrarCancha.cancha = cancha;

	}

	/**
	 * agregamos un robot a la cancha
	 * @param robot
	 */
	public static void addRobot(Robot robot) {
		AdministrarCancha.getCancha().getRobots().add(robot);
		ManejoXML escribir = new ManejoXML("Cancha.xml");
		escribir.CanchaXML(cancha);
		administrarCanchaFrame.listarRobotsCancha.cargarRobots();
	}

	/**
	 * quitamos un robot de la cancha
	 * @param robot
	 */
	public static void removeRobot(Robot robot) {
		AdministrarCancha.getCancha().getRobots().remove(robot);
		ManejoXML escribir = new ManejoXML("Cancha.xml");
		escribir.CanchaXML(cancha);
		administrarCanchaFrame.listarRobotsCancha.cargarRobots();
	}

	/**
	 * pausa partido
	 */
	public static void pausarPartido() {
		ManejoXML escribir = new ManejoXML("Cancha.xml");
		escribir.CanchaXML(cancha);
	}
	/**
	 * se reinicia el partido
	 */
	public static void reanudarPartido() {
		ManejoXMLeer leer = new ManejoXMLeer("Cancha.xml");
		cancha = leer.lecturaXMLCancha();
	}
	
	public static AdministrarCanchaFrame getAdministraCanchaFrame() {
		return administrarCanchaFrame;
	}
	
	public static void setAdministraRobotFrame(AdministrarCanchaFrame administrarCanchaFrame) {
		AdministrarCancha.administrarCanchaFrame=administrarCanchaFrame;
	}

	public  void iniciarPosicionRobots(){
		cancha.getRobots().get(0).setPosicionRelativa(new Point(300,1200));
		cancha.getRobots().get(1).setPosicionRelativa(new Point(300, 0));
		ManejoXML escribir = new ManejoXML("Cancha.xml");
		escribir.CanchaXML(cancha);
	}
}
