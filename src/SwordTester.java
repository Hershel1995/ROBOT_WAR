
public class SwordTester {

	public static void main(String[] args) {
		
		Sword falce = new Sword();
		System.out.println(falce.GetForce());
		System.out.println(falce.GetUsury());
		Sword falce2 = new Sword();
		System.out.println(falce.equals(falce2));
		Sword falceC = falce.clone();
		System.out.println(falceC.GetForce());
	}

}
