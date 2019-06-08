import java.io.Serializable;

/** Una classe che costruisce uno scudo per un combattente
 * @author Carmelo Sottile
 */
public class Shield implements Serializable {

	/** Costruisce uno scudo con resistenza 8 e usura zero
	 */
	public Shield() {
		endurance = 8;
		usury = 0;
	}
	
	/** Ritorna la resistenza dello scudo
	 * @return la resistenza
	 */
	public double GetEndurance() {
		return endurance;
	}
	
	/** Ritorna l'usura dello scudo
	 * @return l'usura
	 */
	public double GetUsury() {
		return usury;
	}
	
	/** Aumenta l'usura dello scudo di 2
	 */
	public void MoreUsury() {
		usury += 2;
	}
	
	/** Diminuisce la resistenza dello scudo
	 * @param sw la spada che diminuisce la resistenza
	 */
	public void LessEndurance(Sword sw) {
		double potenza = sw.GetForce();
		if(endurance - potenza < 0) endurance = 0;
		else endurance = endurance - potenza;
		MoreUsury();
	}
	
	/** Controlla che due scudi sono uguali
	 * @param otherObject l'oggetto da confrontare
	 * @return il risultato del controllo
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()) return false;
		Shield sh = (Shield) otherObject;
		return endurance == sh.endurance && usury == sh.usury;
	}
	
	/** Crea una copia dello scudo
	 * @return lo scudo copiato
	 */
	public Shield clone() {
		Shield cloned = new Shield();
		cloned.usury = usury;
	 	cloned.endurance = endurance;
	 	return cloned;
	}
	
	private double endurance;
	private double usury;
}
