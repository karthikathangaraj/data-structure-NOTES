package algorithms;

import java.util.*;

public class CheckConsecutiveIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        // Read the elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Check if the array is formed by consecutive integers
        boolean isConsecutive = areConsecutive(arr);

        // Print the result
        if (isConsecutive) {
            int min = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
            int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
            System.out.println("The array is formed by consecutive integers.");
            System.out.println("The interval formed is: [" + min + ", " + max + "]");
        } else {
            System.out.println("The array does not contain consecutive integers.");
        }

        scanner.close();
    }

    public static boolean areConsecutive(int[] arr) {
        if (arr.length == 0) {
            return false;
        }

        // Create a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();

        // Initialize min and max values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Populate the HashSet and find min and max values
        for (int num : arr) {
            // Check for duplicate elements
            if (set.contains(num)) {
                System.out.println("The array does not contain consecutive integers as element " + num + " is repeated.");
                return false;
            }
            set.add(num);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // Check if the number of unique elements is equal to the range of values
        if (max - min + 1 != set.size()) {
            return false;
        }

        // Check if all integers from min to max are present in the set
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }

        return true;
    }
}

