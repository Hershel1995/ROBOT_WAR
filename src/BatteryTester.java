
public class BatteryTester {

	public static void main(String[] args) {
		
		Battery samsung = new Battery();
		System.out.println(samsung.GetEnergyBattery());
		Battery samsung2 = new Battery();
		Battery samsungC = samsung.clone();
		System.out.println(samsungC.GetEnergyBattery());
		System.out.println(samsung.GetEnergyBattery() + "%");
		System.out.println(samsung.equals(samsung2));
		samsung.ModifyEnergy(0);
		System.out.println(samsung.equals(samsung2));
	}

}
