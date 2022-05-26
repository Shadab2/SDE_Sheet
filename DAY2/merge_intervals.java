package DAY2;

import java.util.*;

public class merge_intervals {

    public int[][] merge(int[][] interval) {
        // we need to sort the interval aq to start time in order to always select
        // intervals with smaller start time
        // so that any interval whose starting time is greater than this interval would
        // be merged
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] cur = { interval[0][0], interval[0][1] };
        list.add(cur);

        for (int[] now : interval) {
            // merge
            if (now[0] <= cur[1])
                cur[1] = Math.max(cur[1], now[1]);
            else {
                cur = now;
                list.add(cur);
            }

        }
        // important to specify the size in list.toArray() so to avoid Object cannot to
        // converted to int[]
        return list.toArray(new int[list.size()][2]);
    }
}
