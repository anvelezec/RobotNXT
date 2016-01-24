package objetos.futbol.UI.opciones.main.cancha.juego;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
/**
 * en la clase AccionesPanel creamos un panel de botones los cuales contiene unas acciones para manejar los jugadores
 * @author luisa
 *
 */
public class AccionesPanel extends JPanel {
	
	private ArrayList<Button> botones;
	
	public AccionesPanel() {
		
		super();
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setMinimumSize(new Dimension(100, 500));
		setLayout(new GridLayout( 1, 1));
		setAlignmentX(CENTER_ALIGNMENT);
		add(new JLabel("Acciones"));
	}

	public AccionesPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public AccionesPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public AccionesPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	public void addLabel(){
		add(new JLabel("Acciones"));
	}

	public ArrayList<Button> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<Button> botones) {
		
		this.botones = botones;
		setLayout(new GridLayout( 1+botones.size(), 1));
		this.removeAll();
		add(new JLabel("Acciones"));
		
	}
	

}
