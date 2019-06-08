import java.awt.*;
import java.io.Serializable;

/** Una classe che costruisce un ostacolo
 * @author Carmelo Sottile
 */
public class Obstacle implements Serializable{
	
	/** Costruisce un ostacolo con le coordinate x e y
	 * @param x la coordinata x
	 * @param y la coordinata y
	 */
	public Obstacle(int x, int y) {
		weight = 10;
		endurance = 10;
		position = new Point(x, y);
	}
	
	/** Ritorna il peso dell'ostacolo
	 * @return il peso
	 */
	public int GetWeight() {
		return weight;
	}
	
	/** Ritorna la resistenza dell'ostacolo
	 * @return la resistenza
	 */
	public int GetEndurance() {
		return endurance;
	}
	
	/** Ritorna la posizione dell'ostacolo
	 * @return la posizione
	 */
	public Point GetPosition() {
		return position;
	}
	
	/** Modifica la posizione dell'ostacolo
	 * @param a la nuova coordinata a
	 * @param b la nuova coordinata b
	 */
	public void ModifyPosition(int a, int b) {
		position.translate(a, b);
	}
	
	private int weight, endurance;
	private Point position;

}
