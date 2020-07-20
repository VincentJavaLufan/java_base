package array;

import java.util.HashMap;

class Key {

	public Key(Integer id) {
		this.id = id;
	}
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	// 故意先注释掉equals和hashCode方法
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Key)) {
			return false;
		} else {
			return this.getId().equals(
					((Key) obj).getId()
				);
		}
	}

	public int hashCode() {
		return id.hashCode();
	}
}

public class WithoutHashCode {
	public static void main(String[] args) {
		Key k1 = new Key(1);
		Key k2 = new Key(1);
		HashMap<Key, String> hm = new HashMap<Key, String>();
		hm.put(k1, "Key with id is 1");
		System.out.println(hm.get(k2));
	}
}
