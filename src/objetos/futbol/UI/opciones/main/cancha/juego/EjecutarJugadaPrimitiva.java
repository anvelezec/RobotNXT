package objetos.futbol.UI.opciones.main.cancha.juego;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.ListarRobotsCancha;
import objetos.futbol.varios.LecturaTeclado;

public class EjecutarJugadaPrimitiva extends OpcionEspecifica {

	public EjecutarJugadaPrimitiva() {
		super(true, true, "Mueve un robot con una jugada primitiva", "Ejecutar jugada primitiva");
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
	 * 
	 * @param opt
	 */
	public void ejecutarJugadaRobot(int opt) {
		int opt2 = 0;
		System.out.println("Seleccione una jugada a realizar");
		objetos.futbol.robot.Robot robot = AdministrarCancha.getCancha().getRobots().get(opt);
		System.out.println(AdministrarCancha.getCancha().getRobots().get(opt).getJugador().getNombre());
		System.out.println(0 + " " + "Mover Adelante");
		System.out.println(1 + " " + "Mover Atras");
		System.out.println(2 + " " + "Mover Rotar Izquierda");
		System.out.println(3 + " " + "Mover Rotar Derecha");
		System.out.println(4 + " " + "Chutar");
		LecturaTeclado.scan = new Scanner(System.in);
		opt2 = LecturaTeclado.scan.nextInt();
		AdministrarCancha.getCancha().getRobots().get(opt).configurarConexion();
		if (opt2 == 0) {
			// AdministrarCancha.getCancha().getRobots().get(opt).getJugador().ejecutarJugadaCompleja(opt2);}
			System.out.println("Ingrese el valor a mover");
			int valor = LecturaTeclado.scan.nextInt();
			AdministrarCancha.getCancha().getRobots().get(opt).getJugador().moverAdelante(valor);
		} else if (opt2 == 1) {
			System.out.println("Ingrese el valor a mover");
			int valor = LecturaTeclado.scan.nextInt();
			AdministrarCancha.getCancha().getRobots().get(opt).getJugador().moverAtras(valor);
		} else if (opt2 == 2) {
			AdministrarCancha.getCancha().getRobots().get(opt).getJugador().girarD(90);
		} else if (opt2 == 3) {
			AdministrarCancha.getCancha().getRobots().get(opt).getJugador().girarI(90);
		} else if (opt2 == 4) {
			AdministrarCancha.getCancha().getRobots().get(opt).getJugador().chutar();
		} else {
			System.out.println("Opcion no valida");
		}

	}

}
