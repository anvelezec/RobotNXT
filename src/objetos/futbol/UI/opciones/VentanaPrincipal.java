package objetos.futbol.UI.opciones;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarUsuariosFrame;
import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.UI.opciones.main.cancha.juego.AccionesPanel;


public class VentanaPrincipal extends JFrame {
	Container contenedor;
	JPanel panelNorte = new JPanel();
	JPanel panelSur = new JPanel();
	JPanel panelIzq = new JPanel();
	JPanel panelDer = new JPanel();
	JPanel panelCentro = new JPanel();
	JMenuBar barraMenu = new JMenuBar();
	
	private static AccionesPanel accionesPanel = new AccionesPanel();
	public VentanaPrincipal() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Futbolmania BOT");
		setSize(1200, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		setJMenuBar(barraMenu);
		contenedor = getContentPane();

		// Creacion de Menus archivo
		JMenu menuArchivo = new JMenu("Archivo");
		barraMenu.add(menuArchivo);
		JMenu menuAcciones = new JMenu("Acciones");
		barraMenu.add(menuAcciones);
		JMenu menuAyuda = new JMenu("Ayuda");
		barraMenu.add(menuAyuda);
		JMenu menuSeleccionarJugadores = new JMenu("Seleccionar Jugadores");
		barraMenu.add(menuSeleccionarJugadores);
		JMenuItem salir = new JMenuItem("Salir");
		menuArchivo.add(salir);
		//Definicion de paneles
		contenedor.add(panelNorte, BorderLayout.NORTH);
		contenedor.add(panelSur, BorderLayout.SOUTH);
		contenedor.add(panelIzq,BorderLayout.WEST);
		contenedor.add(panelDer,BorderLayout.EAST);
		contenedor.add(panelCentro, BorderLayout.CENTER);
		//Panel Izq
		panelIzq.add(accionesPanel);
		
		
		
	}

	public VentanaPrincipal(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public VentanaPrincipal(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public VentanaPrincipal(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//JFrame f = new MenuAdministrador();
		//f.setVisible(true);
		OpcionMain opcionMain= new OpcionMain();
		opcionMain.ejecutar();
		//Juego juego = new Juego();
		
	}

}
