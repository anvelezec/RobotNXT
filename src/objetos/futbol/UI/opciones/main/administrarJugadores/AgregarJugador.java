package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.util.ArrayList;
import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.varios.LecturaTeclado;
/**
 * agregar un jugador con el menu
 * @author luisa
 *
 */
public class AgregarJugador extends OpcionEspecifica {

	/**
	 *  contructor de agregar un jugador
	 */
	public AgregarJugador() {
		super(true, true, "Agregar un jugador", "Agregar Jugador");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		agregarUnJugador();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 *agregar un jugador delantero o Arquero  
	 */
	public void agregarUnJugador() {
		String opt = "";
		System.out.println("Es Arquero(a) o delantero(d)");
		LecturaTeclado.scan=new Scanner(System.in);
		opt = LecturaTeclado.scan.nextLine();
		
		if (opt.equals("a")) {
			agregarArquero();
		} else if (opt.equals("d")) {
			agregarDelantero();
		}
		else{
			System.out.println("Opcion no valida");
		}
		

	}

	/** 
	 * agregar un arquero desde el menu
	 */
	public void agregarArquero() {
		Arquero arquero = null;
		System.out.println("Ingrese el nombre del arquero");
		LecturaTeclado.scan=new Scanner(System.in);
		String nombre=LecturaTeclado.scan.nextLine();
		String posicion="Arquero";
		ArrayList<JugadaCompleja> jugadasComplejas=new ArrayList<JugadaCompleja>();
		System.out.println("Ingrese el dorsal del arquero");
		byte dorsal=(byte) Integer.parseInt(LecturaTeclado.scan.nextLine());
		int tiempoSinGoles=0;
		arquero=new Arquero(nombre, posicion, jugadasComplejas, tiempoSinGoles, dorsal);
		AdministrarJugadores.addArquero(arquero);
		
	}

	/**
	 * agregar un delantero desde el menu
	 */
	public void agregarDelantero() {
		Delantero delantero = null;
		System.out.println("Ingrese el nombre del delantero");
		LecturaTeclado.scan = new Scanner(System.in);
		String nombre=LecturaTeclado.scan.nextLine();
		String posicion="Delantero";
		ArrayList<JugadaCompleja> jugadasComplejas=new ArrayList<JugadaCompleja>();;
		short golesMarcados=0;
		System.out.println("Ingrese el dorsal del arquero");
		byte dorsal=(byte) Integer.parseInt(LecturaTeclado.scan.nextLine());
		delantero=new Delantero(nombre, posicion, jugadasComplejas, golesMarcados, dorsal);
		AdministrarJugadores.addDelantero(delantero);
	}

	
}
