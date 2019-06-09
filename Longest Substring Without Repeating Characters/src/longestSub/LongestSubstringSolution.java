package longestSub;

import java.util.HashMap;

public class LongestSubstringSolution {
	public static void main(String[] args){
		// Input
		String input = "abcdefgabc";
		
		System.out.println("Input: " + input);
		
		int solution = lengthOfLongestSubstring(input);
		
		// solution
		System.out.println("Solution: " + solution);
		
	}

	public static int lengthOfLongestSubstring(String s) {
		// If its empty, then 0 longest substring
		if (s.length() == 0) {
			return 0;
		}

		// Hash map with string as keys and their position as values
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int max = 0;

		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			
			// Putting the character into the hashmap
			map.put(s.charAt(i), i);
			
			// Getting the max by comparing the current and max
			max = Math.max(max, i - j + 1);
//			System.out.println("Current: "+ s.charAt(i));
//			System.out.println("max: "+ max);
//			System.out.println("Next: " + (i - j + 1));
		}

		return max;
	}

}
 