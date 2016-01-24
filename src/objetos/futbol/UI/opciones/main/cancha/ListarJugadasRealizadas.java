package objetos.futbol.UI.opciones.main.cancha;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarCancha;

public class ListarJugadasRealizadas extends JPanel {
	JList<String> jugadasRealizadas = new JList<String>();
	Juego juego = new Juego();

	public ListarJugadasRealizadas() {
		super();
		setLayout(new BorderLayout());
		JLabel titulo = new JLabel("Historia");
		setLayout(new FlowLayout());
		this.add(titulo, BorderLayout.NORTH);
		this.add(jugadasRealizadas , BorderLayout.CENTER);
		listarJugadas();
	}

	public void listarJugadas() {
		this.jugadasRealizadas.removeAll();
		DefaultListModel<String> jugadasRealizadasG = new DefaultListModel<String>();
		for (int i = 0; i < juego.getRobot().getJugador().getListaJugadas().size(); i++) {
			jugadasRealizadasG.addElement(juego.getRobot().getJugador().getListaJugadas().get(i));
		}
		jugadasRealizadas.setModel(jugadasRealizadasG);
	}

	public ListarJugadasRealizadas(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadasRealizadas(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadasRealizadas(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
