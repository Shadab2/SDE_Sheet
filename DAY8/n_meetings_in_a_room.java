package DAY8;

import java.util.Arrays;

// tags: Greedy , Easy 
public class n_meetings_in_a_room {
    public static int maxMeetings(int start[], int end[], int n) {
        int intervals[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = start[i];
            intervals[i][1] = end[i];
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int meetings = 1;
        int endTime = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > endTime) {
                meetings++;
                endTime = intervals[i][1];
            }
        }
        return meetings++;

    }
}
