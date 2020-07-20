package java8;

public class BooleanDemo {

	public static void main(String[] args) {
		boolean aa = true;
		boolean bb = false;
		bb |= aa; // bb = bb|aa;
		System.out.println(bb);
		bb = bb|aa;
		System.out.println(bb);
		
		int ii = 1;
		int ee = 3;
		ii |= ee;
		System.out.println(ii);
	}
}
