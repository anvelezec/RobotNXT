package objetos.futbol.jugadores;

import java.util.*;
import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;

import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.robot.JugadaPrimitiva;

public abstract class JugadaCompleja {
	
	private String nombreJugada;
	private final String fechaCreacion;
	private final UsuarioAdministrador Autor;
	protected ArrayList<JugadaPrimitiva> jugadasPrimitivas;
	private String explicacion;


	/**
	 * constructor jugada compleja 
	 * @param nommbreJugada
	 * @param fechaCreacion
	 * @param autor
	 * @param explicacion
	 * @param jugadasPrimitivas
	 */
	public JugadaCompleja(String nommbreJugada, String fechaCreacion, UsuarioAdministrador autor, String explicacion,
			ArrayList<JugadaPrimitiva> jugadasPrimitivas) {
		this.nombreJugada = nommbreJugada;
		this.fechaCreacion = fechaCreacion;
		this.Autor = autor;
		this.explicacion = explicacion;

		this.jugadasPrimitivas = new ArrayList<JugadaPrimitiva>();
		this.jugadasPrimitivas = jugadasPrimitivas;
	}
	/**
	 * constructor jugada compleja sin argumentos
	 */
	public JugadaCompleja() {
		this.nombreJugada = null;
		this.fechaCreacion = null;
		this.Autor = null;
		this.explicacion = null;
		this.jugadasPrimitivas = null;
		this.jugadasPrimitivas = null;
	}

	/**
	 * constructor jugada compleja
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param autor
	 * @param jugadasPrimitivas
	 * @param explicacion
	 */
	public JugadaCompleja(String nombreJugada, String fechaCreacion, UsuarioAdministrador autor,
			ArrayList<JugadaPrimitiva> jugadasPrimitivas, String explicacion) {
		super();
		this.nombreJugada = nombreJugada;
		this.fechaCreacion = fechaCreacion;
		Autor = autor;
		this.jugadasPrimitivas = jugadasPrimitivas;
		this.explicacion = explicacion;
	}

	/**
	 * consulta las jugadas primitivas del array de jugada compleja
	 * @return
	 */
	public ArrayList<JugadaPrimitiva> getJugadasPrimitivas() {
		return jugadasPrimitivas;
	}
	
	public JugadaPrimitiva getJugadaPrimitiva(int i) {
		return jugadasPrimitivas.get(i);
	}

	/** 
	 * agregamos un array de jugadas primitivas a una jugada compleja
	 * @param jugadasPrimitivas
	 */
	public void setJugadasPrimitivas(ArrayList<JugadaPrimitiva> jugadasPrimitivas) {
		this.jugadasPrimitivas = jugadasPrimitivas;
	}

	/**
	 *  metodo toString para imprimir el nombre de la jugada
	 */
	public String toString() {
		return "Jugada: " + this.nombreJugada;
	}

	/**
	 * consulta el nombre de la jugada compleja
	 * @return
	 */
	public String getNombreJugada() {
		return nombreJugada;
	}

	/**
	 * da nombre a la jugada compleja
	 * @param NombreJugada
	 */
	public void setNombreJugada(String NombreJugada) {
		this.nombreJugada = NombreJugada;
	}

	/**
	 * consulta la explicacion de la jugada compleja
	 * @return
	 */
	public String getExplicacion() {
		return explicacion;
	}

	/**
	 * agrega la explicacion de la jugada compleja 
	 * @param explicacion
	 */
	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	/**
	 * consulta la fecha de creacion de la jugada compleja
	 * @return
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * consulta el autor que hizo las jugadas complejas
	 * @return
	 */
	public UsuarioAdministrador getAutor() {
		return Autor;
	}

	/**
	 * metodo para determinar si dos jugadas complejas son iguales (tiene
	 * elmismo orden de jugadas primitivas)
	 * 
	 * @param jugada1
	 * @param jugada2
	 * @return true si las jugadas son iguales
	 */
	public boolean CompararJugadas(JugadaCompleja jugada1, JugadaCompleja jugada2) {
		int contador = 0;
		if (jugada1.getJugadasPrimitivas().size() != jugada2.getJugadasPrimitivas().size()) {
			return false;
		} else {
			for (int i = 0; i < jugada1.getJugadasPrimitivas().size(); i++) {
				if (jugada1.getJugadasPrimitivas().get(i) == jugada2.getJugadasPrimitivas().get(i)) {
					contador = contador + 1;
				}
			}
		}
		if (contador == jugada1.getJugadasPrimitivas().size()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * agrega la jugada complja al archivo XML
	 * @param document
	 * @return
	 */
	public abstract Element toXMLElement(Document document);

	/**
	 * metodo abtract para identificar que tipo de jugada es.
	 * @param jugada
	 * @return
	 */
	public abstract String IdentificarJugada(JugadaCompleja jugada);
	
	/**
	 * lee el array de jugadas primitivas para ejecutarlas
	 */
	public void ejecutarJugadaCompleja(){
		for (int j = 0; j < jugadasPrimitivas.size(); j++) {
			jugadasPrimitivas.get(j).ejecutar();
		}
	}

}
