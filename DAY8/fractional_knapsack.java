package DAY8;

import java.util.Arrays;

// tags: Greedy,Classical,Easy

public class fractional_knapsack {
    double fractionalKnapsack(int W, Item arr[], int n) {
        double value[][] = new double[n][2];
        for (int i = 0; i < n; i++) {
            value[i][0] = 1.0 * arr[i].value / arr[i].weight;
            value[i][1] = arr[i].weight;
        }
        int i = 0;
        // don't foreget to use Double.compare
        Arrays.sort(value, (a, b) -> Double.compare(b[0], a[0]));
        double ans = 0.0;
        while (W > 0 && i < n) {
            ans += Math.min(W, value[i][1]) * value[i][0];
            W -= Math.min(W, value[i][1]);
            i++;
        }
        return ans;
    }
}

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}