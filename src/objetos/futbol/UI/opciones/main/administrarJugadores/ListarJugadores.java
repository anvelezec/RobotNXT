package objetos.futbol.UI.opciones.main.administrarJugadores;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
/**
 * clase para listar jugadores
 * @author luisa
 *
 */
public class ListarJugadores extends OpcionEspecifica {

	/**
	 * constructore para listar jugadores sin argumentos
	 */
	public ListarJugadores() {
		super(true, true, "Listar todos los delanteros y arqueros", "Listar Jugadores");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		this.imprimirNombre();
		this.imprimirDescription();
		this.listarTodosJugadores();
		this.volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * imprimir una lista de todos los jugadores arqueros y luego delanteros
	 */
	public void listarTodosJugadores(){
		listarTodosArqueros();
		listarTodosDelanteros();

	}
	
	/**
	 * imprimir una lista de todos los delanteros
	 */
	public void listarTodosDelanteros(){
		System.out.println("Delanteros: ");
		for (int i = 0; i < AdministrarJugadores.getDelanteros().size(); i++) {
			System.out.println(i+" "+AdministrarJugadores.getDelanteros().get(i).getNombre());
		}
	}
	/**
	 * imprimir una lista de todos los arqueros 
	 */
	public void listarTodosArqueros(){
		System.out.println("Arqueros: ");
		for (int i = 0; i < AdministrarJugadores.getArqueros().size(); i++) {
			System.out.println(i+" "+AdministrarJugadores.getArqueros().get(i).getNombre());
		}
	}

}
