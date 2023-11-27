package week7.morepractice.example4;

import java.util.Scanner;

public class bai42 {
    public static void printArray(int a[], int n){
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void insertionSort(int a[], int n) {
        int index, value;
        for (int i = 1; i < n; i++) {
            index = i;
            value = a[i];
            while (index > 0 && a[index - 1] > value) {
                a[index] = a[index - 1];
                index --;
            }
            a[index] = value;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        insertionSort(a, n);
        printArray(a, n);
    }
}
