package objetos.futbol.UI.opciones.main.cancha.juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JuegoCancha extends JFrame  {
	Container contenedor;
	CanchaPanel canchaPanel= new CanchaPanel();

	public JuegoCancha() throws Exception {
		// TODO Auto-generated constructor stub
		setSize(1200, 600);
		contenedor= this.getContentPane();
		contenedor.setLayout(new BorderLayout());
		add(canchaPanel, BorderLayout.CENTER);
	}
	


	public static void main(String[] args) throws Exception {
		JuegoCancha frame = new JuegoCancha();
		frame.setVisible(true);
	}

}
