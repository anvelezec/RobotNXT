package objetos.futbol.jugadores;

import objetos.futbol.varios.*;
import java.util.*;
import objetos.futbol.varios.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * la clase arquero administra el arquero del equipo
 * 
 * @author luisa
 *
 */
public class Arquero extends Futbolista {

	long time_start = System.currentTimeMillis();
	public int tiempoSinGoles;
	public byte dorsal;
	private long tiempoUltimoGol;

	/**
	 * consulta el numero del dorsal del arquero
	 * 
	 * @return
	 */
	public byte getDorsal() {
		return dorsal;
	}

	public int getTiempoSinGoles() {
		return tiempoSinGoles;
	}

	public void setTiempoSinGoles(int tiempoSinGoles) {
		this.tiempoSinGoles = tiempoSinGoles;
	}

	/**
	 * da el numero del dorsal al arquero
	 * 
	 * @param dorsal
	 */
	public void setDorsal(byte dorsal) {
		this.dorsal = dorsal;
	}

	/**
	 * contructor de la clase Arquero;
	 * 
	 * @param nombre
	 * @param posicion
	 * @param jugadasComplejas
	 * @param tiempoSinGoles
	 * @param dorsal
	 */
	public Arquero(String nombre, String posicion, ArrayList<JugadaCompleja> jugadasComplejas, int tiempoSinGoles,
			byte dorsal) {
		super(nombre, posicion, jugadasComplejas);
		this.tiempoSinGoles = 0;
		this.dorsal = dorsal;
		this.tiempoUltimoGol = 0;
	}

	/**
	 * @param nombre
	 *            Nombre del futbolista
	 * @param posicion
	 *            posicion del futbolista
	 * @param jugadasComplejas
	 *            jugadas complejas que puede realizar
	 * @param tiempoSinGoles
	 *            Tiempo sin goles del Arquero
	 * @param dorsal
	 *            Dorsal del Arquero
	 * @param imagen
	 *            imagen del Arquero
	 */
	public Arquero(String nombre, String posicion, ArrayList<JugadaCompleja> jugadasComplejas, int tiempoSinGoles,
			byte dorsal, String imagen) {
		super(nombre, posicion, jugadasComplejas, imagen);
		this.tiempoSinGoles = 0;
		this.dorsal = dorsal;
		this.tiempoUltimoGol = 0;

	}

	/**
	 * to tring que describe al arquero nombre del arquero,posicion, numero del
	 * dorsal y tiempo sin goles
	 */
	public String toString() {
		return ("El futbolista " + super.getNombre() + "juega de " + super.getPosicion() + "con el dorsal" + this.dorsal
				+ "tiempo sin goles " + this.tiempoSinGoles);

	}

	/**
	 * devuelve true si es arquero
	 */
	public boolean jugarConLasManos(Futbolista fut) {
		return (fut instanceof Arquero);
	}

	@Override
	public Element getXMLElement(Document doc) {
		Element arqueroXML = null;

		arqueroXML = doc.createElement("Arquero");

		Element tiempoSinGoles = doc.createElement("TiempoSinGoles");
		tiempoSinGoles.appendChild(doc.createTextNode(Integer.toString(this.tiempoSinGoles)));
		arqueroXML.appendChild(tiempoSinGoles);

		Element dorsal = doc.createElement("Dorsal");
		dorsal.appendChild(doc.createTextNode(Integer.toString(this.dorsal)));
		arqueroXML.appendChild(dorsal);

		Element nombrefutbolista = doc.createElement("Nombre");
		nombrefutbolista.appendChild(doc.createTextNode(this.getNombre()));
		arqueroXML.appendChild(nombrefutbolista);

		Element posicion = doc.createElement("Posicion");
		posicion.appendChild(doc.createTextNode(this.getPosicion()));
		arqueroXML.appendChild(posicion);

		Element imagen = doc.createElement("Imagen");
		imagen.appendChild(doc.createTextNode(this.getImagen()));
		arqueroXML.appendChild(imagen);

		Element listaJugadas = doc.createElement("ListaJugadas");
		for (int i = 0; i < this.getListaJugadas().size(); i++) {
			Element jugada = doc.createElement("Jugada");
			jugada.appendChild(doc.createTextNode(this.getListaJugadas().get(i)));
			listaJugadas.appendChild(jugada);
		}
		arqueroXML.appendChild(listaJugadas);

		Element jugadascomplejas = doc.createElement("JugadasComplejas");
		for (int i = 0; i < this.getJugadasComplejas().size(); i++) {
			// Element jugadacompleja = doc.createElement("JugadaCompleja");
			jugadascomplejas.appendChild(this.getJugadasComplejas().get(i).toXMLElement(doc));
			// jugadascomplejas.appendChild(jugadacompleja);
		}
		arqueroXML.appendChild(jugadascomplejas);

		return arqueroXML;
	}

	/**
	 * modifica el marcador de ambos equipos
	 */
	public void marcador() {
		CalcularTiempo calculoTiempo = new CalcularTiempo();
		this.tiempoSinGoles = (int) (calculoTiempo.calculoTiempo() - this.tiempoUltimoGol);
		this.tiempoUltimoGol = calculoTiempo.calculoTiempo();

	}

}
