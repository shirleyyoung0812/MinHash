import java.util.*;
public class MinHashTester {

	public static void main(String[] args) {
		Set<String> text1 = new HashSet<String> ();
		text1.add("Dora");
		text1.add("is");
		text1.add("a");
		text1.add("stupid");
		text1.add("lovely");
		text1.add("happy");
		text1.add("puppy");
		Set<String> text2 = new HashSet<String> ();
		text2.add("Dora");
		text2.add("is");
		text2.add("a");
		text2.add("stupid");
		text2.add("lovely");
		text2.add("happy");
		text2.add("puppy");
		
		Set<String> text3 = new HashSet<String> ();
		text3.add("Dora");
		text3.add("the");
		text3.add("happy");
		text3.add("puppy");
		text3.add("loves");
		text3.add("Shirley");
		
		Set<String> text4 = new HashSet<String> ();
		text4.add("Dora");
		text4.add("stupid");
		text4.add("is");
		text4.add("lovely");
		text4.add("happy");
		text4.add("a");
		text4.add("puppy");
		MinHash mh = new MinHash();
		System.out.println(String.format("%.3f", mh.similarity(text1, text2, text1.size() + text2.size())));
		System.out.println(String.format("%.3f", mh.similarity(text1, text3, text1.size() + text3.size())));
		System.out.format("%.3f", mh.similarity(text1, text4, text1.size() + text4.size()));
		
		
	}

}
