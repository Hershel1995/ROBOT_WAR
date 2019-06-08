import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/** Una classe che costruisce un banco di rifornimento grafico
 * @author Carmelo Sottile
 */
public class BankSupplyComponent extends JComponent {

	/** Costruisce il banco di rifornimento grafico
	 * @param x la coordinata x dell'angolo in alto a sinistra
	 * @param y la coordinata y dell'angolo in alto a sinistra
	 */
	public BankSupplyComponent(int x, int y) {
		bankSupply = new Rectangle(x, y, 40, 20);
	}
	
	/** Disegna e colora il banco di rifornimento grafico
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(bankSupply);
		g2.setColor(Color.GREEN);
		g2.fill(bankSupply);
	}
	
	private Rectangle bankSupply;
}
