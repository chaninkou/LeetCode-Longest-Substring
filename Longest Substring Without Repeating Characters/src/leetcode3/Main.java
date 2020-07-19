package leetcode3;

public class Main {
	public static void main(String[] args){
		// Input
		String input = "zadbccbaef";
		
		System.out.println("Input: " + input);
		
		FindLongestSubstringWithoutRepeatingFunction solution = new FindLongestSubstringWithoutRepeatingFunction();
		
		// solution
		System.out.println("Solution: " + solution.lengthOfLongestSubstring2(input));
		
	}
}
