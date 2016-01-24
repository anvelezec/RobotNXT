package objetos.futbol.Interfaz;

import objetos.futbol.UI.*;
import objetos.futbol.UI.opciones.MenuAdministrador;
import objetos.futbol.UI.opciones.OpcionMain;
import objetos.futbol.UI.opciones.VentanaPrincipal;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
import objetos.futbol.UI.opciones.main.cancha.Juego;
import objetos.futbol.UI.opciones.main.cancha.JuegoFrame;
import objetos.futbol.UI.opciones.main.cancha.juego.AccionesPanel;
import objetos.futbol.Interfaz.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImagingOpException;
import java.awt.image.*;
import javax.swing.*;
/**
 * en la clase ventanaBienvenida se crea el Jframe para darle la bienvenida a los usuarios, dar una descripcion de la aplicación y logear el usuario
 * @author luisa
 *
 */
public class VentanaBienvenida extends JFrame implements ActionListener,MouseListener{
	/**
	 * atributos de VentanaBienvenida
	 */
	int contador = 0;
	Container panelprincipal;
	JPanel P1,P2,P3,P4,P5,P6;
	JLabel Bienvenida, ingresarUsuario, codigoUsuario, clave;
	JTextArea texto;
	JTextField id,password;
	JScrollPane scroll;
	JButton imagenes, botonIngresar,salida;
	UsuarioGeneral usuarioG;
	
	/**
	 * constructor para la ventanaBienvenida, donde crea el jframe y todos sus componentes, sin argumentos
	 */
	public VentanaBienvenida() {
		
		super("Futbol-Demo");
		
		panelprincipal = this.getContentPane();
		panelprincipal.setLayout(new GridLayout(1,2));
		
		P1 = new JPanel();
		P1.setLayout(new GridLayout(2,1));
		
		P2 = new JPanel();
		P2.setLayout(new BorderLayout());
		
		P3 = new JPanel();
		P3.setLayout(new BorderLayout());
		Bienvenida = new JLabel("Bienvenido a Futbol Mania", SwingConstants.CENTER);
		Font auxFont=Bienvenida.getFont(); 
		Bienvenida.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		P3.add(Bienvenida, BorderLayout.CENTER);
		Bienvenida.addMouseListener(this);
		
		P4 = new JPanel();
		P4.setLayout(new FlowLayout(FlowLayout.CENTER));
		imagenes = new JButton(new ImageIcon("./imagenes/haga click.gif"));
		P4.add(imagenes);
		imagenes.addActionListener(this);
		
		
		P5 = new JPanel();
		P5.setLayout(new FlowLayout(FlowLayout.CENTER));
		texto = new JTextArea(10,25);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		texto.setText("El proyecto realizado en la materia de Programación Orientada a Objetos, tiene como objetivo introducir nuevas tecnología como la robótica a los estudiantes. Para ello se pidió a los estudiantes que realizaran la programación para varios Robots Lego NXT y estos realizaran un pequeño campeonato de futbol.  Los robots debían presentar movimientos sencillos o primitivos y con estos formaran otros movimientos más avanzados o complejos, además debían realizar una interfaz grafica donde se pueda ver la ubicación del robot directamente desde la pantalla del computador. Todo lo anterior se debe presenta por ordenes desde el computador al robot vía Bluetooth. Este proyecto de programación fue creado por, Luisa Fernanda Ruiz Bedoya, Javier Esteban Parra, Andrés Vélez.");
		texto.setEditable(false);
		scroll = new JScrollPane(texto) ;
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		P5.add(scroll);
		
		
		P6 = new JPanel();
		P6.setLayout(new GridLayout(4,1));
		ingresarUsuario = new JLabel("<html> <body>Para ingresar al sistema<br>como usuario general dar click <br>al boton ingresar usuario,<br> de lo contrario ingrese su codigo de usuario<br>y clave de usuario administrador</body> </html>");
		botonIngresar= new JButton("Ingresar Usuario");
		codigoUsuario = new JLabel("Codigo de Usuario");
		id = new JTextField();
		clave = new JLabel("Clave");
		password = new JTextField();
		salida = new JButton("Salida del sistema");
		salida.addActionListener(this);
		botonIngresar.addActionListener(this);
		P6.add(ingresarUsuario);
		P6.add(botonIngresar);
		P6.add(codigoUsuario);
		P6.add(id);
		P6.add(clave);
		P6.add(password);
		P6.add(salida);
		
		
		P1.add(P3);
		P1.add(P4);
		P2.add(P5, BorderLayout.NORTH);
		P2.add(P6, BorderLayout.CENTER);
		
		
		panelprincipal.add(P1, FlowLayout.LEFT);
		panelprincipal.add(P2);
		paintComponents(getGraphics());
		setSize(600,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
    	
    	String comando = e.getActionCommand();
    	if("Salida del sistema".equals(comando)){
			Object[] ventanaEmergente = {"Aceptar","Cancelar"};
			int opcion = JOptionPane.showOptionDialog(null, "¿Desea salir del programa?", "Salida", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, ventanaEmergente, ventanaEmergente[0]);
			
			if (opcion == 0){
				System.exit(0);
			}
		}else if ("Ingresar Usuario".equals(comando)){
			
			String usuario = id.getText(); 
			String clave = password.getText();
			
			if(usuario.length()==0 && clave.length() == 0){
				new OpcionMain().ejecutar();
				this.dispose();
			
			
			}else if(usuario.length()==0 || clave.length() == 0){
				Object[] ventanaEmergente = {"Aceptar"};
				int opcion = JOptionPane.showOptionDialog(null, "Por favor introducir un usuario y contraseña validos", "Error", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, ventanaEmergente, ventanaEmergente[0]);
				
			}else {
				for(int i=0;i<Main.usuariosleidos.size();i++){
					if (Main.usuariosleidos.get(i).getNombre().equals(usuario) && Main.usuariosleidos.get(i).getPassword().equals(clave)){
						new OpcionMain().admin();
						this.dispose();
					}
				}
			}
			
		}
	
		if (contador == 0){
    		imagenes.setIcon(new ImageIcon("./imagenes/haga click.gif"));
    		contador ++;
    	}else if (contador == 1){
    		imagenes.setIcon(new ImageIcon("./imagenes/karim.gif"));
    		contador ++;
    	}else if (contador == 2){
    		imagenes.setIcon(new ImageIcon("./imagenes/sergio.gif"));
    		contador ++;
    	}else if (contador == 3){
    		imagenes.setIcon(new ImageIcon("./imagenes/suarez.gif"));
    		contador ++;
    	}else if (contador == 4){
    		imagenes.setIcon(new ImageIcon("./imagenes/kane.gif"));
    		contador ++;
    	}else if (contador == 5){
    		imagenes.setIcon(new ImageIcon("./imagenes/roberlew.gif"));
    		contador ++;
    	}else if (contador == 6){
    		imagenes.setIcon(new ImageIcon("./imagenes/neuer.gif"));
    		contador ++;
    	}else if (contador == 7){
    		imagenes.setIcon(new ImageIcon("./imagenes/david.gif"));
    		contador ++;
    	}else if (contador == 8){
    		imagenes.setIcon(new ImageIcon("./imagenes/thibaut.gif"));
    		contador ++;
    	}else if (contador == 9){
    		imagenes.setIcon(new ImageIcon("./imagenes/petr.gif"));
    		contador ++;
    	}else if (contador == 10){
    		imagenes.setIcon(new ImageIcon("./imagenes/navas.gif"));
    		contador = 0;
    	}
    	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		Bienvenida.setForeground(Color.yellow);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Bienvenida.setForeground(Color.BLACK);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}




