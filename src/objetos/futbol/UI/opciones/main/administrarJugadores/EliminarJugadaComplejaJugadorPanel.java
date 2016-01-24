package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.jugadores.JugadaCompleja;

public class EliminarJugadaComplejaJugadorPanel extends JPanel {
/*
	private JCheckBox isArquero;
	private JButton eliminar = new JButton("Eliminar jugada compleja");

	public EliminarJugadaComplejaJugadorPanel() {
		// TODO Auto-generated constructor stub
	}

	public EliminarJugadaComplejaJugadorPanel(LayoutManager arg0) {
		super(arg0);
		setLayout(new FlowLayout());

		isArquero = new JCheckBox("Es Arquero?");
		add(isArquero);
		add(eliminar);

		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarJugadaComplejaJugador();
			}

		});
		

	}

	private void eliminarJugadaComplejaJugador() {
		if (isArquero.isSelected()){
			
			JugadaCompleja jugadaComplejaSeleccionada = AdministrarJugadasComplejas.getJugadaComplejas().get(jugadasComplejas.getSelectedIndex());
			AdministrarJugadores.getArqueros().get(AdministrarJugadores.getAdministrarJugadoresFrame().getListarJugadores().getArqueros().getSelectedIndex()).setJugadaCompleja(jugadaComplejaSeleccionada);
			AdministrarJugadores.guardarXML();
			JOptionPane.showMessageDialog(null, "Jugada Agregada");
		}
		
	}

	public EliminarJugadaComplejaJugadorPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EliminarJugadaComplejaJugadorPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
*/
}
