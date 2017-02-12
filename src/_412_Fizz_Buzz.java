import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Write a program that outputs the string representation of numbers from 1 to n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * 
 * Example:
 * 
 * n = 15,
 * 
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * @author shengyizhang
 *
 */

public class _412_Fizz_Buzz {
	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		
        if (n == 0) {
        	return list;
        }
        
        int index = 1;
        
        while (index <= n) {
        	if (index % 3 == 0 && index % 5 == 0) {
        		list.add("FizzBuzz");
        	} else if (index % 3 == 0) {
        		list.add("Fizz");
        	} else if (index % 5 == 0) {
        		list.add("Buzz");
        	} else {
        		list.add(String.valueOf(index));
        	}
        	index++;
        }
        
        return list;
    }
	
	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}
}
