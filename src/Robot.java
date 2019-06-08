import java.awt.*;
import java.io.Serializable;

/** Una classe che costruisce un 
 *  robot che può muoversi
 * @author Carmelo Sottile
 */
public class Robot implements Serializable, Cloneable {
	
	/** Costruisce un robot con le coordinate x e y
	 * @param x la coordinata x
	 * @param y la coordinata y
	 */
	public Robot(int x, int y) {
		battery = new Battery();
		damage = 0;
		position = new Point(x, y);
	}
	
	/** Costruisce un robot con la posizione
	 * @param p la posizione del robot
	 */
	public Robot(Point p) {
		battery = new Battery();
		damage = 0;
		position = p;
	}
	
	/** Muove il robot in alto
	 * @throws InsufficientEnergyException
	 */
	public void MoveUp() throws InsufficientEnergyException {
		if(battery.GetEnergyBattery() < 5) throw new InsufficientEnergyException();
		position.translate(-1, 0);
		battery.LessEnergyMovement();
	}
	
	/** Muove il robot in basso
	 * @throws InsufficientEnergyException
	 */
	public void MoveDown() throws InsufficientEnergyException {
		if(battery.GetEnergyBattery() < 5) throw new InsufficientEnergyException();
		position.translate(1, 0);
		battery.LessEnergyMovement();
	}
	
	/** Muove il robot a sinistra
	 * @throws InsufficientEnergyException
	 */
	public void MoveLeft() throws InsufficientEnergyException {
		if(battery.GetEnergyBattery() < 5) throw new InsufficientEnergyException();
		position.translate(0, -1);
		battery.LessEnergyMovement();
	}
	
	/** Muove il robot a destra
	 * @throws InsufficientEnergyException
	 */
	public void MoveRight() throws InsufficientEnergyException {
		if(battery.GetEnergyBattery() < 5) throw new InsufficientEnergyException();
		position.translate(0, 1);
		battery.LessEnergyMovement();
	}
	
	/** Ritorna la posizione del robot
	 * @return la posizione corrente del robot
	 */
	public Point GetMovement() {
		return position;
	}
	
	/** Modifica la posizione del robot
	 * @param x la nuova coordinata x
	 * @param y la nuova coordinata y
	 */
	public void ModifyPosition(int x, int y) {
		position.x = x;
		position.y = y;
	}
	
	/** Ritorna l'energia del robot
	 * @return l'energia della batteria del robot
	 */
	public double GetEnergyRobot() {
		return battery.GetEnergyBattery();
	}
	
	/** Ritorna il danno del robot
	 * @return il danno corrente del robot
	 */
	public double GetDamage() {
		return damage;
	}
	
	/** Ritorna la batteria del robot
	 * @return la batteria corrente del robot
	 */
	public Battery GetBattery() {
		return battery;
	}
	
	/** Sostituisce la batteria al robot
	 * @param battery la batteria nuova
	 */
	public void NewBattery(Battery battery) {
		this.battery = battery;
	}
	
	/** Sostituisce il danno al robot
	 * @param damage il nuovo danno
	 */
	public void NewDamage(double damage) {
		this.damage = damage;
	}
	
	/** Traduce in stringa le informazioni del robot
	 * @return la stringa delle informazioni
	 */
	public String toString() {
		return getClass().getName() + "[Batteria = " + this.GetEnergyRobot() + ", Danno = " + damage + ", Posizione = " + position + "]";
	}
	
	/** Controlla se due robot sono uguali
	 * @param otherObject l'oggetto da confrontare
	 * @return il risultato del controllo
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()) return false;
		Robot rb = (Robot) otherObject;
		return battery.equals(rb.battery)&& damage == rb.damage && position.equals(rb.position);
	}
	
	/** Crea una copia del robot
	 * @return il robot copiato
	 */
	public Robot clone() {
		try {
			return (Robot) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	 
	private double damage;
	private Point position;
	private Battery battery;
}
