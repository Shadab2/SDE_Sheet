package DAY8;

import java.util.*;

// tags : Greedy , Medium
public class minmum_platforms {

    // platforms can only increase if we have a train whose arrival is earlier than
    // the departure of the train using the platform
    // we will maintain priority queue using the departure so to free the platform
    // as early as possible
    static int findPlatform(int arr[], int dep[], int n) {
        List<Train> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Train(arr[i], dep[i]));
        Collections.sort(list, (a, b) -> a.arrival - b.arrival);
        PriorityQueue<Train> pq = new PriorityQueue<>((a, b) -> a.departure - b.departure);
        pq.add(list.get(0));

        int platforms = 1;
        for (int i = 1; i < n; i++) {
            Train next = list.get(i);
            if (pq.peek().departure < next.arrival)
                pq.poll();
            pq.add(next);
            platforms = Math.max(platforms, pq.size());
        }
        return platforms;

    }

    static class Train {
        int arrival, departure;

        public Train(int arr, int dep) {
            arrival = arr;
            departure = dep;
        }
    }
}
