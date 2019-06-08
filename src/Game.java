import java.io.IOException;

import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) throws IOException {

		JFrame myFrame = new MainFrame();
		myFrame.setTitle("Robot War");
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}
}
