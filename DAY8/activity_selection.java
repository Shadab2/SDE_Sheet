package DAY8;

import java.util.*;

public class activity_selection {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        int n = start.size();
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start.get(i);
            arr[i][1] = end.get(i);
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int e = arr[0][1];
        int activity = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= e) {
                activity++;
                e = arr[i][1];
            }
        }
        return activity;
    }
}
