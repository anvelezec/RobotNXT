package objetos.futbol.UI.opciones.main.administrarRobot;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadoresPanel;
import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Futbolista;

public class AgregarJugadorRobotPanel extends JPanel {
private ListarJugadoresPanel listarJugadoresPanel= new ListarJugadoresPanel();

private JButton boton =  new JButton("seleccionar");
	public AgregarJugadorRobotPanel() {
		super();
		setLayout(new BorderLayout());
		JTextField titulo = new JTextField("Tipos de jugadores");
		this.add(titulo,BorderLayout.NORTH);
		listarJugadoresPanel.cargarJugadores();	
		this.add(listarJugadoresPanel,BorderLayout.CENTER);
		
		this.add(boton,BorderLayout.SOUTH);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escogerJugador();
			}

		});
	}

	private void escogerJugador() {
		
			Futbolista futbolista = AdministrarJugadores.getArqueros()
					.get(listarJugadoresPanel.getArqueros().getSelectedIndex());
			AdministrarCancha.getCancha();
			Cancha.getRobots().get(0).setJugador(futbolista);

			Futbolista futbolista1 = AdministrarJugadores.getDelanteros()
					.get(listarJugadoresPanel.getDelanteros().getSelectedIndex());
			Cancha.getRobots().get(1).setJugador(futbolista1);
			
			AdministrarCancha.pausarPartido();
			AdministrarCancha.reanudarPartido();
			Juego.getJuegoFrame().getCanchaPanel().recargarImagenes();
			JOptionPane.showMessageDialog(null, "Jugadores agegados");

	}


	public AgregarJugadorRobotPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AgregarJugadorRobotPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AgregarJugadorRobotPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
