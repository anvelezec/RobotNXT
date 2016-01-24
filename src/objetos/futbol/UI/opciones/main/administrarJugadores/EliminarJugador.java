package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.varios.LecturaTeclado;
/** 
 * clase para eliminar un jugador desde el menu de la lista
 * @author luisa
 *
 */
public class EliminarJugador extends OpcionEspecifica {

	/** 
	 * constructor de eliminar jugador
	 */
	public EliminarJugador() {
		super(true, true, "Eliminar un jugador", "Elminar Jugador");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		imprimirNombre();
		imprimirDescription();
		eliminarUnJugador();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * eliminar un jugador desde el menu
	 */
	public void eliminarUnJugador(){
		String opt = "";
		LecturaTeclado.scan=new Scanner(System.in);
		System.out.println("Es Arquero(a) o delantero(d)");
		opt = LecturaTeclado.scan.nextLine();
		if (opt.equals("a")) {
			eliminarArquero();
		} else if (opt.equals("d")) {
			eliminarDelantero();
		}
		else{
			System.out.println("Opcion no valida");
		}

		
	}
	/**
	 * eliminar un arquero de la lista
	 */
	public void eliminarArquero(){
		ListarJugadores listar=new ListarJugadores();
		int opt = -1;
		
		if(AdministrarJugadores.getArqueros().size()>0){
			
		System.out.println("Arqueros");
		listar.listarTodosArqueros();
		
		System.out.println("Seleccione el numero de arquero a eliminar");
		LecturaTeclado.scan = new Scanner(System.in);
		opt=Integer.parseInt(LecturaTeclado.scan.nextLine());
		if(opt<AdministrarJugadores.getArqueros().size()){
			AdministrarJugadores.removeArquero(AdministrarJugadores.getArqueros().get(opt));
			System.out.println("Eliminado con exito!");
		}
		else{
			System.out.println("Arquero invalido");
		}
		}else{
			System.out.println("No hay jugadores");
		}
	}
	
	/**
	 * eliminar un delantero de la lista
	 */
	public void eliminarDelantero(){
		ListarJugadores listar=new ListarJugadores();		
		int opt = -1;
		if(AdministrarJugadores.getDelanteros().size()>0){
			
			System.out.println("Arqueros");
			listar.listarTodosDelanteros();
		if(opt<AdministrarJugadores.getDelanteros().size()){
			AdministrarJugadores.removeDelantero(AdministrarJugadores.getDelanteros().get(opt));
			System.out.println("Eliminado con exito!");
		}
		else{
			System.out.println("Delantero invalido invalido");
		}
		}else{
			System.out.println("No hay jugadores");
		}
		
	}

}
