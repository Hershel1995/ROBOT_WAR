
public class ShieldTester {

	public static void main(String[] args) {

		Shield muro = new Shield();
		Shield muro2 = new Shield();
		System.out.println(muro.equals(muro2));
		System.out.println(muro.GetEndurance());
		System.out.println(muro.GetUsury());
		Sword sw = new Sword();
		muro.LessEndurance(sw);
		System.out.println(muro.GetEndurance());
		System.out.println(muro.equals(muro2));
		muro = muro2.clone();
		System.out.println(muro.GetEndurance());
		
	}

}
