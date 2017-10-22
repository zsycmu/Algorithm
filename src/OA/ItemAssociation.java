package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ItemAssociation {
	public static String[] maxAssociation(String[][] associations) {
		if (associations == null || associations.length == 0) {
			return new String[0];
		}
		
		HashMap<String, String> parentMap = new HashMap<String, String>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String[] s : associations) {
			if (!parentMap.containsKey(s[0])) {
				parentMap.put(s[0], s[0]);
			}
			
			if (!parentMap.containsKey(s[1])) {
				parentMap.put(s[1], s[1]);
			}
		}
		
		for (String[] pair : associations) {
			String first = getParent(pair[0], parentMap);
			String second = getParent(pair[1], parentMap);
			
			if (first.compareTo(second) <= 0) {
				parentMap.put(second, first);
			} else {
				parentMap.put(first, second);
			}
		}
		
		for (String str : parentMap.keySet()) {
			String parent = getParent(str, parentMap);
			
			if (!map.containsKey(parent)) {
				map.put(parent, new ArrayList<String>());
			}
			
			map.get(parent).add(str);
		}
		
		int maxCount = 0;
		String maxParent = "";
		for (String key : map.keySet()) {
			if (map.get(key).size() > maxCount || (map.get(key).size() == maxCount &&  (key.compareTo(maxParent) < 0))) {
				maxCount = map.get(key).size();
				maxParent = key;
			}
		}
		
		List<String> maxGroup = map.get(maxParent);
		String[] result = new String[maxGroup.size()];
		 //maxGroup.toArray();
		maxGroup.toArray(result);
		Arrays.sort(result);
		return result;
	}
	
	private static String getParent(String s, HashMap<String, String> parentMap) {
		String parent = s;
		while (parent != parentMap.get(parent)) {
			parent = parentMap.get(parent);
		}
		
		return parent;
	}
	
	public static void main(String[] args) {
    	String[][] input = {{"itemA", "itemB"},{"itemB", "itemC"},{"itemG", "itemD"}, {"itemD", "itemF"},{"itemF", "itemH"}};
    	String[] output = maxAssociation(input);
    	
    	for (String s : output) {
    		System.out.println(s + " ");
    	}
	}
}
