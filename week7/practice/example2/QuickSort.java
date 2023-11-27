package week7.practice.example2;

import java.util.Comparator;

public class QuickSort<T> {

	public static <T> void quickSort(T[] array, Comparator<? super T> comparator) {
		quickSort(array, 0, array.length - 1, comparator);
	}

	private static <T> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
		if (low < high) {
			int partitionIndex = partition(array, low, high, comparator);

			quickSort(array, low, partitionIndex - 1, comparator);
			quickSort(array, partitionIndex + 1, high, comparator);
		}
	}

	private static <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
		T pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (comparator.compare(array[j], pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, i + 1, high);

		return i + 1;
	}

	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {

		Integer[] intArray = { 64, 34, 25, 12, 22, 11, 90 };
		Comparator<Integer> integerComparator = Integer::compareTo;

		quickSort(intArray, integerComparator);

		for (int i : intArray) {
			System.out.print(i + " ");
		}

		System.out.println();

		String[] strArray = { "banana", "apple", "orange", "grape", "kiwi" };
		Comparator<String> stringComparator = String::compareTo;

		quickSort(strArray, stringComparator);

		for (String s : strArray) {
			System.out.print(s + " ");
		}
	}
}
