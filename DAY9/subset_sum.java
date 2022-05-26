package DAY9;

import java.util.*;

// tags: Subsets , Medium
public class subset_sum {

    // Approach #1 Iterative
    public static List<Integer> subsetSum1(int arr[]) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int x : arr) {
            int size = list.size();
            for (int i = 0; i < size; i++)
                list.add(list.get(i) + x);
        }
        return list;
    }

    // Approach #2 Iterative
    public static List<Integer> subsetSum2(int arr[]) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0)
                    sum += arr[j];
            }
            list.add(sum);
        }
        return list;
    }

    // Appraoch #3 recursive
    public static void subsetSum3(List<Integer> list, int arr[], int i, int sum) {
        if (i >= arr.length) {
            list.add(sum);
            return;
        }
        subsetSum3(list, arr, i + 1, sum + arr[i]);
        subsetSum3(list, arr, i + 1, sum);
    }

    // Appraoch #4 recursive
    public static void subsetSum4(List<Integer> list, int arr[], int start, int sum) {
        list.add(sum);
        for (int i = start; i < arr.length; i++) {
            sum += arr[i];
            subsetSum4(list, arr, i + 1, sum);
            sum -= arr[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        List<Integer> list = new ArrayList<>();
        subsetSum4(list, arr, 0, 0);
        System.out.println(subsetSum1(arr));
        System.out.println(subsetSum2(arr));
        System.out.println(list);
    }
}
