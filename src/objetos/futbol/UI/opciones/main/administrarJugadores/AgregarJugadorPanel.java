package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarJugadoresFrame;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.UI.opciones.main.administrarUsuarios.AgregarUsuario;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.JugadaCompleja;

public class AgregarJugadorPanel extends Panel {
	private AgregarJugador agregarJugador = new AgregarJugador();
	private JCheckBox isArquero;
	private JButton agregar = new JButton("Agregar Jugador");

	private String imagen;

	public AgregarJugadorPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout());
		isArquero = new JCheckBox("Es Arquero?");
		add(isArquero);

		add(agregar);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarJugador();
			}

		});
	}

	public AgregarJugadorPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	private void agregarJugador() {
		String nombre;
		byte dorsal;
		String imagen = "";

		if (isArquero.isSelected()) {
			nombre = JOptionPane.showInputDialog("Nombre del Arquero");
			dorsal = Byte.parseByte(JOptionPane.showInputDialog("Dorsal del Arquero"));
			// String imagen = JOptionPane.showInputDialog("Ruta de la imagen
			// del Arquero");

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
			JFileChooser c = new JFileChooser();
			c.setFileFilter(filter);

			int rVal = c.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				imagen = c.getSelectedFile().getName();
			}
			Arquero arqueroInstanciado = new Arquero(nombre, "Arquero", new ArrayList<JugadaCompleja>(), 0, dorsal,
					imagen);
			AdministrarJugadores.addArquero(arqueroInstanciado);

		} else {
			nombre = JOptionPane.showInputDialog("Nombre del Delantero");
			dorsal = Byte.parseByte(JOptionPane.showInputDialog("Dorsal del Delantero"));

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
			JFileChooser c = new JFileChooser();
			c.setFileFilter(filter);

			int rVal = c.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				imagen = c.getSelectedFile().getName();
			}

			// del Delantero");

			Delantero delanteroInstanciado = new Delantero(nombre, "Delantero", new ArrayList<JugadaCompleja>(),
					(short) 0, dorsal, imagen);
			AdministrarJugadores.addDelantero(delanteroInstanciado);
		}

	}

	class OpenL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			// Demonstrate "Open" dialog:
			int rVal = c.showOpenDialog(AgregarJugadorPanel.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				imagen = c.getSelectedFile().getName();

			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
				imagen = ("You pressed cancel");

			}
		}
	}

}
