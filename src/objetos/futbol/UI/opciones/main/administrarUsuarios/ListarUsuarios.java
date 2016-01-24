package objetos.futbol.UI.opciones.main.administrarUsuarios;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
/**
 * Clase apra listar usuarios hija de opcion especifica
 * @author luisa
 *
 */
public class ListarUsuarios extends OpcionEspecifica {

	/** 
	 * constructor listar usuarios
	 */
	public ListarUsuarios() {
		super(true, false, "Listar todos los UsuariosGenerales y UsuariosAdministrador", "Listar Usuarios");

	}

	@Override
	public void ejecutar() {

		this.imprimirNombre();
		this.imprimirDescription();
		this.ListarUsuarios();
		this.volverAtras();

	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}

	/**
	 * listar los usuarios que estan identificados en el sistema
	 */
	private void ListarUsuarios() {
		listarUsuariosAdministrador();
		ListarUsuariosGeneral();

	}

	/**
	 * Listar los usuarios adminitradores identificados en el sistema
	 */
	public void listarUsuariosAdministrador() {
		System.out.println("Usuario Administrador: ");
		for (int i = 0; i < AdministrarUsuarios.getUsuarioAdministrador().size(); i++) {
			System.out.println(i + " " + AdministrarUsuarios.getUsuarioAdministrador().get(i).getNombre());
		}
	}

	/**
	 * Listar los usuarios generales identificados en el sistema
	 */
	public void ListarUsuariosGeneral() {
		System.out.println("Usuario General: ");
		for (int i = 0; i < AdministrarUsuarios.getUsuarioGeneral().size(); i++) {
			System.out.println(i + " " + AdministrarUsuarios.getUsuarioGeneral().get(i).getNombre());
		}

	}

}
