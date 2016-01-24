package objetos.futbol.UI.opciones.main.administrarRobot;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarRobot;

/**
 * Clase para listar los robots  que estan en el sistema
 * @author luisa
 *
 */
public class ListarRobots extends OpcionEspecifica {

	/**
	 * constructor para listar los robots
	 */
	public ListarRobots() {
		super(true, true, "llenar una lista con los robots",  "listar robots ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		imprimirNombre();
		imprimirDescription();
		listarLosRobots();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	/**
	 * imprimir una lista de robots del sistema
	 */
	public void listarLosRobots(){
		System.out.println("Robots: ");
		
		for	(int i = 0 ; i< AdministrarRobot.getRobots().size(); i++){
			System.out.println(i + " "+ AdministrarRobot.getRobots().get(i).getConexionBT());
		}
	}

}
