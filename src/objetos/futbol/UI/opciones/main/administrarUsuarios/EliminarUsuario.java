package objetos.futbol.UI.opciones.main.administrarUsuarios;

import java.util.Scanner;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadores;
import objetos.futbol.varios.LecturaTeclado;
/**
 * opcion para eliminar usuarios
 * @author luisa
 *
 */
public class EliminarUsuario extends OpcionEspecifica {

	/** 
	 * constructor de eliminar usuarios sin argumentos
	 */
	public EliminarUsuario() {
		super(true, false, "Elimina un usuario", "Eliminar usuario");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		eliminarUsuario();
		volverAtras();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 * eliminar un usuario registrado en el sistema
	 */
	private void eliminarUsuario() {
		String opt = "";
		LecturaTeclado.scan = new Scanner(System.in);
		System.out.println("Es Usuario Administrador(a) o Usuario General(g)");
		opt = LecturaTeclado.scan.nextLine();
		if (opt.equals("a")) {
			eliminarUsuarioAdministrador();
		} else if (opt.equals("g")) {
			eliminarUsuarioGeneral();
		} else {
			System.out.println("Opcion no valida");
		}

	}

	/**
	 * eliminar un usuario administrador identificado en el sistema
	 */
	private void eliminarUsuarioAdministrador() {
		ListarUsuarios listar = new ListarUsuarios();
		int opt = -1;
		LecturaTeclado.scan = new Scanner(System.in);
		System.out.println("Usuario Administrador");
		listar.listarUsuariosAdministrador();
		System.out.println("Seleccione el numero del Usuario Administrador a eliminar");
		opt = Integer.parseInt(LecturaTeclado.scan.nextLine());
		if (opt < AdministrarUsuarios.getUsuarioAdministrador().size()) {
			AdministrarUsuarios.removeUsuarioAdministrador(AdministrarUsuarios.getUsuarioAdministrador().get(opt));
			System.out.println("Eliminado con exito!");
		} else {
			System.out.println("Usuario Administrador");
		}

	}

	/**
	 * eliminar un usuario general identificado en el sistema
	 */
	private void eliminarUsuarioGeneral() {
		ListarUsuarios listar = new ListarUsuarios();
		int opt = -1;
		LecturaTeclado.scan = new Scanner(System.in);
		System.out.println("Usuario General");
		listar.ListarUsuariosGeneral();
		System.out.println("Seleccione el numero del Usuario General a eliminar");
		opt = Integer.parseInt(LecturaTeclado.scan.nextLine());
		if (opt < AdministrarUsuarios.getUsuarioGeneral().size()) {
			AdministrarUsuarios.removeUsuarioGeneral(AdministrarUsuarios.getUsuarioGeneral().get(opt));
			System.out.println("Eliminado con exito!");
		} else {
			System.out.println("Usuario Administrador");
		}
	}
}
