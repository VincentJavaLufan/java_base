package thread;

/**
 * https://blog.csdn.net/hebtu666/article/details/102696811
 * @author Administrator
 *
 */
public class ThreadDemo02 extends Thread{

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("current Thread name:" + Thread.currentThread().getName());
			System.out.println("current Thread Priority:" + Thread.currentThread().getPriority());
		}
	}
	public static void main(String[] args) {
		ThreadDemo02 t1 = new ThreadDemo02();
		t1.start();
		
		for(int i=0;i<100;i++) {
			System.out.println(i);
		}
	}

}
