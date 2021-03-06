package thread;

import java.util.concurrent.Callable;

public class ThreadDemo03 implements Callable<Boolean>{

	 public static void main(String[] args) {
		ThreadDeom01 TD1 = new ThreadDeom01();//创建runnable接口的实现类对象。
		Thread t1 = new Thread(TD1);//创建线程对象，通过线程对象来开启我们的线程，代理。
		t1.setName("myThread");
		t1.start();
//		try {
//			t1.wait();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("currentThread:" + Thread.currentThread());
	}
	 
	@Override
	public Boolean call() throws Exception {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			System.out.println("currentThread:" + Thread.currentThread().getName());
		}
		return null;
	}
}
