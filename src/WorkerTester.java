import java.util.ArrayList;

public class WorkerTester {

	public static void main(String[] args) {
		
		ArrayList<Tool> Tl= new ArrayList<Tool>();
		ArrayList<Battery> Bt = new ArrayList<Battery>();
		for(int i=0; i<5; i++) {
			Tl.add(new Tool());
		}
		for(int i=0; i<5; i++) {
			Bt.add(new Battery());
		}
		Worker w = new Worker(5, 4, Tl, Bt);
		Worker w2 = new Worker(5, 4, Tl, Bt);
		Worker w3 = new Worker(2, 3, Tl, Bt);
		System.out.println(w3);
		Worker w4C = w3.clone();
		System.out.println(w4C);
		System.out.println(w.equals(w2));
		System.out.println(w.equals(w3));
		Battery b = new Battery();
		b.LessEnergyMovement();
		double x = b.GetEnergyBattery();
		System.out.println(x);
		//b = w.addBattery(b);
		x = b.GetEnergyBattery();
		System.out.println(x);
		System.out.println(w.toString());
		Robot r1 = new Robot(0, 0);
		try {
			r1.MoveDown();
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(r1.GetEnergyRobot());
		r1 = w.addBattery(r1);
		System.out.println(r1.GetEnergyRobot());
		r1.NewDamage(5);
		System.out.println(r1.GetDamage());
		r1 = w.Repair(r1);
		System.out.println(r1.GetDamage());
		Obstacle o = new Obstacle(0, 0);
		System.out.println(o.GetPosition());
		try {
			o = w.Shift(o);
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(o.GetPosition());
		

	}

}
