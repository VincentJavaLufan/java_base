package pattern.factory.simplefactory.demo;

public class factory {

	public phone makePhone(String phoneName) {
		if(phoneName.equalsIgnoreCase("xiaomi")) {
			return new xiaomi();
		} else if(phoneName.equalsIgnoreCase("iphone")) {
			return new iphone();
		} else {
			return null;
		}
	}
}
