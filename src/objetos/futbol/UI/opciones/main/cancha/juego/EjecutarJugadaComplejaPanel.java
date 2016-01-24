package objetos.futbol.UI.opciones.main.cancha.juego;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.Juego;

import java.util.*;

public class EjecutarJugadaComplejaPanel extends JPanel implements ActionListener{
	
	JList<JButton> listaBotones = new JList<JButton>();
	
	public EjecutarJugadaComplejaPanel() {
		super();
		this.setLayout(new GridLayout(Juego.getRobot().getJugador().getJugadasComplejas().size(), 1));
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		//this.add(listaBotones);
		jugadasComplejas();
	}
	
	public void jugadasComplejas() {
		limpiarJugadasComplejas();
		this.removeAll();
		this.updateUI();
		for(int i = 0; i < Juego.getRobot().getJugador().getJugadasComplejas().size(); i++) {
			JButton button = new JButton(Juego.getRobot().getJugador().getJugadasComplejas().get(i).getNombreJugada());
			//button.setVisible(true);
			listaBotones.add(button);
			this.add(button);
			button.addActionListener(new oyente(i));
			
		}
	}
	
	public void limpiarJugadasComplejas(){
		listaBotones.removeAll();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	class oyente implements ActionListener{
		private int num;
		public oyente(int numero){
			num = numero;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Juego.getRobot().ejecutarJugadaComplejaRobot(num);
			Juego.getJuegoFrame().getCanchaPanel().cargar();
			Juego.getJuegoFrame().getJugadasRealizadas().listarJugadas();
		}
		
	}
	
}
