package objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadores;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.varios.LecturaTeclado;

public class EliminarJugadaPrimitiva extends OpcionEspecifica {

	public EliminarJugadaPrimitiva() {
		super(true, true, "Eliminar una jugada primitiva", "Elminar jugada primitiva");
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		elminarUnaJugadaPrimitiva();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * eliminar una jugada primitiva desde el menu
	 */
	public void elminarUnaJugadaPrimitiva(){
		ListarJugadasPrimitivas listar=new ListarJugadasPrimitivas();
		int opt = -1;
		
		System.out.println("Elminar Jugada Primitiva");
		listar.ListarJugadas();
		System.out.println("Seleccione el numero de la jugada a eliminar");
		LecturaTeclado.scan = new Scanner(System.in);
		opt=Integer.parseInt(LecturaTeclado.scan.nextLine());
		if(opt<AgregarJugadaCompleja.getJugadaCompleja().getJugadasPrimitivas().size()){
			AgregarJugadaCompleja.eliminarJugadaPrimitiva(AgregarJugadaCompleja.getJugadaCompleja().getJugadasPrimitivas().get(opt));
			System.out.println("Eliminado con exito!");
		}
		else{
			System.out.println("Jugada invalida");
		}
	}

}
