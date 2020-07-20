package thread;

public class TestState implements Runnable{
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()-> {
			for(int i=0;i<100;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("/////");
		});
		
		//观察状态
		Thread.State state = thread.getState();
		System.out.println(state);
		
		thread.start();
		state = thread.getState();
		System.out.println("start:" + state);
		
		while(state != thread.getState().TERMINATED) {//只要线程不终止，就一直输出状态
			Thread.sleep(100);
			state = thread.getState();//更新线程状态
			System.out.println(state);
		}
		thread.getState();
		thread.start();//已经终止的线程是无法启动的
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "启动了");
	}
}
