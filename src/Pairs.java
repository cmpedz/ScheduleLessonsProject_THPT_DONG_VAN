
public class Pairs<T, K>{
	
	private T value1;
	
	private K value2;
	
	public Pairs(T v1, K v2) {
		this.value1 = v1;
		this.value2 = v2;
	}
	
	public T getValue1() {
		return value1;
	}
	
	public void setValue1(T v1) {
		this.value1 = v1;
	}
	
	public K getValue2() {
		return value2;
	}
	
	public void setValue2(K v2) {
		this.value2 = v2;
	}

	
	
	
}
