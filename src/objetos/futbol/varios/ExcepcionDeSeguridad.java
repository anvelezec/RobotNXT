package objetos.futbol.varios;

public class ExcepcionDeSeguridad extends Exception {

	public ExcepcionDeSeguridad(String message) {
	        super("Falta de privilegios de usuario, "+message);
	    }

}
