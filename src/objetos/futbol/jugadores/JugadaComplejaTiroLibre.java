package objetos.futbol.jugadores;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.robot.JugadaPrimitiva;

/**
 * clase para administrar las jugadas complejas de tiro libre
 * @author luisa
 *
 */
public class JugadaComplejaTiroLibre extends JugadaCompleja {

	
	private int Agregarnumero, Quitarnumero;

	/**
	 * consultar un numero para al array de jugadas compleja
	 * @return
	 */
	public int getAgregarnumero() {
		return Agregarnumero;
	}

	/**
	 * dar el valor del numeroa agregar al array de jugadas primitivas 
	 * @param agregarnumero
	 */
	public void setAgregarnumero(int agregarnumero) {
		Agregarnumero = agregarnumero;
	}

	/**
	 * consultar numero a quitar del array de jugadas primitivas
	 * @return
	 */
	public int getQuitarnumero() {
		return Quitarnumero;
	}

	/**
	 * dar valor al numero a quitar del array de la jugada compleja
	 * @param quitarnumero
	 */
	public void setQuitarnumero(int quitarnumero) {
		Quitarnumero = quitarnumero;
	}

	/**
	 * contructor jugada compleja tiro libre
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param autor
	 * @param explicacion
	 * @param jugadasPrimitivas
	 */
	public JugadaComplejaTiroLibre(String nombreJugada, String fechaCreacion, UsuarioAdministrador autor,
			String explicacion, ArrayList<JugadaPrimitiva> jugadasPrimitivas) {
		super(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas);
	}

	
	@Override
	public String IdentificarJugada(JugadaCompleja jugada) {
		return "Jugada tiro libre";
	}

	/**
	 *  agregan una jugada primitva al array de jugada compleja
	 * @param Agregarnum
	 */
	public void agregar(JugadaPrimitiva Agregarnum) {
		if (jugadasPrimitivas.contains(Agregarnum)) {
		} else {
			jugadasPrimitivas.add(Agregarnum);
		}
	}

	/**
	 * quitan una jugada primitva al array de jugada compleja
	 * @param quitarnum
	 */
	public void quitar(JugadaPrimitiva quitarnum) {
		if (jugadasPrimitivas.contains(quitarnum)) {
			jugadasPrimitivas.remove(quitarnum);
		}
	}

	@Override
	public Element toXMLElement(Document doc) {
		// TODO Auto-generated method stub
				Element jugadaComplejaXML = null;

				jugadaComplejaXML = doc.createElement("JugadaComplejaTiroLibre");

				Element nombreJugada = doc.createElement("NombreJugada");
				nombreJugada.appendChild(doc.createTextNode(this.getNombreJugada()));
				jugadaComplejaXML.appendChild(nombreJugada);

				Element fechaCreacion = doc.createElement("FechaCreacion");
				fechaCreacion.appendChild(doc.createTextNode(this.getFechaCreacion()));
				jugadaComplejaXML.appendChild(fechaCreacion);

				Element autor = doc.createElement("Autor");
				// TODO:autor.appendChild(doc.createTextNode(jugadaCompleja.getAutor()));
				jugadaComplejaXML.appendChild(autor);

				Element explicacion = doc.createElement("Explicacion");
				explicacion.appendChild(doc.createTextNode(this.getExplicacion()));
				jugadaComplejaXML.appendChild(explicacion);

				Element jugadasPrimitivas = doc.createElement("JugadasPrimitivas");
				for (int i = 0; i < this.getJugadasPrimitivas().size(); i++) {
					Element jugadaPrimitiva = this.getJugadasPrimitivas().get(i).getXMLElment(doc);
					jugadasPrimitivas.appendChild(jugadaPrimitiva);
				}

				jugadaComplejaXML.appendChild(jugadasPrimitivas);

				return jugadaComplejaXML;
	}
}
