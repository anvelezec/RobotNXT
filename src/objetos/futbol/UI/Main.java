package objetos.futbol.UI;

import java.util.ArrayList;

import objetos.futbol.Interfaz.VentanaBienvenida;
import objetos.futbol.varios.ManejoXML;
import objetos.futbol.varios.ManejoXMLeer;

public class Main {

	public static ArrayList<Usuario> usuariosleidos = new ArrayList<Usuario>();
	
	public static void main(String[] args)  {
		
		UsuarioAdministrador andres = new UsuarioAdministrador("andres", "123");
		UsuarioGeneral pedro = new UsuarioGeneral("pedro", "321");
		
		ManejoXML XML = new ManejoXML("Ususarios.xml");
		ManejoXMLeer leerXML = new ManejoXMLeer("Ususarios.xml");
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(pedro);
		usuarios.add(andres);
		
		XML.guardarUsuarios(usuarios);
		
		usuariosleidos=leerXML.leerUsuariosXML();
		VentanaBienvenida ventana1 = new VentanaBienvenida();
		
	}

}
