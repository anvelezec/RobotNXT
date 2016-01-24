package objetos.futbol.UI.opciones.main.cancha.juego;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.UI.opciones.main.cancha.juego.EjecutarJugadaPrimitivaPanel.oyente;

public class DatoPanel extends JPanel{
	JPanel panel = new JPanel();
	JPanel panelArriba = new JPanel();
	JPanel panelAbajo = new JPanel();
	JButton enviar = new JButton("Enviar");
	JTextField texto1 = new JTextField(80);
	JTextArea textArea;
	
	public DatoPanel() {
		super();
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout());
		panelArriba.add(texto1, BorderLayout.WEST);
		panelArriba.add(enviar, BorderLayout.EAST);
		enviar.addActionListener(new oyente(1));
		panelArriba.add(new JTextArea(10, 100), BorderLayout.SOUTH);
		this.add(panelArriba);
	}
	
	class oyente implements ActionListener{
		private int num;
		public oyente(int numero){
			num = numero;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(num == 1){
				texto1.setText(null);
				//textArea.setText(null);
			}else{
				texto1.setText(null);
				//textArea.setText(null);
			}
			Juego.getJuegoFrame().getCanchaPanel().cargar();
		}
		
	}
}
