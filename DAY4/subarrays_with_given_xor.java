package DAY4;

// tags: Implementation , Medium
import java.util.*;

public class subarrays_with_given_xor {
    // just like finding total subarray with given sum B
    public int solve(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int count = 0;
        // always put intitial contiditon to test for edge case as first n elements can
        // have xor B
        map.put(xor, 1);
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
            if (map.containsKey(xor ^ B))
                count += map.get(xor ^ B);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
