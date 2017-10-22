package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckWinner {
	public static int checkWinner (List<List<String>> codeList, List<String> shoppingCart) {
		if (codeList == null || codeList.size() == 0 || shoppingCart == null || shoppingCart.size() == 0) {
			return 0;
		}
		
		int index = 0;
		for(int i = 0; i < codeList.size(); i++) {
			index = compareCodeList(codeList.get(i), shoppingCart, index);
			
			if (index == -1) {
				return 0;
			}
		}
		
		return 1;
	}
	
	private static int compareCodeList(List<String> code, List<String> shoppingCart, int index) {
		if (code == null || shoppingCart == null || code.size() > shoppingCart.size() || index > shoppingCart.size() - 1) {
			return -1;
		}
		
		for (int i = index; i < shoppingCart.size() - code.size() + 1; i++) {
			int j = 0;
			int step = 0;
			while (j < code.size()) {
				if (code.get(j) == null || code.get(j).length() == 0) {
					j++;
					continue;
				}
				
				if ((shoppingCart.get(i + step) == null) || (shoppingCart.get(i + step)).length() == 0) {
					step++;
					continue;
				}
				
				if (!code.get(j).equals(shoppingCart.get(i + step)) && !code.get(j).equals("anything")) {
					break;
				}
				j++;
				step++;
			}
			
			if (j == code.size()) {
				return i + step;
			} 
		}
		return -1;
	}
		
	public static void main(String[] args) {
		List<String> shoppingCart = Arrays.asList("orange", "apple", "apple", "orange", "banana", "orange");
		
		List<List<String>> codeList = new ArrayList<List<String>>();
		codeList.add(Arrays.asList("apple", "apple"));
		codeList.add(Arrays.asList("orange", "banana", "orange"));
		
		System.out.println(checkWinner(codeList, shoppingCart));
		
		
		List<String> shoppingCart2 = Arrays.asList("orange", "apple", "apple", "orange", "banana", "orange");
		
		List<List<String>> codeList2 = new ArrayList<List<String>>();
		codeList2.add(Arrays.asList("orange", "banana", "orange"));
		codeList2.add(Arrays.asList("apple", "apple"));
		
		System.out.println(checkWinner(codeList2, shoppingCart2));
		
		List<String> shoppingCart3 = Arrays.asList("orange", "apple", "apple", "orange", "banana", "orange", "pear", "grape");
		
		List<List<String>> codeList3 = new ArrayList<List<String>>();
		codeList3.add(Arrays.asList("apple", "apple"));
		codeList3.add(Arrays.asList("orange", "banana", "orange"));
		codeList3.add(Arrays.asList("pear", "orange", "grape"));
		
		System.out.println(checkWinner(codeList3, shoppingCart3));
		
		
		List<String> shoppingCart4 = Arrays.asList("orange", "apple", "apple", "orange", "mango", "orange");
		
		List<List<String>> codeList4 = new ArrayList<List<String>>();
		codeList4.add(Arrays.asList("apple", "apple"));
		codeList4.add(Arrays.asList("orange", "anything", "orange"));
		
		System.out.println(checkWinner(codeList4, shoppingCart4));
		
		//List<String> shoppingCart5 = Arrays.asList("orange", "apple", "apple", "", "orange", "mango", null,"orange");
		List<String> shoppingCart5 = Arrays.asList("orange", "apple", "apple","orange","", null, "mango","orange");
		
		List<List<String>> codeList5 = new ArrayList<List<String>>();
		codeList5.add(Arrays.asList("apple", null, "", "apple"));
		codeList5.add(Arrays.asList("orange", "anything", "orange"));
		
		System.out.println(checkWinner(codeList5, shoppingCart5));
	}
}
