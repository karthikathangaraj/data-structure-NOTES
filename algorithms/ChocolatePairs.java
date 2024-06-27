package algorithms;

import java.util.*;

public class ChocolatePairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of chocolates
        System.out.print("Enter the number of chocolates: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Read the array of chocolate lengths
        System.out.println("Enter the lengths of chocolates:");
        int[] chocolates = new int[n];
        for (int i = 0; i < n; i++) {
            chocolates[i] = scanner.nextInt();
        }
        scanner.close();

        // Map to count occurrences of each number of divisors
        Map<Integer, Integer> divisorCount = new HashMap<>();

        // Count the number of divisors for each chocolate length
        for (int length : chocolates) {
            int divisors = countDivisors(length);
            divisorCount.put(divisors, divisorCount.getOrDefault(divisors, 0) + 1);
        }

        // Calculate the number of ways to choose 2 chocolates with the same number of divisors
        long totalPairs = 0;
        for (int count : divisorCount.values()) {
            if (count > 1) {
                totalPairs += (long) count * (count - 1) / 2; // nC2 = n * (n - 1) / 2
            }
        }

        // Print the total number of ways
        System.out.println("Total number of ways to form pairs: " + totalPairs);
    }

    // Function to count divisors of a number
    private static int countDivisors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
