package objetos.futbol.robot;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import lejos.geom.Point;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.*;

/**
 * clase para administrar el robot, desde posicion y jugador
 * 
 * @author luisa
 *
 */
public class Robot {
	/**
	 * constructor robot
	 * 
	 * @param posicionRelativa
	 * @param jugador
	 * @param conexionBT
	 */
	public Robot(Point posicionRelativa, Futbolista jugador, String conexionBT) {
		super();
		this.posicionRelativa = posicionRelativa;
		this.jugador = jugador;
		this.conexionBT = conexionBT;
		this.angulo=0;
	}

	/**
	 * contructor sin argumentos
	 */
	public Robot() {

	}

	private Point posicionRelativa;
	private Futbolista jugador;
	private String conexionBT;
	private float angulo;

	/**
	 * consultar la posicion relativa del robot
	 * 
	 * @return
	 */
	public Point getPosicionRelativa() {
		return posicionRelativa;
	}

	/**
	 * modificar la posicion relativa del robot
	 * 
	 * @param posicionRelativa
	 */
	public void setPosicionRelativa(Point posicionRelativa) {
		this.posicionRelativa = posicionRelativa;
	}

	/**
	 * consultar el jugador que el robot tiene agregado
	 * 
	 * @return
	 */
	public Futbolista getJugador() {
		return jugador;
	}

	/**
	 * agregarle al robot un jugador
	 * 
	 * @param jugador
	 */
	public void setJugador(Futbolista jugador) {
		this.jugador = jugador;
	}

	/**
	 * consultar el string de la conexion bluetooth del robot
	 * 
	 * @return
	 */
	public String getConexionBT() {
		return conexionBT;
	}

	/**
	 * darle nombre a la conexion bluetooth con el robot
	 * 
	 * @param conexionBT
	 */
	public void setConexionBT(String conexionBT) {
		this.conexionBT = conexionBT;
	}

	/**
	 * configurar la conexion bluetooth
	 * 
	 */
	public void configurarConexion() {
		JugadaPrimitiva.configurarConexion(this.conexionBT);
	}

	public void ejecutarJugadaComplejaRobot(int i) {

		for (int j = 0; j < this.jugador.getJugadaCompleja(i).getJugadasPrimitivas().size(); j++) {
			this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(j).ejecutar();
			this.jugador.setListaJugadas(this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(i).informativo());
			if (this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(j).getTipo() == 2) {
				this.angulo = this.angulo + 90;
				if (this.angulo > 360) {
					this.angulo = 0;
				}
			} else if (this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(j).getTipo() == 3) {
				this.angulo = this.angulo - 90;
				if (this.angulo < -360) {
					this.angulo = 0;
				}
			} else if (this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(j).getTipo() == 1) {
				int valor = this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(j).getValor();
				this.posicionRelativa = this.posicionRelativa.pointAt(valor, this.angulo);

			} else if (this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(j).getTipo() == 4) {
				int valor = this.jugador.getJugadaCompleja(i).getJugadaPrimitiva(j).getValor();
				this.posicionRelativa = this.posicionRelativa.pointAt(valor, this.angulo);
			}
		}
	}

	public void moverAdelante() {
		this.jugador.moverAdelante(50);
		this.jugador.setListaJugadas("Mover Adelante");
		this.posicionRelativa = this.posicionRelativa.pointAt(20, this.angulo);

	}

	public void moverAtras() {
		this.jugador.moverAtras(50);
		this.jugador.setListaJugadas("Mover atras");
		this.posicionRelativa = this.posicionRelativa.pointAt(-20, this.angulo);

	}

	public void girarD() {
		this.jugador.girarD(0);
		this.jugador.setListaJugadas("Girar Derecha");
		this.angulo = this.angulo + 90;
		if (this.angulo > 360) {
			this.angulo = 0;
		}

	}

	public void girarI() {
		this.jugador.girarI(0);
		this.jugador.setListaJugadas("Girar Izquierda");
		this.angulo = this.angulo - 90;
		if (this.angulo < -360) {
			this.angulo = 0;
		}

	}

	public void chutar() {
		this.jugador.chutar();
		this.jugador.setListaJugadas("Chute");
	}

	/**
	 * consultar el XML de la descripcion del robot
	 * 
	 * @param doc:
	 *            Documento a escribir XML
	 * @param robot:
	 *            Robot instanciado
	 * @return
	 */
	public Element getRobotXML(Document doc) {

		Element robotXML = null;
		robotXML = doc.createElement("Robot");

		// Element futbolistas = doc.createElement("Futbolistas");

		if (this.jugador instanceof Delantero) {

			Element delantero = doc.createElement("Delantero");
			delantero.appendChild(this.jugador.getXMLElement(doc));
			robotXML.appendChild(delantero);

		} else if (this.jugador instanceof Arquero) {

			Element arquero = doc.createElement("Arquero");
			arquero.appendChild(this.jugador.getXMLElement(doc));
			robotXML.appendChild(arquero);
		}

		Element coneccionBluetooth = doc.createElement("ConeccionBluetooth");
		coneccionBluetooth.appendChild(doc.createTextNode(getConexionBT()));
		robotXML.appendChild(coneccionBluetooth);

		Element posicionRelativa = doc.createElement("PosicionRelativa");

		Element x = doc.createElement("X");
		x.appendChild(doc.createTextNode(Double.toString(this.posicionRelativa.getX())));
		posicionRelativa.appendChild(x);

		Element y = doc.createElement("Y");
		y.appendChild(doc.createTextNode(Double.toString(this.posicionRelativa.getY())));
		posicionRelativa.appendChild(y);

		robotXML.appendChild(posicionRelativa);

		return robotXML;
	}

}
