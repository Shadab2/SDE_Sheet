package DAY7;

public class rotateList {
    // implementation based
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode trav = head;
        while (trav != null) {
            trav = trav.next;
            len++;
        }
        if (head == null || head.next == null || k % len == 0)
            return head;
        k %= len;
        trav = head;
        for (int i = 1; i < (len - k); i++)
            trav = trav.next;
        ListNode newHead = trav.next;
        trav.next = null;
        trav = newHead;
        while (trav.next != null)
            trav = trav.next;
        trav.next = head;
        return newHead;
    }
}

class ListNode {
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
