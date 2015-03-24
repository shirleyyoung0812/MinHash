
/**
 * implement MinHash algorithm
 * http://shirleyisnotageek.blogspot.com/2015/03/min-hash.html
 * @author shirleyyoung
 *
 */
import java.util.*;
public class MinHash {
	//numHash: number of hash functions needed 
	// in this small case, we set it size of text a + size of text b in the test case
	public double similarity(Set<String> text1, Set<String> text2, int numHash){
		
		long[][] minHashValues = new long[2][numHash];
		Arrays.fill(minHashValues[0], Long.MAX_VALUE);
		Arrays.fill(minHashValues[1], Long.MAX_VALUE);
		Random r = new Random(63689);
		int similarity = 0;
		for (int i = 0; i < numHash; i++){
			int a = r.nextInt() + 1;
			for(String s : text1)
				minHashValues[0][i] = Math.min(minHashValues[0][i], getHash(s.hashCode(), a, i));
			for(String s : text2)
				minHashValues[1][i] = Math.min(minHashValues[1][i], getHash(s.hashCode(), a, i)); 
			if(minHashValues[0][i] == minHashValues[1][i]){
				similarity++;
			}
		}
		return (double)similarity / numHash;
	}
	//using circular shifts: http://en.wikipedia.org/wiki/Circular_shift
	//http://stackoverflow.com/questions/5844084/java-circular-shift-using-bitwise-operations
	//circular shifts XOR random number
	private long getHash(int value, int random, int shift){
		//the first hash function comes from string.hashCode()
		//http://www.codatlas.com/github.com/openjdk-mirror/jdk7u-jdk/master/src/share/classes/java/lang/String.java?keyword=String&line=1494
		if(shift == 0)
			return value;
		int rst = (value >>> shift) | (value << (Integer.SIZE - shift));
		return rst ^ random;
	}
}
