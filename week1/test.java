package week1;
// import java.util.Random;
// public class test {

//     static void inputArray(int[] A, int n) {
//         for (int i = 0; i < n - 1; i++) {
//             A[i] = i;
//         }
//     }

//     static int findNumber(int arr[]) {

//         for (int i = 0; i < arr.length; i++) {
//             if 
//         }

//         return frenquent;
//     }
        
//     public static void main(String[] args) {
//         int n = 10;
//         int A[] = new int[n];
//         inputArray(A, n);
        
//         for (int i : A) {
//             System.out.println(i);
//         }

//         System.out.printf("value most frenquent: k = %s", count(A));
//     }
// }



public class test {
    static int findMissingNumber(int[] A, int n) {
        int xorResult = 0;

        // XOR all elements in the array A
        for (int i = 0; i < A.length; i++) {
            xorResult ^= A[i];
        }

        // XOR all numbers in the range [0, n-1]
        for (int i = 0; i <= n; i++) {
            xorResult ^= i;
        }

        return xorResult;
    }

    public static void main(String[] args) {
        int[] A = {0, 4, 1, 2}; // Example array
        int n = A.length; // n is one more than the length of A
        int missingNumber = findMissingNumber(A, n);
        System.out.println("The missing number is: " + missingNumber);
    }
}



