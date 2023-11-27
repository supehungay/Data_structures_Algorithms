package week7.morepractice.example9;

public class NewPosition {
    static int newPosition(int arr[], int i) {
        int n = arr.length;

        int[] originalIndices = new int[n];
        for (int j = 0; j < n; j++) {
            originalIndices[j] = j;
        }

        quickSort(arr, originalIndices, 0, n - 1);

        int newPosition = -1;
        for (int j = 0; j < n; j++) {
            if (originalIndices[j] == i) {
                newPosition = j;
                break;
            }
        }

        return newPosition;
    }

    static void quickSort(int arr[], int indices[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, indices, low, high);

            quickSort(arr, indices, low, pi - 1);
            quickSort(arr, indices, pi + 1, high);
        }
    }

    static int partition(int arr[], int indices[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                int tempIndex = indices[i];
                indices[i] = indices[j];
                indices[j] = tempIndex;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        int tempIndex = indices[i + 1];
        indices[i + 1] = indices[high];
        indices[high] = tempIndex;

        return i + 1;
    }

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        int i = 2; 

        int newPosition = newPosition(arr, i);
        System.out.println("The new position of a[" + i + "] is: " + newPosition);
    }
}
