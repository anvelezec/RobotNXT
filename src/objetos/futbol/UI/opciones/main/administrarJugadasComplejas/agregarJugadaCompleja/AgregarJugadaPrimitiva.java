package objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.varios.LecturaTeclado;
/**
 * clase para agregar jugadas primitiva a un jugador desde el menu y ejecutarla
 * @author luisa
 *
 */
public class AgregarJugadaPrimitiva extends OpcionEspecifica {

	/**
	 * constructor para agregar una jugada primitiva 
	 */
	public AgregarJugadaPrimitiva() {
		super(true, true, "Agregar una jugada primitiva", "Agregar Jugada primitiva");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		agregarUnaJugada();
		volverAtras();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 * agregar una jugada primitiva desde el menu 
	 */
	public void agregarUnaJugada() {
		System.out.println("0 Mover Adelante");
		System.out.println("1 Mover Atras");
		System.out.println("2 Girar Derecha");
		System.out.println("3 Girar Izquierda");
		System.out.println("4 Chutar");
		System.out.println("Seleccione la jugada a agregar");
		LecturaTeclado.scan = new Scanner(System.in);
		int opt = LecturaTeclado.scan.nextInt();

		if (opt == 0) {
			agregarMoverAdelante();
		} else if (opt == 1) {
			agregarMoverAtras();
		} else if (opt == 2) {
			agregarGirarDerecha();
		} else if (opt == 3) {
			agregarGirarIzquierda();
		} else if (opt == 4) {
			agregarChutar();
		}

	}

	/**
	 * agregar la jugada primitiva mover adelante
	 */
	public void agregarMoverAdelante() {
		int tipo = 1;
		System.out.println("Cuantos centimetros  A mover :");
		LecturaTeclado.scan = new Scanner(System.in);
		int valor = Integer.parseInt(LecturaTeclado.scan.nextLine());
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

	/**
	 * agregar la jugada primitiva mover atras
	 */
	public void agregarMoverAtras() {

		int tipo = 4;
		System.out.println("Cuantos centimetros A mover :");
		LecturaTeclado.scan = new Scanner(System.in);
		int valor = Integer.parseInt(LecturaTeclado.scan.nextLine());
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

	/**
	 * agregar la jugada primitiva girar derecha
	 */
	public void agregarGirarDerecha() {
		int tipo = 3;
		int valor = 0;
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

	/**
	 * agregar la jugada primitiva girar izquierda
	 */
	public void agregarGirarIzquierda() {
		int tipo = 2;
		int valor = 0;
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

	/**
	 * agregar la jugada primitiva chutar
	 */
	public void agregarChutar() {
		int tipo = 5;
		int valor = 0;
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

}
