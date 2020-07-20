package thread.syn;

/**
 * 死锁
 * @author Administrator
 *
 */
public class DeadLock {
	public static void main(String[] args) {
		MakeUp g1 = new MakeUp(0,"灰姑凉");
		MakeUp g2 = new MakeUp(1,"白雪公主");
		g1.start();
		g2.start();
	}
}

class Mirror{}
class Lipstick{}
class MakeUp extends Thread {
	//需要的资源只有一份，用static来保证只有一份
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	
	int choice;//选择
	String girlName;//使用化妆品的人
	
	public MakeUp(int choice,String girlName) {
		this.choice = choice;
		this.girlName = girlName;
	}
	
	@Override
	public void run() {//化妆
		try {
//			makeupDeadLock();
			makeup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//a化妆，互相持有对方的锁，就是需要拿到对方的资源
	private void makeupDeadLock() throws InterruptedException {//死锁
		if(choice==0) {
			synchronized (lipstick) {//获得口红的锁
				System.out.println(this.girlName + "获得口红的锁");
				Thread.sleep(1000);
				synchronized (mirror) {
					System.out.println(this.girlName + "获得镜子的锁");
				}
			}
		} else {
			synchronized (mirror) {//获得口红的锁
				System.out.println(this.girlName + "获得镜子的锁");
				Thread.sleep(2000);
				synchronized (lipstick) {
					System.out.println(this.girlName + "获得口红的锁");
				}
			}
		}
	}
	//各拿各的锁就不会造成死锁
	private void makeup() throws InterruptedException {
		if(choice==0) {
			synchronized (lipstick) {//获得口红的锁
				System.out.println(this.girlName + "获得口红的锁");
				Thread.sleep(1000);
			}
			synchronized (mirror) {
				System.out.println(this.girlName + "获得镜子的锁");
			}
		} else {
			synchronized (mirror) {//获得口红的锁
				System.out.println(this.girlName + "获得镜子的锁");
				Thread.sleep(2000);
			}
			synchronized (lipstick) {
				System.out.println(this.girlName + "获得口红的锁");
			}
		}
	}
}
