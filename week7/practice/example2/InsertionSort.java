package week7.practice.example2;

import java.util.Comparator;

public class InsertionSort {
	public static <T> void insertionSort(T[] array, Comparator<? super T> comparator) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			T key = array[i];
			int j = i - 1;

			while (j >= 0 && comparator.compare(array[j], key) > 0) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		Integer[] intArray = { 64, 34, 25, 12, 22, 11, 90 };
		Comparator<Integer> integerComparator = Integer::compareTo;

		insertionSort(intArray, integerComparator);

		for (int i : intArray) {
			System.out.print(i + " ");
		}

		System.out.println();

		String[] strArray = { "banana", "apple", "orange", "grape", "kiwi" };
		Comparator<String> stringComparator = String::compareTo;

		insertionSort(strArray, stringComparator);

		for (String s : strArray) {
			System.out.print(s + " ");
		}
	}
}
