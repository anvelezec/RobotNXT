package objetos.futbol.UI.opciones.main.cancha.juego;

import java.awt.Robot;
import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.ListarRobotsCancha;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.varios.LecturaTeclado;
/**
 * Clase para ejecutar una jugada compleja
 * @author luisa
 *
 */
public class EjecutarJugadaCompleja extends OpcionEspecifica {

	/**
	 * constructor ejecutar jugada compleja
	 */
	public EjecutarJugadaCompleja() {
		super(true, true, "Mueve un robot con una jugada compleja", "Ejecutar jugada compleja");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		seleccionarRobotJugada();
		volverAtras();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 * seleccionar un robot para jugar
	 */
	public void seleccionarRobotJugada() {
		ListarRobotsCancha listarRobotsCancha = new ListarRobotsCancha();
		listarRobotsCancha.listarRobots();
		System.out.println("Seleccione el robot a mover");
		LecturaTeclado.scan = new Scanner(System.in);
		int opt = LecturaTeclado.scan.nextInt();

		if (opt < AdministrarCancha.getCancha().getRobots().size()) {
			ejecutarJugadaRobot(opt);
		}
	}

	/**
	 * ejecuta jugada en el robot
	 * @param opt
	 */
	public void ejecutarJugadaRobot(int opt) {
		int opt2 = 0;
		System.out.println("Seleccione una jugada a realizar");
		objetos.futbol.robot.Robot and =AdministrarCancha.getCancha().getRobots().get(opt);
		System.out.println(AdministrarCancha.getCancha().getRobots().get(opt).getJugador().getNombre());
		for (int i = 0; i < AdministrarCancha.getCancha().getRobots().get(opt).getJugador().getJugadasComplejas()
				.size(); i++) {
			System.out.println(i + " " + AdministrarCancha.getCancha().getRobots().get(opt).getJugador()
					.getJugadasComplejas().get(i).getNombreJugada());
		}

		LecturaTeclado.scan = new Scanner(System.in);
		opt2 = LecturaTeclado.scan.nextInt();
		if (opt2 < AdministrarCancha.getCancha().getRobots().get(opt).getJugador().getJugadasComplejas().size()) {
			// AdministrarCancha.getCancha().getRobots().get(opt).getJugador().ejecutarJugadaCompleja(opt2);}
			AdministrarCancha.getCancha().ejecutarJugadaRobot(AdministrarCancha.getCancha().getRobots().get(opt), opt2);
		} else {
			System.out.println("Opcion no valida");
		}

	}

}
