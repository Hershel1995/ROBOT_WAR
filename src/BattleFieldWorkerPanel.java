import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

/** Una classe che costruisce un pannello grafico con un lavoratore
 * @author Carmelo Sottile
 */
public class BattleFieldWorkerPanel extends JPanel {

	/** Costruisce un pannello grafico con un lavoratore inizializzato
	 */
	public BattleFieldWorkerPanel() {
		box = new Rectangle(0, 0, 60, 60);
		worker = new WorkerComponent(20, 15);
	}
	
	/** Disegna e colora un pannello grafico con un lavoratore
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(box);
		worker.paintComponent(g);
	}
	
	private Rectangle box;
	private WorkerComponent worker;
}
