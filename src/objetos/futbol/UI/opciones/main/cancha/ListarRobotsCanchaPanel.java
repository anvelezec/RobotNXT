package objetos.futbol.UI.opciones.main.cancha;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobots;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobotsPanel;
/**
 * una clase para listar los robots en el panel de juego y las jugadas de los futbolistas en accion
 * @author luisa
 *
 */
public class ListarRobotsCanchaPanel extends JPanel{
	
	private JList<String> robots = new JList<String>();
	/**
	 * constructor para ListarRobots en el panel
	 */
	public ListarRobotsCanchaPanel() {
		setLayout(new GridLayout(1,1));
		//panel de usuarios Generales
		JPanel panelRobots= new JPanel();
		panelRobots.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelRobots.setLayout(new BorderLayout());
		panelRobots.add(new Label("Robots"), BorderLayout.NORTH);
		panelRobots.add(robots, BorderLayout.CENTER);
		//Panel de usuarios Administradores
		
		this.add(panelRobots);
		this.add(panelRobots);
		cargarRobots();
		
	}

	/**
	 * metodo getrobots 
	 * @return
	 */
	public JList<String> getRobots() {
		return robots;
	}

	public void setRobots(JList<String> robots) {
		this.robots = robots;
	}

	

	public ListarRobotsCanchaPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * metodo que carga los robots al sistema 
	 */
	public void cargarRobots() {
		this.robots.removeAll();
		DefaultListModel<String> robotsG = new DefaultListModel<String>();

		for (int i = 0; i < AdministrarCancha.getCancha().getRobots().size(); i++) {
			robotsG.addElement(AdministrarCancha.getCancha().getRobots().get(i).getConexionBT());
		}
		
		robots.setModel(robotsG);

	}
}
