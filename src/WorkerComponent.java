import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/** Una classe che costruisce un robot lavoratore grafico
 * @author Carmelo Sottile
 */
public class WorkerComponent extends JComponent {

	/** Costruisce un robot lavoratore grafico con le coordinate x e y
	 * @param x la coordinata x dell'angolo in alto a sinistra del corpo
	 * @param y la coordinata y dell'angolo in alto a sinistra del corpo
	 */
	public WorkerComponent(int x, int y) {
		head = new Ellipse2D.Double(x+5, y-10, 10, 10);
		body = new Rectangle(x, y, 20, 30);
		arm1 = new Rectangle(x-10, y+5, 10, 10);
		arm2 = new Rectangle(x+20, y+5, 10, 10);
		wheel1 = new Ellipse2D.Double(x, y+30, 10, 10);
		wheel2 = new Ellipse2D.Double(x+10, y+30, 10, 10);
	}
	
	/** Disegna e colora un robot lavoratore grafico
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(body);
		g2.draw(wheel1);
		g2.draw(wheel2);
		g2.draw(head);
		g2.draw(arm1);
		g2.draw(arm2);
		g2.setColor(Color.BLUE);
		g2.fill(body);
		g2.fill(wheel1);
		g2.fill(wheel2);
		g2.fill(head);
		g2.fill(arm1);
		g2.fill(arm2);
	}
	
	
	private Rectangle body, arm1, arm2;
	private Ellipse2D.Double wheel1, wheel2, head;
}
