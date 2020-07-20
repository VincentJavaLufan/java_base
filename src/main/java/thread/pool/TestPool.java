package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池
 * @author Administrator
 *
 */
public class TestPool {

	public static void main(String[] args) {
		//创建服务，创建线程池
		ExecutorService service = Executors.newFixedThreadPool(3);//参数为线程池大小
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		
		//关闭连接
		service.shutdown();
	}
}

class MyThread implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
	}
}
