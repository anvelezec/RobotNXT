package objetos.futbol.UI.opciones.main.administrarJugadasComplejas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

//import javafx.scene.control.RadioButton;
//import javafx.scene.control.ToggleGroup;
import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.opciones.OpcionMain;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.varios.LecturaTeclado;

public class AgregarJugadaComplejaPanel extends JPanel {
	JButton agregar= new JButton("Agregar Jugada Compleja");
	ButtonGroup group = new ButtonGroup();
	JRadioButton rb1 = new JRadioButton("Jugada Compleja Defensiva");
	JRadioButton rb2 = new JRadioButton("Jugada Compleja Ofensiva");
	JRadioButton rb3 = new JRadioButton("Jugada Compleja Tiro libre");
	
	public AgregarJugadaComplejaPanel()  {
		super();
		setLayout(new FlowLayout());
		JPanel panel= new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BorderLayout());
		
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUnaJugadaCompleja();
			}
		});
		
		JPanel ratio= new JPanel();
		ratio.setLayout(new FlowLayout());
		rb1.setSelected(true);
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		ratio.add(rb1);
		ratio.add(rb2);
		ratio.add(rb3);
		panel.add(new Label("Seleccione el tipo de jugada"), BorderLayout.NORTH);
		panel.add(ratio, BorderLayout.CENTER);
		panel.add(agregar, BorderLayout.SOUTH);
		add(panel);
		

	}
	
	public void agregarUnaJugadaCompleja(){
		Date now= new Date();
		String fechaCreacion=now.toString();
		UsuarioAdministrador autor=(UsuarioAdministrador)OpcionMain.getUsuarioLogeado();
		ArrayList<JugadaPrimitiva> jugadasPrimitivas=new ArrayList<JugadaPrimitiva>();
		//Formulario
		String nombreJugada=JOptionPane.showInputDialog("Ingrese el nombre de la Jugada Compleja");
		String explicacion=JOptionPane.showInputDialog("Ingrese la explicacion de la jugada Compleja");
		if(rb1.isSelected()){
			AgregarJugadaCompleja.setJugadaCompleja(new JugadaComplejaDefensiva(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas));
		}
		else if (rb2.isSelected()) {
			AgregarJugadaCompleja.setJugadaCompleja(new JugadaComplejaOfensiva(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas));
		}
		else if(rb3.isSelected()){
			AgregarJugadaCompleja.setJugadaCompleja(new JugadaComplejaTiroLibre(nombreJugada, fechaCreacion, autor, explicacion, jugadasPrimitivas));
		}
		AgregarJugadaCompleja agregarJugadaCompleja= new AgregarJugadaCompleja();
		agregarJugadaCompleja.ejecutar();
		
	}

}
