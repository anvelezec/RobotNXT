package objetos.futbol.UI.opciones.main.cancha.juego;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.UI.opciones.main.cancha.juego.EjecutarJugadaPrimitivaPanel.oyente;
import objetos.futbol.robot.JugadaPrimitiva;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

public class EjecutarJugadaPrimitivaPanel extends JPanel implements ActionListener{
	JugadaPrimitiva jugadaPrimitiva;
	JButton adelante, atras, derecha, izquierda, chutar;
	JPanel botones = new JPanel();
	//EjecutarJugadaPrimitivaPanel oyente;
	public EjecutarJugadaPrimitivaPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout());
		
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setLayout(new BorderLayout());
		
		
	
		adelante = new JButton("Adelante");
		this.add(adelante, new BorderLayout().NORTH);
		adelante.addActionListener(new oyente(1));
		
		atras = new JButton("Atras");
		this.add(atras, new BorderLayout().SOUTH);
		atras.addActionListener(new oyente(4));
		
		derecha = new JButton("Derecha");
		this.add(derecha, new BorderLayout().EAST);
		derecha.addActionListener(new oyente(2));
		
		izquierda = new JButton("Izquierda");
		this.add(izquierda, new BorderLayout().WEST);
		izquierda.addActionListener(new oyente(3));
		
		chutar = new JButton("Chutar");
		this.add(chutar, new BorderLayout().CENTER);
		chutar.addActionListener(new oyente(0));
		
		//this.add(botones);
	}
	
	@Override
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
			if(num == 1){
				System.out.println("Adelante");
				Juego.getRobot().moverAdelante();
			}
			else if(num == 2){
				System.out.println("Derecha");
				Juego.getRobot().girarD();
			}
			else if(num == 3){
				System.out.println("Izquierda");
				Juego.getRobot().girarI();
			}
			else if(num == 4){
				System.out.println("Atras");
				Juego.getRobot().moverAtras();
			}
			else if(num == 0){
				System.out.println("Chutar");
				Juego.getRobot().chutar();
			}
			Juego.getJuegoFrame().getCanchaPanel().cargar();
			Juego.getJuegoFrame().getJugadasRealizadas().listarJugadas();
		}
		
	}
}