package objetos.futbol.UI.opciones.main.administrarRobot;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.varios.LecturaTeclado;
/**
 * Clase para quitar robots del sistema
 * @author luisa
 *
 */
public class QuitarRobot extends OpcionEspecifica {

	/**
	 * constructor para quitar robots sin argumentos
	 */
	public QuitarRobot() {
		super(true, true, "Quitar un robot de mi lista de robots", "Quitar robot");
	}

	@Override
	public void ejecutar() {
		imprimirNombre();
		imprimirDescription();
		quitarunRobot();
		volverAtras();
		
	}

	@Override
	public void volverAtras() {

	}
	/**
	 * ingresar un robot desde el menu y quitarlo de la lista
	 */
	public void quitarunRobot(){
		
		int i=0;
		
		System.out.println("Ingrese el entero del robot que desea eliminar ");
		LecturaTeclado.scan = new Scanner(System.in);
		ListarRobots listarRobots=new ListarRobots();
		listarRobots.listarLosRobots();
		i =LecturaTeclado.scan.nextInt();
		AdministrarRobot.quitarRobot(AdministrarRobot.getRobots().get(i));
		
	}

}
