package objetos.futbol.UI.opciones.main.cancha;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.varios.LecturaTeclado;
/**
 * Clase para eliminar un robot de la cancha extiende de opcion especifica
 * @author luisa
 *
 */
public class EliminarRobotCancha extends OpcionEspecifica {

	/** 
	 * constructor para eliminar un robot de la cancha 
	 */
	public EliminarRobotCancha() {
		super(true, true, "Elimina un robot de la cancha", "Elminar Robot");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		elminarUnRobot();
		volverAtras();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * eliminar un robot de la cancha
	 */
	public void elminarUnRobot(){
		ListarRobotsCancha listarRobotsCancha = new ListarRobotsCancha();
		listarRobotsCancha.listarRobots();

		int opt= LecturaTeclado.scan.nextInt();
		if(opt< AdministrarCancha.getCancha().getRobots().size()){
			AdministrarCancha.removeRobot(AdministrarCancha.getCancha().getRobots().get(opt));
			System.out.println("Eliminado con exito");
		}
		else{
			System.out.println("Robot no valido");
		}
	}

}
