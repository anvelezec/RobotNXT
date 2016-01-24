package objetos.futbol.UI.opciones.main.cancha;

import java.util.ArrayList;

import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.juego.EjecutarJugadaCompleja;
import objetos.futbol.UI.opciones.main.cancha.juego.EjecutarJugadaPrimitiva;
import objetos.futbol.UI.opciones.main.cancha.juego.PausarPartido;
import objetos.futbol.UI.opciones.main.cancha.juego.ReanudarPartido;
import objetos.futbol.cancha.Cancha;
/**
 * Clase que ejecuta el juago extiende de opcon general
 * @author luisa
 *
 */
import objetos.futbol.robot.Robot;

public class Juego extends OpcionGeneral {
	
	// private static Robot robot = Cancha.getRobots().get(0);
	private static Robot robot = Cancha.getRobots().get(1);
	private static JuegoFrame juegoFrame = new JuegoFrame();

	// TODO: Inicializar a robot con el primer robot existente

	private boolean backFlag = false;

	/**
	 * contructor de juego sin argumentos
	 */
	public Juego() {
		super(true, true, "Opciones de juego", "Juego", new ArrayList<Opcion>());
		this.getOpciones().add(new EjecutarJugadaCompleja());
		this.getOpciones().add(new PausarPartido());
		this.getOpciones().add(new ReanudarPartido());
		this.getOpciones().add(new EjecutarJugadaPrimitiva());
	}

	/**
	 * constructor de juego
	 * 
	 * @param opciones
	 */
	public Juego(ArrayList<Opcion> opciones) {
		super(true, true, "Opciones de juego", "Juego", opciones);

		// this.getOpciones().add()
	}

	@Override
	public void ejecutar() {
		/*
		 * backFlag=false; while (!backFlag) { imprimirMenu();
		 * selecionarrOpcion(); }
		 */
		juegoFrame.setVisible(true);
	}

	@Override
	public void volverAtras() {
		backFlag = true;
	}

	public static Robot getRobot() {
		return robot;
	}

	public static void setRobot(Robot robot) {
		Juego.robot = robot;
	}

	public static JuegoFrame getJuegoFrame() {
		return juegoFrame;
	}

	public static void setJuegoFrame(JuegoFrame juegoFrame) {
		Juego.juegoFrame = juegoFrame;
	}
	
	

}
