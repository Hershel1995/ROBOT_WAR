
import java.util.ArrayList;

/** Una classe che costruisce un robot lavoratore
 *  che può riparare altri robot e spostare ostacoli
 * @author Carmelo Sottile
 */
public class Worker extends Robot {
	
	/** Costruisce un robot con le coordinate x e y
	 *  e con le collezioni di batterie e utensili
	 * @param x la coordinata x
	 * @param y la coordinata y
	 * @param Tl la collezione di utensili
	 * @param Bt la collezione di batterie
	 */
	public Worker(int x, int y, ArrayList<Tool> Tl, ArrayList<Battery> Bt) {
		super(x, y);
		toolSet = Tl;
		batterySet = Bt;
	}
	
	/** Aggiunge una batteria ad un robot
	 * @param rb il robot a cui aggiungere una batteria
	 * @return il robot con la batteria nuova
	 */
	public Robot addBattery(Robot rb) {
		Battery bt = rb.GetBattery();
		bt.ModifyEnergy(100);
		rb.NewBattery(bt);
		batterySet.remove(0);
		return rb;
	}
	
	/** Ripara il danno del robot
	 * @param damage il vecchio danno
	 * @return il danno a zero
	 */
	public Robot Repair(Robot r) {
		r.NewDamage(0);;
		return r;
	}
	
	/** Sposta un ostacolo
	 * @param o l'ostacolo da spostare
	 * @return l'ostacolo spostato
	 * @throws InsufficientEnergyException
	 */
	public Obstacle Shift(Obstacle o) throws InsufficientEnergyException {
		Battery newBattery = this.GetBattery();
		if(newBattery.GetEnergyBattery() < 3) throw new InsufficientEnergyException();
		o.ModifyPosition(1, 1);
		newBattery.LessEnergyShift();
		this.NewBattery(newBattery);
		return o;
	}
	
	/** Ritorna la collezione di utensili
	 * @return la collezione di utensili
	 */
	public ArrayList<Tool> GetArrayTool() {
		return toolSet;
	}
	
	/** Ritorna la collezione di batterie
	 * @return la collezione di batterie
	 */
	public ArrayList<Battery> GetArrayBattery() {
		return batterySet;
	}
	
	/** Sostituisce la collezione di batterie
	 * @param batterySet la nuova collezione di batterie
	 */
	public void NewArrayBattery(ArrayList<Battery> batterySet) {
		this.batterySet = batterySet;
	}
	
	/** Sostituisce la collezione di utensili
	 * @param toolSet la nuova collezione di utensili
	 */
	public void NewArrayTool(ArrayList<Tool> toolSet) {
		this.toolSet = toolSet;
	}
	
	/** Traduce in stringa le informazioni del lavoratore
	 * @return la stringa delle informazioni
	 */
	public String toString() {
		return super.toString() + "[Set di Attrezzi = " + toolSet.size() + ", Set di Batterie = " + batterySet.size() + "]";
	}
	
	/** Controlla se due lavoratori sono uguali
	 * @param otherObject l'oggetto da confrontare
	 * @return il risultato del controllo
	 */
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		Worker w = (Worker) otherObject;
		return toolSet.equals(w.toolSet) && batterySet.equals(w.batterySet);
	}
	
	/** Crea una copia del lavoratore
	 * @return il lavoratore copiato
	 */
	public Worker clone(){
		 Worker cloned =(Worker)super.clone();
		 cloned.toolSet =(ArrayList<Tool>) toolSet.clone();
		 cloned.batterySet =(ArrayList<Battery>) batterySet.clone();
		 return cloned;
		 }
	
	private ArrayList<Tool> toolSet;
	private ArrayList<Battery> batterySet;
}