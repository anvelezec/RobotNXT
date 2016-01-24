package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.varios.LecturaTeclado;

public class DescripcionJugadasComplejas extends OpcionEspecifica {

	public DescripcionJugadasComplejas() {
		super(true, true, "Descripcion jugada compleja", "Descripcion jugadas complejas de un jugador");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		descripcion();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	public void descripcion() {
		System.out.println(
				"Seleccione el tipo de jugador Arquero=a / Delantero=d que desea la descripcion de sus jugadas complejas");
		LecturaTeclado.scan = new Scanner(System.in);
		String opc = LecturaTeclado.scan.nextLine();

		if (opc.equals("a")) {
			descripcionJugadasComplejasArquero();
		} else if (opc.equals("d")) {
			descripcionJugadasComplejasDelantero();
		}

	}

	public void descripcionJugadasComplejasArquero() {
		ListarJugadores lista = new ListarJugadores();
		lista.listarTodosArqueros();
		System.out.println("Seleccione Arquero");
		int seleccion = LecturaTeclado.scan.nextInt();

		for (int i = 0; i < AdministrarJugadores.getArqueros().get(seleccion).getJugadasComplejas().size(); i++) {
			System.out.println(AdministrarJugadores.getArqueros().get(seleccion).getJugadasComplejas().get(i)
					.getNombreJugada() + ": "
					+ AdministrarJugadores.getArqueros().get(seleccion).getJugadasComplejas().get(i).getExplicacion());

		}
	}

	public void descripcionJugadasComplejasDelantero() {
		ListarJugadores lista = new ListarJugadores();
		lista.listarTodosDelanteros();
		System.out.println("Seleccione Delantero");
		int seleccion = LecturaTeclado.scan.nextInt();

		for (int i = 0; i < AdministrarJugadores.getDelanteros().get(seleccion).getJugadasComplejas().size(); i++) {
			System.out.println(
					AdministrarJugadores.getDelanteros().get(seleccion).getJugadasComplejas().get(i).getNombreJugada()
							+ ": " + AdministrarJugadores.getDelanteros().get(seleccion).getJugadasComplejas().get(i)
									.getExplicacion());

		}
	}
}
