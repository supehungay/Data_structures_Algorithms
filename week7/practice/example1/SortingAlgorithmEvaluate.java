package week7.practice.example1;

import java.util.Random;
import java.util.Arrays;

public class SortingAlgorithmEvaluate {

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(1000000) + 1;
		}

		return array;
	}

	public static void evaluate_bubbleSort(int[] array) {
		long startTime = System.currentTimeMillis();
		SortingAlgorithm.bubbleSort(array);
		long endTime = System.currentTimeMillis();

		System.out.println("Execution Time bubbleSort: " + (endTime - startTime) + " milliseconds");
	}

	public static void evaluate_insertionSort(int[] array) {
		long startTime = System.currentTimeMillis();
		SortingAlgorithm.insertionSort(array);
		long endTime = System.currentTimeMillis();

		System.out.println("Execution Time insertionSort: " + (endTime - startTime) + " milliseconds");
	}

	public static void evaluate_mergeSort(int[] array) {
		long startTime = System.currentTimeMillis();
		SortingAlgorithm.mergeSort(array);
		long endTime = System.currentTimeMillis();

		System.out.println("Execution Time mergeSort: " + (endTime - startTime) + " milliseconds");
	}

	public static void evaluate_quickSort(int[] array) {
		long startTime = System.currentTimeMillis();
		SortingAlgorithm.quickSort(array);
		long endTime = System.currentTimeMillis();

		System.out.println("Execution Time quickSort: " + (endTime - startTime) + " milliseconds");
	}

	public static void evaluate_selectionSort(int[] array) {
		long startTime = System.currentTimeMillis();
		SortingAlgorithm.selectionSort(array);
		long endTime = System.currentTimeMillis();

		System.out.println("Execution Time selectionSort: " + (endTime - startTime) + " milliseconds");
	}
	

	public static void main(String[] args) {
		int[] sizes = new int[4];
		int temp = 100;
		for (int i = 0; i < sizes.length; i++) {
			sizes[i] = temp;
			temp *= 10;
		}

		for (int size : sizes) {
			System.out.println("Array size: " + size);

			int[] randomArray = generateRandomArray(size);

			System.out.println("\nBubble Sort:");
			evaluate_bubbleSort(Arrays.copyOf(randomArray, randomArray.length));
			System.out.println("\nSelection Sort:");
			evaluate_selectionSort(Arrays.copyOf(randomArray, randomArray.length));
			System.out.println("\nInsertion Sort:");
			evaluate_insertionSort(Arrays.copyOf(randomArray, randomArray.length));
			System.out.println("\nMerge Sort:");
			evaluate_mergeSort(Arrays.copyOf(randomArray, randomArray.length));
			System.out.println("\nQuick Sort:");
			evaluate_quickSort(Arrays.copyOf(randomArray, randomArray.length));
			System.out.println("\n-----------------------------\n");

			// printArray(randomArray);
		}
	}

}
