package objetos.futbol.UI;

import java.util.ArrayList;
import java.util.Scanner;

import objetos.futbol.UI.opciones.OpcionMain;
import objetos.futbol.varios.LecturaTeclado;

/**
 * clase para las opciones generales
 * @author luisa
 *
 */
public abstract class OpcionGeneral implements Opcion {

	private boolean isAdmin;
	private boolean isUsuario;
	private String descripcion;
	private String nombre;
	private ArrayList<Opcion> opciones;

	/**
	 * constructor para opcion general 
	 * @param isAdmin
	 * @param isUsuario
	 * @param descripcion
	 * @param nombre
	 * @param opciones
	 */
	public OpcionGeneral(boolean isAdmin, boolean isUsuario, String descripcion, String nombre,
			ArrayList<Opcion> opciones) {
		super();
		this.isAdmin = isAdmin;
		this.isUsuario = isUsuario;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.opciones = opciones;
	}

	/**
	 * devuelve true para darle un privilegio al administrador
	 * @return
	 */
	public boolean privilegiosAdministrador() {
		if (isUsuario) {
			return true;
		}
		return false;
	}

	/**
	 * devuelve true si el usuario administrador tiene el rpivilegio de hacer algun actividad 
	 * @return
	 */
	public boolean privilegiosUsuario() {
		if (isAdmin) {
			return true;
		}
		return false;
	}

	/*
	 * obtiene la descripcion de la opcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * dar le descripcion de una opcion 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * consulta el nombre de la opcion
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * da el nombre a una opcion 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** 
	 * devuelve true si el usuario es administrador
	 * @return
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/**
	 * crea un usuario admin 
	 * @param isAdmin
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	/** 
	 * devuelve true si el usuario es general
	 * @return
	 */
	public boolean isUsuario() {
		return isUsuario;
	}
	/**
	 * determina si el usuario es general
	 * @param isUsuario
	 */
	public void setUsuario(boolean isUsuario) {
		this.isUsuario = isUsuario;
	}

	/**
	 * consulta el array de opciones
	 * @return
	 */
	public ArrayList<Opcion> getOpciones() {
		return opciones;
	}

	/**
	 * introduce un array de opciones
	 * @param opciones
	 */
	public void setOpciones(ArrayList<Opcion> opciones) {
		this.opciones = opciones;
	}

	@Override
	public abstract void ejecutar();

	@Override
	public void imprimirNombre() {
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

	/**
	 * imprime las opciones del menu
	 */
	public void imprimirMenu() {
		eliminarOpcionesUsuario(OpcionMain.getUsuarioLogeado());
		imprimirNombre();
		imprimirDescription();
		for (int i = 0; i < opciones.size(); i++) {
			System.out.print(i + ". ");
			opciones.get(i).imprimirNombre();
		}
		System.out.print(opciones.size() + ". ");
		System.out.println("Volver atras");
	}

	/**
	 * ejecuta la opcion 
	 * @param i
	 */
	public void ejecutarOpcion(int i) {
		System.out.flush();
		opciones.get(i).ejecutar();
	}

	/**
	 * seleccionar opcion
	 */
	public void selecionarrOpcion() {

		System.out.println("Ingrese un numero de Opcion");
		int opcion = LecturaTeclado.scan.nextInt();

		if (opcion >= 0 && opcion < getOpciones().size()) {
			getOpciones().get(opcion).ejecutar();
		} else if (opcion == getOpciones().size()) {
			volverAtras();
		} else {
			System.out.println("Opcion Invalida");
		}
		// scan.close();
		// scan.close();

	}

	/**
	 * eliminar las opciones de usuarios
	 * @param usuario
	 */
	public void eliminarOpcionesUsuario(Usuario usuario) {
		for (int i = 0; i < this.opciones.size(); i++) {
			if (!opciones.get(i).forUser()) {
				if(usuario instanceof UsuarioGeneral){
					opciones.remove(i);
				}
			}
		}
		/*for (int i = 0; i < this.opciones.size(); i++) {
			if (!opciones.get(i).forAdmin()) {
				if(usuario instanceof UsuarioAdministrador){
					opciones.remove(i);
				}
			}
		}*/
	}

}
