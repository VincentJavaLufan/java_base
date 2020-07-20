package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestInt implements Runnable{
	static int count = 0;
//	static AtomicInteger count = null;
	
	@Override
	public void run() {
		Lock ll = new ReentrantLock();
		ll.lock();
		try {
			for(int i=0;i<100;i++) {
				count ++;
			}
		} catch (Exception e) {
		} finally {
			ll.unlock();
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestInt testInt = new TestInt();
		for(int i=0;i<100;i++) {
			new Thread(testInt).start();
			Thread.sleep(1);
		}
	}
}
