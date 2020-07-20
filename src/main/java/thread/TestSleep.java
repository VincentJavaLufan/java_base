package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep  {
	
//	@Override
//	public void run() {
//		
//	}

	public static void main(String[] args) throws InterruptedException {
		while(true) {
			Thread.sleep(1000);
			SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(sdfDateFormat.format(new Date().getTime()));
		}
	}
}
