package objetos.futbol.UI.opciones.main.administrarJugadores;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;

public class ListarJugadoresPanel extends Panel {

	private JList<String> arqueros = new JList<String>();
	private JList<String> delanteros = new JList<String>();

	public ListarJugadoresPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1, 2));
		// panel de usuarios Generales
		JPanel panelArqueros = new JPanel();
		panelArqueros.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelArqueros.setLayout(new BorderLayout());
		panelArqueros.add(new Label("Arqueros"), BorderLayout.NORTH);
		panelArqueros.add(arqueros, BorderLayout.CENTER);
		// Panel de usuarios Administradores
		JPanel panelDelanteros = new JPanel();
		panelDelanteros.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelDelanteros.setLayout(new BorderLayout());
		panelDelanteros.add(new Label("Delanteros"), BorderLayout.NORTH);
		panelDelanteros.add(delanteros, BorderLayout.CENTER);
		this.add(panelArqueros);
		this.add(panelDelanteros);
		cargarJugadores();
	}

	public ListarJugadoresPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JList<String> getArqueros() {
		return arqueros;
	}

	public void setArqueros(JList<String> arqueros) {
		this.arqueros = arqueros;
	}

	public JList<String> getDelanteros() {
		return delanteros;
	}

	public void setDelanteros(JList<String> delanteros) {
		this.delanteros = delanteros;
	}

	public void cargarJugadores() {
		this.arqueros.removeAll();
		this.delanteros.removeAll();
		DefaultListModel<String> arquerosG = new DefaultListModel<String>();
		DefaultListModel<String> delanterosA = new DefaultListModel<String>();
		for (int i = 0; i < AdministrarJugadores.getArqueros().size(); i++) {
			arquerosG.addElement(AdministrarJugadores.getArqueros().get(i).getNombre());
		}

		for (int i = 0; i < AdministrarJugadores.getDelanteros().size(); i++) {
			delanterosA.addElement(AdministrarJugadores.getDelanteros().get(i).getNombre());
		}
		arqueros.setModel(arquerosG);
		delanteros.setModel(delanterosA);

	}
}
