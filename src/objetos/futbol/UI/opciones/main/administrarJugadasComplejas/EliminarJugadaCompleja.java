package objetos.futbol.UI.opciones.main.administrarJugadasComplejas;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.varios.LecturaTeclado;
/**
 * clase eliminar jugada compleja extiende de opcion expecifica
 * @author luisa
 *
 */
public class EliminarJugadaCompleja extends OpcionEspecifica {

	/**
	 * constructor eliminar jugada compleja sin argumentos
	 */
	public EliminarJugadaCompleja() {
		super(true, true, "Elimina una jugada Compleja", "Eliminar jugada Compleja");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		eliminarUnaJugada();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * eliminar una jugada compleja del array de jugadas
	 */
	public void eliminarUnaJugada(){
		ListarJugadasComplejas listarJugadasComplejas= new ListarJugadasComplejas();
		System.out.println("Seleccione la jugada compleja a eliminar");
		listarJugadasComplejas.listarJugadasCompleas();
		LecturaTeclado.scan=new Scanner(System.in);
		int opt= LecturaTeclado.scan.nextInt();
		if(opt<AdministrarJugadasComplejas.getJugadaComplejas().size()){
			AdministrarJugadasComplejas.removeJugadaCompleja(AdministrarJugadasComplejas.getJugadaComplejas().get(opt));
			System.out.println("Jugada Compleja Eliminada!");
		}
		else{
			System.out.println("Jugada compleja no valida");
		}
	}

}
