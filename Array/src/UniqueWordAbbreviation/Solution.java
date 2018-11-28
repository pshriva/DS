package UniqueWordAbbreviation;
// Question is a little tricky, see explanation - http://buttercola.blogspot.com/2015/10/leetcode-unique-word-abbreviation.html
//LL
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String[] dictionary = {"deer", "door", "cake", "card"};
		ValidWordAbbreviator abbr = new ValidWordAbbreviator(dictionary);
		System.out.println(abbr.isUnique("dear"));
		System.out.println(abbr.isUnique("cart"));
		System.out.println(abbr.isUnique("cane"));
		System.out.println(abbr.isUnique("make"));
	}

}
