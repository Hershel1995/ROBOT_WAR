
/** Una classe che costruisce un robot
 *  combattente che può attaccare altri robot
 * @author Carmelo Sottile
 */
public class Fighter extends Robot {
	
	/** Costruisce un robot con le coordinate x e y
	 * @param x la coordinata x
	 * @param y la coordinata y
	 */
	public Fighter(int x, int y) {
		super(x, y);
		mySword = new Sword();
		myShield = new Shield();
	}
	
	/** Permette di attaccare un altro robot
	 * @param rb il robot da attaccare 
	 * @return il robot attaccato
	 * @throws InsufficientEnergyException
	 * @throws CriticalStatusException
	 */
	public Robot Attack(Robot rb) throws InsufficientEnergyException, CriticalStatusException {
		Battery newBattery = this.GetBattery();
		if(newBattery.GetEnergyBattery() < 3) throw new InsufficientEnergyException();
		double potenza = mySword.GetForce();
		double resistenza = myShield.GetEndurance();
		double danno = potenza - resistenza;
		if(danno >= 75) throw new CriticalStatusException();
		rb.NewDamage(danno);
		newBattery.LessEnergyMovement();
		this.NewBattery(newBattery);
		return rb;
	}
	
	/** Traduce in stringa le informazioni del
	 *  robot combattente
	 *  @return la stringa delle informazioni
	 */
	public String toString() {
		return super.toString() + "[Potenza della spada = " + mySword.GetForce() + ", Resistenza dello scudo = " + myShield.GetEndurance() + "]";
	}
	
	/** Controlla se due combattenti sono uguali
	 * @param otherObject l'oggetto da confrontare
	 * @return il risultato del controllo
	 */
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		Fighter f = (Fighter) otherObject;
		return mySword.equals(f.mySword) && myShield.equals(f.myShield);
	}
	
	/** Crea una copia del combattente
	 * @return il combattente copiato
	 */
	public Fighter clone() {
		Fighter cloned = (Fighter) super.clone();
		cloned.mySword = mySword.clone();
		cloned.myShield = myShield.clone();
		return cloned;
	}
	
	private Sword mySword;
	private Shield myShield;
}
