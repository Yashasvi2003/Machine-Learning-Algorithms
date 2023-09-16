import java.util.Scanner;
public class SudokuSolve {
    private static final int N = 9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] g = new int[N][N];
        int inSize = sc.nextInt();
        for (int i = 0; i < inSize; i++) {
            for (int j = 0; j < inSize; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        boolean sol = Sudoku(g);
        if (sol) {
            printGrid(g);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean Sudoku(int[][] g) {
        int rows = -1;
        int cols = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (g[i][j] == 0) {
                    rows = i;
                    cols = j;
                    break;
                }
            }
            if (rows != -1) {
                break;
            }
        }
        if (rows == -1) {
            return true;
        }
        for (int n = 1; n <= 9; n++) {
            if (isValid(g, rows, cols, n)) {
                g[rows][cols] = n;

                if (Sudoku(g)) {
                    return true;
                }
                g[rows][cols] = 0;
            }
        }

        return false;
    }

    private static boolean isValid(int[][] g, int rows, int cols, int n) {
        for (int j = 0; j < N; j++) {
            if (g[rows][j] == n) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (g[i][cols] == n) {
                return false;
            }
        }
        int StartRow = 3 * (rows / 3);
        int StartCol = 3 * (cols / 3);
        for (int i = StartRow; i < StartRow + 3; i++) {
            for (int j = StartCol; j < StartCol + 3; j++) {
                if (g[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printGrid(int[][] g) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }
}
