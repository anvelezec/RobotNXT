package objetos.futbol.UI.opciones.main.administrarUsuarios;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetos.futbol.UI.UsuarioGeneral;
import objetos.futbol.UI.opciones.main.AdministrarJugadores;
import objetos.futbol.UI.opciones.main.AdministrarUsuarios;

public class ListarUsuariosPanel extends Panel {
	private JList<String> usuariosGenerales = new JList<String>();
	private JList<String> usuariosAdministradores = new JList<String>();
	
	public ListarUsuariosPanel() {
		setLayout(new GridLayout(1,2));
		//panel de usuarios Generales
		JPanel panelUsuariosAdministradores= new JPanel();
		panelUsuariosAdministradores.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelUsuariosAdministradores.setLayout(new BorderLayout());
		panelUsuariosAdministradores.add(new Label("Usuarios Administradores"), BorderLayout.NORTH);
		panelUsuariosAdministradores.add(usuariosAdministradores, BorderLayout.CENTER);
		//Panel de usuarios Administradores
		JPanel panelUsuariosGenerales= new JPanel();
		panelUsuariosGenerales.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelUsuariosGenerales.setLayout(new BorderLayout());
		panelUsuariosGenerales.add(new Label("Usuarios Generales"), BorderLayout.NORTH);
		panelUsuariosGenerales.add(usuariosGenerales, BorderLayout.CENTER);
		this.add(panelUsuariosAdministradores);
		this.add(panelUsuariosGenerales);
		cargarUsuarios();
	}

	public ListarUsuariosPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JList<String> getUsuariosGenerales() {
		return usuariosGenerales;
	}

	public void setUsuariosGenerales(JList<String> usuariosGenerales) {
		this.usuariosGenerales = usuariosGenerales;
	}

	public JList<String> getUsuariosAdministradores() {
		return usuariosAdministradores;
	}

	public void setUsuariosAdministradores(JList<String> usuariosAdministradores) {
		this.usuariosAdministradores = usuariosAdministradores;
	}
	
	public void cargarUsuarios(){
		this.usuariosGenerales.removeAll();
		this.usuariosAdministradores.removeAll();
		DefaultListModel<String> usuariosG= new DefaultListModel<String>();
		DefaultListModel<String> usuariosA= new DefaultListModel<String>();
		for (int i = 0; i < AdministrarUsuarios.getUsuarioGeneral().size(); i++) {
			usuariosG.addElement(AdministrarUsuarios.getUsuarioGeneral().get(i).getNombre());
		}
		usuariosGenerales.setModel(usuariosG);
		for (int i = 0; i < AdministrarUsuarios.getUsuarioAdministrador().size(); i++) {
			usuariosA.addElement(AdministrarUsuarios.getUsuarioAdministrador().get(i).getNombre());
		}
		usuariosAdministradores.setModel(usuariosA);
		usuariosGenerales.setModel(usuariosG);
		//AdministrarUsuarios.getUsuarioGeneral();
	}
	 

}
