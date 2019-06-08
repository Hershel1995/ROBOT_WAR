import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/** Una classe che costruisce un ostacolo grafico
 * @author Carmelo Sottile
 */
public class ObstacleComponent extends JComponent {

	/** Costruisce un ostacolo grafico con le coordinate x e y
	 * @param x la coordinata x dell'angolo in alto a sinistra
	 * @param y la coordinata y dell'angolo in alto a sinistra
	 */
	public ObstacleComponent(int x, int y) {
		obstacle = new Rectangle(x, x, 30, 30);
	}
	
	/** Disegna e colora un ostacolo grafico
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(obstacle);
		g2.setColor(Color.YELLOW);
		g2.fill(obstacle);
	}
	
	private Rectangle obstacle;
}
