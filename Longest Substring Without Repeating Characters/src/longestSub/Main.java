package longestSub;

public class Main {
	public static void main(String[] args){
		// Input
		String input = "adbccbaef";
		
		System.out.println("Input: " + input);
		
		FindLongestSubstringWithoutRepeatingFunction solution = new FindLongestSubstringWithoutRepeatingFunction();
		
		// solution
		System.out.println("Solution: " + solution.lengthOfLongestSubstring(input));
		
	}
}
