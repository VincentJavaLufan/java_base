package thread.syn;

import java.util.ArrayList;
import java.util.List;
/**
 * List的线程不安全
 * 
 * @author Administrator
 *
 */
public class UnsafeList {

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10000;i++) {
			new Thread(()->{
				synchronized(list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		
		Thread.sleep(1);
		System.out.println(list.size());
	}
}
