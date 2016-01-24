package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarJugadoresFrame;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.ListarJugadaComplejaPanel;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.ListarJugadasComplejas;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.*;

public class AgregarJugadaComplejaJugadorPanel extends Panel {

	private ListarJugadoresPanel listarJugadoresPanel = new ListarJugadoresPanel();
	private ListarJugadaComplejaPanel jugadasComplejasList = new ListarJugadaComplejaPanel();
	private JCheckBox isArquero;
	private JButton agregar = new JButton("Agregar jugada compleja");

	public AgregarJugadaComplejaJugadorPanel() {
		super();

		setLayout(new FlowLayout());

		jugadasComplejasList.cargarJugadasComplejas();
		this.add(jugadasComplejasList);
		// cargarJugadasComplejasJugador();

		// setLayout(new GridLayout(2,2));
		isArquero = new JCheckBox("Es Arquero?");
		this.add(isArquero);
		this.add(agregar);
		// add(jugadasComplejasList);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarJugadorJugadaCompleja();
			}

		});
	}

	public AgregarJugadaComplejaJugadorPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	private void agregarJugadorJugadaCompleja() {

		if (isArquero.isSelected()) {
			JugadaCompleja jugadaComplejaInstanciada = AdministrarJugadasComplejas.getJugadaComplejas()
					.get(jugadasComplejasList.getJugadasComplejas().getSelectedIndex());

			AdministrarJugadores.getArqueros().get(AdministrarJugadores.getAdministrarJugadoresFrame()
					.getListarJugadores().getArqueros().getSelectedIndex())
					.setJugadaCompleja(jugadaComplejaInstanciada);
			;
			AdministrarJugadores.guardarXML();
			JOptionPane.showMessageDialog(null, "Jugada compleja agregada");

		} else {
			JugadaCompleja jugadaComplejaInstanciada = AdministrarJugadasComplejas.getJugadaComplejas()
					.get(jugadasComplejasList.getJugadasComplejas().getSelectedIndex());

			AdministrarJugadores.getDelanteros().get(AdministrarJugadores.getAdministrarJugadoresFrame()
					.getListarJugadores().getDelanteros().getSelectedIndex())
					.setJugadaCompleja(jugadaComplejaInstanciada);
			AdministrarJugadores.guardarXML();
			JOptionPane.showMessageDialog(null, "Jugada compleja agregada");
		}

	}

	public ListarJugadoresPanel getListarJugadoresPanel() {
		return listarJugadoresPanel;
	}

	public void setListarJugadoresPanel(ListarJugadoresPanel listarJugadoresPanel) {
		this.listarJugadoresPanel = listarJugadoresPanel;
	}

	public ListarJugadaComplejaPanel getJugadasComplejasList() {
		return jugadasComplejasList;
	}

	public void setJugadasComplejasList(ListarJugadaComplejaPanel jugadasComplejasList) {
		this.jugadasComplejasList = jugadasComplejasList;
	}

}
