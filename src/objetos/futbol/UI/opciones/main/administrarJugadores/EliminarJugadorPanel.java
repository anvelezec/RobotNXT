package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarJugadoresFrame;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.UI.opciones.main.administrarUsuarios.EliminarUsuario;

public class EliminarJugadorPanel extends Panel {
	private EliminarJugador eliminarJugador = new EliminarJugador();
	private JCheckBox isArquero;
	private JButton eliminar = new JButton("eliminar Jugador");

	public EliminarJugadorPanel() {

		super();
		setLayout(new FlowLayout());
		isArquero = new JCheckBox("Es Arquero?");
		add(isArquero);

		add(eliminar);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarJugador();
			}

		});
	}

	public EliminarJugadorPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	private void eliminarJugador() {
		if (isArquero.isSelected()) {
			AdministrarJugadores.removeArquero(AdministrarJugadores.getArqueros().get(AdministrarJugadores
					.getAdministrarJugadoresFrame().getListarJugadores().getArqueros().getSelectedIndex()));

			JOptionPane.showMessageDialog(null, "Arquero eliminado");
		} else {
			AdministrarJugadores.removeDelantero(AdministrarJugadores.getDelanteros().get(AdministrarJugadores
					.getAdministrarJugadoresFrame().getListarJugadores().getDelanteros().getSelectedIndex()));
			JOptionPane.showMessageDialog(null, "Delantero eliminado");

		}

	}
}
