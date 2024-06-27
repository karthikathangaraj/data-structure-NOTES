package algorithms;

import java.util.Scanner;

public class MinInsertionsPalindrome {

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Function to find the minimum number of insertions required
    public static int minInsertionsToPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the dp table in bottom-up manner
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        // Length of longest palindromic subsequence
        int lpsLength = dp[0][n - 1];

        // Minimum insertions needed
        return n - lpsLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = scanner.nextLine();
        
        if (isPalindrome(str)) {
            System.out.println("The string is already a palindrome.");
        } else {
            int result = minInsertionsToPalindrome(str);
            System.out.println("Minimum number of insertions required to make the string a palindrome: " + result);
        }
        
        scanner.close();
    }
}
