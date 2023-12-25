import javax.swing.*;
import java.awt.*;

public class SudokuSolverSwingApp {
    private static final int SIZE = 9;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int[][] sudokuOriginal = SudokuGenerator.generateSudoku();
        int[][] sudokuBacktracking = new int[SIZE][SIZE];
        int[][] sudokuHeuristic = new int[SIZE][SIZE];

        // Copy the original Sudoku for both algorithms
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(sudokuOriginal[i], 0, sudokuBacktracking[i], 0, SIZE);
            System.arraycopy(sudokuOriginal[i], 0, sudokuHeuristic[i], 0, SIZE);
        }

        // Backtracking
        SudokuSolver.resetCounters(); // Reset counters before each solving process

        long startTimeBacktracking = System.nanoTime();
        boolean backtrackingResult = SudokuSolver.solveSudokuBacktracking(sudokuBacktracking);
        long endTimeBacktracking = System.nanoTime();
        long durationBacktracking = (endTimeBacktracking - startTimeBacktracking) / 1_000_000; // milliseconds

        JTextArea backtrackingTextArea = new JTextArea();
        backtrackingTextArea.setText("Backtracking Solution:\n");
        backtrackingTextArea.append(SudokuUtils.sudokuToString(sudokuBacktracking));
        backtrackingTextArea.append("Backtracking Duration: " + durationBacktracking + " ms\n");

        // Thêm thông báo cho người dùng trong GUI
        backtrackingTextArea.append("Number of isValid calls: " + SudokuSolver.getIsValidCallCount() + "\n");
        backtrackingTextArea.append("Number of solveSudoku calls: " + SudokuSolver.getSolveSudokuCallCount() + "\n");
        backtrackingTextArea.append("Number of heuristic calls: " + SudokuSolver.getHeuristicCallCount() + "\n");
        backtrackingTextArea.append("Number of backtracking recursions: " + SudokuSolver.getBacktrackingRecursionCount() + "\n\n");

        // Heuristic
        SudokuSolver.resetCounters(); // Reset counters before each solving process

        long startTimeHeuristic = System.nanoTime();
        boolean heuristicResult = SudokuSolver.solveSudokuBacktrackingHeuristic(sudokuHeuristic);
        long endTimeHeuristic = System.nanoTime();
        long durationHeuristic = (endTimeHeuristic - startTimeHeuristic) / 1_000_000; // milliseconds

        JTextArea heuristicTextArea = new JTextArea();
        heuristicTextArea.setText("Backtracking with Heuristic Solution:\n");
        heuristicTextArea.append(SudokuUtils.sudokuToString(sudokuHeuristic));
        heuristicTextArea.append("Heuristic Duration: " + durationHeuristic + " ms\n");

        // Thêm thông báo cho người dùng trong GUI
        heuristicTextArea.append("Number of isValid calls: " + SudokuSolver.getIsValidCallCount() + "\n");
        heuristicTextArea.append("Number of solveSudoku calls: " + SudokuSolver.getSolveSudokuCallCount() + "\n");
        heuristicTextArea.append("Number of heuristic calls: " + SudokuSolver.getHeuristicCallCount() + "\n");
        heuristicTextArea.append("Number of heuristic recursions: " + SudokuSolver.getHeuristicRecursionCount() + "\n\n");

        JTextArea originalTextArea = new JTextArea();
        originalTextArea.setText("Original Sudoku:\n");
        originalTextArea.append(SudokuUtils.sudokuToString(sudokuOriginal));

        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JScrollPane(backtrackingTextArea));
        panel.add(new JScrollPane(heuristicTextArea));
        panel.add(new JScrollPane(originalTextArea));

        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(1200, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
