package MathUtils;

import java.util.*;

public class RandomAlgorithm {
	//<CLRS> p71
	//<programming> pearls p122
	public int[] RandomizeInPlace(int[] A) {
		int len = A.length;
		int temp, j;
		Random rand = new Random();
		for(int i = 0; i < len; i++) {
			j = rand.nextInt(len-i) % len + i;	//nextInt(bound) from 0 to bound-1
			//swap
			temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
		return A;
	}
	
	public static void main(String[] args) {
		RandomAlgorithm ra = new RandomAlgorithm();
		int[] test = {1,2,3,4,5};
		System.out.println(Arrays.toString(ra.RandomizeInPlace(test)));
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
