	package objetos.futbol.UI.opciones.main.cancha;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarCanchaFrame;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobotsPanel;
import objetos.futbol.UI.opciones.main.administrarRobot.QuitarRobot;
import objetos.futbol.UI.opciones.main.cancha.AgregarRobotCancha;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.robot.Robot;
/**
 * agregar un robot al panel de la cancha
 * @author luisa
 *
 */
public class AgregarRobotCanchaPanel extends JPanel{
	private AgregarRobotCancha agregarRobotCancha = new AgregarRobotCancha();
	private ListarRobotsPanel listarRobotsPanel = new ListarRobotsPanel();
	private JButton agregar = new JButton("agregar Robot");
	public AgregarRobotCanchaPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new BorderLayout());
		add(new Label("Agregar Robot a la cancha"), BorderLayout.NORTH);
		add(agregar, BorderLayout.SOUTH);
		add(listarRobotsPanel, BorderLayout.CENTER);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarRobot();
			}
		});
		
	}

	/**
	 * agregamos un robot al panel de la cancha
	 * @param layout
	 */
	
	public AgregarRobotCanchaPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * agregamos un robot a la cancha
	 */
	public void agregarRobot(){
		Robot robot = AdministrarRobot.getRobots().get(listarRobotsPanel.getRobots().getSelectedIndex());
		AdministrarCancha.addRobot(robot);
		JOptionPane.showMessageDialog(null, "Robot agregado");
		
	}
}
