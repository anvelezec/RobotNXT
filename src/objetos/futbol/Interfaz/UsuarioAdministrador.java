package objetos.futbol.Interfaz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import com.sun.jmx.mbeanserver.JmxMBeanServer;

import sun.net.www.content.image.jpeg;

/**
 * interfaz grafica de usuario administrador
 * @author luisa
 *
 */
public class UsuarioAdministrador extends JFrame{

	private Container paneladministrador;
	private JPanel panelsuperior, panelinferior, panelacciones,panelcancha,panelhistoria;
	private JLabel accioneslabel,historia;
	
	public UsuarioAdministrador() {
		
		super("futbol-Demo Usuario Administrador");
		
		paneladministrador =  this.getContentPane();
		paneladministrador.setLayout(new BorderLayout());
		
		
		panelinferior = new JPanel();
		panelinferior.setLayout(new GridLayout(1, 3));
		
	
		panelsuperior =  new JPanel();
		panelsuperior.setLayout(new GridLayout(1,3));
		
		/**
		 * creacion de la barra de herraminetas
		 */
		
		JMenuBar barraherramientas =  new JMenuBar();
		setJMenuBar(barraherramientas);
		
		JMenu archivo = new JMenu("Archivo");
		JMenu acciones = new JMenu("Acciones");
		JMenu ayuda = new JMenu("Ayuda");
		
		barraherramientas.add(archivo);
		barraherramientas.add(acciones);
		barraherramientas.add(ayuda);
		
		panelacciones= new JPanel();
		panelacciones.setLayout(new BorderLayout());
		accioneslabel =  new JLabel("Acciones", SwingConstants.CENTER);
		panelsuperior.add(accioneslabel);
		
		panelcancha = new JPanel();
		panelsuperior.add(panelcancha);
		
		panelhistoria = new JPanel();
		panelhistoria.setLayout(new BorderLayout());
		historia = new JLabel("Historia", SwingConstants.CENTER);
		panelhistoria.add(historia, BorderLayout.NORTH);
		panelsuperior.add(panelhistoria);
		
		paneladministrador.add(panelsuperior, BorderLayout.NORTH);
		paneladministrador.add(panelinferior, BorderLayout.SOUTH);
		
		setSize(800,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main (String[] args){
		UsuarioAdministrador vent2 = new UsuarioAdministrador();
		
	}
}

