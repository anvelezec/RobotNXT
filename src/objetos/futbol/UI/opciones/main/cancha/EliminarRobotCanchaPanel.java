package objetos.futbol.UI.opciones.main.cancha;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.administrarRobot.QuitarRobot;

/**
 * elimina el robot del panel de la cancha 
 * @author luisa
 *
 */
public class EliminarRobotCanchaPanel extends JPanel{
	
	private QuitarRobot eliminarRobot = new QuitarRobot();
	private JButton eliminar = new JButton("eliminar Robot");
	public EliminarRobotCanchaPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new GridLayout(1, 1));
		add(eliminar);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarRobot();
			}
		});
		
	}

	/**
	 * elimina robot de la cancha en el layout
	 * @param layout
	 */
	public EliminarRobotCanchaPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public void eliminarRobot(){
		
		AdministrarCancha.removeRobot(AdministrarCancha.getCancha().getRobots().get(AdministrarCancha.getAdministraCanchaFrame().getListarRobots().getRobots().getSelectedIndex()));	
			JOptionPane.showMessageDialog(null, "robot eliminado");
		
	}
}
