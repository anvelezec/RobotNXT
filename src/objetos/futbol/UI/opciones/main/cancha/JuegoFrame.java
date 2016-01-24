package objetos.futbol.UI.opciones.main.cancha;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import objetos.futbol.*;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadoresPanel;
import objetos.futbol.UI.opciones.main.administrarRobot.AgregarJugadorRobotFrame;
import objetos.futbol.UI.opciones.main.administrarRobot.AgregarJugadorRobotPanel;
import objetos.futbol.UI.opciones.main.cancha.juego.CanchaPanel;
import objetos.futbol.UI.opciones.main.cancha.juego.DatoPanel;
import objetos.futbol.UI.opciones.main.cancha.juego.EjecutarJugadaComplejaPanel;
import objetos.futbol.UI.opciones.main.cancha.juego.EjecutarJugadaPrimitiva;
import objetos.futbol.UI.opciones.main.cancha.juego.EjecutarJugadaPrimitivaPanel;
import objetos.futbol.robot.Robot;


public class JuegoFrame extends JFrame implements ActionListener{
	
	Container container;
	AgregarJugadorRobotPanel paneljugadores = new AgregarJugadorRobotPanel();
	EjecutarJugadaPrimitivaPanel primitivaPanel = new EjecutarJugadaPrimitivaPanel();
	EjecutarJugadaComplejaPanel complejaPanel = new EjecutarJugadaComplejaPanel();
	ListarJugadasRealizadas jugadasRealizadas = new ListarJugadasRealizadas();
	CanchaPanel canchaPanel= new CanchaPanel();
	DatoPanel datoPanel = new DatoPanel();
	
	JMenuBar barraMenu;
	JMenu acciones,ayuda,archivo,jugadores;
	JMenuItem robots,salida, juegoNuevo,listarJugadores;
	JPanel panelAcciones = new JPanel();
	
	public JuegoFrame() throws HeadlessException {
		super("Juego");
		setSize(1200, 600);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new BorderLayout());
		/**
		 * Barra de menú
		 */
		barraMenu =  new JMenuBar();
		setJMenuBar(barraMenu);
		
		archivo = new JMenu("Archivo");
		acciones = new JMenu("Acciones");
		ayuda = new JMenu("Ayuda");
		jugadores = new JMenu("Seleccionar Jugadores");
		
		listarJugadores =  new JMenuItem("Selecion de jugadores");
		robots = new JMenuItem("Seleccionar robot");
		acciones.add(robots);
		
		
		juegoNuevo = new JMenuItem("Iniciar el partido");
		salida = new JMenuItem("Salir");
		jugadores.add(listarJugadores);
		archivo.add(juegoNuevo);
		archivo.add(salida);
				
		barraMenu.add(archivo);
		barraMenu.add(acciones);
		barraMenu.add(ayuda);
		barraMenu.add(jugadores);
		
		listarJugadores.addActionListener(this);
		juegoNuevo.addActionListener(this);
		robots.addActionListener(this);
		salida.addActionListener(this);
		
		panelAcciones.setLayout(new GridLayout(2, 1));
		panelAcciones.add(primitivaPanel);
		panelAcciones.add(complejaPanel);
		
		container.add(datoPanel, BorderLayout.SOUTH);
		container.add(panelAcciones,BorderLayout.WEST);
		container.add(jugadasRealizadas,BorderLayout.EAST);
		container.add(canchaPanel,BorderLayout.CENTER);
	}
	public JuegoFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Container getContenedor() {
		return container;
	}

	public void setContenedor(Container contenedor) {
		this.container = contenedor;
	}
	
	public JuegoFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public JuegoFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	
	public EjecutarJugadaPrimitivaPanel getJugadaPrimitiva() {
		return primitivaPanel;
	}

	public void setJugadaPrimitiva(EjecutarJugadaPrimitivaPanel primitivaPanel) {
		this.primitivaPanel = primitivaPanel;
	}
	public EjecutarJugadaComplejaPanel getComplejaPanel() {
		return complejaPanel;
	}
	public void setComplejaPanel(EjecutarJugadaComplejaPanel complejaPanel) {
		this.complejaPanel = complejaPanel;
	}
	public CanchaPanel getCanchaPanel() {
		return canchaPanel;
	}
	public void setCanchaPanel(CanchaPanel canchaPanel) {
		this.canchaPanel = canchaPanel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando =  e.getActionCommand();
		
		if("Seleccionar robot".equals(comando)){
			
			String [] ventanarobots = {"Arquero","Delantero"};
			int opciones =  (int) JOptionPane.showOptionDialog(null, "Seleccione un robot", "Robots",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null , ventanarobots,ventanarobots[0] );
			if(opciones == 0){
				Juego.setRobot(AdministrarCancha.getCancha().getRobots().get(0));
				complejaPanel.jugadasComplejas();
			}else if(opciones == 1){
				Juego.setRobot(AdministrarCancha.getCancha().getRobots().get(1));
				complejaPanel.jugadasComplejas();
			}
		}else if("Selecion de jugadores".equals(comando)){
			AgregarJugadorRobotFrame jugadoresdelSistema = new AgregarJugadorRobotFrame();
			
			
		}else if("Iniciar el partido".equals(comando)){
			AdministrarCancha ponerRobotsPosicionesIniciales= new AdministrarCancha();
			ponerRobotsPosicionesIniciales.iniciarPosicionRobots();
			Object[] opciones = {"Aceptar"};
			int opcion = JOptionPane.showOptionDialog(null, "Juego inicializado con exito", "inicializar juego", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,opciones ,opciones[0]);
			Juego.getJuegoFrame().getCanchaPanel().cargar();
		}else if ("Salir".equals(comando)){
			System.exit(0);
		}
		
	}
	public ListarJugadasRealizadas getJugadasRealizadas() {
		return jugadasRealizadas;
	}
	public void setJugadasRealizadas(ListarJugadasRealizadas jugadasRealizadas) {
		this.jugadasRealizadas = jugadasRealizadas;
	}
	
	
	
}