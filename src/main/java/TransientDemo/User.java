package TransientDemo;

import java.io.Serializable;
/**
 * /**
 * https://baijiahao.baidu.com/s?id=1636557218432721275&wfr=spider&for=pc
 * @author Administrator
 *
 */
public class User implements Serializable{
	private static final long serialversionUID = 123456L;
	private String name;
	private transient int age;
	private static String string; //静态变量不管是不是transient关键字修饰，都不会被序列化
	
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialversionUID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
