package DAY12;

import java.util.*;;

public class find_median_from_data_stream {
    // the idea is to always maintain either n/2 or (n/2)+1 element on left max pq
    // and n/2 in right min pq
    // then choose appropriately median according the size being odd or even
    private PriorityQueue<Integer> left, right;
    boolean odd;

    public find_median_from_data_stream() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek())
            left.offer(num);
        else if (num >= left.peek())
            right.add(num);

        if (right.size() - left.size() >= 1) {
            left.add(right.poll());
        }
        if (left.size() - right.size() > 1) {
            right.add(left.poll());
        }
        odd = !odd;
    }

    public double findMedian() {
        if (odd)
            return left.peek();
        return (left.peek() + right.peek()) / 2.0;
    }
}
