package thread;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

/**
 * 多个线程同时操作同一个对象
 * @author Administrator
 *
 */
public class TestThreadBuytickets implements Runnable{
	
	private int ticketNum = 10;

	@Override
	public synchronized void run() {
		while(true) {
			if(ticketNum<=0) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNum-- + "票" +
					Thread.currentThread().getState());
		}
	}
	
	public static void main(String[] args) {
		TestThreadBuytickets ticke = new TestThreadBuytickets();
		new Thread(ticke,"小明").start();
		new Thread(ticke,"小红").start();
		new Thread(ticke,"黄牛").start();
	}

}
