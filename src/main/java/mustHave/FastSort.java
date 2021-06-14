package mustHave;

import java.util.Arrays;

public class FastSort {
	public static void main(String[] args) {
		int[] testArr = new int[100];
		for (int i = 0; i < testArr.length; i++) {
			System.out.println(testArr[i] = (int) Math.round(Math.random() * 1000));
		}
		int[] testArrLow = {4, 1, 5, 4};
		
		System.out.println(Arrays.toString(testArr));
		fastSort(testArr, 0, testArr.length - 1);
		System.out.println(Arrays.toString(testArr));
	}
	
	public static void fastSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			fastSort(arr, start, pivot - 1);
			fastSort(arr, pivot, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end) {
		int leftIndex = start;
		int rightIndex = end;
		int pivot = arr[leftIndex + (end - start) / 2];
		while (leftIndex <= rightIndex) {
			while (arr[leftIndex] < pivot) {
				leftIndex++;
			}
			while (arr[rightIndex] > pivot) {
				rightIndex--;
			}
			
			if (leftIndex <= rightIndex) {
				swap(arr, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}
		return leftIndex;
	}
	public static void swap(int[] arr, int first, int last) {
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}
}
