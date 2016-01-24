package objetos.futbol.UI.opciones.main.administrarJugadasComplejas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import sun.invoke.empty.Empty;

public class ListarJugadaComplejaPanel extends JPanel {
	private JList<String> jugadasComplejas = new JList<String>();
	public ListarJugadaComplejaPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1,2));
		//panel de usuarios Generales
		JPanel panelJugadasComplejas= new JPanel();
		panelJugadasComplejas.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelJugadasComplejas.setLayout(new BorderLayout());
		panelJugadasComplejas.add(new Label("Jugadas Complejas"), BorderLayout.NORTH);
		panelJugadasComplejas.add(jugadasComplejas, BorderLayout.CENTER);
		this.add(panelJugadasComplejas);
		cargarJugadasComplejas();
	}

	public ListarJugadaComplejaPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadaComplejaPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadaComplejaPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void cargarJugadasComplejas(){
		jugadasComplejas.removeAll();
		DefaultListModel<String> jugadasC=new DefaultListModel<String>();
		for (int i = 0; i < AdministrarJugadasComplejas.getJugadaComplejas().size(); i++) {
			jugadasC.addElement(AdministrarJugadasComplejas.getJugadaComplejas().get(i).getNombreJugada()+": "+AdministrarJugadasComplejas.getJugadaComplejas().get(i).getExplicacion());
		}
		jugadasComplejas.setModel(jugadasC);
		
	}

	public JList<String> getJugadasComplejas() {
		return jugadasComplejas;
	}

	public void setJugadasComplejas(JList<String> jugadasComplejas) {
		this.jugadasComplejas = jugadasComplejas;
	}
	
	

}
