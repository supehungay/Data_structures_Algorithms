package week7.morepractice.example8;

public class SortString {
    static String sortString(String str) {
        int[] count = new int[10];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - '0']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.append(i);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String inputString = "314159265358979323846";
        
        System.out.println("Original string: " + inputString);
        
        String sortedString = sortString(inputString);
        
        System.out.println("Sorted string: " + sortedString);
    }
}
