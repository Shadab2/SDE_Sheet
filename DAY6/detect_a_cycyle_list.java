package DAY6;

// tags: fastAndSlow Pointer, Easy
public class detect_a_cycyle_list {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head;

        slow = slow.next;
        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}