package objetos.futbol.UI.opciones.main.administrarJugadasComplejas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.sun.org.omg.CORBA.OperationMode;

import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.opciones.OpcionMain;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja.AgregarJugadaPrimitiva;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja.EliminarJugadaPrimitiva;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja.ListarJugadasPrimitivas;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.varios.LecturaTeclado;
/**
 * agregar jugada compleja hija de opcion general 
 * @author luisa
 *
 */
public class AgregarJugadaCompleja extends OpcionGeneral {
	private static JugadaCompleja jugadaCompleja= new JugadaComplejaDefensiva("", "0/0/0", (UsuarioAdministrador)OpcionMain.getUsuarioLogeado(), "", new ArrayList<JugadaPrimitiva>());
	private static int index;
	private boolean isBack = false;
	private static AgregarJugadaComplejaFrame agregarJugadaComplejaFrame = new AgregarJugadaComplejaFrame();
	/**
	 * constructor de agregar jugada compleja sin argumentos
	 */
	public AgregarJugadaCompleja(){
		super(true, true, "Agregar una Jugada Compleja", "Agrega Jugada Compleja", new ArrayList<Opcion>());
		this.getOpciones().add(new AgregarJugadaPrimitiva());
		this.getOpciones().add(new ListarJugadasPrimitivas());
		this.getOpciones().add(new EliminarJugadaPrimitiva());
		agregarJugadaComplejaFrame.listarJugadasPrimitivas.cargarJugadasPrimitivas();
	}
	
	/**
	 * constructor de agregadas complejas 
	 * @param opciones
	 */
	public AgregarJugadaCompleja(ArrayList<Opcion> opciones) {
		super(true, true, "Agregar una Jugada Compleja", "Agrega Jugada Compleja", opciones);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		agregarJugadaComplejaFrame.setVisible(true);
//		isBack = false;
//		seleccionarJugadaCompleja();
//		while (!isBack) {
//			imprimirMenu();
//			selecionarrOpcion();
//		}
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub
		isBack = true;
		if(AgregarJugadaCompleja.getJugadaCompleja()!=null){
			AdministrarJugadasComplejas.agregarJugadaCompleja(jugadaCompleja);
		}
	}

	/**
	 * consultar jugada compleja
	 * @return
	 */
	public static JugadaCompleja getJugadaCompleja() {
		return jugadaCompleja;
	}

	/**
	 * dar tipo de jugada ocmpleja 
	 * @param jugadaCompleja
	 */
	public static void setJugadaCompleja(JugadaCompleja jugadaCompleja) {
		AgregarJugadaCompleja.jugadaCompleja = jugadaCompleja;
	}

	/**
	 * indexar
	 * @return
	 */
	public static int getIndex() {
		return index;
	}

	/**
	 * set index
	 * @param index
	 */
	public static void setIndex(int index) {
		AgregarJugadaCompleja.index = index;
	}

	/**
	 * agregar jugada promitiva en jugada compleja
	 * @param jugadaPrimitiva
	 */
	public static void agregarJugadaPrimitiva(JugadaPrimitiva jugadaPrimitiva) {
		AgregarJugadaCompleja.jugadaCompleja.getJugadasPrimitivas().add(jugadaPrimitiva);
		agregarJugadaComplejaFrame.listarJugadasPrimitivas.cargarJugadasPrimitivas();
	}

	/**
	 * eliminar jugada primitiva de una jugada compleja
	 * @param jugadaPrimitiva
	 */
	public static void eliminarJugadaPrimitiva(JugadaPrimitiva jugadaPrimitiva) {
		AgregarJugadaCompleja.jugadaCompleja.getJugadasPrimitivas().remove(jugadaPrimitiva);
		agregarJugadaComplejaFrame.listarJugadasPrimitivas.cargarJugadasPrimitivas();
	}

	/**
	 *seleccionar la jugada compleja que se ejecutara 
	 */
	public void seleccionarJugadaCompleja() {
		System.out.println("Seleccione el tipo de la jugada Compleja");
		System.out.println("0. Jugada Compleja Defensiva");
		System.out.println("1. Jugada Compleja Ofensiva");
		System.out.println("2. Jugada Compleja Tiro Libre");
		LecturaTeclado.scan = new Scanner(System.in);
		int opt = LecturaTeclado.scan.nextInt();
		if (opt < 3) {
			Date now= new Date();
			String fechaCreacion=now.toString();
			UsuarioAdministrador autor=(UsuarioAdministrador)OpcionMain.getUsuarioLogeado();
			ArrayList<JugadaPrimitiva> jugadasPrimitivas=new ArrayList<JugadaPrimitiva>();
			//Formulario
			LecturaTeclado.scan = new Scanner(System.in);
			System.out.println("Ingrese el nombre de la Jugada Compleja");
			String nombreJugada=LecturaTeclado.scan.nextLine();
			System.out.println("Ingrese la explicacion de la jugada Compleja");
			String explicacion=LecturaTeclado.scan.nextLine();;
			if (opt == 0) {
				AgregarJugadaCompleja.setJugadaCompleja(new JugadaComplejaDefensiva(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas));
			} else if (opt == 1) {
				AgregarJugadaCompleja.setJugadaCompleja(new JugadaComplejaOfensiva(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas));
			} else if (opt == 2) {
				AgregarJugadaCompleja.setJugadaCompleja(new JugadaComplejaTiroLibre(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas));
			}
			
		}
		else{
			System.out.println("Opcion no valida");
			isBack=true;
		}

	}

	public static AgregarJugadaComplejaFrame getAgregarJugadaComplejaFrame() {
		return agregarJugadaComplejaFrame;
	}

	public static void setAgregarJugadaComplejaFrame(AgregarJugadaComplejaFrame agregarJugadaComplejaFrame) {
		AgregarJugadaCompleja.agregarJugadaComplejaFrame = agregarJugadaComplejaFrame;
	}


	
	

}
