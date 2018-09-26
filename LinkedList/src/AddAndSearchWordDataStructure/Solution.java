package AddAndSearchWordDataStructure;

public class Solution {
	public static void main(String[] args){
		WordDictionary wd = new WordDictionary();
		wd.addWord("a");
		wd.addWord("a");
		System.out.println(wd.search("."));
		System.out.println(wd.search("a"));
		System.out.println(wd.search("aa"));
		System.out.println(wd.search("a"));
		System.out.println(wd.search(".a"));
		System.out.println(wd.search("a."));
	}
}
