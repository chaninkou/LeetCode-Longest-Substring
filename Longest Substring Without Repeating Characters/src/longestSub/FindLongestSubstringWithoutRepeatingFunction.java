package longestSub;

import java.util.HashMap;
import java.util.Map;

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

}
 