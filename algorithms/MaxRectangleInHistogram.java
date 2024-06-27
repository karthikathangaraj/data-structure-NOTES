package algorithms;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangleInHistogram {
    
    public static int getMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;
        
        while (index < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.push(index++);
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of buildings:");
        int n = scanner.nextInt();
        
        int[] heights = new int[n];
        System.out.println("Enter the heights of the buildings:");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        
        int maxArea = getMaxArea(heights);
        System.out.println("The maximum rectangular area in the histogram is: " + maxArea);
        
        scanner.close();
    }

}
