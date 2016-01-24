package objetos.futbol.UI.opciones.main.administrarUsuarios;

import java.util.ArrayList;
import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.Usuario;
import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.UI.opciones.OpcionMain;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.varios.LecturaTeclado;
/**
 * agregar un usuario al sistema extiende de opcion especifica
 * @author luisa
 *
 */
public class AgregarUsuario extends OpcionEspecifica {

	/**
	 * constructor de agregar usuario sin argumentos
	 */
	public AgregarUsuario() {
		super(true, false, "Agregar un usuario", "Agrega un usuario");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		crearUsuario();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 * crear un usuario e identificarlo
	 */
	public void crearUsuario() {
		String opt = "";
		
		System.out.println("Es Administrador(a) o General(g)");
		LecturaTeclado.scan = new Scanner(System.in);
		opt = LecturaTeclado.scan.nextLine();
		if (opt.equals("a")) {
			this.crearUsuarioAdministrador();
		} else if (opt.equals("g")) {
			crearUsuarioGeneral();
		} else{
			System.out.println("Opcion no valida");
		}
		
	}
	
	/**
	 * crear un usuario administrado en el sistema
	 */
	public void crearUsuarioAdministrador() {
		UsuarioAdministrador usuarioAdmin = null;
	
		System.out.println("Ingrese usuario Administrador:");
		LecturaTeclado.scan = new Scanner(System.in);
		String nombre = LecturaTeclado.scan.nextLine();
		System.out.println("Ingrese el password:");
		String password = LecturaTeclado.scan.nextLine();

		usuarioAdmin = new UsuarioAdministrador(nombre, password);
		AdministrarUsuarios.addUsuarioAdministrador(usuarioAdmin);
		
	}
	
	/**
	 * crear un usuario General en el sistema
	 */
	public void crearUsuarioGeneral() {
		UsuarioGeneral usuarioGeneral1 = null;
		
		System.out.println("Ingrese usuario General:");
		LecturaTeclado.scan = new Scanner(System.in);
		String nombre = LecturaTeclado.scan.nextLine();
		System.out.println("Ingrese el password:");
		String password = LecturaTeclado.scan.nextLine();
		usuarioGeneral1 = new UsuarioGeneral(nombre, password);
		AdministrarUsuarios.addUsuarioGeneral(usuarioGeneral1);

		
	}
	 

}
