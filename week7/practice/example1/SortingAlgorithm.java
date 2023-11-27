package week7.practice.example1;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithm {
	// Bubble Sort Algorithm
	public static void bubbleSort(int[] array) {
		int n = array.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;

			for (int j = 0; j < n - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
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

	// Quick Sort Algorithm
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(array, low, high);

			quickSort(array, low, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, i + 1, high);

		return i + 1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Insertion Sort Algorithm
	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	// Merge Sort Algorithm
	public static void mergeSort(int[] array) {
		int n = array.length;

		if (n < 2) {
			return;
		}

		int mid = n / 2;

		int[] leftArray = Arrays.copyOfRange(array, 0, mid);
		int[] rightArray = Arrays.copyOfRange(array, mid, n);

		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(array, leftArray, rightArray);

	}

	private static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < leftSize && j < rightSize) {
			if (leftArray[i] < rightArray[j]) {
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

	// Selection Sort Algorithm
	public static void selectionSort(int[] array) {
		int n = array.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			
			// Swap array[i] and array[minIndex]
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	public static void printArray(int arr[]) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = new int[10];
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			int num_range = random.nextInt((int)Math.pow(10, 6)) + 1;
			array[i] = num_range;
		}

		System.out.println("\nBubble Sort:");
		int tempArray[] = Arrays.copyOf(array, array.length);
		bubbleSort(tempArray);
		printArray(tempArray);
		
		System.out.println("\nSelection Sort:");
		tempArray = Arrays.copyOf(array, array.length);
		selectionSort(tempArray);
		printArray(tempArray);
		
		System.out.println("\nInsertion Sort:");
		tempArray = Arrays.copyOf(array, array.length);
		insertionSort(tempArray);
		printArray(tempArray);
		
		System.out.println("\nMerge Sort:");
		tempArray = Arrays.copyOf(array, array.length);
		mergeSort(tempArray);
		printArray(tempArray);
		
		System.out.println("\nQuick Sort:");
		tempArray = Arrays.copyOf(array, array.length);
		quickSort(tempArray);
		printArray(tempArray);
		System.out.println("\n-----------------------------\n");
	}

}
