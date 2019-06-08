
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/** Una classe che costruisce un banco di rifornimento per i robot
 * @author Carmelo Sottile
 */
public final class BankSupply implements Serializable {
	
	/** Costruisce un banco di rifornimento con le coordinate x e y
	 * @param x la coordinata x
	 * @param y la coordinata y
	 */
	public BankSupply(int x, int y) {
		position = new Point(x, y);
	}
	
	/** Ricarica l'energia del robot
	 * @param rb il robot da ricaricare
	 * @return il robot ricaricato
	 */
	public Robot RechargeEnergy(Robot rb) {
		Battery bt = rb.GetBattery();
		bt.ModifyEnergy(100);
		rb.NewBattery(bt);
		return rb;
	}
	
	/** Riempie la collezione di utensili di un lavoratore
	 * @param wk il lavoratore a cui riempire la collezione di utensili
	 * @return il lavoratore con la collezione di utensili piena
	 */
	public Worker FillArrayTool(Worker wk) {
		ArrayList<Tool> toolSet = new ArrayList<Tool>();
		for(int i=0; i<5; i++) {
			toolSet.add(new Tool());
		}
		wk.NewArrayTool(toolSet);
		return wk;
	}
	
	/** Riempie la collezione di batterie di un lavoratore
	 * @param wk il lavoratore a cui riempire la collezione di batterie
	 * @return il lavoratore con la collezione di batterie piena
	 */
	public Worker FillArrayBattery(Worker wk) {
		ArrayList<Battery> batterySet = new ArrayList<Battery>();
		for(int i=0; i<5; i++) {
			batterySet.add(new Battery());
		}
		wk.NewArrayBattery(batterySet);
		return wk;
	}
	
	/** Ritorna la posizione del banco di rifornimento
	 * @return la posizione del banco di rifornimento
	 */
	public Point GetPosition() {
		return position;
	}
	
	private final Point position;
}
