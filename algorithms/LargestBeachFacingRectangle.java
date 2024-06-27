package algorithms;

import java.util.Scanner;
import java.util.Stack;

public class LargestBeachFacingRectangle {

    public static long getMaxPossibleArea(int[] lengths) {
        int n = lengths.length;
        long maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        // Array to store the heights of histogram bars
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = lengths[i];
        }
        
        // Find the maximum rectangle area using histogram concept
        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                long area = (long) heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long area = (long) heights[top] * (stack.isEmpty() ? n : n - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of landowners
        System.out.print("Enter the number of landowners: ");
        int n = scanner.nextInt();

        // Input the lengths of plots facing the beach
        int[] lengths = new int[n];
        System.out.println("Enter the lengths of plots facing the beach:");
        for (int i = 0; i < n; i++) {
            lengths[i] = scanner.nextInt();
        }

        // Calculate the maximum possible area of the rectangular plot
        long maxArea = getMaxPossibleArea(lengths);
        System.out.println("Maximum possible area of the rectangular plot: " + maxArea);

        scanner.close();
    }
}