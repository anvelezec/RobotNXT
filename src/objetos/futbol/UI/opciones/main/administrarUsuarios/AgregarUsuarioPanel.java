package objetos.futbol.UI.opciones.main.administrarUsuarios;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import objetos.futbol.UI.UsuarioAdministrador;
import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;

public class AgregarUsuarioPanel extends JPanel {
	private AgregarUsuario agregarUsuario = new AgregarUsuario();
	private JCheckBox isAdmin;
	private JButton agregar = new JButton("Agregar Usuario");

	public AgregarUsuarioPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout());
		isAdmin = new JCheckBox("Es administrador?");
		add(isAdmin);
		add(agregar);
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarUnUsuario();
			}
		});

	}

	public AgregarUsuarioPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public AgregarUsuarioPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public AgregarUsuarioPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void agregarUnUsuario(){
		String nombre;
		nombre = JOptionPane.showInputDialog("Usuario");
		String password;
		password = JOptionPane.showInputDialog("password");
		if(isAdmin.isSelected()){
			UsuarioAdministrador usuarioAdministrador= new UsuarioAdministrador(nombre, password);
			AdministrarUsuarios.addUsuarioAdministrador(usuarioAdministrador);
		}else{
			UsuarioGeneral usuarioGeneral= new UsuarioGeneral(nombre, password);
			AdministrarUsuarios.addUsuarioGeneral(usuarioGeneral);
		}
		
	}

}
