package objetos.futbol.UI.opciones.main.cancha.juego;


import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.ListarRobotsCancha;
import objetos.futbol.varios.LecturaTeclado;
/**
 * clase para pausar un partido
 * @author luisa
 *
 */
public class PausarPartido extends OpcionEspecifica {

	/** 
	 * constructor para pausar un partido sin constructor
	 */
	public PausarPartido() {
		super(true, true, "Pausa el partido", "Pausar partido");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		imprimirNombre();
		imprimirDescription();
		pausarPartido();
		volverAtras();
		
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * pausar un partido
	 */
	private static void pausarPartido() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Desea pausar el partido ? Si=1/ No=2");
		int respuesta = scan.nextInt();
		if (respuesta==1){
			System.out.println("Partido pausado");
			AdministrarCancha.pausarPartido();
		}else if (respuesta==2){
			System.out.println("Continuar con el partido");
		}
	}

}
