package mustHave;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] testArr = new int[10000];
		for (int i = 0; i < testArr.length; i++) {
			testArr[i] = (int) Math.round(Math.random() * 1000);
		}
		int[] testArrLow = {3, 5, 2, 1, 5, 6, 7, 4, 3, 2};
		System.out.println(Arrays.toString(mergeSort(testArrLow)));
		System.out.println(Arrays.toString(mergeSort(testArr)));
	}
	
	public static int[] mergeSort(int[] arr) {
		int[] tmp;
		int[] currentSrc = arr;
		int[] currentDest = new int[arr.length];
		int size = 1;
		while (size < arr.length) {
			for (int i = 0; i < arr.length; i += 2 * size) {
				merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
			}
			tmp = currentSrc;
			currentSrc = currentDest;
			currentDest = tmp;
			size = size * 2;
			System.out.println(Arrays.toString(currentSrc));
		}
		return currentSrc;
	}
	
	public static void merge(int[] src1, int src1Start, int[] src2, int src2Start,
									 int[] dest, int destStart, int size) {
		int index1 = src1Start;
		int index2 = src2Start;
		int src1End = Math.min(src1Start + size, src1.length);
		int src2End = Math.min(src2Start + size, src2.length);
		
		int iterationCount = src1End - src1Start + src2End - src2Start;
		
		for (int i = destStart; i < destStart + iterationCount; i++) {
			if (index1 < src2End && (index2 >= src2End || src1[index1] < src2[index2])) {
				dest[i] = src1[index1];
				index1++;
			} else {
				dest[i] = src2[index2];
				index2++;
			}
		}
	}
}
