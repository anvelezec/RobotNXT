package objetos.futbol.cancha;

import java.util.ArrayList;
import java.util.List;
import lejos.geom.Point;
import lejos.geom.Rectangle;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.ListarJugadasComplejas;
import objetos.futbol.jugadores.*;
import objetos.futbol.robot.Robot;
import objetos.futbol.varios.CalcularTiempo;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
/**
 * clase para dibujar la cancha
 * @author luisa
 *
 */
public class Cancha {
	private static final Rectangle estadio = new Rectangle(0, 0, 2430, 1820);
	private static final Rectangle cancha = new Rectangle(300, 300, 1830, 1220);
	private static final Rectangle zonaArqueroIzquierdo = new Rectangle(300, 300 + 385, 450, 450);
	private static final Rectangle zonaJuego = new Rectangle(300 + 450, 300 + 385, 930, 450);
	private static final Rectangle arcoIzquierdo = new Rectangle(300 - 80, 300 + 385, 80, 450);
	private static final Rectangle zonaArqueroDerecha = new Rectangle(300 + 450 + 930, 300 + 385, 450, 450);
	private static final Rectangle arcoDerecha = new Rectangle(300 + 1830 + 80, 300 + 385, 80, 450);
	private static ArrayList<Robot> robots;
	private int marcadorEquipo;
	private int marcadorEnemigo;
	private CalcularTiempo tiempo;
	/**
	 * constructor para cancha sin argumentos
	 */
	public Cancha(){
		robots=new ArrayList<Robot>();
		marcadorEnemigo=0;
		marcadorEquipo=0;
	}
	
	/**
	 * constructor para cancha con argumentos
	 * @param marcadorEquipo
	 * @param marcadorEnemigo
	 * @param listaRobots
	 */
	public Cancha(int marcadorEquipo, int marcadorEnemigo, ArrayList<Robot> listaRobots){
		this.marcadorEquipo = marcadorEquipo;
		robots = listaRobots;
		this.marcadorEnemigo = marcadorEnemigo;
	}

	/**
	 * consulta el marcador del propio equipo
	 * @return
	 */
	public int getMarcadorEquipo() {
		return marcadorEquipo;
	}

	/**
	 * agregar un camio en el marcador del propio equipo 
	 * @param marcadorEquipo
	 */
	public void setMarcadorEquipo(int marcadorEquipo) {
		this.marcadorEquipo = marcadorEquipo;
	}
	/**
	 * consulta el marcador del equipo contrario
	 * @return
	 */
	public int getMarcadorEnemigo() {
		return marcadorEnemigo;
	}

	/**
	 * cambia el marcador del equipo contrario
	 * @param marcadorEnemigo
	 */
	public void setMarcadorEnemigo(int marcadorEnemigo) {
		this.marcadorEnemigo = marcadorEnemigo;
	}

	/**
	 * consulta el tiempo transcurido en el partido
	 * @return
	 */
	public CalcularTiempo getTiempo() {
		return tiempo;
	}

	/**
	 * asigna valor al tiempo del partido
	 * @param tiempo
	 */
	public void setTiempo(CalcularTiempo tiempo) {
		this.tiempo = tiempo;
	}

	private static final Point posicionInicialArquero = new Point(300, 300);
	private static final Point posicionInicialDelantero = new Point(300, 300 + 1220);

	/**
	 * consulta el tamaño del estadio
	 * @return
	 */
	public static Rectangle getEstadio() {
		return estadio;
	}

	/**
	 * consulta el tamaño de la cancha
	 * @return
	 */
	public static Rectangle getCancha() {
		return cancha;
	}

	/**
	 * consulta la zona limite del arquero izquierdo
	 * @return
	 */
	public static Rectangle getZonaarqueroizquierdo() {
		return zonaArqueroIzquierdo;
	}

	/**
	 * consulta la zona delimitada para el juego
	 * @return
	 */
	public static Rectangle getZonajuego() {
		return zonaJuego;
	}

	/**
	 * consulta el tamaño del arco izquierdo
	 * @return
	 */
	public static Rectangle getArcoizquierdo() {
		return arcoIzquierdo;
	}

	/**
	 * constula la zona limite para el arquero derecho
	 * @return
	 */
	public static Rectangle getZonaarqueroderecha() {
		return zonaArqueroDerecha;
	}

	/**
	 * constula la zona limite del arco derecho
	 * @return
	 */
	public static Rectangle getArcoderecha() {
		return arcoDerecha;
	}

	/**
	 * constula la lista de roots configurados con el sistema
	 * @return
	 */
	public static List<Robot> getRobots() {
		return robots;
	}

	/**
	 * se configura un robot con el sistema
	 * @param robots
	 */
	public void setRobots(ArrayList<Robot> robots) {
		this.robots = robots;
	}

	/**
	 * cambia el marcador del propio equipo o el contrario
	 * @param robot
	 */
	public void marcador(Robot robot) {
		if (robot.getJugador() instanceof Arquero) {
			robot.getJugador().marcador();
		} else if (robot.getJugador() instanceof Delantero) {
			robot.getJugador().marcador();
		}
	}

	/**
	 * Encontrar la posicion absoluta
	 * @param robot
	 * @return
	 */
	
	public Point posicionAbsoluta(Robot robot) {
		Point posicionAbsoluta = null;
		Futbolista futbolista = robot.getJugador();
		if (futbolista.jugarConLasManos(futbolista)) {
			posicionAbsoluta = calcularPosicionAbsolutaArquero(robot);
		} else {
			posicionAbsoluta = calcularPosicionAbsolutaDelantero(robot);
		}

		return posicionAbsoluta;
	}
	
	/**
	 * delimita la zona limete del robot 
	 * @param robot
	 * @return
	 */
	public Rectangle robotLimite(Robot robot) {
		Rectangle robotLimite = null;
		if (robot.getJugador().jugarConLasManos(robot.getJugador())) {
			robotLimite = zonaArqueroIzquierdo;
		} else {
			robotLimite = cancha;
		}
		return robotLimite;
	}

	/**
	 * devuelve true si el robot excdio sus limites en la zona de juego
	 * @param robot
	 * @return
	 */
	public boolean robotExedeLimites(Robot robot) {
		Rectangle robotLimite = robotLimite(robot);
		if (!robotLimite.contains(posicionAbsoluta(robot))) {
			return true;
		}
		return false;
	}
	
	/**
	 * manda una excepcion si el robot excedi los limites
	 * @param robot
	 * @throws Exception
	 */
	public void alertarRobotLimites(Robot robot) throws Exception {
		if (robotExedeLimites(robot)) {
			throw new Exception("El robot sobrepaso sus limites");
		}
	}
	
	/**
	 * Encontrar la posicion absoluta del arquero en base su posicion inicial
	 * @param robot
	 * @return
	 */
	 
	public Point calcularPosicionAbsolutaArquero(Robot robot) {
		Point posicionAbsoluta = null;
		posicionAbsoluta = posicionInicialArquero;
		posicionAbsoluta = posicionAbsoluta.add(robot.getPosicionRelativa());
		return posicionAbsoluta;
	}

	/**
	 *Encontrar la posicion absoluta del delantero en base su posicion inicial
	 * @param robot
	 * @return
	 */
	
	public Point calcularPosicionAbsolutaDelantero(Robot robot) {
		Point posicionAbsoluta = posicionInicialDelantero;
		posicionAbsoluta = posicionAbsoluta.add(robot.getPosicionRelativa());
		return posicionAbsoluta;
	}


	/**
	 * Escribir Cancha en XML
	 * @param doc
	 * @return
	 */
	public Element getXMLElement(Document doc) {
		Element canchaXML = null;

		canchaXML = doc.createElement("Cancha");
		

		Element elementoMarcadorEquipo = doc.createElement("MarcadorEquipo");
		elementoMarcadorEquipo.appendChild(doc.createTextNode(Integer.toString(this.marcadorEquipo)));
		canchaXML.appendChild(elementoMarcadorEquipo);

		Element elementoMarcadorEnemigo = doc.createElement("MarcadorEnemigo");
		elementoMarcadorEnemigo.appendChild(doc.createTextNode(Integer.toString(this.marcadorEnemigo)));
		canchaXML.appendChild(elementoMarcadorEnemigo);

		Element robots = doc.createElement("Robots");
		for (int i = 0; i < this.getRobots().size(); i++) {

			Element robotE = this.getRobots().get(i).getRobotXML(doc);
			robots.appendChild(robotE);

		}
		canchaXML.appendChild(robots);
		
		return canchaXML;
	}

	/**
	 * inicia el tiempo de partida
	 */
	public void iniciarPartido() {
		tiempo.agregarTiempoInicial();
	}

	/**
	 * pausa el tiempo del partido
	 */
	public void pausarPartido() {
		if(tiempo.getsizeTimeStart()-1==tiempo.getsizeTimeEnd()){
		tiempo.agregarTiempoFinal();
		}
	}
	
	/*
	 * reauna el tiempo del partido
	 */
	public void reanudarPartido() {
		if(tiempo.getsizeTimeEnd()==tiempo.getsizeTimeStart()){
		tiempo.agregarTiempoInicial();
		}
	}

	/**
	 * finaliza el tiempo del partido
	 */
	public void finalizarPartido() {
		if(tiempo.getsizeTimeStart()-1==tiempo.getsizeTimeEnd()){
		tiempo.agregarTiempoFinal();
		}
	}
	
	/**
	 * ejecuta una jugada compleja en el robot
	 * @param robot
	 * @param indiceJugadaCompleja
	 */
	public void ejecutarJugadaRobot(Robot robot, int indiceJugadaCompleja) {
		robot.configurarConexion();
	//	robot.getJugador().ejecutarJugadaCompleja(indiceJugadaCompleja);
		robot.ejecutarJugadaComplejaRobot(indiceJugadaCompleja);
	}

}
