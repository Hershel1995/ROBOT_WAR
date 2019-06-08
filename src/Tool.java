import java.io.Serializable;

/** Una classe che costruisce un'utensile
 * @author Carmelo Sottile
 */
public class Tool implements Serializable{

	/** Costruisce un utensile con usura a zero
	 */
	public Tool() {
		usury = 0;
	}
	
	/** Ritorna l'usura dell'utensile
	 * @return l'usura
	 */
	public double GetUsury() {
		return usury;
	}
	
	/** Aumenta l'usura dell'utensile di 3
	 */
	public void MoreUsury() {
		usury += 3;
	}
	
	private double usury;
}
