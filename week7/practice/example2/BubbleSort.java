package week7.practice.example2;

import java.util.Comparator;

public class BubbleSort {
	public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator) {
		int n = array.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;

			for (int j = 0; j < n - 1; j++) {
				if (comparator.compare(array[j], array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] intArray = { 64, 34, 25, 12, 22, 11, 90 };
		Comparator<Integer> integerComparator = Integer::compareTo;

		bubbleSort(intArray, integerComparator);

		for (int i : intArray) {
			System.out.print(i + " ");
		}
	}
}
