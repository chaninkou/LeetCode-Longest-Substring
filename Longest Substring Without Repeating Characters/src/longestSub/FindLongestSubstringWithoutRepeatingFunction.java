package longestSub;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindLongestSubstringWithoutRepeatingFunction {
	public int lengthOfLongestSubstring(String s) {
        // If the string is empty, then there is no substring
        if(s.length() == 0 || s == null){
            return 0;
        }
        
        // Storing each character as key and the index of the character as value
        HashMap<Character, Integer> map = new HashMap<>();
        
        // The longest substring
        int maxLength = 0;
        
        // This will keep track of total length from currentIndex, default is 0 since we do start from 0
        int startIndexFromCurrentIndex = 0;
        
        for(int currentIndex = 0; currentIndex < s.length(); currentIndex++){
        	char currentElement = s.charAt(currentIndex);
        	
            // If the character is already in the map, add one to the value of the key
            if(map.containsKey(currentElement)){
            	// map.get(s.charAt(index)) + 1 to get the right length
            	startIndexFromCurrentIndex = Math.max(startIndexFromCurrentIndex, map.get(currentElement) + 1);
            }
            
            // Put the key and value in the map
            // If the key already in it, we will also replace the index with second one that appear and so on
            map.put(currentElement, currentIndex);
            
            // Getting the max sub string
            // + 1 since the index starts from 0
            maxLength = Math.max(maxLength, currentIndex - startIndexFromCurrentIndex + 1);
        }
        
        return maxLength;
    }
	
	// Another way to do it with hashset
	public int lengthOfLongestSubstring1(String s){
		// Error checking
		if(s.length() == 0 || s == null){
			return 0;
		}
		
		// Use hashset to see if another character appear
		Set<Character> set = new HashSet<>();
		
		// start pointer and end pointer
		int start = 0;
		int end = 0;
		
		int max = 0;
		
		for(int i = 0; i < s.length(); i++){
			// If its not in the set yet
			if(!set.contains(s.charAt(end))){
				// Keep adding the element
				set.add(s.charAt(end));
				
				// update the pointer
				end++;
				
				// Compare current hashset size and the previous max
				max = Math.max(max, set.size());
			} else { // This kind of just keep deleting the start index element until removing the current element that is appearing
				set.remove(s.charAt(start));
				start++;
			}
			
		}
			
		return max;
	}

}
 