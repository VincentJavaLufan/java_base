package TransientDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * /**
 * https://baijiahao.baidu.com/s?id=1636557218432721275&wfr=spider&for=pc
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		SerializeUser();
		DeSerializeUser();
	}
	
	//序列化 在序列化SerializeUser方法中，首先创建一个序列化user类，然后将其写入到G://Test/template路径中
	private static void SerializeUser() throws FileNotFoundException, IOException, ClassCastException {
		User user = new User();
		user.setName("序列化");
		user.setAge(33);
		user.setString("aaaaaasssssdddf中国 你好！？》《");
		ObjectOutputStream ooStream = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Test.txt"));
		ooStream.writeObject(user);
		ooStream.close();
		System.out.println("添加了transient关键字序列化：name= " + user.getName());
		System.out.println("添加了transient关键字序列化：age= " + user.getAge());
		System.out.println("添加了transient关键字序列化：string= " + user.getString());
		user.setString("11111");//静态变量不管是不是transient关键字修饰，都不会被序列化
	}
	
	//反序列化  在反序列化DeSerializeUser方法中，首先创建一个File，然后读取G://Test/template路径中的数据
	private static void DeSerializeUser() throws IOException, ClassNotFoundException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\Test.txt");
		ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
		User newUser = (User)oiStream.readObject();
		System.out.println("添加了transient关键字序列化：name= " + newUser.getName());
		System.out.println("添加了transient关键字序列化：age= " + newUser.getAge());
		System.out.println("添加了transient关键字序列化：string= " + newUser.getString());
	}
}
