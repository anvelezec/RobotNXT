package objetos.futbol.UI.opciones.main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobots;
import objetos.futbol.UI.opciones.main.administrarRobot.ListarRobotsPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.AgregarUsuarioPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.EliminarUsuarioPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.ListarUsuariosPanel;

public class AdministrarUsuariosFrame extends JFrame {
	Container contenedor;
	ListarUsuariosPanel listarUsuarios = new ListarUsuariosPanel();
	AgregarUsuarioPanel agregarUsuario = new AgregarUsuarioPanel();
	EliminarUsuarioPanel eliminarUsuario = new EliminarUsuarioPanel();
	
	public AdministrarUsuariosFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Administrar Usuarios");
		setSize(400, 400);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor = getContentPane();

		contenedor.add(listarUsuarios);
		contenedor.add(agregarUsuario);
		contenedor.add(eliminarUsuario);


	}

	public AdministrarUsuariosFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public AdministrarUsuariosFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public AdministrarUsuariosFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public Container getContenedor() {
		return contenedor;
	}

	public void setContenedor(Container contenedor) {
		this.contenedor = contenedor;
	}

	public ListarUsuariosPanel getListarUsuarios() {
		return listarUsuarios;
	}

	public void setListarUsuarios(ListarUsuariosPanel listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}

	public AgregarUsuarioPanel getAgregarUsuario() {
		return agregarUsuario;
	}

	public void setAgregarUsuario(AgregarUsuarioPanel agregarUsuario) {
		this.agregarUsuario = agregarUsuario;
	}

	public EliminarUsuarioPanel getEliminarUsuario() {
		return eliminarUsuario;
	}

	public void setEliminarUsuario(EliminarUsuarioPanel eliminarUsuario) {
		this.eliminarUsuario = eliminarUsuario;
	}

}
