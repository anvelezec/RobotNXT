package objetos.futbol.UI.opciones.main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobotsPanel;
import objetos.futbol.UI.opciones.main.cancha.AgregarRobotCanchaPanel;
import objetos.futbol.UI.opciones.main.cancha.EliminarRobotCanchaPanel;
import objetos.futbol.UI.opciones.main.cancha.ListarRobotsCanchaPanel;
import objetos.futbol.UI.opciones.main.cancha.ListarRobotsCancha;

public class AdministrarCanchaFrame extends JFrame{
	Container contenedor;
	
	AgregarRobotCanchaPanel agregarRobotCancha = new AgregarRobotCanchaPanel();
	EliminarRobotCanchaPanel eliminarRobotCancha = new EliminarRobotCanchaPanel();
	ListarRobotsCanchaPanel listarRobotsCancha = new ListarRobotsCanchaPanel();
	
	public ListarRobotsCanchaPanel getListarRobots() {
		return listarRobotsCancha;
	}
	
	public AdministrarCanchaFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Administrar Cancha");
		setSize(800, 400);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor = getContentPane();

		contenedor.add(agregarRobotCancha);
		contenedor.add(eliminarRobotCancha);
		contenedor.add(listarRobotsCancha);

	}
	
	public AdministrarCanchaFrame(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AdministrarCanchaFrame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AdministrarCanchaFrame(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
}
