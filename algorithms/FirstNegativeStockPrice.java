package algorithms;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNegativeStockPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of days (N)
        System.out.print("Enter the number of days: ");
        int N = scanner.nextInt();

        // Read the stock prices
        int[] prices = new int[N];
        System.out.println("Enter the stock prices: ");
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }

        // Read the window size (K)
        System.out.print("Enter the window size (K): ");
        int K = scanner.nextInt();

        // Find and print the first negative stock price change in every window of size K
        int[] result = findFirstNegativePriceInWindow(prices, K);

        System.out.println("First negative stock prices in every window of size " + K + ":");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] findFirstNegativePriceInWindow(int[] prices, int k) {
        int n = prices.length;
        if (n < k) {
            return new int[0]; // If the number of days is less than the window size, return an empty array
        }
        int[] result = new int[n - k + 1];
        int index = 0;

        // Queue to store indices of days with negative stock price change in the current window
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Check if the current element's price is lower than the previous day's price
            if (i > 0 && prices[i] < prices[i - 1]) {
                queue.offer(i);
            }

            // Remove elements that are out of the current window
            if (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }

            // Start recording results once we have processed the first k elements
            if (i >= k - 1) {
                if (!queue.isEmpty()) {
                    result[index++] = prices[queue.peek()];
                } else {
                    result[index++] = 0;
                }
            }
        }

        return result;
    }
}
