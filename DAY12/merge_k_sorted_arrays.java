package DAY12;

import java.util.*;
// tags : Implementation , Greedy , Medium

// the idea is to pick the smallest element from kArrays and move its pointer to next element
// its a generalized version of merge two arrays , we need to use min heap to find the smallest element
// of the first k elements ans so on

public class merge_k_sorted_arrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < kArrays.size(); i++) {
            pq.add(new Tuple(kArrays.get(i).get(0), i, 0));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();
            ArrayList<Integer> list = kArrays.get(cur.arrayNum);
            if (list.size() > cur.index + 1) {
                pq.add(new Tuple(list.get(cur.index + 1), cur.arrayNum, cur.index + 1));
            }
            ans.add(cur.value);
        }
        return ans;
    }

    static class Tuple implements Comparable<Tuple> {
        int value, arrayNum;
        int index;

        public Tuple(int value, int arrayNum, int index) {
            this.value = value;
            this.arrayNum = arrayNum;
            this.index = index;
        }

        public int compareTo(Tuple that) {
            return this.value - that.value;
        }
    }
}
