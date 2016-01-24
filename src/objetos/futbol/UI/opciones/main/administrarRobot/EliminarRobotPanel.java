package objetos.futbol.UI.opciones.main.administrarRobot;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.UI.opciones.main.administrarUsuarios.EliminarUsuario;
import objetos.futbol.UI.opciones.main.cancha.EliminarRobotCancha;

public class EliminarRobotPanel extends Panel {
	
	private EliminarRobotCancha eliminarRobot = new EliminarRobotCancha();
	private JButton eliminar = new JButton("eliminar Robot");
	public EliminarRobotPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout());
		add(eliminar);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarRobot();
			}
		});
		
	}

	public EliminarRobotPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public void eliminarRobot(){
		//AdministrarRobot.quitarRobot(AdministrarRobot.getCancha().getRobots().get(AdministrarCancha.getAdministraCanchaFrame().getListarRobots().getRobots().getSelectedIndex()));
			AdministrarRobot.removeRobots(AdministrarRobot.getAdministraRobotFrame().getListarRobots().getRobots().getSelectedIndex());
			JOptionPane.showMessageDialog(null, "robot eliminado");
		
	}
}
