import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
    private static final int SIZE = 9;
    private static int backtrackingRecursionCount = 0;
    private static int heuristicRecursionCount = 0;
    private static int isValidCallCount = 0;
    private static int solveSudokuCallCount = 0;
    private static int heuristicCallCount = 0;

    public static boolean solveSudokuBacktracking(int[][] sudoku) {
        int row, col;
        int[] emptyCell = findEmptyCell(sudoku);
        row = emptyCell[0];
        col = emptyCell[1];

        if (row == -1 && col == -1) {
            return true;
        }

        solveSudokuCallCount++;
        for (int num = 1; num <= SIZE; num++) {
            if (isSafe(sudoku, row, col, num)) {
                sudoku[row][col] = num;
                backtrackingRecursionCount++;
                if (solveSudokuBacktracking(sudoku)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean solveSudokuBacktrackingHeuristic(int[][] sudoku) {
        int row, col;
        int[] emptyCell = findEmptyCellWithHeuristic(sudoku);
        row = emptyCell[0];
        col = emptyCell[1];

        if (row == -1 && col == -1) {
            return true;
        }

        int[] possibleValues = getHeuristicValues(sudoku, row, col);
        for (int num : possibleValues) {
            if (num != 0) {
                sudoku[row][col] = num;
                heuristicCallCount++;
                solveSudokuCallCount++;
                if (solveSudokuBacktrackingHeuristic(sudoku)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    private static int[] findEmptyCell(int[][] sudoku) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (sudoku[i][j] == 0) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    private static int[] findEmptyCellWithHeuristic(int[][] sudoku) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int minChoices = SIZE + 1;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (sudoku[i][j] == 0) {
                    int[] choices = getHeuristicValues(sudoku, i, j);
                    if (choices.length < minChoices) {
                        minChoices = choices.length;
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    private static int[] getHeuristicValues(int[][] sudoku, int row, int col) {
        boolean[] used = new boolean[SIZE + 1];
        Arrays.fill(used, false);

        for (int i = 0; i < SIZE; i++) {
            used[sudoku[row][i]] = true;
            used[sudoku[i][col]] = true;
        }

        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                used[sudoku[boxStartRow + i][boxStartCol + j]] = true;
            }
        }

        List<Integer> choices = new ArrayList<>();
        for (int num = 1; num <= SIZE; num++) {
            if (!used[num]) {
                choices.add(num);
            }
        }

        int[] result = new int[choices.size()];
        for (int i = 0; i < choices.size(); i++) {
            result[i] = choices.get(i);
        }

        return result;
    }

    private static boolean isSafe(int[][] sudoku, int row, int col, int num) {
        isValidCallCount++;
        return !usedInRow(sudoku, row, num) &&
               !usedInCol(sudoku, col, num) &&
               !usedInBox(sudoku, row - row % 3, col - col % 3, num);
    }

    private static boolean usedInRow(int[][] sudoku, int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (sudoku[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usedInCol(int[][] sudoku, int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (sudoku[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usedInBox(int[][] sudoku, int boxStartRow, int boxStartCol, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[boxStartRow + i][boxStartCol + j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void resetCounters() {
        backtrackingRecursionCount = 0;
        heuristicRecursionCount = 0;
        isValidCallCount = 0;
        solveSudokuCallCount = 0;
        heuristicCallCount = 0;
    }

    public static int getIsValidCallCount() {
        return isValidCallCount;
    }

    public static int getSolveSudokuCallCount() {
        return solveSudokuCallCount;
    }

    public static int getHeuristicCallCount() {
        return heuristicCallCount;
    }

    public static int getBacktrackingRecursionCount() {
        return backtrackingRecursionCount;
    }

    public static int getHeuristicRecursionCount() {
        return heuristicRecursionCount;
    }
}
