package objetos.futbol.varios;
import objetos.futbol.jugadores.*;
import java.io.File;
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
import java.util.*;
/**
 * Manejo de las jugadas complejas y primitivas de los futbolistas
 * @author luisa
 *
 */
public class Manejo_de_jugadas {
	private Queue<Futbolista> InfoJugador = new LinkedList <>();
	CalcularTiempo momento = new CalcularTiempo();
	private static int dorsal;
	private static long tiempo;
	private static String nombre;
	private static Futbolista jugada;
	
	/**
	 * constructor para almacenar un futbolista
	 * @param jugador
	 */
	public void Almacenar(Futbolista jugador){
		nombre = jugador.getNombre();
		jugada = jugador;
	}
	
	
	public static void main(String [] args) {
    	
                try {
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                    Document doc = docBuilder.newDocument(); // Crear un nuevo documento
                    Element  Tipo = doc.createElement("Tipo");   // Crea un <futbolista> de doc 
                    doc.appendChild(Tipo);
                    
                    Element Arquero = doc.createElement("Arquero");   
                    Tipo.appendChild(Arquero);

                    Element Futbolista = doc.createElement("Futbolista");   // Crea un <futbolista> de doc 
                    Tipo.appendChild(Futbolista);
            for(int i = 0; i < 10; i++) {
                if(i % 2 == 0 /* Es Futbolista? */) {
                    /*
                    
                        Debo crear una instancia de si la jugada que se realizo fue un gol para crear una instancia que me permita
                        ir a desarrollar otro código. Esto se ha creado con el fin de luego reemplazar i por el dorsal del jugador.
                    
                    */
                    if(i == 0) {
                        Element  Jugador1 = doc.createElement("Jugador" + Integer.toString(i+1));   // Crea un <futbolista> de doc 
                        Futbolista.appendChild(Jugador1);
                    }
                    else if(i == 2){
                        Element  Jugador2 = doc.createElement("Jugador" + Integer.toString(i+1));   // Crea un <futbolista> de doc 
                        Futbolista.appendChild(Jugador2);
                    }
                    else if(i == 4){
                        Element  Jugador3 = doc.createElement("Jugador" + Integer.toString(i+1));   // Crea un <futbolista> de doc 
                        Futbolista.appendChild(Jugador3);
                    }
                    else if(i == 6){
                        Element  Jugador4 = doc.createElement("Jugador" + Integer.toString(i+1));   // Crea un <futbolista> de doc 
                        Futbolista.appendChild(Jugador4);
                    }
                    else if(i == 8){
                        Element  Jugador5 = doc.createElement("Jugador" + Integer.toString(i+1));   // Crea un <futbolista> de doc 
                        Futbolista.appendChild(Jugador5);
                    }
                }else{ /* Entonces es Arquero */
                    if(i == 1){
                        Element ArJugador1 = doc.createElement("Arquero" + Integer.toString(i+1));  
                        Arquero.appendChild(ArJugador1);
                    }
                    else if(i == 3){
                        Element ArJugador2 = doc.createElement("Arquero" + Integer.toString(i+1));  
                        Arquero.appendChild(ArJugador2);
                    }
                    else if(i == 5){
                        Element ArJugador3 = doc.createElement("Arquero" + Integer.toString(i+1));  
                        Arquero.appendChild(ArJugador3);
                    }
                    else if(i == 7){
                        Element ArJugador4 = doc.createElement("Arquero" + Integer.toString(i+1));  
                        Arquero.appendChild(ArJugador4);
                    }
                    else if(i == 9){
                        Element ArJugador5 = doc.createElement("Arquero" + Integer.toString(i+1));  
                        Arquero.appendChild(ArJugador5);
                    }
                }
                
                 /*  Element  Jugador = doc.createElement("Jugador1");   // Crea un <futbolista> de doc 
                    Futbolista.appendChild(Jugador);
                  //  public void Gol(){
                        Element  Goles = doc.createElement("Goles");   // Crea un <futbolista> de doc 
                        Jugador.appendChild(Goles);
                   // }

                    Element Jugada = doc.createElement("Tipo_de_Jugada");   // Crea un <futbolista> de doc 
                    Jugador.appendChild(Jugada);

                    Element TimeJugada = doc.createElement("Realizada_en");   // Crea un <futbolista> de doc 
                    Jugada.appendChild(TimeJugada);

                    //------------------------ ARQUERO -------------------------

                    

                    Element ArJugador = doc.createElement("Arquero1");  
                    Arquero.appendChild(ArJugador);

                    Element tsinGoles = doc.createElement("Tiempo_sin_Goles");   // Crea un <futbolista> de doc 
                    Arquero.appendChild(tsinGoles);

                    Element ArJugada = doc.createElement("Habilidad_tapar");   // Crea un <futbolista> de doc 
                    tsinGoles.appendChild(ArJugada);

                    Element TimeArJugada = doc.createElement("Realizada_en");   // Crea un <futbolista> de doc 
                    ArJugada.appendChild(TimeArJugada);
                         */
                if(i == 9) {
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("d:\\asd.xml"));
                    transformer.transform(source, result);
                }   



            }
                } catch (ParserConfigurationException pce) {
                    pce.printStackTrace();
                } catch (TransformerException tfe) {
                    tfe.printStackTrace();
                }
        
    }
}



