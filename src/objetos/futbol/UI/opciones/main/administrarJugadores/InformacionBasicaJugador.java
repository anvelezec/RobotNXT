package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.varios.LecturaTeclado;

public class InformacionBasicaJugador extends OpcionEspecifica {

	public InformacionBasicaJugador() {
		super(true, true, "Descripcion basica de un jugador", "Descripcion basica de jugadores");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		descripcionFutbolista();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	public void descripcionFutbolista() {
		System.out.println("Seleccione el tipo de jugador Arquero=a / Delantero=d que desea la descripcion basica");
		LecturaTeclado.scan = new Scanner(System.in);
		String opc = LecturaTeclado.scan.nextLine();
		if (opc.equals("a")) {
			descripcionArquero();
		} else if (opc.equals("d")) {
			descripcionDelantero();
		}

	}

	public void descripcionArquero() {
		ListarJugadores lista = new ListarJugadores();
		lista.listarTodosArqueros();
		System.out.println("Seleccione Arquero");
		int seleccion = LecturaTeclado.scan.nextInt();

		System.out.println("Nombre:"+" "+ AdministrarJugadores.getArqueros().get(seleccion).getNombre());
		System.out.println("Posicion:"+" "+AdministrarJugadores.getArqueros().get(seleccion).getPosicion());
		System.out.println("Dorsal:"+" "+AdministrarJugadores.getArqueros().get(seleccion).getDorsal());
		System.out.println("Tiempo sin goles:"+" "+AdministrarJugadores.getArqueros().get(seleccion).getTiempoSinGoles());
		
	}

	public void descripcionDelantero() {
		ListarJugadores lista = new ListarJugadores();
		lista.listarTodosDelanteros();
		System.out.println("Seleccione Delantero");
		int seleccion = LecturaTeclado.scan.nextInt();

		System.out.println("Nombre:"+" "+AdministrarJugadores.getDelanteros().get(seleccion).getNombre());
		System.out.println("Posicion:"+" "+AdministrarJugadores.getDelanteros().get(seleccion).getPosicion());
		System.out.println("Dorsal:"+" "+AdministrarJugadores.getDelanteros().get(seleccion).getDorsal());
		System.out.println("Goles marcados:"+" "+AdministrarJugadores.getDelanteros().get(seleccion).getGolesMarcados());


	}

}
