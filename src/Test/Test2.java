package Test;

class Test3 {
	int val;
	public Test3(int val) {
		this.val = val;
	}
}
public class Test2 {
	public static void ChangeInstance(Test3 instance) {
		instance.val;
	}
	public static void main(String[] args) {
		Test3 input = new Test3(1);
		ChangeInstance(input);
		
		System.out.println(input.val);
	}
}
