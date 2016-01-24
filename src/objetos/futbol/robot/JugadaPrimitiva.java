package objetos.futbol.robot;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;
import objetos.futbol.UI.opciones.main.cancha.Juego;

/**
 *  Definiendo el metodo jugada primitiva el cual
 *  me ingresa como parametro el numeor correspondiente a una jugada a realizar
 * dentro del metodo se establece la conexion bluetooth con el robot y envia el numero
 * de la jugada pertienete.
 */

 
public class JugadaPrimitiva {
	private static String conexionBT;
	public static boolean debug = true;
	private int tipo;
	private int valor;
	private boolean correcto = false;

	
	
	public static String getConexionBT() {
		return conexionBT;
	}

	public static void setConexionBT(String conexionBT) {
		JugadaPrimitiva.conexionBT = conexionBT;
	}

	/**
	 * consultar el tipo de jugada primitiva
	 * @return
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * dar valor al tipo de jugada primitiva 
	 * @param tipo
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;

	}

	/**
	 * consultar el valor a ijntroducir a las jugadas primitivas
	 * @return
	 */
	public int getValor() {
		return valor;
	}

	/** 
	 * darle valor a al argumento de jugada primitiva
	 * @param valor
	 */
	public void setvalor(int valor) {
		this.valor = valor;

	}

	/**
	 *  constructor jugada primitiva sin argumentos
	 */
	public JugadaPrimitiva() {
		this.tipo = -1;
		this.valor = -1;
	}

	/**
	 * constructor de jugadas primitivas
	 * @param tipo
	 * @param valor
	 */
	public JugadaPrimitiva(int tipo, int valor) {
		this.tipo = tipo;
		this.valor = valor;
	}

	/**
	 * definir la jugada primitiva a un tipo 
	 * @return
	 */
	public String informativo() {
		int tipo = this.getTipo();
		int valor = getValor();

		String nombre = "";
		String informacion;

		if (tipo == 1 || tipo==11) {
			nombre = "MoverAdelante";
		} else if (tipo == 2) {
			nombre = "GirarIzquierda";
			valor = 90;
		} else if (tipo == 3) {
			nombre = "GirarDerecha";
			valor = -90;
		} else if (tipo == 4 || tipo==44) {
			nombre = "MoverAtras";
		} else if (tipo == 5) {
			nombre = "Chutar";
		}

		informacion = nombre + " " + Integer.toString(valor);
		return informacion;
	}

	/**
	 * enviar jugadas primitivas al robot por bluetooth
	 * @param jugada
	 */
	private void enviarJugadaRobot(int jugada) {
		if (!debug) {
			NXTConnector conn = new NXTConnector();
			boolean ejecucion = false;
			// conn.connectTo("NXT_3", , protocols)

			conn.addLogListener(new NXTCommLogListener() {

				public void logEvent(String message) {
					System.out.println("BTSend Log.listener: " + message);

				}

				public void logEvent(Throwable throwable) {
					System.out.println("BTSend Log.listener - stack trace: ");
					throwable.printStackTrace();

				}

			});

			// conectando al NXT atraves de conexion Bluetooth
			// boolean connected = conn.connectTo("btspp://");
			boolean connected = false;
			connected = conn.connectTo(JugadaPrimitiva.conexionBT, NXTComm.PACKET);
			// connected= conn.connectTo("", JugadaPrimitiva.conexionBT,
			// NXTCommFactory.BLUETOOTH, NXTComm.PACKET);
			// connected=conn.connectTo(, JugadaPrimitiva.conexionBT,
			// NXTCommFactory.BLUETOOTH);

			// conectando al NXT atraves de conexion Bluetooth
			// boolean connected = conn.connectTo();

			if (!connected) {
				System.err.println("Failed to connect to any NXT");
				// System.exit(1);
			} else {
				DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
				DataInputStream dis = new DataInputStream(conn.getInputStream());

				try {
					System.out.println("Enviando Jugada primitiva " + jugada);
					dos.writeInt(jugada);
					dos.flush();

				} catch (IOException ioe) {
					System.out.println("IO Exception writing bytes:");
					System.out.println(ioe.getMessage());

				}

				try {

					ejecucion = dis.readBoolean();
					System.out.println(ejecucion);
					dis.close();
					dos.close();
					conn.close();

				} catch (IOException ioe) {

					System.out.println("IO Exception reading bytes:");
					System.out.println(ioe.getMessage());

				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!ejecucion) {
				this.enviarJugadaRobot(jugada);
			}
		}

	}
	 
	 /**
	  * Definiendo metodos especificos que ejecutan el metodo privado
	  *EnviarJugadaRobot tal como: 1=Chutar 
	  */
	public void chutar() {

		enviarJugadaRobot(500);

	}

	   /**
	    * Definiendo metodos especificos que ejecutan el metodo privado
	    *EnviarJugadaRobot tal como: 3 = girar derecha
	    */
	public void girarD() {
		enviarJugadaRobot(300);
	}

	/**
	 *Definiendo metodos especificos que ejecutan el metodo privado
	 *EnviarJugadaRobot tal como: 2 = girar izquierda
	 */
	public void girarI() {
		enviarJugadaRobot(200);
	}

	/**
	 * Definiendo metodos especificos que ejecutan el metodo privado
	 *EnviarJugadaRobot tal como: 3 = mover adelante
	 */
	public void moverAdelante() {
		enviarJugadaRobot(this.obtenerMensaje());
	}
	/**
	 *Definiendo metodos especificos que ejecutan el metodo privado
	 *EnviarJugadaRobot tal como: 4=MoverAtras
	 */
	public void moverAtras() {
		enviarJugadaRobot(this.obtenerMensaje());
	}

	/**
	 * Definiendo metodos especificos que ejecutan el metodo privado
	 *EnviarJugadaRobot tal como: 3 = mover adelante
	 */
	public void moverAdelanteQuemado() {
		enviarJugadaRobot(115);
	}
	/**
	 *Definiendo metodos especificos que ejecutan el metodo privado
	 *EnviarJugadaRobot tal como: 4=MoverAtras
	 */
	public void moverAtrasQuemado() {
		enviarJugadaRobot(415);
	}
	/**
	 * obtener mensajes del tipo de valor 
	 * @return
	 */
	public int obtenerMensaje() {
		String Tipo = Integer.toString(tipo);
		String Valor = Integer.toString(valor);
		String mensaje = Tipo + Valor;
		return Integer.parseInt(mensaje);
	}

	/**
	 * ejecutar jugadas primitivas con el tipo especificado de cada uno
	 */
	public void ejecutar() {
		if (tipo == 0) {
			// detenerse();
		} else if (tipo == 1) {
			moverAdelante();
		}else if(tipo==11){
			moverAdelanteQuemado();
		} else if (tipo == 2) {
			girarI();
		} else if (tipo == 3) {
			girarD();
		} else if (tipo == 4) {
			moverAtras();
		}else if(tipo==44){
			moverAtrasQuemado();
		} else if (tipo == 5) {
			chutar();
		}
		System.out.println("Jugada Realizada");
	}

	/**
	 * Obtiene una jugada primitiva a XMLElment
	 * 
	 * @param doc
	 * @return el xml de la jugada primitiva
	 */
	public Element getXMLElment(Document doc) {
		Element jugadaPrimitivaXML = null;
		jugadaPrimitivaXML = doc.createElement("JugadaPrimitiva");
		Element tipo = doc.createElement("Tipo");
		tipo.appendChild(doc.createTextNode(Integer.toString(this.getTipo())));
		jugadaPrimitivaXML.appendChild(tipo);
		Element valor = doc.createElement("Valor");
		valor.appendChild(doc.createTextNode(Integer.toString(this.getValor())));
		jugadaPrimitivaXML.appendChild(valor);
		return jugadaPrimitivaXML;
	}

	/**
	 * configurar la conexion de bluetooth con el robot
	 * @param conectionString
	 */
	public static void configurarConexion(String conectionString) {
		JugadaPrimitiva.conexionBT = conectionString;

	}

}
