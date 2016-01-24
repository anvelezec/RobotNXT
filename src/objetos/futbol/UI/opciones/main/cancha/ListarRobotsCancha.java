package objetos.futbol.UI.opciones.main.cancha;

import objetos.futbol.UI.OpcionEspecifica;
import objetos.futbol.UI.opciones.main.AdministrarCancha;
/**
 * Clase para listar robots en la cancha extiende de opcion especifica
 * @author luisa
 *
 */
public class ListarRobotsCancha extends OpcionEspecifica {

	/** 
	 * constructor para listar robots en cancha
	 */
	public ListarRobotsCancha() {
		super(true, true, "Listar todos los robots en la cancha", "Listar Robots en Cancha");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		imprimirNombre();
		imprimirDescription();
		listarRobots();
		volverAtras();
	}

	@Override
	public void volverAtras() {
		// TODO Auto-generated method stub

	}
	/**
	 * metodo para listar robots que se encuentran en la cancha
	 */
	public void listarRobots(){
		for (int i = 0; i < AdministrarCancha.getCancha().getRobots().size(); i++) {
			System.out.println(i+" "+AdministrarCancha.getCancha().getRobots().get(i).getConexionBT());
		}		
	}

}
