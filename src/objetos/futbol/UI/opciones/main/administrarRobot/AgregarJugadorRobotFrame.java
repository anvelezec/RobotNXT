package objetos.futbol.UI.opciones.main.administrarRobot;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class AgregarJugadorRobotFrame extends JFrame{

	private Container ListaJugadores;
	
	public AgregarJugadorRobotFrame() {
		super("Listar robot");
		ListaJugadores = this.getContentPane();
		ListaJugadores.setLayout(new BorderLayout());
		
		AgregarJugadorRobotPanel jugadoreslistados = new AgregarJugadorRobotPanel();
		
		ListaJugadores.add(jugadoreslistados, BorderLayout.CENTER);
		
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
