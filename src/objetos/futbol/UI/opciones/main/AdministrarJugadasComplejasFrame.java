package objetos.futbol.UI.opciones.main;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.AgregarJugadaComplejaPanel;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.EliminarJugadaComplejaPanel;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.ListarJugadaComplejaPanel;

public class AdministrarJugadasComplejasFrame extends JFrame {
	Container contenedor;
	ListarJugadaComplejaPanel listarJugadasComplejas = new ListarJugadaComplejaPanel();
	AgregarJugadaComplejaPanel agregarJugadasComplejas = new AgregarJugadaComplejaPanel();
	EliminarJugadaComplejaPanel eliminarJugadasComplejas = new EliminarJugadaComplejaPanel();
	public AdministrarJugadasComplejasFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Administrar Jugadas Complejas");
		setSize(900, 800);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor = getContentPane();
		

		contenedor.add(listarJugadasComplejas);
		contenedor.add(agregarJugadasComplejas);
		contenedor.add(eliminarJugadasComplejas);
	}

	public AdministrarJugadasComplejasFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public AdministrarJugadasComplejasFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public AdministrarJugadasComplejasFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadaComplejaPanel getListarJugadasComplejas() {
		return listarJugadasComplejas;
	}

	public void setListarJugadasComplejas(ListarJugadaComplejaPanel listarJugadasComplejas) {
		this.listarJugadasComplejas = listarJugadasComplejas;
	}

	
	

}
