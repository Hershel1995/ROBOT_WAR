import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

/** Una classe che costruisce un pannello grafico con un ostacolo
 * @author Carmelo Sottile
 */
public class BattleFieldObstaclePanel extends JPanel {

	/** Costruisce un pannello grafico con un ostacolo inizializzato
	 */
	public BattleFieldObstaclePanel() {
		box = new Rectangle(0, 0, 60, 60);
		obstacle = new ObstacleComponent(15, 10);
	}
	
	/** Disegna e colora un pannello grafico con un ostacolo
	 * @param g il disegnatore
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.draw(box);
		obstacle.paintComponent(g);
	}
	
	private Rectangle box;
	private ObstacleComponent obstacle;
}
