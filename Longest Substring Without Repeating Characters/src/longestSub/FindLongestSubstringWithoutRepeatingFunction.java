package longestSub;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringWithoutRepeatingFunction {
	public static int lengthOfLongestSubstring(String s) {
		// If its empty, then 0 longest substring
		if (s.length() == 0) {
			return 0;
		}

		// Hash map with string as keys and their position as values
		Map<Character, Integer> map = new HashMap<>();

		int max = 0;

		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int currentRepeat = map.get(s.charAt(i)) + 1;
				j = Math.max(j, currentRepeat);
			}
			
			// Putting the character into the hashmap
			map.put(s.charAt(i), i);
			
			// Getting the max by comparing the current and max
			int current = i - j + 1;
			max = Math.max(max, current);
//			System.out.println("Current: "+ s.charAt(i));
//			System.out.println("max: "+ max);
//			System.out.println("Next: " + (i - j + 1));
		}

		return max;
	}

}
 