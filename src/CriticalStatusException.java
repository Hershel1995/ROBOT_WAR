
/** Un'eccezione non controllata che è lanciata
 *  quando il robot è danneggiato per il 75%
 * @author Carmelo Sottile
 */
public class CriticalStatusException extends RuntimeException {

	/** Costruisce l'eccezione con un messaggio di default
	 */
	public CriticalStatusException() {
		super("Robot danneggiato per almeno il 75%!");
	}
	
	/** Costruisce l'eccezione con un messaggio dato dall'utente
	 * @param msg il messaggio dell'eccezione
	 */
	public CriticalStatusException(String msg) {
		super(msg);
	}
}
