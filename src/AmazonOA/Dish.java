package AmazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 给楼主补一个我做到的题，之前看到地里有人提过，但是没看到完整的描述，我就没准备，谁知道偏就给我出了这题。。。
大概意思是给人推荐菜谱，input是两个二维String 数组，第一个用来存菜名和对应的菜系，第二个用来存人名和这个人喜欢的菜系，要去返回一个二维String数组，存的值是人名对应可能喜欢的菜名(如果人名后面对应的是“*”，那么就表示所有菜系都要)。
input: String[][] menu, String[][] personPreferences. 鍥磋鎴戜滑@1point 3 acres
output: String[][] recommendation. 1point 3acres 璁哄潧

example 1:
input: {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}}, {{"Peter", "Italian"}, {"Adam", "American"}}. From 1point 3acres bbs
Expected output: {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Adam", "Burger"}}

example 2:
input: {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}}, {{"Peter", "*"}}
Expected output: {{"Peter", "Pizza"}, {"Peter", "Pasta"}, {"Peter", "Burger"}}

攒人品攒人品攒人品。。。。。。
 * @author Shengyi
 *
 */

public class Dish {
	public static String[][] recommend(String[][] menu, String[][] personPreferences) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<String[]> recommendation = new ArrayList<String[]>();
		
		if (menu == null || menu.length == 0 || personPreferences == null || personPreferences.length == 0) {
			return null;
		}
		
		for (String[] pair : menu) {
			if (!map.containsKey(pair[1])) {
				map.put(pair[1], new ArrayList<String>());
			}
			
			map.get(pair[1]).add(pair[0]);
		}
		
		for (String[] pair : personPreferences) {
			String dish = pair[1];
			String name = pair[0];
			if (pair[1].equals("*")) {
				for(String key : map.keySet()) {
					List<String> allDish = map.get(key);
					for(String d : allDish) {
						recommendation.add(new String[] {name, d});
					}
				}
			} else {
				List<String> allDish = map.get(dish);
				for(String d : allDish) {
					recommendation.add(new String[] {name, d});
				}
			}
		}
		
		String[][] result = new String[recommendation.size()][2];
		
		for (int i = 0; i < recommendation.size(); i++) {
			String[] temp = recommendation.get(i);
			result[i][0] = temp[0];
			result[i][1] = temp[1];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[][] menu = {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}};
		String[][] personPreferences = {{"Peter", "Italian"}, {"Adam", "*"}};
		
		String[][] result = recommend(menu, personPreferences);
		
		for (String[] s : result) {
			System.out.println(s[0] + " " + s[1]);
		}
	}
}
