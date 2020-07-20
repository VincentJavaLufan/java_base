package thread;

public class TestJoin implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName() + "插队了" + i+ "--" + Thread.currentThread().getState());
		}
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new TestJoin());
		thread.start();
		
		for(int i=0;i<100;i++) {
			if(i==50) {
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + i + "--" + Thread.currentThread().getState());
		}
		
	}
}
