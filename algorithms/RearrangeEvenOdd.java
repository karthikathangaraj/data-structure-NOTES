package algorithms;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RearrangeEvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Read the elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Rearrange the array
        int[] result = rearrangeEvenOdd(arr);

        // Print the rearranged array
        System.out.println("Rearranged array:");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] rearrangeEvenOdd(int[] arr) {
        Queue<Integer> evenQueue = new LinkedList<>();
        Queue<Integer> oddQueue = new LinkedList<>();

        // Step 1: Process the array and separate even and odd numbers into queues
        for (int num : arr) {
            if (num % 2 == 0) {
                evenQueue.offer(num);
            } else {
                oddQueue.offer(num);
            }
        }

        // Step 2: Reconstruct the array
        int index = 0;
        while (!evenQueue.isEmpty()) {
            arr[index++] = evenQueue.poll();
        }
        while (!oddQueue.isEmpty()) {
            arr[index++] = oddQueue.poll();
        }

        return arr;
    }
}
