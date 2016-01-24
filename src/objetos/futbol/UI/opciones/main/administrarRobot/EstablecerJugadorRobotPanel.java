package objetos.futbol.UI.opciones.main.administrarRobot;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.ListarJugadaComplejaPanel;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadoresPanel;
import objetos.futbol.jugadores.Futbolista;

public class EstablecerJugadorRobotPanel extends JPanel {

	private ListarJugadoresPanel listarJugadoresPanel = new ListarJugadoresPanel();
	private ListarRobotsPanel listarRobotsPanel = new ListarRobotsPanel();

	private JCheckBox isArquero;
	private JButton agregar = new JButton("Agregar jugador a robot");

	public EstablecerJugadorRobotPanel() {
		setLayout(new FlowLayout());
		// panel de usuarios Generales
		listarJugadoresPanel.cargarJugadores();
		this.add(listarJugadoresPanel);

		isArquero = new JCheckBox("Es Arquero?");
		this.add(isArquero);
		this.add(agregar);

		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarJugadorJugadaCompleja();
			}

		});

	}

	private void agregarJugadorJugadaCompleja() {
		if (isArquero.isSelected()) {
			Futbolista futbolista = AdministrarJugadores.getArqueros()
					.get(listarJugadoresPanel.getArqueros().getSelectedIndex());
			AdministrarRobot.getRobots()
					.get(AdministrarRobot.getAdministraRobotFrame().getListarRobots().getRobots().getSelectedIndex())
					.setJugador(futbolista);
			AdministrarRobot.guardar();
			JOptionPane.showMessageDialog(null, "Jugador agegado");


		} else {
			Futbolista futbolista = AdministrarJugadores.getDelanteros()
					.get(listarJugadoresPanel.getDelanteros().getSelectedIndex());
			AdministrarRobot.getRobots()
					.get(AdministrarRobot.getAdministraRobotFrame().getListarRobots().getRobots().getSelectedIndex())
					.setJugador(futbolista);
			AdministrarRobot.guardar();
			JOptionPane.showMessageDialog(null, "Jugador agegado");

		}

	}

	public EstablecerJugadorRobotPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public EstablecerJugadorRobotPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public EstablecerJugadorRobotPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
