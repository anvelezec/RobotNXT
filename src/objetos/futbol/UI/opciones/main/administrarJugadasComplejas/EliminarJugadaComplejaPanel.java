package objetos.futbol.UI.opciones.main.administrarJugadasComplejas;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;

public class EliminarJugadaComplejaPanel extends JPanel {
	JButton eliminar = new JButton("Eliminar Jugada Compleja");

	public EliminarJugadaComplejaPanel() {
		
		super();
		setLayout(new FlowLayout());
		add(eliminar);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarUnaJugadaCompleja();
			}
		});
	}

	public EliminarJugadaComplejaPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EliminarJugadaComplejaPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EliminarJugadaComplejaPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	public void eliminarUnaJugadaCompleja(){
		AdministrarJugadasComplejas.removeJugadaCompleja(
				AdministrarJugadasComplejas.getJugadaComplejas().get(AdministrarJugadasComplejas.getAdministrarJugadasComplejasFrame().getListarJugadasComplejas().getJugadasComplejas().getSelectedIndex())
				);
		JOptionPane.showMessageDialog(null, "Jugada Compleja Eliminada");
	}

}
