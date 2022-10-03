package DAY5;

// tags : LinkedList, fast and slow , Medium
public class nth_node_from_end_of_list {

    // Approach #1 using two passes
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0, count = 1;
        ListNode trav = head;
        while (trav != null) {
            trav = trav.next;
            length++;
        }
        trav = head;
        if (length - n == 0)
            return head.next;
        while (trav != null) {
            if (length - count == n) {
                trav.next = trav.next.next;
                break;
            }
            trav = trav.next;
            count++;
        }
        return head;
    }

    // Approach #2 using a single pass
    // fast forwarding fast pointer n step after so that when it reached null , slow
    // is at nth node from last
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode newHead = new ListNode(0);
        ListNode slow = newHead, fast = newHead;
        newHead.next = head;
        while (n-- > 0)
            fast = fast.next;

        // when fast is null we slow would be at nth node from last
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
