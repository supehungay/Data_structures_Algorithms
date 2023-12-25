import java.util.Random;

public class SudokuGenerator {
    private static final int SIZE = 9;

    public static int[][] generateSudoku() {
        int[][] sudoku = new int[SIZE][SIZE];
        fillValues(sudoku);
        return sudoku;
    }

    private static void fillValues(int[][] sudoku) {
        // Sử dụng thuật toán để điền giá trị vào Sudoku
        fillDiagonal(sudoku);
        solveSudoku(sudoku);
        removeDigits(sudoku);
    }

    private static void fillDiagonal(int[][] sudoku) {
        for (int i = 0; i < SIZE; i += 3) {
            fillBox(sudoku, i, i);
        }
    }

    private static void fillBox(int[][] sudoku, int row, int col) {
        Random rand = new Random();
        int num;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    num = rand.nextInt(SIZE) + 1;
                } while (!isSafe(sudoku, row + i, col + j, num));

                sudoku[row + i][col + j] = num;
            }
        }
    }

    private static boolean isSafe(int[][] sudoku, int row, int col, int num) {
        for (int x = 0; x < SIZE; x++) {
            if (sudoku[row][x] == num || sudoku[x][col] == num || sudoku[row - row % 3 + x / 3][col - col % 3 + x % 3] == num) {
                return false;
            }
        }
        return true;
    }

private static boolean solveSudoku(int[][] sudoku) {
    int row = -1;
    int col = -1;
    boolean isEmpty = true;

    // Tìm ô trống trong Sudoku
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (sudoku[i][j] == 0) {
                row = i;
                col = j;
                isEmpty = false;
                break;
            }
        }
        if (!isEmpty) {
            break;
        }
    }

    // Nếu không còn ô trống, Sudoku đã được giải
    if (isEmpty) {
        return true;
    }

    // Thử nghiệm các giá trị từ 1 đến 9
    for (int num = 1; num <= SIZE; num++) {
        if (isSafe(sudoku, row, col, num)) {
            sudoku[row][col] = num;

            // Nếu giải pháp được tìm thấy, trả về true
            if (solveSudoku(sudoku)) {
                return true;
            }

            // Nếu không tìm thấy giải pháp, hủy bỏ thay đổi và thử giá trị khác
            sudoku[row][col] = 0;
        }
    }

    // Nếu không có giải pháp nào cho ô hiện tại, quay lại bước trước đó
    return false;
}

    private static void removeDigits(int[][] sudoku) {
        Random rand = new Random();
        int emptyCells = 30;  // Số lượng ô cần xóa để tạo Sudoku ngẫu nhiên
        while (emptyCells > 0) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            if (sudoku[row][col] != 0) {
                sudoku[row][col] = 0;
                emptyCells--;
            }
        }
    }
}
