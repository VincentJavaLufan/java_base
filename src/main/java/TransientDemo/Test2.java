package TransientDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.org.apache.bcel.internal.classfile.Field;

import oracle.net.aso.u;

public class Test2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		serWriteFunction();
		serReadFunction();
	}
	
	public static void serWriteFunction() throws FileNotFoundException, IOException {
		User user = new User();
		user.setAge(111);
		user.setName("lufan");
		ObjectOutputStream opStream = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Test.txt"));
		opStream.writeObject(user);
		opStream.close();
	}
	public static void serReadFunction() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oiStream = new ObjectInputStream(
				new FileInputStream("C:\\Users\\Administrator\\Desktop\\Test.txt"));
		
		User newUser = (User)oiStream.readObject();
		System.out.println(newUser.getAge());
		System.out.println(newUser.getName());
		oiStream.close();
	}
}
