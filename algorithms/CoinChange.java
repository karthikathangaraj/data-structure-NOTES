package algorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Initialize dp array with amount+1, which is an impossible high value
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // Loop through each coin and update the dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still amount+1, it means the amount cannot be made up
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of coin denominations: ");
        int n = scanner.nextInt();
        int[] coins = new int[n];

        System.out.print("Enter the coin denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();

        int result = coinChange(coins, amount);
        if (result == -1) {
            System.out.println("It's not possible to make the amount with the given coins.");
        } else {
            System.out.println("The minimum number of coins needed: " + result);
        }
    }
}
