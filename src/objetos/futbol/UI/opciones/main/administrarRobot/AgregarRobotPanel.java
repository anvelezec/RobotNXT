package objetos.futbol.UI.opciones.main.administrarRobot;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import lejos.geom.Point;
import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.UI.opciones.main.administrarUsuarios.AgregarUsuario;
import objetos.futbol.robot.Robot;

public class AgregarRobotPanel extends Panel {

	private AgregarRobot agregarRobot = new AgregarRobot();
	private JCheckBox isArquero;
	
	private JButton agregar = new JButton("Agregar Robot");

	public AgregarRobotPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout());

		isArquero = new JCheckBox("Agregar robot arquero ?");
		add(isArquero);
		add(agregar);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarRobot();
			}
		});
	}

	public AgregarRobotPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public void agregarRobot() {
		String nombre;
		Robot robotInstanciado = new Robot();
		nombre = JOptionPane.showInputDialog("Conexion Robot");

		if (isArquero.isSelected()) {
			robotInstanciado.setConexionBT(nombre);
			robotInstanciado.setPosicionRelativa(new Point(300, 1200));
		} else  {
			robotInstanciado.setConexionBT(nombre);
			robotInstanciado.setPosicionRelativa(new Point(300,0));
		}

		AdministrarRobot.addRobot(robotInstanciado);

	}
}
