package objetos.futbol.jugadores;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.robot.JugadaPrimitiva;

/**
 * clase para administrar las jugadas complejas ofensivas 
 * @author luisa
 *
 */
public class JugadaComplejaOfensiva extends JugadaCompleja {

		private int numerosAgregar, numerosquitar;

		/**
		 * obtener el numero de jugada primitiva a agregar
		 * @return
		 */
	public int getNumerosAgregar() {
		return numerosAgregar;
	}

	/**
	 * Dar valor a numero a agregar al array de jugada compleja ofensiva
	 * @param numerosAgregar
	 */
	public void setNumerosAgregar(int numerosAgregar) {
		this.numerosAgregar = numerosAgregar;
	}

	/**
	 * consulta numero a quitar del array de jugadas primitivas
	 * @return
	 */
	public int getNumerosquitar() {
		return numerosquitar;
	}

	/**
	 * dar valor al numero a quitar del array de jugadas primitivas
	 * @param numerosquitar
	 */
	public void setNumerosquitar(int numerosquitar) {
		this.numerosquitar = numerosquitar;
	}

	/**
	 * constructor jugada compleja ofensiva
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param autor
	 * @param explicacion
	 * @param jugadasPrimitivas
	 */
	public JugadaComplejaOfensiva(String nombreJugada, String fechaCreacion, UsuarioAdministrador autor,
			String explicacion, ArrayList<JugadaPrimitiva> jugadasPrimitivas) {
		super(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas);
	}

	
	@Override
	public String IdentificarJugada(JugadaCompleja jugada) {
		return "Jugada ofensiva";
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

				jugadaComplejaXML = doc.createElement("JugadaComplejaOfensiva");

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
