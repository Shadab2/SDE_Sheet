package DAY12;

import java.util.*;

// tags : Implementation 
public class top_k_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        int ans[] = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = list.get(i).getKey();
        return ans;
    }
}
