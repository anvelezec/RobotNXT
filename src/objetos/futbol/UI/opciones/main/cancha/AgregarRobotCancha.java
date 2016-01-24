package objetos.futbol.UI.opciones.main.cancha;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobots;
import objetos.futbol.robot.Robot;
import objetos.futbol.varios.LecturaTeclado;
/**
 * Clase agregar robot  a cancha 
 * @author luisa
 *
 */
public class AgregarRobotCancha extends OpcionEspecifica {
	/** 
	 * constructor para agregar un robot a la cancha sin argumentos
	 */
	public AgregarRobotCancha() {
		super(true, true, "Agrega un robot a la cancha", "Agregar robot");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		this.imprimirNombre();
		this.imprimirDescription();
		agregarUnRobot();
		this.volverAtras();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	/**
	 * agregar un robot a la cancha
	 */
	public void agregarUnRobot(){

		ListarRobots listarRobots = new ListarRobots();
		System.out.println("Seleccione el numero del robot");
		listarRobots.listarLosRobots();
		LecturaTeclado.scan = new Scanner(System.in);
		int opt= LecturaTeclado.scan.nextInt();
		
		if(opt<AdministrarRobot.getRobots().size()){
			Robot robot=AdministrarRobot.getRobots().get(opt);
			AdministrarCancha.addRobot(robot);
		}
		else{
			System.out.println("Opcion no valida");
		}
		
	}

}
