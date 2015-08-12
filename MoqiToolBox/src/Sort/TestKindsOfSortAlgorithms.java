package Sort;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestKindsOfSortAlgorithms {
	private KindsOfSortAlgorithms sortAlgorithms = new KindsOfSortAlgorithms();
	@Test
	public void testQuickSort() {
		Random random = new Random();
		
		for(int i = 1; i < 100; i++) {
			int[] test = new int[i];
			for(int j = 0; j < test.length; j++) {
				test[j] = random.nextInt();
			}
			int[] actual = Arrays.copyOf(test, test.length);
			//!!! test
			int[] expected = Arrays.copyOf(test, test.length);
			Arrays.sort(expected);
			org.junit.Assert.assertArrayEquals(i + "th example failed!", expected, actual);
		}
	}
}
