public class SudokuUtils {
    private static final int SIZE = 9; // Thêm hằng số SIZE

    public static String sudokuToString(int[][] sudoku) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(sudoku[i][j]);
                if (j < SIZE - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Các phương thức tiện ích bổ sung có thể được thêm vào đây nếu cần
}
