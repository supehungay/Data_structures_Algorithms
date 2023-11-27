package week7.morepractice.example6;

public class KthSmallestAndLargest {
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Tìm số bé thứ k và số lớn thứ k
    public static void findKthSmallestAndLargest(int arr[], int k) {
        bubbleSort(arr);

        int n = arr.length;
        if (k > 0 && k <= n) {
            int kthSmallest = arr[k - 1];
            System.out.println("The " + k + "th smallest number is: " + kthSmallest);

            int kthLargest = arr[n - k];
            System.out.println("The " + k + "th largest number is: " + kthLargest);
        } else {
            System.out.println("Invalid value of k");
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int myArray[] = {64, 34, 25, 12, 22, 11, 90};
        int k = 3;

        System.out.println("Original array:");
        printArray(myArray);

        findKthSmallestAndLargest(myArray, k);
    }
}
