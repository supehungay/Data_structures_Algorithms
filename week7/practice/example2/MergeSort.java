package week7.practice.example2;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T> {

	public static <T> void mergeSort(T[] array, Comparator<? super T> comparator) {
		int n = array.length;

		if (n < 2) {
			return;
		}

		int mid = n / 2;

		T[] leftArray = Arrays.copyOfRange(array, 0, mid);
		T[] rightArray = Arrays.copyOfRange(array, mid, n);

		mergeSort(leftArray, comparator);
		mergeSort(rightArray, comparator);

		merge(array, leftArray, rightArray, comparator);

	}

	private static <T> void merge(T[] array, T[] leftArray, T[] rightArray, Comparator<? super T> comparator) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < leftSize && j < rightSize) {
			if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
				array[k++] = leftArray[i++];
			} else {
				array[k++] = rightArray[j++];
			}
		}

		while (i < leftSize) {
			array[k++] = leftArray[i++];
		}

		while (j < rightSize) {
			array[k++] = rightArray[j++];
		}

	}

	public static void main(String[] args) {
		Integer[] intArray = { 64, 34, 25, 12, 22, 11, 90 };
		Comparator<Integer> integerComparator = Integer::compareTo;

		mergeSort(intArray, integerComparator);

		for (int i : intArray) {
			System.out.print(i + " ");
		}

		System.out.println();

		String[] strArray = { "banana", "apple", "orange", "grape", "kiwi" };
		Comparator<String> stringComparator = String::compareTo;

		mergeSort(strArray, stringComparator);

		for (String s : strArray) {
			System.out.print(s + " ");
		}
	}
}
