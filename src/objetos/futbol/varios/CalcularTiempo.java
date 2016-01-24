package objetos.futbol.varios;

import java.util.ArrayList;

/**
 * Clase para calcular el tiempó que transcurre en el partido
 * @author luisa
 *
 */
public class CalcularTiempo {

	ArrayList<Long> timeStart = new ArrayList<Long>();
	ArrayList<Long> timeEnd = new ArrayList<Long>();

	/**
	 * retorna el tamaño del array de timestart
	 * @return
	 */
	public int getsizeTimeStart() {
		return timeStart.size();
	}

	/**
	 * retorna el tamno del array del timeend
	 * @return
	 */
	public int getsizeTimeEnd() {
		return timeEnd.size();
	}

	/**
	 * retorna el array de Timestar
	 * @return
	 */
 	public ArrayList<Long> getTimeStart() {
		return timeStart;
	}
 	/**
 	 * introducimos un array para darle valores al array del timestart
 	 * @param timeStart
 	 */
	public void setTimeStart(ArrayList<Long> timeStart) {
		this.timeStart = timeStart;
	}

	/** 
	 * agregamos tiempo inicial en milisegundos al array de timestart
	 */
	public void agregarTiempoInicial() {
		this.timeStart.add(System.currentTimeMillis());
	}

	/**
	 * agregamos un tiempo final en milisegundos al array timestart
	 */
	public void agregarTiempoFinal() {
		this.timeStart.add(System.currentTimeMillis());
	}

	/**
	 * quitamos el tiempo inicial en milisegundos del array timestart
	 */
	public void removerTiempoInicial() {
		this.timeStart.remove(System.currentTimeMillis());
	}

	/**
	 * quitamos el tiempo final en milisegundos del array timestart
	 */
	public void removerTiempoFinal() {
		this.timeStart.remove(System.currentTimeMillis());
	}

	/**
	 * nos devuelve un arraylist de timeend
	 * @return
	 */
	public ArrayList<Long> getTimeEnd() {
		return timeEnd;
	}

	/**
	 * introducimos un arraylist que da valor a timeend
	 * @param timeEnd
	 */
	public void setTimeEnd(ArrayList<Long> timeEnd) {
		this.timeEnd = timeEnd;
	}

	
	/**
	 * calculamos el tiempo que ha transcurrido el partido hasta un punto en especifico
	 * @return Tiempo transcurrido de partido
	 */
	public long calculoTiempo() {
		long tiempo = 0;
		
			for (int i = 0; i < getTimeStart().size() - 1; i++) {
				tiempo = tiempo + (getTimeEnd().get(i) - getTimeStart().get(i));
			}
			
			tiempo= tiempo+(System.currentTimeMillis() - getTimeStart().get(getTimeStart().size()));
		

		return tiempo;
	}

	

}
