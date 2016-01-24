package objetos.futbol.UI.opciones.main.cancha.juego;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
/**
 * Clase para Reanudar el partido despues de una pausa
 * @author luisa
 *
 */
public class ReanudarPartido extends OpcionEspecifica {

	/**
	 * constructor para reanudar un partido sin argumentos
	 */
	public ReanudarPartido() {
		super(true, true, "Reanuda el partido", "reanudar partidop");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		imprimirNombre();
		imprimirDescription();
		reanudarPartido();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 * reanudar un partido
	 */
	private static void reanudarPartido() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Desea reanudar el partido ? Si=1/ No=2");
		int respuesta = scan.nextInt();
		if (respuesta==1){
			System.out.println("Partido Reanudado");
			AdministrarCancha.reanudarPartido();
		}else if (respuesta==2){
			System.out.println("El partido continua pausado");
		}
	}
}
