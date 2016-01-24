package objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaCompleja;
import objetos.futbol.robot.JugadaPrimitiva;
import objetos.futbol.varios.LecturaTeclado;

public class AgregarJugadaPrimitivaPanel extends JPanel {
	JButton agregar = new JButton("Agregar Jugada Primitiva");
	ButtonGroup group = new ButtonGroup();
	JRadioButton rb1 = new JRadioButton("Mover Adelante");
	JRadioButton rb2 = new JRadioButton("Mover Atras");
	JRadioButton rb3 = new JRadioButton("Girar Derecha");
	JRadioButton rb4 = new JRadioButton("Girar Izquierda");
	JRadioButton rb5 = new JRadioButton("Chutar");

	public AgregarJugadaPrimitivaPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BorderLayout());

		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUnaJugadaPrimitiva();
			}
		});

		JPanel ratio = new JPanel();
		ratio.setLayout(new FlowLayout());
		rb1.setSelected(true);
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		group.add(rb4);
		group.add(rb5);
		ratio.add(rb1);
		ratio.add(rb2);
		ratio.add(rb3);
		ratio.add(rb4);
		ratio.add(rb5);
		panel.add(new Label("Seleccione la jugada Primitiva"), BorderLayout.NORTH);
		panel.add(ratio, BorderLayout.CENTER);
		panel.add(agregar, BorderLayout.SOUTH);
		add(panel);
	}

	public AgregarJugadaPrimitivaPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub

	}

	public AgregarJugadaPrimitivaPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AgregarJugadaPrimitivaPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public void agregarUnaJugadaPrimitiva() {
		if (rb1.isSelected()) {
			agregarMoverAdelante();
		} else if (rb2.isSelected()) {
			agregarMoverAtras();

		} else if (rb3.isSelected()) {
			agregarGirarDerecha();

		} else if (rb4.isSelected()) {
			agregarGirarIzquierda();

		} else if (rb5.isSelected()) {
			agregarChutar();

		}
	}

	/**
	 * agregar la jugada primitiva mover adelante
	 */
	public void agregarMoverAdelante() {
		int tipo = 1;
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Cuantos centimetros  A mover :"));
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

	/**
	 * agregar la jugada primitiva mover atras
	 */
	public void agregarMoverAtras() {

		int tipo = 4;
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Cuantos centimetros  A mover :"));
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

	/**
	 * agregar la jugada primitiva girar derecha
	 */
	public void agregarGirarDerecha() {
		int tipo = 3;
		int valor = 0;
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);
	}

	/**
	 * agregar la jugada primitiva girar izquierda
	 */
	public void agregarGirarIzquierda() {
		int tipo = 2;
		int valor = 0;
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

	/**
	 * agregar la jugada primitiva chutar
	 */
	public void agregarChutar() {
		int tipo = 5;
		int valor = 0;
		JugadaPrimitiva jugadaPrimitiva = new JugadaPrimitiva(tipo, valor);
		AgregarJugadaCompleja.agregarJugadaPrimitiva(jugadaPrimitiva);

	}

}
