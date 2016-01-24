package objetos.futbol.UI.opciones.main.administrarRobot;

import java.util.Scanner;

import lejos.geom.Point;
import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.robot.Robot;
import objetos.futbol.varios.LecturaTeclado;
import objetos.futbol.varios.ManejoXML;
import objetos.futbol.varios.ManejoXMLeer;
/**
 * agregar un robot al sistema
 * @author luisa
 *
 */
public class AgregarRobot extends OpcionEspecifica {

	/**
	 * clase para agregar un robot al sistema
	 */
	public AgregarRobot() {
		super(true, true, "Agregar un robot", "Agregar Robot");
		
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		AgregarUnRobot();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * agregar un robot al sistema
	 */
	private void AgregarUnRobot(){
		Robot robot=new Robot();
		System.out.println("Porfavor ingrese la conexion Bluetoot");
		LecturaTeclado.scan = new Scanner(System.in);
		String conexion = LecturaTeclado.scan.nextLine();
		robot.setConexionBT(conexion);
		
		System.out.println("Porfavor ingrese la posicion relativa del robot en el eje X");
		int posicionx  = LecturaTeclado.scan.nextInt();
		System.out.println("Porfavor ingrese la posicion relativa del robot en el eje Y");
		int posiciony  = LecturaTeclado.scan.nextInt();
		robot.setPosicionRelativa(new Point(posicionx, posiciony));
		
		AdministrarRobot.addRobot(robot);
		
	    /*ManejoXML escribir = new ManejoXML("Robots.xml");
	    ManejoXMLeer leer = new ManejoXMLeer("Robots.xml");
	    escribir.guardarRobot(AdministrarRobot.getRobots());
	    AdministrarRobot.setRobots(leer.leerRobotsXML());*/
	    
	}

}
