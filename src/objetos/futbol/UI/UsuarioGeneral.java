package objetos.futbol.UI;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * clase para crear un usuario general extiende de la clase usuario
 * @author luisa
 *
 */
public class UsuarioGeneral extends Usuario {

	/**
	 * constructor para usuario general 
	 * @param nombre
	 * @param password
	 */
	public UsuarioGeneral(String nombre, String password) {
		super(nombre, password, false, true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Element usuarioXML(Document doc) {
		Element usuarioXML = null;

		usuarioXML = doc.createElement("UsuarioGeneral");
		
		Element nombre = doc.createElement("Nombre");
		nombre.appendChild(doc.createTextNode(this.getNombre()));
		usuarioXML.appendChild(nombre);

		Element password = doc.createElement("Password");
		password.appendChild(doc.createTextNode(this.getPassword()));
		usuarioXML.appendChild(password);

		return usuarioXML;
	}

}
