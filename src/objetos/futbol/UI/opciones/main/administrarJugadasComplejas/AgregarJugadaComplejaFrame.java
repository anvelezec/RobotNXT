package objetos.futbol.UI.opciones.main.administrarJugadasComplejas;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarJugadasComplejas;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja.AgregarJugadaPrimitivaPanel;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja.EliminarJugadaPrimitivaPanel;
import objetos.futbol.UI.opciones.main.administrarJugadasComplejas.agregarJugadaCompleja.ListarJugadasPrimitivasPanel;

public class AgregarJugadaComplejaFrame extends JFrame {
	Container contenedor;
	ListarJugadasPrimitivasPanel listarJugadasPrimitivas = new ListarJugadasPrimitivasPanel();
	AgregarJugadaPrimitivaPanel  agregarJugadaPrimitiva = new AgregarJugadaPrimitivaPanel();
	EliminarJugadaPrimitivaPanel eliminarJugadaPrimitiva = new EliminarJugadaPrimitivaPanel();
	public AgregarJugadaComplejaFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Agregar Jugada Compleja");
		setSize(600, 600);
		setLocation(0, 0);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	        	if(AgregarJugadaCompleja.getJugadaCompleja()!=null)
	        	AdministrarJugadasComplejas.agregarJugadaCompleja(AgregarJugadaCompleja.getJugadaCompleja());
	        }
	    });
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor = getContentPane();
		

		contenedor.add(listarJugadasPrimitivas);
		contenedor.add(agregarJugadaPrimitiva);
		contenedor.add(eliminarJugadaPrimitiva);
	}

	public AgregarJugadaComplejaFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public AgregarJugadaComplejaFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public AgregarJugadaComplejaFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public ListarJugadasPrimitivasPanel getListarJugadasPrimitivas() {
		return listarJugadasPrimitivas;
	}

	public void setListarJugadasPrimitivas(ListarJugadasPrimitivasPanel listarJugadasPrimitivas) {
		this.listarJugadasPrimitivas = listarJugadasPrimitivas;
	}
	
	

}
