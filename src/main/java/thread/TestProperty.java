package thread;

public class TestProperty {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"-->" + Thread.currentThread().getPriority());
		MyProperty property = new MyProperty();
		
		Thread t1 = new Thread(property,"a");
		Thread t2 = new Thread(property,"b");
		Thread t3 = new Thread(property,"c");
		Thread t4 = new Thread(property,"d");
		Thread t5 = new Thread(property,"e");
		Thread t6 = new Thread(property,"f");
		
		t1.start();//默认优先级是5
		
		t2.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		
		t3.setPriority(1);
		t3.start();
		
		t4.setPriority(5);
		t4.start();
		
		t5.setPriority(Thread.NORM_PRIORITY);
		t5.start();
		
		t6.setPriority(Thread.MAX_PRIORITY);
		t6.start();
	}
}

class MyProperty implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->" + Thread.currentThread().getPriority());
	}
}