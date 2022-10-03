package DAY6;

import java.util.*;

class detect_a_cycyle_list {
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

// ---------------------------------------------------------------------

class intersection_of_two_list {
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
}

// --------------------------------------------------------------------------

class linked_list_cycle_2 {
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

// ------------------------------------------------------------------------

class palindrome_linked_list {
    // globally declared
    // the idea is to reach out to end of the list using recursion and start
    // comparing by incrementing
    // trav and decremneting endNode
    ListNode trav;

    public boolean isPalindrome(ListNode head) {
        trav = head;
        return check(head);
    }

    public boolean check(ListNode cur) {
        if (cur.next == null) {
            return cur.val == trav.val;
        }
        if (!check(cur.next))
            return false;
        trav = trav.next;
        return trav.val == cur.val;
    }
}

// ------------------------------------------------------------------------------

class reverse_nodes_in_k_group {

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup1(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}

// --------------------------------------------------------------------------------------
