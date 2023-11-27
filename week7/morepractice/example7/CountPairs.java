package week7.morepractice.example7;

import java.util.Arrays;

public class CountPairs {
    static int countPairs(int arr[], int x) {
        int n = arr.length;
        Arrays.sort(arr); 

        int count = 0;

        for (int j = 0; j < n; j++) {
            int target = x - arr[j];

            int i1 = binarySearchFirstIndex(arr, target, 0, j - 1);
            int i2 = binarySearchLastIndex(arr, target, 0, j - 1);

            if (i1 != -1 && i2 != -1) {
                count += (i2 - i1 + 1);
            }
        }

        return count;
    }

    static int binarySearchFirstIndex(int arr[], int target, int low, int high) {
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // Tiếp tục tìm kiếm bên trái
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    static int binarySearchLastIndex(int arr[], int target, int low, int high) {
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // Tiếp tục tìm kiếm bên phải
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 10;

        int result = countPairs(arr, x);
        System.out.println("Number of pairs where ai + aj = " + x + ": " + result);
    }
}
