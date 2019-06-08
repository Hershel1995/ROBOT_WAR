
/** Un'eccezione controllata che � lanciata quando
 *  il robot non ha pi� energia sufficiente per
 *  compiere azioni.
 * @author Carmelo Sottile
 */
public class InsufficientEnergyException extends Exception{

	/** Costruisce l'eccezione con un messaggio di default
	 */
	public InsufficientEnergyException() {
		super("Energia insufficiente!");
	}
	
	/** Costruisce l'eccezione con un messaggio dato dall'utente
	 * @param msg il messaggio dell'eccezione
	 */
	public InsufficientEnergyException(String msg) {
		super(msg);
	}
}
