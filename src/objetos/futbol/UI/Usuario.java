package objetos.futbol.UI;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * clase para definir usuarios
 * @author luisa
 *
 */
public abstract class Usuario {
	private String nombre;
	private String password;
	private boolean isAdmin;
	private boolean isUser;

	/**
	 * construtor usuario 
	 * @param nombre
	 * @param password
	 */
	public Usuario(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	
	/**
	 * contructor usuario
	 * @param nombre
	 * @param password
	 * @param isAdmin
	 * @param isUser
	 */
	public Usuario(String nombre, String password, boolean isAdmin, boolean isUser) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isUser = isUser;
	}


	/**
	 * consultar nombre de usuario
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * darle nombre a usuarios
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * dar la contraseña
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * configurar contraseña de usuario
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * devuelve true si el administrador
	 * @return
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * configurar admin 
	 * @param isAdmin
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * retorna true si es un usuario 
	 * @return
	 */
	public boolean isUser() {
		return isUser;
	}

	/**
	 * set user
	 * @param isUser
	 */
	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	/**
	 * validar usuario para poder acceder al sistema
	 * @param nombre
	 * @param password
	 * @return
	 */
	public boolean validarUsuario(String nombre, String password) {
		if (this.nombre.equals(nombre)) {
			if (this.password.equals(password)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * guardar en XML el usuario creado 
	 * @param doc
	 * @return
	 */
	public abstract Element usuarioXML(Document doc);
}
