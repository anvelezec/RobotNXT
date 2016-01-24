package objetos.futbol.UI.opciones.main.administrarRobot;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadores;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.varios.LecturaTeclado;
/**
 * Clase para estableces un jugador a un robot
 * @author luisa
 *
 */
public class EstablecerJugadorRobot extends OpcionEspecifica {

	/**
	 * constructor para establecer un jugador a un robot
	 */
	public EstablecerJugadorRobot() {
		super(true, true, "Agrega un Jugador a un robot", "Establecer Jugador Robot");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		seleccionarRobot();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	/**
	 * seleccionar un robot de la lista
	 */
	public void seleccionarRobot(){
		ListarRobots listarRobots= new ListarRobots();
		listarRobots.listarLosRobots();
		LecturaTeclado.scan= new Scanner(System.in);
		int opt= LecturaTeclado.scan.nextInt();
		if(opt<AdministrarRobot.getRobots().size()){
			seleccionarJugador(opt);
		}
		else{
			System.out.println("Opcion invalida");
		}
	}
	/**
	 * seleccionar un jugador para un robot especifico
	 * @param robot
	 */
	public void seleccionarJugador(int robot){
		ListarJugadores listarJugadores = new ListarJugadores();
		System.out.println("Seleccione el tipo de jugador");
		System.out.println("Delanero(d) o arquero(a)");
		LecturaTeclado.scan = new Scanner(System.in);
		String opc = LecturaTeclado.scan.nextLine();
		if (opc.equals("d")) {
			listarJugadores.listarTodosDelanteros();
			seleccionarDelantero(robot);
		} else if (opc.equals("a")) {
			listarJugadores.listarTodosArqueros();
			seleccionarArquero(robot);
		}
		
	}
	
	/**
	 * seleccionar un delantero para el robot
	 * @param robot
	 */
	public void seleccionarDelantero(int robot) {
		LecturaTeclado.scan = new Scanner(System.in);
		int opc = LecturaTeclado.scan.nextInt();
		if(opc<AdministrarJugadores.getDelanteros().size()){
			AdministrarRobot.getRobots().get(robot).setJugador(AdministrarJugadores.getDelanteros().get(opc));
			System.out.println("Agregado");
		}
		
	}

	/**
	 * seleccionar un arquero para el robot
	 * @param robot
	 */
	public void seleccionarArquero(int robot) {
		LecturaTeclado.scan = new Scanner(System.in);
		int opc = LecturaTeclado.scan.nextInt();
		if(opc<AdministrarJugadores.getArqueros().size()){
			AdministrarRobot.getRobots().get(robot).setJugador(AdministrarJugadores.getArqueros().get(opc));
			System.out.println("Agregado");
		}
	}
	

}
