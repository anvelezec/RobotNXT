package objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;

public class EliminarJugadaPrimitivaPanel extends JPanel {
	JButton eliminar = new JButton("Eliminar Jugada Primitiva");

	public EliminarJugadaPrimitivaPanel() {
		super();
		setLayout(new FlowLayout());
		add(eliminar);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarUnaJugadaPrimitiva();
			}
		});
	}

	public EliminarJugadaPrimitivaPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public EliminarJugadaPrimitivaPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public EliminarJugadaPrimitivaPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public void eliminarUnaJugadaPrimitiva() {
		AgregarJugadaCompleja.eliminarJugadaPrimitiva(AgregarJugadaCompleja.getJugadaCompleja().getJugadasPrimitivas()
				.get(AgregarJugadaCompleja.getAgregarJugadaComplejaFrame().getListarJugadasPrimitivas().getJugadasPrimitivas().getSelectedIndex()));
	}

}
