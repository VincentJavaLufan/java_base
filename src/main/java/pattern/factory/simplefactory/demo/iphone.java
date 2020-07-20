package pattern.factory.simplefactory.demo;

public class iphone implements phone{

		public iphone() {
			this.create();
		}
		@Override
		public void create() {
			System.out.println("create iphone");
			
		}
		
}
