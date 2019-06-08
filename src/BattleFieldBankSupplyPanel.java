import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

/** Una classe che costruisce un pannello grafico con un banco di rifornimento
 * @author Carmelo Sottile
 */
public class BattleFieldBankSupplyPanel extends JPanel {

	/** Costruisce un pannello grafico con un banco di rifornimento inizializzato
	 */
	public BattleFieldBankSupplyPanel() {
		box = new Rectangle(0, 0, 60, 60);
		bankSupply = new BankSupplyComponent(10, 20);
	}
	
	/** Disegna e colora un pannello grafico con un banco di rifornimento
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(box);
		bankSupply.paintComponent(g);
	}
	
	private Rectangle box;
	private BankSupplyComponent bankSupply;
}
