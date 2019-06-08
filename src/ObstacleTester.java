
public class ObstacleTester {

	public static void main(String[] args) {
		
		Obstacle o = new Obstacle(1, 1);
		System.out.println(o.GetEndurance());
		System.out.println(o.GetWeight());
		System.out.println(o.GetPosition());
		o.ModifyPosition(2, 2);
		System.out.println(o.GetPosition());

	}

}
