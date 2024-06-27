package algorithms;
import java.util.Scanner;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the input list
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Reading the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Finding the index of the target value
        int index = search(nums, target);
        System.out.println("The index of the target value is: " + index);

        scanner.close();
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target is in the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Target is in the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // Target is not present in the list
        return -1;
    }
}
