package objetos.futbol.jugadores;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * clase que administra los jugadores delanteros
 * @author luisa
 *
 */
public  class Delantero extends Futbolista{

	
	public int getGolesMarcados() {
		return golesMarcados;
	}

	public void setGolesMarcados(int golesMarcados) {
		this.golesMarcados = golesMarcados;
	}

	public byte getDorsal() {
		return dorsal;
	}

	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}

	public int golesMarcados;
	public byte dorsal;

	/**
	 * contructor de la clase Delantero;
	 * @param nombre
	 * @param posicion
	 * @param jugadasComplejas
	 * @param golesMarcados
	 * @param dorsal
	 */
	public Delantero(String nombre, String posicion,ArrayList<JugadaCompleja> jugadasComplejas,short golesMarcados,byte dorsal){
		super(nombre,posicion,jugadasComplejas);
		this.golesMarcados=golesMarcados;
		this.dorsal=dorsal;
	}

	/**
	 * 
	 * @param nombre
	 * @param posicion
	 * @param jugadasComplejas
	 * @param golesMarcados
	 * @param dorsal
	 */
	public Delantero(String nombre, String posicion,ArrayList<JugadaCompleja> jugadasComplejas,short golesMarcados,byte dorsal,String imagen){
		super(nombre,posicion,jugadasComplejas, imagen);
		this.golesMarcados=golesMarcados;
		this.dorsal=dorsal;
	}
	
	/**
	 * Metodo tostring describe al delantero nobre de jugador, posicion, numero de dorsal y cantidad de goles marcados
	 */
	public String toString() {
		return("El futbolista "+ super.getNombre()+ "juega de "+super.getPosicion()+"con el dorsal"
		+this.dorsal+"ha marcado "+this.golesMarcados);
	}

	/**
	 * Metodo jugar con las manos devuelve true si es arquero
	 */
	public boolean jugarConLasManos(Futbolista fut){
		return(fut instanceof Arquero);
	}
	
	@Override
	public Element getXMLElement(Document doc) {
		Element delanteroXML = null;

		delanteroXML = doc.createElement("Delantero");
		
		Element golesMarcados = doc.createElement("GolesMArcados");
		golesMarcados.appendChild(doc.createTextNode(Integer.toString(this.golesMarcados)));
		delanteroXML.appendChild(golesMarcados);

		Element dorsal = doc.createElement("Dorsal");
		dorsal.appendChild(doc.createTextNode(Integer.toString(this.dorsal)));
		delanteroXML.appendChild(dorsal);

		Element nombrefutbolista = doc.createElement("Nombre");
		nombrefutbolista.appendChild(doc.createTextNode(this.getNombre()));
		delanteroXML.appendChild(nombrefutbolista);

		Element posicion = doc.createElement("Posicion");
		posicion.appendChild(doc.createTextNode(this.getPosicion()));
		delanteroXML.appendChild(posicion);

		Element imagen = doc.createElement("Imagen");
		imagen.appendChild(doc.createTextNode(this.getImagen()));
		delanteroXML.appendChild(imagen);
		
		Element listaJugadas = doc.createElement("ListaJugadas");
		for (int i = 0; i < this.getListaJugadas().size(); i++) {
			Element jugada = doc.createElement("Jugada");
			jugada.appendChild(doc.createTextNode(this.getListaJugadas().get(i)));
			listaJugadas.appendChild(jugada);
		}
		delanteroXML.appendChild(listaJugadas);

		Element jugadascomplejas = doc.createElement("JugadasComplejas");
		for (int i = 0; i < this.getJugadasComplejas().size(); i++) {
			//Element jugadacompleja = doc.createElement("JugadaCompleja");
			jugadascomplejas.appendChild(this.getJugadasComplejas().get(i).toXMLElement(doc));
			//jugadascomplejas.appendChild(jugadacompleja);
		}
		delanteroXML.appendChild(jugadascomplejas);

		return delanteroXML;
	}

	/**
	 * adiciona los goles marcados por el delantero
	 */
	public void marcador() {
		this.golesMarcados = golesMarcados + 1;
	}

	

}