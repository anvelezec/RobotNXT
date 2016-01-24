package objetos.futbol.jugadores;

import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.robot.JugadaPrimitiva;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JugadaComplejaDefensiva extends JugadaCompleja {
	
	private int atributo1, atributo2; 

	/**
	 * obtenemos el atributo 1
	 * @return
	 */
	public int getAtributo1() {
		return atributo1;
	}

	/**
	 * damos valor al atributo
	 * @param atributo1
	 */
	public void setAtributo1(int atributo1) {
		this.atributo1 = atributo1;
	}

	/**
	 * consulta el atributo 1
	 * @return
	 */
	public int getAtributo2() {
		return atributo2;
	}

	/**
	 * dar valor al atributo 2
	 * @param atributo2
	 */
	public void setAtributo2(int atributo2) {
		this.atributo2 = atributo2;
	}

	/**
	 * constructor de jugada compleja defensiva
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param autor
	 * @param explicacion
	 * @param jugadasPrimitivas
	 */
	public JugadaComplejaDefensiva(String nombreJugada, String fechaCreacion, UsuarioAdministrador autor,
			String explicacion, ArrayList<JugadaPrimitiva> jugadasPrimitivas) {
		super(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas);

	}


	@Override
	public String IdentificarJugada(JugadaCompleja jugada) {
		return "Jugada defensiva";
	}

	/**
	 *  agregan una jugada primitiva al array de jugada compleja
	 * @param Agregarnum
	 */
	public void agregar(JugadaPrimitiva Agregarnum) {
		if (jugadasPrimitivas.contains(Agregarnum)) {
		} else {
			jugadasPrimitivas.add(Agregarnum);
		}
	}

	/**
	 * quitar una jugada primitiva al array de jugada compleja
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
		jugadaComplejaXML = doc.createElement("JugadaComplejaDefensiva");

		Element nombreJugada = doc.createElement("NombreJugada");
		nombreJugada.appendChild(doc.createTextNode(this.getNombreJugada()));
		jugadaComplejaXML.appendChild(nombreJugada);

		Element fechaCreacion = doc.createElement("FechaCreacion");
		fechaCreacion.appendChild(doc.createTextNode(this.getFechaCreacion()));
		jugadaComplejaXML.appendChild(fechaCreacion);

		Element autor = doc.createElement("Autor");
		autor.appendChild(doc.createTextNode(this.getAutor().getNombre()));
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
