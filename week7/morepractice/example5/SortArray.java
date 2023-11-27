package week7.morepractice.example5;

public class SortArray {
    public static void sortAscending(int arr[]) {
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

    public static void sortDescending(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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

        System.out.println("Original array:");
        printArray(myArray);

        sortAscending(myArray);
        System.out.println("Sorted array in ascending order:");
        printArray(myArray);

        sortDescending(myArray);
        System.out.println("Sorted array in descending order:");
        printArray(myArray);
    }
}
