package objetos.futbol.UI.opciones.main.administrarRobot;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.varios.LecturaTeclado;
/**
 * Clase para configurar el bluetooth al robot
 * @author luisa
 *
 */
	public class configurarBTRobot extends OpcionEspecifica{

	/**
	 * constructor de configuracion Bluethoot
	 */
	public configurarBTRobot() {
		super(true, true, "comunicacion con un robot expecifico","configuracion Bluethoot");
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		configuracionBluethoot();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * configurar una conexion bluetooth al robot
	 */
	public void configuracionBluethoot(){
		System.out.println("Ingrese el string de conexion");
		LecturaTeclado.scan = new Scanner(System.in);
		String nombreConexion =  LecturaTeclado.scan.nextLine();
		int i = LecturaTeclado.scan.nextInt();
		AdministrarRobot.getRobots().get(i).setConexionBT(nombreConexion);
	}
	public void configuracionBluethoot(String nombreConexion, int i){
		
		AdministrarRobot.getRobots().get(i).setConexionBT(nombreConexion);
	}
}
