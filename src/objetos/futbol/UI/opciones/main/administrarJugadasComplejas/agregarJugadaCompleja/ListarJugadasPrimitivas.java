package objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja;

import javax.swing.JList;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;
import objetos.futbol.jugadores.JugadaCompleja;
/**
 * clase para listas las jugadas primitivas
 * @author luisa
 *
 */
public class ListarJugadasPrimitivas extends OpcionEspecifica {
	public ListarJugadasPrimitivas() {
		super(true, true, "Lista las Jugadas Primitivas","Listar jugadas primitiva" );
		
	}

	@Override
	public void ejecutar() {
		imprimirNombre();
		imprimirDescription();
		ListarJugadas();
		volverAtras();
		
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * listas las jugas primitivas de una jugada compleja
	 */
	public void ListarJugadas(){
		for (int i = 0; i < AgregarJugadaCompleja.getJugadaCompleja().getJugadasPrimitivas().size(); i++) {
			System.out.println(i+". "+AgregarJugadaCompleja.getJugadaCompleja().getJugadasPrimitivas().get(i).informativo());
		}
	}

}
