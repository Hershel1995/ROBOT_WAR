import java.io.Serializable;

/** Una classe che costruisce una batteria per i robot
 * @author Carmelo Sottile
 */
public class Battery implements Serializable, Cloneable {
	
	/** Costruisce una batteria con energia a 100
	 */
	public Battery() {
		energy = 100;
	}
	
	/** Modifica l'energia della batteria
	 * @param newEnergy la nuova energia
	 */
	public void ModifyEnergy(double newEnergy) {
		energy = newEnergy;
	}
	
	/** Ritorna l'energia della batteria
	 * @return l'energia della batteria
	 */
	public double GetEnergyBattery() {
		return energy;
	}
	
	/** Riduce l'energia della batteria di 5 a causa del movimento
	 */
	public void LessEnergyMovement() {
		energy -= 5;
	}
	
	/** Riduce l'energia della batteria di 3 a causa dello spostamento
	 */
	public void LessEnergyShift() {
		energy -= 3;
	}
	
	/** Controlla se due batterie sono uguali
	 * @param otherObject l'oggetto da confrontare
	 * @return il risultato del controllo
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()) return false;
		Battery bt = (Battery) otherObject;
		return energy == bt.energy;
	}
	
	/** Crea una copia della batteria
	 * @return la batteria copiata
	 */
	public Battery clone(){
		try {
			return (Battery) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	private double energy;
}
