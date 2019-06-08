import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/** Una classe che costruisce un robot combattente grafico
 * @author Carmelo Sottile
 */
public class FighterComponent extends JComponent {

	/** Costruisce un robot combattente grafico con le coordinate x e y
	 * @param x la coordinata x dell'angolo in alto a destra del corpo
	 * @param y la coordinata y dell'angolo in alto a destra del corpo
	 */
	public FighterComponent(int x, int y) {
		head = new Ellipse2D.Double(x+5, y-10, 10, 10);
		body = new Rectangle(x, y, 20, 30);
		sword = new Rectangle(x-15, y+5, 15, 10);
		shield = new Ellipse2D.Double(x+20, y+5, 10, 15);
		wheel1 = new Ellipse2D.Double(x, y+30, 10, 10);
		wheel2 = new Ellipse2D.Double(x+10, y+30, 10, 10);
	}
	
	/** Disegna e colora il robot combattente grafico
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(body);
		g2.draw(wheel1);
		g2.draw(wheel2);
		g2.draw(head);
		g2.draw(sword);
		g2.draw(shield);
		g2.setColor(Color.RED);
		g2.fill(body);
		g2.fill(wheel1);
		g2.fill(wheel2);
		g2.fill(head);
		g2.fill(sword);
		g2.fill(shield);
	}
	
	
	private Rectangle body, sword;
	private Ellipse2D.Double wheel1, wheel2, head, shield;
}
