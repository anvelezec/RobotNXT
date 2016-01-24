package objetos.futbol.varios;

//import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.*;
import objetos.futbol.UI.Usuario;
import objetos.futbol.cancha.*;
import objetos.futbol.robot.*;

import java.awt.Robot;
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

import lejos.geom.Point;
/**
 * Clase para manejar el XML
 * @author luisa
 *
 */
public class ManejoXML {

	/**
	 * Metodo que me crea estructura XML para objeto tipo jugadaPrimitiva
	 */
	String rutaArchivoFutbolistas;
	
	/**
	 * constructor para el manejo  XML
	 * @param rutaArchivoJugadores
	 */
	public ManejoXML(String rutaArchivoJugadores) {
		super();
		this.rutaArchivoFutbolistas = rutaArchivoJugadores;
	}

	/**
	 * devuelve la ruta de la rut de archivo de jugadores
	 * @return
	 */
	public String getRutaArchivoJugadores() {
		return rutaArchivoFutbolistas;
	}

	/**
	 * damos ruta a un archivo para jugadores
	 * @param rutaArchivoJugadores
	 */
	public void setRutaArchivoJugadores(String rutaArchivoJugadores) {
		this.rutaArchivoFutbolistas = rutaArchivoJugadores;
	}

	/**
	 * Metodo que me crea estructura XML para arrayList de Futbolistas
	 * 
	 * @param futbolistas:
	 *            Guarda en XML un arrayList de Futbolistas
	 */
	public void guardarFutbolistas(ArrayList<Futbolista> futbolistas) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Futbolistas");
			doc.appendChild(rootElement);
			for (int i = 0; i < futbolistas.size(); i++) {
				rootElement.appendChild(futbolistas.get(i).getXMLElement(doc));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(rutaArchivoFutbolistas));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Guarda las jugadas complejas en un XML
	 * @param jugadasComplejas
	 */
	public void guardarJugadasComplejas(ArrayList<JugadaCompleja> jugadasComplejas) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("JugadasComplejas");
			doc.appendChild(rootElement);
			for (int i = 0; i < jugadasComplejas.size(); i++) {
				rootElement.appendChild(jugadasComplejas.get(i).toXMLElement(doc));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(rutaArchivoFutbolistas));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * guarda un arraylist de los robots del sistema
	 * @param robots: Estructra XML robots 
	 */
	public void guardarRobot(ArrayList<objetos.futbol.robot.Robot> robots) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Robots");
			doc.appendChild(rootElement);
			for (int i = 0; i < robots.size(); i++) {
				rootElement.appendChild(robots.get(i).getRobotXML(doc));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(rutaArchivoFutbolistas));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *guardar un array usuario
	 * @param Usuarios
	 */
	public void guardarUsuarios(ArrayList<Usuario> Usuarios) {
		try {
			/*
			FutbolistaXML = doc.createElement("Futbolista");

			Element nombrefutbolista = doc.createElement("Nombre");
			nombrefutbolista.appendChild(doc.createTextNode(futbolista.getNombre()));
			FutbolistaXML.appendChild(nombrefutbolista);
			*/
			
		
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("Usuarios");
			doc.appendChild(rootElement);

			for (int i = 0; i < Usuarios.size(); i++) {
				rootElement.appendChild(Usuarios.get(i).usuarioXML(doc));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(rutaArchivoFutbolistas));
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que me crea estructura XML para objeto tipo JugadaPrimitiva
	 * 
	 * @param doc:
	 *            Documento a exportar estructura XML
	 * @param jugadaPrimitiva:
	 *            jugada primitiva instanciada
	 * @return
	 */
	public Element jugadaPrimitivaXML(Document doc, JugadaPrimitiva jugadaPrimitiva) {
		Element jugadaPrimitivaXML = jugadaPrimitiva.getXMLElment(doc);

		/*
		 * jugadaPrimitivaXML = doc.createElement("JugadaPrimitiva"); Element
		 * tipo = doc.createElement("Tipo");
		 * tipo.appendChild(doc.createTextNode(Integer.toString(jugadaPrimitiva.
		 * getTipo()))); jugadaPrimitivaXML.appendChild(tipo); Element valor =
		 * doc.createElement("Valor");
		 * valor.appendChild(doc.createTextNode(Integer.toString(jugadaPrimitiva
		 * .getValor()))); jugadaPrimitivaXML.appendChild(valor);
		 */

		return jugadaPrimitivaXML;

	}

	/**
	 * Metodo que me crea estructura XML para objeto tipo JugadaCompleja
	 * 
	 * @param doc:Documento
	 *            a exportar estructura XML
	 * @param jugadaCompleja:
	 *            jugada Compleja instanciada
	 * @return
	 */
	public Element jugadaComplejaXML(Document doc, JugadaCompleja jugadaCompleja) {
		Element jugadaComplejaXML = jugadaCompleja.toXMLElement(doc);

		/*
		 * jugadaComplejaXML = doc.createElement("JugadaCompleja");
		 * 
		 * Element nombreJugada = doc.createElement("NombreJugada");
		 * nombreJugada.appendChild(doc.createTextNode(jugadaCompleja.
		 * getNombreJugada())); jugadaComplejaXML.appendChild(nombreJugada);
		 * 
		 * Element fechaCreacion = doc.createElement("FechaCreacion");
		 * fechaCreacion.appendChild(doc.createTextNode(jugadaCompleja.
		 * getFechaCreacion())); jugadaComplejaXML.appendChild(fechaCreacion);
		 * 
		 * Element autor = doc.createElement("Autor"); //
		 * TODO:autor.appendChild(doc.createTextNode(jugadaCompleja.getAutor()))
		 * ; jugadaComplejaXML.appendChild(autor);
		 * 
		 * Element explicacion = doc.createElement("Explicacion");
		 * explicacion.appendChild(doc.createTextNode(jugadaCompleja.
		 * getExplicacion())); jugadaComplejaXML.appendChild(explicacion);
		 * 
		 * Element jugadasPrimitivas = doc.createElement("JugadasPrimitivas");
		 * for (int i = 0; i < jugadaCompleja.getJugadasPrimitivas().size();
		 * i++) { Element jugadaPrimitiva = this.jugadaPrimitivaXML(doc,
		 * jugadaCompleja.getJugadasPrimitivas().get(i));
		 * jugadasPrimitivas.appendChild(jugadaPrimitiva); }
		 * 
		 * jugadaComplejaXML.appendChild(jugadasPrimitivas);
		 */

		return jugadaComplejaXML;
	}

	/**
	 * Metodo que me crea estructura XML de las jugadas realizadas para objeto
	 * ListaJugadas
	 * 
	 * @param doc:Documento
	 *            a exportar estructura XML
	 * @param Listajugada:
	 *            Lista de jugadas realizadas por un jugador
	 * @return
	 */
	public Element ListaJugadasXML(Document doc, Futbolista Listajugada) {
		Element ListaJugadasXML = null;

		Element jugadas = doc.createElement("Jugadas");
		for (int i = 0; i < Listajugada.getListaJugadas().size(); i++) {
			Element jugadacompleja = doc.createElement("JugadaCompleja");
			jugadacompleja.appendChild(this.jugadaComplejaXML(doc, Listajugada.getJugadasComplejas().get(i)));
			jugadas.appendChild(jugadacompleja);
		}

		ListaJugadasXML.appendChild(jugadas);

		return ListaJugadasXML;
	}

	/*
	 * Metodo que me crea estructura XML para objeto tipo Futbolista
	 */

	/**
	 * Metodo que me crea estructura XML para objeto tipo Futbolista
	 * 
	 * @param doc:Documento
	 *            a exportar estructura XML
	 * @param futbolista:
	 *            futbolista instanciado
	 * @return
	 */
	public Element FutbolistaXML(Document doc, Futbolista futbolista) {
		Element FutbolistaXML = futbolista.getXMLElement(doc);

		FutbolistaXML = doc.createElement("Futbolista");

		Element nombrefutbolista = doc.createElement("Nombre");
		nombrefutbolista.appendChild(doc.createTextNode(futbolista.getNombre()));
		FutbolistaXML.appendChild(nombrefutbolista);

		Element posicion = doc.createElement("Posicion");
		posicion.appendChild(doc.createTextNode(futbolista.getPosicion()));
		FutbolistaXML.appendChild(posicion);

		Element jugada = doc.createElement("Jugada");
		jugada.appendChild(this.ListaJugadasXML(doc, futbolista));
		FutbolistaXML.appendChild(jugada);

		Element jugadascomplejas = doc.createElement("JugadasComplejas");
		for (int i = 0; i < futbolista.getJugadasComplejas().size(); i++) {
			Element jugadacompleja = doc.createElement("JugadaCompleja");
			jugadacompleja.appendChild(this.jugadaComplejaXML(doc, futbolista.getJugadasComplejas().get(i)));
			jugadascomplejas.appendChild(jugadacompleja);
		}
		FutbolistaXML.appendChild(jugadascomplejas);

		return FutbolistaXML;// No olvidar retornar un tipo Element

	}

	/**
	 * Metodo que me crea estructura XML para objeto tipo Arquero
	 * 
	 * @param doc:
	 *            Documento a exportar estructura XML
	 * @param arquero:
	 *            Arquero instanciado
	 * @return
	 */
	public Element ArqueroXML(Document doc, Arquero arquero) {
		Element arqueroXML = arquero.getXMLElement(doc);

		/*
		 * arqueroXML = doc.createElement("Arquero");
		 * 
		 * Element tiempoSinGoles = doc.createElement("TiempoSinGoles");
		 * tiempoSinGoles.appendChild(doc.createTextNode(Integer.toString(
		 * arquero.TiempoSinGoles))); arqueroXML.appendChild(tiempoSinGoles);
		 * 
		 * Element dorsal = doc.createElement("Dorsal");
		 * dorsal.appendChild(doc.createTextNode(Integer.toString(arquero.dorsal
		 * ))); arqueroXML.appendChild(dorsal);
		 * 
		 * Element futbolista = doc.createElement("Futbolista");
		 * futbolista.appendChild(this.FutbolistaXML(doc, arquero));
		 * arqueroXML.appendChild(futbolista);
		 */

		return arqueroXML;
	}

	/**
	 * Metodo que me crea estructura XML para objeto tipo Delantero
	 * 
	 * @param doc:
	 *            Documento a exportar estructura XML
	 * @param delantero:
	 *            Delantero instanciado
	 * @return
	 */
	public Element DelanteroXML(Document doc, Delantero delantero) {
		Element delanteroXML = delantero.getXMLElement(doc);

		/*
		 * delanteroXML = doc.createElement("Delantero");
		 * 
		 * Element golesMarcados = doc.createElement("GolesMarcados");
		 * golesMarcados.appendChild(doc.createTextNode(Integer.toString(
		 * delantero.golesMarcados))); delanteroXML.appendChild(golesMarcados);
		 * 
		 * Element dorsal = doc.createElement("Dorsal");
		 * dorsal.appendChild(doc.createTextNode(Integer.toString(delantero.
		 * dorsal))); delanteroXML.appendChild(dorsal);
		 * 
		 * Element futbolista = doc.createElement("Futbolista");
		 * futbolista.appendChild(this.FutbolistaXML(doc, delantero));
		 * delanteroXML.appendChild(futbolista);
		 */

		return delanteroXML;
	}

	/**
	 * Metodo que me crea estructura XML para objeto tipo Cancha
	 * 
	 * @param doc:Documento
	 *            a exportar estructura XML
	 * @param cancha:
	 *            Cancha instanciada
	 * @return
	 */
	public void CanchaXML(Cancha cancha) {
		Element canchaXML = null;
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Canchas");
			
			
			Element escrituraCancha = cancha.getXMLElement(doc);
			rootElement.appendChild(escrituraCancha);
			
			doc.appendChild(rootElement);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(rutaArchivoFutbolistas));
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved! en CanchaXML");
			
		} catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * Metodo que me crea estructura XML para objeto tipo Robot
	 * 
	 * @param doc:
	 *            Documento a exportar estructura XML
	 * @param robot:
	 *            Robot instanciado
	 * @return
	 */
	public Element RobotXML(Document doc, objetos.futbol.robot.Robot robot) {
		Element robotXML = robot.getRobotXML(doc);

		return robotXML;
	}

}
