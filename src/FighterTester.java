
public class FighterTester {

	public static void main(String[] args) {
		
		Fighter rambo = new Fighter(1, 1);
		Robot pinko = new Robot(2, 1);
		Fighter rambo2 = new Fighter(1, 1);
		System.out.println(rambo2.toString());
		Fighter ramboC = rambo2.clone();
		System.out.println(ramboC.toString());
		Fighter rambo3 = new Fighter(1, 2);
		System.out.println(rambo.equals(rambo2));
		System.out.println(rambo.equals(rambo3));
		System.out.println(pinko.GetDamage());
		try {
			rambo.Attack(pinko);
		} catch (CriticalStatusException e) {
			System.out.println("Robot danneggiato per almeno il 75%!");
		} catch (InsufficientEnergyException e) {
			System.out.println("Energia Insufficiente!");
		}
		System.out.println(pinko.GetDamage());
		System.out.println(rambo);
	}
}
