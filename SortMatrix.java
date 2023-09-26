import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class SortMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter matrix size(n*n) Number:");
        int n = scanner.nextInt();

        System.out.print("Enter column index for sorting:");
        int k = scanner.nextInt();

        if (k < 0 || k >= n) {
            System.out.println("Incorrect number of column");
            return;
        }

        int[][] matrix = new int[n][n];
        Random random = new Random();

        // Filling matrix random numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        System.out.println("Origin matrix:");
        printMatrix(matrix);

        // Sort rows of matrix in order column K
        Arrays.sort(matrix, (row1, row2) -> Integer.compare(row1[k], row2[k]));

        System.out.println("Matrix after sorting:");
        printMatrix(matrix);
    }

    // Method for print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}

