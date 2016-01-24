package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.ListarJugadasComplejas;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.varios.LecturaTeclado;
/**
 * clase para agregar un jugador, ejecutar jugadas complejas etc
 * @author luisa
 *
 */
public class AgregarJugadaComplejaJugador extends OpcionEspecifica {

	/** 
	 * constructor para agregar jugadas ocmplejas a un jugador
	 */
	public AgregarJugadaComplejaJugador() {
		super(true, true, "Agrega una Jugada Compleja a un Jugador", "Agregar Jugada Compleja Jugador");
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		seleccionarJugador();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub
		AdministrarJugadores.guardarXML();

	}

	/**
	 * seleccionar el tipo de jugador al que se le dara la jugada compleja
	 */
	public void seleccionarJugador() {
		ListarJugadores listarJugadores = new ListarJugadores();
		System.out.println("Seleccione el tipo de jugador");
		System.out.println("Delanero(d) o arquero(a)");
		LecturaTeclado.scan = new Scanner(System.in);
		String opc = LecturaTeclado.scan.nextLine();
		if (opc.equals("d")) {
			listarJugadores.listarTodosDelanteros();
			seleccionarDelantero();
		} else if (opc.equals("a")) {
			listarJugadores.listarTodosArqueros();
			seleccionarArquero();
		}

	}

	/**
	 * seleccionar el delantero que se agregara la jugada compleja
	 */
	public void seleccionarDelantero() {
		LecturaTeclado.scan = new Scanner(System.in);
		int opc = LecturaTeclado.scan.nextInt();
		if(opc<AdministrarJugadores.getDelanteros().size()){
			JugadaCompleja jugadaCompleja= seleccionarUnaJugadaCompleja();
			if(jugadaCompleja!=null){
				AdministrarJugadores.getDelanteros().get(opc).getJugadasComplejas().add(jugadaCompleja);
				AdministrarJugadores.guardarXML();
			}
		}
		
	}

	/**
	 * seleccionar el arquero que se agregara la jugada compleja
	 * 
	 */
	public void seleccionarArquero() {
		LecturaTeclado.scan = new Scanner(System.in);
		int opc = LecturaTeclado.scan.nextInt();
		if(opc<AdministrarJugadores.getArqueros().size()){
			JugadaCompleja jugadaCompleja= seleccionarUnaJugadaCompleja();
			if(jugadaCompleja!=null){
				AdministrarJugadores.getArqueros().get(opc).getJugadasComplejas().add(jugadaCompleja);
				AdministrarJugadores.guardarXML();
			}
		}
	}
	
	/**
	 * selecciona una jugada compleja de la lista de las jugadas complejas creadas
	 * @return
	 */
	public JugadaCompleja seleccionarUnaJugadaCompleja(){
		JugadaCompleja jugadaCompleja=null;
		ListarJugadasComplejas listarJugadasComplejas = new ListarJugadasComplejas();
		listarJugadasComplejas.listarJugadasCompleas();
		System.out.println("Seleccione una jugada compleja");
		LecturaTeclado.scan=new Scanner(System.in);
		int opt= LecturaTeclado.scan.nextInt();
		if(opt< AdministrarJugadasComplejas.getJugadaComplejas().size()){
			jugadaCompleja= AdministrarJugadasComplejas.getJugadaComplejas().get(opt);
			
		}
		return jugadaCompleja;
	}

}
