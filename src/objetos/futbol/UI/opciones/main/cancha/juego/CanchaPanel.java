package objetos.futbol.UI.opciones.main.cancha.juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.robot.Robot;

public class CanchaPanel extends JPanel {
	BufferedImage imageArquero;
	BufferedImage imageDelantero;
	BufferedImage imgaeCancha;

	JLabel picDelantero;
	JLabel picArquero;
	JLabel cancha;
	JButton administrarUsuariosB = new JButton("Administrar Usuarios");

	public CanchaPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setSize(800, 421);
		try {
			imageDelantero = ImageIO
					.read(new File(AdministrarCancha.getCancha().getRobots().get(1).getJugador().getImagen()));
			imageArquero = ImageIO
					.read(new File(AdministrarCancha.getCancha().getRobots().get(0).getJugador().getImagen()));
			imgaeCancha = ImageIO.read(new File("Cancha.png"));

			cancha = new JLabel(new ImageIcon(imgaeCancha));
			//picDelantero = new JLabel(new ImageIcon(imageDelantero));
			//picArquero = new JLabel(new ImageIcon(imageArquero));
			picDelantero= new JLabel();
			picDelantero.setIcon(new ImageIcon(imageDelantero));
			picArquero = new JLabel();
			picArquero.setIcon(new ImageIcon(imageArquero));

			picDelantero.setSize(100, 100);
			picArquero.setSize(100, 100);
			cancha.setSize(imgaeCancha.getWidth(), imgaeCancha.getHeight());

			administrarUsuariosB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// picDelantero.setLocation(100, 100);
					// picArquero.setLocation(30, 30);
					// posicionarArquero(300+1830, 0);
					// posicionarDelantero(300, 1220);
					//Juego.setRobot(AdministrarCancha.getCancha().getRobots().get(0));
					recargarImagenes();
				}
			});
			administrarUsuariosB.setSize(80, 10);
			administrarUsuariosB.setLocation(150, 150);
			// add(picLabel);

			// setSize(800, 800);
			picDelantero.setLocation(100, 100);
			picArquero.setLocation(0, 150);
			add(administrarUsuariosB);
			add(picDelantero);
			add(picArquero);
			add(cancha);
			cargar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CanchaPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CanchaPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CanchaPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public JLabel getPicLabel() {
		return picDelantero;
	}

	public void setPicLabel(JLabel picLabel) {
		this.picDelantero = picLabel;
	}

	public JLabel getPicLabel2() {
		return picArquero;
	}

	public void setPicLabel2(JLabel picLabel2) {
		this.picArquero = picLabel2;
	}

	public void posicionarArquero() {
		Robot robot = null;

		robot = AdministrarCancha.getCancha().getRobots().get(0);
		int x = (int) robot.getPosicionRelativa().x;
		int y = (int) robot.getPosicionRelativa().y;
		int posicionX = x * 800 / 2430;
		int posicionY = y * 421 / (1820 - 30);
		picArquero.setLocation(posicionX, posicionY);
	}

	public void posicionarDelantero() {
		Robot robot = null;

		robot = AdministrarCancha.getCancha().getRobots().get(1);
		int x = (int) robot.getPosicionRelativa().x;
		int y = (int) robot.getPosicionRelativa().y;
		int posicionX = x * 800 / 2430;
		int posicionY = y * 421 / (1820 - 30);
		picDelantero.setLocation(posicionX, posicionY);
	}

	public void cargar() {
		posicionarArquero();
		posicionarDelantero();

	}

	public void recargarImagenes() {
		try {
			imageDelantero = ImageIO
					.read(new File(AdministrarCancha.getCancha().getRobots().get(1).getJugador().getImagen()));
			imageArquero = ImageIO
					.read(new File(AdministrarCancha.getCancha().getRobots().get(0).getJugador().getImagen()));
			picDelantero.setIcon(new ImageIcon(imageDelantero));
			picArquero.setIcon(new ImageIcon(imageArquero));
			updateUI();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
