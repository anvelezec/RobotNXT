package objetos.futbol.UI;
/**
 * interface de opciones
 * @author luisa
 *
 */
public interface Opcion {
	
	/**
	 * ejecuta las opciones que seran heredados e implementados por los hijos
	 */
	public void ejecutar();
	
	/**
	 * metodo que es implementado por las clases hijas de la interfaz imprime el nombre la opcion
	 */
	public void imprimirNombre();
	
	/**
	 * metodo que es implementado por las clases hijas de la interfaz imprimir la descripcion de las opciones 
	 */
	public void imprimirDescription();
	/** 
	 * metodo que es implementado por las clases hijas de la interfaz y volver atras en el menu 
	 */
	public void volverAtras();
	/**
	 * metodo que es implementado por las clases hijas de la interfaz para definir el usuario gneral
	 * @return
	 */
	public boolean forUser();
	/** 
	 * metodo que es implementado por las clases hijas de la interfaz para definir el usuario administrador
	 * @return
	 */
	public boolean forAdmin();
	
}
