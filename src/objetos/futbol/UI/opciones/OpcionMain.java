package objetos.futbol.UI.opciones;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import objetos.futbol.UI.Opcion;
import objetos.futbol.UI.OpcionGeneral;
import objetos.futbol.UI.Usuario;
import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.varios.LecturaTeclado;
/**
 *clase opcion hija de opcion general 
 * @author luisa
 *
 */
public class OpcionMain extends OpcionGeneral {
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static Usuario usuarioLogeado= new UsuarioAdministrador("Admin", "123");;
	private static MenuAdministrador menuAdministrador= new MenuAdministrador();
	private static Juego juego = new Juego();
	/**
	 * constructor de opcion main sin argumentos
	 */
	public OpcionMain(){
		super(true, true, "Opcion principal de menu principal", "Menu Inicio", new ArrayList<Opcion>());
		//this.getOpciones().add(new AdministrarUsuarios());
		//this.getOpciones().add(new AdministrarJugadasComplejas());
		//this.getOpciones().add(new AdministrarJugadores());
		//this.getOpciones().add(new AdministrarRobot());
		//this.getOpciones().add(new AdministrarCancha());
		UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador("Admin", "123");
		OpcionMain.addUsuario(usuarioAdministrador);
		usuarios.addAll(AdministrarUsuarios.getUsuarioAdministrador());
		usuarios.addAll(AdministrarUsuarios.getUsuarioGeneral());
		//menuAdministrador= new MenuAdministrador();
	}

	/**
	 * constructor opcion main
	 * @param opciones
	 */
	public OpcionMain(ArrayList<Opcion> opciones) {
		// TODO Auto-generated constructor stub
		super(true, true, "Opcion principal de menu principal", "Menu Inicio", opciones);
		UsuarioAdministrador usuarioAdministrador = new UsuarioAdministrador("Admin", "123");
		OpcionMain.addUsuario(usuarioAdministrador);
		usuarios.addAll(AdministrarUsuarios.getUsuarioAdministrador());
		usuarios.addAll(AdministrarUsuarios.getUsuarioGeneral());
		// OpcionMain.setUsuarioLogeado(usuarioAdministrador);
	}
	/**
	 * consultar el array de usuarios
	 * @return
	 */
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * dar una array de usuarios 
	 * @param usuarios
	 */
	public static void setUsuarios(ArrayList<Usuario> usuarios) {
		OpcionMain.usuarios = usuarios;
	}

	/** 
	 * consultar el usuario logeado
	 * @return
	 */
	public static Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	/**
	 * ingresar un usuario para logearlo
	 * @param usuarioLogeado
	 */
	public static void setUsuarioLogeado(Usuario usuarioLogeado) {
		OpcionMain.usuarioLogeado = usuarioLogeado;
	}

	@Override
	public void ejecutar() {
		//menuAdministrador.setVisible(true);
		juego.getJuegoFrame().setVisible(true);
		

	}
	public void admin(){
		menuAdministrador.setVisible(true);
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	/**
	 * validar usuario y darle la bienvenida 
	 * @param nombre
	 * @param password
	 * @return
	 */
	public boolean validarUsuario(String nombre, String password) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).validarUsuario(nombre, password)) {
				usuarioLogeado = usuarios.get(i);
				System.out.println("Bienvenido " + usuarioLogeado.getNombre());
				return true;
			}
		}
		System.out.println("Error usuario o password no valida");
		return false;
	}

	/**
	 * ejecutar el menu para el usuario predeterminado
	 */
	private void ejecutarValido() {
		while (true) {
			this.imprimirMenu();
			selecionarrOpcion();
		}
	}

	/**
	 * agregar un usuario
	 * @param usuario
	 */
	public static void addUsuario(Usuario usuario) {
		OpcionMain.usuarios.add(usuario);
		guardarUsuarioXML();
	}
	/** 
	 * guardar un usuario n un XML
	 */
	public static void guardarUsuarioXML(){
		//TODO guardarXML todos los usuarios
	}
	public void ejecutarOpcion(Opcion opcion){
		this.ejecutarOpcion(this.getOpciones().indexOf(opcion));
		
	}

}
