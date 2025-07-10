package HackWithInfy2025.DynamicPrograming;

import java.util.Scanner;

public class JumpGameDP {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            int maxReach = Math.min(i + nums[i], n - 1);
            for (int j = i + 1; j <= maxReach; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean result = canJump(nums);
        System.out.println("Can reach the end? " + result);
    }
}