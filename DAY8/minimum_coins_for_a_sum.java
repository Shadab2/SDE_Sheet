package DAY8;

public class minimum_coins_for_a_sum {
    public static int findMinimumCoins(int amount) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int i = 8, cns = 0;
        while (amount > 0) {
            if (amount >= coins[i]) {
                cns += (amount / coins[i]);
                amount = amount % coins[i];
            } else
                i--;
        }
        return cns;
    }
}
