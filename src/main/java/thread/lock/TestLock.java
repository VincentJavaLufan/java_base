package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public static void main(String[] args) {
		TestLock2 testLock2 = new TestLock2();
		new Thread(testLock2).start();
		new Thread(testLock2).start();
		new Thread(testLock2).start();
		new Thread(testLock2).start();
	}
}

class TestLock2 implements Runnable {
	int ticketNums = 30;
	
	//定义lock
	private final ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while(true) {
			try {
				lock.lock();
				if(ticketNums>0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(ticketNums--);
				} else {
					break;
				}
			} finally {
				lock.unlock();
			}
		}
	}
}