package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthPermutation {
    public static String getPermutation(int n, int k) {
        // Create a list of numbers to get elements from
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Compute factorials
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        
        // Adjust k to be zero-based
        k--;
        
        // Build the k-th permutation
        StringBuilder result = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int idx = k / factorial[i - 1];
            k = k % factorial[i - 1];
            
            result.append(numbers.get(idx));
            numbers.remove(idx);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        String kthPermutation = getPermutation(n, k);
        System.out.println("The " + k + "-th permutation sequence is: " + kthPermutation);
    }
}