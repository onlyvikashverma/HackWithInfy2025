import java.util.*;
public class MinimumNumberOfCoins {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        sc.nextLine();
        String[] tokens = sc.nextLine().split(" ");
        int[] coins = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            coins[i] = Integer.parseInt(tokens[i]);
        }
        Arrays.sort(coins);
        int n = coins.length;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        System.out.println(count);

        sc.close();
    }
}