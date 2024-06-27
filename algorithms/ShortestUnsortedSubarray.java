package algorithms;

import java.util.Scanner;
import java.util.Arrays;

public class ShortestUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int left = 0;
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        if (left == n - 1) { // The array is already sorted
            return 0;
        }

        int right = n - 1;
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        // Find the min and max in the nums[left..right]
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // Extend the left boundary to include any numbers greater than the min
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // Extend the right boundary to include any numbers less than the max
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int result = findUnsortedSubarray(nums);
        System.out.println("Length of the shortest subarray that needs to be sorted: " + result);
        
        scanner.close();
    }
}
