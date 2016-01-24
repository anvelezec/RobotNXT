package objetos.futbol.UI.opciones.main;

import java.util.ArrayList;

import javax.swing.JFrame;

import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.Usuario;
import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.UI.opciones.main.administrarUsuarios.AgregarUsuario;
import objetos.futbol.UI.opciones.main.administrarUsuarios.EliminarUsuario;
import objetos.futbol.UI.opciones.main.administrarUsuarios.ListarUsuarios;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.varios.ManejoXML;
import objetos.futbol.varios.ManejoXMLeer;
/**
 * clase administrar usuario
 * @author luisa
 *
 */
public class AdministrarUsuarios extends OpcionGeneral {
	static ManejoXML XML = new ManejoXML("Ususarios.xml");
	static ManejoXMLeer leerXML = new ManejoXMLeer("Ususarios.xml");
	private boolean backFlag = false;
	private static ArrayList<UsuarioAdministrador> usuarioAdministrador = new ArrayList<UsuarioAdministrador>();
	private static ArrayList<UsuarioGeneral> usuarioGeneral = new ArrayList<UsuarioGeneral>();
	private static AdministrarUsuariosFrame administrarUsuariosFrame= new AdministrarUsuariosFrame();
	/**
	 * constructor para administrar usuarios  sin argumentos
	 */
	public AdministrarUsuarios(){
		super(true, false, "Administra los usuarios", "Administrar Usuarios", new ArrayList<Opcion>());
		this.getOpciones().add(new AgregarUsuario());
		this.getOpciones().add(new ListarUsuarios());
		this.getOpciones().add(new EliminarUsuario());
		cargarUsuarios();
		administrarUsuariosFrame.listarUsuarios.cargarUsuarios();

	}
	/**
	 * constructor para administrar usuarios
	 * @param opciones
	 */
	public AdministrarUsuarios(	ArrayList<Opcion> opciones) {
		super(true, true, "Administra los usuarios", "Administrar Usuarios", opciones);
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * cargar usuario en el sistema 
	 */
	private void cargarUsuarios(){
		ArrayList<Usuario> usuariosleidos = new ArrayList<Usuario>();
		usuariosleidos=leerXML.leerUsuariosXML();
		for (int i = 0; i < usuariosleidos.size(); i++) {
			if(usuariosleidos.get(i) instanceof UsuarioGeneral){
				usuarioGeneral.add((UsuarioGeneral)usuariosleidos.get(i));
			}
			else if (usuariosleidos.get(i) instanceof UsuarioAdministrador) {
				usuarioAdministrador.add((UsuarioAdministrador)usuariosleidos.get(i));
			}
		}
	}

	@Override
	public void ejecutar() {
		/*backFlag=false;
		while (!backFlag) {
			imprimirMenu();
			selecionarrOpcion();
		}*/
		administrarUsuariosFrame.setVisible(true);

	}

	@Override
	public void volverAtras() {
		backFlag = true;
		// TODO Auto-generated method stub

	}

	/**
	 * agregar un usuario administrador
	 * @param usuarioAdministrador
	 */
	public static void addUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
		AdministrarUsuarios.usuarioAdministrador.add(usuarioAdministrador);
		guardarXML();
	}

	/**
	 * quitar un usuario dministrador
	 * @param usuarioAdministrador
	 */
	public static void removeUsuarioAdministrador(UsuarioAdministrador usuarioAdministrador) {
		AdministrarUsuarios.usuarioAdministrador.remove(usuarioAdministrador);
		guardarXML();
	}

	/**
	 * agregaar un usuario general 
	 * @param usuarioGeneral
	 */
	public static void addUsuarioGeneral(UsuarioGeneral usuarioGeneral) {
		AdministrarUsuarios.usuarioGeneral.add(usuarioGeneral);
		guardarXML();
	}

	/**
	 * quitar un usuario general
	 * @param usuarioGeneral2
	 */
	public static void removeUsuarioGeneral(UsuarioGeneral usuarioGeneral2) {
		AdministrarUsuarios.usuarioGeneral.remove(usuarioGeneral2);
		guardarXML();
	}

	/**
	 * consultar array de usuario administrador
	 * @return
	 */
	public static ArrayList<UsuarioAdministrador> getUsuarioAdministrador() {
		return usuarioAdministrador;
	}

	/**
	 * agregar un array de usuario administrador 
	 * @param usuarioAdministrador
	 */
	public static void setUsuarioAdministrador(ArrayList<UsuarioAdministrador> usuarioAdministrador) {
		AdministrarUsuarios.usuarioAdministrador = usuarioAdministrador;
		guardarXML();
	}

	/**
	 * consultar array en listas de usuario general
	 * @return
	 */
	public static ArrayList<UsuarioGeneral> getUsuarioGeneral() {
		return usuarioGeneral;
	}
	/**
	 * agregar un array de usuarios generales
	 * @param usuarioGeneral
	 */
	public static void setUsuarioGeneral(ArrayList<UsuarioGeneral> usuarioGeneral) {
		AdministrarUsuarios.usuarioGeneral = usuarioGeneral;
		guardarXML();
	}
	
	/**
	 * guardar XML
	 */
	public static void guardarXML(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(usuarioAdministrador);
		usuarios.addAll(usuarioGeneral);
		XML.guardarUsuarios(usuarios);
		administrarUsuariosFrame.listarUsuarios.cargarUsuarios();
	}
	public static AdministrarUsuariosFrame getAdministrarUsuariosFrame() {
		return administrarUsuariosFrame;
	}
	public static void setAdministrarUsuariosFrame(AdministrarUsuariosFrame administrarUsuariosFrame) {
		AdministrarUsuarios.administrarUsuariosFrame = administrarUsuariosFrame;
	}
	
	

}
