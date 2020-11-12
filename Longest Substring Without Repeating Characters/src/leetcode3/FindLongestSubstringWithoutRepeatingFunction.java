package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindLongestSubstringWithoutRepeatingFunction {
	// Sliding window method using HashMap, O(N) time but uses containskey method
	public int lengthOfLongestSubstring(String s) {
        // If the string is empty, then there is no substring
        if(s.length() == 0 || s == null){
            return 0;
        }
        
        // Storing each character as key and the index of the character as value
        HashMap<Character, Integer> map = new HashMap<>();
        
        // The longest substring
        int maxLength = 0;
        
        // Start pointer
        int start = 0;
        
        for(int end = 0; end < s.length(); end ++){
        	// If it is a duplicates, move the start pointer
        	if(map.containsKey(end)){
        		// Make sure the start does not get smaller
        		start = Math.max(start, map.get(end) + 1);
        	}
        	
        	// update the index of the key no matter what
        	map.put(s.charAt(end), end);
        	
        	// end - start + 1 will get the maximum length
        	maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
	
	// Sliding window method without hashmap using array[128]
	public int lengthOfLongestSubstring2(String s) {
        // If the string is empty, then there is no substring
        if(s.length() == 0 || s == null){
            return 0;
        }
        
        // 128 since there might have uppercase too
        int[] store = new int[128];
        
        // The longest substring
        int maxLength = 0;
        
        // Start pointer
        int start = 0;
        
        for(int end = 0; end < s.length(); end ++){
        	// start will only change when we see duplicates
        	start = Math.max(start, store[s.charAt(end)]);
        	
        	// update the index of current element, + 1 since we want the start to be next element
        	store[s.charAt(end)] = end + 1;
        	
        	// end - start + 1 will get the maximum length
        	maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
	
	// Another way to do it with hashset, slower way
	public int lengthOfLongestSubstring1(String s){

        Set<Character> set = new HashSet<>();
        
        int max = 0, start = 0, end = 0;
        
        while (start < s.length() && end < s.length()) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                
                end++;
                
                max = Math.max(max, end - start);
            }
            else {
            	// Since this is a while loop, will keep removing the hashset from index 0 until there is no duplicates
                set.remove(s.charAt(start));
                
                // Update start at the same time
                start++;
            }
        }
        return max;
	}

}
 