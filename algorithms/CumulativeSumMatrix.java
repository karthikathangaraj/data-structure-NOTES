package algorithms;

import java.util.Scanner;

public class CumulativeSumMatrix {
    // Recursive function to calculate the cumulative sum of a matrix
    public static int cumulativeSum(int[][] matrix, int row, int col) {
        // Base case: if we have processed all rows
        if (row == matrix.length) {
            return 0;
        }
        // Base case: if we have processed all columns in the current row
        if (col == matrix[row].length) {
            return cumulativeSum(matrix, row + 1, 0);
        }
        // Recursive case: current element + cumulative sum of the rest of the matrix
        return matrix[row][col] + cumulativeSum(matrix, row, col + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the matrix
        System.out.print("Enter the number of rows in the matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculate the cumulative sum
        int result = cumulativeSum(matrix, 0, 0);

        // Print the result
        System.out.println("The cumulative sum of the matrix is: " + result);

        scanner.close();
    }
}
