package week7.morepractice.example4;

import java.util.Scanner;

public class bai41 {

    public static void printArray(int a[], int n){
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void bubbleSort(int a[], int n) {
        for (int i = n - 1; i >= 1; i--) {
            boolean swapped = true;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j +1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = false;
                }
            }
            if (swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        bubbleSort(a, n);
        printArray(a, n);
    }
}
