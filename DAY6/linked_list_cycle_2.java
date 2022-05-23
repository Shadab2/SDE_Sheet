package DAY6;

import java.util.*;

public class linked_list_cycle_2 {
    // Approach #1 using set and java only class names
    public ListNode detectCycle(ListNode head) {
        Set<String> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head.toString()))
                return head;
            set.add(head.toString());
            head = head.next;
        }
        return null;
    }

    // Approach #2 using floydd warshall fast and slow
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
};
