import java.awt.*;

public class RobotTester {

	public static void main(String[] args) {
		
		Robot pinko = new Robot(10, 20);
		Robot pinko2 = new Robot(10, 20);
		Robot pinko3 = new Robot(11, 22);
		System.out.println(pinko.toString());
		Robot pinkoC = pinko.clone();
		System.out.println(pinkoC.toString());
		System.out.println(pinko.equals(pinko2));
		System.out.println(pinko.equals(pinko3));
		Point p = pinko.GetMovement();
		System.out.println(p.x);
		System.out.println(p.y);
		System.out.println(pinko.GetEnergyRobot() + "%");
		System.out.println(pinko.GetDamage() + "%");
		try {
			pinko.MoveUp();
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(pinko.GetMovement());
		System.out.println(pinko.GetEnergyRobot() + "%");
		try {
			pinko.MoveDown();
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(pinko.GetMovement());
		System.out.println(pinko.GetEnergyRobot() + "%");
		try {
			pinko.MoveLeft();
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(pinko.GetMovement());
		System.out.println(pinko.GetEnergyRobot() + "%");
		try {
			pinko.MoveRight();
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(pinko.GetMovement());
		System.out.println(pinko.GetEnergyRobot() + "%");
		System.out.println(pinko.toString());
		pinko3.ModifyPosition(5, 4);
		System.out.println(pinko3.GetMovement());
		try {
			pinko3.MoveDown();
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(pinko3.GetEnergyRobot());
		pinko3.NewBattery(new Battery());
		System.out.println(pinko3.GetEnergyRobot());
		pinko3.NewDamage(0);
		System.out.println(pinko3.GetDamage());
	}

}
