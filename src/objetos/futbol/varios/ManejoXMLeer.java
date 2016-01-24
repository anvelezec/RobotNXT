package objetos.futbol.varios;

import java.util.*;

import objetos.futbol.UI.Usuario;
import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.*;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.robot.Robot;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lejos.geom.Point;
import lejos.geom.Rectangle;
import objetos.futbol.jugadores.*;
import objetos.futbol.robot.JugadaPrimitiva;

/**
 * Clase para manejar archivo XML
 * 
 * @author luisa
 *
 */
public class ManejoXMLeer {

	String direccionArchivoLectura;

	/**
	 * constructor para la lectura del XML
	 * 
	 * @param direccionArchivoLectura
	 */
	public ManejoXMLeer(String direccionArchivoLectura) {
		super();
		this.direccionArchivoLectura = direccionArchivoLectura;
	}

	/**
	 * preguntar direccion de archivo de XML
	 * 
	 * @return
	 */
	public String getDireccionArchivoLectura() {
		return direccionArchivoLectura;
	}

	/**
	 * dar direccion de XML
	 * 
	 * @param direccionArchivoLectura
	 */
	public void setDireccionArchivoLectura(String direccionArchivoLectura) {
		this.direccionArchivoLectura = direccionArchivoLectura;
	}

	/**
	 * Me lee una estructura XML de una jugada jugadaPrimitiva
	 * 
	 * @param Node
	 *            jugada jugadaPrimitiva
	 * @return jugadaPrimitiva
	 */
	public static JugadaPrimitiva LeerJugadaPrimitivaXML(Node jugadaPrimitiva) {

		JugadaPrimitiva jPrimitiva;

		int tipo = 0, valor = 0;
		Element eElement = (Element) jugadaPrimitiva;
		tipo = Integer.parseInt(eElement.getElementsByTagName("Tipo").item(0).getTextContent());
		valor = Integer.parseInt(eElement.getElementsByTagName("Valor").item(0).getTextContent());
		jPrimitiva = new JugadaPrimitiva(tipo, valor);

		return jPrimitiva;

	}

	/**
	 * Me lee una estructura XML de una jugada jugadaCompleja Defensiva
	 * 
	 * @param Node
	 *            jugada jugadaCompleja Defensiva
	 * @return jugadaCompleja Defensiva
	 */
	public static JugadaComplejaDefensiva LeerJugadaComplejaDefensivaXML(Node jugadaCompleja) {
		ArrayList<JugadaPrimitiva> jugadasPrimitivas = new ArrayList<JugadaPrimitiva>();

		Element eElement = (Element) jugadaCompleja;
		String nombre = eElement.getElementsByTagName("NombreJugada").item(0).getTextContent();
		String fechaCreacion = eElement.getElementsByTagName("FechaCreacion").item(0).getTextContent();

		String nombreAutor = eElement.getElementsByTagName("Autor").item(0).getTextContent();
		// UsuarioAdministrador autor = (UsuarioAdministrador)
		// eElement.getElementsByTagName("Autor").item(0);
		// autor.setPassword("");
		UsuarioAdministrador autor = new UsuarioAdministrador(nombreAutor, "");

		String explicacion = eElement.getElementsByTagName("Explicacion").item(0).getTextContent();
		// int atributo1 =
		// Integer.parseInt(eElement.getElementsByTagName("Atributo1").item(0).getTextContent());
		// int atributo2 =
		// Integer.parseInt(eElement.getElementsByTagName("Atributo2").item(0).getTextContent());

		NodeList nList = eElement.getElementsByTagName("JugadasPrimitivas");
		for(int i = 0; i < nList.getLength(); i++) {
			Element elementoJP = (Element) nList.item(i);
			NodeList listaJP = elementoJP.getElementsByTagName("JugadaPrimitiva");
			
			for (int temp = 0; temp < listaJP.getLength(); temp++) {
				Node nNode = listaJP.item(temp);
				jugadasPrimitivas.add(LeerJugadaPrimitivaXML(nNode));
			}
		}
/*
		NodeList listaJugPrim = () nList.getElementsByTagName("JugadaPrimitiva");
		//System.out.println("Tamaño de lista J-P: " + listaJugPrim.getLength());
		for (int temp = 0; temp < listaJugPrim.getLength(); temp++) {
			Node nNode = listaJugPrim.item(temp);
			jugadasPrimitivas.add(LeerJugadaPrimitivaXML(nNode));
		}
*/
		JugadaComplejaDefensiva jComplejaDefensiva = new JugadaComplejaDefensiva(nombre, fechaCreacion, autor,
				explicacion, jugadasPrimitivas);

		return jComplejaDefensiva;
	}

	/*
	 * Me lee una estructura XML de una jugada compleja ofensiva
	 */

	/**
	 * Me lee una estructura XML de una jugada jugadaCompleja Ofensiva
	 * 
	 * @param Node
	 *            jugada jugadaCompleja Ofensiva
	 * @return jugadaCompleja Ofensiva
	 */
	public static JugadaComplejaOfensiva LeerJugadaComplejaOfensivaXML(Node jugadaCompleja) {
		ArrayList<JugadaPrimitiva> jugadasPrimitivas = new ArrayList<JugadaPrimitiva>();

		Element eElement = (Element) jugadaCompleja;
		String nombre = eElement.getElementsByTagName("NombreJugada").item(0).getTextContent();
		String fechaCreacion = eElement.getElementsByTagName("FechaCreacion").item(0).getTextContent();

		String nombreAutor = eElement.getElementsByTagName("Autor").item(0).getTextContent();
		// UsuarioAdministrador autor = (UsuarioAdministrador)
		// eElement.getElementsByTagName("Autor").item(0);
		// autor.setPassword("");
		UsuarioAdministrador autor = new UsuarioAdministrador(nombreAutor, "");

		String explicacion = eElement.getElementsByTagName("Explicacion").item(0).getTextContent();
		// int atributo1 =
		// Integer.parseInt(eElement.getElementsByTagName("Atributo1").item(0).getTextContent());
		// int atributo2 =
		// Integer.parseInt(eElement.getElementsByTagName("Atributo2").item(0).getTextContent());

		NodeList nList = eElement.getElementsByTagName("JugadasPrimitivas");
		for(int i = 0; i < nList.getLength(); i++) {
			Element elementoJP = (Element) nList.item(i);
			NodeList listaJP = elementoJP.getElementsByTagName("JugadaPrimitiva");
			
			for (int temp = 0; temp < listaJP.getLength(); temp++) {
				Node nNode = listaJP.item(temp);
				jugadasPrimitivas.add(LeerJugadaPrimitivaXML(nNode));
			}
		}
		/*
		Element nJCompleja = (Element) jugadaCompleja;

		NodeList nList = nJCompleja.getElementsByTagName("JugadasPrimitivas");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			jugadasPrimitivas.add(LeerJugadaPrimitivaXML(nNode));
		}
		*/
		JugadaComplejaOfensiva jComplejaDefensiva = new JugadaComplejaOfensiva(nombre, fechaCreacion, autor,
				explicacion, jugadasPrimitivas);

		return jComplejaDefensiva;
	}

	/**
	 * Me lee una estructura XML de una jugada jugadaCompleja TiroLibro
	 * 
	 * @param Node
	 *            jugada jugadaCompleja TiroLibre
	 * @return jugadaCompleja TiroLibro
	 */
	public static JugadaComplejaTiroLibre LeerJugadaComplejaTiroLibreXML(Node jugadaCompleja) {
		ArrayList<JugadaPrimitiva> jugadasPrimitivas = new ArrayList<JugadaPrimitiva>();

		Element eElement = (Element) jugadaCompleja;
		String nombre = eElement.getElementsByTagName("NombreJugada").item(0).getTextContent();
		String fechaCreacion = eElement.getElementsByTagName("FechaCreacion").item(0).getTextContent();

		String nombreAutor = eElement.getElementsByTagName("Autor").item(0).getTextContent();
		// UsuarioAdministrador autor = (UsuarioAdministrador)
		// eElement.getElementsByTagName("Autor").item(0);
		// autor.setPassword("");
		UsuarioAdministrador autor = new UsuarioAdministrador(nombreAutor, "");

		String explicacion = eElement.getElementsByTagName("Explicacion").item(0).getTextContent();
		// int atributo1 =
		// Integer.parseInt(eElement.getElementsByTagName("Atributo1").item(0).getTextContent());
		// int atributo2 =
		// Integer.parseInt(eElement.getElementsByTagName("Atributo2").item(0).getTextContent());

		NodeList nList = eElement.getElementsByTagName("JugadasPrimitivas");
		for(int i = 0; i < nList.getLength(); i++) {
			Element elementoJP = (Element) nList.item(i);
			NodeList listaJP = elementoJP.getElementsByTagName("JugadaPrimitiva");
			
			for (int temp = 0; temp < listaJP.getLength(); temp++) {
				Node nNode = listaJP.item(temp);
				jugadasPrimitivas.add(LeerJugadaPrimitivaXML(nNode));
			}
		}
		/*
		Element nJCompleja = (Element) jugadaCompleja;

		NodeList nList = nJCompleja.getElementsByTagName("JugadasPrimitivas");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			jugadasPrimitivas.add(LeerJugadaPrimitivaXML(nNode));
		}
		*/
		JugadaComplejaTiroLibre jComplejaDefensiva = new JugadaComplejaTiroLibre(nombre, fechaCreacion, autor,
				explicacion, jugadasPrimitivas);

		return jComplejaDefensiva;
	}

	/**
	 * Me lee una estructura XML de un Delantero
	 * 
	 * @param Node
	 *            Delantero
	 * @return Delantero
	 */
	public static Delantero DelanteroXMLectura(Node nodefutbolista) {
		Delantero DelanteroInstanciado = null;

		if (nodefutbolista.getNodeType() == Node.ELEMENT_NODE) {

			Element futbolistaElement = (Element) nodefutbolista;

			String nombre = futbolistaElement.getElementsByTagName("Nombre").item(0).getTextContent();
			String posicion = futbolistaElement.getElementsByTagName("Posicion").item(0).getTextContent();
			short golesMarcados = (short) Integer
					.parseInt(futbolistaElement.getElementsByTagName("GolesMArcados").item(0).getTextContent());
			byte dorsal = (byte) Integer
					.parseInt(futbolistaElement.getElementsByTagName("Dorsal").item(0).getTextContent());

			String imagen=futbolistaElement.getElementsByTagName("Imagen").item(0).getTextContent();
			// Jugadas
			ArrayList<String> jugadalistaJugada = new ArrayList<String>();

			NodeList listaJugadas = futbolistaElement.getElementsByTagName("Jugadas");

			for (int i = 0; i < listaJugadas.getLength(); i++) {
				jugadalistaJugada.add(listaJugadas.item(i).getTextContent());

			}
			// lista jugadas fin

			// jugadas complejas
			ArrayList<JugadaCompleja> jugadaComplejas = new ArrayList<JugadaCompleja>();

			NodeList jugadasComplejasN = futbolistaElement.getElementsByTagName("JugadasComplejas");
			for (int temp = 0; temp < jugadasComplejasN.getLength(); temp++) {
				Element jugadasComplejas = (Element) jugadasComplejasN.item(temp);

				NodeList jugadasComplejasDefensivas = jugadasComplejas.getElementsByTagName("JugadaComplejaDefensiva");

				for (int i = 0; i < jugadasComplejasDefensivas.getLength(); i++) {
					Node jugadasComplejasDefensivasIesima = jugadasComplejasDefensivas.item(i);
					JugadaCompleja jugadaComplejaDefensivaInstanciada = LeerJugadaComplejaDefensivaXML(
							jugadasComplejasDefensivasIesima);
					jugadaComplejas.add(jugadaComplejaDefensivaInstanciada);
				}

				NodeList jugadasComplejasOfensivas = jugadasComplejas.getElementsByTagName("JugadaComplejaOfensiva");

				for (int i = 0; i < jugadasComplejasOfensivas.getLength(); i++) {
					Node jugadasComplejasOfensivasIesima = jugadasComplejasOfensivas.item(i);
					JugadaCompleja jugadaComplejaOfensivaInstanciada = LeerJugadaComplejaOfensivaXML(
							jugadasComplejasOfensivasIesima);
					jugadaComplejas.add(jugadaComplejaOfensivaInstanciada);
				}

				NodeList jugadasComplejasTiroLibre = jugadasComplejas.getElementsByTagName("JugadaComplejaTiroLibre");

				for (int i = 0; i < jugadasComplejasTiroLibre.getLength(); i++) {
					Node jugadasComplejasTiroLibreIesima = jugadasComplejasTiroLibre.item(i);
					JugadaCompleja jugadaComplejaTiroLibreInstanciada = LeerJugadaComplejaTiroLibreXML(
							jugadasComplejasTiroLibreIesima);
					jugadaComplejas.add(jugadaComplejaTiroLibreInstanciada);
				}
				// fin jugadas complejas
			}
			
			DelanteroInstanciado = new Delantero(nombre, posicion, jugadaComplejas, golesMarcados, dorsal,imagen);
			DelanteroInstanciado.setListaJugadas(jugadalistaJugada);

		}

		return DelanteroInstanciado;

	}

	/**
	 * Me lee una estructura XML de un Arquero
	 * 
	 * @param Node
	 *            Arquero
	 * @return Arquero
	 */
	public static Arquero ArqueroXMLectura(Node nodefutbolista) {
		Arquero ArqueroInstanciado = null;

		if (nodefutbolista.getNodeType() == Node.ELEMENT_NODE) {
			Element futbolistaElement = (Element) nodefutbolista;

			String nombre = futbolistaElement.getElementsByTagName("Nombre").item(0).getTextContent();
			String posicion = futbolistaElement.getElementsByTagName("Posicion").item(0).getTextContent();
			// System.out.println(futbolistaElement.getElementsByTagName("TiempoSinGoles").item(0).getNodeValue());
			int tiempoSinGoles = Integer
					.parseInt(futbolistaElement.getElementsByTagName("TiempoSinGoles").item(0).getTextContent());
			// int tiempoSinGoles = -1;
			byte dorsal = (byte) Integer
					.parseInt(futbolistaElement.getElementsByTagName("Dorsal").item(0).getTextContent());

			String imagen=futbolistaElement.getElementsByTagName("Imagen").item(0).getTextContent();
			
			// Jugadas
			ArrayList<String> jugadalistaJugada = new ArrayList<String>();

			NodeList listaJugadas = futbolistaElement.getElementsByTagName("Jugadas");

			for (int i = 0; i < listaJugadas.getLength(); i++) {
				jugadalistaJugada.add(listaJugadas.item(i).getTextContent());

			}

			// lista jugadas fin

			// jugadas complejas
			// NodeList jugadasComplejas =
			// futbolistaElement.getElementsByTagName("JugadasComplejas");
			ArrayList<JugadaCompleja> jugadaComplejas = new ArrayList<JugadaCompleja>();

			NodeList jugadasComplejasN = futbolistaElement.getElementsByTagName("JugadasComplejas");
			for (int temp = 0; temp < jugadasComplejasN.getLength(); temp++) {
				Element jugadasComplejas = (Element) jugadasComplejasN.item(temp);

				NodeList jugadasComplejasDefensivas = jugadasComplejas.getElementsByTagName("JugadaComplejaDefensiva");

				for (int i = 0; i < jugadasComplejasDefensivas.getLength(); i++) {
					Node jugadasComplejasDefensivasIesima = jugadasComplejasDefensivas.item(i);
					JugadaCompleja jugadaComplejaDefensivaInstanciada = LeerJugadaComplejaDefensivaXML(
							jugadasComplejasDefensivasIesima);
					jugadaComplejas.add(jugadaComplejaDefensivaInstanciada);
				}

				NodeList jugadasComplejasOfensivas = jugadasComplejas.getElementsByTagName("JugadaComplejaOfensiva");

				for (int i = 0; i < jugadasComplejasOfensivas.getLength(); i++) {
					Node jugadasComplejasOfensivasIesima = jugadasComplejasOfensivas.item(i);
					JugadaCompleja jugadaComplejaOfensivaInstanciada = LeerJugadaComplejaOfensivaXML(
							jugadasComplejasOfensivasIesima);
					jugadaComplejas.add(jugadaComplejaOfensivaInstanciada);
				}

				NodeList jugadasComplejasTiroLibre = jugadasComplejas.getElementsByTagName("JugadaComplejaTiroLibre");

				for (int i = 0; i < jugadasComplejasTiroLibre.getLength(); i++) {
					Node jugadasComplejasTiroLibreIesima = jugadasComplejasTiroLibre.item(i);
					JugadaCompleja jugadaComplejaTiroLibreInstanciada = LeerJugadaComplejaTiroLibreXML(
							jugadasComplejasTiroLibreIesima);
					jugadaComplejas.add(jugadaComplejaTiroLibreInstanciada);
				}
				// fin jugadas complejas
			}

			// fin jugadas complejas

			ArqueroInstanciado = new Arquero(nombre, posicion, jugadaComplejas, tiempoSinGoles, dorsal,imagen);
			ArqueroInstanciado.setListaJugadas(jugadalistaJugada);
		}
		return ArqueroInstanciado;

	}

	/**
	 * Me lee una estructura XML de varios Futbolistas independientemente si son
	 * Arqeros o Delanteros
	 * 
	 * @param Node
	 *            Futbolistas
	 * @return Futbolistas
	 */
	public void FutbolistaXMLeer() {
		try {
			File fXmlFile = new File(direccionArchivoLectura);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList listaDelanteros = doc.getElementsByTagName("Delantero");
			NodeList listaArqueros = doc.getElementsByTagName("Arquero");

			for (int i = 0; i < listaDelanteros.getLength(); i++) {
				Node delantero = listaDelanteros.item(i);
				DelanteroXMLectura(delantero);
			}

			for (int i = 0; i < listaArqueros.getLength(); i++) {
				Node arquero = listaArqueros.item(i);
				ArqueroXMLectura(arquero);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Filed read !");
	}

	/**
	 * leer delanteros XML
	 * 
	 * @return ArrayList de delanteros
	 */
	public static ArrayList<Delantero> leerDelanteroXML() {
		ArrayList<Delantero> delanteros = new ArrayList<Delantero>();
		try {
			File fXmlFile = new File("jugadores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList listaDelanteros = doc.getElementsByTagName("Delantero");
			for (int i = 0; i < listaDelanteros.getLength(); i++) {
				Node delantero = listaDelanteros.item(i);
				delanteros.add(DelanteroXMLectura(delantero));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delanteros;
	}

	/**
	 * Leer la lista de arqueros del XML
	 * 
	 * @return ArrayList de Arqueros
	 */
	public static ArrayList<Arquero> leerArqueroXML() {
		ArrayList<Arquero> arqueros = new ArrayList<Arquero>();
		try {
			File fXmlFile = new File("jugadores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList listaArqueros = doc.getElementsByTagName("Arquero");
			for (int i = 0; i < listaArqueros.getLength(); i++) {
				Node arquero = listaArqueros.item(i);
				arqueros.add(ArqueroXMLectura(arquero));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arqueros;
	}

	/**
	 * leer usuario Administrador desde el XML
	 * 
	 * @param usuarioAdministrador
	 *            : Estructura usuario administrador XML
	 * @return Un usuario Administrador indexado
	 */
	public UsuarioAdministrador leerUsusarioAdministradorXML(Node usuarioAdministrador) {
		UsuarioAdministrador instanaciaUsuarioAdministrador = null;
		if (usuarioAdministrador.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) usuarioAdministrador;
			String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
			String password = eElement.getElementsByTagName("Password").item(0).getTextContent();

			instanaciaUsuarioAdministrador = new UsuarioAdministrador(nombre, password);
		}
		return instanaciaUsuarioAdministrador;
	}

	/**
	 * Leer un usuario general desde el XML
	 * 
	 * @param usuarioGeneral
	 *            : Estructura XML de un usuario General
	 * @return Un Usuario general indexado
	 */
	public UsuarioGeneral leerUsusarioGeneralXML(Node usuarioGeneral) {
		UsuarioGeneral instanciaUsuarioGeneral = null;
		if (usuarioGeneral.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) usuarioGeneral;
			String nombre = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
			String password = eElement.getElementsByTagName("Password").item(0).getTextContent();
			instanciaUsuarioGeneral = new UsuarioGeneral(nombre, password);
		}
		return instanciaUsuarioGeneral;
	}

	/**
	 * Leer jugadas complejas desde un XML
	 * 
	 * @return Lista con jugadasComplejas
	 */
	public ArrayList<JugadaCompleja> JugadasComplejasXML() {
		ArrayList<JugadaCompleja> jugadasComplejas = new ArrayList<JugadaCompleja>();
		try {
			File fXmlFile = new File(direccionArchivoLectura);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList listaJugadasComplejasDefensivas = doc.getElementsByTagName("JugadaComplejaDefensiva");

			for (int i = 0; i < listaJugadasComplejasDefensivas.getLength(); i++) {
				Node jugadaCompleja = listaJugadasComplejasDefensivas.item(i);
				jugadasComplejas.add(LeerJugadaComplejaDefensivaXML(jugadaCompleja));
			}

			NodeList listaJugadasComplejasOfensiva = doc.getElementsByTagName("JugadaComplejaOfensiva");

			for (int i = 0; i < listaJugadasComplejasOfensiva.getLength(); i++) {
				Node jugadaCompleja = listaJugadasComplejasOfensiva.item(i);
				jugadasComplejas.add(LeerJugadaComplejaDefensivaXML(jugadaCompleja));
			}

			NodeList listaJugadasComplejasTiroLibre = doc.getElementsByTagName("JugadaComplejaTiroLibre");

			for (int i = 0; i < listaJugadasComplejasTiroLibre.getLength(); i++) {
				Node jugadaCompleja = listaJugadasComplejasTiroLibre.item(i);
				jugadasComplejas.add(LeerJugadaComplejaDefensivaXML(jugadaCompleja));
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return jugadasComplejas;
	}

	/**
	 * leer un usuario desde el XML
	 * 
	 * @return
	 */
	public ArrayList<Usuario> leerUsuariosXML() {
		ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
		try {
			File fXmlFile = new File(direccionArchivoLectura);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList UsuariosAdministrador = doc.getElementsByTagName("UsuarioAdministrador");

			for (int i = 0; i < UsuariosAdministrador.getLength(); i++) {
				Node usuarioAdministrador = UsuariosAdministrador.item(i);
				Usuarios.add(leerUsusarioAdministradorXML(usuarioAdministrador));
			}

			NodeList UsuariosGeneral = doc.getElementsByTagName("UsuarioGeneral");

			for (int i = 0; i < UsuariosGeneral.getLength(); i++) {
				Node usuarioGeneral = UsuariosGeneral.item(i);
				Usuarios.add(leerUsusarioGeneralXML(usuarioGeneral));
			}
		} catch (Exception e) {

		}

		return Usuarios;
	}

	/**
	 * Leer los robots instanciados
	 * 
	 * @return: Array list de robos instanciados
	 */

	public ArrayList<Robot> leerRobotsXML() {
		ArrayList<Robot> listaRobots = new ArrayList<Robot>();
		try {
			File fXmlFile = new File(direccionArchivoLectura);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nodeListRobots = doc.getElementsByTagName("Robot");
			
			for (int i = 0; i < nodeListRobots.getLength(); i++) {
				Node robot = nodeListRobots.item(i);
				listaRobots.add(lecturaXMLRobot(robot));
			}

		} catch (Exception e) {

		}

		return listaRobots;
	}

	/**
	 * leer Xml
	 * 
	 * @param robot:
	 *            Estructura Nodo de un robot
	 * @return robot instanciado
	 */
	public Robot lecturaXMLRobot(Node robot) {
		Robot robotInstanciado;

		Element eElement = (Element) robot;

		// NodeList futbolistas= eElement.getElementsByTagName("Futbolistas");

		int lonDelantero = eElement.getElementsByTagName("Delantero").getLength();
		int lonArquero = eElement.getElementsByTagName("Arquero").getLength();
		Futbolista futbolista = null;

		if (lonArquero > 0) {
			Node arquero = eElement.getElementsByTagName("Arquero").item(0);
			futbolista = ArqueroXMLectura(arquero);
		} else if (lonDelantero > 0) {
			Node delantero = eElement.getElementsByTagName("Delantero").item(0);
			futbolista = DelanteroXMLectura(delantero);
		}

		String coneccionBluetooth = eElement.getElementsByTagName("ConeccionBluetooth").item(0).getTextContent();

		// Element punto = (Element)
		// eElement.getElementsByTagName("PosicionRelativa");
		NodeList punto = eElement.getElementsByTagName("PosicionRelativa");

		// float xRobot = (float)
		// Double.parseDouble(punto.getElementsByTagName("X").item(0).getTextContent());
		// float yRobot = (float)
		// Double.parseDouble(punto.getElementsByTagName("Y").item(0).getTextContent());

		Element xRobot = (Element) punto.item(0);
		float xRobotInstanciado = (float) Double.parseDouble(xRobot.getElementsByTagName("X").item(0).getTextContent());

		Element yRobot = (Element) punto.item(0);
		float yRobotInstanciado = (float) Double.parseDouble(yRobot.getElementsByTagName("Y").item(0).getTextContent());

		Point puntoInstanciado = new Point(xRobotInstanciado, yRobotInstanciado);

		robotInstanciado = new Robot(puntoInstanciado, futbolista, coneccionBluetooth);

		return robotInstanciado;
	}

	/**
	 * Lee la cancha
	 * 
	 * @return
	 */
	public Cancha lecturaXMLCancha() {
		Cancha canchaInstanciada = new Cancha();
		try {
			File fXmlFile = new File(direccionArchivoLectura);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			/*
			 * NodeList estadio = doc.getElementsByTagName("Estadio"); NodeList
			 * cancha1 = doc.getElementsByTagName("Cancha"); NodeList ZonaArqIzq
			 * = doc.getElementsByTagName("ZonaArqueroIzquierdo"); NodeList
			 * ZonaJuego = doc.getElementsByTagName("ZonaJuego"); NodeList
			 * ArcoIzq = doc.getElementsByTagName("ArcoIzquierdo"); NodeList
			 * ZonaArqDer = doc.getElementsByTagName("ZonaArqueroDerecha");
			 * NodeList ArcoDer = doc.getElementsByTagName("ArcoDerecha");
			 * 
			 */
			ArrayList<Robot> robots = new ArrayList<Robot>();
			NodeList Robots = doc.getElementsByTagName("Robot");
			for (int i = 0; i < Robots.getLength(); i++) {
				Node robot = Robots.item(i);
				robots.add(this.lecturaXMLRobot(robot));
			}

			int elementoMarcadorEquipo = Integer
					.parseInt(doc.getElementsByTagName("MarcadorEquipo").item(0).getTextContent());
			int elementoMarcadorEnemigo = Integer
					.parseInt(doc.getElementsByTagName("MarcadorEnemigo").item(0).getTextContent());

			canchaInstanciada.setMarcadorEnemigo(elementoMarcadorEnemigo);
			canchaInstanciada.setMarcadorEquipo(elementoMarcadorEquipo);
			canchaInstanciada.setRobots(robots);

			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return canchaInstanciada;
	}

}
