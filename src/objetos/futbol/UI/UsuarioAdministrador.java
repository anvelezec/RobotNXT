package objetos.futbol.UI;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * clase usuario administrador 
 * crear un usuario que sea administrador del sistema
 * @author luisa
 *
 */
public class UsuarioAdministrador extends Usuario {

	/** 
	 * constructor para usuario administrador
	 * @param nombre
	 * @param password
	 */
	public UsuarioAdministrador(String nombre, String password) {
		super(nombre, password, true, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Element usuarioXML(Document doc) {
		Element usuarioXML = null;

		usuarioXML = doc.createElement("UsuarioAdministrador");
		
		Element nombre = doc.createElement("Nombre");
		nombre.appendChild(doc.createTextNode(this.getNombre()));
		usuarioXML.appendChild(nombre);

		Element password = doc.createElement("Password");
		password.appendChild(doc.createTextNode(this.getPassword()));
		usuarioXML.appendChild(password);

		return usuarioXML;
	}
	
}
