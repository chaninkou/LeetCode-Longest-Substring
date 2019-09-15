package longestSub;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringWithoutRepeatingFunction {
	public int lengthOfLongestSubstring(String s) {
        // If the string is empty, then there is no substring
        if(s.length() == 0){
            return 0;
        }
        
        // Storing each character as key and the index of the character as value
        HashMap<Character, Integer> map = new HashMap<>();
        
        // The longest substring
        int max = 0;
        
        for(int index = 0, numbersOfRepeatedCharacter = 0; index < s.length(); index++){
            // If the character is already in the map, add one to the value of the key
            if(map.containsKey(s.charAt(index))){
                numbersOfRepeatedCharacter = Math.max(numbersOfRepeatedCharacter, map.get(s.charAt(index)) + 1);
            }
            
            // Put the key and value in the map
            map.put(s.charAt(index), index);
            
            // Getting the max sub string
            max = Math.max(max, index - numbersOfRepeatedCharacter + 1);
        }
        
        return max;
    }

}
 