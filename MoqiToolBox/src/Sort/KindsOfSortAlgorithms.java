package Sort;

import java.util.Arrays;

public class KindsOfSortAlgorithms<E> {
	//!!!泛型
	//普通的快排
	public void quicksort(int[] array) {
		if(array == null || array.length == 0) {
			System.out.println("Invalid parameter!!");
			return;
		}
		if(array.length == 1) {
			return;
		}
		quicksortHelpFunc(array, 0, array.length - 1);
	}
	
	public void quicksortHelpFunc(int[] array, int left, int right) {
		if(left < right) {
			int middle = partition(array, left, right);
			quicksortHelpFunc(array, left, middle);
			quicksortHelpFunc(array, middle+1, right);
		}
	}
	
	public int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];
		int help;
		
		while(left < right) {
			while(left < right && array[left] < pivot) {
				left++;
			}
			while(left < right && array[right] > pivot) {
				right--;
			}
			if(left < right) {
				help = array[left];
				array[left] = array[right];
				array[right] = help;
				left++;
				right--;
			}
		}
		//费解
		if(left == right && array[right] > pivot) {
			right--;
		}
		
		return right;
	}
	
	//原址排序，返回index信息
	//泛型函数
	public void quickSort() {
		
	}
	
	public static void main(String[] args) {
		KindsOfSortAlgorithms sortAlgorithms = new KindsOfSortAlgorithms();
		int[] test = {0, 3, 1, 2};
		System.out.println("original: " + Arrays.toString(test));
		sortAlgorithms.quicksort(test);
		System.out.println("sorted: " + Arrays.toString(test));
	}
}
