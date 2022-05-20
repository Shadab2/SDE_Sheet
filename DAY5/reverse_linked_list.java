package DAY5;

// tags : Implementation , LinkedList, Easy
public class reverse_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Approach #1 recusrive
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        // important to set head.next to null otherwise cycle at the orginal head of the
        // node
        head.next = null;
        return newHead;
    }

    // Approach #2 iterative
    public ListNode reverseListIterative(ListNode head) {
        ListNode cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
