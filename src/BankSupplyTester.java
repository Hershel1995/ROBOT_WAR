import java.util.ArrayList;

public class BankSupplyTester {

	public static void main(String[] args) {
		
		BankSupply bs = new BankSupply(5, 5);
		System.out.println(bs.GetPosition());
		Robot rb = new Robot(1, 1);
		try {
			rb.MoveDown();
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia insufficente!");
		}
		System.out.println(rb.GetEnergyRobot());
		rb = bs.RechargeEnergy(rb);
		System.out.println(rb.GetEnergyRobot());
		ArrayList<Battery> batterySet = new ArrayList<Battery>();
		for(int i=0; i<3; i++) {
			batterySet.add(new Battery());
		}
		ArrayList<Tool> toolSet = new ArrayList<Tool>();
		for(int i=0; i<5; i++) {
			toolSet.add(new Tool());
		}
		Worker w = new Worker(0, 0, toolSet, batterySet);
		System.out.println(w.toString());
		w = bs.FillArrayBattery(w);
		System.out.println(w.toString());

	}

}
