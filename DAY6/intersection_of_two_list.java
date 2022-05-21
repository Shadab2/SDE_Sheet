package DAY6;

// Approach #1 
// finish one list and switch over another list 
public class intersection_of_two_list {

    // hefty implementation
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode trav1 = headA, trav2 = headB;
        while (trav1 != null && trav2 != null) {
            if (trav1.equals(trav2))
                return trav1;
            trav1 = trav1.next;
            trav2 = trav2.next;
        }
        if (trav1 == null)
            trav1 = headB;
        if (trav2 == null)
            trav2 = headA;
        while (trav1 != null && trav2 != null) {
            if (trav1.equals(trav2))
                return trav1;
            trav1 = trav1.next;
            trav2 = trav2.next;
        }
        if (trav1 == null)
            trav1 = headB;
        if (trav2 == null)
            trav2 = headA;
        while (trav1 != null && trav2 != null) {
            if (trav1.equals(trav2))
                return trav1;
            trav1 = trav1.next;
            trav2 = trav2.next;
        }
        return null;

    }

    // concice implementation
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (null == headA || null == headB)
            return null;

        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
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

}
