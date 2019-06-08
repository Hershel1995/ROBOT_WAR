import java.io.Serializable;

/** Una classe che costruisce una spada per un combattente
 * @author Carmelo Sottile
 */
public class Sword implements Serializable{

	/** Costruisce una spada con forza 10 e usura zero
	 */
	public Sword() {
		force = 10;
		usury = 0;
	}
	
	/** Ritorna la forza della spada
	 * @return la forza
	 */
	public double GetForce() {
		return force;
	}
	
	/** Ritorna l'usura della spada
	 * @return l'usura
	 */
	public double GetUsury() {
		return usury;
	}
	
	/** Aumenta l'usura della spada di 2
	 */
	public void MoreUsury() {
		usury += 2;
	}
	
	/** Controlla che due spade sono uguali
	 * @param otherObject l'oggetto da confrontare
	 * @return il risultato del controllo
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()) return false;
		Sword sw = (Sword) otherObject;
		return usury == sw.usury && force == sw.force;
	}
	
	/** Crea una copia della spada
	 * @return la spada copiata
	 */
	public Sword clone() {
		Sword cloned = new Sword();
		cloned.force = force;
		cloned.usury = usury;
		return cloned;
	}
	
	private double usury;
	private double force;
}
