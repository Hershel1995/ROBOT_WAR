import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

/** Una classe che costruisce un pannello grafico vuoto
 * @author Carmelo Sottile
 */
public class BattleFieldEmptyPanel extends JPanel {

	/** Costruisce un pannello grafico vuoto inizializzando un rettangolo
	 */
	public BattleFieldEmptyPanel() {
		box = new Rectangle(0, 0, 60, 60);
	}
	
	/** Disegna e colora il pannello grafico vuoto
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(box);
	}
	
	private Rectangle box;
}
