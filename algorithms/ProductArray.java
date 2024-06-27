package algorithms;

import java.util.Scanner;

public class ProductArray {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        // Read the array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Construct the product array
        int[] result = constructProductArray(nums);

        // Print the result
        System.out.println("The product array is:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] constructProductArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int[] P = new int[n];

        // Construct the left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Construct the right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Construct the product array P
        for (int i = 0; i < n; i++) {
            P[i] = left[i] * right[i];
        }

        return P;
    }
}
