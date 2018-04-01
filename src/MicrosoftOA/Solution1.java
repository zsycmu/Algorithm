package MicrosoftOA;

public class Solution1 {
	
	public static void MakeTheNumbersMatch(int a, int b, int x, int y) {
		while (a != x || b != y) {
			if (a > x) {
				a--;
			} else if (a < x) {
				a++;
			}
			
			if (b > y) {
				b--;
			} else if (b < y) {
				b++;
			}
		}
		
		System.out.println(a);	
		System.out.println(b);	
		System.out.println(x);	
		System.out.println(y);
	}
	public static void main(String[] args) {
		int a = -1;
		int b = 2;
		int x = 3;
		int y = -4;
		
		MakeTheNumbersMatch(a, b, x, y);
		
		System.out.println(a);	
		System.out.println(b);	
		System.out.println(x);	
		System.out.println(y);
	}
}
