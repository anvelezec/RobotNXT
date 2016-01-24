package objetos.futbol.UI.opciones.main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import objetos.futbol.UI.opciones.main.administrarJugadores.AgregarJugadaComplejaJugadorPanel;
import objetos.futbol.UI.opciones.main.administrarJugadores.AgregarJugadorPanel;
import objetos.futbol.UI.opciones.main.administrarJugadores.EliminarJugadorPanel;
import objetos.futbol.UI.opciones.main.administrarJugadores.ListarJugadoresPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.AgregarUsuarioPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.EliminarUsuarioPanel;
import objetos.futbol.UI.opciones.main.administrarUsuarios.ListarUsuariosPanel;

public class AdministrarJugadoresFrame extends JFrame {
	Container contenedor;
	
	

	
	ListarJugadoresPanel listarJugadores = new ListarJugadoresPanel();
	AgregarJugadorPanel agregarJugadores = new AgregarJugadorPanel();
	EliminarJugadorPanel eliminarJugadores = new EliminarJugadorPanel();
	AgregarJugadaComplejaJugadorPanel complejaJugadorPanel = new AgregarJugadaComplejaJugadorPanel();
	
	public AdministrarJugadoresFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Administrar jugadores");
		setSize(400, 400);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor = getContentPane();
		
		contenedor.add(listarJugadores);
		contenedor.add(agregarJugadores);
		contenedor.add(eliminarJugadores);
		contenedor.add(complejaJugadorPanel);

	}

	public AdministrarJugadoresFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Container getContenedor() {
		return contenedor;
	}

	public void setContenedor(Container contenedor) {
		this.contenedor = contenedor;
	}

	public AdministrarJugadoresFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public AdministrarJugadoresFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadoresPanel getListarJugadores() {
		return listarJugadores;
	}

	public void setListarJugadores(ListarJugadoresPanel listarJugadores) {
		this.listarJugadores = listarJugadores;
	}

	public AgregarJugadorPanel getAgregarJugadores() {
		return agregarJugadores;
	}

	public void setAgregarJugadores(AgregarJugadorPanel agregarJugadores) {
		this.agregarJugadores = agregarJugadores;
	}

	public EliminarJugadorPanel getEliminarJugadores() {
		return eliminarJugadores;
	}

	public void setEliminarJugadores(EliminarJugadorPanel eliminarJugadores) {
		this.eliminarJugadores = eliminarJugadores;
	}
	
	public AgregarJugadaComplejaJugadorPanel getAddJugadaComplejaJugador() {
		return complejaJugadorPanel;
	}

	public void setAddJugadaComplejaJugador(AgregarJugadaComplejaJugadorPanel complejaJugadorPanel) {
		this.complejaJugadorPanel = complejaJugadorPanel;
	}

	public AgregarJugadaComplejaJugadorPanel getComplejaJugadorPanel() {
		return complejaJugadorPanel;
	}

	public void setComplejaJugadorPanel(AgregarJugadaComplejaJugadorPanel complejaJugadorPanel) {
		this.complejaJugadorPanel = complejaJugadorPanel;
	}

}
