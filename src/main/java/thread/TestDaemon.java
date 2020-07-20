package thread;

public class TestDaemon {

	public static void main(String[] args) {
		Thread thread = new Thread(new God());
		thread.setDaemon(true);//默认是false表示是用户线程，正常的线程都是用户线程。
		thread.start();//守护线程
		
		new Thread(new You()).start();//用户线程
	}
}

class God implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("上帝保佑你！");
		}
	}
}

class You implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<365;i++) {
			System.out.println("开心的活着！");
		}
	}
}
