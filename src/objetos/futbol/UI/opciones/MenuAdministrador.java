package objetos.futbol.UI.opciones;

import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarRobot;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;

public class MenuAdministrador extends JFrame {
	static AdministrarJugadasComplejas administrarJugadasComplejas = new AdministrarJugadasComplejas();
	static AdministrarJugadores administrarJugadores= new AdministrarJugadores();
	static AdministrarRobot administrarRobot = new AdministrarRobot();
	static AdministrarCancha administrarCancha= new AdministrarCancha();

	static AdministrarUsuarios usuarios= new AdministrarUsuarios();
	Container container;
	JButton administrarUsuariosB= new JButton("Administrar Usuarios");
	JButton administrarJugadasComplejasB= new JButton("Administrar Jugadas Complejas");
	JButton administrarJugadoresB= new JButton("Administrar Jugadores");
	JButton administrarRobotsB= new JButton("Administrar Robots");
	JButton administrarCanchaB= new JButton("Administrar Cancha");
	//JButton jugarB= new JButton("Jugar");
	


	public MenuAdministrador() throws HeadlessException {
		super("Administrar");
		setSize(500, 600);
		setLocation(0, 0);
		//setVisible(true);
		container= this.getContentPane();
		container.setLayout(new GridLayout(5, 1));
		administrarUsuariosB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eiecutarAdministrarUsuarios();
			}
		});
		administrarJugadasComplejasB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eiecutarJugadasComplejas();
			}
		});
		administrarJugadoresB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eiecutarJugadores();
			}
		});
		administrarRobotsB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eiecutarRobots();
			}
		});
		administrarCanchaB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eiecutarCancha();
			}
		});
		
		/*
		jugarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		*/
		container.add(administrarUsuariosB);
		container.add(administrarJugadasComplejasB);
		container.add(administrarJugadoresB);
		container.add(administrarRobotsB);
		container.add(administrarCanchaB);
	}

	protected void eiecutarCancha() {
		administrarCancha.ejecutar();
	}

	protected void eiecutarRobots() {
		// TODO Auto-generated method stub
		
		administrarRobot.ejecutar();
		
	}

	protected void eiecutarJugadores() {
		// TODO Auto-generated method stub
		
		administrarJugadores.ejecutar();
	}

	protected void eiecutarJugadasComplejas() {
		// TODO Auto-generated method stub
		
		administrarJugadasComplejas.ejecutar();
	}

	protected void eiecutarAdministrarUsuarios() {
		// TODO Auto-generated method stub
		
		usuarios.ejecutar();
		
	}

	public MenuAdministrador(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public MenuAdministrador(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public MenuAdministrador(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
