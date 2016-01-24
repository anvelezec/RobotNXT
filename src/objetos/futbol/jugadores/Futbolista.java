package objetos.futbol.jugadores;

import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.robot.JugadaPrimitiva;

/**
 * clase que administra los jugadores del equipo
 * 
 * @author luisa
 *
 */
public abstract class Futbolista {

	private String nombre;
	private final String posicion;
	private ArrayList<JugadaCompleja> jugadasComplejas = new ArrayList<JugadaCompleja>();
	private ArrayList<String> listaJugadas = new ArrayList<String>();
	private int golesMarcador;
	private String imagen;

	/**
	 * constructor
	 * 
	 * @param nombre Nombre del futbolista
	 * @param posicion posicion del futbolista
	 * @param jugadasComplejas jugadas complejas que puede realizar
	 */
	public Futbolista(String nombre, String posicion, ArrayList<JugadaCompleja> jugadasComplejas) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.jugadasComplejas = jugadasComplejas;
		this.listaJugadas = new ArrayList<String>();
		this.imagen="";
	}

	
	/**
	 * 
	 * @param nombre Nombre del futbolista
	 * @param posicion posicion del futbolista
	 * @param jugadasComplejas jugadas complejas que puede realizar
	 * @param imagen imagen del futbolista
	 */
	public Futbolista(String nombre, String posicion, ArrayList<JugadaCompleja> jugadasComplejas,String imagen) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.jugadasComplejas = jugadasComplejas;
		this.listaJugadas = new ArrayList<String>();
		this.imagen=imagen;
	}
	/**
	 * consultar el nombre del futbolista
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * dar nombre al futbolista
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * consultar el array de jugada compleja del futbolista
	 * 
	 * @return
	 */
	public ArrayList<JugadaCompleja> getJugadasComplejas() {
		return jugadasComplejas;
	}

	/**
	 * 
	 * @param i:
	 *            indice jugada compleja a retornar
	 * @return i-esima jugada compleja
	 */
	public JugadaCompleja getJugadaCompleja(int i) {
		return jugadasComplejas.get(i);
	}

	/**
	 * 
	 * @param jugada:
	 *            Jugada compleja a agregar
	 */
	public void setJugadaCompleja(JugadaCompleja jugada) {
		jugadasComplejas.add(jugada);
	}

	/**
	 * dar un array de jugadas complejas
	 * 
	 * @param jugadasComplejas
	 */
	public void setJugadasComplejas(ArrayList<JugadaCompleja> jugadasComplejas) {
		this.jugadasComplejas = jugadasComplejas;
	}

	/**
	 * consultar la lista de jugadas complejas que contiene el futbolista
	 * 
	 * @return
	 */
	public ArrayList<String> getListaJugadas() {
		return listaJugadas;
	}

	/**
	 * 
	 * @param i indice i-esima jugada realizada
	 * @return i-esima jugada realizada
	 */
	public String getListaJugadas(int i) {
		return listaJugadas.get(i);
	}
	
	/**
	 * ingresar una lista de jugadas ocmplejas al futbolist
	 * 
	 * @param listaJugadas
	 */
	public void setListaJugadas(ArrayList<String> listaJugadas) {
		listaJugadas = listaJugadas;
	}

	/**
	 * 
	 * @param listaJugadas: Jugada realizada
	 */
	public void setListaJugadas(String listaJugadas) {
		this.listaJugadas.add(listaJugadas);
	}
	
	/**
	 * consult la posicion en la que juga el futbolista
	 * 
	 * @return
	 */
	public String getPosicion() {
		return posicion;
	}

	/**
	 * to string que describe el nombre y la posicion del futbolista
	 */
	public String toString() {
		return "El futbolista " + nombre + " juega de " + posicion;
	}

	/**
	 * devuelve true si dos futbolistas son iguales
	 * 
	 * @param f
	 * @return
	 */
	public boolean soniguales(Futbolista f) {
		return f.equals(this);
	}

	
	/**
	 * 
	 * @return Direccion imagen del jugador
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * 
	 * @param imagen Direccion de la imagen de un jugador
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public abstract void marcador();

	public abstract boolean jugarConLasManos(Futbolista fut);

	public abstract Element getXMLElement(Document doc);

	public void ejecutarJugadaCompleja(int i) {
		jugadasComplejas.get(i).ejecutarJugadaCompleja();
	}

	public void moverAdelante(int valor) {
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva();
		jugadaPrimitiva.setConexionBT(Juego.getRobot().getConexionBT());
		jugadaPrimitiva.setTipo(1);
		jugadaPrimitiva.setvalor(valor);
		jugadaPrimitiva.ejecutar();
	}

	public void moverAtras(int valor) {
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva();
		jugadaPrimitiva.setConexionBT(Juego.getRobot().getConexionBT());
		jugadaPrimitiva.setTipo(4);
		jugadaPrimitiva.setvalor(valor);
		jugadaPrimitiva.ejecutar();
	}

	public void girarD(int valor) {
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva();
		jugadaPrimitiva.setConexionBT(Juego.getRobot().getConexionBT());
		jugadaPrimitiva.setTipo(3);
		jugadaPrimitiva.setvalor(valor);
		jugadaPrimitiva.ejecutar();
	}

	public void girarI(int valor) {
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva();
		jugadaPrimitiva.setConexionBT(Juego.getRobot().getConexionBT());
		jugadaPrimitiva.setTipo(2);
		jugadaPrimitiva.setvalor(valor);
		jugadaPrimitiva.ejecutar();
	}

	public void chutar() {
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva();
		jugadaPrimitiva.setConexionBT(Juego.getRobot().getConexionBT());
		jugadaPrimitiva.setTipo(5);
		jugadaPrimitiva.setvalor(0);
		jugadaPrimitiva.ejecutar();
	}
}
