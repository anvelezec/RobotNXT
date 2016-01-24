package objetos.futbol.UI;
/**
 * clase para definir las opciones de bajo nivel 
 * @author luisa
 *
 */
public abstract class OpcionEspecifica implements Opcion {
	private boolean isAdmin;
	private boolean isUsuario;
	private String descripcion;
	private String nombre;
	
	/**
	 * construtor de opcion especifica
	 * @param isAdmin
	 * @param isUsuario
	 * @param descripcion
	 * @param nombre
	 */
	public OpcionEspecifica(boolean isAdmin, boolean isUsuario, String descripcion, String nombre) {
		super();
		this.isAdmin = isAdmin;
		this.isUsuario = isUsuario;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	@Override
	public abstract void ejecutar();

	@Override
	public void imprimirNombre() {
		// TODO Auto-generated method stub
		System.out.println(nombre);

	}

	@Override
	public void imprimirDescription() {
		// TODO Auto-generated method stub
		System.out.println(descripcion);
	}

	@Override
	public abstract void volverAtras();
	
	@Override
	public boolean forUser() {
		if (isUsuario) {
			return true;
		}
		return false;
	}

	@Override
	public boolean forAdmin() {
		if (isAdmin) {
			return true;
		}
		return false;
	}


}
