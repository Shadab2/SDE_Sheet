package DAY4;

import java.util.*;

// tags : Implmentation , Medium
public class largest_subarray_with_zero_sum {
    int maxLen(int arr[], int n) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        // start with -1 , so to get 1 based length
        // also put 0 to handle case when the length of the subarray of size n resuls in
        // zero sum
        map.put(0, -1);
        int sum = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum))
                maxLength = Math.max(i - map.get(sum), maxLength);
            map.putIfAbsent(sum, i);
        }
        return maxLength;

    }
}
