package algorithms;

import java.util.Scanner;

public class MatrixSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Reading the matrix
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Reading the key
        System.out.print("Enter the key to search: ");
        int key = scanner.nextInt();

        // Searching for the key in the matrix
        boolean found = searchMatrix(matrix, key);
        System.out.println("The key " + key + " is present: " + found);

        scanner.close();
    }

    public static boolean searchMatrix(int[][] matrix, int key) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == key) {
                return true;
            } else if (midValue < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
