package objetos.futbol.varios;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.robot.Robot;

/**
 * metodo main para inicializar el sistema
 * 
 * @author luisa
 *
 */
public class Main {

	public static void main(String[] args) {

		// Inicializar inicio = new Inicializar();
		// inicio.inicializar();
		ManejoXMLeer leer = new ManejoXMLeer("Robots.xml");

		ArrayList<Robot> robots = new ArrayList<Robot>();
		robots.addAll(leer.leerRobotsXML());

		System.out.println(robots.size());
		System.out.println(robots.get(1).getConexionBT());
	}

}
