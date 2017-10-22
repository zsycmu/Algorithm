package OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
