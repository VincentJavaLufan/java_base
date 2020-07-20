package pattern.factory.simplefactory.demo;

public class xiaomi implements phone{

	public xiaomi() {
		this.create();
	}
	@Override
	public void create() {
		System.out.println("create xiaomi");
		
	}
	
}
