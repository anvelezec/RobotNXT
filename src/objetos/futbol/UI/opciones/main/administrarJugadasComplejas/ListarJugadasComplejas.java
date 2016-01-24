package objetos.futbol.UI.opciones.main.administrarJugadasComplejas;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.varios.LecturaTeclado;
/**
 * clase para listar las jugadas complejas hereda de opcion especifica
 * @author luisa
 *
 */
public class ListarJugadasComplejas extends OpcionEspecifica {

	/**
	 * constructor de listar jugadas complejas sin argumentos
	 */
	public ListarJugadasComplejas() {
		super(true, false, "Lista las Jugadas Complejas", "Listar jugadas Complejas");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		this.imprimirNombre();
		this.imprimirDescription();
		this.listarJugadasCompleas();
		this.volverAtras();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 * listas jugadas complejas en una lista
	 */
	public void listarJugadasCompleas() {
		for (int i = 0; i < AdministrarJugadasComplejas.getJugadaComplejas().size(); i++) {
			System.out.println(i + ". " + AdministrarJugadasComplejas.getJugadaComplejas().get(i).getNombreJugada()
					+ ": " + AdministrarJugadasComplejas.getJugadaComplejas().get(i).getExplicacion());
		}
	}

}
