package algorithms;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of players (N)
        System.out.print("Enter the number of players (N): ");
        int N = scanner.nextInt();

        // Read the runs scored by each player
        int[] runs = new int[N];
        System.out.println("Enter the runs scored by each player: ");
        for (int i = 0; i < N; i++) {
            runs[i] = scanner.nextInt();
        }

        // Read the window size (K)
        System.out.print("Enter the window size (K): ");
        int K = scanner.nextInt();

        // Get the maximum values for each sliding window
        int[] result = maxSlidingWindow(runs, K);

        // Output the result
        System.out.println("Maximum values for each sliding window of size " + K + ":");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove elements not within the window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element at the back of the deque
            deque.offer(i);

            // The front of the deque contains the index of the maximum element for the current window
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }

        return result;
    }
}
