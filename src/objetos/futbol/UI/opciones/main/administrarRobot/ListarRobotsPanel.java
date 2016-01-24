package objetos.futbol.UI.opciones.main.administrarRobot;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;

public class ListarRobotsPanel extends Panel {

	private JList<String> robots = new JList<String>();

	public ListarRobotsPanel() {
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

	public JList<String> getRobots() {
		return robots;
	}

	public void setRobots(JList<String> robots) {
		this.robots = robots;
	}

	

	public ListarRobotsPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	
	public void cargarRobots() {
		this.robots.removeAll();
		DefaultListModel<String> robotsG = new DefaultListModel<String>();

		for (int i = 0; i < AdministrarRobot.getRobots().size(); i++) {
			robotsG.addElement(AdministrarRobot.getRobots().get(i).getConexionBT());
		}

		robots.setModel(robotsG);

		// AdministrarUsuarios.getUsuarioGeneral();
	}

}
