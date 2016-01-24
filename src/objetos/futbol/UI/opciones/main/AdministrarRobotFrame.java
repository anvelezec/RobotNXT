package objetos.futbol.UI.opciones.main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import objetos.futbol.UI.opciones.main.administrarRobot.AgregarRobotPanel;
import objetos.futbol.UI.opciones.main.administrarRobot.EliminarRobotPanel;
import objetos.futbol.UI.opciones.main.administrarRobot.EstablecerJugadorRobotPanel;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobots;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobotsPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.AgregarUsuarioPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.EliminarUsuarioPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.ListarUsuariosPanel;

public class AdministrarRobotFrame extends JFrame {
	Container contenedor;

	ListarRobotsPanel listarRobots = new ListarRobotsPanel();
	AgregarRobotPanel agregarRobots = new AgregarRobotPanel();
	EliminarRobotPanel eliminarRobot = new EliminarRobotPanel();
	EstablecerJugadorRobotPanel establecerJugadorRobotPanel = new EstablecerJugadorRobotPanel();

	public ListarRobotsPanel getListarRobots() {
		return listarRobots;
	}

	public AdministrarRobotFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Administrar Robots");
		setSize(800, 400);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor = getContentPane();

		contenedor.add(listarRobots);
		contenedor.add(agregarRobots);
		contenedor.add(eliminarRobot);
		contenedor.add(establecerJugadorRobotPanel);
	}

	public AdministrarRobotFrame(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AdministrarRobotFrame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AdministrarRobotFrame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
