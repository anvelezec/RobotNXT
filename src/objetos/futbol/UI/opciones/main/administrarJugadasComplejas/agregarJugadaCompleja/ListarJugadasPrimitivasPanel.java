package objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;

public class ListarJugadasPrimitivasPanel extends JPanel {
	private JList<String> jugadasPrimitivas = new JList<String>();

	public ListarJugadasPrimitivasPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1,2));
		//panel de usuarios Generales
		JPanel panelJugadasComplejas= new JPanel();
		panelJugadasComplejas.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelJugadasComplejas.setLayout(new BorderLayout());
		panelJugadasComplejas.add(new Label("Jugadas Complejas"), BorderLayout.NORTH);
		panelJugadasComplejas.add(jugadasPrimitivas, BorderLayout.CENTER);
		this.add(panelJugadasComplejas);
		cargarJugadasPrimitivas();
	}

	public ListarJugadasPrimitivasPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadasPrimitivasPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadasPrimitivasPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void cargarJugadasPrimitivas(){
		jugadasPrimitivas.removeAll();
		DefaultListModel<String> jugadasP=new DefaultListModel<String>();
		for (int i = 0; i < AgregarJugadaCompleja.getJugadaCompleja().getJugadasPrimitivas().size(); i++) {
			jugadasP.addElement(AgregarJugadaCompleja.getJugadaCompleja().getJugadasPrimitivas().get(i).informativo());
		}
		jugadasPrimitivas.setModel(jugadasP);
	}

	public JList<String> getJugadasPrimitivas() {
		return jugadasPrimitivas;
	}

	public void setJugadasPrimitivas(JList<String> jugadasPrimitivas) {
		this.jugadasPrimitivas = jugadasPrimitivas;
	}
	
	

}
