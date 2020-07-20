package thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * a测试juc安全类型集合
 * @author Administrator
 *
 */
public class TestJUC {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for(int i=0;i<10000;i++) {
			new Thread(
						()-> {
							list.add(Thread.currentThread().getName());
						}
					).start();
		}
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(list.size());
	}
}
